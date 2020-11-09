package meta.metrics.menu;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MenuDialog {
    private Scanner scanner;
    private PrintStream printStream;

    public MenuDialog(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public void startMenuDialog() {
        println("-------------Welcome to Meta Metrics------------");
        println("Instructions: You may enter some details about your project");
        println("so that we may provide you with some metrics and feedback ");
        println("regarding the quality of your code.");
        println("");
    }

    public void endMenuDialog(String filePath) {
        println("");
        println(String.format("Your results are available at: %s", filePath));
        println("You can see your results on a web application");
    }

    public String waitForResponse(String question) {
        println(String.format("%s: ", question));
        return scanner.nextLine();
    }

    private void println(Object object) {
        printStream.println(object.toString());
    }
}
