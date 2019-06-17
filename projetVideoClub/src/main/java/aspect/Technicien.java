package aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Technicien {
	@Before("execution(* bean.ChefOrchestre.concert(..))" )
	public void eteindreLumiere(){
		System.out.println("On éteind la lumière !");
	}

	@AfterReturning(pointcut="execution(* bean.ChefOrchestre.concert(..))",returning="result" )
	public void allumerLumiere(){
		System.out.println("On rallume la lumière !");
	}
}
