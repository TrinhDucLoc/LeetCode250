package main.java;

public class wc470_removeSubstring {

  public static void main(String[] args) {
    System.out.println(removeSubstring("(())", 1));
    System.out.println(removeSubstring("((()))()()()", 3));
    System.out.println(removeSubstring(")(()))", 1));
    System.out.println(removeSubstring("((()", 2));
  }

  public static String removeSubstring(String s, int k) {
    StringBuilder res = new StringBuilder(s);
    StringBuilder templete = new StringBuilder();

    for (int i = 0; i < k; i++) {
      templete.append("(");
    }
    for (int i = 0; i < k; i++) {
      templete.append(")");
    }
    String immutableString = templete.toString();
    int i = 0;
    while (i <= res.length() - 2 * k) {
        if (res.substring(i, i + 2*k).equals(immutableString)) {
          res.delete(i, i + 2 * k);
          i = Math.max(i, i - 2 * k);
        } else {
          i++;
        }
    }
    return res.toString();
  }

// SOLUTION 2:
//  public static String removeSubstring(String s, int k) {
//    String res = s;
//    String balancedString = buildKBalancedString(k);
//
//    while (res.contains(balancedString)) {
//      res = res.replace(balancedString, "");
//    }
//    return res;
//  }
//
//  private static String buildKBalancedString(int k) {
//    StringBuilder builder = new StringBuilder();
//    for (int i = 0; i < k; i++) {
//      builder.append("(");
//    }
//
//    for (int i = 0; i < k; i++) {
//      builder.append(")");
//    }
//    return builder.toString();
//  }

// SOLUTION 1:
//  public static String removeSubstring(String s, int k) {
//    StringBuilder kBalanced = new StringBuilder();
//
//    kBalanced = buildKBalancedString(k, kBalanced);
//    String kBalancedInsertLeftOne = "(" + kBalanced;
//    String kBalancedInsertLeftTwo = ")" + kBalanced;
//    String kBalancedInsertRightOne = kBalanced + "(";
//    String kBalancedInsertRightTwo = kBalanced + ")";
//
//    int flagChange = 0;
//    if ((s.contains(kBalancedInsertRightOne) || s.contains(kBalancedInsertRightTwo))
//        && (s.contains(kBalancedInsertLeftOne) || s.contains(kBalancedInsertLeftTwo))) {
//      s = s.replace(kBalanced, "");
//      flagChange = 1;
//    }
//
//    if (flagChange == 0) {
//      return s;
//    }
//
//    String stringNew;
//    if (s.contains("()") && !s.contains("()()")) {
//      stringNew = s.replace("()", "");
//      if (checkAllBalanced(stringNew)) {
//        s = stringNew;
//      }
//    }
//
//    return s;
//  }
//
//  private static StringBuilder buildKBalancedString(int k, StringBuilder kBalanced) {
//    int kLeft = k, kRight = k;
//    while (kLeft > 0) {
//      kBalanced.append("(");
//      kLeft--;
//    }
//    while (kRight > 0) {
//      kBalanced.append(")");
//      kRight--;
//    }
//    return kBalanced;
//  }
//
//  private static boolean checkAllBalanced(String stringNew) {
//    if (stringNew.length() == 0) {
//      return true;
//    }
//    int flagChar = stringNew.charAt(0);
//    for (char c : stringNew.toCharArray()) {
//      if (c != flagChar) {
//        return false;
//      }
//    }
//    return true;
//  }
}
