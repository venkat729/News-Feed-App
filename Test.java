package news_feed;

public class Test {
    public static void main(String[] args) {
        String msg = "hello";
        String hash1 = Utils.hash(msg);
        String hash2 = Utils.hash(msg);
        System.out.println(hash1);
        System.out.println(hash2);
    }
}
