package mvp.project.network;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import mvp.project.model.LoginModel;
import mvp.project.model.MovieModel;

/**
 * Created by Bhavin on 8/18/2017.
 */

public class ServiceApi {

    public interface Login{

        @POST("/login")
        void callLoginApi(@Body LoginModel model, Callback<String> callback);
    }

    public interface MoviesRepo{

        @GET("/json/glide.json")
        void getMoviesData(Callback<List<MovieModel>> callback);
    }
}
