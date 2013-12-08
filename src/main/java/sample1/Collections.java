package sample1;

import java.util.*;
import java.util.stream.*;

import com.google.common.base.*;
import com.google.common.collect.*;

// TODO Search sur une propriete par nom
// TODO Map reduce
//
public class Collections {
  public int withJava6(String name) {
    List<Person> persons = Arrays.asList(new Person("Bob", 34), new Person("Dave", 60), new Person("Jack", 12));

    for (Person person : persons) {
      if (name.equals(person.getName())) {
        return person.getAge();
      }
    }

    throw new NoSuchElementException("Unable to find " + name);
  }

  public int withGuava(final String name) {
    List<Person> persons = Lists.newArrayList(new Person("Bob", 34), new Person("Dave", 60), new Person("Jack", 12));


    return FluentIterable.from(persons).filter(new Predicate<Person>() {
      @Override
      public boolean apply(Person person) {
        return name.equals(person.getName());
      }
    }).first().get().getAge();
  }

  public int withJava8(String name) {
    Stream<Person> persons = Stream.of(
      new Person("Bob", 34),
      new Person("Dave", 60),
      new Person("Jack", 12)
    );

    return persons.filter(person -> name.equals(person.getName())).findFirst().get().getAge();
  }

  public static class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }
  }
}
