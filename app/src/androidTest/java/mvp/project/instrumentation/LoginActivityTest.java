package mvp.project.instrumentation;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mvp.project.R;
import mvp.project.ui.login.LoginActivity;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Bhavin on 8/21/2017.
 */

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {


    @Rule
    public ActivityTestRule<LoginActivity> mLoginActivityActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void shouldLoginWithValidCredentials() {
        onView(withId(R.id.etEmail)).perform(typeText("viu-android-test@viu@.com"));
        onView(withId(R.id.etPassword)).perform(typeText("viu1234"),closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());

        onView(allOf(withId(R.id.rvMoviesList), isDisplayed()));

    }

    @Test
    public void shouldShowEmailEmptyError() {
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.etEmail)).check(matches(hasErrorText(getResourceString(R.string.error_email_empty))));
    }

    @Test
    public void shouldShowPasswordEmptyError() {
        onView(withId(R.id.etEmail)).perform(typeText("viu-android-test@viu@.com"),closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.etPassword)).check(matches(hasErrorText(getResourceString(R.string.error_password_empty))));
    }

    private String getResourceString(int id) {
        Context targetContext = getTargetContext();
        return targetContext.getResources().getString(id);
    }
}
