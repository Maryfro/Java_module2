package de.telran;

import static org.junit.jupiter.api.Assertions.*;

class LoanIssuerTest {

    LoanConsumer lc1 = new LoanConsumer("Ivan", 70, 25000);
    LoanConsumer lc2 = new LoanConsumer("Vasja", 49, 21000);
    LoanConsumer lc3 = new LoanConsumer("Petya", 15, 21000);
    LoanConsumer lc4 = new LoanConsumer("Max", 15, 19000);
    LoanConsumer lc5 = new LoanConsumer("Max", 18, 19999);
    LoanConsumer lc6 = new LoanConsumer("Max", 69, 20000);
    LoanConsumer lc7 = new LoanConsumer("Max", 69, 19999);
    LoanConsumer lc8 = new LoanConsumer("Max", 70, 19999);
    LoanConsumer lc9 = new LoanConsumer("Max", 50, 20000);
    LoanConsumer lc10 = new LoanConsumer("Max", 50, 19999);
    LoanIssuer li1 = new LoanIssuer("Boss", false, true);
    LoanIssuer li2 = new LoanIssuer("Boss2", true, true);
    LoanIssuer li3 = new LoanIssuer("Boss3", false, false);



    @org.junit.jupiter.api.Test
    void test_toIssue_LazyLoanIssuer_TrueCase() {
        assertTrue(li2.toIssue(lc2));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_LazyLoanIssuer_FalseCase_TwoConditions() {
        assertFalse(li2.toIssue(lc4));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_LazyLoanIssuer_FalseCase_Age() {
        assertFalse(li2.toIssue(lc3));
    }
    @org.junit.jupiter.api.Test
    void test_toIssue_LazyLoanIssuer_FalseCase_Income() {
        assertFalse(li2.toIssue(lc5));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_NotLazyAndKindLoanIssuer_TrueCase() {
        assertTrue(li1.toIssue(lc6));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_NotLazyAndKindLoanIssuer_FalseCase_Age() {
        assertFalse(li1.toIssue(lc1));
    }
    @org.junit.jupiter.api.Test
    void test_toIssue_NotLazyAndKindLoanIssuer_FalseCase_Income() {
        assertFalse(li1.toIssue(lc7));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_NotLazyAndKindLoanIssuer_FalseCase_TwoConditions() {
        assertFalse(li1.toIssue(lc8));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_NotLazyAndNotKindLoanIssuer_TrueCase() {
        assertTrue(li3.toIssue(lc2));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_NotLazyAndNotKindLoanIssuer_FalseCase_Age() {
        assertFalse(li3.toIssue(lc9));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_NotLazyAndNotKindLoanIssuer_FalseCase_Income() {
        assertFalse(li3.toIssue(lc5));
    }

    @org.junit.jupiter.api.Test
    void test_toIssue_NotLazyAndNotKindLoanIssuer_FalseCase_TwoConditions() {
        assertFalse(li3.toIssue(lc10));
    }
}