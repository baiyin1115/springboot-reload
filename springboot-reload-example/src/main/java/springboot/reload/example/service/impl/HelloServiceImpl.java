package springboot.reload.example.service.impl;

import org.springframework.stereotype.Service;

import springboot.reload.example.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String hello(String msg) {
		return String.format("版本 1111111111 : %s", msg);
//		return String.format("版本 2222222222: %s", msg);
//		return String.format("版本 333333333: %s", msg);
	}

}
