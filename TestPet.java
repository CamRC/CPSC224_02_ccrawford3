public class TestPet {
	public static void main(String[] args) {
		String testName;
		String testAnimalType;
		int testAge;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("What is your pet's name? ");
		testName = keyboard.nextLine();
		
		System.out.print("What kind of animal is your pet? ");
		testAnimalType = keyboard.nextLine();
		
		System.out.print("How old is your pet? ");
		testAge = keyboard.nextInt();
		
		Pet testPet = new Pet(testName, testAnimalType, testAge);
		
		System.out.println();
		System.out.println("Here is the data you provided:");
		System.out.println("Name: " + testName);
		System.out.println("Type of animal: " + testAnimalType);
		System.out.println("Age of pet: " + testAge);