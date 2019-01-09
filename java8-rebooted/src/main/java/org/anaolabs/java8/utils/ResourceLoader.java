package org.anaolabs.java8.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Just a helper class for loading local files content provided in /resources
 * 
 * @author T328469
 */
@Component
public class ResourceLoader {

    private final String INVALID_PATH_ERROR_MESSAGE = "Invalid provided path: '%s'.";

    /**
     * Get content of a given file in a single line
     * 
     * @param localPath relative path of file to read
     * @return full content of that file
     * @throws IOException
     */
    public String getContent(String localPath) throws IOException {

        StringBuilder content = new StringBuilder();

        Resource resource = new ClassPathResource(localPath);
        try (InputStream dataStream = resource.getInputStream();
            Scanner scanner = new Scanner(dataStream, StandardCharsets.UTF_8.name())) {
            while (scanner.hasNext()) {
                content.append(scanner.nextLine());
            }
            return content.toString();
        }
        catch (IOException e) {
            throw new IOException(String.format(INVALID_PATH_ERROR_MESSAGE, localPath));
        }
    }

    /**
     * Get content of a given file per line
     * 
     * @param localPath relative path of file to read
     * @return content per line
     * @throws IOException
     */
    public List<String> getContentLines(String localPath) throws IOException {

        List<String> lines = new ArrayList<>();
        Resource resource = null;

        // Get resource
        try {
            resource = new ClassPathResource(localPath);
        }
        catch (IllegalArgumentException iae) {
            throw new IOException(String.format(INVALID_PATH_ERROR_MESSAGE, localPath));
        }

        // Parse resource
        try (InputStream dataStream = resource.getInputStream();
            Scanner scanner = new Scanner(dataStream, StandardCharsets.UTF_8.name())) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        catch (IOException ioe) {
            throw new IOException(String.format(INVALID_PATH_ERROR_MESSAGE, localPath));
        }

        return lines;
    }
}
