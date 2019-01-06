package pl.znamirowski.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.znamirowski.hibernate.demo.entity.Course;
import pl.znamirowski.hibernate.demo.entity.Instructor;
import pl.znamirowski.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure()
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);

			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
