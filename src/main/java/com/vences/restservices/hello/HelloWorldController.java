package com.vences.restservices.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    ResourceBundleMessageSource messageSource;

    //Simple Method
    //Get
    //  URI - /helloworld
    //@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    @GetMapping("/helloworld1")
    public String helloworld() {
        return "Hello Rest Services World";
    }

    @GetMapping("/helloworld-bean")
    public UserDetails helloWorldBean() {
        return new UserDetails("Lucas", "Manuel", "Cancun");
    }

    @GetMapping("/hello-int")
    public String getMessagesInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {
        return messageSource.getMessage("label.hello", null, new Locale(locale));
    }

    @GetMapping("/hello-int2")
    public String getMessagesInI18NFormat2(@RequestHeader(name = "Accept-Language", required = false) String locale) {
        return messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
    }

}
