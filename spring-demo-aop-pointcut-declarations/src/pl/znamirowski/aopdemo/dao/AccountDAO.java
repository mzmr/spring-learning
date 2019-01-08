package pl.znamirowski.aopdemo.dao;

import org.springframework.stereotype.Component;

import pl.znamirowski.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vip) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
