package Task4LogEntry;

public class LogEntry {
    long timeStamp;
    String login;
    String url;

    public LogEntry(long timeStamp, String login, String url) {
        this.timeStamp = timeStamp;
        this.login = login;
        this.url = url;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }
}
