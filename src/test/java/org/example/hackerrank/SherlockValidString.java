package org.example.hackerrank;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SherlockValidString {
    public static final String YES = "YES";
    public static final String NO = "NO";

    @Test
    public void sherlockTest() {
        String result = "";
        result = isValid("abc");
        assertEquals(YES, result);

        result = isValid("abbccc");
        assertEquals(NO, result);

        result = isValid("aabbcd");
        assertEquals(NO, result);

        result = isValid("aabbccddeefghi");
        assertEquals(NO, result);

        result = isValid("abcdefghhgfedecba");
        assertEquals(YES, result);
        result = isValid("aaaabbcc");
        assertEquals(NO, result);

        result = isValid("aaaaabc");
        assertEquals(NO, result);

        result = isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd");
        assertEquals(YES, result);

        result = isValid("xxxaabbccrry");
        assertEquals(NO, result);

        result = isValid("abbccc");
        assertEquals(NO, result);
    }

    static String isValid(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());

        Collections.sort(values);
        int minValue = values.get(0);
        int maxValue = values.get(values.size() - 1);
        if (minValue == maxValue) {
            return "YES";
        }

        Map<Integer, Long> valueGroup = values.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (minValue == 1 && valueGroup.get(1) == 1 && valueGroup.keySet().size() == 2) {
            return "YES";

        }
        if (valueGroup.get(maxValue) == 1 && maxValue - minValue == 1) {
            return "YES";
        }
        return "NO";
    }

    static String isValid1(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        int minValue = values.get(0);
        int maxValue = values.get(values.size() - 1);
        if (minValue == maxValue) {
            return "YES";
        }

        Map<Integer, Long> valueGroup = values.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int maxCount = (int) values.stream().filter(i -> i == maxValue).count();
        int minCount = (int) values.stream().filter(i -> i == minValue).count();

        if ((maxCount == 1 && maxValue - minValue == 1)) {
            return "YES";
        }
        if (minCount == 1 && minValue == 1) {
            return "YES";
        }

        return "NO";

    }

    @Test
    public void groupByTest() {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(1);
        lst.add(3);

        Map<Integer, Long> collect = lst.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        assertEquals(1, 1);
    }
}
