package com.boox.quicksettings;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.util.DisplayMetrics;
import android.view.accessibility.AccessibilityEvent;

public class QuickSettingsService extends AccessibilityService {
    private static QuickSettingsService instance;

    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
        instance = this;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {}

    @Override
    public void onInterrupt() {}

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    public static boolean swipeDown() {
        if (instance == null) return false;

        DisplayMetrics metrics = instance.getResources().getDisplayMetrics();
        float x = metrics.widthPixels * 0.75f;

        Path swipePath = new Path();
        swipePath.moveTo(x, 1f);
        swipePath.lineTo(x, 300f);

        GestureDescription.StrokeDescription stroke =
                new GestureDescription.StrokeDescription(swipePath, 0, 60);
        GestureDescription gesture = new GestureDescription.Builder()
                .addStroke(stroke)
                .build();

        return instance.dispatchGesture(gesture, null, null);
    }
}
