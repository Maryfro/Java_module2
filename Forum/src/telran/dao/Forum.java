package telran.dao;

import telran.data.Post;
import telran.data.UserAdmin;

import java.util.Arrays;
import java.util.Scanner;

public class Forum {
    private Post[] posts;
    int size;

    public Forum(int capacity) {
        posts = new Post[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean addPost(Post post) {
        if (size < posts.length) {
            posts[size] = post;
            size++;
            return true;
        }
        return false;
    }

    public Post[] getLastPostsByAuthor(String authorName, int numberOfPosts) {
        int newIndex = 0;
        Post[] postsByAuthor = new Post[numberOfPosts];
        for (int i = 0; i < size; i++) {
            if (posts[i].getAuthor().getName().equalsIgnoreCase(authorName) && newIndex < numberOfPosts) {
                postsByAuthor[newIndex] = posts[i];
                newIndex++;
            }
        }
        return postsByAuthor;
    }

    public int countLikesByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equalsIgnoreCase(title)) {
                return posts[i].getLikes();
            }
        }
        return -1;
    }

    private boolean checkPassword(Scanner scanner) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getAuthor().getClass().getSimpleName().equals("UserAdmin")) {
                UserAdmin admin = (UserAdmin) posts[i].getAuthor();
                int count = 3;
                while (count > 0) {
                    System.out.println("enter password ");
                    String password = scanner.nextLine();
                    if (admin.getPassword().equals(password))
                        return true;
                    else
                        count--;
                }
                break;
            }
        }
        return false;
    }

    public void updatePostByAdmin(int postID, Scanner scanner) {
        if (checkPassword(scanner)) {
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                if (posts[i].getPostID() == postID) {
                    System.out.println("Old content " + posts[i].getContent());
                    System.out.println("enter updates");
                    posts[i].setContent(scanner.nextLine());
                    System.out.println(postID + " content changed to " + posts[i].getContent());
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("post was not found");
            }
        } else {
            System.out.println("Access denied");
        }
    }

    public void removePost(Post post, Scanner scanner) {
        if (checkPassword(scanner)) {
            boolean checked = false;
            for (int i = 0; i < size; i++) {
                if (posts[i].equals(post)) {
                    System.out.println("you are going to delete this post ");
                    System.out.println(posts[i].toString());
                    posts[i] = posts[size-1];
                    size--;
                    checked = true;
                    break;
                }
            }
            if (!checked) {
                System.out.println("post was not found");
            }
        } else {
            System.out.println("access denied");
        }
    }

    @Override
    public String toString() {
        return "posts: " + Arrays.toString(posts);
    }

    public void displayForum(){
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
        }
    }
}
