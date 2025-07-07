package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JavaStreams {
    public static void main(String[] args) {
        oddNumbers();
        stringsWithA();
        squareNums();
        combinePredicates();
        comparatorSort();
    }

    // Activity 1: Filter Odd Numbers
    public static void oddNumbers(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9 ,10);
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        List<Integer> oddNums = numbers.stream()
                .filter(isOdd)
                .collect(Collectors.toList());
        System.out.println("\nOdd numbers:" + oddNums);
    }

    // Activity 2: Filter Strings Starting With 'A'
    public static void stringsWithA(){
        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA = s -> s.startsWith("A");
        List<String> namesWithA = names.stream()
                .filter(startsWithA)
                .collect(Collectors.toList());
        System.out.println("\nNames starting with A: " + namesWithA);
    }

    // Activity 3: Square All Numbers
    public static void squareNums(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> square = numbers.stream()
                .map(n -> n*n)
                .toList();
        System.out.println("\nSquared numbers: " + square);
    }

    // Activity 4: Combine Predicates
    public static void combinePredicates(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;
        List<Integer> evenNums = numbers.stream()
                .filter(isEven.and(greaterThanFive))
                .collect(Collectors.toList());
        System.out.println("\nEven and >5: " + evenNums);
    }

    public static void comparatorSort(){
        List<Person> people = Arrays.asList(
                new Person("Jana", 23),
                new Person("Christian", 24),
                new Person("Ivan", 25),
                new Person("Francis", 26),
                new Person("Jovi", 27)
        );
        people.sort(
                Comparator.comparingInt(Person::getAge));
        System.out.println("\nSorted by age (ascending): ");
        people.forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));

        people.sort(
                Comparator.comparing(Person::getName));
        System.out.println("\nSorted by name: ");
        people.forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));

        people.sort(
                Comparator.comparingInt(Person::getAge).reversed());
        System.out.println("\nSorted by age (descending): ");
        people.forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));
    }
}