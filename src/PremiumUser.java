import java.util.ArrayList;

public class PremiumUser extends User {

    /* instance variable */
    private String customTitle;

    public PremiumUser(String username, String bio) {
        super(username, bio);
        this.customTitle = customTitle;
    }

    public String fetchMessage(MessageExchange me) {
        if (input == null || !user.joinRoom(me)){
            throw new IllegalArgumentException();
        }
        String finalMessage;
        for (int i = 0; i < me.getMessage(); i++){
            finalMessage = finalMessage + me.getContents(i);
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
        /* come back bro */
        return null;
    }

    public boolean banUser(ModeratedRoom room, User u) {
        if (room == null|| newNum < 10){
            throw new IllegalArgumentException();
        }
        /* come back bro */
        return false;
    }

    public boolean unbanUser(ModeratedRoom room, User u) {
        /* come back */
        return false;
    }

    public boolean setNumVisibleLog(ModeratedRoom room, int newNum) {
        /* come back */
        return false;
    }

}
