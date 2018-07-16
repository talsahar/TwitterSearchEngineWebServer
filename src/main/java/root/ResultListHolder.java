package root;

import db.TwitterResult;

public class ResultListHolder {

    TwitterResult[] results;

    public ResultListHolder(TwitterResult[] results) {
        this.results = results;
    }

    public void setResult(TwitterResult[] results) {
        this.results = results;
    }

    public TwitterResult[] getResults() {
        return results;
    }
}
