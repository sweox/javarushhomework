package golovach;

public class ArrayInverter
{
    public static void Invert(int[] data)
    {
        for (int k = 0; k < data.length / 2; k++)
        {
            int tmp = data[k];
            data[k] = data[data.length - 1 - k];
            data[data.length - 1 - k] = tmp;
        }
    }
    public static void InvertRec(int[] data, int k)
    {
        if (k < data.length / 2)
        {
            int tmp = data[k];
            data[k] = data[data.length - 1 - k];
            data[data.length - 1 - k] = tmp;
            InvertRec(data, k + 1);
        }
    }
}
