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

package readwrite

import (
	"context"
	"strconv"
	"strings"

	"github.com/apache/plc4x/plc4go/protocols/eip/readwrite/model"
	"github.com/apache/plc4x/plc4go/spi/utils"
	"github.com/pkg/errors"
)

// Code generated by code-generation. DO NOT EDIT.

type EipXmlParserHelper struct {
}

// Temporary imports to silent compiler warnings (TODO: migrate from static to emission based imports)
func init() {
	_ = strconv.ParseUint
	_ = strconv.ParseInt
	_ = strings.Join
	_ = utils.Dump
}

func (m EipXmlParserHelper) Parse(typeName string, xmlString string, parserArguments ...string) (interface{}, error) {
	switch typeName {
	case "PathSegment":
		return model.PathSegmentParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "TransportType":
		return model.TransportTypeParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "PortSegmentType":
		return model.PortSegmentTypeParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "NetworkConnectionParameters":
		return model.NetworkConnectionParametersParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "TypeId":
		return model.TypeIdParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "InstanceSegment":
		return model.InstanceSegmentParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "CIPData":
		parsedUint0, err := strconv.ParseUint(parserArguments[0], 10, 16)
		if err != nil {
			return nil, err
		}
		packetLength := uint16(parsedUint0)
		return model.CIPDataParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)), packetLength)
	case "ClassSegment":
		return model.ClassSegmentParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "EipPacket":
		response := parserArguments[0] == "true"
		return model.EipPacketParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)), response)
	case "CIPAttributes":
		parsedUint0, err := strconv.ParseUint(parserArguments[0], 10, 16)
		if err != nil {
			return nil, err
		}
		packetLength := uint16(parsedUint0)
		return model.CIPAttributesParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)), packetLength)
	case "CipService":
		connected := parserArguments[0] == "true"
		parsedUint1, err := strconv.ParseUint(parserArguments[1], 10, 16)
		if err != nil {
			return nil, err
		}
		serviceLen := uint16(parsedUint1)
		return model.CipServiceParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)), connected, serviceLen)
	case "Services":
		parsedUint0, err := strconv.ParseUint(parserArguments[0], 10, 16)
		if err != nil {
			return nil, err
		}
		servicesLen := uint16(parsedUint0)
		return model.ServicesParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)), servicesLen)
	case "LogicalSegmentType":
		return model.LogicalSegmentTypeParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "DataSegmentType":
		return model.DataSegmentTypeParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	case "CIPDataConnected":
		return model.CIPDataConnectedParseWithBuffer(context.Background(), utils.NewXmlReadBuffer(strings.NewReader(xmlString)))
	}
	return nil, errors.Errorf("Unsupported type %s", typeName)
}
