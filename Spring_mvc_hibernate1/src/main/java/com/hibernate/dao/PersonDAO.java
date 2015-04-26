package com.hibernate.dao;

import java.util.List;

import com.hibernate.pojo.Person;
  
public interface PersonDAO {
 
    public void save(Person p);
     
    public List<Person> list();
     
}