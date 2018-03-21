package com.freesoft.android_running_app.beans;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by c026dinab on 3/9/2018.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor()
@Entity(tableName = "CHECKPOINTS")
public class Checkpoint implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CHECKPOINT_ID")
    private Integer id;

    @ColumnInfo(name = "LONGITUDE")
    private double longitude;

    @ColumnInfo(name = "LATITUDE")
    private double latitude;

    public Checkpoint(double longitude, double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

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
