package db;

public class TwitterResult {

String link;
String title;
String description;
String gist; // first 100 of content
String screenshot_url;
String timestamp;

    public TwitterResult(TwitterLink link) {
        this.link = link.getUrl();
        this.title = link.getTitle();
        this.description = link.getDescription();
        String content = link.getContent();
        this.gist = content.substring(0, Math.min(content.length(), 100));
        this.screenshot_url = link.getImageUrl();
        this.timestamp = Long.toString(link.getTimestamp());
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGist(String gist) {
        this.gist = gist;
    }

    public void setScreenshot_url(String screenshot_url) {
        this.screenshot_url = screenshot_url;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getGist() {
        return gist;
    }

    public String getScreenshot_url() {
        return screenshot_url;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
