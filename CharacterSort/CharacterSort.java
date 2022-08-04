package CharacterSort;
import java.util.*;

public class CharacterSort {

    public static void main(String[] args)
    {
        String str = "omid";
        characterSort(str);
    }


        static void characterSort(String inputString)
        {
            Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
            char[] strArray = inputString.toCharArray();
            for (char c : strArray) {
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                }
                else {
                    charCountMap.put(c, 1);
                }
            }


            StringBuilder answer = new StringBuilder();
            for (Map.Entry entry : charCountMap.entrySet()) {
                for (Integer i =0; i < (Integer) entry.getValue() ; i++) answer.append(entry.getKey());
            }
            System.out.println(charCountMap);
        }

    }

