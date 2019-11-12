package com.circulartimer;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.circulartimer.circulartimerview.CircularTimerListener;
import com.circulartimer.circulartimerview.CircularTimerView;
import com.circulartimer.circulartimerview.TimeFormatEnum;

public class TestActivity extends Activity {

    Button btnReset;
    CircularTimerView progressBar;
    LinearLayout rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        btnReset = findViewById(R.id.btnRestart);
//        progressBar = findViewById(R.id.progress_circular);
//        progressBar.setProgress(0);
        rootLayout = findViewById(R.id.rootLayout);

        progressBar = new CircularTimerView(getBaseContext());
        rootLayout.addView(progressBar);




        progressBar.setCircularTimerListener(new CircularTimerListener() {
            @Override
            public String updateDataOnTick(long remainingTimeInMs) {
                return String.valueOf((int)Math.ceil((remainingTimeInMs / 1000.f)));
            }

            @Override
            public void onTimerFinished() {
                Toast.makeText(TestActivity.this, "FINISHED", Toast.LENGTH_SHORT).show();
                progressBar.setPrefix("");
                progressBar.setSuffix("");
                progressBar.setText("FINISHED THANKS!");
            }
        }, 10, TimeFormatEnum.SECONDS, 10);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setProgress(0);
                progressBar.startTimer();
            }
        });
    }
}
