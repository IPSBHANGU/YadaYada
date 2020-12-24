package com.android.yadayada;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class DisclaimerTile extends TileService {
    /* renamed from: L */
    public static final void m0L(String str, Object... objArr) {
    }

    static {
        Class<DisclaimerTile> cls = DisclaimerTile.class;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onTileAdded() {
        m0L("onTileAdded", new Object[0]);
    }

    public void onStartListening() {
        m0L("onStartListening", new Object[0]);
        Tile qsTile = getQsTile();
        qsTile.setLabel(getString(R.string.tile_label));
        qsTile.setSubtitle(Build.ID);
        qsTile.setIcon(Icon.createWithResource(this, R.drawable.tile_icon));
        qsTile.updateTile();
    }

    public void onStopListening() {
        m0L("onStopListening", new Object[0]);
    }

    public void onClick() {
        startActivityAndCollapse(new Intent(this, DisclaimerActivity.class).addFlags(335544320));
    }
}

