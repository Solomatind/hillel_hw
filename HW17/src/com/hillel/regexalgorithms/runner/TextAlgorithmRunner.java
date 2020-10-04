package com.hillel.regexalgorithms.runner;

import com.hillel.regexalgorithms.engine.TextAlgorithm;

public class TextAlgorithmRunner {
    public static void main(String[] args) {
        String input = "A system of cells interlinked within cells, interlinked within cells, interlinked within one stem. tenet, tnt, tenet";
        TextAlgorithm textAlgorithm = new TextAlgorithm(input);
        System.out.println(textAlgorithm.countOfWords());
        System.out.println(textAlgorithm.replaceChar(3, '2'));
        System.out.println(textAlgorithm.uniqWordsWithSameBeginAndEnd());
        System.out.println("Count of punct marks = " + textAlgorithm.countOfPunñtMarks());
    }

}
