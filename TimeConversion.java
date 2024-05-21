import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String timeConversion(String s) {
        if(s.charAt(8)=='P') {
            String time = s.substring(0,8);
            String[] times = time.split(":");
            
            if(times[0].matches("12")) return times[0] + ":" + times[1] + ":" + times[2];
            
            times[0] = String.valueOf(Integer.valueOf(times[0]) + 12);
            
            return times[0] + ":" + times[1] + ":" + times[2];
        } else {
            String time = s.substring(0,8);
            String[] times = time.split(":");
            
            if(times[0].matches("12")) return "00:" + times[1] + ":" + times[2];
            
            return s.substring(0,8);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
