package pl.znamirowski.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.znamirowski.hibernate.demo.entity.Course;
import pl.znamirowski.hibernate.demo.entity.Instructor;
import pl.znamirowski.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure()
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor tempInstructor = new Instructor("Susan", "Public", "susanpublic@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/susanpublic", "video games");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
