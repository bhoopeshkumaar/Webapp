package com.hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
	
	    public static void main(String[] args) {
	        SessionFactory sf=new Configuration().configure().buildSessionFactory();
	        Session session=sf.openSession();
	        Transaction tx=session.beginTransaction();
	        //System.out.println("after transaction---->>");
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter ID of the student to be deleted: ");
	        int idSearch=sc.nextInt();
	        Student obj=new Student();
	        try{
	            obj=(Student)session.load(Student.class,idSearch);
	            System.out.println(obj.getId()+" "+obj.getFirstName()+" "+obj.getLastName()+" "+obj.getUniversity());
	        }catch(Exception e){
	            System.out.println("Record not found!");
	        }
	        obj.setId(idSearch);
	        //System.out.println("after constructor call------>");
	        session.delete(obj);
	        tx.commit();
	        session.close();
	        System.out.println("Record Deleted Successfully!");
	    }

}