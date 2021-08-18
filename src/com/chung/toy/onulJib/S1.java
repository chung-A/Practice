package com.chung.toy.onulJib;

public class S1 {
    /**
     *
     *
     *
     *
     public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String str = br.readLine();
     Map<Character, Integer> map = new LinkedHashMap<>();

     char key = '*';
     for (int i = 0; i < str.length(); i++) {
     char c = str.charAt(i);

     //문자인 경우
     if (isText(c)) {
     key = c;
     continue;
     }

     //숫자인 경우 - 이어지는 숫자 모두 담기
     StringBuilder stb = new StringBuilder();
     stb.append(c);
     while (true) {
     //문자열의 끝인 경우
     if (i + 1 >= str.length()) {
     break;
     }
     //다음문자가 숫자가 아닌경우
     else if (isText(str.charAt(i + 1))) {
     break;
     }
     i++;
     char nextChar = str.charAt(i);
     stb.append(nextChar);
     }

     int number = Integer.parseInt(stb.toString());
     if(map.containsKey(key)){
     map.replace(key, map.get(key) + number);
     }
     else{
     map.put(key, number);
     }
     }

     //문자열 만들기
     StringBuilder stb = new StringBuilder();
     for (Character c : map.keySet()) {
     stb.append(c).append(map.get(c));
     }
     System.out.println(stb);
     }

     static boolean isText(char c) {
     return c >= 'a' && c <= 'z';
     }

     */
}
