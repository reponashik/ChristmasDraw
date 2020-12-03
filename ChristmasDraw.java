
import java.util.*; //Importing java package that contains frameworks, class builders, built-in functionalities
import java.util.Random; //Importing Random module for the random generations

public class ChristmasDraw { //Class initiation
	public static void main(String[] args) { //Main method initiation
		String[][] thisyear = new String[10][2]; //New empty array where to store the couples from the first draw
  		String[][] nextyear = new String[10][2]; //New empty array where to store the couples from the second draw
  		String [] giftGiver = {"x1", "x2","x3","x4","x5","y1","y2","y3","y4","y5"}; //array of individual components who will gift presents.
  	    String [] giftReceiver = {"x1","x2","x3","x4","x5","y1","y2","y3","y4","y5"}; //array of individual components who will receive presents.
  		String[][] couples = {{"x1", "y1"}, {"x2", "y2"}, {"x3", "y3"}, {"x4", "y4"}, {"x5", "y5"}}; //2D array with all couples listed
		//Limit: sometimes when the pairs did not pass the requirements needed would fall
  		//into an infinite-loop 
  		//Therefore a variable called limit has been defined to not 
  		//allow the program to fall into an infinite loop due to 
  		//unpaired couples
  		int limit = 0;
		//Tests executed to verify array was printing fine
		//System.out.println(Arrays.deepToString(couples));
  		
 
  		/////////////////////////////////////////////////////////////////////////////
  		for(int i = 0; i < thisyear.length; i++) { //This for loop determined draw1
  			limit = 0;
  			/////////
  	  		String compare1; //This is where a random couple will be stored to be then compared
  	  		String compare2; //This is where a random couple will be stored to be then compared
  	  		//Initiation do while loop
  	  		do {
  	  			compare1 = randomise(couples); //generate two random elements from 'couples' array
  	  	  		compare2 = randomise(couples);
  	  	  		limit++;
  	  	  		if(limit >= 50) { //This means that if after 50 comparisons there are still pairs that cannot be joined
  	  	  			//because of the constraints, the loop will start again until couples respect the constraints. 
  	  	  			i = 0;
  	  	  	//After compare 1 and compare 2 are generated thanks to the randomise method defined separately, it can now be passed in the 
  	  	  	//method called notAllowed to be verified to see if the couple generated respects the constraints, to see that they are not the same 
  	  	  	//couple, if yes, they will be stored in this year, otherwise the loop will run again until all 10 places in the 
  	  	  	//this year array is not fully filled with regular arrays.
  	  	  		}
  	  		}while(!notAllowed(thisyear, compare1, compare2, i)); //run loop until compare1 does not pass requirements
  	 		thisyear[i][0] = compare1; //The result will be saved in thisyear
  	 		thisyear[i][1] = compare2; //Compare2 saved in thisyear as well
  		}
  		///////////////////////////////////////////////////////////////////////////
  		//The for loop below is testing cases for the second draw
  		for(int i = 0; i < nextyear.length; i++) {  //Until the array next year is filled with all valid couples
  			limit = 0; //Limit set to 0
  			String compare1; //Stores random
  	  		String compare2; //Stores random
  	  		do {
  	  			compare1 = randomise(couples); //Calling function randomise and array couples used as argument
  	  	  		compare2 = randomise(couples); //Calling function randomise and array couples used as argument
  	  	  		limit++; //Increment limit after each comparison
	  	  		if(limit >= 50) { //This means that if after 50 comparisons there are still pairs that cannot be joined
  	  	  			//because of the constraints, the loop will start again until couples respect the constraints. 
	  	  			i = 0;
	  	  		}
  	  		}while(!notAllowed(nextyear, compare1, compare2, i) || !secondDraw(compare1, compare2, thisyear)); //also check if pair existed in previous draw
  	 		nextyear[i][0] = compare1; //If the array check is valid, then compare1 will pass its value to nextyear[i][0] for all i 
  	 		nextyear[i][1] = compare2; //If the array check is valid, then compare1 will pass its value to nextyear[i][1] for all i 
  		}
    	//Display in the terminal
  		System.out.println("Draws "); //Introducing draws
  	    System.out.println("These are the draws for the first year: "); //print the draws
  	    //For loop to print all elements in next year's draw after taking in account the constraints
  		for(int i = 0; i < thisyear.length; i++) {
			System.out.println(thisyear[i][0] + " will buy a present to " + thisyear[i][1]);
  		}
  		System.out.println("          "); //line space
  		System.out.println("These are the draw for the second Christmas: ");
  		//For loop to print all elements in next year's draw after taking in account the constraints
  		for(int i = 0; i < nextyear.length; i++) {
			System.out.println(nextyear[i][0] + " will buy a present to " + nextyear[i][1]);
  		}
  		
  	
  	
} //End of main method
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean secondDraw(String x, String y, String[][] a) { //This is the method that checks if a couple is valid for second draw
		if(!x.equals(y) && x.charAt(1) != y.charAt(1)) { //avoid selections of couples like x1 and y1 or y1 and y1 being repeated
			for(int j = 0; j < a.length; j++) { //charAt in the line above makes sure that the index 1 of two elements is different
		  		if(a[j][0].equals(x) && a[j][1].equals(y)) {  //If element are the same it will return false and look until a valid couple is found
		  			return false; //Logic statement
		  	    }
		  	}
			return true; //Logic statement
	  	}else {
	  		return null != null; //Inverse logic to end loop
	  	}	
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	//The job of the method below is to process a 2D Array, and return 
		public static String randomise(String[][] couplearray) { 
		int random1 = new Random().nextInt(couplearray.length); 
		int random2 = new Random().nextInt(couplearray[0].length); //nextInt is used to get a random number between 0 and the length of the array that will be passed in.
		return couplearray[random1][random2]; //Returning a 2D Array with two random elements.
		}
////////////////////////////////////////////////////////////////////////////////////////////////////
		//The job of the method below is to put valid couples in the first year draw, the check is to see that they are not a couple
	public static boolean notAllowed(String[][] a, String x, String y, int i) { //Definition of arguments
		if(!x.equals(y) && x.charAt(1) != y.charAt(1)) { //charAt() makes sure that the index 1 of the elements is different
			for(int j = 0; j < i; j++) { 
		  		if(a[j][0].equals(x) || a[j][1].equals(y)) { //This makes sure that one element has not been paired already
		  			return false; //in which case return false
		  	    }
		  	}
			return true; //otherwise return true
	  	}else {
	  		return null != null; //Inverse logic to end loop
	  	}
	}
	
}
