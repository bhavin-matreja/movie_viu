package mvp.project.ui.login;

import android.support.annotation.StringRes;

/**
 * Created by Bhavin on 8/18/2017.
 */

public class LoginContract {

    public interface ILoginView {

        void setEmailEmptyError(@StringRes int resId);

        void setPasswordEmptyError(@StringRes int resId);

        void showUnsuccessfulLoginError(@StringRes int resId);

        void showProgressDialog();

        void hideProgressDialog();

        void showToastMessage(String errorMsg);

        void startMoviesActivity();
    }

    public interface ILoginService {

        interface OnLoginFinishedListener {
            void onLoginSuccess();
            void onLoginFailure();
        }

        void login(String username, String password, OnLoginFinishedListener listener);
    }
}
