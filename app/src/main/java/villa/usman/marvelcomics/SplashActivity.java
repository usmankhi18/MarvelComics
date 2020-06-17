package villa.usman.marvelcomics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import villa.usman.marvelcomics.common.Constants;

public class SplashActivity extends Activity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences = getSharedPreferences(Constants.ProfilePREFERENCES, Context.MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPreferences.contains("UserID")) {
                        goToDashboard();
                } else {
                    goToLoginActivity();
                }
                finish();
            }
        }, Constants.DELAY_LENGTH);
    }

    private void goToDashboard() {
        Intent dashboardIntent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(dashboardIntent);
    }

    private void goToLoginActivity() {
        Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(mainIntent);
    }
}