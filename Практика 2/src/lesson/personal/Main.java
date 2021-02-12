package lesson.personal;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Human> humanity = new ArrayList<>();
        LocalDate date;
        humanity.add(new Human(19, "Alexis", "Proshin", date = LocalDate.of(2001,9,21), 72));
        humanity.add(new Human(19, "Nikita", "Evgenyev", date = LocalDate.of(1992,2,20), 60));
        humanity.add(new Human(22, "Fedot", "Turgenev", date = LocalDate.of(1994,3,9), 70));
        humanity.add(new Human(50, "Kayemir", "Malinov", date = LocalDate.of(2002,5,14), 65));
        humanity.add(new Human(21, "Paul", "Yashemalinkin", date = LocalDate.of(1985,9,30), 75));
        humanity.add(new Human(18, "Fresk", "Klubin", date = LocalDate.of(1988,1,11), 80));
        humanity.add(new Human(18, "Vi", "Balbesov", date = LocalDate.of(2006,3,12), 85));

        Predicate<Human> filterYearBirth = (a)-> {
          if (a.birthDate.isBefore(LocalDate.of(1999,2,3)))
              return true;
          return false;
        };

        Function<Human,Human> weightMinus = a-> {
            a.weight = a.weight - 5;
            return a;
        };


        System.out.print("\n Last names of sort massive :");
        Stream<Human> streamHumanintyLastNames = humanity.stream();
        streamHumanintyLastNames.filter(filterYearBirth).map(weightMinus).forEach(a-> {
            System.out.print(" " + a.lastName);
        });

        System.out.println(" \n \n Changes: \n");
        Stream<Human> streamHumanintyChangedList = humanity.stream();
        streamHumanintyChangedList.filter(filterYearBirth).map(weightMinus).forEach(System.out::println);

    }
}

class Human {
    int age;
    String firstName;
    String lastName;
    public LocalDate birthDate;
    int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human has {" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }
}
