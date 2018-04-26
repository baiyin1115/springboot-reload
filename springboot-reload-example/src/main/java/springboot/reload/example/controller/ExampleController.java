package springboot.reload.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.reload.example.service.HelloService;

@RestController
public class ExampleController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping(value = "debug-test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok(
				helloService.hello("使用教程: <br/>项目启动完成后,修改HelloServiceImpl的实现,然后打包 HelloServiceImpl为jar文件,然后reload再看"));
	}
	
}