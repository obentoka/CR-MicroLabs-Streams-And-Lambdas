package com.zipcodewilmington.lambdas;

import com.zipcodewilmington.lambdas.anthropoid.Person;
import com.zipcodewilmington.lambdas.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */
    public StreamFilter() {
        this(PersonFactory.createPersonStream(100), 'A');
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */
    public StreamFilter(Person[] people, Character startingCharacter) {
        this(Stream.of(people), startingCharacter);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this(people.stream(), startingCharacter);
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }



    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with "A"
     */
    public List<Person> toListMultiLine() {
        Stream<Person> personStreamFiltered = personStream.filter(person -> person.name.getValue().startsWith(startingCharacter));
        List list = personStreamFiltered.collect(Collectors.toList());
        return list;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person object whose name starts with "A"
     */
    public List<Person> toListOneLine() {
        return personStream
                .filter(person -> person.name.getValue().startsWith(startingCharacter))
                .collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with "A"
     */
    public Person[] toArrayOneLine() {
        return personStream
                .filter(person -> person.name.getValue().startsWith(startingCharacter))
                .toArray(Person[]::new); // method reference
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with "A"
     */
    public Person[] toArrayMultiLine() {
        Stream<Person> personStreamFiltered = personStream.filter(person -> person.name.getValue().startsWith(startingCharacter));
        Person[] personArray = personStreamFiltered.toArray(Person[]::new); // method reference
        return personArray;
    }

}
