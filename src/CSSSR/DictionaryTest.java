/**
 * @author Vadim Naumov
 */

package CSSSR;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class DictionaryTest {

    @Test
    void transform1() {
        String text = "сапог сарай арбуз болт бокс биржа";
        Map<Character, Set<String>> actual = Dictionary.transform(text);

        Character c = 'с';
        Character b = 'б';
        Set<String> setC = new LinkedHashSet<>(Arrays.asList("сапог", "сарай"));
        Set<String> setB = new LinkedHashSet<>(Arrays.asList("биржа", "бокс", "болт"));

        Map<Character, Set<String>> expected = new TreeMap<>();
        expected.put(c, setC);
        expected.put(b, setB);

        assertEquals(expected, actual);
    }

    @Test
    void transform2() {
        String text = "бревно баран барак бурундук бокс бриз бок брат " +
                "бук борт бак броненосец буржуа арбуз болт бокс биржа";
        Map<Character, Set<String>> actual = Dictionary.transform(text);

        Set<String> expected = new LinkedHashSet<>(Arrays.asList("броненосец", "бурундук", "бревно",
                "буржуа", "барак", "баран", "биржа", "бокс", "болт", "борт",
                "брат", "бриз", "бак", "бок", "бук"));

        assertEquals(Collections.addAll(expected), Collections.addAll(actual.values()));
    }

    @Test
    void transform3() {
        String text = "hi man алыча бурундук бриз борт броненосец 65 арбуз слива фин";
        Map<Character, Set<String>> actual = Dictionary.transform(text);

        Character a = 'а';
        Character b = 'б';
        Set<String> setA = new LinkedHashSet<>(Arrays.asList("алыча", "арбуз"));
        Set<String> setB = new LinkedHashSet<>(Arrays.asList("бурундук", "броненосец", "борт", "бриз"));

        Map<Character, Set<String>> expected = new TreeMap<>();
        expected.put(a, setA);
        expected.put(b, setB);

        assertEquals(expected, actual);
    }

    @Test
    void transform4() {
        String text = "hi man ! yes";
        Map<Character, Set<String>> actual = Dictionary.transform(text);
        Map<Character, Set<String>> expected = new TreeMap<>();

        assertEquals(expected, actual);
    }

    @Test
    void transform5() {
        String text = "";
        Map<Character, Set<String>> actual = Dictionary.transform(text);
        Map<Character, Set<String>> expected = new TreeMap<>();

        assertEquals(expected, actual);
    }

    @Test
    void transform6() {
        String text = null;
        Map<Character, Set<String>> actual = Dictionary.transform(text);
        Map<Character, Set<String>> expected = new TreeMap<>();

        assertEquals(expected, actual);
    }

    @Test
    void transform7() {
        String text = "аз буки веди глаголь";
        Map<Character, Set<String>> actual = Dictionary.transform(text);
        Map<Character, Set<String>> expected = new TreeMap<>();

        assertEquals(expected, actual);
    }

    @Test
    void transform8() {
        String text = "аз буки веди глаголь гораций";
        Map<Character, Set<String>> actual = Dictionary.transform(text);

        Character g = 'г';
        Set<String> setG = new LinkedHashSet<>(Arrays.asList("глаголь", "гораций"));

        Map<Character, Set<String>> expected = new TreeMap<>();
        expected.put(g, setG);

        assertEquals(expected, actual);
    }
}