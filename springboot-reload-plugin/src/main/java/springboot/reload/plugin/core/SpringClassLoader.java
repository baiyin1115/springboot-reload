package springboot.reload.plugin.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringClassLoader extends AnnotationConfigApplicationContext{
 
	public ClassLoader getMyClassLoader() {
		return super.getClassLoader();
	}

}
