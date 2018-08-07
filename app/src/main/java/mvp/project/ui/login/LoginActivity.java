package mvp.project.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mvp.project.R;
import mvp.project.ui.movies.MoviesActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.ILoginView {

    private EditText etEmail,etPassword;
    private Button btnLogin;
    private LoginPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialiseVariables();
    }

    private void initialiseVariables() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        presenter = new LoginPresenter(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(R.string.loading));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                presenter.validateCredentials(etEmail.getText().toString().trim(), etPassword.getText().toString().trim());
                break;
        }
    }

    @Override
    public void setEmailEmptyError(@StringRes int resId) {
        etEmail.setError(getString(resId));
    }

    @Override
    public void setPasswordEmptyError(@StringRes int resId) {
        etPassword.setError(getString(resId));
    }

    @Override
    public void showUnsuccessfulLoginError(@StringRes int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void showToastMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void startMoviesActivity() {
       startActivity(new Intent(this, MoviesActivity.class));
    }
}
