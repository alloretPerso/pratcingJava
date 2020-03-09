package com.lambda.course1;

import java.util.function.Function;

public class demo {
    public static Comparator<String> oldFashion = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    };
    public static Comparator<String> lambda = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());

    //public static Comparator<String> lambdaRefactored = Comparator.comparing(String::length);

    public static Runnable r = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (i++ < 10) {
                System.out.println("It works !");
            }
        }
    };

    public static Runnable rLambda = () -> {
        int i = 0;
        while (i++ < 10) {
            System.out.println("It works !");
        }
    };


    private static Function<Person, Integer> getAge = Person::getAge;
    private static Function<Person, String> getLastName = Person::getLastName;
    private static Comparator<Person> comparator = Comparator.comparing(getLastName);

    public static void main(String[] args) {
        //rLambda.run();

        Person person2 = new Person(17, "xx", "aa");
        Person person1 = new Person(19, "ttdd", "tt");
        System.out.println(getAge.apply(person1));
        System.out.println(comparator.compare(person1, person2));

       /* Comparator<Person> cmp = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getAge);*/
       var test =1 ;
    }
}
