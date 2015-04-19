package com.hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Search {
	
	public static void main(String args[]){
		
	
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        //System.out.println("after transaction---->>");
        Scanner sc=new Scanner(System.in);
        //Adding Records:
        System.out.println("Enter ID of the student to be searched: ");
        int idSearch=sc.nextInt();
        try{
            Student obj=(Student)session.load(Student.class,idSearch);
            System.out.println(obj.getId()+" "+obj.getFirstName()+" "+obj.getLastName()+" "+obj.getUniversity());
        }catch(Exception e){
            System.out.println("Record not found!");
        }
        tx.commit();
        session.close();
        
	}
}
