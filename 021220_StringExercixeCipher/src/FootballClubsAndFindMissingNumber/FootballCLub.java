package FootballClubsAndFindMissingNumber;


import java.util.*;

public class FootballCLub {

    String country;
    String name;
    int achievedPoints;

    public FootballCLub(String country, String name, int achievedPoints) {
        this.country = country;
        this.name = name;
        this.achievedPoints = achievedPoints;
    }


    @Override
    public String toString() {
        return "FootballCLub{" +
                "country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", achievedPoints=" + achievedPoints +
                '}';
    }
// TODO there is a list of clubs. We need to order clubs in such way:
// countries are ordered alphabetically, and then according to points
// * Austria, 100 points, Austria 80 points, Belgium 100 points, Belgium 85 points

// pattern comparator

}