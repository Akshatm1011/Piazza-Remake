/*
  Name: Your Name
  PID:  A12345678
 */

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Messenger Application Test
 * @author TODO
 * @since  TODO
 */
public class MessengerApplicationTest {

    /*
      Messages defined in starter code. Remember to copy and paste these strings to the
      test file if you cannot directly access them. DO NOT change the original declaration
      to public.
     */
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    /*
      Global test variables. Initialize them in @Before method.
     */
    PremiumUser marina;
    MessageExchange room;
    ModeratedRoom moder;
    TextMessage texter;
    /*
      The date used in Message and its subclasses. You can directly
      call this in your test methods.
     */
    LocalDate date = LocalDate.now();

    /*
     * Setup
     */
    @Before
    public void setup() {
        marina = new PremiumUser("Marina", "Instructor");
        room = new ChatRoom();
        StandardUser newUser = new StandardUser("shawn", "student");
        moder = new ModeratedRoom(marina);
        try{
            texter = new TextMessage(marina, "tester");
        } catch (OperationDeniedException E){

        }

    }

    /*
      Recap: Assert exception without message
     */
    @Test (expected = IllegalArgumentException.class)
    public void testPremiumUserThrowsIAE() {
        marina = new PremiumUser("Marina", null);
    }

    /*
      Assert exception with message
     */
    @Test
    public void testPhotoMessageThrowsODE() {
        try {
            PhotoMessage pm = new PhotoMessage(marina, "PA02.zip");
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_INPUT, ode.getMessage());
        }
    }

    /*
     * Assert message content without hardcoding the date
     */

    /* @Test
    public void testTextMessageGetContents() {
        try {
            TextMessage tm = new TextMessage(marina, "A sample text message.");

            // concatenating the current date when running the test
            String expected = "<Premium> Marina [" + date + "]: A sample text message.";
            assertEquals(expected, tm.getContents());
        } catch (OperationDeniedException ode) {
            fail("ODE should not be thrown");
        }
    }
    */

    @Test
    public void tester(){
        moder.recordMessage(texter);
        moder.getLog(marina).get(0);
        System.out.println(moder.getLog(marina).toString());
    }

    /*
      TODO: Add your tests
     */

}
