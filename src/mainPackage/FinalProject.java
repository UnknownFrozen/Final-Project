package mainPackage;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;




public class FinalProject {
	
	public void main (String[] argv){
		runCode();
    }
	
	@Test
	public void runCode() {
				Scanner input = new Scanner(System.in);
				Random rand = new Random();
				
		        int total;
		        double average;
		        int highest;
		        int lowest;
		        
		        int totalNumbers = rand.nextInt(100);
		        int range = 100;
		        
		        String userInput;        
		        
		        boolean par = false;
				boolean run = true;
				
				while(run) {
					
					total = 0;
			        average = 0;

			        highest = 0;
			        lowest = 0;
					
			        if (!par) {
			        	totalNumbers = rand.nextInt(100);
			        }
			        
			        int[] numbers = new int[totalNumbers];
			        for(int i = 0; i < totalNumbers; i++){
			            numbers[i] = rand.nextInt(range);
			        }
			        
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

			        System.out.println("Do you wish to restart the code? (Y/N)");
			        userInput = input.nextLine();
			        userInput = inputCheck(userInput, "Do you wish to restart the code? (Y/N)");
			
			        if (userInput.equals("Y") || userInput.equals("y")) {
			        	run = true;
			        	
			        	System.out.println("Define your own parameters for this run? (Y/N)");
			        	userInput = input.nextLine();
			        	userInput = inputCheck(userInput, "Define your own parameters for this run? (Y/N)");
			        	
			        	if (userInput.equals("Y") || userInput.equals("y")) {
			        		par = true;
			        		System.out.println("");
			        		System.out.println("Enter total number of values to generate: ");
			        		totalNumbers = input.nextInt();
			        		
			    			System.out.println("Enter highest possible value: ");
			    			range = input.nextInt();
			    			input.nextLine();
			        	}
			        	else {
			        		par = false;
			        		System.out.println("System will generate random parameters.");
			        	}
			        }
			        else {
			        	run = false;
			        	System.out.println("The code will not restart, Have a great day!");
			        }
			        
				}
				
				input.close();
	}
	
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
