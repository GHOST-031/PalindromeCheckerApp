public class PalindromeCheckerApp {
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.run();
    }
    
    public void run() {
        // UC6: Queue + Stack Based Palindrome Check
        System.out.println("======================================");
        System.out.println("   UC6: Queue + Stack Based Palindrome Check");
        System.out.println("======================================");
        uc6CheckPalindromeWithQueueStack();
        
        // UC5: Stack-Based Palindrome Checker
        System.out.println("\n======================================");
        System.out.println("   UC5: Stack-Based Palindrome Checker");
        System.out.println("======================================");
        uc5CheckPalindromeWithStack();
        
        // UC4: Character Array Based Palindrome Check
        System.out.println("\n======================================");
        System.out.println("   UC4: Character Array Based Palindrome Check");
        System.out.println("======================================");
        uc4CheckPalindromeWithCharArray();
        
        // UC3: Palindrome Check Using String Reverse
        System.out.println("\n======================================");
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
    
    // UC6: Queue + Stack Based Palindrome Check - Demonstrates FIFO vs LIFO
    private void uc6CheckPalindromeWithQueueStack() {
        String testString = "radar";
        
        // Create a Queue (FIFO - First In First Out) 
        java.util.Queue<Character> queue = new java.util.LinkedList<>();
        
        // Create a Stack (LIFO - Last In First Out)
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        System.out.println("String: \"" + testString + "\"");
        System.out.println("\nEnqueue/Push Operation - Adding characters to Queue and Stack:");
        
        // Enqueue all characters to queue and push to stack
        for (int i = 0; i < testString.length(); i++) {
            char c = testString.charAt(i);
            queue.offer(c);  // Enqueue to queue
            stack.push(c);   // Push to stack
            System.out.println("Enqueue/Push: " + c + " | Queue size: " + queue.size() + " | Stack size: " + stack.size());
        }
        
        // Dequeue from queue (FIFO - gets characters in original order)
        // Pop from stack (LIFO - gets characters in reverse order)
        System.out.println("\nDequeue/Pop Operation - Comparing FIFO vs LIFO:");
        System.out.println("Position | Queue (FIFO) | Stack (LIFO) | Match?");
        System.out.println("---------|--------------|--------------|-------");
        
        boolean isPalindrome = true;
        int position = 1;
        
        while (!queue.isEmpty() && !stack.isEmpty()) {
            char fromQueue = queue.poll();   // Dequeue (FIFO - next is first that was added)
            char fromStack = stack.pop();     // Pop (LIFO - next is last that was added)
            
            boolean matches = (fromQueue == fromStack);
            System.out.println("   " + position + "    |      " + fromQueue + "        |      " + fromStack + "       | " + (matches ? "Yes" : "No"));
            
            if (!matches) {
                isPalindrome = false;
            }
            position++;
        }
        
        System.out.println("\nDetailed Explanation:");
        System.out.println("- Queue (FIFO): Returns characters in the order they were added (original order)");
        System.out.println("- Stack (LIFO): Returns characters in reverse order (last added comes out first)");
        System.out.println("- If Queue and Stack outputs match at each position, the string is a palindrome");
        
        if (isPalindrome) {
            System.out.println("\nResult: \"" + testString + "\" is a palindrome.");
        } else {
            System.out.println("\nResult: \"" + testString + "\" is not a palindrome.");
        }
    }
    
    // UC5: Stack-Based Palindrome Checker using LIFO principle
    private void uc5CheckPalindromeWithStack() {
        String testString = "level";
        
        // Create a stack to store characters
        // Stack demonstrates LIFO (Last In First Out) principle
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        System.out.println("String: \"" + testString + "\"");
        System.out.println("\nPush Operation - Adding characters to stack:");
        
        // Push Operation: Insert each character into the stack
        for (int i = 0; i < testString.length(); i++) {
            char c = testString.charAt(i);
            stack.push(c);
            System.out.println("Push: " + c + " (Stack size: " + stack.size() + ")");
        }
        
        // Build reversed string by popping from stack
        System.out.println("\nPop Operation - Removing characters from stack (reversed order):");
        String reversedString = "";
        int popCount = 0;
        
        while (!stack.isEmpty()) {
            // Pop Operation: Remove characters from stack in reverse order
            char c = stack.pop();
            reversedString = reversedString + c;
            popCount++;
            System.out.println("Pop: " + c + " (Stack size: " + stack.size() + ")");
        }
        
        // Compare original and reversed string
        boolean isPalindrome = testString.equals(reversedString);
        
        System.out.println("\nOriginal String: \"" + testString + "\"");
        System.out.println("Reversed String: \"" + reversedString + "\"");
        
        if (isPalindrome) {
            System.out.println("Result: \"" + testString + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + testString + "\" is not a palindrome.");
        }
    }
    
    // UC4: Character Array Based Palindrome Check using Two-Pointer Technique
    private void uc4CheckPalindromeWithCharArray() {
        String testString = "noon";
        
        // Convert string to character array
        // Demonstrates: Array indexing and direct character access
        char[] charArray = testString.toCharArray();
        
        // Two-Pointer Technique: Compare from both ends moving towards center
        int left = 0;
        int right = charArray.length - 1;
        boolean isPalindrome = true;
        
        System.out.println("String: \"" + testString + "\"");
        System.out.println("Character Array: ");
        for (int i = 0; i < charArray.length; i++) {
            System.out.print("[" + i + "]=" + charArray[i] + " ");
        }
        System.out.println("\n");
        
        // Two-pointer approach: start from beginning and end
        System.out.println("Comparison Process using Two-Pointer Technique:");
        while (left < right) {
            System.out.println("Compare charArray[" + left + "]=" + charArray[left] + 
                             " with charArray[" + right + "]=" + charArray[right]);
            
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        
        if (isPalindrome) {
            System.out.println("Result: \"" + testString + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + testString + "\" is not a palindrome.");
        }
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
