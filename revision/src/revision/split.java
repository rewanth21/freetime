package revision;

public class split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = new String("hello/world/block");
      String[] array = s.split("\n");
      String[] array2 = new String[1];
      for(String s1 :array){
    	  String s2 = s1;
    	  String s3 = s2.replaceAll("/", " ");
    	  System.out.println(s3);
    	  array2[0] = s3;
      }
      for(int i = 0; i< array2.length; i++){
    	  System.out.println(array2[i]);
      }
	}

}
