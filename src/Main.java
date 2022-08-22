import MotorolaChanelKeyGenerator.*;
import RetransKeyGenerator.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Select what do you need: \n1. Generate Chanel Key\n2. Generate Retrans Key\n3. Exit");
                int menuChoice = scanner.nextInt();
                switch (menuChoice){
                    case 1:
                        System.out.print("Enter how much keys do you need: ");
                        int numberOfChanelKeys = scanner.nextInt();
                        System.out.println("Motorola Chanel Keys: \n" + new MotorolaChanelKeyGenerator().ChanelKeyGenerator
                                (numberOfChanelKeys));
                        break;
                    case 2:
                        System.out.print("Enter how much keys do you need: ");
                        int numberOfRetransKeys = scanner.nextInt();
                        System.out.println("Motorola Retrans Keys: \n" + new RetransKeyGenerator().RetransKeyGenerator
                                (numberOfRetransKeys));
                        break;
                    case 3:
                        return;
                }
            }
        }
}