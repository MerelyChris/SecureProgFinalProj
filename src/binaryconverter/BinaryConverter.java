package binaryconverter;
import java.util.Scanner;

public class BinaryConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("To convert a byte of binary press '1', to convert an integer press '2': ");
        String ans = input.nextLine();


        while(!ans.matches("0")){
            if(validAns(ans) == true){
                switch(ans){
                    case "1":
                        handleBinary(input);
                        break;
                    case "2":
                        handleInteger(input);
                        break;
                }
            }
            else{
                System.out.println("Incorrect input");
            }
            System.out.print("Enter a byte '1', integer '2', or quit '0': ");
            ans = input.nextLine();
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
        int total = 0;
        System.out.print("Enter byte of binary: ");
        String binary = input.next();
        int[] intArr = split(binary);
        int[] binTable = {128,64,32,16,8,4,2,1};
        for(int n = 0; n < intArr.length; n++){
            if(intArr[n] == 1){
                total += binTable[n];
            }
        }
        System.out.println(binary + " as an integer is " + total);
    }
    public static void handleInteger(Scanner input){
        System.out.print("Enter integer: ");
        int integer = input.nextInt();
        int origInt = integer;
        int[] binTable = {128,64,32,16,8,4,2,1};
        String binary = "";
        for(int n = 0; n < binTable.length; n++){
            if(binTable[n]-integer<=0){
                binary += '1';
                integer -= binTable[n];
            }
            else
                binary += '0';
        }
        System.out.println(origInt + " as an integer is " + binary);
    }
}
