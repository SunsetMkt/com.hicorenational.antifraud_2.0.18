package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.n */
/* loaded from: classes.dex */
final class C0888n implements Parcelable.Creator<ParcelableRequest> {
    C0888n() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableRequest createFromParcel(Parcel parcel) {
        return ParcelableRequest.m759a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableRequest[] newArray(int i2) {
        return new ParcelableRequest[i2];
    }
}
