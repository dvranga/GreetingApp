package com.bridgelabz.greetingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {

		private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @Autowired
	    private GreetingRepository greetingRepository;

	    @Override
	    public Greeting addGreeting(User user) {
	        String message = String.format(template,(user.toString().isEmpty())? "Hello World" : user.toString());
	        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
	    }

	    @Override
	    public Optional<Greeting> getGreetingById(long id) {
	        Optional<Greeting> greeting = greetingRepository.findById(id);
	        return greeting;
	    }
	    
	    @Override
	    public List<Greeting> getAllGreetings() {
	        List<Greeting> greetings = new ArrayList<>();
	        greetingRepository.findAll().forEach(greeting -> greetings.add(greeting));
	        return greetings;
	    }

	    @Override
	    public Optional<Greeting> editGreetingById(long id, String name) {
	        Optional<Greeting> particularGreeting = greetingRepository.findById(id);
	        particularGreeting.get().setMessage(name);
	        return particularGreeting;
	    }
	    
	    @Override
	    public String deleteGreeting(long id) {
	        greetingRepository.deleteById(id);
	        return "Greeting Deleted Succesfully";
	    }

}








