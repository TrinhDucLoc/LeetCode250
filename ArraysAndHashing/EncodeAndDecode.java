import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode {

  public static void main(String[] args) {
    List<String> strs = Arrays.asList("neet", "code", "love", "you");
    System.out.println(encode(strs));
    System.out.println(decode(encode(strs)));
  }

  //["neet","code","love","you"]
  public static String encode(List<String> strs) {
    if (strs.isEmpty()) {
      return "";
    }

    StringBuilder res = new StringBuilder();
    List<Integer> sizes = new ArrayList<>();

    for (String str : strs) {
      sizes.add(str.length());
    }

    for (Integer size : sizes) {
      res.append(size).append(",");
    }
    res.append("#");

    for (String str : strs) {
      res.append(str);
    }

    return res.toString();
  }

  //4,4,4,3,#neetcodeloveyou
  public static List<String> decode(String str) {
    if (str.length() == 0) {
      return new ArrayList<>();
    }

    List<String> res = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();
    int i = 0;

    while (str.charAt(i) != '#') {
      StringBuilder tempStr = new StringBuilder();
      while (str.charAt(i) != ',') {
        tempStr.append(str.charAt(i));
        i++;
      }
      sizes.add(Integer.valueOf(tempStr.toString()));
      i++;
    }
    i++;

    for (Integer size : sizes) {
      res.add(str.substring(i, i + size));
      i += size;
    }

    return res;
  }
}
