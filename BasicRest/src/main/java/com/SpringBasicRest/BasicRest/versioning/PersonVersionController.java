package com.SpringBasicRest.BasicRest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*This file indicates the different way we can do versioning
* in RestServices*/

@RestController
public class PersonVersionController {

    @GetMapping("v1/person")
    public PersonV1 personV1 (){

        return new PersonV1("Isida Kaloshi");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2 (){

       return  new PersonV2(new Name( "Zenepe", "Kaloshi")) ;
    }

    // using request parameter to implement versioning
    @GetMapping(value="/person/param", params = "version=1")
    public PersonV1 paramV1 (){

        return new PersonV1("Isida Kaloshi");
    }

    @GetMapping(value="/person/param", params = "version=2")
    public PersonV2 paramV2 (){

        return  new PersonV2(new Name( "Zenepe", "Kaloshi")) ;
    }

    // using header parameter to implement versioning
    @GetMapping(value="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1 (){

        return new PersonV1("Isida Kaloshi");
    }
    @GetMapping(value="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2 (){

        return  new PersonV2(new Name( "Zenepe", "Kaloshi")) ;
    }
    //  using produces to iplement versioning
    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1 (){

        return new PersonV1("Isida Kaloshi");
    }
    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2 (){

        return  new PersonV2(new Name( "Zenepe", "Kaloshi")) ;
    }
}

