package root;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import db.DBManager;
import db.TwitterLink;
import db.TwitterResult;
import metrics.GenericMetrics;
import metrics.TimeCalculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TwitterSearchServlet extends HttpServlet {

    GenericMetrics metrics = metrics = new GenericMetrics
            ("TWEETS/MANUFACTOR", "SearchTime",
                    "TimeInterval", "Millisecond");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        System.out.println("new request query: " + query);
        TimeCalculator timer = new TimeCalculator();
        timer.start();
        ArrayList<TwitterLink> list = new ArrayList<>();
        if(query == null || query.equals("")) {
            // return all data
            list = DBManager.getInstance().selectAll();
        } else {
            list = DBManager.getInstance().select(query);
        }
        TwitterResult[] resultList = list.stream()
                .map(twitterLink -> new TwitterResult(twitterLink))
                .toArray(TwitterResult[]::new);
        System.out.println("result count: " + resultList.length);
        long time = timer.stop();
        metrics.sendMetricData((double) time);
        ResultListHolder resultHolder = new ResultListHolder(resultList);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(resultHolder);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(json);
    }
}
