/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.mosuka.solr.prometheus.scraper.config;

import java.util.*;

public class Query {
    private String collection = "";
    private String path = "";
    private List<LinkedHashMap<String, String>> params = new ArrayList<>();

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<LinkedHashMap<String, String>> getParams() {
        return params;
    }

    public void setParams(List<LinkedHashMap<String, String>> params) {
        this.params = params;
    }

    public String getParamsString() {
        StringBuffer buffer = new StringBuffer();

        for(Iterator<LinkedHashMap<String, String>> i = getParams().iterator(); i.hasNext(); ) {
            LinkedHashMap<String, String> param = i.next();
            for(Iterator<String> j = param.keySet().iterator(); j.hasNext(); ) {
                String name = j.next();
                buffer.append(name).append("=").append(param.get(name));
                if (j.hasNext()) {
                    buffer.append("&");
                }
            }
            if (i.hasNext()) {
                buffer.append("&");
            }
        }

        return buffer.toString();
    }
}
