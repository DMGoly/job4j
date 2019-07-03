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

public class FitTest {
    Fit fit = new Fit();

    @Test
    public void whenWeightMen(){
        double result = fit.manWeight(186D);
        double exp = 98.89999999999999D;
        assertThat(result, is(exp));
    }

    @Test
    public void whenWeightWomen(){
        double result = fit.womanWeight(178D);
        double exp =78.19999999999999D ;
        assertThat(result,is(exp));
    }
}
