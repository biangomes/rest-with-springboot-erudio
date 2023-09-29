package br.com.biangomes;

public class NumberConverter {

    public static Double convertToDouble(String numero) {
        if (numero.equals(null)) return 0D;

        // parser para usar o padrão do Brasil
        String number = numero.replaceAll(",",".");

        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String numero) {
        if (numero.equals(null)) return false;

        String number = numero.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
