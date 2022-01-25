import java.util.ArrayList;
import java.util.List;

public class StandardUser extends User {

    /* Message to append when fetching non-text message */
    private static final String FETCH_DENIED_MSG =
            "This message cannot be fetched because you are not a premium user.";

    public StandardUser(String username, String bio) {
        super(username, bio);
    }

    public String fetchMessage(MessageExchange me) {
        if (me == null|| !me.getUsers().contains(username)){
            throw new IllegalArgumentException();
        }
        int amountOfLogs;
        if (me.getLog(this).size() < 100){
            amountOfLogs = me.getLog(this).size();
        } else {
            amountOfLogs = 100;
        }
        String finalMessage = "";
        for (int i = 0; i < amountOfLogs; i++){
            if (!(me.getLog(this).get(i) instanceof TextMessage)) {
                finalMessage = finalMessage + FETCH_DENIED_MSG;
            } else {
                finalMessage = finalMessage + me.getLog(this).get(i);
            }
        }
        return finalMessage;
    }

    public String displayName() {
        return username;  // placeholder for checkpoint test.
                               // replace it with your own after checkpoint submission.
    }
}
