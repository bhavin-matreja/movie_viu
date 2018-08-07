package mvp.project.ui.movies2;

import java.util.List;

import mvp.project.model.MovieModel;

/**
 * Created by Bhavin on 11/28/2017.
 */

public class MoviesContract {

    public interface iMoviesView {
        void showProgressDialog();

        void hideProgressDialog();

        void setRecyclerAdapter(List<MovieModel> movieModels);

        void showToastMessage(int resId);
    }

    public interface iMoviesService {
        interface OnMoviesDataFetchFinishedListener {
            void onMoviesDataRecSuccess(List<MovieModel> movieModels);
            void onMoviesDataRecFailure();
        }

        void getMoviesData(OnMoviesDataFetchFinishedListener listener);

    }

}
