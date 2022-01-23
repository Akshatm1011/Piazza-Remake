import java.util.Arrays;

public class PhotoMessage extends Message {

    /* Error message to use in OperationDeniedException */
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    /* instance variable */
    private String extension;
    private String[] acceptedTypes = ["jpg","jpeg","gif","png","tif","tiff","raw"];

    public PhotoMessage(User sender, String photoSource)
                        throws OperationDeniedException {
        if (sender != instanceOf(PremiumUser)){
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        if (Arrays.asList(acceptedTypes).contains(extension) == false){
            throw new OperationDeniedException(INVALID_INPUT);
        }
        if (sender == null || photoSource == null){
            throw new IllegalArgumentException();
        }
        super(sender);
        contents = photoSource;
        extension =
    }

    public String getContents() {
        return this.getSender().displayName() + " [" + this.getDate().toString()
                + "]: Picture at " + contents;
    }

    public String getExtension() {
        return extension;
    }

}
