import java.util.ArrayList;
import java.util.Random;
public class hi
{
    public static void main(String[] args)
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 100; i ++ )
        {
            numbers.add(rand.nextInt(2 , 100));
        }

        for(int val : numbers)
        {
            System.out.print(val + " ");
        }

        for (int val : numbers)
        {
            if(hello(val) == false)
            {
                numbers.remove(val);

            }
        }





    }
    public boolean hello(number)
    {
        for (int i = 0; i < 10; i++)
        {
            if (number % i == 0)
            {
                return true;

            }


        }

    }
}       