import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermutionInString {

  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "a"));
//    System.out.println(checkInclusion("abc", "lecaabee"));
  }

  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    int l = 0, r = s1.length() - 1;
    Set<String> hashSet = new HashSet<>();
    int[] alpha1 = new int[26];
    for (char c1 : s1.toCharArray()) {
      alpha1[c1 - 'a']++;
    }
    String s1Key = Arrays.toString(alpha1);
    hashSet.add(s1Key);

    while (r < s2.length()) {
      int[] alpha2 = new int[26];
      for (int i = l; i <= r; i++) {
        alpha2[s2.charAt(i) - 'a']++;
      }
      String s2Key = Arrays.toString(alpha2);
      if (hashSet.contains(s2Key)) {
        return true;
      }
      l++;
      r++;
    }

    return false;
  }
}
