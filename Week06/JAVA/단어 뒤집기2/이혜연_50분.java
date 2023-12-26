import java.io.*;
import java.util.*;

public class Main {	
	
	static String reverse(String arr) {
		String result ="";
		for(int i=arr.length()-1;i>=0;i--) {
			result += arr.charAt(i);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr = br.readLine();
		
		String result = "";
		String reverse = "";
		boolean flag = false;
	
		for(int i=0;i<arr.length();i++) {
			if(arr.charAt(i)=='<') {
				flag = true;
				if(reverse.length()>0) {
					String[] newReverse = reverse.split(" ");
					for(int j=0;j<newReverse.length;j++) {
						StringBuffer sb = new StringBuffer(newReverse[j]);
						result += sb.reverse().toString();
						if(j!=newReverse.length-1)
							result += " ";
					}
				}
				reverse = "";
				flag = false;
				int index = i;
				while(arr.charAt(index)!='>') {
					result += arr.charAt(index++);
					i++;
				}
				result += '>';
			}
			
			else {
				reverse += arr.charAt(i);
			}
			
		}
		if(!flag) {
			String[] newReverse = reverse.split(" ");
			for(int i=0;i<newReverse.length;i++) {
				StringBuffer sb = new StringBuffer(newReverse[i]);
				result += sb.reverse().toString();
				if(i!=newReverse.length-1)
					result += " ";
			}
			
		}
		
		System.out.println(result);
   }
 }
