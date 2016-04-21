package com.icap.primenumber.service;

import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/primenumbers")
@Produces(MediaType.APPLICATION_JSON)
public class PrimeNumberService {

    @Autowired
    PrimeNumberProcessor processor;

    @GET
    @Timed
    @Path("/{number}")
    public int[] getPrimeNumbers(@PathParam("number") Integer number) {
        if(number==0) throw new RuntimeException("Invalid value");
        if(number>10000){
            return processor.getPrimeNumbersUsingMillerRabinTest(number);
        }else{
            return processor.getPrimeNumbers(number);
        }
    }
}
