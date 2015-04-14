package com.hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Insertion {
	
	public static void main(String args[]){
		
	
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        //System.out.println("after transaction---->>");
        Scanner sc=new Scanner(System.in);
        //Adding Records:
        System.out.println("Enter ID of the student: ");
        int id=sc.nextInt();
        System.out.println("Enter First Name of the student: ");
        String firstName=sc.next();
        System.out.println("Enter Last Name of the student: ");
        String lastName=sc.next();
        System.out.println("Enter University of the student: ");
        String university = sc.next();
        Student obj= new Student(id, firstName, lastName, university);
        //System.out.println("after constructor call------>");
        session.save(obj);
        tx.commit();
        System.out.println("Insertion Successful");
        
	}
}
