import java.util.*;
class Solution {
   static ArrayList<String> answer = new ArrayList<>();
	static int length = 0;
	static boolean check(String arr1, String arr2) {
		for(int i=0;i<answer.size();i++) {
				if(answer.get(i).equals(arr1) && answer.get(i+1).equals(arr2)) 
					return true;
			
			
		}
		return false;
	}
    
    public String[] solution(String[][] tickets) {

	   int cnt = 0;
	   
	   for(int i=0;i<tickets.length;i++) {
		if(tickets[i][0].equals("ICN")) 
			cnt++;
	   }
	   
	   String[][] tickets1 = new String[cnt][2];
	   String[][] tickets2 = new String[tickets.length-cnt][2];
	   int j = 0, k=0;
	   for(int i=0;i<tickets.length;i++) {
		   if(tickets[i][0].equals("ICN")) {

			   tickets1[j][0] = tickets[i][0];
			   tickets1[j++][1] = tickets[i][1];
		   }
		   else{
			   tickets2[k][0] = tickets[i][0];
			   tickets2[k++][1] = tickets[i][1];
		   }
			  
	   }
	   
	   
	   Arrays.sort(tickets1, new Comparator<String[]>() {
           @Override
           public int compare(String[] o1, String[] o2) {
        		   if(o1[0].toString().contentEquals(o2[0].toString()))
                       return o1[1].toString().compareTo(o2[1].toString());
                   else
                       return o1[0].toString().compareTo(o2[0].toString());

              
           }			
       });
	   
	   Arrays.sort(tickets2, new Comparator<String[]>() {
           @Override
           public int compare(String[] o1, String[] o2) {
        		   if(o1[0].toString().contentEquals(o2[0].toString()))
                       return o1[1].toString().compareTo(o2[1].toString());
                   else
                       return o1[0].toString().compareTo(o2[0].toString());

              
           }			
       });
	   
	 for(int i=0;i<tickets1.length;i++) {
		 tickets[i][0] = tickets1[i][0];
		 tickets[i][1] = tickets1[i][1];
	 }
	 int m=0;
	 for(int i=cnt;i<cnt+tickets2.length;i++) {
		 tickets[i][0] = tickets2[m][0];
		 tickets[i][1] = tickets2[m++][1];
	 }
	   

	  Queue<String> q = new LinkedList<>();
	   q.add(tickets[0][0]);
	   q.add(tickets[0][1]);
	   	   
	   

	for(int i=1;i<tickets.length;i++) {
		String first = q.poll();
			String second = q.poll();
			if(first!=null)
				answer.add(first);
			if(second!=null)
				answer.add(second);
		if(!check(tickets[i][0], tickets[i][1])){
			q.add(tickets[i][0]);
			q.add(tickets[i][1]);	
			
		}   

   	}
	    String[] result = new String[answer.size()];
   for(int i=0;i<answer.size();i++)
	   result[i] = answer.get(i);
	   
        return result;
    }
}
