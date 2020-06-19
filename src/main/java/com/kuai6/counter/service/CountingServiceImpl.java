package com.kuai6.counter.service;

import com.kuai6.counter.CountingServiceInterface;
import com.kuai6.counter.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountingServiceImpl implements CountingServiceInterface {

    @Autowired
    private RepositoryInterface repository;

    public long increase() {
        return repository.increase().getValue();
    }
}
