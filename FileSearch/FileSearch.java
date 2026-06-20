import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File root = new File("documents");
        return searchInside(root, fileName);
    }

    private static String searchInside(File folder, String fileName) {
        File[] files = folder.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().equals(fileName)) {
                    return file.getPath();
                }
            }
            if (file.isDirectory()) {
                String result = searchInside(file, fileName);

                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}