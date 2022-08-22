package MotorolaChanelKeyGenerator;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;
public class MotorolaChanelKeyGenerator {
    public String ChanelKeyGenerator(int numberOfKeys) throws IOException{
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        File file = new File("Keys.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        String key = "";
        char [] keyDictionary = new char[] {'A','B','C', 'D','E','F','1'
                , '2','3','4','5','6','7','8','9','0'};
        while (numberOfKeys > 0){
            int keyLength = 9;
            while(keyLength !=0){
                key += String.valueOf(keyDictionary[new Random().nextInt(16)]);
                keyLength--;
            }
            key += "\n";
            numberOfKeys--;
        }
        writer.append(date.format(now) + " Motorola Chanel Keys: \n" + key);
        writer.close();
        return key;
    }

}

