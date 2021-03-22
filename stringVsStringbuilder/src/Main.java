
public class Main {
    public static void main(String[] args) {
   /*     String res = "";
        long beforeConcatenation = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            res += "java";
        }
        long timeConcatenated = System.currentTimeMillis() - beforeConcatenation;
        System.out.println(timeConcatenated);*/

        ConcatenationTester ct = new ConcatenationTester(new StringBuilder());
        ConcatenationTester ct1 = new ConcatenationTester(new StringConcatenator());
        ct.test(10000, "JAVA");
        ct1.test(10000, "JAVA");
    }
}

//interface iConcantenator
//+concantenate(String[] strings);

//StringConcatenator implements Concatenator
//Stringbuilder implements Concatenator
//+concantenate();
//Stringbuffer implements Concatenator;
//+concantenate();
// ConcatenationTester
//-concatenator:Concatenator field/constructor
//+void test(int times, String text);
//this method should count the amount
// of miliseconds of concate n times
//-composeArray(int times, String text): String[]
