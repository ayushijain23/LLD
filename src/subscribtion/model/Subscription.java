package subscribtion.model;

public interface Subscription {
    void subscribe(NewsLetter letter, User user, int price);
    void unsubscribe(User user);
    void notifyUsers();
}
