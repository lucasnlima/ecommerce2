package com.study.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/loja")
public class LojaController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String getLoja(){
        return "Hello";
    }
}
