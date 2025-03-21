package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.k */
/* loaded from: classes.dex */
final class C0885k implements Parcelable.Creator<DefaultProgressEvent> {
    C0885k() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultProgressEvent createFromParcel(Parcel parcel) {
        return DefaultProgressEvent.m744a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultProgressEvent[] newArray(int i2) {
        return new DefaultProgressEvent[i2];
    }
}
