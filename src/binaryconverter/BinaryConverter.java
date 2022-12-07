package binaryconverter;
import java.util.Scanner;
import java.math.BigDecimal;

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
    
    public static boolean validAns(String inp){
        if(inp.matches("^[0-2]?")){
            return true;
        }
        return false;
    }

    public static boolean validInt(String inp){
        BigDecimal maxInt = new BigDecimal(2147483647);
        BigDecimal bigDec = new BigDecimal(inp);
        int res = maxInt.compareTo(bigDec);
        if(!inp.matches("^[0-9]+$") || res == -1){
            return false;
        }
        return true;
    }

    public static void handleBinary(Scanner input){
        System.out.print("Enter binary: ");
        String testBin = input.nextLine();
        while(!testBin.matches("^[0-1]+$")){
            System.out.print("Incorrect input, try again: ");
            testBin = input.nextLine();
        }
        int decimal = Integer.parseInt(testBin,2);
        System.out.println(testBin + " as an integer is " + decimal);
    }

    public static void handleInteger(Scanner input){
        System.out.print("Enter integer: ");
        String testInt = input.nextLine();
        while(validInt(testInt) != true){
            System.out.print("Incorrect input, try again: ");
            testInt = input.nextLine();
        }
        Integer finInt = Integer.parseInt(testInt);
        String binary = Integer.toBinaryString(finInt);
        System.out.println(testInt + " as an integer is " + binary);
    }
}
