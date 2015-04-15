package com.hib;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class WhereClause {
    public static void main(String[] args) {
         SessionFactory sf=new Configuration().configure().buildSessionFactory();
          Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        
        Criteria q=session.createCriteria(Student.class);
        q.add(Restrictions.eq("university","IJKL"));//select university from student where university='UMD';
        List<Student> list=q.list();
        if(list.isEmpty())
        {
            System.out.println("No records");
        }
        
        else
        {
            for(Student stu:list)
            {
                System.out.println(stu.getFirstName()+" "+stu.getUniversity());
            }
                    
        }
       
        tx.commit();
        session.close();
        
 }
}
   
       
        