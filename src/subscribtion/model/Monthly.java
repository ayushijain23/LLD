package subscribtion.model;

import java.util.ArrayList;
import java.util.List;

public class Monthly implements Subscription{

    public Monthly(){

    }
    public Monthly(List<User> observers) {
        this.observers = observers;
    }

    List<User> observers = new ArrayList<>();
    @Override
    public void subscribe(NewsLetter letter, User user, int price) {
        observers.add(user);
    }

    @Override
    public void unsubscribe(User user) {
         observers.remove(user);
    }

    @Override
    public void notifyUsers() {
       for(User user : observers){
           //logic to send newsLetters
       }
    }

    public void sendLetters(){
        notifyUsers();
    }


}
