package utility;

import java.io.PrintWriter;
import java.io.StringWriter;

public class EduExceptionHandler {

    public static void ThrowEX(Exception ex) {
        System.out.println("An error has occurred. Please call an administrator" + "\n" + " -- Error details --" + "\n");
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        System.out.println(exceptionAsString);
    }
}
