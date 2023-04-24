package news_feed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SocialNetwork {
  private final List<User> users;
  private int autoIncrementedUserId;
  SocialNetwork() {
    users = new ArrayList<>();
  }
  private boolean hasExistingUsername(String username) {
    for(User user : users) {
      if(user.getUsername().equals(username)) {
        return true;
      }
    }
    return false;
  }
  private boolean hasExistingEmail(String email) {
    for(User user : users) {
      if(user.getEmail().equals(email)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean signup(String[] args) {
    String username = args[1], email = args[2], password = args[3];
    // checking for valid username, email, and password
    if(Utils.isEmpty(username) || Utils.isEmpty(email) || Objects.isNull(password)) {
      return false;
    }
    username = username.trim();
    email = email.trim();
    // checking if username or email exists in database
    if(hasExistingUsername(username) || hasExistingEmail(email)) {
      System.out.println("Username or email already exists");
    } else {
      // creating new user with session
      autoIncrementedUserId++;
      Session session = new Session();
      User user = new User(autoIncrementedUserId,username,email,Utils.hash(password),session);
      session.setCurrentUser(user);
      session.setAuthToken(Utils.getAuthenticationToken(autoIncrementedUserId));
      session.setExpiryDate(Utils.getExpiryDate(10));
      session.setLoggedIn(true);
      users.add(user);
      System.out.println("User created successfully");
      return true;
    }
    return false;
  }
  private boolean login(String[] args) {
    String username = args[1], password = args[2];
    // checking for valid username
    if(Utils.isEmpty(username) || !hasExistingUsername(username)) {
      System.out.println("Invalid username");
      return false;
    }
    password = Utils.hash(password);
    for(User user : users) {
      // if username and password are correct then reinitiating or creating new session based on login status
      if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
        Session session = user.getSession();
        session.setAuthToken(Utils.getAuthenticationToken(user.getUserId()));
        session.setExpiryDate(Utils.getExpiryDate(10));
        if(session.isLoggedIn()) {
          session.setLoggedIn(true);
        }
        System.out.println("Login Successful");
        return true;
      }
    }
    System.out.println("Login failed");
    return false;
  }
  public static void main(String[] arg) throws IOException {
    SocialNetwork app = new SocialNetwork();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      String command = reader.readLine();
      String[] args = command.split(" ");
      if("signup".equalsIgnoreCase(args[0])) {
        app.signup(args);
      }
      if("login".equalsIgnoreCase(args[0])) {
        app.login(args);
      }
      if("quit".equalsIgnoreCase(args[0]))
        break;
    }
  }
}