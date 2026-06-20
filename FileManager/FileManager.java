public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        FileOutputStream output = new FileOutputStream(fileName);
        output.write(content.getBytes());
        output.close();
    }
    public static String getContentFile(String fileName) throws IOException {
        FileInputStream input = new FileInputStream(fileName);
        byte[] buffer = new byte[1024];

        int bytesRead = input.read(buffer);
        String content = "";
        while (bytesRead != -1) {
            content += new String(buffer, 0, bytesRead);
            bytesRead = input.read(buffer);
        }
        input.close();
        return content;

    }
    public static void deleteFile(String fileName) {
        File file = new file(fileName);
        file.delete();
    }
}