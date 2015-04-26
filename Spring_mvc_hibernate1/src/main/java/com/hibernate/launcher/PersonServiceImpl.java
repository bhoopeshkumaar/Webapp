package com.hibernate.launcher;

import java.util.List;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.dao.PersonDAO;
import com.hibernate.pojo.Person;
 
public class PersonServiceImpl {
 
    public void persist(String user, String country){
    	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        PersonDAO personDAO = context.getBean(PersonDAO.class);
         
        Person person = new Person();
        person.setName(user); 
        person.setCountry(country);
         
        personDAO.save(person);
         
        System.out.println("Person::"+person);
         
        List<Person> list = personDAO.list();
         
        for(Person p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        context.close(); 
    	
    }
    
    
}