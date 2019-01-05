package pl.znamirowski.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.znamirowski.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure()
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// in query use Java names, not database names
			List<Student> theStudents = session.createQuery("from Student", Student.class).getResultList();
			theStudents.forEach(System.out::println);
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'", Student.class).getResultList();
			System.out.println("\nStudents who have last name of Doe");
			theStudents.forEach(System.out::println);
			
			theStudents = session.createQuery("from Student s where s.firstName = 'Daffy'" +
					" OR s.lastName='Doe'", Student.class).getResultList();
			System.out.println("\nStudents who have last name of Doe OR first name Daffy");
			theStudents.forEach(System.out::println);
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%.pl'", Student.class).getResultList();
			System.out.println("\nStudents who have an email in Polish domain");
			theStudents.forEach(System.out::println);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
