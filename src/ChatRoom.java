import java.util.ArrayList;

public class ChatRoom implements MessageExchange {

    /* instance variables */
    private ArrayList<User> users;
    private ArrayList<Message> log;

    public ChatRoom() {
        users = new ArrayList<>();
        log = new ArrayList<>();
    }

    public ArrayList<Message> getLog(User requester) {
        return log;
    }

    public boolean addUser(User u) {
        if (users.contains(u)){
            return false;
        } else {
            users.add(u);
            u.rooms.add(this);
            return true;
        }
    }

    public boolean removeUser(User requester, User u) {
        if (!users.contains(u)){
            return false;
        } else {
            users.remove(u);
            u.rooms.remove(this);
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
}