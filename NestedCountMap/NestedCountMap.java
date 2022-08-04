
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class NestedCountMap {

    public static void main(String[] args) {


        String[] userList = {"a" , "bb", "cc", "dd", "eeee", "ffff", "gggg", "hhhh"} ;

        Map<Integer, Map<Integer, List<String>>> sameLengthCountToSameLengthStringListNestedMap = new HashMap<>();
        Map<Integer, List<String>> lengthToSameLengthListMap = Stream.of(userList).collect(groupingBy(String::length));



        lengthToSameLengthListMap.keySet().forEach(x ->
                sameLengthCountToSameLengthStringListNestedMap.put(lengthToSameLengthListMap.get(x).size(), new HashMap<Integer, List<String>>() {
                    {
                        put(x, lengthToSameLengthListMap.get(x));
                    }
                }));

        System.out.println(sameLengthCountToSameLengthStringListNestedMap);
    }

}



