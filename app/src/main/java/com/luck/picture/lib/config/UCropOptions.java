package com.luck.picture.lib.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.yalantis.ucrop.UCrop;

/* JADX INFO: loaded from: classes2.dex */
public class UCropOptions extends UCrop.Options implements Parcelable {
    public static final Parcelable.Creator<UCropOptions> CREATOR = new Parcelable.Creator<UCropOptions>() { // from class: com.luck.picture.lib.config.UCropOptions.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public UCropOptions createFromParcel(Parcel parcel) {
            return new UCropOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UCropOptions[] newArray(int i2) {
            return new UCropOptions[i2];
        }
    };

    /* JADX INFO: renamed from: com.luck.picture.lib.config.UCropOptions$1 */
    static class AnonymousClass1 implements Parcelable.Creator<UCropOptions> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public UCropOptions createFromParcel(Parcel parcel) {
            return new UCropOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UCropOptions[] newArray(int i2) {
            return new UCropOptions[i2];
        }
    }

    public UCropOptions() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
    }

    protected UCropOptions(Parcel parcel) {
    }
}
