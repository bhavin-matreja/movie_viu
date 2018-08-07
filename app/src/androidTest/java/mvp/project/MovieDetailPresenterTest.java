package mvp.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import mvp.project.ui.moviedetail.MovieDetailContract;
import mvp.project.ui.moviedetail.MovieDetailPresenter;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by Bhavin on 8/21/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class MovieDetailPresenterTest {

    @Mock
    MovieDetailContract.IMovieDetailView view;

    @InjectMocks
    MovieDetailPresenter presenter = new MovieDetailPresenter(view);

    @Test
    public void shouldShowCouldntLoadDataError(){
        //MovieDetailPresenter presenter = new MovieDetailPresenter(view);
        presenter.loadData(null, "abc");
        verify(view).showToastMessage(R.string.error_no_data);
    }

    @Test
    public void shouldLoadMovieData(){
        //MovieDetailPresenter presenter = new MovieDetailPresenter(view);
        presenter.loadData("abc", "abc.png");
        verify(view).showMoviePoster(eq("abc.png"));
        verify(view).showMovieName(eq("abc"));

    }
}
