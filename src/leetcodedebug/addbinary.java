package leetcodedebug;

public class addbinary {
    public String addBinary(String a, String b) {
        int lena = a.length(),lenb = b.length();
        int chang = Math.max(lena,lenb),duan = Math.min(lena,lenb);
        char[] result= new char[chang];
        char jin=0;
        int i;
        String sc,sd;
        if(chang==lena){
            sc=a;
            sd=b;
        }
        else{
            sc=b;
            sd=a;
        }
        for(i=1;i<=duan;i++){
            result[chang-i]= (char)(((sc.charAt(chang-i)+sd.charAt(duan-i)+jin-'0'-'0')%2)+'0');
            jin = (char) ((sc.charAt(chang-i)+sd.charAt(duan-i)+jin-'0'-'0')/2);
        }
        for(;i<=chang;i++){
            result[chang-i]=(char) (((sc.charAt(chang-i)+jin-'0')%2)+'0');
            jin = (char) ((sc.charAt(chang-i)+jin-'0')/2);
        }
        if(jin==0)
            return new String(result);
        else
            return "1"+new String(result);
    }
}
