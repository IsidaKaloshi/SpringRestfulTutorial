package com.SpringBasicRest.BasicRest.HelloWorld;


        import org.apache.tomcat.util.http.parser.AcceptLanguage;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.MessageSource;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestHeader;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.Locale;

// Controller
@RestController
public class HelloWordController {

    @Autowired
    private MessageSource messageSource;

    // GET
    // URI - /hello-world
    // create a methor that return "HelloWorld!!"

    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    // one way is with RequestMapping but we can doi it direcly with GetMapping

    @GetMapping(path = "/hello-world")
    public String HelloWorldId(){

        return "Hello World !!";

    }

    //hello-word-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldIdBean HelloWorldIdBean(){

        return new HelloWorldIdBean("Hello World");

    }


    //hello-word pathe variable
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldIdBean HelloWorlPathVariable(@PathVariable String name){

        return new HelloWorldIdBean(String.format("Hello World, %s", name));

    }


    @GetMapping(path = "/hello-world-internationalized")
    public String HelloWorldInternationalized
            (@RequestHeader (name = "Accept-Language", required = false) Locale locale){

       return messageSource.getMessage("good.morning.message", null,locale);


    }
}
