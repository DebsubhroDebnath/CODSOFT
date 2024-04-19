package JavaProgramming.Codsoft;
import java.util.Random;
import java.util.Scanner;


class NewGame{

    public int CompGame(){
        

        Random rand = new Random();

        int computerNum = rand.nextInt(100);
        System.out.println("---------------------Guess The Number-------------------");
        
        System.out.println("Guess Opponent's number (The Number is between 1 to 100!) ");
        System.out.println("==========================================================");
        System.out.println("");

        return computerNum;
    }

}

public class NumberGame{

    public static void isCorrectNumber(int userNum, int computerNum){

        if(userNum==computerNum){
            System.out.println("Congratulations! you guessed the correct Number");
        }
        else if(userNum>computerNum){
            System.out.println("Guess Something Smaller! Your Number is Greater than Opponent's Number! ");
        }
        else{
            System.out.println("Guess Something Larger! Your Number is Smaller than Opponent's Number! ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfGuess = 0;
        NewGame gm = new NewGame();
        int computerNum = gm.CompGame();
        int userNumber;
        
        do {
            System.out.print("Enter the Number :");
            userNumber = sc.nextInt();
            isCorrectNumber(userNumber, computerNum);
            numberOfGuess++;
            
        } while (userNumber!=computerNum);
        
        System.out.println("You Won the game you took " + numberOfGuess +" "+" guesses!!");
        sc.close();
    }
}