package my.sunghyuk.edabit.hard;

import java.rmi.server.ObjID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Program {
  private Program() {

  }

  /**
   * Positives and Negatives
   * @see https://edabit.com/challenge/hYq8J8HJM3pwCFKiZ
   * @param arr
   * @return 정수 배열이 양의 정수, 음의 정수가 번갈아가며 이루어져 있는가. 어떤 수로 시작하든 상관없음. 요소에 0이 포함되면 false 리턴
   */
  public static boolean alternateSign(int[] arr) {

    for (int i = 0; i < arr.length; i++) {
      // 아래의 for문에서 i < arr.length - 1의 조건 때문에 요소가 한 개인 경우 arr[0] 실행 안 됨.
      if (arr[i] == 0) {
        return false;
      }
    }
    for (int i = 0; i < arr.length - 1; i++) {
      // System.out.println("arr[" + i + "] : " + arr[i]);
      if (arr[i] >= 0 && arr[i + 1] >= 0) {
        return false;
      }
      if (arr[i] <= 0 && arr[i + 1] <= 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * String or Integer?
   * @see https://edabit.com/challenge/paaguQWznz2cPNCiA
   * @param var
   * @return Object 타입의 매개변수 var가 정수면 "int", 문자열이면 "str" 리턴
   */
  public static String intOrString(Object var) {
    /* String varStr = String.valueOf(var);
    if (varStr.equals(var)) {
      return "str";
    }
    if (varStr.equals(String.valueOf(var))) {
      return "int";
    }
    return ""; */

    // Other Solution
    return var instanceof String ? "str" : "int";
  }

  /**
   * In the Centre?
   * @see https://edabit.com/challenge/qbhH4bef2N275iQ2Z
   * @param str
   * @return 주어진 문자열 str은 대부분의 공백과 공백이 아닌 문자 하나의 조합으로 이루어져 있다. 이 문자열에서 공백이 아닌 문자의 위치는 문자열에 중앙에 있는가. isCentered("  #  ") ➞ true
   */
  public static boolean isCentered(String str) {
    /* String centreCh = "";
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != ' ') {
        centreCh = String.valueOf(str.charAt(i));
      }
    }
    return str.substring(0, str.indexOf(centreCh)).length() == str.substring(str.indexOf(centreCh) + 1).length(); */

    // Other Solution
    /* int i = 0;
    int j = 0;
    while (str.charAt(i) == ' ') {
      i++;
    }
    while (str.charAt(str.length() - 1 - j) == ' ') {
      j++;
    }
    return i == j; */

    // Other Solution
    /* for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
    }
    return true; */

    // Other Solution
    return str.equals(new StringBuilder(str).reverse().toString());
  }

  /**
   * Exact Factorial Bounds
   * @see https://edabit.com/challenge/hTWrPnnCScgSsoN9A
   * @param n
   * @return 주어진 n이 팩토리얼 숫자인가. 그렇다면 n과 팩토리얼 수열에서의 마지막 값을 배열로 리턴, 아니라면 빈 배열 리턴. 재귀함수로 풀 수 있음.
   */
  public static long[] isExact(long n) {
    long factorialNum = 1;
    long i = 1;
    while (factorialNum < n) {
      factorialNum *= i;
      if (factorialNum == n) {
        return new long[] { n, i };
      }
      i++;
    }
    return new long[] {};
  }

  /**
   * Filter out Strings from an Array
   * @see https://edabit.com/challenge/vNszi3mbJA5BhgGFX
   * @param str
   * @return 문자열 배열에서 음수 값을 나타내지 않는 문자열만 배열로 리턴. 0은 음수 아님. 배열의 순서 유지, 중복된 요소는 제거. filterArray([1, 2, "aasf", "1", "123", 123]) ➞ [1, 2, 123]
   */
  public static String[] filterArray(String[] str) {
    for (int i = 0; i < str.length; i++) {
      str[i] = str[i].replaceAll("[^0-9]", "");
    }
    Set<String> numSet = new LinkedHashSet<>();
    for (int i = 0; i < str.length; i++) {
      if (!str[i].equals("")) {
        numSet.add(str[i]);
      }
    }
    return numSet.toArray(new String[numSet.size()]);
  }

  /**
   * Pronic Number
   * @see https://edabit.com/challenge/mMc9D6vB4iPiiAK7k
   * @param n
   * @return 주어진 정수 n이 어떠한 두 연속된 정수 곱의 값이라면 n은 Pronic Number(또는 heteromecic number)라 한다. n은 Pronic Number인가. 재귀함수로 풀 수 있음
   */
  public static boolean isHeteromecic(int n) {
    for (int i = 0; i <= Math.sqrt(n); i++) {
      if (i * (i + 1) == n) {
        return true;
      }
    }
    return false;

    // Other Solution
    // return (int) Math.sqrt(n) * ((int) Math.sqrt(n) + 1) == n;
  }

  /**
   * N-Length Letter Groups
   * @see https://edabit.com/challenge/5RvoqBgeykwy2Xqdb
   * @param s
   * @param n
   * @return 주어진 문자열 s를 주어진 길이 n만큼씩 자른 문자열 배열로 리턴. 1) 오름차순 배열로 리턴 2) 문자열의 길이가 주어진 길이보다 작다면 빈 배열로 리턴 3) Java Streams API 이용하여 풀어보기 4) 재귀함수로 풀 수 있음
   */
  public static String[] collect(String s, int n) {
    if (s.length() < n) {
      return new String[0];
    }
    String[] wordArr = new String[s.length() / n];
    for (int i = 0; i < wordArr.length; i++) {
      wordArr[i] = s.substring(0, n);
      s = s.substring(n);
    }
    Arrays.sort(wordArr);
    return wordArr;

    // Other Solution
    /* return IntStream.range(0, s.length() / n).mapToObj(i -> s.substring(i * n, (i + 1) * n)).sorted()
        .toArray(String[]::new); */

    // Other Solution
    /* String[] wordArr = s.replaceAll(".{" + n + "}", "$0,").replaceAll(",[^,]{1," + --n + "}$", "").split(",");
    Arrays.sort(wordArr);
    return n >= s.length() ? new String[0] : wordArr; */
  }

  /**
   * Disarium Number
   * @see https://edabit.com/challenge/GjCgCugvh4eorPmgM
   * @param n
   * @return Disarium Number란 수의 왼쪽부터 각 자리의 수 * 1, 2, 3, 4... 제곱의 합이 자신인 수를 말한다. n은 Disarium Number인가. isDisarium(75) ➞ false // 7^1 + 5^2 = 7 + 25 = 32. isDisarium(135) ➞ true // 1^1 + 3^2 + 5^3 = 1 + 9 + 125 = 135
   */
  public static boolean isDisarium(int n) {
    int nCopy = n;
    int digitSum = 0;
    int i = 1;
    while (nCopy != 0) {
      int digit = nCopy / (int) Math.pow(10, String.valueOf(nCopy).length() - 1);
      digitSum += Math.pow(digit, i++);
      nCopy = nCopy % (int) Math.pow(10, String.valueOf(nCopy).length() - 1);
    }
    return digitSum == n;

    // Other Solution
    // return n == getDigitSum(n, String.valueOf(n).length());

    // Other Solution
    /* int pow = String.valueOf(n).length();
    int digitSum = 0;
    int nCopy = n;
    while (pow > 0) {
      digitSum += Math.pow(nCopy % 10, pow);
      pow--;
      nCopy = nCopy / 10;
    }
    return digitSum == n; */
  }

  private static int getDigitSum(int n, int pow) {
    return n < 1 ? 0 : (int) Math.pow(n % 10, pow) + getDigitSum(n / 10, --pow);
  }

  /**
   * Find the Longest Word
   * @see https://edabit.com/challenge/MYtinBHDSk4Bk7HnH
   * @param ㄴ
   * @return 문장에서 가장 긴 "단어" 리턴. 재귀함수로 풀 수 있음. 1) 특수문자를 제외한 문자열의 길이를 비교(소유격을 나타내는 단어는 소유격이 아닌 단어 자체를 비교, 강조를 의미하는 "" 등 제외) 2) 소문자로 리턴.
   */
  public static String findLongest(String sentence) {

    /* String[] wordArr = sentence.toLowerCase().replace("'s", "").split(" ");
    String longestWord = "";
    for (int i = 0; i < wordArr.length; i++) {
      if (wordArr[i].replaceAll("[^a-z]", "").length() > longestWord.length()) {
        longestWord = wordArr[i].replaceAll("[^a-z]", "");
      }
    }
    return longestWord; */

    // Other Solution
    // String[] wordArr = sentence.toLowerCase().replaceAll("[^a-z]", " ").split(" ");
    // 특수기호들을 " "으로 만든 후 " " 기준으로 자르면 문장부호들은 단어에서 잘려나가 단어에서 문장부호를 제외한 "단어"만 얻을 수 있음.
    String[] wordArr = sentence.toLowerCase().replaceAll("[^a-z ]", " ").split(" +");
    //.replaceAll("[^a-z ]", " ") .split(" +")
    // 특수기호와 공백이 붙어있어 공백이 두 개 생기는 경우 공백 한 개 이상의 기준으로 자름
    String longestWord = "";
    for (int i = 0; i < wordArr.length; i++) {
      if (wordArr[i].length() > longestWord.length()) {
        longestWord = wordArr[i];
      }
    }
    return longestWord;
  }

  /**
   * Largest Gap
   * @see https://edabit.com/challenge/qSJ5hZfG52Nf2hXWS
   * @param numbers
   * @return 배열을 정렬한 후 앞 요소와 뒷 요소의 차이 값 중 가장 큰 차이 값 리턴
   */
  public static int largestGap(int[] numbers) {
    Arrays.sort(numbers);
    int largestGap = 0;
    for (int i = numbers.length - 1; i >= 1; i--) {
      if (numbers[i] - numbers[i - 1] > largestGap) {
        largestGap = numbers[i] - numbers[i - 1];
      }
    }
    return largestGap;
  }

  /**
   * Oddly or Evenly Positioned from Last
   * @see https://edabit.com/challenge/99yALJGy4ZmFzaqvr
   * @param arr
   * @param par
   * @return 주어진 par가 "odd"이면 배열 맨 뒤의 홀수 번째 요소에서 시작하여 홀수 번째 요소들을, "even"이면 짝수 번째 요소에서 시작하여 짝수 번째 요소들을 배열로 리턴. 배열 순서 유지
   */
  public static Object[] charAtPos(Object[] arr, String par) {
    List<Object> list = new ArrayList<>();
    if (par.equals("odd")) {
      for (int i = arr.length - 1; i >= 0; i = i - 2) {
        list.add(arr[i]);
      }
    }
    if (par.equals("even")) {
      for (int i = arr.length - 2; i >= 0; i = i - 2) {
        list.add(arr[i]);
      }
    }
    Object[] filteredArr = new Object[list.size()];
    for (int i = filteredArr.length - 1, j = 0; i >= 0; i--, j++) {
      filteredArr[i] = list.get(j);
    }
    return filteredArr;
  }

  /**
   * Numbered Cards
   * @see https://edabit.com/challenge/qE9gCJtrtcMurvQtT
   * @param you
   * @param opp
   * @return 정수형 배열 you와 opp에서 각각 두 개의 정수를 뽑아 두 자리 수를 만들었을 때 you의 배열에서 만든 수가 더 크면 true, 아니면 false 리턴
   */
  public static boolean winRound(int[] you, int[] opp) {
    Arrays.sort(you);
    Arrays.sort(opp);
    // return Integer.parseInt(String.valueOf(you[you.length - 1]) + String.valueOf(you[you.length - 2])) > Integer
    //     .parseInt(String.valueOf(opp[opp.length - 1]) + String.valueOf(opp[opp.length - 2]));
    return you[you.length - 1] * 10 + you[you.length - 2] > opp[opp.length - 1] * 10 + opp[opp.length - 2];
  }
}