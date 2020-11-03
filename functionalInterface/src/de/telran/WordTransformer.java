package de.telran;

@FunctionalInterface
public interface WordTransformer {
    String transform(String word);
}
