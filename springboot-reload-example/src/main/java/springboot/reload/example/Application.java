package springboot.reload.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springboot.reload.plugin.annotation.EnableOnlineReload;

@SpringBootApplication
@ComponentScan(basePackages="springboot.reload")
@EnableOnlineReload(activeProfile= {"dev"},needAuth=true)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}