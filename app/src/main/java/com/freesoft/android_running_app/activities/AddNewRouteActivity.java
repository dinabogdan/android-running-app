package com.freesoft.android_running_app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.freesoft.android_running_app.R;
import com.freesoft.android_running_app.beans.Checkpoint;
import com.freesoft.android_running_app.beans.Route;

import java.util.List;

/**
 * Created by c026dinab on 3/10/2018.
 */

public class AddNewRouteActivity extends AppCompatActivity {

    private TextInputEditText tietRouteName;
    private Button btnStart;
    private Button btnStop;
    private Route route;
    private List<Checkpoint> checkpointList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_route);

        tietRouteName = findViewById(R.id.tiet_routeName);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String REGEX = "^[a-zA-Z ]+$";
                route = new Route();
                if (tietRouteName.getText() == null || tietRouteName.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.route_name_not_complete_errorMsg, Toast.LENGTH_SHORT).show();
                } else if (!tietRouteName.getText().toString().matches(REGEX)) {
                    Toast.makeText(getApplicationContext(), R.string.route_name_invalid_errorMsg, Toast.LENGTH_SHORT).show();
                } else {
                    route.setRouteName(tietRouteName.getText().toString());
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
