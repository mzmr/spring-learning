package pl.znamirowski.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* pl.znamirowski.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* pl.znamirowski.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* pl.znamirowski.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
