package telran.data;

public class Post {
    private User author;
    private int postID;
    private static int totalPosts = 0;
    private String title;
    private String content;
    private int likes = 0;
    private int dislikes = 0;

    public Post(User author, String title, String content) {
        this.author = author;
        this.postID = ++totalPosts;
        this.title = title;
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public int getPostID() {
        return postID;
    }

    public static int getTotalPosts() {
        return totalPosts;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "author: " + author +
                ", postID: " + postID +
                ", title: " + title.toUpperCase()  +
                "\n " + content +
                "\nlikes: " + likes +
                ", dislikes: " + dislikes;
    }

    public int addLike(){
        return likes++;
    }

    public int addDislike(){
        return dislikes++;
    }
}
