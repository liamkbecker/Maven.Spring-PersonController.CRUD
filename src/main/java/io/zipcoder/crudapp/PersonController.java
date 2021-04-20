package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController implements PersonRepository {

    @Autowired
    PersonRepository personRepository;

    List<Person> personList = new ArrayList<Person>();

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public Person createPerson(Person p){
        personList.add(p);
        return p;
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable String id){
        for(int i = 0; i < personList.size(); i++){
            if(Long.getLong(id) == personList.get(i).getId()){
                return personList.get(i);
            }
        }
        return new Person();
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public List<Person> getPersonList(){
        return personList;
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public Person updatePerson(Person p){
        deletePerson("" + p.getId());
        return createPerson(p);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable String id){
        for(int i = 0; i < personList.size(); i++){
            if(Long.getLong(id) == personList.get(i).getId()){
                personList.remove(personList.get(i));
            }
        }
    }

    @Override
    public <S extends Person> S save(S s) {
        return null;
    }

    @Override
    public <S extends Person> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Person findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Person> findAll() {
        return personRepository;
    }

    @Override
    public Iterable<Person> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public void delete(Iterable<? extends Person> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
