package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Scope implements Parcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new C2137a();

    /* renamed from: a */
    private String f6394a;

    /* renamed from: com.hihonor.cloudservice.support.api.entity.auth.Scope$a */
    class C2137a implements Parcelable.Creator {
        C2137a() {
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
        this.f6394a = null;
    }

    /* renamed from: a */
    public String m6019a() {
        return this.f6394a;
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
        return ((Scope) obj).f6394a.equals(this.f6394a);
    }

    public final int hashCode() {
        String str = this.f6394a;
        return str == null ? super.hashCode() : str.hashCode();
    }

    public final String toString() {
        return this.f6394a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6394a);
    }

    public Scope(String str) {
        this.f6394a = str;
    }

    protected Scope(Parcel parcel) {
        this.f6394a = parcel.readString();
    }
}
