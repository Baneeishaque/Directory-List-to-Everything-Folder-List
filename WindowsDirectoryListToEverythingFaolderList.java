
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
import java.io.IOException;
// import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
// import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WindowsDirectoryListToEverythingFaolderList {

    public static void main(String[] args) {

        String filename = "WindowsDirectoryList.txt";

        try {

            List list = fileToListJava8(filename);
            // list.forEach(System.out::println);
            List doubleQuotedList = (List) list.stream().map(c -> "\"" + c + "\"").collect(Collectors.toList());
            String joinedList = String.join(",", doubleQuotedList);
            // System.out.println(joinedList);
            String replacredString = joinedList.replace("\\", "\\\\");
            System.out.println(replacredString);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static List fileToListJava8(String fileName) throws IOException {

        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {

            result = lines.collect(Collectors.toList());
        }
        return result;
    }

    // private static List readByJava7(String fileName) throws IOException {
    // return Files.readAllLines(new File(fileName).toPath(),
    // Charset.defaultCharset());
    // }

    // private static List readByJavaClassic(String fileName) throws IOException {

    // List<String> result = new ArrayList<>();
    // BufferedReader br = null;

    // try {

    // br = new BufferedReader(new FileReader(fileName));

    // String line;
    // while ((line = br.readLine()) != null) {
    // result.add(line);
    // }

    // } catch (IOException e) {
    // e.printStackTrace();
    // } finally {
    // if (br != null) {
    // br.close();
    // }
    // }

    // return result;
    // }
}