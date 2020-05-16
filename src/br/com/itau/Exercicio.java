package br.com.itau;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.itau.modelo.Lancamento;
import br.com.itau.service.LancamentoService;

public class Exercicio {

    public static void main(String[] args) {
        List<Lancamento> lancamentos = new LancamentoService().listarLancamentos();
        int varCategoria = 6;
        int varMes = 1;

        System.out.println("lancamentos ordenados por mes");
        lancamentos.sort(Comparator.comparingInt(Lancamento::getMes));
        lancamentos.forEach(System.out::println);

        System.out.println("lancamentos da mesma categoria");
        List<Lancamento> result = lancamentos.stream().filter(item -> item.getCategoria()== varCategoria).collect(Collectors.toList());
        result.forEach(System.out::println);

        //fatura de acordo com o mes
        List<Lancamento> fatura = lancamentos.stream().filter(item -> item.getMes()== varMes).collect(Collectors.toList());
        double resultadoFatura = fatura.stream().mapToDouble(Lancamento::getValor).sum();
        System.out.println("fatura do Mes " + varMes + ": "+ resultadoFatura);


    }


}
