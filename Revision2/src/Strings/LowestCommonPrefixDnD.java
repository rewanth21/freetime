package Strings;

public class LowestCommonPrefixDnD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings= {"geeksforgeeks", "geeks",
                "geek", "geezer"};
		
		int n = strings.length;
		String ans = commonPrefix(strings, n);
		
		if(ans.length() > 0){
			System.out.println("the longest common prefix is " + ans);
		}
		else 
			System.out.println("There is no common prefix");
		
	}
	
	static String commonPrefix(String arr[], int n){
		String prefix = arr[0];
		
		for(int i = 1; i <= n-1; i++){
			prefix = commonPrefixUtil(prefix, arr[i]);
		}
		
		
		return(prefix);
	}
	
	
	static String commonPrefixUtil(String str1, String str2){
		String result = "";
		int n1 = str1.length(), n2 = str2.length();
		
		int i = 0, j = 0;
		
		while( i < n1 && j < n2){
			if(str1.charAt(i) != str2.charAt(j))
				break;
			
			result = result + str1.charAt(i);
			i++;
			j++;
		}
		
		
		
		return result;
	}
	
}
