package test;

import java.util.Scanner;


public class SpiderMatrix {
	public static void spider(int input){
		int downRow=0;
		int upRow=input-1;
		int forwardColumn=0;
		int backwordColum=input-1;
		int element=1;
		int[][] matrix=new int[input][input];
		
		while(element<=input*input){
			for(int i=forwardColumn;i<=backwordColum;i++){
				matrix[downRow][i]=element++;
			}
			for(int i=downRow+1;i<=upRow;i++){
				matrix[i][backwordColum]=element++;
			}
			for(int i=backwordColum-1;i>=forwardColumn;i--){
				matrix[upRow][i]=element++;
			}
			for(int i=upRow-1;i>downRow;i--){
				matrix[i][forwardColumn]=element++;
			}
			
			forwardColumn++;
			backwordColum--;
			downRow++;
			upRow--;
		}
		
		for(int i=0;i<input;i++){
			for(int x=0;x<input;x++){
				System.out.format("%3d",matrix[i][x]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		//System.out.println("Please enter the number for generating Spider matrix");
		//int input=new Scanner(System.in).nextInt();
		spider(5);
	}

}
