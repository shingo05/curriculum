package check;

import constants.Constants;

public class Check {
	
	private static String firstName = "西田";
	private static String lastName = "進悟";
	

	private static String printName(String firstName, String lastName) {
		return firstName + lastName;
		
	}

	
	public static void main(String[] args) {
		
		System.out.println("printNameメゾット → " + (printName(firstName,lastName)));

		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
		pet.introduce();
		
		RobotPet Robo = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
		Robo.introduce();
		
	}

}
