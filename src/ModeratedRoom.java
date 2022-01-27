import java.util.ArrayList;
import java.util.List;

public class ModeratedRoom implements MessageExchange {
    /* instance variables */
    private ArrayList<User> users, banned;
    private ArrayList<Message> log;
    private User moderator;
    private int numVisibleLog;

    public ModeratedRoom(PremiumUser moderator) {
        this.users = new ArrayList<>();
        this.banned = new ArrayList<>();
        this.log = new ArrayList<>();
        this.moderator = moderator;
        this.numVisibleLog = Integer.MAX_VALUE;
        this.users.add(moderator);
    }

    public ArrayList<Message> getLog(User requester) {
        ArrayList allowedLogs = new ArrayList();
        if (requester == this.moderator){
            return this.log;
        }
        if (requester != this.moderator){
            if (this.log.size() < this.numVisibleLog){
                allowedLogs = this.log;
                return this.log;
            } else {
                allowedLogs.add(this.log.subList(0,this.numVisibleLog));
                return allowedLogs;
            }
        }
        return allowedLogs;
    }

    public boolean addUser(User u) {
        if (this.banned.contains(u)|| this.users.contains(u)){
            return false;
        } else {
            this.users.add(u);
            u.rooms.add(this);
            return true;
        }
    }

    public boolean removeUser(User requester, User u) {
        if (u == this.moderator || !this.users.contains(u)){
            return false;
        } else {
            this.users.remove(u);
            u.rooms.remove(this);
            return true;
        }
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public boolean recordMessage(Message m) {
        this.log.add(m);
        return true;
    }

    public boolean banUser(User requester, User u) {
        if (requester != this.moderator || u == this.moderator){
            return false;
        } else {
            this.users.remove(u);
            this.banned.add(u);
            u.rooms.add(this);
            return true;
        }
    }

    public boolean unbanUser(User requester, User u) {
        if (requester != this.moderator){
            return false;
        } else {
            this.banned.remove(u);
            return true;
        }
    }

    public boolean setNumVisibleLog(User requester, int newNum) {
        if (requester != this.moderator) {
            return false;
        } else {
            this.numVisibleLog = newNum;
            return true;
        }
    }
}
