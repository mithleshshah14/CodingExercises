import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

    public static void main(String[] args) {
        String val = "google&&121";

        Map<Character, Integer> myMap = new HashMap<>();

        Map<Character, Integer> charCounts = new HashMap<>();
        val.chars().forEach(c -> charCounts.put((char) c, charCounts.getOrDefault((char) c, 0) + 1));

        // Print the character counts
        charCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("key:" + entry.getKey() + ", val:" + entry.getValue()));

       /* for(char c : val.toCharArray()) {

            if (myMap.containsKey(c)) {
                myMap.put(c, myMap.get(c) + 1);
            } else {
                myMap.put(c, 1);
            }

        }

        for(Map.Entry<Character, Integer> res : myMap.entrySet()) {
            if(res.getValue()>1)
            System.out.println("key:"+res.getKey()+", val:"+res.getValue());
        }*/
        String source = "";
    }


    static int getOccurrences(String source, String word) {
        // Your code goes here.
        int count = 0;

        for(String val : source.split(" ")){
        }
        return count;
    }
}
