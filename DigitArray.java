public class DigitArray
{
    public static <int> createDigitArr(List<int> digarr, int size)
    {
        for(int i = 0; i < size; i++)
        {
            digarr.add(new int(0));
        }
        return digarr;
    }
}
