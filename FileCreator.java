// Benjamin Roux - bsar3

import java.io.*;

public class FileCreator {

    /*
     * Create the file 'fileName' with the content 'content'
     */
    public static void createFile(String fileName, String content) throws IOException {
        File file = new File("./" + fileName);

        // Create the file
        if (file.createNewFile())
        {
            System.out.println("File " + fileName + " is created!");
        } else {
            System.out.println("File " + fileName + " already exists.");
        }

        // Write the content
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }
}
