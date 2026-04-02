package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class Scope implements Parcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new a();
    private String a;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public Scope createFromParcel(Parcel parcel) {
            return new Scope(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Scope[] newArray(int i2) {
            return new Scope[i2];
        }
    }

    public Scope() {
        this.a = null;
    }

    public String a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Scope)) {
            return false;
        }
        return ((Scope) obj).a.equals(this.a);
    }

    public final int hashCode() {
        String str = this.a;
        return str == null ? super.hashCode() : str.hashCode();
    }

    public final String toString() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
    }

    public Scope(String str) {
        this.a = str;
    }

    protected Scope(Parcel parcel) {
        this.a = parcel.readString();
    }
}
