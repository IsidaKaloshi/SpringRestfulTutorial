package com.SpringBasicRest.BasicRest.HelloWorld;

public class HelloWorldIdBean {


    private String message;

    public HelloWorldIdBean(String message) {

        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldIdBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
