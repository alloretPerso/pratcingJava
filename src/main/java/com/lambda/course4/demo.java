package com.lambda.course4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(0, "Tom", "Friz"),
                new Person(18, "Tim", "Friz"),
                new Person(60, "Rob", "Friz"),
                new Person(70, "Jef", "Friz")));

        List<Integer> listAge = people.stream().map(Person::getAge).collect(Collectors.toList());

        List<Integer> filteredList = listAge.stream().filter(age -> age > 20).collect(Collectors.toList());

        int sum = filteredList.stream().reduce(Integer::sum).get();

        //System.out.println(listAge);

        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));

        BinaryOperator<Integer> op = Integer::sum;

        int reduction = reduce(list, 0, op);
        System.out.println("Reduction : " + reduction);
    }

    private static int reduce(List<Integer> list, int i, BinaryOperator<Integer> op) {
        int result = i;
        for (int value : list) {
            result = op.apply(result, value);
        }
        return result;
    }

}
