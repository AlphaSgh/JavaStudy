import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class testException {
    public static void testException() {
/*
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void process1() {
        process2();
    }
    static void process2() {
        Integer.parseInt(null);
    }
*/
        //log4j
        Logger logger = Logger.getLogger(testException.class.getName());
        logger.info("start process");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            logger.severe(e.getMessage());
        }
        logger.info("process end");
    }
}