import static org.junit.jupiter.api.Assertions.*;

class CipherTest {

    Cipher cipher = new Cipher();

    @org.junit.jupiter.api.Test
    void toCipher_emptyInput() {
        assertEquals("", cipher.toCipher(""));
    }

    @org.junit.jupiter.api.Test
    void toCipher_NonRepeatingLetters() {
        assertEquals("abcd", cipher.toCipher("abcd"));
    }

    @org.junit.jupiter.api.Test
    void toCipher_RepeatingLetters() {
        assertEquals("a3b2cd4", cipher.toCipher("aaabbcdddd"));
    }
}