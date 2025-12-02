import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Code2A {
    public static void main(String args[]) {
        List<String> file;
        try (
            BufferedReader in = new BufferedReader(new FileReader(args[0]))
        ) {
            file = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            return;
        }

        Pattern regexA = Pattern.compile("(\\d+)\\1");
        Pattern regexB = Pattern.compile("(\\d+)\\1+");

        long sumA = 0;
        long sumB = 0;
        for (String range : file.get(0).split(",")) {
            long start = Long.parseLong(range.split("-")[0]);
            long end = Long.parseLong(range.split("-")[1]) + 1;
            for (long i = start; i < end; i++) {
                if (regexA.matcher(Long.toString(i)).matches()) {
                    sumA += i;
                }
                if (regexB.matcher(Long.toString(i)).matches()) {
                    sumB += i;
                }
            }
        }
        System.out.println(sumA);
        System.out.println(sumB);
    }
}