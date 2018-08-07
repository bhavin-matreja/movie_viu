package mvp.project.util;

/**
 * Created by Bhavin on 8/21/2017.
 */

public class CommanUtility {

    public static boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
