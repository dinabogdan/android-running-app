package com.freesoft.android_running_app.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by c026dinab on 3/9/2018.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Checkpoint implements Parcelable {
    private double longitude;
    private double latitude;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
    }

    public static final Parcelable.Creator<Checkpoint> CREATOR = new Parcelable.Creator<Checkpoint>() {

        @Override
        public Checkpoint createFromParcel(Parcel in) {
            return new Checkpoint(in);
        }

        @Override
        public Checkpoint[] newArray(int size) {
            return new Checkpoint[size];
        }

    };

    private Checkpoint(Parcel in) {
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
    }
}
