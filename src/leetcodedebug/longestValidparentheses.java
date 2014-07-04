package leetcodedebug;

import java.util.Stack;

public class longestValidparentheses {
	public int longestValidParentheses(String s) {
        Stack<Character> sc = new Stack<Character>();
        Stack<Integer> si = new Stack<Integer>();
        int i=0,max=0;
        for(i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(si.isEmpty()||c=='('){
                si.push(i);
                sc.push(c);
            }
            else{
                if(sc.peek()=='('){
                    sc.pop();
                    si.pop();
                    if(si.isEmpty()){
                        if(max<i+1){
                            max=i+1;
                        }
                    }
                    else{
                        if(max<i-si.peek()){
                            max = i-si.peek();
                        }
                    }
                }
            }
        }
        return max;
    }
}
