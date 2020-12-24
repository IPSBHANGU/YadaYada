package com.android.yadayada;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Utils {
    public static void sendFeedback(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(new ComponentName("com.google.android.apps.betterbug", "com.google.android.apps.betterbug.bugslist.BugsListActivity"));
        intent.setFlags(268435456);
        if (!context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            context.startActivity(intent);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(":settings:fragment_args_key", "device_feedback");
        context.startActivity(new Intent("android.settings.DEVICE_INFO_SETTINGS").addCategory("android.intent.category.DEFAULT").addFlags(335544320).putExtra(":settings:show_fragment_args", bundle));
    }
}

