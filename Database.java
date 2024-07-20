import java.util.List;

public interface Database {
    void connect();
    List<Friend> getFriends();
}
