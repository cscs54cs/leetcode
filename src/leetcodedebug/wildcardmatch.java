package leetcodedebug;

public class wildcardmatch {
    public boolean isMatch(String s, String p) {
        int is=0,ip=0;
        boolean star=false;
        int starpos=-1,smark=-1;
        while(is<s.length()){
            if(ip>=p.length()){
            	if(is<=s.length()-1)
            		return false;
            	else
            		break;
            }
            if((s.charAt(is)==p.charAt(ip))||p.charAt(ip)=='?'){
                is++;
                ip++;
                continue;
            }
            if(p.charAt(ip)=='*'){
                star=true;
                starpos=ip;
                ip++;
                smark=is;
                continue;
            }
            if(star){
                ip=starpos+1;
                is=++smark;
                continue;
            }
            return false;
        }
        while(ip<p.length()&&p.charAt(ip)=='*'){
            ip++;
        }
        return (ip>=p.length());
    }
}
