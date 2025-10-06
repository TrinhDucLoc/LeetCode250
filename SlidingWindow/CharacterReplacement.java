import java.util.HashSet;
import java.util.Set;

public class CharacterReplacement {

  public static void main(String[] args) {
    System.out.println(characterReplacement("ABBB", 2));
  }

  public static int characterReplacement(String s, int k) {
    Set<Character> hashSet = new HashSet<>();

    for (char c : s.toCharArray()) {
      if (!hashSet.contains(c)) {
        hashSet.add(c);
      }
    }

    if (hashSet.size() == 1) {
      return s.length();
    }

    int res = 0;
    for (Character c : hashSet) {
      int countDuplicate = 0;
      int l = 0;

      for (int r = 0; r < s.length(); r++) {
        if (s.charAt(r) == c) {
          countDuplicate++;
        }

        while ((r - l + 1) - countDuplicate > k) {
          if (s.charAt(l) == c) {
            countDuplicate--;
          }
          l++;
        }
        res = Math.max(res, r - l + 1);
      }
    }
    return res;
  }
}

/*
Window: "AA"     → count=2, need 0 replacements → valid, length=2
Window: "AAB"    → count=2, need 1 replacement  → valid, length=3
Window: "AABA"   → count=3, need 1 replacement  → valid, length=4
Window: "AABAB"  → count=3, need 2 replacements → invalid! (2 > k)
  Shrink: "ABAB" → count=2, need 2 replacements → invalid!
  Shrink: "BAB"  → count=1, need 2 replacements → invalid!
  Shrink: "AB"   → count=1, need 1 replacement  → valid, length=2
...

Analyst:
Input: "AAABABB", k = 1
Output: 5

Solution:
1/ Using brute force:


2/ Using sliding window
- Window with: (r - l + 1)
- Count duplicate with c
- K is max replace character => replaceInWindow = window - countDuplicate => res = Math.max(countDuplicate, res);
- If replaceInWindow > k => move left and update count if charAt(l) == c

Time complexity: O(N)
Space complexity: O(N)
 */
