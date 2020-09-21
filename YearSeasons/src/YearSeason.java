public enum YearSeason {
    SPRING(18),
    SUMMER(26),
    FALL(15),
    WINTER(10);

    private int middleTemp;

    YearSeason(int middleTemp) {
        this.middleTemp = middleTemp;
    }

    public void clothingChoice() {
        switch (this) {
            case SPRING:
                System.out.println("sweater");
                break;
            case SUMMER:
                System.out.println("dress");
                break;
            case FALL:
                System.out.println("rain coat");
                break;
            case WINTER:
                System.out.println("jacket");
        }
    }

    public static void main(String[] args) {
        YearSeason spring = YearSeason.SPRING;
        spring.clothingChoice();
        System.out.println(spring.middleTemp);
        System.out.println(YearSeason.FALL.middleTemp);

        int sum = 0;
        for (int i = 0; i < YearSeason.values().length; i++) {
            sum = sum +  YearSeason.values()[i].middleTemp;
        }
        sum = sum / 4;
        System.out.println( "Middle " + sum);
    }
}
