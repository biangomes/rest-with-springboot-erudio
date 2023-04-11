package br.com.biangomes;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	private int n1;
	private int n2;
	private final AtomicLong counter = new AtomicLong();
	
	
}
