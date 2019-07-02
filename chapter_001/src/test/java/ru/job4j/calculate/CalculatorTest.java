package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CalculatorTest {
    Calculator calculator = new Calculator();


    @Test
    public void whenAddThreePlusFourThenSeven() {
        double result = calculator.add(3D, 4D);
        double exp = 7D;
        assertThat(result, is(exp));
    }

    @Test
    public void  whenDiv(){
        double result = calculator.div(3D,3D);
        double exp = 1D;
        assertThat(result, is(exp));
    }
    @Test
    public void Multiple(){
        double result = calculator.multiple(3D,3D);
        double exp = 9D;
        assertThat(result,is(exp));
    }
    @Test
    public void Minus(){
        double result = calculator.minus(3D,3D);
        double exp = 0D;
        assertThat(result, is(exp));
    }

}
