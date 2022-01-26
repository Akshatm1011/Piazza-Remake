import java.util.ArrayList;

public class PremiumUser extends User {

    /* instance variable */
    private String customTitle;

    public PremiumUser(String username, String bio) {
        super(username, bio);
        this.customTitle = "Premium";
    }

    public String fetchMessage(MessageExchange me) {
        if (me == null || !me.getUsers().contains(username)){
            throw new IllegalArgumentException();
        }
        String finalMessage = "";
        for (int i = 1; i < me.getLog(this).size(); i--){
            finalMessage = finalMessage + me.getLog(this).get(i);
        }
        return finalMessage;
    }

    public String displayName() {
        return "<" + this.customTitle + "> " + this.username;
    }

    public void setCustomTitle(String newTitle) {
        this.customTitle = newTitle;
    }

    public MessageExchange createModeratedRoom(ArrayList<User> users) {
        if (users == null){
            throw new IllegalArgumentException();
        }
        ModeratedRoom newRoom = new ModeratedRoom(this);
        return newRoom;
    }

    public boolean banUser(ModeratedRoom room, User u) {
        if (room == null){
            throw new IllegalArgumentException();
        }
        return room.banUser(this,this);
    }

    public boolean unbanUser(ModeratedRoom room, User u) {
        if (room == null|| u == null){
            throw new IllegalArgumentException();
        }
        return room.unbanUser(this,this);
    }

    public boolean setNumVisibleLog(ModeratedRoom room, int newNum) {
        if (room == null|| newNum < 10){
            throw new IllegalArgumentException();
        }
        return room.setNumVisibleLog(this, newNum);
    }
}
