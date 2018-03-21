package com.freesoft.android_running_app.services;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

import com.freesoft.android_running_app.activities.AddNewRouteActivity;
import com.freesoft.android_running_app.beans.Checkpoint;
import com.freesoft.android_running_app.beans.Route;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationService extends Service {

    private static final int INTERVAL = 10000;
    private static final int FASTEST_INTERVAL = 5000;

    private FusedLocationProviderClient locationProviderClient;
    private LocationRequest locationRequest;
    private List<Checkpoint> checkpoints = new ArrayList<>();
    private Route route = null;

    public LocationService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        locationRequest = new LocationRequest();
        locationRequest.setInterval(INTERVAL);
        locationRequest.setFastestInterval(FASTEST_INTERVAL);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        PackageManager packageManager = getApplication().getPackageManager();
        int hasPermission = packageManager.checkPermission(Manifest.permission.ACCESS_FINE_LOCATION,
                getApplication().getPackageName());
        if (hasPermission == PackageManager.PERMISSION_GRANTED) {
            locationProviderClient.requestLocationUpdates(locationRequest, locationCallBack, null);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        route = (Route) intent.getSerializableExtra("ROUTE");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        locationProviderClient.removeLocationUpdates(locationCallBack);
        route.setCheckpointsList(checkpoints);
        route.setStopDate(new Date().toString());
        Intent intent = new Intent("RETURN_ROUTE");
        intent.putExtra("COMPLETED_ROUTE", route);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    LocationCallback locationCallBack = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            Location location = locationResult.getLastLocation();
            Checkpoint checkpoint = new Checkpoint(location.getLongitude(), location.getLatitude());
            checkpoints.add(checkpoint);

        }
    };
}
