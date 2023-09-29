package br.com.biangomes.math;

public class SimpleMath {

    public Double sum(Double n1, Double n2) throws Exception {
        return n1 + n2;
    }

    public Double sub(Double n1, Double n2) throws Exception {
        return n1 - n2;
    }

    public Double div(Double n1, Double n2) throws Exception {
        return n1 / n2;
    }

    public Double mult(Double n1, Double n2) {
        return n1 * n2;
    }

    public Double mean(Double n1, Double n2) {
        return (n1 + n2) / 2;
    }
}
