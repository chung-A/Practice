package com.chung.toy.line;

import java.util.Stack;

public class Test1 {
    /*
    문제 설명
우리는 일상에서 순서를 표현하거나 부가 정보를 제공하거나 특정 내용을 부각하는 등의 용도로 괄호를 사용합니다. 괄호는 여는 괄호와 닫는 괄호가 한 묶음을 이루어야 한다는 특징이 있으며 다양한 형태가 존재합니다.

아래 규칙에 맞춰 임의의 문자열에서 다양한 괄호를 올바르게 사용했는지 확인할 수 있는 해결법을 제시해 봅시다.

제한 사항
임의의 문자열 inputString이 입력됩니다

공백으로만 이루어진 문자열은 입력되지 않습니다
입력 문자열의 길이는 1 이상입니다
최대 길이는 명시되지 않습니다
괄호는 아래와 같이 네 종류가 있다고 가정합니다
( ), { }, [ ], < >
동일한 형태의 괄호가 여러 번 사용될 수 있습니다.
괄호를 정상적으로 사용했는지 검증한 결과를 반환합니다

인덱스는 0부터 시작합니다.
여닫는 괄호의 짝이 맞지 않으면 닫는 괄호의 인덱스를 음수로 반환합니다.
예를 들어 'line [({<plus>)}]' 경우 14번째 괄호가 짝이 맞지 않기 때문에 인덱스 14의 음수인 -14를 반환합니다.
괄호가 열려 있는 상태로 문자열이 끝나면 문자열의 마지막 인덱스를 음수로 반환합니다.
예를 들어 'line [({<plus>})' 문자열은 괄호 1개가 닫히지 않고 끝나기 때문에 마지막 인덱스 15의 음수인 -15를 반환합니다.
답이 중복으로 존재하는 경우 문자열 왼쪽 기준으로 먼저 등장하는 것을 답으로 합니다.
예를 들어 'ABC({ABC)ABC'의 경우에는 짝이 맞지 않는 괄호와 닫히지 않은 괄호가 동시에 존재하며 이때 왼쪽 기준으로 우선인 -8이 정답이 됩니다.
모든 괄호를 정상적으로 사용했다면 총 괄호 쌍의 개수를 반환합니다.
예를 들어 '(A)[B]'라는 문자열은 2개의 괄호 쌍이 존재하기 때문에 2를 반환합니다.
첫 번째 문자가 닫는 괄호이거나 괄호가 없는 경우에는 0을 반환합니다.
두 번째 문자 이후에서 닫는 괄호가 먼저 나오는 경우에는 닫는 괄호의 인덱스를 음수로 반환합니다.
예를 들어 'ABC)ABC'의 경우에는 -3을 반환합니다.
     */

    char[] startSign = new char[]{'(', '{', '[', '<'};
    char[] endSign = new char[]{')', '}', ']', '>'};

    public int solution(String inputString) {

        int answer = 0;
        int lastCharIdx = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            //시작하는 문자 였다면
            int startIdx = contains(startSign, c);
            if (startIdx != -1) {
                stack.push(startIdx);
                lastCharIdx = startIdx;
                continue;
            }

            //끝나는 문자 였다면
            int endIdx = contains(endSign, c);
            if (endIdx != -1) {

                //짝이 안맞는경우 검사
                if (lastCharIdx != endIdx) {
                    return i * -1;
                }
                //짝이 맞으면
                else{
                    //꺼내고
                    stack.pop();
                    answer++;

                    //다음 예정인 괄호가 있다면
                    if(!stack.empty()) {
                        lastCharIdx = stack.peek();
                    }
                    else{
                        lastCharIdx = -1;
                    }
                }
            }

        }

        //괄호가 아직 남았는데 문자가 끝나버린 경우
        if(!stack.empty()){
            return (inputString.length() - 1) * -1;
        }

        return answer;
    }

    int contains(char[] chars, char target) {
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
