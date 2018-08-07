package mvp.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import mvp.project.model.MovieModel;
import mvp.project.ui.movies.MoviesContract;
import mvp.project.ui.movies.MoviesPresenter;

import static org.mockito.Mockito.verify;

/**
 * Created by Bhavin on 8/21/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class MoviesPresenterTest {

    @Mock
    MoviesContract.IMoviesActivityView view;

    @Mock
    MoviesContract.IMoviesActivityService service;

    @InjectMocks
    MoviesPresenter presenter = new MoviesPresenter(view,service);


    @Test
    public void shouldSetAdapterWhenMoviesDataRecSuccess(){
        List<MovieModel> movieModels = Arrays.asList(new MovieModel());
        presenter.onMoviesDataRecSuccess(movieModels);
        verify(view).setRecyclerAdapter(movieModels);
    }

    @Test
    public void shouldShowErrorWhenMoviesDataRecSucessGotNoList(){
        presenter.onMoviesDataRecSuccess(null);
        verify(view).showToastMessage(R.string.error_no_data);
    }

    @Test
    public void shouldShowMoviesDataRecFailedError() {
        presenter.onMoviesDataRecFailure();
        verify(view).showToastMessage(R.string.error_no_data);
    }
}
