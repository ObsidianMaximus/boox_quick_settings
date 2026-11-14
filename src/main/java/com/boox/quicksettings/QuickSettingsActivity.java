package com.boox.quicksettings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class QuickSettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!QuickSettingsService.swipeDown()) {
            Toast.makeText(this, "Enable Quick Settings in Accessibility", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        }

        finishAndRemoveTask();
        overridePendingTransition(0, 0);
    }
}
