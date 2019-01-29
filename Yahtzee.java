import java.lang.Math.*;
import java.util.*;

public class Yahtzee
{
	public static void main(String [] args)
	{
		final int DICEINPLAY = 5;
		int[] hand = new int[DICEINPLAY];
		//srand (time(0));
		char playAgain = 'y';
		Scanner scnr = new Scanner(System.in);
		
		while(playAgain == 'y')
		{
			String keep = "nnnnn";
			int turn = 1;
			
			while (turn < 4 && keep != "yyyyy")
			{
				for (int dieNumber = 0; dieNumber < DICEINPLAY; dieNumber++)
				{
					if (keep.substring(dieNumber, dieNumber + 1).charAt(0) != 'y')
					{//come back to this
						hand[dieNumber] = rollDice();
					}
				}
				
				System.out.println("Your roll was: ");
				for (int dieNumber = 0; dieNumber < DICEINPLAY; dieNumber++)
					System.out.println(hand[dieNumber] + " ");
				
				if (turn < 3)
				{
					System.out.println("Enter dice to keep (y or n) ");
					keep = scnr.nextLine();
				}
				turn++;
			}
			
			sortArray(hand, DICEINPLAY);
			System.out.println("Here is your sorted hand: ");
			
			for (int dieNumber = 0; dieNumber < DICEINPLAY; dieNumber++)
				System.out.println(hand[dieNumber] + " ");
			
			for (int dieValue = 1; dieValue <= 6; dieValue++)
			{
				int currentCount = 0;
				for (int diePosition = 0; diePosition < 5; diePosition++)
				{
					if (hand[diePosition] == dieValue)
						currentCount++;
				}
				System.out.print("Score " + dieValue * currentCount + " on the ");
				System.out.println(dieValue + " line");
			}
			//lower scorecard
			if (maxOfAKindFound(hand) >= 3)
			{
				System.out.print("Score " + totalAllDice(hand) + " on the ");
				System.out.println("3 of a Kind line");
			}
			else 
				System.out.println("Score 0 on the 3 of a Kind line");

			if (maxOfAKindFound(hand) >= 4)
			{
				System.out.print("Score " + totalAllDice(hand) + " on the ");
				System.out.println("4 of a Kind line");
			}
			else 
				System.out.println("Score 0 on the 4 of a Kind line");

			if (fullHouseFound(hand))
				System.out.println("Score 25 on the Full House line");
			else
				System.out.println("Score 0 on the Full House line");

			if (maxStraightFound(hand) >= 4)
				System.out.println("Score 30 on the Small Straight line");
			else
				System.out.println("Score 0 on the Small Straight line");

			if (maxStraightFound(hand) >= 5)
				System.out.println("Score 40 on the Large Straight line");
			else
				System.out.println("Score 0 on the Large Straight line");

			if (maxOfAKindFound(hand) >= 5)
				System.out.println("Score 50 on the Yahtzee line");
			else
				System.out.println("Score 0 on the Yahtzee line");

			System.out.print("Score " + totalAllDice(hand) + " on the ");
			System.out.println("Chance line");
			System.out.println("\nEnter 'y' to play again ");
			playAgain = scnr.nextLine().charAt(0);
		}
		
		
	}
	
	//method that simulates the role of a single die
	public static int rollDice()
	{
		int roll = (int) (Math.random() * 6 + 1);
		return roll;
	}
	
	//method that returns the count of the die value occurring most in the hand, but not the value itself
	public static int maxOfAKindFound(int hand[]) 
	{
		int maxCount = 0;
		for (int dieValue = 1; dieValue <= 6; dieValue++)
		{
			int currentCount = 0;
			for(int diePostion = 0; diePostion < 5; diePostion++)
			{
				if (hand[diePostion] == dieValue)
					currentCount++;
			}
			if (currentCount > maxCount)
				maxCount = currentCount;
		}
		return maxCount;
	}
	
	//method that returns the total value of all dice in a hand
	public static int totalAllDice(int hand[]) 
	{
		int total = 0;
		for (int diePostion = 0; diePostion < 5; diePostion++)
			total += hand[diePostion];
		
		return total;
	}
	
	public static void sortArray (int array[], int size)
	{
		boolean swap;
		int temp;
		
		do
		{
			swap = false;
			for (int count = 0; count < (size - 1); count++)
			{
				if (array[count] > array[count + 1])
				{
					temp = array[count];
					array[count] = array[count + 1];
					array[count + 1] = temp;
					swap = true;
				}
			}
		} while(swap);
	}
	
	public static int maxStraightFound(int hand[])
	{
		int maxLength = 1;
		int curLength = 1;
		
		for (int counter = 0; counter < 4; counter++)
		{
			if (hand[counter] + 1 == hand[counter + 1])
				curLength++;
			else if (hand[counter] + 1 < hand[counter + 1])
				curLength = 1;
			if (curLength > maxLength)
				maxLength = curLength;
		}
		return maxLength;
	}
	
	public static boolean fullHouseFound(int hand[])
	{
		boolean foundFH = false;
		boolean found3K = false;
		boolean found2K = false;
		
		for (int dieValue = 1; dieValue <= 6; dieValue++)
		{
			int currentCount = 0;
			for (int diePostion = 0; diePostion < 5; diePostion++)
			{
				if (hand[diePostion] == dieValue)
					currentCount++;
			}
			if (currentCount == 2)
				found2K = true;
			if (currentCount == 3)
				found3K = true;
		}
		if (found2K && found3K)
			foundFH = true;
		
		return foundFH;
	}
	
	
	
	
} //closing class bracket


