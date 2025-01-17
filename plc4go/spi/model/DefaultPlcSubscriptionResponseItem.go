/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package model

import (
	"context"
	"encoding/binary"
	"fmt"

	"github.com/apache/plc4x/plc4go/pkg/api/model"
	"github.com/apache/plc4x/plc4go/spi/utils"
)

type DefaultPlcSubscriptionResponseItem struct {
	code               model.PlcResponseCode
	subscriptionHandle model.PlcSubscriptionHandle
}

func NewSubscriptionResponseItem(code model.PlcResponseCode, subscriptionHandle model.PlcSubscriptionHandle) *DefaultPlcSubscriptionResponseItem {
	return &DefaultPlcSubscriptionResponseItem{
		code:               code,
		subscriptionHandle: subscriptionHandle,
	}
}

func (r *DefaultPlcSubscriptionResponseItem) GetCode() model.PlcResponseCode {
	return r.code
}

func (r *DefaultPlcSubscriptionResponseItem) GetSubscriptionHandle() model.PlcSubscriptionHandle {
	return r.subscriptionHandle
}

func (d *DefaultPlcSubscriptionResponseItem) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithByteOrderForByteBasedBuffer(binary.BigEndian))
	if err := d.SerializeWithWriteBuffer(context.Background(), wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (d *DefaultPlcSubscriptionResponseItem) SerializeWithWriteBuffer(ctx context.Context, writeBuffer utils.WriteBuffer) error {
	if err := writeBuffer.PushContext("PlcSubscriptionResponseItem"); err != nil {
		return err
	}

	{
		stringValue := fmt.Sprintf("%v", d.code)
		if err := writeBuffer.WriteString("code", uint32(len(stringValue)*8), "UTF-8", stringValue); err != nil {
			return err
		}
	}

	if d.subscriptionHandle != nil {
		if serializableField, ok := d.subscriptionHandle.(utils.Serializable); ok {
			if err := writeBuffer.PushContext("subscriptionHandle"); err != nil {
				return err
			}
			if err := serializableField.SerializeWithWriteBuffer(ctx, writeBuffer); err != nil {
				return err
			}
			if err := writeBuffer.PopContext("subscriptionHandle"); err != nil {
				return err
			}
		} else {
			stringValue := fmt.Sprintf("%v", d.subscriptionHandle)
			if err := writeBuffer.WriteString("subscriptionHandle", uint32(len(stringValue)*8), "UTF-8", stringValue); err != nil {
				return err
			}
		}
	}
	if err := writeBuffer.PopContext("PlcSubscriptionResponseItem"); err != nil {
		return err
	}
	return nil
}

func (d *DefaultPlcSubscriptionResponseItem) String() string {
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(context.Background(), d); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
