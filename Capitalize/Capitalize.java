import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {

        if (args == null || args.length != 2) {
            return;
        }

        FileInputStream input = new FileInputStream(args[0]);
        FileOutputStream output = new FileOutputStream(args[1]);

        byte[] buffer = new byte[1024];
        int bytesRead = input.read(buffer);

        String content = "";
        while (bytesRead != -1) {
            content += new String(buffer, 0, bytesRead);
            bytesRead = input.read(buffer);
        }
        String[] words = content.split("\\s+");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }
            String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1).to.LowerCase();
            if (!result.isEmpty()) {
                result += " ";
            }
            result += capitalized;
        }

        output.write(result.getBytes());

        input.close();
        output.close();
    }
}