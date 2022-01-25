import java.util.ArrayList;

public class PremiumUser extends User {

    /* instance variable */
    private String customTitle;

    public PremiumUser(String username, String bio) {
        super(username, bio);
        this.customTitle = customTitle;
    }

    public String fetchMessage(MessageExchange me) {
        if (me == null || !me.contains(username)){
            throw new IllegalArgumentException();
        }
        String finalMessage = "";
        for (int i = 0; i < me.getLog(this).size(); i++){
            finalMessage = finalMessage + me.getContents();
        }
        return finalMessage;
    }

    public String displayName() {
        return "<" + customTitle + "> " + username;
    }

    public void setCustomTitle(String newTitle) {
        customTitle = newTitle;
    }

    public MessageExchange createModeratedRoom(ArrayList<User> users) {
        if (users == null){
            throw new IllegalArgumentException();
        }
        ModeratedRoom newRoom = new ModeratedRoom(this);
        return newRoom;
    }

    public boolean banUser(ModeratedRoom room, User u) {
        if (room == null|| ModeratedRoom.newNum < 10){
            throw new IllegalArgumentException();
        }
        room.banUser(this,this);
        return true;
    }

    public boolean unbanUser(ModeratedRoom room, User u) {
        if (room == null|| u == null){
            return false;
        }
        room.unbanUser(this,this);
        return true;
    }

    public boolean setNumVisibleLog(ModeratedRoom room, int newNum) {
        room.setNumVisibleLog(this, newNum);
        return true;
    }

}
