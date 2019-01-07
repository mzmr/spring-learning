package pl.znamirowski.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.znamirowski.hibernate.demo.entity.Course;
import pl.znamirowski.hibernate.demo.entity.Instructor;
import pl.znamirowski.hibernate.demo.entity.InstructorDetail;
import pl.znamirowski.hibernate.demo.entity.Review;
import pl.znamirowski.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure()
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			Student tempStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
			Student tempStudent2 = new Student("Mary", "Public", "marypublic@gmail.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			System.out.println("\nSaving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());

			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
