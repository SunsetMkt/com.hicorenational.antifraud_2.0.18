package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ParcelableHeader implements Parcelable {

    /* renamed from: c */
    public static Parcelable.Creator<ParcelableHeader> f1213c = new C0887m();

    /* renamed from: a */
    public int f1214a;

    /* renamed from: b */
    public Map<String, List<String>> f1215b;

    public ParcelableHeader(int i2, Map<String, List<String>> map) {
        this.f1215b = map;
        this.f1214a = i2;
    }

    /* renamed from: a */
    public Map<String, List<String>> m757a() {
        return this.f1215b;
    }

    /* renamed from: b */
    public int m758b() {
        return this.f1214a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ParcelableResponseHeader [responseCode=" + this.f1214a + ", header=" + this.f1215b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (this.f1215b != null) {
            parcel.writeInt(1);
            parcel.writeMap(this.f1215b);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f1214a);
    }

    /* renamed from: a */
    static ParcelableHeader m756a(Parcel parcel) {
        ParcelableHeader parcelableHeader = new ParcelableHeader();
        try {
            if (parcel.readInt() == 1) {
                parcelableHeader.f1215b = parcel.readHashMap(ParcelableHeader.class.getClassLoader());
            }
            parcelableHeader.f1214a = parcel.readInt();
        } catch (Throwable th) {
            ALog.m714e("anet.ParcelableHeader", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableHeader;
    }

    ParcelableHeader() {
    }
}
