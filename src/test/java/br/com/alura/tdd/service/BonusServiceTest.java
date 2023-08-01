package br.com.alura.tdd.service;

import br.com.alura.tdd.service.modelo.Funcionario;
import br.com.alura.tdd.service.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test //verificar a exception com junit
    public void bonusDeveriaSerZeroSalarioAlto(){
        BonusService bonus = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> bonus.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    public void bonusDeveriaSer10PorCento(){
        BonusService bonus = new BonusService();
        BigDecimal bonusService = bonus.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("5000")));
        assertEquals(new BigDecimal("500.0"), bonusService);
    }

    @Test
    public void bonusDeveriaSer1000(){
        BonusService bonus = new BonusService();
        BigDecimal bonusService = bonus.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.0"), bonusService);
    }


}
