import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }

        FileOutputStream file = new FileOutputStream(args[0]);

        byte[] buffer = new byte[1024];

        int bytesRead = System.in.read(buffer);

        while (bytesRead != -1) {
            file.write(buffer, 0, bytesRead);
            bytesRead = System.in.read(buffer);
        }

        file.close();
    }
}
