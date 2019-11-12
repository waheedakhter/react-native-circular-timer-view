package com.circulartimer.circulartimerview;

public interface CircularTimerListener {
    String updateDataOnTick(long remainingTimeInMs);
    void onTimerFinished();
}
