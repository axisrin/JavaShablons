package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nThread-Safe Constructor with preparement : \n");

        BanditOdinochka bO = BanditOdinochka.firstThreadSafeConstructor();
        System.out.println(bO.toString());

        BanditOdinochka b1 = BanditOdinochka.firstThreadSafeConstructor();
        System.out.println(b1.toString()+"\n");

        System.out.println("Thread-Safe Constructor with Volatile : \n");

        BanditOdinochkaVolatile bOV = BanditOdinochkaVolatile.secondThreadSafeConstructor();
        System.out.println(bOV.toString());

        BanditOdinochkaVolatile b1V = BanditOdinochkaVolatile.secondThreadSafeConstructor();
        System.out.println(b1V.toString()+"\n");

        System.out.println("Thread-Safe Constructor with Holder : \n");

        BanditOdinochkaWithHolder bOWH = BanditOdinochkaWithHolder.thirdThreadSafeConstructor();
        System.out.println(bOWH.toString());

        BanditOdinochkaWithHolder b1WH = BanditOdinochkaWithHolder.thirdThreadSafeConstructor();
        System.out.println(b1WH.toString()+"\n");

    }

    public static class BanditOdinochka {

        private static BanditOdinochka banditOdinochka;

        private BanditOdinochka() {};

        public static synchronized BanditOdinochka firstThreadSafeConstructor(){
            if (banditOdinochka == null){
                banditOdinochka = new BanditOdinochka();
            }
            return banditOdinochka;
        }

    }

    public static class BanditOdinochkaVolatile { // Паршивый метод с нагрузкой volatile

        private static volatile BanditOdinochkaVolatile banditOdinochkaVolatile;

        private BanditOdinochkaVolatile() {};

        public static BanditOdinochkaVolatile secondThreadSafeConstructor(){
            if (banditOdinochkaVolatile == null)
                synchronized (BanditOdinochkaVolatile.class) {
                    if (banditOdinochkaVolatile == null)
                        banditOdinochkaVolatile = new BanditOdinochkaVolatile();
                }
            return banditOdinochkaVolatile;
        }

    }

    public static class BanditOdinochkaWithHolder { // Еврейский подход

        private static BanditOdinochkaVolatile banditOdinochkaVolatile;

        private static class BanditOdinochkaHolder {
            static final BanditOdinochkaWithHolder bandit = new BanditOdinochkaWithHolder();
        }

        public static BanditOdinochkaWithHolder thirdThreadSafeConstructor(){
            return BanditOdinochkaHolder.bandit;
        }

    }

}
