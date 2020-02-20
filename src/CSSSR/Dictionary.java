/**
 *
 * @author Vadim Naumov
 */

package CSSSR;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        Map<Character, Set<String>> data = transform(text);
        System.out.println(data);
    }

    public static Map<Character, Set<String>> transform(String text) {

        List<String> stringList;
        Map<Character, Set<String>> dictionary = new TreeMap<>();

        //преобразуем текст в отдельные слова (только кириллица)
        stringList = Arrays.asList(text.toLowerCase().split("[^А-Яа-я]+"));

        //группируем слова по первой букве в слове
        for (String element : stringList) {

            char letter = element.charAt(0);

            if (!dictionary.containsKey(letter)) {

                //если данной буквы нет в словаре то заводим новую группу
                //компаратор сравнивает по количеству символов и алфавитному порядку
                Set<String> set = new TreeSet<>((s, f) -> {
                    if (s.length() == f.length()) {
                        return s.compareTo(f);
                    } else {
                        return Integer.compare(f.length(), s.length());
                    }
                });
                set.add(element);
                dictionary.put(letter, set);

            } else {
                dictionary.get(letter).add(element);
            }
        }

        //оставляем группы, содержащие более одного элемента
        dictionary.entrySet().removeIf(entry -> entry.getValue().size() == 1);
        return dictionary;
    }
}