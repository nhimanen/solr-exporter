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

import java.util.ArrayList;
import java.util.List;

public class ScrapeConfig implements Cloneable {
    private Query query = new Query();

    private List<String> jsonQueries = new ArrayList<>();

    public Query getQuery() {
        return this.query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public List<String> getJsonQueries() {
        return jsonQueries;
    }

    public void setJsonQueries(List<String> jsonQueries) {
        this.jsonQueries = jsonQueries;
    }

    public ScrapeConfig clone() throws CloneNotSupportedException {
        ScrapeConfig scrapeConfig = null;

        try {
            scrapeConfig = (ScrapeConfig) super.clone();
            scrapeConfig.query = (Query) this.query.clone();
            scrapeConfig.jsonQueries = new ArrayList<>(this.jsonQueries);
        }catch (Exception e){
            e.printStackTrace();
        }

        return scrapeConfig;
    }
}