package com.pal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * ( number 2 would have letters -- a,b,c
 * 3 would have -- d,e,f
 * and so on...
 * )
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class LetterCombiPhoneNumber {
    static Map<Character, String> letterMap = new HashMap<>();

    public static void main(String[] args) {
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");

        String digits = "";
        LetterCombiPhoneNumber classObj = new LetterCombiPhoneNumber();
        List<String> resultList = classObj.letterCombinations(digits);
        System.out.println("result=" + resultList);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!(digits.length() > 0 && digits.length() <= 4))
            return result;

        char[] digitsArr = digits.toCharArray();
        List<String> listOfLetters = new ArrayList<>();

        for (char ch : digitsArr) {
            listOfLetters.add(letterMap.get(ch));
        }

        getCombination("", listOfLetters, 0, result);
        System.out.println(result);

        return result;
    }

    private void getCombination(String letter, List<String> listOfLetters, int nxt, List<String> result) {
        if (nxt < listOfLetters.size()) {
            char[] letters = listOfLetters.get(nxt).toCharArray();
            for (int i = 0; i < letters.length; i++) {
                getCombination(letter + letters[i] + "", listOfLetters, nxt + 1, result);
            }
        } else {
            result.add(letter);
        }

        return;
    }

}
