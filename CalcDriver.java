import java.util.*;	
public class CalcDriver
{
	public static void main (String[] args)
	{
		boolean again = true;
		Scanner keyboard = new Scanner(System.in);
		while(again == true)
		{
			System.out.println("what program would you like to use?  Your options are:");
			System.out.println("1. Matrix Multiplication");
			System.out.println("2. Financial Calculator");
			System.out.println("3. Statistics Calculator");
			int program  = keyboard.nextInt();
			switch (program)
			{
				case 1:
					int[][] a = new int [3][2];
					int[][] b = new int [2][3];
					System.out.println("enter the integers for your first matrix (3 rows by 2 columns)");
					System.out.println("***read numbers from left to right starting from the top row down***");						
					System.out.println("row 1:"); // populates matrix a explicitly through user input
					int  ar11, ar12;
					ar11 = keyboard.nextInt();
					ar12 = keyboard.nextInt();
					a[0][0] = ar11;
					a[0][1] = ar12;
					System.out.println("row 2:");
					int  ar21, ar22;																
					ar21 = keyboard.nextInt();
					ar22 = keyboard.nextInt();
					a[1][0] = ar21;
					a[1][1] = ar22;
					System.out.println("row 3:");
					int  ar31, ar32;
					ar31 = keyboard.nextInt();
					ar32 = keyboard.nextInt();	
					a[2][0] = ar31;
					a[2][1] = ar32;
					System.out.println("enter the integers for your second matrix (2 rows by 3 columns)");
					System.out.println("***read numbers from left to right starting from the top row down***");		
					System.out.println("row 1:");									// populates matrix b explicitly through user input
					int  br11, br12, br13;
					br11 = keyboard.nextInt();
					br12 = keyboard.nextInt();
					br13 = keyboard.nextInt();
					b[0][0] = br11;
					b[0][1] = br12;
					b[0][2] = br13;
					System.out.println("row 2:");									
					int  br21, br22, br23;
					br21 = keyboard.nextInt();
					br22 = keyboard.nextInt();
					br23 = keyboard.nextInt();
					b[1][0] = br21;
					b[1][1] = br22;
					b[1][2] = br23;	
					matrixMultiplier2 Matrix = new matrixMultiplier2();																				
					Matrix.multipliedMatrix(a, b);
					Matrix.display();
					break;
				case 2:
					Financial test = new Financial();
					test.FCalc();
					break;
				case 3:
					System.out.println();
					System.out.println("how many data points do you have to enter?");
					int length = keyboard.nextInt();
					double[] data = new double[length];
					for(int i = 0; i<length; i++)
					{
						System.out.println("please enter your next number");
						data[i] = keyboard.nextDouble();
					}
					Statistics dataSet = new Statistics(data);
					dataSet.writeOutput();
					break;
			}
			System.out.println("do you want to do something else?");
			String answer = keyboard.nextLine();
			answer = keyboard.nextLine();
			System.out.println("the answer is " + answer);
			boolean answer2 = answer.equalsIgnoreCase("no");
			System.out.println("the answer is " + answer2);
			if (answer2 == true)
			{
				again = false;
			}
		}
		
	}
}