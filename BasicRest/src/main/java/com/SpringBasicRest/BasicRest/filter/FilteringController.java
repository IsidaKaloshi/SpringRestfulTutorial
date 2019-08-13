package com.SpringBasicRest.BasicRest.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrievSomeBean() {

        return new SomeBean ("value1", "value2", "value3");

    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomeBean() {

        return  Arrays.asList(new SomeBean ("value1", "value2", "value3"),
                    new SomeBean("Value22", "Value23", "Value35"));

    }
}
