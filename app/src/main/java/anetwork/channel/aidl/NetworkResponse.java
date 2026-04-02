package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse implements Parcelable, b.a.i {
    public static final Parcelable.Creator<NetworkResponse> CREATOR = new l();
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    byte[] f1671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, List<String>> f1672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Throwable f1673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b.a.s.a f1674f;

    public NetworkResponse() {
    }

    public void a(int i2) {
        this.a = i2;
        this.f1670b = ErrorConstant.getErrMsg(i2);
    }

    @Override // b.a.i
    public String d() {
        return this.f1670b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // b.a.i
    public b.a.s.a e() {
        return this.f1674f;
    }

    @Override // b.a.i
    public Map<String, List<String>> f() {
        return this.f1672d;
    }

    @Override // b.a.i
    public Throwable g() {
        return this.f1673e;
    }

    @Override // b.a.i
    public int getStatusCode() {
        return this.a;
    }

    @Override // b.a.i
    public byte[] n() {
        return this.f1671c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkResponse [");
        sb.append("statusCode=");
        sb.append(this.a);
        sb.append(", desc=");
        sb.append(this.f1670b);
        sb.append(", connHeadFields=");
        sb.append(this.f1672d);
        sb.append(", bytedata=");
        byte[] bArr = this.f1671c;
        sb.append(bArr != null ? new String(bArr) : "");
        sb.append(", error=");
        sb.append(this.f1673e);
        sb.append(", statisticData=");
        sb.append(this.f1674f);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeString(this.f1670b);
        byte[] bArr = this.f1671c;
        int length = bArr != null ? bArr.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.f1671c);
        }
        parcel.writeMap(this.f1672d);
        b.a.s.a aVar = this.f1674f;
        if (aVar != null) {
            parcel.writeSerializable(aVar);
        }
    }

    public NetworkResponse(int i2) {
        this.a = i2;
        this.f1670b = ErrorConstant.getErrMsg(i2);
    }

    public void a(byte[] bArr) {
        this.f1671c = bArr;
    }

    public void a(Map<String, List<String>> map) {
        this.f1672d = map;
    }

    public void a(String str) {
        this.f1670b = str;
    }

    public void a(Throwable th) {
        this.f1673e = th;
    }

    public static NetworkResponse a(Parcel parcel) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            networkResponse.a = parcel.readInt();
            networkResponse.f1670b = parcel.readString();
            int i2 = parcel.readInt();
            if (i2 > 0) {
                networkResponse.f1671c = new byte[i2];
                parcel.readByteArray(networkResponse.f1671c);
            }
            networkResponse.f1672d = parcel.readHashMap(NetworkResponse.class.getClassLoader());
            try {
                networkResponse.f1674f = (b.a.s.a) parcel.readSerializable();
            } catch (Throwable unused) {
                ALog.i("anet.NetworkResponse", "[readFromParcel] source.readSerializable() error", null, new Object[0]);
            }
        } catch (Exception e2) {
            ALog.w("anet.NetworkResponse", "[readFromParcel]", null, e2, new Object[0]);
        }
        return networkResponse;
    }

    public void a(b.a.s.a aVar) {
        this.f1674f = aVar;
    }
}
