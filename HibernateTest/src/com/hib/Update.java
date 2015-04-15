package com.hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {
	public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        Scanner sc=new Scanner(System.in);
        Student obj = new Student();
        System.out.println("Enter Rollnum to be updated: ");
        int idSearch=sc.nextInt();
        try{
            obj=(Student)session.load(Student.class,idSearch);
            System.out.println(obj.getId()+" "+obj.getFirstName()+" "+obj.getLastName()+" "+obj.getUniversity());
        }catch(Exception e){
            System.out.println("Record not found!");
        }
        
        System.out.println("Enter Updated Rollnum: ");
        int idUpdate=sc.nextInt();
        System.out.println("Enter Updated First Name: ");
        String fname=sc.next();
        System.out.println("Enter Updated Last Name: ");
        String lname=sc.next();
        System.out.println("Enter Updated University Name: ");
        String univ =sc.next();
            
        obj=(Student)session.get(Student.class,new Integer(idUpdate));
           
        obj.setId(idUpdate);
        obj.setFirstName(fname);
        obj.setLastName(lname);
        obj.setUniversity(univ);
        session.update(obj);
        System.out.println("Updated!");
        session.clear();
        tx.commit();
        session.close();
    }

}
