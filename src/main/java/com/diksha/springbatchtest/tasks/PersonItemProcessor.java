package com.diksha.springbatchtest.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import com.diksha.springbatchtest.data.Person;
 
@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {
 
  @Override
  public Person process(Person person) throws Exception {
    final String firstName = person.getFirstName().toUpperCase();
    final String lastName = person.getLastName().toUpperCase();
    final Person transformedPerson = new Person(firstName, lastName);
    log.info("Converting (" + person + ") into (" + transformedPerson + ")");
 
    return transformedPerson;
  }
}