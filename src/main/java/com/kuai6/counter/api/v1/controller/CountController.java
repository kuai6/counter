package com.kuai6.counter.api.v1.controller;

import com.kuai6.counter.CountingServiceInterface;
import com.kuai6.counter.api.v1.dto.CountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CountController {

    @Autowired
    protected CountingServiceInterface countingService;

    @GetMapping("/")
    public CountDTO get() {
        long value = countingService.increase();
        return new CountDTO(value);
    }
}
