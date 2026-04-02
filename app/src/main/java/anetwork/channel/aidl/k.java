package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class k implements Parcelable.Creator<DefaultProgressEvent> {
    k() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a */
    public DefaultProgressEvent createFromParcel(Parcel parcel) {
        return DefaultProgressEvent.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a */
    public DefaultProgressEvent[] newArray(int i2) {
        return new DefaultProgressEvent[i2];
    }
}
