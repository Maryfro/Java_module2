package telran.controller;

import telran.data.*;

public class App {
    public static void main(String[] args) {
        //System.out.println(WordTransformer.transformWord(" sdfl WEk serI jhg"));
        //System.out.println(WordTransformer.transformWord1((" sERl WEk SErI jhg"), 2));

        TransformerRuleLength3 tr3 = new TransformerRuleLength3();
        TransformerRuleLength4 tr4 = new TransformerRuleLength4();
        Transformable tr6 = new TransformerRulesLength6();

        System.out.println(WordTransformer.WordTransformNew("asd sdf fdg", tr3));
        System.out.println(WordTransformer.WordTransformNew("asd ASDF GHGF sdf fdg", tr4));
        System.out.println(WordTransformer.WordTransformNew("asd ASDF GHGFdf sdf fdg", tr6));

       /* System.out.println("---------------------------------");

        Transformable[] transformables = {tr3, tr4, tr6};
        System.out.println(WordTransformer.WordTransformAllActions("asd sdf fdg", transformables));
        System.out.println(WordTransformer.WordTransformAllActions("asd ASDF GHGF sdf fdg", transformables));
        System.out.println(WordTransformer.WordTransformAllActions("asd ASDF GHGFdf sdf fdg", transformables));*/

    }
}
