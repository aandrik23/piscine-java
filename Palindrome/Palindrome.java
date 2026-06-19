public class Palindrome {
    public static boolean isPalindrome(String s) {
        String reversed = "";

        for (int i = s.length() - 1; i >= 0 ; i--){
            reversed += s.charAt(i);
        }
       return s.equals(reversed);
        }
    }