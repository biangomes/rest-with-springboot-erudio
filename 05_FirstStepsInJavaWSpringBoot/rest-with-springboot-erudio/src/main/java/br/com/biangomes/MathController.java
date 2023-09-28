package br.com.biangomes;

import java.util.concurrent.atomic.AtomicLong;

import br.com.biangomes.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
public class MathController {

	private int n1;
	private int n2;
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
	public Double sum(@PathVariable("n1") String n1, @PathVariable("n2") String n2) throws Exception {

		if (!isNumeric(n1) || !isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Não é permitido caracteres diferentes de números!");
		}

		return convertToDouble(n1) + convertToDouble(n2);

	}

	private Double convertToDouble(String numero) {
		if (numero.equals(null)) return 0D;

		// parser para usar o padrão do Brasil
		String number = numero.replaceAll(",",".");

		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String numero) {
		if (numero.equals(null)) return false;

		String number = numero.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}


}
