package Matrices;

public class Transpose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[][] transpose = new Integer[3][3];
        
        transpose[0][0] = 1;
        transpose[0][1] = 2;
        transpose[0][2] = 3;
        transpose[1][0] = 4;
        transpose[1][1] = 5;
        transpose[1][2] = 6;
        transpose[2][0] = 7;
        transpose[2][1] = 8;
        transpose[2][2] = 9;
        
        
        for(int i = 0; i < 3; i++){
        	for(int j = 0; j <3 ; j++){
        		System.out.print(transpose[i][j] + " ");
        	}
        	System.out.println();
        }
        
        
        for(int i = 0; i < 3; i++){
        	for(int j = i; j < 3; j++){
        		int temp = transpose[i][j];
        		
        		transpose[i][j] = transpose[j][i];
        		transpose[j][i] = temp;
        	}
        }
        
        System.out.println();
        
        for(int i = 0; i < 3; i++){
        	for(int j = 0; j <3 ; j++){
        		System.out.print(transpose[i][j] + " ");
        	}
        	System.out.println();
        }
        
	}

}
