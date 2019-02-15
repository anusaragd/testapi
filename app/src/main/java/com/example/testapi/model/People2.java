package com.example.testapi.model;

import android.os.Parcel;
import android.os.Parcelable;

public class People2 implements Parcelable {

    private int age;
    private String name;

    public People2() {

    }

    protected People2(Parcel in) {
        age = in.readInt();
        name = in.readString();
    }

    public static final Creator<People2> CREATOR = new Creator<People2>() {
        @Override
        public People2 createFromParcel(Parcel in) {
            return new People2(in);
        }

        @Override
        public People2[] newArray(int size) {
            return new People2[size];
        }
    };

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }
}
