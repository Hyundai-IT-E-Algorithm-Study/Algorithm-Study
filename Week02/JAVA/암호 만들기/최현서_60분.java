import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int L, C;
	
	static List<String> alphabets = null;
	static List<String> vowels = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		String str = "";
		alphabets = new ArrayList<>(); 
		
		for (int i=0; i<C; i++) {
			alphabets.add(sc.next());
		}
		Collections.sort(alphabets);
		
		
		String[] vowel = {"a","i","o","u","e"};
		vowels = Arrays.asList(vowel);
		
		
		makePasswords("", 0, 0);
		
		
	}
	static void makePasswords(String password, int vowelNum, int idx) {
		if (password.length() == L) {
			if(1<=vowelNum && vowelNum <= L-2) System.out.println(password);
			return;
		}
		
		if (idx>=C) return;
		
		//현재 index 알파벳 포함
		if(vowels.contains(alphabets.get(idx))) vowelNum++;
		makePasswords(password.concat(alphabets.get(idx)), vowelNum, idx+1);	
		
		//현재 index 알파벳 미포함
		if(vowels.contains(alphabets.get(idx))) vowelNum--;
		makePasswords(password, vowelNum, idx+1);
	}
	
	
}
