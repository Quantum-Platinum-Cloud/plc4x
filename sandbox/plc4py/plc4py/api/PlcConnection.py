#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
from abc import abstractmethod

from plc4py.api.messages.PlcRequest import ReadRequestBuilder
from plc4py.api.exceptions.exceptions import PlcConnectionException
from plc4py.utils.GenericTypes import GenericGenerator


class PlcConnection(GenericGenerator):
    def __init__(self, url: str):
        self.url = url

    @abstractmethod
    def connect(self) -> None:
        """
        Establishes the connection to the remote PLC.
        """
        raise PlcConnectionException

    @abstractmethod
    def is_connected(self) -> bool:
        """
        Indicates if the connection is established to a remote PLC.
        :return: True if connection, False otherwise
        """
        pass

    @abstractmethod
    def close(self) -> None:
        """
        Closes the connection to the remote PLC.
        :return:
        """
        pass

    @abstractmethod
    def read_request_builder(self) -> ReadRequestBuilder:
        """
        :return: read request builder.
        """
        pass