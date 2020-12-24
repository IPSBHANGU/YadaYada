package com.android.yadayada;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

public class DisclaimerActivity extends Activity {
    private static final String TAG = DisclaimerActivity.class.getSimpleName();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(524288);
        Log.v(TAG, "Disclaimer was shown to user");
        setContentView(R.layout.main);
    }

    public void onResume() {
        super.onResume();
        View findViewById = findViewById(R.id.feedback_button);
        if (findViewById != null) {
            int i = 0;
            if (!(Settings.Secure.getInt(getContentResolver(), "user_setup_complete", 0) != 0)) {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
    }

    public void okClicked(View view) {
        finish();
    }

    public void feedbackClicked(View view) {
        Utils.sendFeedback(this);
        finish();
    }

    static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("prefs", 0);
    }

    public void onStop() {
        super.onStop();
        if (getResources().getBoolean(R.bool.show_only_once)) {
            SharedPreferences.Editor edit = getPrefs(this).edit();
            edit.putBoolean("shown", true);
            edit.apply();
        }
    }
}
