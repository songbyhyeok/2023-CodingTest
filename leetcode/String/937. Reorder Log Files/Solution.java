import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();        

        for(String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }

        // Collections.sort(letters, new Comparator<String>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         String[] s1x = s1.split("", 2);
        //         String[] s2x = s2.split("", 2);

        //         final int compared = s1x[1].compareTo(s2x[1]);
        //         if (compared == 0) {
        //             return s1x[0].compareTo(s2x[0]);
        //         }
        //         return compared;
        //     }
        // });

        letters.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            }
            return compared;
        }
        );
        
        letters.addAll(digits);

        return letters.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] answer = reorderLogFiles(new String[]{"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"});
        System.out.println(answer);
    }
}