import java.util.Arrays;
import java.util.Locale;

public class PhotoMessage extends Message {

    /* Error message to use in OperationDeniedException */
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    /* instance variable */
    private String extension;
    private String[] acceptedTypes;
    private String[] spliter;
    private int index;

    public PhotoMessage(User sender, String photoSource)
                        throws OperationDeniedException {
        super(sender);
        this.contents = photoSource;
        this.spliter = photoSource.split("\\.");
        this.extension = spliter[0].toLowerCase();
        this.acceptedTypes = new String[]{"jpg","jpeg","gif","png","tif","tiff","raw"};
        if (!(sender instanceof PremiumUser)){
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        if (!(Arrays.asList(acceptedTypes).contains(extension))){
            throw new OperationDeniedException(INVALID_INPUT);
        }
        if (sender == null || photoSource == null){
            throw new IllegalArgumentException();
        }
    }

    public String getContents() {
        return this.getSender().displayName() + " [" + this.getDate().toString()
                + "]: Picture at " + this.contents;
    }

    public String getExtension() {
        return this.extension;
    }

}
