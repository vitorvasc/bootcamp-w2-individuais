package br.com.meli.bootcampspringcodigomorse.controller;

import br.com.meli.bootcampspringcodigomorse.service.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    private CodigoMorseService codigoMorseService;

    @Autowired
    public CodigoMorseController(CodigoMorseService codigoMorseService) {
        this.codigoMorseService = codigoMorseService;
    }

    @RequestMapping("/convert-to-text")
    public String convertToText(@RequestParam String text) {
        return codigoMorseService.toNormal(text);
    }

    @RequestMapping("/convert-to-morse")
    public String convertToMorse(@RequestParam String text) {
        return codigoMorseService.toMorse(text);
    }
}
