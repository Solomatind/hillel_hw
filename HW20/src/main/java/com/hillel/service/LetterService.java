package com.hillel.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterService {

    public String findLetter(String word) {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("words.txt");
        String words = null;
        try {
            words = new String(stream.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern wordToFind = Pattern.compile(word);
        Matcher wordsList = wordToFind.matcher(words);
        int count = 0;
        while (wordsList.find()) {
            count++;
        }
        if (count == 0) {
            return "There is no word \"" + word + "\" in text \"" + words + "\"";
        } else {
            return "The word \"" + word + "\" is present in the text \"" + words + "\" by " + count + " times";
        }
    }

}
