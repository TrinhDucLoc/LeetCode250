import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(strs));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
//    Map<String, ArrayList<String>> hashMap = new HashMap<>();
//    for (String str : strs) {
//      char[] chars = str.toCharArray();
//      Arrays.sort(chars);
//      if (hashMap.containsKey(String.valueOf(chars))) {
//        hashMap.get(String.valueOf(chars)).add(str);
//      } else {
//        hashMap.put(String.valueOf(chars), new ArrayList<>());
//        hashMap.get(String.valueOf(chars)).add(str);
//      }
//    }
//    return new ArrayList<>(hashMap.values());

    Map<String, List<String>> hashMap = new HashMap<>();

    for (String s : strs) {
      int[] strKey = new int[26];

      for (char c : s.toCharArray()) {
        strKey[c - 'a']++;
      }

      String newKey = Arrays.toString(strKey);
      if (!hashMap.containsKey(newKey)) {
        hashMap.put(newKey, new ArrayList<>());
      }
      hashMap.get(newKey).add(s);
    }
    return new ArrayList<>(hashMap.values());
  }
}
