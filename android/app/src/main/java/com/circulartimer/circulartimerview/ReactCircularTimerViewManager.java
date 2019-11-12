package com.circulartimer.circulartimerview;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import java.util.Map;

public class ReactCircularTimerViewManager extends SimpleViewManager<CircularTimerView> {

    public static final String REACT_CLASS = "CircularTimerView";
    private ThemedReactContext mContext;
    private CircularTimerView view;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected CircularTimerView createViewInstance(@NonNull ThemedReactContext reactContext) {
        mContext = reactContext;
        view = new CircularTimerView(reactContext);
        view.setProgress(0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.onPress();
            }
        });

        view.setCircularTimerListener(new CircularTimerListener() {
            @Override
            public String updateDataOnTick(long remainingTimeInMs) {

                String updatedData = String.valueOf((int)Math.ceil((remainingTimeInMs / 1000.f)));
                return updatedData;
            }

            @Override
            public void onTimerFinished() {
                view.onTimerFinished();

            }
        }, 10, TimeFormatEnum.SECONDS, 10);

        return view;
    }

    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put(
                        "onPress",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onPress")))
                .put(
                        "onTimerFinished",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onTimerFinished")))
                .build();
    }
}