
/**
 * Created by Kevin L. Wong on 11/28/2023
 * This Java file serves as an entry point for processing Jack programming language files. It includes a main method that takes a Jack file or 
 * directory as input and processes it accordingly. If provided with a single Jack file as input, it compiles the file into a corresponding .vm file. 
 * For a directory input, it retrieves all .jack files within the directory and compiles each one into a separate .vm file. The class relies on a 
 * CompilationEngine, which handles the actual compilation process, and it utilizes a helper method, getJackFiles, to obtain all .jack files within 
 * a directory. This file encapsulates the logic for compiling Jack code into VM (virtual machine) code, serving as a starting point for the 
 * conversion process.
 */
import java.io.File;
import java.util.ArrayList;

public class JackAnalyzer {

    public static void main(String[] args) {
        // input is the jack file
        File jackFileDir = new File(args[0]);
        ArrayList<File> files = new ArrayList<>();
        if (jackFileDir.isFile() && args[0].endsWith(".jack")) {
            files.add(jackFileDir);

        } else if (jackFileDir.isDirectory()) {
            files = getJackFiles(jackFileDir);
        }

        for (File file : files) {
            String fileOutName = file.toString().substring(0, file.toString().length() - 5) + ".vm";
            File fileOutFile = new File(fileOutName);
            // compile the files
            CompilationEngine compilationEngine = new CompilationEngine(file, fileOutFile);
            compilationEngine.compileClass();

        }

    }

    // obtain all jack files in a given directory
    public static ArrayList<File> getJackFiles(File jackFileDir) {
        File[] files = jackFileDir.listFiles();
        ArrayList<File> fResults = new ArrayList<>();
        if (files != null)
            for (File file : files) {
                if (file.getName().endsWith(".jack"))
                    fResults.add(file);
            }
        return fResults;
    }

}