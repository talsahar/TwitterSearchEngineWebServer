package root;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {
    /**
     * Runs on port 8080, serves clients search queries
     * path: /results?query=example
     * An empty query will result all exists entities from rds db

     * EV/SystemProperties:#
     AWS_ACCESS_KEY
     AWS_SECRET_ACCESS_KEY
     RDS_TABLE_NAME
     RDS_DB_NAME
     RDS_USERNAME
     RDS_PASSWORD
     RDS_HOSTNAME
     RDS_PORT
    */
    public static void main(String[] args) {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler(server, "/results");
        handler.addServlet(TwitterSearchServlet.class, "/");
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}