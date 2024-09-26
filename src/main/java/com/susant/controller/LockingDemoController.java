package com.susant.controller;

import com.susant.entity.BusDetails;
import com.susant.repository.BusRepository;
import com.susant.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.function.FailableRunnable;

@RestController
@RequestMapping("/api")
public class LockingDemoController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BusRepository busRepository;

	@GetMapping("/bookTicket")
	public void bookTicket() {
	    ExecutorService executor = Executors.newFixedThreadPool(2);

	    // Using lambdas instead of method references
	    executor.execute(run(() -> bookingService.bookTickets()));  // lambda for bookTicket
	    executor.execute(run(() -> bookingService.bookTickets1())); // lambda for bookTicket1
	    executor.shutdown();
	}
	
	@PostMapping("/addBus/{capacity}/{number}")
	public void addBus(@PathVariable int capacity, @PathVariable String number, @RequestBody BusDetails busDetails) {
	    busDetails.setCapacity(capacity);
	    busDetails.setNumber(number);
	    busDetails.setDepartureTime(LocalDateTime.now());
	    busRepository.save(busDetails);
	}


	private Runnable run(FailableRunnable<Exception> runnable) {
	    return () -> {
	        try {
	            runnable.run();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    };
	}


}