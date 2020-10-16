package com.example.labb1;
import java.util.Scanner;

public class Labb1 {
    public static void main(String[] args) {


        //updated
        Scanner sc = new Scanner(System.in); //Creating scanner for user input
        int choice; //Creating int "choice" for later use
        System.out.println("Hello and welcome to the Dice Game!");
        System.out.println("Please enter your name");
        String playerName = sc.nextLine();  //Asking for user's name
        int[] highScore = {0,0}; //Creating array "highScore" outside while-loop so the results don't change every round



        do {    //While loop here so the user can choose to play again how many times he/she chooses
            System.out.println("How many throws do you want?");
            int amountOfThrows = sc.nextInt();  // Register amount of throws
            int amountOfSides = 6;
            int sumPlayer1 = 0;
            int sumComputer = 0;
            int[] throwArray = new int[2]; //Creating array to be able to save the dice results



            for (int i = 1; i <= amountOfThrows; i++) {
                throwArray[0] = (int) (1 + amountOfSides * Math.random()); //Throwing dice and saving results in array
                throwArray[1] = (int) (1 + amountOfSides * Math.random());
                System.out.println(playerName + " throw " + i + " shows: " + throwArray[0]); //Prints results of the dice
                System.out.println("Computer's throw " + i + " shows: " + throwArray[1]);
                sumPlayer1 += throwArray[0]; // saves the total score
                sumComputer += throwArray[1];
            }
            if(sumPlayer1 > highScore[0]) {  //Changes the first place in array "highScore" to sumPlayer1's score if the score is higher than the existing score
                highScore[0] = sumPlayer1;
            }
            if(sumComputer > highScore[1]) { //Changes the second place in array "highScore" to sumComputer's score if the score is higher than the existing score
                highScore[1] = sumComputer;
            }
            System.out.println("Total score for " + playerName + " is: " + sumPlayer1); //Prints the total score
            System.out.println("Total score for player2(computer) is: " + sumComputer);
            if(sumPlayer1 > sumComputer) {
                System.out.println("Congratulations "+playerName+" You won! 🧨💥🧨💥🧨💥🧨💥"); //Prints winning sentence if the user wins
            } else if(sumComputer > sumPlayer1) {
                System.out.println("Too bad, you lose :("); // Prints losing sentence if the user lose
            } else{
                System.out.println("It's a tie! "); // Prints the tie sentence if the user ties
            }
            System.out.println("Showing high-score list");
            if(highScore[0] > highScore[1]) {  //If place [0] is > than place [1] in the array, prints first place as playerName, second place as computer + the score
                System.out.println("First place shows "+playerName+" with a high-score of: "+highScore[0]);
                System.out.println("Second place shows Computer with a high-score of: "+highScore[1]);
            } else if(highScore[1] > highScore[0]) { //If place [1] is > than place [0] in the array, prints first place as computer, second place as playerName + the score
                System.out.println("First place shows: Computer with a high-score of: "+highScore[1]);
                System.out.println("Second place shows: "+playerName+" with a score of: "+highScore[0]);
            } else { //If score is equal, prints the same score from the arrays + playerName and computer
                System.out.println("High-score is equal, both "+playerName+" and computer has the same score of: "+highScore[0]+" and "+highScore[1]);
            }
            System.out.println("Do you want to play again?"); //Asking user if you want to play again
            System.out.println("1. YES");
            System.out.println("2. Quit Program");
            choice = sc.nextInt(); //Saves the user's choice in int "choice"
            if(choice == 1) { //If user choose to play again, choice set to 1
                System.out.println("Restarting round");
            } else { //If user don't press either 1 or 2, program shutdown, "choice" set to 3
                System.out.println("Program shutdown");
                choice = 2;
            }
        } while(choice != 2);
    }

}
