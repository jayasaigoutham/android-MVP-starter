package com.jayasai.starter.Login;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.jayasai.starter.Base.BaseInteractor;


public class LoginInteractor extends BaseInteractor {

    interface OnLoginFinishedListener {
        void ifSuccess();

        void ifUsernameError();

        void ifPasswordError();
    }

    public void login(String username, String Password, final OnLoginFinishedListener listener)
    {
        UserLoginTask mAuthTask = null;
        mAuthTask = new UserLoginTask(username, Password);
        mAuthTask.execute((Void) null);

        listener.ifSuccess();
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            if (TextUtils.isEmpty(mEmail)) {
                return false;
            }
            if (TextUtils.isEmpty(mPassword)) {
                return false;
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

        }

        @Override
        protected void onCancelled() {

        }
    }
}
