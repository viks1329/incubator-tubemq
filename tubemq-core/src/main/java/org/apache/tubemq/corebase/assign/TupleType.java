/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tubemq.corebase.assign;

public enum TupleType {
    TUPLE_VALUE_TYPE_ALL_OFFSET(0, "TUPLE_VALUE_TYPE_ALL_OFFSET",
            "Range-tuple value are all offset"),
    TUPLE_VALUE_TYPE_ALL_TIME(1, "TUPLE_VALUE_TYPE_ALL_TIME",
            "Range-tuple value are all message append time."),
    TUPLE_VALUE_TYPE_LOFFSET_RTIME(2, "TUPLE_VALUE_TYPE_LOFFSET_RTIME",
                                    "Range-tuple left value left is offset, right is time."),
    TUPLE_VALUE_TYPE_LTIME_ROFFSET(3, "TUPLE_VALUE_TYPE_LTIME_ROFFSET",
                                  "Range-tuple left value is time, right is offset.");

    private int code;
    private String token;
    private String description;

    TupleType(int code, String token, String description) {
        this.code = code;
        this.token = token;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getToken() {
        return token;
    }

    public String getDescription() {
        return description;
    }

    public static TupleType valueOf(int code) {
        for (TupleType valueType : TupleType.values()) {
            if (valueType.getCode() == code) {
                return valueType;
            }
        }
        throw new IllegalArgumentException(String.format("unknown TupleType code %s", code));
    }
}