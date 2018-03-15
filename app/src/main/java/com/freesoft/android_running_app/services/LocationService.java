package com.freesoft.android_running_app.services;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.freesoft.android_running_app.beans.Checkpoint;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class LocationService extends Service {

    private static final int INTERVAL = 10000;
    private static final int FASTEST_INTERVAL = 5000;

    private FusedLocationProviderClient locationProviderClient;
    private LocationRequest locationRequest;

    public LocationService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        locationRequest= new LocationRequest();
        locationRequest.setInterval(INTERVAL);
        locationRequest.setFastestInterval(FASTEST_INTERVAL);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //if(ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION")==1){
            locationProviderClient.requestLocationUpdates(locationRequest, locationCallBack, null);
        //}
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        locationProviderClient.removeLocationUpdates(locationCallBack);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return null;
    }

    LocationCallback locationCallBack = new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            Location location = locationResult.getLastLocation();
            Checkpoint checkpoint = new Checkpoint(location.getLongitude(), location.getLatitude());
            Log.i("###Punct", checkpoint.toString());
        }
    };
}
