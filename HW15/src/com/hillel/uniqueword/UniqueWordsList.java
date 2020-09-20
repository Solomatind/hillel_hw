package com.hillel.uniqueword;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UniqueWordsList {
    
    private HashMap<String, Integer> uniqueWords;
    
    public void readWords(File wordsFile) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();
        Scanner scanner = new Scanner(wordsFile);
        while(scanner.hasNext()) {
            words.add(scanner.next());
        }
        scanner.close();
        makeUniqueWords(words);
    }
    
    private void makeUniqueWords(ArrayList<String> words) {
        uniqueWords = new HashMap<>();
        for (String word : words) {
            if (uniqueWords.keySet().contains(word)) {
                uniqueWords.put(word, uniqueWords.get(word) + 1);
            } else {
                uniqueWords.put(word, 1);
            }
        }
    }
    
    public HashMap<String, Integer> getUniqueWords() {
        return uniqueWords;
    }

}
