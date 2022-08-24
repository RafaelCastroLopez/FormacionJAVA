package com.example.Loggin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RecogerLoggin {

    @GetMapping("probarLogin")
    public void loggin(){
        log.trace("soy un trace");
        log.info("soy un info");
        log.debug("soy un debug");
        log.warn("soy un warning");
        log.error("soy un error");
        System.out.println("mira los logs");
    }


}
