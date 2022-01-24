import java.util.ArrayList;
import java.util.List;

public class ModeratedRoom implements MessageExchange {
    /* instance variables */
    private ArrayList<User> users, banned;
    private ArrayList<Message> log;
    private User moderator;
    private int numVisibleLog;

    public ModeratedRoom(PremiumUser moderator) {
        users = new ArrayList<>();
        banned = new ArrayList<>();
        log = new ArrayList<>();
        this.moderator = moderator;
        numVisibleLog = Integer.MAX_VALUE;
        users.add(moderator);
    }

    public ArrayList<Message> getLog(User requester) {
        String allowedContents;
        if (requester == moderator){
            for (int i = 0; i < numVisibleLog; i++){
                allowedContents = allowedContents + log.get(i);
            }
            return allowedContents;
        }
        if (requester != moderator){
            if (log.length() < numVisibleLog){
                return log;
            } else {

                for (int i = 0; i < numVisibleLog; i++){
                    allowedContents = allowedContents + log.get(i);
                }
                return allowedContents;
            }
        }
    }

    public boolean addUser(User u) {
        if (banned.contains(u)|| users.contains(u)){
            return false;
        } else {
            users.add(u);
            u.rooms++ ;
            return true;
        }
    }

    public boolean removeUser(User requester, User u) {
        if (u == moderator || !users.contains(u)){
            return false;
        } else {
            users.remove(u);
            u.rooms--;
            return true;
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean recordMessage(Message m) {
        log.add(m);
        return true;
    }

    public boolean banUser(User requester, User u) {
        if (requester != moderator || u == moderator){
            return false;
        } else {
            users.remove(u);
            banned.add(u);
            u.rooms--;
            return true;
        }
    }

    public boolean unbanUser(User requester, User u) {
        if (requester != moderator){
            return false;
        } else {
            banned.remove(u);
            return true;
        }
    }

    public boolean setNumVisibleLog(User requester, int newNum) {
        if (requester != moderator) {
            return false;
        } else {
            numVisibleLog = newNum;
            return true;
        }
    }
}
