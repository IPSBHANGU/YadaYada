package com.android.yadayada;

import android.app.ActivityManager;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;

public class DisclaimerReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        SharedPreferences prefs = DisclaimerActivity.getPrefs(context);
        Intent addFlags = new Intent(context, DisclaimerActivity.class).addFlags(268435456);
        if ("com.android.yadayada.SHOW".equals(action) || ("android.intent.action.LOCKED_BOOT_COMPLETED".equals(action) && (!runningOnTv(context) || userSetupComplete(context)))) {
            if (!prefs.getBoolean("shown", false) && !ActivityManager.isRunningInTestHarness() && !ActivityManager.isRunningInUserTestHarness()) {
                context.startActivity(addFlags);
            }
        } else if ("com.android.yadayada.RESET".equals(action)) {
            prefs.edit().remove("shown").apply();
        }
    }

    private static boolean runningOnTv(Context context) {
        return ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4;
    }

    private static boolean userSetupComplete(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "user_setup_complete", 0) != 0;
    }
}

