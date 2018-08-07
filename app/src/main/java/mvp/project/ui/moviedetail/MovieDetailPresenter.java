package mvp.project.ui.moviedetail;

import mvp.project.R;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MovieDetailPresenter {

    private MovieDetailContract.IMovieDetailView view;

    public MovieDetailPresenter(MovieDetailContract.IMovieDetailView view) {
        this.view = view;
    }

    public void loadData(String movieName, String movieUrl) {
        if (movieName == null || movieUrl == null) {
            view.showToastMessage(R.string.error_no_data);
            return;
        }
        view.showMoviePoster(movieUrl);
        view.showMovieName(movieName);
    }
}
