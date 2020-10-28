package telran.robot;

public class RobotApp {
    public static void main(String[] args) {
        Body body = new Body();
        SmallHead smallHead = new SmallHead();
        MediumHead mediumHead = new MediumHead();
        BigHead bigHead = new BigHead();
        Foot foot = new Foot();
        //Robot robotNew = new Robot(body, foot);// generic type allows adding other objects

        Robot robot = new Robot(body, smallHead);
        ((SmallHead) robot.getHead()).talk();

        Robot<SmallHead> robot1 = new Robot<>(body, smallHead);
        robot1.getHead().talk();
        Robot<MediumHead> robot2 = new Robot<>(body, mediumHead);
        robot2.getHead().look();
        Robot<BigHead> robot3 = new Robot<>(body, bigHead);
        robot3.getHead().burn();
    }
}
