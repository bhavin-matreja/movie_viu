package mvp.project.ui.movies;

import android.support.annotation.StringRes;

import java.util.List;

import mvp.project.model.MovieModel;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MoviesContract {

    public interface IMoviesActivityView {

        void setRecyclerAdapter(List<MovieModel> movieModels);

        void showToastMessage(@StringRes int resId);

        void showProgressDialog();

        void hideProgressDialog();
    }

    public interface IMoviesActivityService {

        interface OnMoviesDataFetchFinishedListener {
            void onMoviesDataRecSuccess(List<MovieModel> movieModels);
            void onMoviesDataRecFailure();
        }

        void getMoviesData(OnMoviesDataFetchFinishedListener listener);

    }
}
