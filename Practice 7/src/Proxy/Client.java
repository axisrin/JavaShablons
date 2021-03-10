package Proxy;

public class Client {

    public static void main(String[] args) {

        Subject subject = new Proxy();
        subject.request();
        RealSubject.greeting = "Bro this is real!";
        subject.request();

    }

}
