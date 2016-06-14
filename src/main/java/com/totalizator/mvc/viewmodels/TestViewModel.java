package com.totalizator.mvc.viewmodels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by home on 13.06.16.
 */

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
