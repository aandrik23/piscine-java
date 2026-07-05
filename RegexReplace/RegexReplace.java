public class RegexReplace {
    public static String removeUnits(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("(?<=\\d)(cm|€)(?=\\s|$)", "");
    }

    public static String obfuscateEmail(String s) {

        if (s == null) {
            return null;
        }

        String[] email = s.split("@");

        if (email.length != 2) {
            return s;
        }

        String username = email[0];
        String domain = email[1];

        if (username.contains(".")) {
            username = username.replaceFirst("\\..*", ".***");
        } else if (username.contains("-")) {
            username = username.replaceFirst("-.*", "-***");
        } else if (username.contains("_")) {
            username = username.replaceFirst("_.*", "_***");
        } else if (username.length() > 3) {
            StringBuilder hidden = new StringBuilder(username.substring(0, 3));
            for (int i = 3; i < username.length(); i++) {
                hidden.append("*");
            }
            username = hidden.toString();
        }

        String[] parts = domain.split("\\.");

        if (parts.length == 2) {

            String tld = parts[1];

            if (tld.equals("com") || tld.equals("org") || tld.equals("net")) {
                domain = "*******." + tld;
            } else {
                domain = "*******." + "*".repeat(tld.length());
            }
        } else if (parts.length == 3) {

            domain = "*******." + parts[1] + "." + "*".repeat(parts[2].length());
        }
        return username + "@" + domain;

    }

}