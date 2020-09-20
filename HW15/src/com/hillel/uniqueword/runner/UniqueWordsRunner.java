package com.hillel.uniqueword.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import com.hillel.uniqueword.UniqueWordsList;

public class UniqueWordsRunner {
    
    public static void main(String[] args) {
        UniqueWordsList wordsList = new UniqueWordsList();
        try {
            wordsList.readWords(new File("words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> result = new HashMap<>();
        result = wordsList.getUniqueWords();
        System.out.println(result);
    }

}
