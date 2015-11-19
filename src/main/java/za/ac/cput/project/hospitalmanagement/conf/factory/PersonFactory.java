package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Person;

/**
 * Created by Ancel on 2015/05/06.
 */
public class PersonFactory {
    public static Person createPerson(String firstName, String lastName, int age, String gender) {
        Person person = new Person
                .Builder(firstName)
                .lastName(lastName)
                .age(age)
                .gender(gender)
                .build();
        return person;
    }
}
