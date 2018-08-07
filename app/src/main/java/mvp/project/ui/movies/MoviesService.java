package mvp.project.ui.movies;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import mvp.project.model.MovieModel;
import mvp.project.network.ServiceApi;
import mvp.project.network.ServiceClient2;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MoviesService implements MoviesContract.IMoviesActivityService {

    @Override
    public void getMoviesData(final OnMoviesDataFetchFinishedListener listener) {

        ServiceApi.MoviesRepo api = ServiceClient2.getInstance().getClient(ServiceApi.MoviesRepo.class);
        api.getMoviesData(new Callback<List<MovieModel>>() {

            @Override
            public void success(List<MovieModel> movieModels, Response response) {
                listener.onMoviesDataRecSuccess(movieModels);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onMoviesDataRecFailure();
            }
        });
    }
}
