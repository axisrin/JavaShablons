package lesson.personal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String n1 = scanner.next();
        String n2 = scanner.next();

        Comparator<String> comapreNumString = (a,b) ->{
            int c , d;
            c = Integer.valueOf(a);
            d = Integer.valueOf(b);

            if(c > d) {
                System.out.println("More is = " + c);
                String a1 = a;
                return Integer.parseInt(a1);
            }
            System.out.println("More is = " + d);
            String b1 = b;
            return Integer.parseInt(b1);
        };

        int compareStringInt = comapreNumString.compare(n1,n2);
    }
}
