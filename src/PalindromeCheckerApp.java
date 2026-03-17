public class PalindromeCheckerApp {
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.run();
    }
    
    public void run() {
        // UC10: Case-Insensitive & Space-Ignored Palindrome
        System.out.println("======================================");
        System.out.println("   UC10: Case-Insensitive & Space-Ignored Palindrome");
        System.out.println("======================================");
        uc10CheckCaseInsensitiveRealWorldPalindrome();
        
        // UC9: Recursive Palindrome Checker
        System.out.println("\n======================================");
        System.out.println("   UC9: Recursive Palindrome Checker");
        System.out.println("======================================");
        uc9CheckPalindromeRecursive();
        
        // UC8: Linked List Based Palindrome Checker
        System.out.println("\n======================================");
        System.out.println("   UC8: Linked List Based Palindrome Checker");
        System.out.println("======================================");
        uc8CheckPalindromeWithLinkedList();
        
        // UC7: Deque-Based Optimized Palindrome Checker
        System.out.println("\n======================================");
        System.out.println("   UC7: Deque-Based Optimized Palindrome Checker");
        System.out.println("======================================");
        uc7CheckPalindromeWithDeque();
        
        // UC6: Queue + Stack Based Palindrome Check
        System.out.println("\n======================================");
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
    
    // UC7: Deque-Based Optimized Palindrome Checker
    private void uc7CheckPalindromeWithDeque() {
        String testString = "madam";
        
        // Create a Deque (Double Ended Queue) - allows insertion/deletion from both ends
        // Deque can be accessed from front and rear simultaneously
        java.util.Deque<Character> deque = new java.util.LinkedList<>();
        
        System.out.println("String: \"" + testString + "\"");
        System.out.println("\nInserting characters into Deque (both ends accessible):");
        
        // Insert all characters into the deque
        for (int i = 0; i < testString.length(); i++) {
            char c = testString.charAt(i);
            deque.addLast(c);  // Add to rear
            System.out.println("Add: " + c + " (Deque size: " + deque.size() + ")");
        }
        
        System.out.println("\nCharacter Deque Contents: " + deque);
        System.out.println("\nComparing First and Last Characters (moving towards center):");
        System.out.println("Position | First (removeFront) | Last (removeLast) | Match?");
        System.out.println("---------|---------------------|------------------|-------");
        
        boolean isPalindrome = true;
        int position = 1;
        
        // Compare front and rear elements
        // removeFirst() gets from front, removeLast() gets from rear
        while (deque.size() >= 1) {
            if (deque.size() == 1) {
                // Single character in middle - always matches
                char single = deque.removeFirst();
                System.out.println("   " + position + "    |         " + single + "          |        " + single + "         | Yes (Middle)");
                break;
            } else if (deque.size() >= 2) {
                // Remove from front and rear
                char fromFront = deque.removeFirst();   // Get first element
                char fromRear = deque.removeLast();     // Get last element
                
                boolean matches = (fromFront == fromRear);
                System.out.println("   " + position + "    |         " + fromFront + "          |        " + fromRear + "         | " + (matches ? "Yes" : "No"));
                
                if (!matches) {
                    isPalindrome = false;
                    break;
                }
                position++;
            }
        }
        
        System.out.println("\nDeque Advantage:");
        System.out.println("- Enables direct access to both front and rear elements");
        System.out.println("- No need for separate data structures (no Queue + Stack required)");
        System.out.println("- Optimized: O(n/2) comparisons with minimal overhead");
        System.out.println("- Eliminates intermediate data structures and copies");
        
        if (isPalindrome) {
            System.out.println("\nResult: \"" + testString + "\" is a palindrome.");
        } else {
            System.out.println("\nResult: \"" + testString + "\" is not a palindrome.");
        }
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
    
    // UC8: Linked List Based Palindrome Checker using Fast and Slow Pointer Technique
    private void uc8CheckPalindromeWithLinkedList() {
        String testString = "racecar";
        
        System.out.println("String: \"" + testString + "\"");
        System.out.println("\nBuilding Linked List from String:");
        
        // Step 1: Convert string to linked list
        Node head = null;
        for (char c : testString.toCharArray()) {
            head = new Node(c, head);
        }
        // Reverse to get correct order (since we prepended)
        head = reverseLinkedList(head);
        
        // Print linked list
        System.out.print("Linked List: ");
        printLinkedList(head);
        System.out.println();
        
        // Step 2: Find middle using fast and slow pointer technique
        System.out.println("\nFast and Slow Pointer Technique to find middle:");
        Node slow = head;
        Node fast = head;
        
        int step = 1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("Step " + step + ": Slow at '" + (slow != null ? slow.data : "null") + 
                             "', Fast at '" + (fast != null ? fast.data : "null") + "'");
            step++;
        }
        
        System.out.println("\nMiddle found at: '" + slow.data + "'");
        
        // Step 3: Reverse second half
        System.out.println("\nReversing second half of linked list:");
        Node secondHalf = reverseLinkedList(slow);
        
        // Step 4: Compare first half with reversed second half
        System.out.println("\nComparing First Half with Reversed Second Half:");
        Node first = head;
        Node second = secondHalf;
        boolean isPalindrome = true;
        int position = 1;
        
        while (first != null && second != null && first != second) {
            System.out.println("Position " + position + ": First='" + first.data + "', Second='" + 
                             second.data + "' => " + (first.data == second.data ? "Match" : "No Match"));
            
            if (first.data != second.data) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
            position++;
        }
        
        System.out.println("\nLinked List Advantages:");
        System.out.println("- Dynamic memory allocation (no fixed size needed)");
        System.out.println("- Fast and Slow pointer finds middle in O(n/2) time");
        System.out.println("- In-place reversal: O(1) extra space for second half");
        System.out.println("- Overall Time: O(n), Space: O(1) after list creation");
        
        if (isPalindrome) {
            System.out.println("\nResult: \"" + testString + "\" is a palindrome.");
        } else {
            System.out.println("\nResult: \"" + testString + "\" is not a palindrome.");
        }
    }
    
    // UC10: Case-Insensitive & Space-Ignored Palindrome Checker
    private void uc10CheckCaseInsensitiveRealWorldPalindrome() {
        // Test cases with mixed case and spaces (real-world examples)
        String[] testStrings = {
            "A man, a plan, a canal: Panama",
            "race a car",
            "Was it a car or a cat I saw?",
            "Madam, I'm Adam"
        };
        
        System.out.println("Testing real-world palindromes with spaces and mixed case:\n");
        
        for (String testString : testStrings) {
            System.out.println("Original String: \"" + testString + "\"");
            
            // Step 1: String Preprocessing - Remove spaces and convert to lowercase
            String preprocessed = preprocessString(testString);
            System.out.println("After preprocessing: \"" + preprocessed + "\"");
            
            // Step 2: Check if palindrome
            boolean isPalindrome = checkIfPalindrome(preprocessed);
            
            // Step 3: Display result
            if (isPalindrome) {
                System.out.println("Result: Palindrome OK\n");
            } else {
                System.out.println("Result: Not a palindrome X\n");
            }
        }
        
        System.out.println("UC10 Preprocessing Explanation:");
        System.out.println("- Regular Expression: Removes all non-alphanumeric characters");
        System.out.println("- toLowerCase(): Converts all characters to lowercase");
        System.out.println("- Handles real-world text with punctuation and spaces");
        System.out.println("- Makes palindrome checking more practical and flexible");
    }
    
    // Helper method: Preprocess string for palindrome checking
    // Removes all non-alphanumeric characters and converts to lowercase
    private String preprocessString(String str) {
        // Regular Expression: [^a-zA-Z0-9] means \"any character that is NOT alphanumeric\"
        // replaceAll() replaces all non-alphanumeric characters with empty string
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned;
    }
    
    // Helper method: Check if a string is a palindrome (simple comparison)
    private boolean checkIfPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // UC9: Recursive Palindrome Checker using Call Stack
    private void uc9CheckPalindromeRecursive() {
        String testString = "rotator";
        
        System.out.println("String: \"" + testString + "\"");
        System.out.println("\nRecursive Approach using Call Stack:");
        System.out.println("Converting string to character array for recursive comparison...");
        
        char[] chars = testString.toCharArray();
        
        // Display the array
        System.out.print("Character Array: [");
        for (int i = 0; i < chars.length; i++) {
            System.out.print("[" + i + "]=" + chars[i]);
            if (i < chars.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        // Enable tracing for recursive calls
        System.out.println("\nRecursive Call Trace:");
        callDepth = 0;  // Initialize call depth
        
        boolean isPalindrome = isPalindromeRecursive(chars, 0, chars.length - 1);
        
        System.out.println("\nRecursion Explanation:");
        System.out.println("- Each recursive call compares characters from opposite ends");
        System.out.println("- Base condition: when left >= right, recursion stops (all chars matched)");
        System.out.println("- Call Stack grows with each recursive call");
        System.out.println("- Call Stack shrinks as each recursive call returns");
        System.out.println("- Time Complexity: O(n/2) comparisons");
        System.out.println("- Space Complexity: O(n/2) for call stack depth in worst case");
        
        if (isPalindrome) {
            System.out.println("\nResult: \"" + testString + "\" is a palindrome.");
        } else {
            System.out.println("\nResult: \"" + testString + "\" is not a palindrome.");
        }
    }
    
    private int callDepth = 0;  // Track recursion depth for tracing
    
    // Recursive method to check palindrome
    // Left pointer starts from beginning, Right pointer starts from end
    private boolean isPalindromeRecursive(char[] chars, int left, int right) {
        String indent = "  ".repeat(callDepth);  // For visual indentation
        
        // Display current recursive call
        System.out.println(indent + "Call " + (callDepth + 1) + ": left=" + left + ", right=" + right + 
                         " => Compare '" + chars[left] + "' with '" + chars[right] + "'");
        
        callDepth++;
        
        // Base Condition: When pointers meet or cross, we've compared all relevant pairs
        if (left >= right) {
            callDepth--;
            System.out.println(indent + "  => Base condition met (left >= right). Palindrome confirmed!");
            return true;
        }
        
        // If characters don't match, it's not a palindrome
        if (chars[left] != chars[right]) {
            callDepth--;
            System.out.println(indent + "  => Mismatch! '" + chars[left] + "' != '" + chars[right] + "'. Not a palindrome.");
            return false;
        }
        
        // Characters match, move pointers towards center
        System.out.println(indent + "  => Match! '" + chars[left] + "' == '" + chars[right] + "'. Moving inward...");
        
        // Recursive call to check the remaining substring
        boolean result = isPalindromeRecursive(chars, left + 1, right - 1);
        
        callDepth--;
        return result;
    }
    
    // Helper method to reverse a linked list
    private Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    // Helper method to print linked list
    private void printLinkedList(Node head) {
        System.out.print("[");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.print("]");
    }
    
    // Inner class: Node for Singly Linked List
    private static class Node {
        char data;
        Node next;
        
        Node(char data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
