package com.bridgelabz.greetingapp.greetingController;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.dto.Greeting;
import com.bridgelabz.greetingapp.service.IGreetingService;

@RestController
public class GreetingController {
	private static final String template="Hello, %s!";
	private final AtomicLong counter=new AtomicLong();
	
	@Autowired
	private IGreetingService greetingService;
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
	
	@GetMapping("/greeting/{name}")
	public Greeting greetingNew(@PathVariable(value = "name") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
	
	@GetMapping("/message")
	public String message() {
		return greetingService.greet();
	}
}




