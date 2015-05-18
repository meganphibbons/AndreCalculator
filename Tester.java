package AndreCalculator;

public class Tester
{
	public static void main(String[] args)
	{
		String first = "10.01";
		String second = "20.02";
		System.out.println(first + " times " + second);
		DefaultCalculator.multiply(first, second);
		
		String base = "2";
		String power = "1024";
		System.out.println(DefaultCalculator.exponent(base, power));
	}
}
