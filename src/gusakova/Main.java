package gusakova;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person [] person = new Person[3];
        person[0]=new Person("Mik", 12);
        person[1] = new Person("Nik", 16);
        person[2]=new Person("Lina", 11);

        Arrays.sort(person, new PersonSuperComparator());
        for (Person p: person)
            System.out.println(p);
    }
}
class Person{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age){
        this.name=name;
        this.age =age;
    }

    @Override
    public String toString() {
        return name + " " + String.valueOf(age) + "\n";
    }
}

class PersonSuperComparator implements Comparator<Person> {
    public int compare(Person person1, Person person2) {
        int nameCompare = person1.getName().compareToIgnoreCase(person2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        } else {
            return Integer.valueOf(person1.getAge()).compareTo(Integer.valueOf(person2.getAge()));
        }
    }
}