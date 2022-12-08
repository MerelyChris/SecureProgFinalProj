package binaryconverter;
import java.util.Scanner;
import java.math.BigDecimal;

public class BinaryConverter {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String res = "";
        while(!res.equals("0")){
            res = handleFork(input);
            switch(res){
                case "1":
                    handleBin(input);
                    break;
                case "2":
                    handleInt(input);
                    break;
                default:
                    break;
            }
        }
        input.close();
    }
    

    //Program Cycle Methods
    public static String handleFork(Scanner input){
        System.out.print("To convert binary press '1', to convert an integer press '2', to exit press '0': ");
        String ans = input.nextLine();
        boolean result = validAns(ans);

        while(result != true){
            System.out.print("Incorrect input, try again: ");
            ans = input.nextLine();
            result = validAns(ans);
        }
        return ans;
    }

    public static boolean validAns(String inp){
        if(inp.matches("^[0-2]?")){
            return true;
        }
        return false;
    }


    //Integer Methods
    public static void handleInt(Scanner intInp){
        System.out.print("Enter binary: ");

        String testBin = intInp.nextLine();
        boolean binState = validBin(testBin);
        while(binState != true){
            System.out.print("Incorrect input, try again: ");
            testBin = intInp.nextLine();
            binState = validBin(testBin);
        }
        String integer = convBin(testBin);
        System.out.println(testBin + " as an integer is " + integer);

    }

    public static boolean validInt(String inp){
        if(inp.matches("^[0-9]+$")){
            BigDecimal maxInt = new BigDecimal(2147483647);
            BigDecimal bigDec = new BigDecimal(inp);
            int res = maxInt.compareTo(bigDec);
            if(res != -1){
                return true;
            }
            return false;
        }
        return false;
    }

    public static String convInt(String inp){
        Integer res = Integer.parseInt(inp);
        String binary = Integer.toBinaryString(res);
        return binary;
    }

    //Binary Methods
    public static void handleBin(Scanner binInp){
        System.out.print("Enter integer: ");
        String testInt = binInp.nextLine();
        boolean intState = validInt(testInt);
        while(intState != true){
            System.out.print("Incorrect input, try again: ");
            testInt = binInp.nextLine();
            intState = validInt(testInt);
        }
        String binary = convInt(testInt);
        System.out.println(testInt + " in binary is " + binary);
    }

    public static boolean validBin(String inp){
        if(inp.matches("^[0-1]+$") && inp.length() <= 31){
            return true;
        }
        return false;
    }

    public static String convBin(String inp){
        int res = Integer.parseInt(inp,2);
        String integer = String.valueOf(res);
        return integer;
    }
}
