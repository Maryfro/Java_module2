package telran.controller;

import telran.data.TransformerRuleLength3;
import telran.data.TransformerRuleLength4;
import telran.data.TransformerRulesStars;
import telran.data.WordTransformer;

public class App {
    public static void main(String[] args) {
        //System.out.println(WordTransformer.transformWord(" sdfl WEk serI jhg"));
        //System.out.println(WordTransformer.transformWord1((" sERl WEk SErI jhg"), 2));

        TransformerRuleLength3 tr3 = new TransformerRuleLength3();
        TransformerRuleLength3 tr4 = new TransformerRuleLength4();


        System.out.println(WordTransformer.WordTransformNew("asd sdf fdg", tr3));
        System.out.println(WordTransformer.WordTransformNew("asd ASDF GHGF sdf fdg", tr4));
        System.out.println(WordTransformer.WordTransformNew("asd ASDF GHGFdf sdf fdg", new TransformerRulesStars()));

    }
}
