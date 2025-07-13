public class Palindrome_Number {

    public static void main(String[] args) {

        int x = 1254521;//the number to be analyzed
        String message = (isPalindrome(x)) ?  " is palindrome" : " is not palindrome";
        System.out.println(x + message);

    }

    public static boolean isPalindrome(int x) {

        if(x < 0) return false;//excludes negative numbers

        for (int i = 0; i < String.valueOf(x).length()/2; i++){
            if(String.valueOf(x).charAt(i) != String.valueOf(x).charAt(String.valueOf(x).length()-1-i)) return false;

        }
        return true;
    }
}
