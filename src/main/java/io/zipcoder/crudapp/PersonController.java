package io.zipcoder.crudapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

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

}
