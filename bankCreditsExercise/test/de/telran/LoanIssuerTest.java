package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanIssuerTest {

    LoanConsumer lc1 = new LoanConsumer("Ivan", 71, 25000);
    LoanConsumer lc2 = new LoanConsumer("Vasja", 50, 21000);
    LoanConsumer lc3 = new LoanConsumer("Petya", 15, 21000);
    LoanConsumer lc4 = new LoanConsumer("Max", 15, 19000);
    LoanConsumer lc5 = new LoanConsumer("Max", 18, 19999);
    LoanConsumer lc6 = new LoanConsumer("Max", 70, 20000);
    LoanConsumer lc7 = new LoanConsumer("Max", 70, 19999);
    LoanConsumer lc8 = new LoanConsumer("Max", 70, 19999);
    LoanConsumer lc9 = new LoanConsumer("Max", 51, 20000);
    LoanConsumer lc10 = new LoanConsumer("Max", 51, 19999);
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

    @Test
    public void testToIssue_lazyAndKindIssuer_providesEverybodyOlder18AndEarningMoreOrEqualThan20000() {
        LoanIssuer issuer = new LoanIssuer("Vasily", true, true);

        LoanConsumer customerMiddleAged = new LoanConsumer("Arkady", 35, 20000);
        LoanConsumer customerOlderAged = new LoanConsumer("Fuka", 50, 20000);
        LoanConsumer customerOlderAgedOlder = new LoanConsumer("Varlam", 55, 20000);
        LoanConsumer customerSenior = new LoanConsumer("Karp", 70, 20000);
        LoanConsumer customerUndead = new LoanConsumer("Koschey", 200, 20000);

        assertTrue(issuer.toIssue(customerMiddleAged));
        assertTrue(issuer.toIssue(customerOlderAged));
        assertTrue(issuer.toIssue(customerOlderAgedOlder));
        assertTrue(issuer.toIssue(customerSenior));
        assertTrue(issuer.toIssue(customerUndead));
    }

    @Test
    public void testToIssue_lazyAndEvilIssuer_providesEverybodyOlder18AndEarningMoreOrEqualThan20000() {
        LoanIssuer issuer = new LoanIssuer("Vasily", true, false);

        LoanConsumer customerMiddleAged = new LoanConsumer("Arkady", 35, 20000);
        LoanConsumer customerOlderAged = new LoanConsumer("Fuka", 50, 20000);
        LoanConsumer customerOlderAgedOlder = new LoanConsumer("Varlam", 55, 20000);
        LoanConsumer customerSenior = new LoanConsumer("Karp", 70, 20000);
        LoanConsumer customerUndead = new LoanConsumer("Koschey", 200, 20000);

        assertTrue(issuer.toIssue(customerMiddleAged));
        assertTrue(issuer.toIssue(customerOlderAged));
        assertTrue(issuer.toIssue(customerOlderAgedOlder));
        assertTrue(issuer.toIssue(customerSenior));
        assertTrue(issuer.toIssue(customerUndead));
    }

    @Test
    public void testToIssue_lazyAndEvilIssuer_notProvidesEverybodyOlder18AndEarningLessThan20000() {
        LoanIssuer issuer = new LoanIssuer("Vasily", false, true);

        LoanConsumer customerMiddleAged = new LoanConsumer("Arkady", 35, 19999);
        LoanConsumer customerOlderAged = new LoanConsumer("Fuka", 50, 19999);
        LoanConsumer customerOlderAgedOlder = new LoanConsumer("Varlam", 55, 19000);
        LoanConsumer customerSenior = new LoanConsumer("Karp", 70, 19000);
        LoanConsumer customerUndead = new LoanConsumer("Koschey", 200, 19000);

        assertFalse(issuer.toIssue(customerMiddleAged));
        assertFalse(issuer.toIssue(customerOlderAged));
        assertFalse(issuer.toIssue(customerOlderAgedOlder));
        assertFalse(issuer.toIssue(customerSenior));
        assertFalse(issuer.toIssue(customerUndead));
    }

    @Test
    public void testToIssue_lazyAndKindIssuer_notProvidesEverybodyOlder18AndEarningLessThan20000() {
        LoanIssuer issuer = new LoanIssuer("Vasily", true, true);

        LoanConsumer customerMiddleAged = new LoanConsumer("Arkady", 35, 19999);
        LoanConsumer customerOlderAged = new LoanConsumer("Fuka", 50, 19999);
        LoanConsumer customerOlderAgedOlder = new LoanConsumer("Varlam", 55, 19000);
        LoanConsumer customerSenior = new LoanConsumer("Karp", 70, 19000);
        LoanConsumer customerUndead = new LoanConsumer("Koschey", 200, 19000);

        assertFalse(issuer.toIssue(customerMiddleAged));
        assertFalse(issuer.toIssue(customerOlderAged));
        assertFalse(issuer.toIssue(customerOlderAgedOlder));
        assertFalse(issuer.toIssue(customerSenior));
        assertFalse(issuer.toIssue(customerUndead));
    }

    @Test
    public void testToIssue_lazyAndKindIssuer_notProvidesEverybodyYounger18() {
        LoanIssuer issuer = new LoanIssuer("Vasily", true, true);

        LoanConsumer customerYoungFewGold = new LoanConsumer("Arkady", 17, 19999);
        LoanConsumer customerYoungNormalGold = new LoanConsumer("Arkady", 17, 21000);

        assertFalse(issuer.toIssue(customerYoungFewGold));
        assertFalse(issuer.toIssue(customerYoungNormalGold));
    }

    @Test
    public void testToIssue_lazyAndEvilIssuer_notProvidesEverybodyYounger18() {
        LoanIssuer issuer = new LoanIssuer("Vasily", false, true);

        LoanConsumer customerYoungFewGold = new LoanConsumer("Arkady", 17, 19999);
        LoanConsumer customerYoungNormalGold = new LoanConsumer("Arkady", 17, 21000);

        assertFalse(issuer.toIssue(customerYoungFewGold));
        assertFalse(issuer.toIssue(customerYoungNormalGold));
    }

    @Test
    public void testToIssue_activeAndEvilIssuer_provides() {
        LoanIssuer issuer = new LoanIssuer("Vasily", false, false);

        LoanConsumer customerMiddleAged = new LoanConsumer("Arkady", 25, 20000);
        LoanConsumer customerAlmostOlderAged = new LoanConsumer("Arkady Georgievich", 49, 25000);

        assertTrue(issuer.toIssue(customerMiddleAged));
        assertTrue(issuer.toIssue(customerAlmostOlderAged));
    }

    @Test
    public void testToIssue_activeAndEvilIssuer_notProvides() {
        LoanIssuer issuer = new LoanIssuer("Vasily", false, false);

        LoanConsumer customerMiddleAgedFewGold = new LoanConsumer("Arkady", 25, 19999);
        LoanConsumer customerAlmostOlderAgedFewGold = new LoanConsumer("Arkady Georgievich", 49, 19999);
        LoanConsumer customerOlderAgedFewGold = new LoanConsumer("Arkady Georgievich", 50, 19999);
        LoanConsumer customerSeniorFewGold = new LoanConsumer("Arkady Georgievich", 70, 19999);

        LoanConsumer customerYoungButReach = new LoanConsumer("Arkady Junior", 17, 25000);
        LoanConsumer customerOlderNormalGold = new LoanConsumer("Arkady Georgievich", 51, 25000);

        assertFalse(issuer.toIssue(customerMiddleAgedFewGold));
        assertFalse(issuer.toIssue(customerAlmostOlderAgedFewGold));
        assertFalse(issuer.toIssue(customerOlderAgedFewGold));
        assertFalse(issuer.toIssue(customerOlderNormalGold));
        assertFalse(issuer.toIssue(customerSeniorFewGold));
        assertFalse(issuer.toIssue(customerYoungButReach));
    }

    @Test
    public void testToIssue_activeAndKindIssuer_provides() {
        LoanIssuer issuer = new LoanIssuer("Vasily", true, false);

        LoanConsumer customerMiddleAged = new LoanConsumer("Arkady", 25, 20000);
        LoanConsumer customerAlmostOlderAged = new LoanConsumer("Arkady Georgievich", 49, 25000);
        LoanConsumer customerOlderAged = new LoanConsumer("Arkady Georgievich", 69, 25000);

        assertTrue(issuer.toIssue(customerMiddleAged));
        assertTrue(issuer.toIssue(customerAlmostOlderAged));
        assertTrue(issuer.toIssue(customerOlderAged));
    }

    @Test
    public void testToIssue_activeAndKindIssuer_notProvides() {
        LoanIssuer issuer = new LoanIssuer("Vasily", false, false);

        LoanConsumer customerMiddleAgedFewGold = new LoanConsumer("Arkady", 25, 19999);
        LoanConsumer customerAlmostOlderAgedFewGold = new LoanConsumer("Arkady Georgievich", 49, 19999);
        LoanConsumer customerOlderAgedFewGold = new LoanConsumer("Arkady Georgievich", 50, 19999);
        LoanConsumer customerSeniorFewGold = new LoanConsumer("Arkady Georgievich", 70, 19999);

        LoanConsumer customerYoungButReach = new LoanConsumer("Arkady Junior", 17, 25000);
        LoanConsumer customerOlderNormalGold = new LoanConsumer("Arkady Georgievich", 70, 25000);


        assertFalse(issuer.toIssue(customerMiddleAgedFewGold));
        assertFalse(issuer.toIssue(customerAlmostOlderAgedFewGold));
        assertFalse(issuer.toIssue(customerOlderAgedFewGold));
        assertFalse(issuer.toIssue(customerOlderNormalGold));
        assertFalse(issuer.toIssue(customerSeniorFewGold));
        assertFalse(issuer.toIssue(customerYoungButReach));
    }
}




