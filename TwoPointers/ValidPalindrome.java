public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
      while (l < r && !isAlphanumeric(s.charAt(l))) {
        l++;
      }

      while (l < r && !isAlphanumeric(s.charAt(r))) {
        r--;
      }

      if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
        return false;
      }
      l++;
      r--;
    }

    return true;
  }

  public boolean isAlphanumeric(char s) {
    return (s >= 'A' && s <= 'Z')
        || (s >= 'a' && s <= 'z')
        || (s >= '0' && s <= '9');
  }
}
