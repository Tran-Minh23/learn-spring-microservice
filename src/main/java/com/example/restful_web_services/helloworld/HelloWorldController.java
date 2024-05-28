package com.example.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("hello-world")
    public String helloWorld() {
        return "hello cc";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello cc");
    }

    @GetMapping(path = "/hello-world/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name) {
        return new HelloWorldBean("Hello cc " + name);
    }

    @GetMapping("hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
    }
}
