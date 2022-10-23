package CricketScorer.model;

public class Player {
    private String id;
    private  String name;
    private int age;
    private String gender;
    private String country;

    public Player(String id, String name, int age, String gender, String country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
