package mvp.project.ui.moviedetail;

import android.support.annotation.StringRes;

/**
 * Created by Bhavin on 8/20/2017.
 */

public class MovieDetailContract {

    public interface IMovieDetailView{

        void showToastMessage(@StringRes int resId);

        void showMoviePoster(String movieUrl);

        void showMovieName(String movieName);
    }
}
