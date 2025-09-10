package Utilization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;


public class Base64Utils {

    /**
     * Converts a file to Base64 encoded string
     *
     * @param filePath the path to the file
     * @return Base64 encoded string
     * @throws IOException if the file cannot be read or doesn't exist
     */
    public static String fileToBase64(String filePath) throws IOException {
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
        return Base64.getEncoder().encodeToString(fileContent);
    }

    /**
     * Gets the file size from Base64 string without decoding
     *
     * @param base64String the Base64 encoded string
     * @return approximate file size in bytes
     */
    public static long getFileSizeFromBase64(String base64String) {
        if (base64String == null) return 0;

        String cleanBase64 = base64String.replaceAll("=+$", "");
        return (cleanBase64.length() * 3L) / 4;
    }






}