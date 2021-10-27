import java.util.*;

public class KFrequency {

    public static void main(String[] args) {
        String s = "trichotillomania";
        int k = 2;
        showFrequency(s,k);
    }

    public static void showFrequency(String s , int k) {
        Map<Character, Integer> strMap = new HashMap<>();

        for(int i = 0; i<s.length(); i++) {
            if (!strMap.containsKey(s.charAt(i))) {

                strMap.put(s.charAt(i), 1);

            } else {
                strMap.put(s.charAt(i), strMap.get(s.charAt(i)) + 1);
            }
        }

            Set<Integer> sInt = new HashSet<>(strMap.values());
                sInt.stream().forEach(System.out::println);
            List<Integer> list = new ArrayList<>(sInt);
            Collections.sort(list,Collections.reverseOrder());
           // System.out.println(list.size());
            int n = 0;
            if(list.size() >= k) {
                 n = list.get(k - 1);
            } else {
                System.out.println(-1);
                System.exit(1);
            }

            TreeMap<Character,Integer> trMap = new TreeMap<>();
            trMap.putAll(strMap);

            for(Map.Entry<Character,Integer> ss : trMap.entrySet()) {
                if(ss.getValue() == n) {
                    System.out.println(ss.getKey());
                    break;
                }
            }


    }
}
