package pl.znamirowski.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.znamirowski.hibernate.demo.entity.Instructor;
import pl.znamirowski.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure()
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructionDetail: " + tempInstructorDetail);
			
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
