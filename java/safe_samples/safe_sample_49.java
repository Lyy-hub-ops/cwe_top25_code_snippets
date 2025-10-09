// Safe Java code example
import java.util.regex.Pattern;

public class SafeExample {
    private static final Pattern SAFE_INPUT_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s]+$");
    
    public static String safeProcessInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        
        // Validate input format
        if (!SAFE_INPUT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("Input contains invalid characters");
        }
        
        // Safe processing
        return input.trim().toLowerCase();
    }
    
    public static void main(String[] args) {
        try {
            String result = safeProcessInput("Hello World 123");
            System.out.println("Processed: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
