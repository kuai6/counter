package com.kuai6.counter.repository;

public class IncreaseException extends RuntimeException {
    public IncreaseException(Throwable e) {
        initCause(e);
    }

    public IncreaseException(String msg) {
        super(msg);
    }
}
