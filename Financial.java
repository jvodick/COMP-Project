import java.util.*;
class Financial 
{
	public static void FCalc()
	{
			Scanner keyboard = new Scanner(System.in);
	
			double n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
	
			System.out.println("Please enter a number below to calculate:");
			System.out.println("1. Future Value            2. Present Value"); //test 1 and 2
			System.out.println("3. Ratios                  4. Net Operating Cash Flow"); //test 3
			System.out.println("5. Return on Equity        6. EBITDA"); //test 5 and 6
			System.out.println("7. Previous menu");
	
			int input = keyboard.nextInt();
	
			switch (input)	{
				case 1:
					System.out.println ("Formula: F = C x (1 + r)^t" );
					System.out.println ("Enter your capital depost (C):");
					n1 = keyboard.nextInt();
		
					System.out.println ("Enter your interest rate (r):");
					n2 = keyboard.nextInt();
		
					System.out.println ("Enter time in years (t):");
					n3 = keyboard.nextInt();
					
					n4 = (1 + n2);
					n5 = n1 * (Math.pow((double)n4, (double)n3));
					
					System.out.println ("Your future value is: " + n5);		
					break;
		
				case 2:
					System.out.println ("Formula: P = C / (1 + r)^t");
					System.out.println ("Enter your capital depost (C):");
					n1 = keyboard.nextInt();
		
					System.out.println ("Enter your interest rate (r):");
					n2 = keyboard.nextInt();
		
					System.out.println ("Enter time in years (t):");
					n3 = keyboard.nextInt();
					
					n4 = (1+n2);
					n5 = n1/(Math.pow((double)n4, (double)n3));
		
					System.out.println ("Your present value is: " + n5);
					break;
				
				case 3:
					System.out.println ("Select a ratio:");
					System.out.println ("1. Current Ratio = Current Assets/Current Liabilities");
					System.out.println ("2. Inventory Turnover = Cost of Goods Sold/Inventory");
					System.out.println ("3. Receivables Turnover = Sales/Account Receivable");
					System.out.println ("4. Long-term Debt-to-Capital Ratio = Long-term debt/Long term Debt + Equity");
					System.out.println ("5. Times Interest Earned Ratio = EBIT/Interest");
					System.out.println ("6. Profit Margin = Net Income after Tax/Sales");
					System.out.println ("7. Previous menu");
		
					int ratioInput = keyboard.nextInt();
		
					switch (ratioInput)
					{
					case 1:
						System.out.println ("Please enter your current assets and then your current liabilities:");
						n1 = keyboard.nextInt();
						n2 = keyboard.nextInt();
				
						System.out.println ("Your Current Ratio is " + n1 / n2);
				
						break;
				
					case 2:
						System.out.println ("Please enter your cost of goods sold and then your inventory:");
						n1 = keyboard.nextInt();
						n2 = keyboard.nextInt();
				
						System.out.println ("Your Inventory Turnover is " + n1 / n2);
				
						break;
				
				
					case 3:
						System.out.println ("Please enter your Sales and then your accounts receivable:");
						n1 = keyboard.nextInt();
						n2 = keyboard.nextInt();
				
						System.out.println("Your Receivables Turnover is " + n1 / n2);
				
						break;
				
				
					case 4:
						System.out.println("Please enter your long term debt and then your equity:");
						n1 = keyboard.nextInt();
						n2 = keyboard.nextInt();
						n3 = n1 / (n1 + n2);
				
						System.out.println("Your long-term debt-to-capital ratio is " + n3);
				
						break;
				
					case 5:
						System.out.println("Please enter your Revenue and then your Expenses:");
						n1 = keyboard.nextInt();
						n2 = keyboard.nextInt();
				
						System.out.println("Enter interest:");
						n3 = keyboard.nextInt();
						n4 = (n1 + n2) / n3;
				
						System.out.println("Your times interest earned ratio is " + n4);
				
						break;
				
					case 6:
						System.out.println("Please enter your net income after tax and then your sales:");
						n1 = keyboard.nextInt();
						n2 = keyboard.nextInt();
				
						System.out.println("Your profit margin is " + n1 / n2);
				
						break;
				
					case 7:
						break;
				}
					break;
				
				case 4:
					System.out.println("Net Operating Cash Flow:");
					System.out.println(" ");
					System.out.println("Net income");
					System.out.println("(Increase in inventories)");
					System.out.println("Increase in accounts payable");
					System.out.println("(Increase in accured interest receivable)");
					System.out.println("Increase in accrued interest payable");
					System.out.println("(Gain on sale of property)");
					System.out.println(" ");
					System.out.println("Enter information in this order:");
					n1 = keyboard.nextInt();
					n2 = keyboard.nextInt();
					n3 = keyboard.nextInt();
					n4 = keyboard.nextInt();
					n5 = keyboard.nextInt();
					n6 = keyboard.nextInt();
					n7 = n1 - n2 + n3 - n4 + n5 - n6;
					System.out.println(" ");
					System.out.println("Net Operating Cash flow: " + n7);
					break;
					
				case 5:
					System.out.println("Formula: Return on Equity = Profit Margin x Asset Turnover x Equity Multiplier");
					System.out.println("Enter your Net Income After Taxes, then your Sales, then your Assets, then your Equity on separate lines");
					n1 = keyboard.nextInt();
					n2 = keyboard.nextInt();
					n3 = keyboard.nextInt();
					n4 = keyboard.nextInt();
					n5 = keyboard.nextInt();
					n6 = (n1 / n2) * (n2 / n3) * (n3 / n4);
					System.out.println("Your ROE is " + n6);
					break;
		
		
				case 6:		
					System.out.println("Formula: EBITDA = EBIT + Depreciation + Amortization");
					System.out.println("Calculate EBIT by entering your revenue and then your expenses:");
					n1 = keyboard.nextInt();
					n2 = keyboard.nextInt();
		
					System.out.println("Enter your Depreciation:");
					n3 = keyboard.nextInt();
		
					System.out.println("Enter your Amortization:");
					n4 =  keyboard.nextInt();
					n5 = (n1 + n2) + n3 + n4;
		
					System.out.println("Your EBITDA is: " + n5);
					break;
		
				case 7:
					break;
			}
	}
}
