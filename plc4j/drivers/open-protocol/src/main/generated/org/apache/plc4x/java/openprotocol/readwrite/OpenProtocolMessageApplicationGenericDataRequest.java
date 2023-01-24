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
package org.apache.plc4x.java.openprotocol.readwrite;

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

public class OpenProtocolMessageApplicationGenericDataRequest extends OpenProtocolMessage
    implements Message {

  // Accessors for discriminator values.
  public Mid getMid() {
    return Mid.ApplicationGenericDataRequest;
  }

  // Properties.
  protected final Mid requestMid;
  protected final OpenProtocolRevision wantedRevision;
  protected final byte[] extraData;

  public OpenProtocolMessageApplicationGenericDataRequest(
      OpenProtocolRevision revision,
      short noAckFlag,
      int stationId,
      int spindleId,
      int sequenceNumber,
      short numberOfMessageParts,
      short messagePartNumber,
      Mid requestMid,
      OpenProtocolRevision wantedRevision,
      byte[] extraData) {
    super(
        revision,
        noAckFlag,
        stationId,
        spindleId,
        sequenceNumber,
        numberOfMessageParts,
        messagePartNumber);
    this.requestMid = requestMid;
    this.wantedRevision = wantedRevision;
    this.extraData = extraData;
  }

  public Mid getRequestMid() {
    return requestMid;
  }

  public OpenProtocolRevision getWantedRevision() {
    return wantedRevision;
  }

  public byte[] getExtraData() {
    return extraData;
  }

  @Override
  protected void serializeOpenProtocolMessageChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("OpenProtocolMessageApplicationGenericDataRequest");

    // Simple Field (requestMid)
    writeSimpleEnumField(
        "requestMid",
        "Mid",
        requestMid,
        new DataWriterEnumDefault<>(Mid::getValue, Mid::name, writeUnsignedLong(writeBuffer, 32)));

    // Simple Field (wantedRevision)
    writeSimpleEnumField(
        "wantedRevision",
        "OpenProtocolRevision",
        wantedRevision,
        new DataWriterEnumDefault<>(
            OpenProtocolRevision::getValue,
            OpenProtocolRevision::name,
            writeUnsignedLong(writeBuffer, 24)));

    // Implicit Field (extraDataLength) (Used for parsing, but its value is not stored as it's
    // implicitly given by the objects content)
    int extraDataLength = (int) (COUNT(getExtraData()));
    writeImplicitField("extraDataLength", extraDataLength, writeUnsignedInt(writeBuffer, 16));

    // Array Field (extraData)
    writeByteArrayField("extraData", extraData, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("OpenProtocolMessageApplicationGenericDataRequest");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    OpenProtocolMessageApplicationGenericDataRequest _value = this;

    // Simple field (requestMid)
    lengthInBits += 32;

    // Simple field (wantedRevision)
    lengthInBits += 24;

    // Implicit Field (extraDataLength)
    lengthInBits += 16;

    // Array field
    if (extraData != null) {
      lengthInBits += 8 * extraData.length;
    }

    return lengthInBits;
  }

  public static OpenProtocolMessageApplicationGenericDataRequestBuilder staticParseBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("OpenProtocolMessageApplicationGenericDataRequest");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    Mid requestMid =
        readEnumField(
            "requestMid",
            "Mid",
            new DataReaderEnumDefault<>(Mid::enumForValue, readUnsignedLong(readBuffer, 32)));

    OpenProtocolRevision wantedRevision =
        readEnumField(
            "wantedRevision",
            "OpenProtocolRevision",
            new DataReaderEnumDefault<>(
                OpenProtocolRevision::enumForValue, readUnsignedLong(readBuffer, 24)));

    int extraDataLength = readImplicitField("extraDataLength", readUnsignedInt(readBuffer, 16));

    byte[] extraData = readBuffer.readByteArray("extraData", Math.toIntExact(extraDataLength));

    readBuffer.closeContext("OpenProtocolMessageApplicationGenericDataRequest");
    // Create the instance
    return new OpenProtocolMessageApplicationGenericDataRequestBuilder(
        requestMid, wantedRevision, extraData);
  }

  public static class OpenProtocolMessageApplicationGenericDataRequestBuilder
      implements OpenProtocolMessage.OpenProtocolMessageBuilder {
    private final Mid requestMid;
    private final OpenProtocolRevision wantedRevision;
    private final byte[] extraData;

    public OpenProtocolMessageApplicationGenericDataRequestBuilder(
        Mid requestMid, OpenProtocolRevision wantedRevision, byte[] extraData) {

      this.requestMid = requestMid;
      this.wantedRevision = wantedRevision;
      this.extraData = extraData;
    }

    public OpenProtocolMessageApplicationGenericDataRequest build(
        OpenProtocolRevision revision,
        short noAckFlag,
        int stationId,
        int spindleId,
        int sequenceNumber,
        short numberOfMessageParts,
        short messagePartNumber) {
      OpenProtocolMessageApplicationGenericDataRequest
          openProtocolMessageApplicationGenericDataRequest =
              new OpenProtocolMessageApplicationGenericDataRequest(
                  revision,
                  noAckFlag,
                  stationId,
                  spindleId,
                  sequenceNumber,
                  numberOfMessageParts,
                  messagePartNumber,
                  requestMid,
                  wantedRevision,
                  extraData);
      return openProtocolMessageApplicationGenericDataRequest;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OpenProtocolMessageApplicationGenericDataRequest)) {
      return false;
    }
    OpenProtocolMessageApplicationGenericDataRequest that =
        (OpenProtocolMessageApplicationGenericDataRequest) o;
    return (getRequestMid() == that.getRequestMid())
        && (getWantedRevision() == that.getWantedRevision())
        && (getExtraData() == that.getExtraData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getRequestMid(), getWantedRevision(), getExtraData());
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