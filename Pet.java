public class Pet {
	private String name;
	private String animalType;
	private int age;
	
	public Pet(String name, String animalType, int age) {
		this.name = name;
		this.animalType = animalType;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAnimal(String animalType) {
		this.animalType = animalType;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAnimal() {
		return animalType;
	}
	
	public int getAge() {
		return age;
	}
}