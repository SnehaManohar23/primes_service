package com.example.primesservice.controller;

import com.example.primesservice.rabbitmq.MQSender;
import com.example.primesservice.service.iPrimesService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {
    iPrimesService primesService;
    private final MQSender mqSender;
    public PrimesController(iPrimesService primesService, MQSender mqSender)
    {
        this.primesService=primesService;
        this.mqSender=mqSender;
    }
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        boolean result=primesService.isPrime(n);
        mqSender.sendMessage(n,result);
        return result;
    }
}
