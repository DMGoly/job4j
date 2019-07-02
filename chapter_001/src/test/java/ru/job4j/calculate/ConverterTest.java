package ru.job4j.calculate;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Dmitry Golyshkin (dmgoly@gmail.com)
 * @version $Id$
 * @since 0.1
 **/

public class ConverterTest{
    Converter converter = new Converter();
    @Test
    public void whenRubToEur(){
        int result = converter.rubleToEuro(70);
        int exp = 1;
        assertThat(result, is(exp));
    }
    @Test
    public void whenEuroToRub(){
        int result = converter.EuroToRuble(1);
        int exp = 70;
        assertThat(result,is(exp));
    }
    @Test
    public void whenRubToUsd(){
        int result = converter.rubleToDollar (65);
        int exp = 1;
        assertThat(result, is(exp));

    }
    @Test
    public void whenUsdToRub(){
        int result = converter.DollarToRuble(2);
        int exp = 130;
        assertThat(result, is(exp));
    }
}