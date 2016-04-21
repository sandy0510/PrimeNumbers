package com.icap.primenumber.service;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.stream.IntStream;

public class PrimeNumberProcessor {

    private static final int NO_OF_FERMAT_ITERATIONS = 10;
    private static final int SQUARE_ROOT_LIMIT = 10000;

    public int[] getPrimeNumbers(int number) {
        if(number ==1 || number==2) return new int[]{number};
        return IntStream.rangeClosed(2, number)
                .parallel()
                .filter(x -> checkIfNumberIsPrimeNormalScenario.apply(x))
                .toArray();
    }

    public int[] getPrimeNumbersUsingMillerRabinTest(int number) {
        return IntStream.rangeClosed(2, number)
                .parallel()
                .filter(origNumber -> BigInteger.valueOf(origNumber).isProbablePrime(NO_OF_FERMAT_ITERATIONS))
                .toArray();
    }

    Function<Integer, Boolean> checkIfNumberIsPrimeNormalScenario = (number) -> {
        boolean isPrime = true;
        int limit = (number > SQUARE_ROOT_LIMIT ? (int) Math.sqrt(number) : number / 2);
        long factors = IntStream.rangeClosed(2, limit)
                .parallel()
                .filter(no -> number % no == 0)
                .count();
        if (factors > 0) return false;
        return isPrime;
    };

}
