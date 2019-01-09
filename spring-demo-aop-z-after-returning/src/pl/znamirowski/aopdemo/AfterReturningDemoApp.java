package pl.znamirowski.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.znamirowski.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		context.close();
	}

}
