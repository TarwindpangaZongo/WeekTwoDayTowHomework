package com.example.weektwodaytowhomework;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    String carMake;
    String carModel;
    String carYear;
    String carTitleStatus;
    String carColor;
    String carEngine;
    String carTransmission;

    public Car(String carMake, String carModel, String carYear, String carTitleStatus, String carColor, String carEngine, String carTransmission) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carTitleStatus = carTitleStatus;
        this.carColor = carColor;
        this.carEngine = carEngine;
        this.carTransmission = carTransmission;
    }

    protected Car(Parcel in) {
        carMake = in.readString();
        carModel = in.readString();
        carYear = in.readString();
        carTitleStatus = in.readString();
        carColor = in.readString();
        carEngine = in.readString();
        carTransmission = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(carMake);
        dest.writeString(carModel);
        dest.writeString(carYear);
        dest.writeString(carTitleStatus);
        dest.writeString(carColor);
        dest.writeString(carEngine);
        dest.writeString(carTransmission);
    }
}
