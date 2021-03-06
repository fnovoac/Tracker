package com.tracker.ui.tracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import static com.tracker.ui.util.Constants.ACTION.START_TRACKER_ACTION;
import static com.tracker.ui.util.Constants.ACTION.START_TRACKER_ACTION_FOREGROUND;
import static com.tracker.ui.util.Constants.ACTION.STOP_TRACKER_ACTION;
import static com.tracker.ui.util.Constants.ACTION.STOP_TRACKER_ACTION_FOREGROUND;
import static com.tracker.utils.ActivityUtils.isServiceRunning;

public class ReactiveGpsLocationProvider implements LocationProvider {
    private final Context context;

    public ReactiveGpsLocationProvider(@NonNull final Context context) {
        this.context = context;
    }

    @Override
    public void startService() {
        if (!isServiceRunning(context, TrackerService.class))
            context.startService(serviceIntent().setAction(START_TRACKER_ACTION));
    }

    @Override
    public void showTrackingForeground() {
        context.startService(serviceIntent().setAction(START_TRACKER_ACTION_FOREGROUND));
    }

    @Override
    public void stopService() {
        context.startService(serviceIntent().setAction(STOP_TRACKER_ACTION));
    }

    @Override
    public void hideTrackingForeground() {
        context.startService(serviceIntent().setAction(STOP_TRACKER_ACTION_FOREGROUND));
    }

    @NonNull
    private Intent serviceIntent() {
        return new Intent(context, TrackerService.class);
    }
}
