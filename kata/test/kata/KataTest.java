/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class KataTest {
    public static final String OPEN = "open";
    public static final String SPARE = "spare";
    public static final String STRIKE = "strike";
    public static final int PLAIN_ROLL = 1;
    public static final int NOT_TEN = 9;
    public static final int TEN = 10;
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void score_of_a_frame_equals_sum_of_frame_rolls_plus_the_value_of_bonus_rolls() {
        int sumOfFrameRolls = PLAIN_ROLL;
        int valueOfBonusRolls = 2;
        
        int scoreOfFrame = sumOfFrameRolls + valueOfBonusRolls;
        
        assertThat(scoreOfFrame, is(sumOfFrameRolls+valueOfBonusRolls));
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void bonus_score_for_spare_equals_score_of_next_roll() {
        String frameType = SPARE;
        int scoreOfNextRoll = PLAIN_ROLL;
        
        int bonusScoreForSpare = scoreOfNextRoll;
        
        assertThat(bonusScoreForSpare, is(scoreOfNextRoll));
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void bonus_score_for_strike_equals_score_of_next_two_rolls() {
        String frameType = STRIKE;
        int scoreOfNextTwoRolls = PLAIN_ROLL;
        
        int bonusScoreForStrike = scoreOfNextTwoRolls;
        
        assertThat(bonusScoreForStrike, is(scoreOfNextTwoRolls));
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void no_bonus_score_for_open_frame() {
        String frameType = OPEN;
        
        int bonusScoreOfOpenFrame = 0;
        
        assertThat(bonusScoreOfOpenFrame, is(0));
    }
    
    @Test
    public void score_for_roll_equals_number_of_pins_for_roll() {
        int numberOfPins = 2;
        
        int scoreOfRoll = numberOfPins;
                
        assertThat(scoreOfRoll, equalTo(numberOfPins));
    }
    
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void a_frame_is_strike_if_first_roll_is_ten() {
        int valueOfFirstRoll = TEN;
        int sumOfFrameRolls = TEN;
        
        String frameType = getFrameType(valueOfFirstRoll, sumOfFrameRolls);
        
        assertThat(frameType, is(STRIKE));
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void a_frame_is_spare_if_first_roll_is_not_ten_and_sum_of_rolls_equals_ten() {
        int valueOfFirstRoll = NOT_TEN;
        int sumOfFrameRolls = TEN;
        
        String frameType = getFrameType(valueOfFirstRoll, sumOfFrameRolls);
        
        assertThat(frameType, is(SPARE));
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void a_frame_is_open_frame_if_first_roll_is_not_ten_and_sum_of_rolls_different_than_ten() {
        int valueOfFirstRoll = PLAIN_ROLL;
        int sumOfFrameRolls = NOT_TEN;
        
        String frameType = getFrameType(valueOfFirstRoll, sumOfFrameRolls);
        
        assertThat(frameType, is(OPEN));
    }
    
    
    @Test
    public void sum_of_rolls_equals_sum_of_first_and_second_roll() {
        int valueOfFirstRoll = PLAIN_ROLL;
        int valueOfSecondRoll = PLAIN_ROLL;
        
        int sumOfFrameRolls = valueOfFirstRoll + valueOfSecondRoll;
        
        assertThat(sumOfFrameRolls, is(valueOfFirstRoll + valueOfSecondRoll));
    }
    
    @Test
    public void a_open_frame_has_two_rolls() {
        String frameType = OPEN;
        
        int numberOfRolls = 2;
        
        assertThat(numberOfRolls, is(2));
    }
    
    @Test
    public void a_spare_frame_has_two_rolls() {
        String frameType = SPARE;
        
        int numberOfRolls = 2;
        
        assertThat(numberOfRolls, is(2));
    }
    
    @Test
    public void a_strike_frame_has_one_roll() {
        String frameType = STRIKE;
        
        int numberOfRolls = 1;
        
        assertThat(numberOfRolls, is(1));
    }
    
    
    
    //~~~~~~~~~~~
    
    protected String getFrameType(int valueOfFirstRoll, int sumOfFrameRolls) {
        String frameType = OPEN;
        if (sumOfFrameRolls == 10) {
            if (valueOfFirstRoll == 10) {
                frameType = STRIKE;
            } else {
                frameType = SPARE;
            }
        }
        return frameType;
    }
}