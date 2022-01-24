public class TextMessage extends Message {

    /* Error message to use in OperationDeniedException */
    private static final String EXCEED_MAX_LENGTH =
            "Your input exceeded the maximum length limit.";

    public TextMessage(User sender, String text)
            throws OperationDeniedException {
        super(sender);
        if (text.length() > 500){
            throw new OperationDeniedException("EXCEED_MAX_LENGTH");
        }
        if (text == null || sender == null){
            throw new IllegalArgumentException();
        }
        contents = text;
    }

    public String getContents() {
        return this.getSender().displayName() + " [" + this.getDate().toString()
                + "]: " + contents;
    }
}
