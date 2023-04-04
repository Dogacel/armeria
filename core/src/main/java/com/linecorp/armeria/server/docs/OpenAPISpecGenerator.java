/*
 * Copyright 2022 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.armeria.server.docs;

import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.collect.ImmutableSet.toImmutableSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;

import com.linecorp.armeria.common.annotation.Nullable;
import com.linecorp.armeria.internal.common.JacksonUtil;

/**
 * Generates an OpenAPI specification json file from the given service specification.
 *
 * @see <a href="https://json-schema.org/">JSON schema</a>
 */
final class OpenAPISpecGenerator {

    private static interface GenerationStrategy {
        ObjectNode generate(ServiceSpecification serviceSpecification);
    }

    private static final class OpenAPI2_0Strategy implements GenerationStrategy {
        // swagger: 2.0
        // definitions

        @Override
        public ObjectNode generate(ServiceSpecification serviceSpecification) {
            return null;
        }
    }

    private static final class OpenAPI3_0Strategy implements GenerationStrategy {
        // openapi: 3.0
        // components

        @Override
        public ObjectNode generate(ServiceSpecification serviceSpecification) {
            return null;
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(OpenAPISpecGenerator.class);

    private static final ObjectMapper mapper = JacksonUtil.newDefaultObjectMapper();

    static ObjectNode generate(ServiceSpecification serviceSpecification) {
        final OpenAPISpecGenerator generator = new OpenAPISpecGenerator();
        return generator.generateJSONSpecification(serviceSpecification);
    }

    private ObjectNode generateJSONSpecification(ServiceSpecification serviceSpecification) {
        final ObjectNode root = mapper.createObjectNode();
        root.put("openapi", "3.1.0");

        // root.put("info", ...);
        // root.put("servers", ...);
        // root.put("components", ...);
        // root.put("paths", ...);

        return root;
    }

}
