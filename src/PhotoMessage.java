import java.util.Arrays;
import java.util.Locale;

public class PhotoMessage extends Message {

    /* Error message to use in OperationDeniedException */
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    /* instance variable */
    private String extension;
    private String[] acceptedTypes = new String[]{"jpg","jpeg","gif","png","tif","tiff","raw"};

    public PhotoMessage(User sender, String photoSource)
                        throws OperationDeniedException {
        super(sender);
        if (!(sender instanceof PremiumUser)){
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        if (Arrays.asList(this.acceptedTypes).contains(this.extension) == false){
            throw new OperationDeniedException(INVALID_INPUT);
        }
        if (sender == null || photoSource == null){
            throw new IllegalArgumentException();
        }
        this.contents = photoSource;
        this.extension = photoSource.split(".")[-1].toLowerCase();
    }

    public String getContents() {
        return this.getSender().displayName() + " [" + this.getDate().toString()
                + "]: Picture at " + this.contents;
    }

    public String getExtension() {
        return this.extension;
    }

}
