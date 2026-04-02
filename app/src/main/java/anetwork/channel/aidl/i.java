package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class i implements Parcelable.Creator<DefaultFinishEvent> {
    i() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a */
    public DefaultFinishEvent createFromParcel(Parcel parcel) {
        return DefaultFinishEvent.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a */
    public DefaultFinishEvent[] newArray(int i2) {
        return new DefaultFinishEvent[i2];
    }
}
