package com.stori.toyrpc;

public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String s) {
        return "Hello " + s + "!";
    }
}
