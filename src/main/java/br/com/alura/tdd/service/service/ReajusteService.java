package br.com.alura.tdd.service.service;

import br.com.alura.tdd.service.modelo.DesempenhoEnum;
import br.com.alura.tdd.service.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, DesempenhoEnum desempenho){
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal reajuste = desempenho.percentualReajuste().multiply(salarioAtual);
        funcionario.reajustarSalario(reajuste);
    }
}
