package news_feed;

import java.util.List;

public class User {
  private final int userId;
  private final String username;
  private final String email;
  private final String password;
  private final Session session;
  private List<User> followers, following;
  public String getEmail() {
    return email;
  }
  public String getPassword() {
    return password;
  }
  public List<User> getFollowers() {
    return followers;
  }
  public List<User> getFollowing() {
    return following;
  }
  public Session getSession() {
    return session;
  }
  public int getUserId() {
    return userId;
  }
  public String getUsername() {
    return username;
  }
  public User(int userId, String username, String email, String password, Session session) {
    this.userId = userId;
    this.email = email;
    this.username = username;
    this.password = password;
    this.session = session;
  }
  public Post createPost(String title, String text) {
    return null;
  }
  public boolean follow(User user) {
    return false;
  }
  public List<Post> getNewsFeed() {
    return null;
  }
}
