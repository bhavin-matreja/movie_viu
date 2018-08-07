package mvp.project.ui.movies;

import java.util.List;

import mvp.project.R;
import mvp.project.model.MovieModel;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MoviesPresenter implements MoviesContract.IMoviesActivityService.OnMoviesDataFetchFinishedListener {

    private List<MovieModel> movieModels;
    private MoviesContract.IMoviesActivityView view;
    private MoviesContract.IMoviesActivityService service;

    public MoviesPresenter(MoviesContract.IMoviesActivityView view, MoviesContract.IMoviesActivityService service) {
        this.view = view;
        this.service = service;
    }

    public void fetchMoviesData(){
        view.showProgressDialog();
        service.getMoviesData(this);
    }

    @Override
    public void onMoviesDataRecSuccess(List<MovieModel> movieModels) {
        view.hideProgressDialog();
        if(movieModels!=null) {
            this.movieModels = movieModels;
            view.setRecyclerAdapter(movieModels);
        }
        else {
            view.showToastMessage(R.string.error_no_data);
        }
    }

    @Override
    public void onMoviesDataRecFailure() {
        view.hideProgressDialog();
        view.showToastMessage(R.string.error_no_data);
    }
}
