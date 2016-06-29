package code;
/**
 * ‘?’匹配任意单个字符，‘*’匹配任意字符序列（包括空字符序列）。如果匹配整个串返回true。
	例：
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false
		a	*	d	?
	a	t	t	f	f
	b	f	t	f	f
	c	f	t	f	f
	d	f	t	f	f	
	d	f	t	t	f
	e	f	f	f	t
		t	f	t	t	t
 * @author Administrator
 *
 */
public class WildcardMatching {
	
	 public boolean issMatch(String s, String p) {
	        boolean[][] match=new boolean[s.length()+1][p.length()+1];
	        match[s.length()][p.length()]=true;
	        for(int i=p.length()-1;i>=0;i--){
	            if(p.charAt(i)!='*')
	                break;
	            else
	                match[s.length()][i]=true;
	        }
	        for(int i=s.length()-1;i>=0;i--){
	            for(int j=p.length()-1;j>=0;j--){
	                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
	                        match[i][j]=match[i+1][j+1];
	                else if(p.charAt(j)=='*')
	                        match[i][j]=match[i+1][j]||match[i][j+1];
	                else
	                    match[i][j]=false;
	            }
	        }
	        return match[4][1];
	    }
 	public static void main(String[] args){
 		WildcardMatching w = new WildcardMatching();
 		String s = "abcdde";
 		String p = "a*d?";
 		System.out.println(w.issMatch(s, p));
 	}

}
