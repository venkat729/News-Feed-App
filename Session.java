package news_feed;

import java.util.Date;

public class Session {
  private User currentUser;
  private String authToken;
  private Date expiryDate;
  private boolean isLoggedIn;

  public Session() {}

  public void setLoggedIn(boolean isLoggedIn) {
    this.isLoggedIn = isLoggedIn;
  }
  public void setAuthToken(String authToken) {
    this.authToken = authToken;
  }
  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }
  public void setCurrentUser(User user) {
    this.currentUser = user;
  }
  public boolean isLoggedIn() {
    return isLoggedIn;
  }
  public String getAuthToken() {
    return authToken;
  }
  public Date getExpiryDate() {
    return expiryDate;
  }
  public User getCurrentUser() {
    return currentUser;
  }
}
