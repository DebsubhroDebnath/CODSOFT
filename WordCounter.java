package JavaProgramming.Codsoft;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class WordCounter {

    public static void main(String[] args) {
        
        

        System.out.println("--------------------WORD COUNTER PROGRAM------------------");
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.printf("1.For File Input \t2.For Text Input:\t3.For Exit\n");
            System.out.println();
            System.out.println("==========================================================");
            System.out.print("Enter your Choice:");

            choice = sc.nextInt();

            switch(choice){
                case 1:
                    sc.nextLine(); // Here we have use this to skip the escape sequence present inside the buffer after using the nextInt function (i.e. \n)

                    System.out.print("Enter your file name with .txt :");
                    String fileName = sc.nextLine();
                    File myfile = new File(fileName);
                    try{
                        myfile.createNewFile();
                        System.out.println("File created Successfully");
                    }catch(Exception e){
                        System.out.println("There is an error creating your file ");
                        e.printStackTrace();
                    }

                    try{
                        FileWriter filewriter = new FileWriter(fileName);
                        System.out.print("Enter any text:");
                        String text = sc.nextLine();
                        filewriter.write(text);
                        filewriter.close();

                        System.out.println("Text added Successfully");
                    }catch(Exception e){
                        System.out.println("Unable to write inside the File");
                        e.printStackTrace();
                    }

                    try{
                        Scanner in = new Scanner(myfile);
                        String str = "";
                        while(in.hasNextLine()){
                            str = in.nextLine();
                        }
                        
                        countWord(str);

                        in.close();
                    }catch(Exception e){
                        System.out.println("Unable to read the file");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    
                    System.out.println("Enter your Text:");
                    sc.nextLine(); 
                    String word = sc.nextLine();
                    countWord(word);
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Please Enter the correct Choice");
            }

        }while(choice!=3);

        sc.close();
    }

    public static void countWord(String word){

        int counter = 0;
        for(int i=0;i<word.length();i++){
            counter++;
        }
        System.out.println("The Total Number of Words in the string is = "+counter);

    }
}