package telran.app;

import telran.dao.Forum;
import telran.data.Post;
import telran.data.User;
import telran.data.UserAdmin;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user1 = new User("Vasya", 25);
        User user2 = new User("Petya", 33);
        UserAdmin admin = new UserAdmin("Oleg", 39, "123");
        Post post1 = new Post(user1, "How to learn java?", "You have to work hard");
        Post post2 = new Post(user2, "How to become a millionaire", "You have to work hard as well");
        Post post3 = new Post(admin, "How to become a billionaire?", "You have to work hard as well");

        Forum forum = new Forum(20, "123");
        forum.addPost(post1);
        forum.addPost(post2);
        forum.addPost(post3);

        //System.out.println(post1.getLikes());
        post1.addLike();
        post1.addLike();
        post1.addLike();
        post2.addLike();
        post2.addLike();
        post2.addLike();
        post2.addLike();
        post2.addLike();
        post3.addLike();
        post3.addLike();

        //System.out.println(post1.getLikes());
        //System.out.println(forum.countLikesByTitle(post1.getTitle()));
        //System.out.println(Arrays.toString(forum.getLastPostsByAuthor(post3.getAuthor().getName(), 2)));
        // forum1.displayForum();
    /*    System.out.println("--------------------");
        forum.updatePostByAdmin(post3.getPostID(), scanner);
        forum.updatePostByAdmin(15, scanner);
        System.out.println("-------------------");*/
        /*forum.removePost(post1, scanner, admin);
        System.out.println("-------------------");
        forum.displayForum();
        */
       /* forum.updatePostByUserAdmin(post3.getPostID(), scanner, admin);
        forum.updatePostByAdmin(post2.getPostID(), scanner);

        scanner.close();*/

        System.out.println(forum.getPostWithMaxLikes());
        System.out.println("--------");
        String[] str = {"s", null, "b", null};
        Post[] posts = {null, post1, null, post2, null, post3};
        User[] users = {user1, null, user2, null, admin};
        Forum[] forums = {null, forum, null};
        Forum.displayNonNull(posts);
        System.out.println("--------");
        Forum.displayNonNull(str);
        System.out.println("--------");
        Forum.displayNonNull(users);
        System.out.println("--------");
        //Forum.displayNonNull(forums);

    }
}
