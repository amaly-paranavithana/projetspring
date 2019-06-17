package aspect;


import org.aspectj.lang.annotation.*;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class Public {
	@Before("execution(* bean.ChefOrchestre.concert(..))")
	public void assis(){
		System.out.println("Le public s'assied");
	}
@AfterThrowing("execution(* bean.ChefOrchestre.concert(..))")

	public void siffle() {
System.out.println("Le public siffle");
	}
@AfterReturning("execution(* bean.ChefOrchestre.concert(..))")

	public void applaudir() {
System.out.println("Le public applaudit");
	}

}
