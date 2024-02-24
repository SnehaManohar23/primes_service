package com.example.primesservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesServiceTest {
    PrimesService primeService=new PrimesService();

    @Test
    void _45IsNotPrime() {
        int n=45;
        boolean expected=false;
        boolean actual=primeService.isPrime(n);
        assertEquals(expected, actual);
    }
    @Test
    void _285191IsPrime() {
        int n=285191;
        boolean expected=true;
        boolean actual=primeService.isPrime(n);
        assertEquals(expected, actual);
    }
}