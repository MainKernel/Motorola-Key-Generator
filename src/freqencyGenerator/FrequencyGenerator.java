package freqencyGenerator;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class FrequencyGenerator {
    private static final double startFreq = 136.0000;
    private static final double endFreq = 174.0000;
    private static final DecimalFormat decfor = new DecimalFormat("0.000");
    private final ArrayList<String> restricted = new ArrayList<>();

    public void generateFreq(int channels) {
        readFrequency();
        for (int i = 0; i < channels; ) {
            boolean freqIsGood = false;
            while (!freqIsGood) {
                double temp = endFreq - (endFreq - startFreq) * new Random().nextDouble();
                freqIsGood = isFrequencyGood(temp);
                if (freqIsGood) {
                    writeFrequency(decfor.format(temp));
                    restricted.add(decfor.format(temp));
                }
            }
            i++;
        }
    }

    private boolean isFrequencyGood(double d) {
        double higher = Double.parseDouble((decfor.format(d))) + 0.125;
        double lower = Double.parseDouble((decfor.format(d))) - 0.125;
        for (String s : restricted) {
            double temp = 0;
            if (s != null) {
                temp = Double.parseDouble(s);
            }
            if (temp > lower & temp > higher & temp != d) {
                return true;
            }
        }
        return false;
    }

    private void writeFrequency(String s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("GeneratedFreq.txt", true))) {
            writer.newLine();
            writer.write(s + "0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFrequency() {
        restricted.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("RestrFreq.txt"));
            while (reader.readLine() != null) {
                restricted.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("GeneratedFreq.txt"));
            while (reader1.readLine() != null) {
                restricted.add(reader1.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
