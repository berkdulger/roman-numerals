/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class AppTest {

    @Test
    public void value_of_I_is_1() {
        assertThat(valueOf("I"), is(1));
    }

    @Test
    public void value_of_V_is_5() {
        assertThat(valueOf("V"), is(5));
    }

    @Test
    public void value_of_X_is_10() {
        assertThat(valueOf("X"), is(10));
    }

    @Test
    public void value_of_L_is_50() {
        assertThat(valueOf("L"), is(50));
    }

    @Test
    public void value_of_C_is_100() {
        assertThat(valueOf("C"), is(100));
    }

    @Test
    public void value_of_D_is_500() {
        assertThat(valueOf("D"), is(500));
    }

    @Test
    public void value_of_M_is_1000() {
        assertThat(valueOf("M"), is(1000));
    }
    
    @Test
    public void value_is_computed_by_adding_symbols_values() {
        int valueOfSymbol1 = 1;
        int valueOfSymbol2 = 2;
        
        int computedValue = valueOfSymbol1+valueOfSymbol2;
        
        assertThat(computedValue, is(valueOfSymbol1+valueOfSymbol2));
    }
    
    @Test
    public void I_can_be_substracted_from_V() {
        String leftSymbol = "I";
        String rightSymbol = "V";
        
        boolean canBePlaced = canSubstractSymbol(leftSymbol, rightSymbol);
        
        assertThat(canBePlaced, is(true));
    }
    
    @Test
    public void I_can_be_substracted_from_X() {
        String leftSymbol = "I";
        String rightSymbol = "X";
        
        boolean canBePlaced = canSubstractSymbol(leftSymbol, rightSymbol);
        
        assertThat(canBePlaced, is(true));
    }
    
    @Test
    public void X_can_be_substracted_from_L() {
        String leftSymbol = "X";
        String rightSymbol = "L";
        
        boolean canBePlaced = canSubstractSymbol(leftSymbol, rightSymbol);
        
        assertThat(canBePlaced, is(true));
    }
    
    @Test
    public void X_can_be_substracted_from_C() {
        String leftSymbol = "X";
        String rightSymbol = "C";
        
        boolean canBePlaced = canSubstractSymbol(leftSymbol, rightSymbol);
        
        assertThat(canBePlaced, is(true));
    }
    
    @Test
    public void C_can_be_substracted_from_D() {
        String leftSymbol = "C";
        String rightSymbol = "D";
        
        boolean canBePlaced = canSubstractSymbol(leftSymbol, rightSymbol);
        
        assertThat(canBePlaced, is(true));
    }
    
    @Test
    public void C_can_be_substracted_from_M() {
        String leftSymbol = "C";
        String rightSymbol = "M";
        
        boolean canBePlaced = canSubstractSymbol(leftSymbol, rightSymbol);
        
        assertThat(canBePlaced, is(true));
    }
    
    @Test
    public void symbol_can_be_placed_before_lower_or_equal_symbol() {
        boolean leftSymbolIsHigherOrEqualThanRightSymbol = true;
        
        boolean canBePlaced = leftSymbolIsHigherOrEqualThanRightSymbol;
        
        assertThat(canBePlaced, is(true));
    }
    
    @Test
    public void symbol_can_be_placed_before_substractable_symbol() {
        boolean leftSymbolCanBeSubstractedFromRightSymbol = true;
        
        boolean canBePlaced = leftSymbolCanBeSubstractedFromRightSymbol;
        
        assertThat(canBePlaced, is(true));
    }
    
    
    //~~~~~~~
        
    enum RomanSymbol {
        I(1, null),
        V(5, I),
        X(10,I),
        L(50, X),
        C(100, X),
        D(500, C),
        M(1000, C);
        
        int value;
        RomanSymbol substractionLiteral;

        public static RomanSymbol fromString(String symbol) {
            RomanSymbol chosenLiteral = null;
            for (RomanSymbol romanLiteral : RomanSymbol.values()) {
                if (romanLiteral.name().equals(symbol)) {
                    chosenLiteral = romanLiteral;
                }
            }
            return chosenLiteral;
        }
        
        private RomanSymbol(int value, RomanSymbol substractionLiteral) {
            this.value = value;
            this.substractionLiteral = substractionLiteral;
        }
        
        int getValue() {
            return value;
        }

        public boolean canSubstract(RomanSymbol literalToSubstract) {
            return substractionLiteral.equals(literalToSubstract);
        }
    }

    
    protected int valueOf(String symbol) {
        RomanSymbol romanLiteral = RomanSymbol.fromString(symbol);
        return romanLiteral.getValue();
    }

    
    
    protected boolean canSubstractSymbol(String leftSymbol, String rightSymbol) {
        RomanSymbol rightLiteral = RomanSymbol.fromString(rightSymbol);
        RomanSymbol leftLiteral = RomanSymbol.fromString(leftSymbol);
        
        return rightLiteral.canSubstract(leftLiteral);
    }
}