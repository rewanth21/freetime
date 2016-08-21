package revision;

public class Interface extends Hobbit{
  public static void main(String[] args){
	  int myGold = 7;
	  System.out.println(countGold(myGold, 6));
  }
}

class Hobbit{
	public static int countGold(int x, int y){
		return x + y;
	}
}
