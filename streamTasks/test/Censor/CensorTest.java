package Censor;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;



class CensorTest {

    Censor censor = new Censor(new HashSet<>(Arrays.asList("fuck", "bitch", "suck")));

    @Test
    public void verify_trueCase(){
        assertTrue(censor.verify("Hello my dear, you rock as joke"));
    }

    @Test
    public void verify_falseCase(){
        assertFalse(censor.verify("Hello bitch, you suck as fuck"));
    }

    @Test
    public void verify_falseCase_oneWord(){
        assertFalse(censor.verify("And she walk like a bad bitch talk like a bad"));
    }

    @Test
    public void verify_falseCase_oneWord_UpperCase(){
        assertFalse(censor.verify("It's Britney, Bitch"));
    }

}