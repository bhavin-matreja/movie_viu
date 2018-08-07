package mvp.project.ui.movies2;

import java.util.List;

import mvp.project.R;
import mvp.project.model.MovieModel;

/**
 * Created by Bhavin on 11/28/2017.
 */

class MoviesPresenter implements MoviesContract.iMoviesService.OnMoviesDataFetchFinishedListener {

    private MoviesContract.iMoviesView view;
    private MoviesContract.iMoviesService service;
    private List<MovieModel> movieModels;

    public MoviesPresenter(MoviesContract.iMoviesView view, MoviesContract.iMoviesService service) {
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

    }
}
