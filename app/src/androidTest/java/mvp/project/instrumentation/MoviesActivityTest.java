package mvp.project.instrumentation;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mvp.project.R;
import mvp.project.ui.movies.MoviesActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by Bhavin on 8/21/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MoviesActivityTest {

    @Rule
    public ActivityTestRule<MoviesActivity> mActivityTestRule = new ActivityTestRule<>(MoviesActivity.class);

    @Test
    public void checkMovieListDataIsFetchedAndPerformClick() {
        // Assert RecyclerView has data
        Assert.assertThat(getRVcount(),greaterThan(0));
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rvMoviesList), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));
        onView(allOf(withId(R.id.ivMoviePoster), isDisplayed()));
    }

    private int getRVcount(){
        RecyclerView recyclerView = (RecyclerView) mActivityTestRule.getActivity().findViewById(R.id.rvMoviesList);
        if(recyclerView.getAdapter()==null) return 0;
        return recyclerView.getAdapter().getItemCount();
    }

}
