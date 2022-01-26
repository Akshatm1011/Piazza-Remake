import java.util.ArrayList;

public class ChatRoom implements MessageExchange {

    /* instance variables */
    private ArrayList<User> users;
    private ArrayList<Message> log;

    public ChatRoom() {
        this.users = new ArrayList<>();
        this.log = new ArrayList<>();
    }

    public ArrayList<Message> getLog(User requester) {
        return this.log;
    }

    public boolean addUser(User u) {
        if (this.users.contains(u)){
            return false;
        } else {
            this.users.add(u);
            u.rooms.add(this);
            return true;
        }
    }

    public boolean removeUser(User requester, User u) {
        if (!this.users.contains(u)){
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
}