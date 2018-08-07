package mvp.project.ui.movies;

import java.util.List;

import mvp.project.model.MovieModel;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MoviesRecyclerPresenter {


    interface View{
        void setMovieTitle(String name);
        void setMoviePosterImage(String url);
    }

    private List<MovieModel> movieModels;

    public MoviesRecyclerPresenter(List<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }


    public void onBindRepositoryRowViewAtPosition(int position, MoviesRecyclerPresenter.View view) {
        MovieModel movieModel = movieModels.get(position);
        view.setMovieTitle(movieModel.name);
        view.setMoviePosterImage(movieModel.url.medium);
    }

    public int getRepositoriesRowsCount() {
        return movieModels.size();
    }

    public MovieModel onMovieItemClicked(int position) {
        MovieModel movie = movieModels.get(position);
        return movie;
    }
}
