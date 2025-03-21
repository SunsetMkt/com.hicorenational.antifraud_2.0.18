package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.aidl.InterfaceC0868d;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.b */
/* loaded from: classes.dex */
final class C0890b implements Parcelable.Creator<BodyHandlerEntry> {
    C0890b() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BodyHandlerEntry createFromParcel(Parcel parcel) {
        BodyHandlerEntry bodyHandlerEntry = new BodyHandlerEntry((C0890b) null);
        bodyHandlerEntry.f1320a = InterfaceC0868d.a.m768a(parcel.readStrongBinder());
        return bodyHandlerEntry;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BodyHandlerEntry[] newArray(int i2) {
        return new BodyHandlerEntry[i2];
    }
}
