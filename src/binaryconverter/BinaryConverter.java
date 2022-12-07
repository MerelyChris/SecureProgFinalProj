package binaryconverter;
import java.util.Scanner;

public class BinaryConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        String ans = "1";
        while(!ans.equals("0")){
            Scanner input = new Scanner(System.in);
            System.out.print("To convert binary press '1', to convert an integer press '2', to exit press '0': ");
            ans = input.nextLine();
            boolean result = validAns(ans);
            if(result == true){
                switch(ans){
                    case "1":
                        handleBinary(input);
                        break;
                    case "2":
                        handleInteger(input);
                        break;
                }
            }
            else if(result == false){
                System.out.println("Incorrect input");
            }
        } 
    }
    
    public static boolean validAns(String ans){
        if(ans.matches("^[0-2]?")){
            return true;
        }
        return false;
    }

    public static int[] split(String inp){
        int[] intArr = new int[inp.length()];
        for(int n = 0; n < inp.length(); n++){
            intArr[n] = Character.getNumericValue(inp.charAt(n));
        }
        return intArr;
    }
    public static void handleBinary(Scanner input){
        System.out.print("Enter binary: ");
        String binary = input.next();
        int decimal = Integer.parseInt(binary,2);
        System.out.println(binary + " as an integer is " + decimal);
    }
    public static void handleInteger(Scanner input){
        System.out.print("Enter integer: ");
        String testInt = input.nextLine();
        while(!testInt.matches("^[0-9]+$")){
            System.out.print("Incorrect input, try again: ");
            testInt = input.nextLine();
        }
        Integer finInt = Integer.parseInt(testInt);
        String binary = Integer.toBinaryString(finInt);
        System.out.println(testInt + " as an integer is " + binary);
    }
}
