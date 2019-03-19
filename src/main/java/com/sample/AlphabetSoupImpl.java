package com.sample;

import java.util.Arrays;

/**
 * Created by RAJESH on 3/17/2019.
 */
public class AlphabetSoupImpl implements AlphabetSoupIntr {

    /**
     * checks if the letters in the soup can be used to make the given message.
     * @param message the message which can be made from the bowl.
     * @param bowl the letters in the bowl.
     * @return true if the word can be made.
     */
    public boolean isMessageFound(String message, String bowl) {
        if (isEmpty(message) || isEmpty(bowl))
            return false;

        message = message.replaceAll("\\s", "");
        bowl = bowl.replaceAll("\\s", "");

        char[] messageChars = message.toCharArray();
        char[] bowlChars = bowl.toCharArray();

        Arrays.sort(messageChars);
        Arrays.sort(bowlChars);

        for (char c : messageChars) {
            int binarySearchResult = Arrays.binarySearch(bowlChars, c);
            if (binarySearchResult < 0) {
                return false;
            } else {
                bowlChars[binarySearchResult] = '\u0000';
            }
        }

        return true;
    }

    private boolean isEmpty(String string) {

        return string == null || string.trim().equals("");
    }

}
