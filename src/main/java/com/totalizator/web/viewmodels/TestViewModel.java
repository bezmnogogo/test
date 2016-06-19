package com.totalizator.web.viewmodels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect
public class TestViewModel {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
