import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);
    public void processUser(String username, int userId) {
        logger.info(username+" "+ userId);
    }
    public static void main(String[] args) {
    	ParameterizedLogging logging = new ParameterizedLogging();
        logging.processUser("alice", 101);
        logging.processUser("bob", 202);
    }
}
