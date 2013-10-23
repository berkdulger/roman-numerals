/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.kata;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class AppTest {
    
    @Test
    public void value_of_numeral_with_one_symbol_is_that_symbols_value() {
        String romanNumeral = "X";
        
        final int valueOfRomanNumeral = valueOfNumeral(romanNumeral);
        
        assertThat(valueOfRomanNumeral, is(new Symbol(romanNumeral).getValue()));
    }
    
    //~~~~~~~~~~ Production
    
    class Numeral {
        String represenation;

        public Numeral(String represenation) {
            this.represenation = represenation;
        }
        
        public int getValue() {
            return new Symbol(represenation).getValue();
        }
    }
    
    protected int valueOfNumeral(String romanNumeral) {
        return new Numeral(romanNumeral).getValue();
    }
}