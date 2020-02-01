package com.peige.work.spring.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
//json多一个字段少一个字段都可以解析
public class Quote {

    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "value")
    private Value value;

    public Quote(String type, Value value) {
        this.type = type;
        this.value = value;
    }

    public String getT() {
        return type;
    }

    public void setT(String t) {
        this.type = t;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
