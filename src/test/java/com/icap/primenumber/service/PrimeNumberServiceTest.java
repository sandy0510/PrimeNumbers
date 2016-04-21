package com.icap.primenumber.service;

import org.assertj.core.api.exception.RuntimeIOException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PrimeNumberServiceTest {

    @Mock
    PrimeNumberProcessor primeNumberProcessor;
    @InjectMocks
    PrimeNumberService service;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void getPrimeNumbersSuccessTest(){
        int[] expected = new int[]{2,3};
        when(primeNumberProcessor.getPrimeNumbers(anyInt())).thenReturn(expected);

        int[] actual = service.getPrimeNumbers(100);
        assertEquals(expected[0],actual[0]);
        assertEquals(expected[1],actual[1]);
    }

    @Test
    public void getPrimeNumbers_checkCall_to_MillerRobin_SuccessTest(){
        int[] expected = new int[]{2,3};
        when(primeNumberProcessor.getPrimeNumbersUsingMillerRabinTest(anyInt())).thenReturn(expected);
        int[] actual = service.getPrimeNumbers(20000);

        verify(primeNumberProcessor,times(1)).getPrimeNumbersUsingMillerRabinTest(eq(20000));
        assertEquals(expected[0],actual[0]);
        assertEquals(expected[1],actual[1]);
    }

    @Test(expected = RuntimeException.class)
    public void getPrimeNumbersExceptionTest(){
        when(primeNumberProcessor.getPrimeNumbers(anyInt())).thenThrow(new RuntimeException("Some problem..."));
        service.getPrimeNumbers(100);
    }


}