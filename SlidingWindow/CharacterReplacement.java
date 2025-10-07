import java.util.HashSet;
import java.util.Set;

public class CharacterReplacement {

  public static void main(String[] args) {
    System.out.println(characterReplacement("AABABBA", 1));
  }

  // "AAABABB", k = 1 -> 5
  public static int characterReplacement(String s, int k) {
    Set<Character> hashSet = new HashSet<>();
    int res = 0;

    for (char c : s.toCharArray()) {
      if (!hashSet.contains(c)) {
        hashSet.add(c);
      }
    }

    for (Character c : hashSet) {
      int l = 0, countDuplicate = 0, windowSize = 0;
      for (int r = 0; r < s.length(); r++) {
        windowSize = r - l + 1;
        if (s.charAt(r) == c) {
          countDuplicate++;
        }

        while (l < s.length() && (windowSize - countDuplicate > k)) {
          if (s.charAt(l) == c) {
            countDuplicate--;
          }
          l++;
          windowSize = r - l + 1;
        }
        res = Math.max(res, windowSize);
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
