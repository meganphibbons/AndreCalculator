public class AndreCalculator
{
	private static ArrayList digits = new ArrayList<int>;
	private static ArrayList digits2 = new ArrayList<int>;
	private static ArrayList results = new ArrayList<int>;
	//private static final int size = 50;

	//private static void fillArrs()
	//{
	//	digits = DigitArray.createDigitArr(digits, size);
	//	digits2 = DigitArray.createDigitArr(digits2, size);
		//results = DigitArray.createDigitArr(results, size);
	//}
	
	/**
	 *
	 *@param first the first integer to be multiplied
	 *@param second the second integer to be multiplied
	 */
	public static void multiply(int first, int second)
	{
		int f = first;
		int s = second;
		while(f/10 >= 0)
		{
			digits.add(f%10);
			f /= 10;
		}
		while(s/10 >= 0)
		{
			digits.add(s%10);
			s /= 10;
		}

//for(int i=0; i< digits.size(); i++)
//{
//for(int j = 0; j<digits2.size(); j++)
//{
//results.set(i, results.get(i) + digits.get(i)*digits2.get(j));
//}
//}
	}

	/**
	 *@param first the first double to be multiplied
	 *@param second the second double to be multiplied
	 */
	public static void multiply(double first, double second)
	{

	}

	/**
	 *@param first the first number (stored as a string to bypass length limits) to be multiplied
	 *@param second the second number (stored as a string to bypass length limits) to be multiplied
	 */
	public static void multiply(String first, String second)
	{

	}
}
