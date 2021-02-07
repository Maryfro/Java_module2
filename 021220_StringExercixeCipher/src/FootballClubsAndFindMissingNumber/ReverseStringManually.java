package FootballClubsAndFindMissingNumber;

public class ReverseStringManually {

    //reverse a string without using a reverse method

    public String reverseString(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output += input.charAt(input.length() - 1 - i);
        }
        return output;
    }
}
