import java.util.ArrayList;
import java.util.Arrays;

public abstract class User {

    /* Error message to use in OperationDeniedException */
    protected static final String JOIN_ROOM_FAILED =
            "Failed to join the chat room.";
    protected static final String INVALID_MSG_TYPE =
            "Cannot send this type of message to the specified room.";

    /* instance variables */
    protected String username;
    protected String bio;
    protected ArrayList<MessageExchange> rooms;

    public User(String username, String bio) {
        if (username == null|| bio == null){
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.bio = bio;
        ArrayList rooms = new ArrayList();
    }

    public void setBio(String newBio) {
        bio = newBio;
    }

    public String displayBio() {
        return bio;
    }

    public void joinRoom(MessageExchange me) throws OperationDeniedException {
        if (me == null){
            throw new IllegalArgumentException();
        }
        if (Arrays.asList(rooms).contains(me)||me.addUser(this) == false){
            throw new OperationDeniedException(JOIN_ROOM_FAILED);
        }
    }

    public void quitRoom(MessageExchange me) {
        if (me == null){
            throw new IllegalArgumentException();
        }
        me.removeUser(this,this);
    }

    public MessageExchange createChatRoom(ArrayList<User> users) {
        if (users == null){
            throw new IllegalArgumentException();
        }
        ChatRoom newRoom = new ChatRoom();
        rooms.add(newRoom);
        for (int i = 0; i < users.size(); i++){
            try{
                newRoom.joinRoom(users.get(i));
            } catch (OperationDeniedException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
        return newRoom;
    }

    public void sendMessage(MessageExchange me, MessageType msgType, String contents) {
        /*record message instance in msgExchange*/
        if (me == null|| msgType == null|| contents == null){
            throw new IllegalArgumentException();
        }
        if (msgType != MessageType.TEXT|| msgType != MessageType.PHOTO){
            throw new IllegalArgumentException();
        }
        if (!user.join(me)){
            throw new IllegalArgumentException();
        }
        try{

        } catch {

        }
    }

    public abstract String fetchMessage(MessageExchange me);

    public abstract String displayName();
}
