package com.semih.core.utilities.results;

import lombok.Data;

@Data

public class Result {
    public Result(boolean success) {
        this.success = success;
    }

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public Result() {
    }

    public Result(String message) {
        this.message = message;

    }

    private String message;

    private boolean success;
}
