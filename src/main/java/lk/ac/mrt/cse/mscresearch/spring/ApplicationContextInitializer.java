package lk.ac.mrt.cse.mscresearch.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInitializer {

	private static ApplicationContext ctx;
	
	public static void initialize() {
		ctx = new AnnotationConfigApplicationContext(Configuration.class);
	}
	
	public static <T>  T get(Class<T> c) {
		return ctx.getBean(c);
	}
}
