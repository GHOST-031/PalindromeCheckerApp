public class PalindromeCheckerApp {
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.run();
    }
    
    public void run() {
        // UC1: Welcome Message
        System.out.println("======================================");
        System.out.println("   Welcome to Palindrome Checker App");
        System.out.println("   Version: 1.0");
        System.out.println("======================================");
        
        // UC2: Print a Hardcoded Palindrome Result
        System.out.println("\n======================================");
        System.out.println("   UC2: Palindrome Checker");
        System.out.println("======================================");
        uc2CheckHardcodedPalindrome();
    }
    
    // UC2: Check if a hardcoded string is a palindrome
    private void uc2CheckHardcodedPalindrome() {
        String hardcodedString = "madam";
        
        boolean isPalindrome = checkPalindrome(hardcodedString);
        
        if (isPalindrome) {
            System.out.println("\"" + hardcodedString + "\" is a palindrome.");
        } else {
            System.out.println("\"" + hardcodedString + "\" is not a palindrome.");
        }
    }
    
    // Helper method to check if a string is a palindrome
    private boolean checkPalindrome(String str) {
        // Remove spaces and convert to lowercase for comparison
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        
        // Check if string equals its reverse
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
}
