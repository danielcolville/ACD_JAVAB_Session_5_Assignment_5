package session5;
import java.util.Scanner;
public class MatrixCalc {

	public static void main(String[] args) {
		int[][]m1=new int[1][1];
		int[][]m2=new int[1][1];
		int[][]res=new int[1][1];
		Scanner sc=new Scanner(System.in);
		String text="";
		
		System.out.println("Command List:\n Add1 (1) to enter 1st matrix\n Add2 (2) to enter 2nd matrix\n Addition (+) to perform matrix addition\n Difference (-) to perform matrix subtraction");
		System.out.println(" Tranpose (t) to tranpose a matrix\n Multiply (m) to matrix multiply\n Quit (q) to exit");
		do {
			System.out.println("Enter a command:");
			text=sc.next();
			if(text.equalsIgnoreCase("Add1")||text.equalsIgnoreCase("1")) {
				m1=enterMat(sc);
				for(int[] si:m1) {
					for(int i:si) {
						System.out.print(i+",");
					}
					System.out.println();
				}
			}
			else if(text.equalsIgnoreCase("Add2")||text.equalsIgnoreCase("2")) {
				m2=enterMat(sc);
				for(int[] si:m2) {
					for(int i:si) {
						System.out.print(i+",");
					}
					System.out.println();
				}
			}
			else if(text.equalsIgnoreCase("Addition")||text.equalsIgnoreCase("+")) {
				
				res=mAdd(m1,m2);
				for(int[] si:res) {
					for(int i:si) {
						System.out.print(i+",");
					}
					System.out.println();
				}
			}
			else if(text.equalsIgnoreCase("Difference")||text.equalsIgnoreCase("-")) {
				System.out.print("Which Matrix is being subtracted from the other? Enter 1 or 2");
				int in=sc.nextInt();
				if(in==1) {
					res=mDiff(m2,m1);
				}
				else if(in==2) {
					res=mDiff(m1,m2);
				}
				for(int[] si:res) {
					for(int i:si) {
						System.out.print(i+",");
					}
					System.out.println();
				}
			}
			else if(text.equalsIgnoreCase("Transpose")||text.equalsIgnoreCase("t")) {
				System.out.print("Which to transpose? Enter 1 or 2");
				int in=sc.nextInt();
				if(in==1) {
					res=transpose(m1);
					for(int[] si:res) {
						for(int i:si) {
							System.out.print(i+",");
						}
						System.out.println();
					}
				}
				else if(in==2) {
					res=transpose(m2);
					for(int[] si:res) {
						for(int i:si) {
							System.out.print(i+",");
						}
						System.out.println();
					}
				}
			}
			else if(text.equalsIgnoreCase("Multiply")||text.equalsIgnoreCase("m")) {
				System.out.print("Which is first matrix in multiplication? Enter 1 or 2");
				int in=sc.nextInt();
				if(in==1) {
					res=matMult(m1,m2);
				}
				else if(in==2) {
					res=matMult(m2,m1);
				}
				for(int[] si:res) {
					for(int i:si) {
						System.out.print(i+",");
					}
					System.out.println();
				}
			}
			else if(text.equalsIgnoreCase("Quit")||text.equalsIgnoreCase("1")) {
				break;
			}
			else {
				System.out.println("Invalid option.  Try:\n Add1 (1) to enter 1st matrix\n Add2 (2) to enter 2nd matrix\n Addition (+) to perform matrix addition\n Difference (-) to perform matrix subtraction");
				System.out.println(" Tranpose (t) to tranpose a matrix\n Multiply (m) to matrix multiply\n Quit (q) to exit");
			}
		}while(true);
		
		
	}
	public static int[][] enterMat(Scanner sc) {
		System.out.println("Enter number of rows matrix 2");
		int rows=sc.nextInt();
		System.out.println("Enter number of cols matrix 2");
		int cols=sc.nextInt();
		int[][] m2=new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print("Enter next number:");
				m2[i][j]=sc.nextInt();
			}
		}
		return m2;
	}
	public static int[][] mAdd(int[][] m1,int[][]m2) {
		int [][]m3=new int[m1.length][m1[0].length];
		if(m1.length==m2.length) {
			for(int i=0;i<m1.length;i++) {
				for(int j=0;j<m1[i].length;j++) {
					m3[i][j]=m2[i][j]+m1[i][j];
				}
			}
		}
		else {
			System.out.println("Can't add matrices with dimensions that don't match");
			return null;
		}
		return m3;
	}
	public static int[][] mDiff(int[][] m1,int[][]m2) {
		int [][]m3=new int[m1.length][m1[0].length];
		if(m1.length==m2.length) {
			for(int i=0;i<m1.length;i++) {
				for(int j=0;j<m1[i].length;j++) {
					m3[i][j]=m1[i][j]-m2[i][j];
				}
			}
		}
		else {
			System.out.println("Can't add matrices with dimensions that don't match");
			return null;
		}
		return m3;
	}
	public static int[][] transpose(int[][] m1) {
		int [][] m2=new int[m1[0].length][m1.length];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;j<m1[i].length;j++) {
				
				m2[i][j]=m1[j][i];
				//System.out.print(m2[i][j]+" "+m1[i][j]);
			}
		}
		return m2;
	}
	public static int[][] matMult(int[][]m1,int[][]m2) {
		if(m1[0].length!=m2.length) {
			System.out.println("Matrix dimensions do not match for multiplication(i.e number of columns in 1st does not equal rows in 2nd)");
		}
		int[][]m3=new int[m1.length][m1[0].length];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;j<m1[0].length;j++) {
				int sum=0;
				int k=0;
				while(k<m1[i].length && k<m2.length) {
					sum+=m1[i][k]*m2[k][j];
					k++;
				}
				m3[i][j]=sum;
			}
		}
		return m3;
	}
	
}
