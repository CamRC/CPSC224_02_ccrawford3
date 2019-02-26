//imports
import javax.swing.*;

public class Hangman
{
	public static void main(String[] args)
	{
		printMenu();
	}
	
	public static void printMenu()
	{
		int userInt = 0;
		String temp = JOptionPane.showInputDialog("1: Play the game from a randomly chosen word\n2: Play the game from a word entered by another user \n3: Exit the game...");
		userInt = Integer.parseInt(temp);
		
		while (userInt != 3)
		{
			if(userInt > 0 && userInt < 4)
			{
				switch (userInt)
				{
					case 1:
						File wordList = new File("wordList.txt");
						Scanner read = new Scanner(wordList);
						int rand = (int) Math.random() * 49 + 1;
						String randomWord;
						for(int i = 0; i < rand; i++) {
							randomWord = read.nextLine();
						}
						runProgram(randomWord);
						break;
					
					case 2:
						String word = JOptionPane.showInputDialog("Input a word to be guessed:");
						runProgram(word);
						break;
						
					case 3:
						JOptionPane.showMessageDialog(null, "Thank you for playing!");
						break;
				}
			}
			else 
			{
				JOptionPane.showInputDialog("That is not a valid input, please enter: 1, 2, or 3");
			}
		}
	}
	
	public static void runProgram(String word)
	{
		boolean correct = false;
		int numOfGuesses = 0;
		char[] wordArray = word.toCharArray();
		boolean[] correctPlaces = new boolean[word.length()];
		
		for(int i = 0; i < word.length(); i++) {
			correctPlaces[i] = false;
		}
		
		String blank = "";
		for(int i = 0; i < word.length(); i++) {
			blank = blank + "_";
		}
		
		JOptionPane.showMessageDialog(null, "**HANGMAN**\n**************\n--------------\n" + blank + "\n--------------\n**************");
		while (!correct || numOfGuesses < 6)
		{
			char guess = JOptionPane.showInputDialog("Please guess a letter: ").charAt(0);
			
			for(int j = 0; j < word.length(); j++)
			{
				//change so they don't have to correctly guess in order 
				if (guess == wordArray[j])
				{
					correctPlaces[j] = true;
				}
			}
			String outputWord = "";
			for(int i = 0; i < word.length(); i++) {
				if(correctPlaces[i] == false) {
					outputWord = outputWord + "_";
				} else {
					outputWord = outputWord + wordArray[i];
				}
			}
			JOptionPane.showMessageDialog(null, "**HANGMAN**\n**************\n--------------\n" + outputWord + "\n--------------\n**************");
		}
		
		if (correct)
		{
			// might need to be in a dialog box 
			JOptionPane.showMessageDialog(null, "Congrats! You guessed correctly. The word was " + word);
		}
		
		//calls print menu again to see if they want to repeat the game
		printMenu();
	}
	
	
	
	
	
}