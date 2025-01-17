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
package org.apache.plc4x.java.cbus.readwrite;

import static org.apache.plc4x.java.spi.codegen.fields.FieldReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.fields.FieldWriterFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataWriterFactory.*;
import static org.apache.plc4x.java.spi.generation.StaticHelper.*;

import java.time.*;
import java.util.*;
import org.apache.plc4x.java.api.exceptions.*;
import org.apache.plc4x.java.api.value.*;
import org.apache.plc4x.java.spi.codegen.*;
import org.apache.plc4x.java.spi.codegen.fields.*;
import org.apache.plc4x.java.spi.codegen.io.*;
import org.apache.plc4x.java.spi.generation.*;

// Code generated by code-generation. DO NOT EDIT.

public class ParameterChangeReply extends Reply implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final ParameterChange parameterChange;

  // Arguments.
  protected final CBusOptions cBusOptions;
  protected final RequestContext requestContext;

  public ParameterChangeReply(
      byte peekedByte,
      ParameterChange parameterChange,
      CBusOptions cBusOptions,
      RequestContext requestContext) {
    super(peekedByte, cBusOptions, requestContext);
    this.parameterChange = parameterChange;
    this.cBusOptions = cBusOptions;
    this.requestContext = requestContext;
  }

  public ParameterChange getParameterChange() {
    return parameterChange;
  }

  @Override
  protected void serializeReplyChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ParameterChangeReply");

    // Simple Field (parameterChange)
    writeSimpleField(
        "parameterChange", parameterChange, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("ParameterChangeReply");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    ParameterChangeReply _value = this;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();

    // Simple field (parameterChange)
    lengthInBits += parameterChange.getLengthInBits();

    return lengthInBits;
  }

  public static ReplyBuilder staticParseReplyBuilder(
      ReadBuffer readBuffer, CBusOptions cBusOptions, RequestContext requestContext)
      throws ParseException {
    readBuffer.pullContext("ParameterChangeReply");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;
    boolean _lastItem = ThreadLocalHelper.lastItemThreadLocal.get();

    ParameterChange parameterChange =
        readSimpleField(
            "parameterChange",
            new DataReaderComplexDefault<>(
                () -> ParameterChange.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("ParameterChangeReply");
    // Create the instance
    return new ParameterChangeReplyBuilderImpl(parameterChange, cBusOptions, requestContext);
  }

  public static class ParameterChangeReplyBuilderImpl implements Reply.ReplyBuilder {
    private final ParameterChange parameterChange;
    private final CBusOptions cBusOptions;
    private final RequestContext requestContext;

    public ParameterChangeReplyBuilderImpl(
        ParameterChange parameterChange, CBusOptions cBusOptions, RequestContext requestContext) {
      this.parameterChange = parameterChange;
      this.cBusOptions = cBusOptions;
      this.requestContext = requestContext;
    }

    public ParameterChangeReply build(
        byte peekedByte, CBusOptions cBusOptions, RequestContext requestContext) {
      ParameterChangeReply parameterChangeReply =
          new ParameterChangeReply(peekedByte, parameterChange, cBusOptions, requestContext);
      return parameterChangeReply;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ParameterChangeReply)) {
      return false;
    }
    ParameterChangeReply that = (ParameterChangeReply) o;
    return (getParameterChange() == that.getParameterChange()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getParameterChange());
  }

  @Override
  public String toString() {
    WriteBufferBoxBased writeBufferBoxBased = new WriteBufferBoxBased(true, true);
    try {
      writeBufferBoxBased.writeSerializable(this);
    } catch (SerializationException e) {
      throw new RuntimeException(e);
    }
    return "\n" + writeBufferBoxBased.getBox().toString() + "\n";
  }
}
