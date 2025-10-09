// Safe file operations
import java.io.*;
import java.nio.file.*;

public class SafeFileHandler {
    public static String safeReadFile(String filename) throws IOException {
        Path path = Paths.get(filename).normalize();
        
        // Validate path
        if (!Files.exists(path)) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        
        if (!Files.isRegularFile(path)) {
            throw new IllegalArgumentException("Path is not a regular file");
        }
        
        // Safe read with proper resource management
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }
}
