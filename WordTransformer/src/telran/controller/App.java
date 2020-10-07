package telran.controller;

import telran.data.*;

public class App {
    public static void main(String[] args) {
        //System.out.println(WordTransformer.transformWord(" sdfl WEk serI jhg"));
        //System.out.println(WordTransformer.transformWord1((" sERl WEk SErI jhg"), 2));

        TransformToUpperCase tr3 = new TransformToUpperCase();
        TransformToLowerCase tr4 = new TransformToLowerCase();
        WordsChecker tr6 = new ReplaceWithStars();

        System.out.println(WordsTransformer.WordTransformNew("asd ASDF GHGFdf sdf fdg", tr3));
        System.out.println(WordsTransformer.WordTransformNew("asd ASDF GHGFdf sdf fdg", tr4));
        System.out.println(WordsTransformer.WordTransformNew("asd ASDF GHGFdf sdf fdg", tr6));

        System.out.println("---------------------------------");

        WordsChecker[] wordcheckers = {tr3, tr4, tr6};
        System.out.println(WordsTransformer.WordTransformAllActions("asd sdf fdg", wordcheckers));
        System.out.println(WordsTransformer.WordTransformAllActions("asd ASDF GHGF sdf fdg", wordcheckers));
        System.out.println(WordsTransformer.WordTransformAllActions("asd ASDF GHGFdf sdf fdg", wordcheckers));

    }
}
