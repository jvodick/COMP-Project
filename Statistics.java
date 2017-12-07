/*
will have an object that is an array and to which different statistics functions can be performed
will be able to pass in a text document to create an array or multiple arrays
make it draw box and whisters plots. 
*/
import java.util.Scanner;
import java.io.*;
public class Statistics
{
	private double[] data;
	private double range;
	private double mean;
	private double median;
	private int n;
	private double geometricMean;
	private double varience;
	private double standardDeviation;
	private double coefficientOfVariation;
	private double meanAbsoluteDeviation;
	private double upperQuartile;
	
	public Statistics(double[] data)
	{
		this.data = data;
		n = data.length;
	}
	
	//inset methods or construtors to read from files here
	public Statistics (String dataFile)
	{
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner (new File (dataFile));
		}
		catch(FileNotFoundException e)
		{
			System.out.println ("Error opening the file " +
                    dataFile );
                    System.exit (0);
		}
		int length = Integer.parseInt(inputStream.nextLine());
		data = new double[length];
		for (int i = 0; i<length; i++)
		{
			data[i] = Double.parseDouble(inputStream.nextLine());
		}
		inputStream.close ();
		n = length;
	}
	
	public void sortArray()//sorts the array to be able to do other functions to it
	{
		boolean sort = true;
		while (sort == true)
		{
			sort = false;
			for(int i = 0; i < n-1; i++)
			{
				if (data[i] > data[i+1])
				{
					interchange(i, i+1, data);
					sort = true;
				}
			}
		}
	}
	
	private void interchange(int i, int j, double [] a)
	{
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public double range()  //method to find the range
	{
		this.sortArray(); 
		range = data[n-1] - data[0];  //finding the range, get the biggest - smallest 
		return range;
	}
	
	public double mean()   //method to find mean
	{
		this.sortArray();
		double sum = 0;
		for (int i = 0; i < n; i++)
		{
			sum = sum + data[i];
		}
		mean = sum/n;
		return mean;
	}
	
	public double median()   //method to find the median
	{
		this.sortArray();
		if(n%2 == 0)
		{
			int topMiddle = (n)/2;
			int bottomMiddle = (n-2)/2;
			double sumMiddles = data[topMiddle]+ data[bottomMiddle];
			median = sumMiddles/2;
		}
		else // if if the length of the array is odd. 
		{
			int middle = (n-1)/2;
			median = data[middle];
		}
		return median;
	}
	
	public double geometricMean() //mutiplies all data and then takes the nth root 
	{
		//check to make sure all in array is more than 0
		boolean positive = true;
		for (int i = 0; i < n; i++)
		{
			if(data[i]<0)
			{
				positive = false;
			}
		}
		double product = 1;
		if (positive == true)
		{
			for (int i = 0; i < n; i++)
			{
				product = product * data[i];
			}
			geometricMean = Math.pow(product, 1.0/n);
		}
		else
		{
			System.out.println("geometric mean cannot be found becuase the data contains a number lower than zero");
		}
		return geometricMean;
	}
	//method to find lower quartile
	//method to find upper quartile
	
	public double varience()
	{
		this.mean();
		double sum = 0;
		for (int i = 0; i<n; i++)
		{
			double num = data[i] - mean;
			double num2 = Math.pow(num,2);
			sum = sum + num2;
			
		}
		varience = sum/n;
		return 	varience;	
	}
	
	public double standardDeviation()
	{
		this.varience();
		standardDeviation = Math.sqrt(varience);
		return standardDeviation;
	}
		
	public double coefficientOfVariation()
	{
		coefficientOfVariation = (standardDeviation/mean);
		return coefficientOfVariation;
	}
	
	public double meanAbsoluteDeviation()
	{
		this.mean();
		double sum = 0;
		for (int i = 0; i<n; i++)
		{
			double num = data[i] - mean;
			num = Math.abs(num);
			sum = sum + num;
		}
		meanAbsoluteDeviation = sum/n;
		return meanAbsoluteDeviation;
	} 
	
	/*public double upperQuartile()
	{
		this.median();
		
	}*/// finish this one when i can get back to my computer 
	
	public void toFile()
	{
		 PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter ("dataAnalysis.txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println ("Error opening the file " +
                    "dataAnalysis.txt");
            System.exit (0);
        }
		outputStream.println("the sorted array you entered is: ");
		for (int i = 0; i < data.length; i++)
		{
			outputStream.print(data[i] + " ");
		}
		outputStream.println();
		outputStream.println("the range is: " + this.range());
		outputStream.println("the mean is: " + this.mean());
		outputStream.println("the meadian is: "+ this.median());
		outputStream.println("the geo mean is: " + this.geometricMean());
		outputStream.println("the varience is: " + this.varience());
		outputStream.println("the standard Deviation is: " + this.standardDeviation());
		outputStream.println("the coefficient Of Variation is: " + this.coefficientOfVariation());
		outputStream.println("the mean Absolute Deviation is: " + this.meanAbsoluteDeviation());
		outputStream.close();
	}
	
	
	public boolean equals(double otherdata[])
	{
		boolean dataMatches = true;
		System.out.println("the boolean is originally" + dataMatches);
		if (data.length != otherdata.length)
		{
			dataMatches = false;
			System.out.println("the boolean is now" + dataMatches);
		}
		else //same length
		{
			for (int i = 0; i<n; i++)
			{
				if (data[i] != otherdata[i])
				{
					dataMatches = false;
					System.out.println("the boolean is now" + dataMatches);
				}
			}
		}
		
		return dataMatches;
	}
	
	//eventually make another equals method that sorts the arrays//
	public void writeOutput()
	{
		
		this.sortArray();
		System.out.println("the sorted array you entered is: ");
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + " ");
		}
		System.out.println();
		System.out.println("the range is: " + this.range());
		System.out.println("the mean is: " + this.mean());
		System.out.println("the meadian is: "+ this.median());
		System.out.println("the geo mean is: " + this.geometricMean());
		System.out.println("the varience is: " + this.varience());
		System.out.println("the standard Deviation is: " + this.standardDeviation());
		System.out.println("the coefficient Of Variation is: " + this.coefficientOfVariation());
		System.out.println("the mean Absolute Deviation is: " + this.meanAbsoluteDeviation());
		this.toFile();
	}
	
	public static void main(String[] args)
	{
		//double[] data = {3, 4, 1, 2, 5, 6};
		Statistics dataSet = new Statistics("statdata.txt");
		/*dataSet.sortArray();
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + " ");
		}	
		System.out.println();
		System.out.println("the range is: " + dataSet.range());
		System.out.println("the mean is: " + dataSet.mean());
		System.out.println("the geo mean is: " + dataSet.geometricMean());
		System.out.println("the varience is: " + dataSet.varience());
		System.out.println("the sd is: " + dataSet.standardDeviation());
		System.out.println("the coefficientOfVariation is: " + dataSet.coefficientOfVariation());
		System.out.println("the meanAbsoluteDeviation is: " + dataSet.meanAbsoluteDeviation());
		double[] data2 = {3, 4, 1, 2, 5, 6};
		Statistics dataSet2 = new Statistics(data2);
		for (int i = 0; i < data2.length; i++)
		{
			System.out.print(data2[i] + " ");
		}
		System.out.println();
		boolean same = dataSet.equals(dataSet2);
		System.out.println(same);
		dataSet.toFile();
		
		
		        ___________
		l______l     l     l________l
		l      l_____l_____l        l
		*/
		dataSet.writeOutput();
		
		
		
	}
}
