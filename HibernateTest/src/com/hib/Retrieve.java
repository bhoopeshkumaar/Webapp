package com.hib;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Retrieve {
    public static void main(String[] args) {
        
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        
        Query q=session.createQuery("select id,firstName,lastName,university from Student");//classname,variablenames
        
        List<Object[]> list=q.list();
        if(list.isEmpty())
        {
            System.out.println("No records");
        }
        else
        {
            for(Object stu[]:list)
            {
                System.out.println(stu[0]+" "+stu[1]+" "+stu[2]+" "+stu[3]);
            }
        }
        tx.commit();
        session.close();
        
    }
    
}

