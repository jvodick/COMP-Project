public class matrixMultiplier2
{	
int[][] ab;
public int [][] multipliedMatrix (int[][] a, int[][] b)
{
	ab = new int [3][3];
	ab[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0]));			//populates row 1
	ab[0][1] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1]));
	ab[0][2] = ((a[0][0] * b[0][2]) + (a[0][1] * b[1][2]));
	
	ab[1][0] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0]));			//populates row 2
	ab[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1]));
	ab[1][2] = ((a[1][0] * b[0][2]) + (a[1][1] * b[1][2]));
	
	ab[2][0] = ((a[2][0] * b[0][0]) + (a[2][1] * b[1][0]));			//populates row 3
	ab[2][1] = ((a[2][0] * b[0][1]) + (a[2][1] * b[1][1]));
	ab[2][2] = ((a[2][0] * b[0][2]) + (a[2][1] * b[1][2]));
	
	return ab;
	
		
}

public void display()
{		System.out.println("Multiplied matrix:");
		int count = 0;
		for(int row = 0; row < ab[0].length; row++)
		{
			
			count++;
			System.out.println("row " + count + ":");
			System.out.println(ab[row][0]);
			System.out.println(ab[row][1]);
			System.out.println(ab[row][2]);
		}
}

}