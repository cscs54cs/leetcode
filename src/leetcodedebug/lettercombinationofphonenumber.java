package leetcodedebug;

import java.util.ArrayList;

public class lettercombinationofphonenumber {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> re = new ArrayList<String>();
        if(digits.length()<1){
            ret.add(digits);
            return ret;
        }
        putchar(ret,digits.charAt(0));
        for(String ss:ret){
            for(String subs:letterCombinations(digits.substring(1,digits.length()))){
                re.add(ss+subs);
            }
        }
        return re;
    }
    public void putchar(ArrayList<String> ret,char c){
        if(c=='1'){
            ret.add("");
        }
        else if(c=='2'){
            ret.add("a");
            ret.add("b");
            ret.add("c");
        }
        else if(c=='3'){
            ret.add("d");
            ret.add("e");
            ret.add("f");
        }
        else if(c=='4'){
            ret.add("g");
            ret.add("h");
            ret.add("i");
        }
        else if(c=='5'){
            ret.add("j");
            ret.add("k");
            ret.add("l");
        }
        else if(c=='6'){
            ret.add("m");
            ret.add("n");
            ret.add("o");
        }
        else if(c=='7'){
            ret.add("p");
            ret.add("q");
            ret.add("r");
            ret.add("s");
        }
        else if(c=='8'){
            ret.add("t");
            ret.add("u");
            ret.add("v");
        }
        else if(c=='9'){
            ret.add("w");
            ret.add("x");
            ret.add("y");
            ret.add("z");
        }
    }
}
