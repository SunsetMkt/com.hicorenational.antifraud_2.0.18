package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.m */
/* loaded from: classes.dex */
final class C0887m implements Parcelable.Creator<ParcelableHeader> {
    C0887m() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableHeader createFromParcel(Parcel parcel) {
        return ParcelableHeader.m756a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableHeader[] newArray(int i2) {
        return new ParcelableHeader[i2];
    }
}
