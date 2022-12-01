public class Player {

    public Player(int id, String Name, int strength) {
        this.id = id;
        this.name = Name;
        this.strength = strength;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

//    public void setPlayerName(String playerName) {
//        this.name = playerName;
//    }

    public int getStrength() {
        return strength;
    }

//    public void setStrength(int strength) {
//        this.strength = strength;
//    }

    private int id;
    private String name;
    private int strength;
}
