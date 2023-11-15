import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int N,M;
	static BufferedWriter bw = null;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		makeSeq("");
		bw.flush();
		bw.close();
		
	}
	
	static void makeSeq(String seq) throws IOException{
		if(seq.length()==M*2) {
			bw.write(seq + "\n");
			return;
		}
		
		for(int i=1; i<= N; i++) {
				makeSeq(seq.concat(i+" "));
		}
	}

}
