package com.tracker.data.tracker;

public enum TrackingState {
    TRACKING,
    NOT_TRACKING;

    public boolean isTracking() {
        return this == TRACKING;
    }
}
