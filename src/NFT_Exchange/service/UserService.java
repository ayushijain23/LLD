package NFT_Exchange.service;


import NFT_Exchange.model.Artist;
import NFT_Exchange.model.Person;
import NFT_Exchange.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<Artist> artistList = new ArrayList<>();
    static List<User> userList = new ArrayList<>();


    public static void registerArtist(Artist artist){
        artistList.add(artist);
    }

    public static void registerUser(User user){
        userList.add(user);
    }

    public static Person getPersonById(String id){
        for(Person person : artistList){
            if(person.getId().equals(id)){
                return person;
            }
        }

        for(Person person : userList){
            if(person.getId().equals(id)){
                return person;
            }
        }

        return null;
    }

    public static void getAllUsers(){
        for(Person person : artistList){
            System.out.println("User Name "+ person.getName()+ " And wallet money is:"+ person.getWalletMoney());
        }

        for(Person person : userList){
            System.out.println("User Name "+ person.getName()+ " And wallet money is:"+ person.getWalletMoney());
        }
    }

}
