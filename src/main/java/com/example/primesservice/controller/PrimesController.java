package com.example.primesservice.controller;

import com.example.primesservice.service.iPrimesService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {
    iPrimesService primesService;
    public PrimesController(iPrimesService primesService)
    {
        this.primesService=primesService;
    }
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        return primesService.isPrime(n);
    }
}
