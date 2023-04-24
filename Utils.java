package news_feed;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Utils {
  static String hash(String password) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(password.getBytes());
      byte[] digest = messageDigest.digest();
      StringBuilder hexString = new StringBuilder();
      for (byte b : digest) {
        hexString.append(Integer.toHexString(0xFF & b));
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return null;
  }
  static boolean isEmpty(String text) {
    return Objects.isNull(text) || text.trim().equals("");
  }
  static String getAuthenticationToken(int userId) {
    // creating random uuid for token
    return UUID.randomUUID().toString()+"-"+userId;
  }
  static Date getExpiryDate(int numberOfDays) {
    // creating expiry date for the given no.of days
    Calendar expiryDate = Calendar.getInstance();
    expiryDate.setTime(Date.from(Instant.now()));
    expiryDate.add(Calendar.DAY_OF_MONTH, numberOfDays);
    return expiryDate.getTime();
  }
}
