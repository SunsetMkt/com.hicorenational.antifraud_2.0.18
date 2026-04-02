package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class ParcelableHeader implements Parcelable {

    /* JADX INFO: renamed from: c */
    public static Parcelable.Creator<ParcelableHeader> f1678c = new m();
    public int a;

    /* JADX INFO: renamed from: b */
    public Map<String, List<String>> f1679b;

    public ParcelableHeader(int i2, Map<String, List<String>> map) {
        this.f1679b = map;
        this.a = i2;
    }

    public Map<String, List<String>> a() {
        return this.f1679b;
    }

    public int b() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ParcelableResponseHeader [responseCode=" + this.a + ", header=" + this.f1679b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (this.f1679b != null) {
            parcel.writeInt(1);
            parcel.writeMap(this.f1679b);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.a);
    }

    static ParcelableHeader a(Parcel parcel) {
        ParcelableHeader parcelableHeader = new ParcelableHeader();
        try {
            if (parcel.readInt() == 1) {
                parcelableHeader.f1679b = parcel.readHashMap(ParcelableHeader.class.getClassLoader());
            }
            parcelableHeader.a = parcel.readInt();
        } catch (Throwable th) {
            ALog.e("anet.ParcelableHeader", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableHeader;
    }

    ParcelableHeader() {
    }
}
