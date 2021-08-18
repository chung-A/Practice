package com.chung.toy.six;

public class S2 {

/*

N명의 학생이 시험을 보았습니다. 각 학생에는 1부터 N까지의 번호가 붙어있습니다. N명의 학생의 시험 점수를 바탕으로 등수를 부여하려고 합니다. 각 학생의 등수는 자신보다 높은 점수를 받은 학생의 수에 1을 더한 수입니다. 예를 들어, 세 학생이 있고 1, 2, 3번 학생의 성적이 각각 2, 2, 1이라면 1, 2번 학생은 가장 점수가 높고 동점이기 때문에 1등이고, 3번 학생은 1, 2번 학생보다 점수가 낮기 때문에 3등입니다.
1번부터 N번 학생까지의 점수가 순서대로 들어있는 배열 grade가 주어질 때 1번부터 N번 학생까지의 등수가 순서대로 들어있는 배열을 return 하도록 solution 함수를 완성해주세요.
제한사항
grade의 길이는 1 이상 1,000,000 이하입니다.
grade의 각 원소는 1이상 1,000,000,000 이하입니다.
입출력 예
grade	result
[2,2,1]	[1,1,3]
[3,2,1,2]	[1,2,4,2]
입출력 예 설명
입출력 예 #1
문제 예시와 같습니다.
입출력 예 #2
1번 학생은 가장 점수가 높기 때문에 1등, 2번 학생은 자신보다 높은 점수의 학생이 1번 학생밖에 없으므로 2등, 3번 학생은 자신보다 높은 점수의 학생이 1번, 2번, 4번 학생이기 때문에 4등, 그리고 4번 학생은 2번 학생과 마찬가지로 자신보다 높은 점수의 학생이 1번 학생밖에 없으므로 2등입니다.

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{3,2,1,2};
//        int[] arr2 = new int[]{1, 1, 9, 1, 1, 1};
//        String[] arr3 = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};
//        String solution = solution("xyZA", "ABCxy");
        int[] ints = solution2(arr);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] solution2(int[] grade) {
        List<Main.Student> list = new ArrayList<>();
        for (int i = 0; i < grade.length; i++) {
            list.add(new Main.Student(i, grade[i]));
        }

        list.sort((s1, s2) -> s2.grade - s1.grade);

        for (int i = 0; i < list.size(); i++) {
            Main.Student student = list.get(i);

            int rank = i + 1;
            if (i != 0) {
                if (list.get(i - 1).grade == student.grade) {
                    rank = list.get(i - 1).rank;
                }
            }
            student.setRank(rank);
        }

        list.sort(Comparator.comparingInt(s -> s.index));

        int[] answer = new int[grade.length];
        for (int i = 0; i < grade.length; i++) {
            answer[i] = list.get(i).rank;
        }
        return answer;
    }

    static class Student{
        int index;
        int grade;
        int rank;

        public void setRank(int rank) {
            this.rank = rank;
        }

        public Student(int index, int grade) {
            this.index = index;
            this.grade = grade;
        }
    }


    public static String solution1(String s1, String s2) {
        //1-2
        int length = Math.min(s1.length(), s2.length());

        String answer1 = getString(s1, s2, length);
        String answer2 = getString(s2, s1, length);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        //반환
        if(answer1.length()>answer2.length()){
            return answer2;
        } else if (answer1.length() < answer2.length()) {
            return answer1;
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(answer1);
            list.add(answer2);
            Collections.sort(list);
            return list.get(0);
        }
    }

    private static String getString(String s1, String s2, int length) {
        StringBuilder stb1 = new StringBuilder();
        StringBuilder stb2 = new StringBuilder();
        String answer = s1 + s2;
        int index = 0;
        while (index <= length) {
            stb1.setLength(0);
            stb2.setLength(0);

            for (int i = s1.length() - index; i < s1.length(); i++) {
                stb1.append(s1.charAt(i));
            }

            for (int i = 0; i < index; i++) {
                stb2.append(s2.charAt(i));
            }

            if (stb1.length() != 0 && stb2.length() != 0 && stb1.toString().equals(stb2.toString())) {
                answer = makeStr(s1, s2, stb1.toString(), index, s2.length()-1 - index);
            }

            index++;
        }
        return answer;
    }

    public static String makeStr(String s1, String s2, String same, int start, int end) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < end; i++) {
            stb.append(s1.charAt(i));
        }

        stb.append(same);

        for (int i = start; i < s2.length(); i++) {
            stb.append(s2.charAt(i));
        }
        return stb.toString();
    }
*/


}
