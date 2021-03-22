package FootballClubsAndFindMissingNumber;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FootballCLubTest {


    @Test
    public void test_compare() {
        FootballCLub arsenal = new FootballCLub("England", "Arsenal", 9);
        FootballCLub bayern = new FootballCLub("Germany", "Bayern", 6);
        FootballCLub chelsea = new FootballCLub("England", "Chelsea", 16);
        FootballCLub borussia = new FootballCLub("Germany", "Borussia", 12);
        FootballCLub atletico = new FootballCLub("Spain", "Atletico", 4);
        FootballCLub barcelona = new FootballCLub("Spain", "Barcelona", 5);
        List<FootballCLub> clubs = new ArrayList<>();
        Collections.addAll(clubs, arsenal, bayern, chelsea, borussia, atletico, barcelona);
        clubs.sort(new Comparator<FootballCLub>() {
            @Override
            public int compare(FootballCLub o1, FootballCLub o2) {
                if (o1.country.equals(o2.country))
                    return -(o1.achievedPoints - o2.achievedPoints);
                else
                    return o1.country.compareTo(o2.country);
            }
        });
        List<FootballCLub> exp = new ArrayList<>();
        Collections.addAll(exp, chelsea, arsenal, borussia, bayern, barcelona, atletico);
        assertEquals(exp, clubs);
    }
}