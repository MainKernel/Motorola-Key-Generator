package retransKeyGenerator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class RetransKeyGenerator {
        public String RetransKeyGenerator(int numberOfKeys) throws IOException{
            DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            File file = new File("Keys.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            String retransKeys = "";
            char[] retransKeyCharDictionary = new char[] {'A','a','B','b','C','c','D','d','E','e'
                    ,'F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n'
                    ,'O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w'
                    ,'X','x','Y','y','Z','z','0','1','2','3','4','5','6','7','8','9','#','$','_'};
            char[] retransKeyIntDictionary = new char[] {};
            char[] retransKeySymbolDictionary = new char[] {};
            while (numberOfKeys > 0){
                int keyLength = 23;
                while (keyLength != 0){
                    retransKeys += String.valueOf(retransKeyCharDictionary[new Random().nextInt(65)]);
                    keyLength--;
                }
                retransKeys += "\n";
                numberOfKeys--;
            }
            writer.append(date.format(now) + " Motorola Retrans Keys: \n" + retransKeys);
            writer.close();
            return retransKeys;
        }

    }

