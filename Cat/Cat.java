import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }

        FileInputStream file = new FileInputStream(args[0]);

        byte[] buffer = new byte[1024];

        int bytesRead = file.read(buffer);

        while (bytesRead != -1) {
            System.out.write(buffer, 0, bytesRead);
            bytesRead = file.read(buffer);
        }

        file.close();
    }
}
