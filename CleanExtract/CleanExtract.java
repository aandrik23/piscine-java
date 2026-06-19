public class CleanExtract {
    public static String extract(String s){
        String[] parts = s.split("\\|");
        String result = "";
        for (int i=0; i <parts.length; i++) {
            int firstDot = parts[i].indexOf(".");
            int lastDot = parts[i].lastIndexOf(".");

            String extracted;
            if firstDot == -1 {
                extracted = parts[i].trim();
            } else if (firstDot == lastDot) {
                    parts[i].substring(firstDot + 1).trim();
            } else {
                    extracted = parts[i].substring(firstDot + 1, lastDot).trim();
            }
//            if (firstDot == 0 && lastDot == 0) {
//                extracted = extracted.replace(".", "").trim();
//            }

            if (!extracted.isEmpty()) {
                result += extracted + " ";
            }
        }
        return result.trim();
    }
}