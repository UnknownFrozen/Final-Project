package mainPackage;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;



/**
 * Code used to generate a random amount of numbers where it will find the total, average, highest, and lowest of these numbers.
 * @author Keegan
 *
 */
public class FinalProjectV2 {
	
	/**
	 * Main function calls separate "runCode()" function in order to generate and calculate numbers.
	 * @param argv
	 */
	public void main (String[] argv){
		runCode();
    }
	
	/**
	 * Function used to generate numbers and calculate different things based on the numbers generated.
	 */
	@Test
	public void runCode() {
		//Scanner variable that will be used to get user input later on in the code.
				Scanner input = new Scanner(System.in);
				//Random number variable that will be used to randomly generate number depending on given parameters.
				Random rand = new Random();
				
				//Initializing variables that will be used later in while loop to determine the final information of the generated numbers
		        int total;
		        double average;
		        int highest;
		        int lowest;
		        
				//Initializing variables that will be used for determining how many numbers to generate and the highest value they could be.
		        int totalNumbers = rand.nextInt(100);
		        int range = 100;
		        
		        //Variable that will be used to assign the various user inputs at the end of the code.
		        String userInput;        
		        
		        //Variables used with user input to decide if the code repeats or if user decides their own parameters.
		        boolean par = false;
				boolean run = true;
				
				//While loop used to keep running code if user chooses.
				while(run) {
					
					total = 0;
			        average = 0;

			        highest = 0;
			        lowest = 0;
					
			        //Assigns a random total number to generate if user decided not to define their own parameters at the end of the first run.
			        if (!par) {
			        	totalNumbers = rand.nextInt(100);
			        }
			        
			        //Generates the numbers and puts them in array based on the totalNumber (Total numbers generated) and range (Range of generated numbers) variables.
			        int[] numbers = new int[totalNumbers];
			        for(int i = 0; i < totalNumbers; i++){
			            numbers[i] = rand.nextInt(range);
			        }
			        
			        

			        //Determines final information like total, highest, and lowest from generated numbers using for loop.
			        int temp = 0;
			        for(int i = 0; i < totalNumbers; i++){
			            temp = numbers[i];
			            total += temp;
			        
			            if(i == 0){
			                lowest = temp;
			            }
			            else if (lowest > temp) {
			                lowest = temp;
			            }

			            if (temp > highest){
			                highest = temp;
			            }
			        }
			        average = total/totalNumbers;
			        
			        //Outputting final information to the console based on generated values.
			        System.out.println("");
			        System.out.println("------ Outcome ------");
			        System.out.println("");
			        System.out.println("There were " + totalNumbers + " numbers generated with a range of 0-" + range);
			        System.out.println("The highest number generated was: " + highest);
			        System.out.println("The lowest number generated was: " + lowest);
			        System.out.println("The total of these numbers was " + total + " with a average of " + average);
			        System.out.println("");
			        System.out.println("--- Code as reached the end, Press enter to continue ---");
			        input.nextLine();

			        //Question to the user to see if code should be restarted.
			        System.out.println("Do you wish to restart the code? (Y/N)");
			        userInput = input.nextLine();
		        	//Checking with function if input is valid, repeats question till system gets valid answer.
			        userInput = inputCheck(userInput, "Do you wish to restart the code? (Y/N)");
			        
			        
			        //If the user decides to restart the code by inputing "Y",
			        //The system will proceed to the next steps of restarting the code.
			        if (userInput.equals("Y") || userInput.equals("y")) {
			        	run = true;
			        	
			        	//Once the user decides to restart the code, the system asks if the user wants to define their own parameters for the next run.
			        	System.out.println("Define your own parameters for this run? (Y/N)");
			        	userInput = input.nextLine();
			        	//Checking with function if input is valid, repeats question till system gets valid answer.
			        	userInput = inputCheck(userInput, "Define your own parameters for this run? (Y/N)");
			        	
			        	//If the users decides to define their own parameters by inputing "Y",
			        	//The system will ask the users to define the specific number of values to generate and the range of the generated values.
			        	if (userInput.equals("Y") || userInput.equals("y")) {
			        		par = true;
			        		System.out.println("");
			        		System.out.println("Enter total number of values to generate: ");
			        		totalNumbers = input.nextInt();
			        		
			    			System.out.println("Enter highest possible value: ");
			    			range = input.nextInt();
			    			input.nextLine();
			        	}
			        	//If the users decides not to define their own parameters by inputing "N",
			        	//The system will generate it's own values like the initial first run.
			        	else {
			        		par = false;
			        		System.out.println("System will generate random parameters.");
			        	}
			        }
			        //If the user decides to not restart the code by inputing "N",
			        //The system will proceed to end the loop, resulting in the code ending.
			        else {
			        	run = false;
			        	System.out.println("The code will not restart, Have a great day!");
			        }
			        
			    //End of while loop to repeat code.
				}
				
				input.close();
	}
	
	/**
	 * Defined function to check if user input is valid.
	 * If user input is invalid, function repeats supplied question till input is valid.
	 * @param x
	 * @param question
	 * @return string
	 */
	public static String inputCheck (String x, String question) {
		Scanner input2 = new Scanner(System.in);
		boolean valid = false;
		while (!valid) {
        	if (x.equals("N") || x.equals("n") || x.equals("Y") || x.equals("y")) {
	        	valid = true;
	        }
        	else {
        		System.out.println("");
        		System.out.println("!Input not valid, Please try again!");
	        	System.out.println(question);
		        x = input2.nextLine();
        	}
        }
		return x;
	}
}
