import java.util.*;

public class palindrome
{
    public static void main(String[] args)
    {
        System.out.println("Enter the number you want to check for palindrome : ");
        Scanner sc = new Scanner(System.in);
        int number , reversedInteger = 0, remainder, originalInteger;
        number = sc.nextInt();
        originalInteger = number;
        while( number != 0 )
        {
            remainder = number % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            number  /= 10;
        }

        if (originalInteger == reversedInteger)
            System.out.println(originalInteger + " is a palindrome.");
        else
            System.out.println(originalInteger + " is not a palindrome.");
    }

}
