public class PalindromeCheckerApp {
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.run();
    }
    
    public void run() {
        // UC3: Palindrome Check Using String Reverse
        System.out.println("======================================");
        System.out.println("   UC3: Palindrome Check Using String Reverse");
        System.out.println("======================================");
        uc3CheckPalindromeByReverse();
        
        // UC1: Welcome Message
        System.out.println("\n======================================");
        System.out.println("   Welcome to Palindrome Checker App");
        System.out.println("   Version: 1.0");
        System.out.println("======================================");
        
        // UC2: Print a Hardcoded Palindrome Result
        System.out.println("\n======================================");
        System.out.println("   UC2: Palindrome Checker");
        System.out.println("======================================");
        uc2CheckHardcodedPalindrome();
    }
    
    // UC3: Check if a string is a palindrome by reversing using a for loop
    private void uc3CheckPalindromeByReverse() {
        String testString = "racecar";
        
        // Use for loop to reverse the string
        // Demonstrates: Loop, String Concatenation, String Immutability
        String reversed = "";  // Original string
        
        // For loop to iterate through string in reverse order
        for (int i = testString.length() - 1; i >= 0; i--) {
            // String concatenation creates new String objects (demonstrates immutability)
            reversed = reversed + testString.charAt(i);
        }
        
        // Using equals() method to compare string content instead of memory references
        boolean isPalindrome = testString.equals(reversed);
        
        System.out.println("Original String: \"" + testString + "\"");
        System.out.println("Reversed String: \"" + reversed + "\"");
        
        if (isPalindrome) {
            System.out.println("Result: \"" + testString + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + testString + "\" is not a palindrome.");
        }
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
