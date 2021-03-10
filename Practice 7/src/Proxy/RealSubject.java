package Proxy;

public class RealSubject implements Subject{

    static String greeting = "Hello, i'm the REAL SUBJECT!";

    @Override
    public void request() {
        System.out.println(greeting);
    }
}
