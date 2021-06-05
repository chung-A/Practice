package com.chung.six;

public class S1 {

/**
 * 문제 설명
 *
 * 두 문자열의 앞뒤를 겹쳐서 만들 수 있는 문자열 중, 더 짧은 문자열을 구하려합니다.
 * 예를 들어 "xyZA"와 "ABCxy"가 주어졌을 때, 두 문자열을 겹치는 방법은 다음과 같습니다.
 * 방법1. "xyZA" 뒤에 "ABCxy" 겹치기
 * overlapping_1.png
 * 방법2. "ABCxy" 뒤에 "xyZA" 겹치기
 * overlapping_2.png
 * 두 문자열 s1과 s2가 주어질 때, s1과 s2를 겹쳐서 만들 수 있는 문자열 중, 가장 짧은 문자열을 return 하도록 solution 함수를 완성해주세요.
 * 제한사항
 * s1과 s2의 길이는 1 이상 100 이하입니다.
 * s1과 s2는 알파벳 대문자와 소문자로만 이루어져 있습니다.
 * 문자열을 겹칠 때에는 대소문자를 구분합니다. 즉, "a"와 "A"를 겹칠 수는 없습니다.
 * 가장 짧은 문자열이 여러 개라면 그 중 사전 순으로 앞서는 문자열을 return 해주세요.
 * 입출력 예
 * s1	s2	result
 * "xyZA"	"ABCxy"	"ABCxyZA"
 * "AxA"	"AyA"	"AxAyA"
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제에 주어진 예시와 같습니다.
 * 입출력 예 #2
 * 두 문자열을 겹치면 "AxAyA"와 "AyAxA"를 만들 수 있습니다. 둘의 길이는 같으므로 사전 순으로 앞서는 문자열인 "AxAyA"를 return 합니다.
 *
 * import java.io.*;
 * import java.util.*;
 *
 * class Solution {
 *
 *     public String solution(String s1, String s2) {
 *         //1-2
 *         int length = Math.min(s1.length(), s2.length());
 *
 *         String answer1 = getString(s1, s2, length);
 *         String answer2 = getString(s2, s1, length);
 *
 *         //반환
 *         if(answer1.length()>answer2.length()){
 *             return answer2;
 *         } else if (answer1.length() < answer2.length()) {
 *             return answer1;
 *         }
 *         else{
 *             List<String> list = new ArrayList<>();
 *             list.add(answer1);
 *             list.add(answer2);
 *             Collections.sort(list);
 *             return list.get(0);
 *         }
 *     }
 *
 *     private String getString(String s1, String s2, int length) {
 *         StringBuilder stb1 = new StringBuilder();
 *         StringBuilder stb2 = new StringBuilder();
 *         String answer = s1 + s2;
 *         int index = 0;
 *         while (index <= length) {
 *             stb1.setLength(0);
 *             stb2.setLength(0);
 *
 *             for (int i = s1.length() - index; i < s1.length(); i++) {
 *                 stb1.append(s1.charAt(i));
 *             }
 *
 *             for (int i = 0; i < index; i++) {
 *                 stb2.append(s2.charAt(i));
 *             }
 *
 *             if (stb1.length() != 0 && stb2.length() != 0 && stb1.toString().equals(stb2.toString())) {
 *                 answer = makeStr(s1, s2, stb1.toString(), index, s2.length()-1 - index);
 *             }
 *
 *             index++;
 *         }
 *         return answer;
 *     }
 *
 *     public String makeStr(String s1, String s2, String same, int start, int end) {
 *         StringBuilder stb = new StringBuilder();
 *         String regex=same+"$";
 *         stb.append(s1.replaceAll(regex, ""));
 *
 *         stb.append(same);
 *
 *         for (int i = start; i < s2.length(); i++) {
 *             stb.append(s2.charAt(i));
 *         }
 *         return stb.toString();
 *     }
 * }
 */
}
