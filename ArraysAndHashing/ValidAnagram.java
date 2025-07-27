public class ValidAnagram {

  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    System.out.println(isAnagram(s, t));

    String s2 = "rat";
    String t2 = "car";
    System.out.println(isAnagram(s2, t2));

  }
  public static boolean isAnagram(String s, String t) {
    if (s.length() == 0 || t.length() == 0) {
      return true;
    }
    int[] anphabet = new int[26];
    char[] sChar = s.toCharArray();
    char[] tChar = t.toCharArray();
    for (char item : sChar) {
      anphabet[item - 'a']++;
    }
    for (char item : tChar) {
      anphabet[item - 'a']--;
    }

    for (int i = 0; i < anphabet.length; i++) {
      if (anphabet[i] != 0) {
        return false;
      }
    }

    return true;
  }
}
