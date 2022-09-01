package com.familytree.result;

public class DataError implements DataResult{
    private String message;
    public DataError(String message) {
        this.message = message;
    }


    @Override
    public String message() {
        return this.message;
    }

    @Override
    public String getValue() {
        return null;
    }
}
