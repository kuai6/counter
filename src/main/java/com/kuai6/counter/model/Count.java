package com.kuai6.counter.model;

import com.kuai6.counter.ValueAwareInterface;

public class Count implements ValueAwareInterface {
    private final long value;

    public Count(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
