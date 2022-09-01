package com.familytree.result;

public class DataSuccess implements DataResult{
    private String message;
    private String value;
    public DataSuccess(String message,String value) {
        this.message = message;
        this.value = value;
    }

    public DataSuccess(String message) {
        this.message = message;
    }


    @Override
    public String message() {
        return this.message;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
