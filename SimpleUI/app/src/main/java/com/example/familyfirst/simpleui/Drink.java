package com.example.familyfirst.simpleui;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by familyfirst on 8/11/16.
 */
public class Drink implements Parcelable {
    String name;
    int lPrice;
    int mPrice;
    int ImageId;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.lPrice);
        dest.writeInt(this.mPrice);
        dest.writeInt(this.ImageId);
    }

    public Drink() {
    }

    protected Drink(Parcel in) {
        this.name = in.readString();
        this.lPrice = in.readInt();
        this.mPrice = in.readInt();
        this.ImageId = in.readInt();
    }

    public static final Parcelable.Creator<Drink> CREATOR = new Parcelable.Creator<Drink>() {
        @Override
        public Drink createFromParcel(Parcel source) {
            return new Drink(source);
        }

        @Override
        public Drink[] newArray(int size) {
            return new Drink[size];
        }
    };
}
