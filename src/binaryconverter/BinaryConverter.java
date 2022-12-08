package binaryconverter;
import java.util.Scanner;
import java.math.BigDecimal;

public class BinaryConverter {
    static final String INV_SPLASH = "Incorrect input, try again: ";

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
        System.out.print("To convert int to bin press '1', to convert bin to int press '2', to exit press '0': ");
        String ans = input.nextLine();
        boolean result = validAns(ans);

        while(!result){
            System.out.print(INV_SPLASH);
            ans = input.nextLine();
            result = validAns(ans);
        }
        return ans;
    }

    public static boolean validAns(String inp){
        return inp.matches("^[0-2]?");
    }


    //Integer Methods
    public static void handleInt(Scanner intInp){
        System.out.print("Enter binary: ");

        String testBin = intInp.nextLine();
        boolean binState = validBin(testBin);
        while(!binState){
            System.out.print(INV_SPLASH);
            testBin = intInp.nextLine();
            binState = validBin(testBin);
        }
        String integer = convBin(testBin);
        System.out.println(testBin + " as an integer is " + integer);

    }

    public static boolean validInt(String inp){
        if(inp.matches("^\\d+$")){
            BigDecimal maxInt = new BigDecimal(2147483647);
            BigDecimal bigDec = new BigDecimal(inp);
            return maxInt.compareTo(bigDec) > -1;
        }
        return false;
    }

    public static String convInt(String inp){
        Integer res = Integer.parseInt(inp);
        return Integer.toBinaryString(res);
    }

    //Binary Methods
    public static void handleBin(Scanner binInp){
        System.out.print("Enter integer: ");
        String testInt = binInp.nextLine();
        boolean intState = validInt(testInt);
        while(!intState){
            System.out.print(INV_SPLASH);
            testInt = binInp.nextLine();
            intState = validInt(testInt);
        }
        String binary = convInt(testInt);
        System.out.println(testInt + " in binary is " + binary);
    }

    public static boolean validBin(String inp){
        return (inp.matches("^[0-1]+$") && inp.length() <= 31);
    }

    public static String convBin(String inp){
        int res = Integer.parseInt(inp,2);
        return String.valueOf(res);
    }
}
