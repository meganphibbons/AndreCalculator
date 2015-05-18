/**
 * @author Max (BionicPi)
 */

package AndreCalculator;

import java.util.ArrayList;
import java.util.List;

public class DefaultCalculator
{
	private static List<Integer> digits = new ArrayList<Integer>();
	private static List<Integer> digits2 = new ArrayList<Integer>();
	private static List<Integer> results = new ArrayList<Integer>();

	private static List<Integer> digitsDecimal = new ArrayList<Integer>();
	private static List<Integer> digits2Decimal = new ArrayList<Integer>();
	private static List<Integer> resultsDecimal = new ArrayList<Integer>();

	private static boolean negative = false;

	/**
	 * Multiplies two numbers stored as strings. Returns result as a string
	 *
	 * @param first
	 *            the first number (stored as a string to bypass length limits)
	 *            to be multiplied
	 * @param second
	 *            the second number (stored as a string to bypass length limits)
	 *            to be multiplied
	 * @return the product of the inputs, as a string
	 */
	public static String multiply(String first, String second)
	{
		digits = new ArrayList<Integer>();
		digits2 = new ArrayList<Integer>();
		results = new ArrayList<Integer>();
		digitsDecimal = new ArrayList<Integer>();
		digits2Decimal = new ArrayList<Integer>();
		resultsDecimal = new ArrayList<Integer>();

		try
		{
			if ((first.contains("-") || second.contains("-"))
					&& !(first.contains("-") && second.contains("-")))
			{
				negative = true;
			} else
				negative = false;

			first = first.replaceAll("-", "");
			second = second.replaceAll("-", "");

			if (!(first.contains(".") || second.contains(".")))
			{
				for (int i = first.length() - 1; i >= 0; i--)
				{
					digits.add(Integer.parseInt(first.substring(i, i + 1)));
				}

				for (int i = second.length() - 1; i >= 0; i--)
				{
					digits2.add(Integer.parseInt(second.substring(i, i + 1)));
				}
				return intMultiplication();
			} else
			{
				int fDec = first.indexOf(".");
				int sDec = second.indexOf(".");

				for (int i = fDec - 1; i >= 0; i--)
					digits.add(Integer.parseInt(first.substring(i, i + 1)));
				for (int i = first.length() - 1; i > fDec; i--)
					digitsDecimal.add(Integer.parseInt(first
							.substring(i, i + 1)));

				for (int i = sDec - 1; i >= 0; i--)
					digits2.add(Integer.parseInt(second.substring(i, i + 1)));
				for (int i = second.length() - 1; i > sDec; i--)
					digits2Decimal.add(Integer.parseInt(second.substring(i,
							i + 1)));

				// System.out.println(digits + " . " + digitsDecimal + " \n " +
				// digits2 + " . " + digits2Decimal);
				// return decimalMultiplication();
				return "We currently do not support decimals. Sorry.";
			}
		} catch (NumberFormatException e)
		{
			return "Unrecognized charachter. Numbers, decimals, and negative signs only please.";
		} catch (IndexOutOfBoundsException e)
		{
			return "Number too large.";
		}catch(Exception e)
		{
			return "Unknown error.";
		}

	}

	public static String exponent(String base, String power)
	{
		if (power.contains("."))
			return "We do not currently support rationals.";
		else if (Integer.parseInt(power) >= 1)
		{
			Integer decrementPower = Integer.parseInt(power) - 1;
			return multiply(base, exponent(base, decrementPower.toString()));
		} else if (Integer.parseInt(power) < 0)
			return "We don't yet support negative exponents.";
		else if (Integer.parseInt(power) == 0)
			return "1";
		else
			return "An error occured. Please check your inputs for unrecognized charachters.";
	}

	/**
	 * Multiplies and returns two ints stored in the array lists.
	 * 
	 * @return a string containing the product of the ints stored in the
	 *         ArrayLists
	 */
	private static String intMultiplication()
	{

		for (int i = 0; i < digits.size(); i++)
		{
			for (int j = 0; j < digits2.size(); j++)
			{
				try
				{
					results.set(i + j, results.get(i + j) + digits.get(i)
							* digits2.get(j));
				} catch (IndexOutOfBoundsException e)
				{
					for (int c = results.size(); c <= i + j; c++)
						results.add(0);
					results.set(i + j, results.get(i + j) + digits.get(i)
							* digits2.get(j));
				}
			}
		}

		for (int i = 0; i < results.size(); i++)
		{
			if (results.get(i) >= 10)
			{
				try
				{
					results.set(i + 1, results.get(i + 1) + results.get(i) / 10);
				} catch (IndexOutOfBoundsException e)
				{
					results.add(results.get(i) / 10);
				}
				results.set(i, results.get(i) % 10);
			}
		}

		String number = "";
		if (negative)
			number += "-";
		for (int num = results.size() - 1; num >= 0; num--)
		{
			number += results.get(num);
		}
		return number;
	}

	/**
	 * Computes and returns the product of the numbers stored in the ArrayLists
	 * 
	 * @return the product of the numbers stored in the array lists as a String
	 */
	private static String decimalMultiplication()
	{
		for (int i = 0; i < digits.size(); i++)
		{
			for (int j = 0; j < digits2.size(); j++)
			{
				try
				{
					results.set(i + j, results.get(i + j) + digits.get(i)
							* digits2.get(j));
				} catch (IndexOutOfBoundsException e)
				{
					for (int c = results.size(); c <= i + j; c++)
						results.add(0);
					results.set(i + j, results.get(i + j) + digits.get(i)
							* digits2.get(j));
				}
			}
		}

		for (int i = 0; i < digits.size(); i++)
		{
			for (int j = 0; j < digits2Decimal.size(); j++)
			{
				// try
				// {
				if (i - (1 + j) < 0)
					resultsDecimal.set(-(i - (1 + j)), resultsDecimal
							.get(-(i - (1 + j)))
							+ digits.get(i) * digits2Decimal.get(j));
				else
					results.set(i - j, results.get(i - j) + digits.get(i)
							* digits2.get(j));
				// }catch(IndexOutOfBoundsException e)
				// {
				// for(int c = results.size(); c<= i+j; c++)
				// results.add(0);
				// results.set(i+j, results.get(i+j) +
				// digits.get(i)*digits2.get(j));
				// }
			}
		}

		// TODO track tenths place for decimal results, add secondary for loop
		// to multiply the decimals.

		for (int i = 0; i < results.size(); i++)
		{
			if (results.get(i) >= 10)
			{
				try
				{
					results.set(i + 1, results.get(i + 1) + results.get(i) / 10);
				} catch (IndexOutOfBoundsException e)
				{
					results.add(results.get(i) / 10);
				}
				results.set(i, results.get(i) % 10);
			}
		}

		// String number = "";
		// for(int num=results.size()-1; num>=0; num--)
		// {
		// number+=results.get(num);
		// }
		// return number;
		return "This function isn't yet avalible.";
	}
}
