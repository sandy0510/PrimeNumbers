package com.icap.primenumber.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Sandeepreddy on 21/04/2016.
 */
public class PrimeNumberProcessorTest {

    PrimeNumberProcessor primeNumberProcessor;

    @Before
    public void setUp() {
        primeNumberProcessor = new PrimeNumberProcessor();
    }

    @Test
    public void getPrimeNumbers_success() throws Exception {
        int[] actual = primeNumberProcessor.getPrimeNumbers(10);
        assertEquals(4, actual.length);
        assertEquals(2, actual[0]);
        assertEquals(3, actual[1]);
        assertEquals(5, actual[2]);
        assertEquals(7, actual[3]);
    }

    @Test
    public void getPrimeNumbersUsingMillerRabinTest_success() throws Exception {
        int[] actual = primeNumberProcessor.getPrimeNumbersUsingMillerRabinTest(10);
        assertEquals(4, actual.length);
        assertEquals(2, actual[0]);
        assertEquals(3, actual[1]);
        assertEquals(5, actual[2]);
        assertEquals(7, actual[3]);
    }

    @Test
    public void getPrimeNumbers_for1_success() throws Exception {
        int[] actual = primeNumberProcessor.getPrimeNumbers(1);
        assertEquals(1, actual.length);
        assertEquals(1, actual[0]);
    }

    @Test
    public void getPrimeNumbers_for2_success() throws Exception {
        int[] actual = primeNumberProcessor.getPrimeNumbers(2);
        assertEquals(1, actual.length);
        assertEquals(2, actual[0]);
    }

    @Test
    public void fn_checkIfNumberIsPrimeNormalScenario_lessthan1000_test_success() {
        boolean actual = primeNumberProcessor.checkIfNumberIsPrimeNormalScenario.apply(3);
        assertEquals(true, actual);
    }

    @Test
    public void fn_checkIfNumberIsPrimeNormalScenario_lessthan1000_notprime_test_success() {
        boolean actual = primeNumberProcessor.checkIfNumberIsPrimeNormalScenario.apply(4);
        assertEquals(false, actual);
    }

    @Test
    public void fn_checkIfNumberIsPrimeNormalScenario_morethan1000_notprime_test_success() {
        boolean actual = primeNumberProcessor.checkIfNumberIsPrimeNormalScenario.apply(1100);
        assertEquals(false, actual);
    }

    @Test
    public void fn_checkIfNumberIsPrimeNormalScenario_morethan1000_test_success() {
        boolean actual = primeNumberProcessor.checkIfNumberIsPrimeNormalScenario.apply(1297);
        assertEquals(true, actual);
    }

}