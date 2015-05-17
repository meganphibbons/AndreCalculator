package AndreCalculator;

public class Tester
{
	public static void main(String[] args)
	{
		String first = "10.01";
		String second = "20.02";
		System.out.println(first + " times " + second);
		DefaultCalculator.multiply(first, second);
	}
}
