package com.hillel.regexalgorithms.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAlgorithm {

    private String inputText;

    public TextAlgorithm(String inputText) {
        this.inputText = inputText;
    }

    public Map<String, Integer> countOfWords() {
        Pattern uniqWord = Pattern.compile("(\\b\\w+\\b)(?![\\s\\S]*\\b\\1\\b)");
        Matcher uniqWords = uniqWord.matcher(inputText);
        Map<String, Integer> result = new HashMap<>();
        while (uniqWords.find()) {
            Pattern word = Pattern.compile("\\b" + uniqWords.group() + "\\b");
            Matcher foundWordToCount = word.matcher(inputText);
            int count = (int) foundWordToCount.results().count();
            result.put(uniqWords.group(), count);
        }
        return result;
    }

    public String replaceChar(int k, char s) {
        return inputText.replaceAll(String.format("(\\b\\w{%d})\\w", k - 1), "$1" + s);
    }

    public String uniqWordsWithSameBeginAndEnd() {
        Pattern uniqWordWithSame = Pattern.compile("(\\b(?<fstLet>\\w)\\w+\\k<fstLet>\\b)(?![\\s\\S]*\\b\\1\\b)");
        Matcher uniqWordsWithSame = uniqWordWithSame.matcher(inputText);
        StringBuilder result = new StringBuilder();
        while (uniqWordsWithSame.find()) {
            result.append(uniqWordsWithSame.group() + " ");
        }
        return result.toString();
    }

    public int countOfPunctMarks() {
        Pattern punctMark = Pattern.compile("\\p{P}");
        Matcher punctMarks = punctMark.matcher(inputText);
        return (int) punctMarks.results().count();
    }

    public String getInputText() {
        return inputText;
    }

}
