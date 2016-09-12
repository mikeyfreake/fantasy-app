package io.github.mikeyfreake.fantasy.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping("/foo")
    @ResponseBody
    public Foo home() {
    	return new Foo("michael", "some developer guy");
        //return "Hello World!";
    }

}
