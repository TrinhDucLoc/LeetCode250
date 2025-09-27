package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class evenNumberBitwiseORs {

  public static void main(String[] args) {
//    System.out.println(convertBinaryToDecimal(110));
    System.out.println(evenNumberBitwiseORs(new int[]{100, 64, 32, 16, 8, 4, 2}));
//    System.out.println(convertNumberToBinary(6, 4));
//    System.out.println(convertBinaryToDecimal(110));
  }

  public static int evenNumberBitwiseORs(int[] nums) {
    int bits = 0;
    Set<Integer> hashSet = new HashSet<>();
    for (int num : nums) {
      if (num % 2 == 0) {
        hashSet.add(num);
        bits = Math.max(bits, bitsOfBinary(num));
      }
    }
    System.out.println(bits);

    List<Integer> listInt = hashSet.stream().toList();

    if (hashSet.size() == 0) {
      return 0;
    } else if (hashSet.size() == 1) {
      return listInt.get(0);
    }

    int res = convertNumberToBinary(listInt.get(0), bits);
    for (int i = 1; i < listInt.size(); i++) {
      int binaryNum2 = convertNumberToBinary(listInt.get(i), bits);
      res = orTwoBinary(res, binaryNum2, bits);
    }

    return convertBinaryToDecimal(res);
  }

  public static int convertNumberToBinary(int num, int bits) {
    int[] remainder = new int[bits];
    for (int i = bits - 1; i >= 0; --i) {
      remainder[i] = num % 2;
      num /= 2;
    }
    int binaryNum = 0;
    for (int i = 0; i < bits; i++) {
      binaryNum = binaryNum * 10;
      binaryNum = binaryNum + remainder[i];
    }
    return binaryNum;
  }

  public static int convertBinaryToDecimal(int num) {
    // 0010 -> 2
    int res = 0;
    int idx = 0;
    while (num > 0) {
      int lastNum = num % 10;
      int lastNumToSum = 0;
      if (lastNum == 1) {
        if (idx == 0) {
          lastNumToSum = 1;
        } else {
          lastNumToSum = 1;
          for (int j = 1; j <= idx; j++) {
            lastNumToSum *= 2;
          }
        }
      }
      res += lastNumToSum;
      idx++;
      num /= 10;
    }
    return res;
  }

  public static int orTwoBinary(int binaryNum1, int binaryNum2, int bits) {
    int[] tempSum = new int[bits];
    int idx = 0;

    while (binaryNum1 > 0 && binaryNum2 > 0) {
      if (binaryNum1 % 10 == 1 || binaryNum2 % 10 == 1) {
        tempSum[idx] = 1;
      } else {
        tempSum[idx] = 0;
      }
      binaryNum1 = binaryNum1 / 10;
      binaryNum2 = binaryNum2 / 10;
      idx++;
    }
    while (binaryNum1 > 0) {
      tempSum[idx] += binaryNum1 % 10;
      binaryNum1 = binaryNum1 / 10;
      idx++;
    }
    while (binaryNum2 > 0) {
      tempSum[idx] += binaryNum2 % 10;
      binaryNum2 = binaryNum2 / 10;
      idx++;
    }
    int resValue = 0;
    for (int i = tempSum.length - 1; i >= 0; i--) {
      resValue *= 10;
      resValue += tempSum[i];
    }
    return resValue;
  }

  public static int bitsOfBinary(int binaryNum) {
    int bits = 0;
    while (binaryNum > 0) {
      bits++;
      binaryNum = binaryNum / 2;
    }
    return bits <= 4 ? 4 : 8;
  }
}
