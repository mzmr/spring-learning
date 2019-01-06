package pl.znamirowski.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.znamirowski.hibernate.demo.entity.Course;
import pl.znamirowski.hibernate.demo.entity.Instructor;
import pl.znamirowski.hibernate.demo.entity.InstructorDetail;
import pl.znamirowski.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure()
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println("Deleting the course...");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.delete(tempCourse);

			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
