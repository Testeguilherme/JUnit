package br.com.alura.tdd.service;

import br.com.alura.tdd.service.modelo.DesempenhoEnum;
import br.com.alura.tdd.service.modelo.Funcionario;
import br.com.alura.tdd.service.service.ReajusteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    public ReajusteService reajusteService;
    public Funcionario funcionario;

    @BeforeEach //anotação para o junit chamar esse método antes de rodar cada teste
    public void inicializar(){
        System.out.println("Início!");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach //anotação para o junit chamar esse método depois de rodar cada teste
    public void finalizar(){
        System.out.println("Fim!");
    }

    @Test
    public void aDesejar(){
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
    @Test
    public void bom(){
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    @Test
    public void otimo(){
        reajusteService.concederReajuste(funcionario, DesempenhoEnum.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
