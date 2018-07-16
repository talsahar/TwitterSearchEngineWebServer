package db;

public class TwitterLink {
    private String title;
    private String content;
    private String url;
    private String imageUrl;
    private String description;
    private long timestamp;

    public TwitterLink(String title, String content, String imageUrl, String url, String description, long timestamp) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.description = description;
        this.imageUrl = imageUrl;
        this.timestamp = timestamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getFilename() {
        if(title == null || title.equals(""))
            return url;
        return title;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
