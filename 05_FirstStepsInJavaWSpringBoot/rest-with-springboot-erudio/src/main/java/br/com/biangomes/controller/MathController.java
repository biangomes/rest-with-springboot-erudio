package br.com.biangomes.controller;

import java.util.concurrent.atomic.AtomicLong;

import br.com.biangomes.NumberConverter;
import br.com.biangomes.exceptions.CantDivideByZeroException;
import br.com.biangomes.exceptions.UnsupportedMathOperationException;
import br.com.biangomes.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import static br.com.biangomes.NumberConverter.convertToDouble;
import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
public class MathController {

	private int n1;
	private int n2;
	private final AtomicLong counter = new AtomicLong();

	private SimpleMath math = new SimpleMath();

	@RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
	public Double sum(@PathVariable("n1") String n1, @PathVariable("n2") String n2) throws Exception {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Não é permitido caracteres diferentes de números!");
		}

		return math.sum(convertToDouble(n1), convertToDouble(n2));
	}

	@RequestMapping(value = "/sub/{n1}/{n2}", method = RequestMethod.GET)
	public Double sub(@PathVariable("n1") String n1, @PathVariable("n2") String n2) throws Exception {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Não é permitido caracteres diferentes de números!");
		}

		return math.sub(convertToDouble(n1), convertToDouble(n2));
	}

	@RequestMapping(value = "/div/{n1}/{n2}", method = RequestMethod.GET)
	public Double div(@PathVariable("n1") String n1, @PathVariable("n2") String n2) throws Exception {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Não é permitido caracteres diferentes de números!");
		}

		if (n2 == "0") {
			throw new CantDivideByZeroException("Não é permitido dividir por zero!");
		}

		return math.div(convertToDouble(n1), convertToDouble(n2));
	}

	@RequestMapping(value="/mult/{n1}/{n2}", method = RequestMethod.GET)
	public Double mult(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Não é permitido caracteres diferentes de números!");
		}

		return math.mult(convertToDouble(n1), convertToDouble(n2));
	}

	@RequestMapping(value="/mean/{n1}/{n2}", method = RequestMethod.GET)
	public Double mean(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Não é permitido caracteres diferentes de números!");
		}

		return math.mean(convertToDouble(n1), convertToDouble(n2));
	}

	@RequestMapping(value = "/root/{n1}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("n1") String n1) {
		if (!NumberConverter.isNumeric(n1)) {
			throw new UnsupportedMathOperationException("Não é permitido caracteres diferentes de números!");
		}

		return Math.sqrt(convertToDouble(n1));
	}
}
