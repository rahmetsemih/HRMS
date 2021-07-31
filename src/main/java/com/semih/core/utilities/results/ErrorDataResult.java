package com.semih.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult( String message, T data) {
        super(false, message, data);

    }
    public ErrorDataResult(T data) {
        super(false,data);
    }
    public ErrorDataResult() {
        super(false);
    }

}