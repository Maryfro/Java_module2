package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IStringOperationTest {
    IStringOperation iStringOpUpper = new IStringOperation() {
        @Override
        public String operate(String input) {
            return input.toUpperCase();
        }

        @Override
        public String getName() {
            return "upper_case";
        }
    };

    IStringOperation iStringOpLower = new IStringOperation() {
        @Override
        public String operate(String input) {
            return input.toLowerCase();
        }

        @Override
        public String getName() {
            return "lower_case";
        }
    };


    @Test
    public void test_operate_UpperCase() {
        assertEquals("HELLO", iStringOpUpper.operate("hello"));
    }

    @Test
    public void test_getName_UpperCase() {
        assertEquals("upper_case", iStringOpUpper.getName());
    }

    @Test
    public void test_operate_LowerCase() {
        assertEquals("hello", iStringOpLower.operate("HELLO"));
    }

    @Test
    public void test_getName_LowerCase() {
        assertEquals("lower_case", iStringOpLower.getName());
    }

}