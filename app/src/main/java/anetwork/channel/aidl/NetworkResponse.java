package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import java.util.List;
import java.util.Map;
import p000a.p001a.InterfaceC0008i;
import p000a.p001a.p012s.C0035a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkResponse implements Parcelable, InterfaceC0008i {
    public static final Parcelable.Creator<NetworkResponse> CREATOR = new C0886l();

    /* renamed from: a */
    int f1203a;

    /* renamed from: b */
    private String f1204b;

    /* renamed from: c */
    byte[] f1205c;

    /* renamed from: d */
    private Map<String, List<String>> f1206d;

    /* renamed from: e */
    private Throwable f1207e;

    /* renamed from: f */
    private C0035a f1208f;

    public NetworkResponse() {
    }

    /* renamed from: a */
    public void m748a(int i2) {
        this.f1203a = i2;
        this.f1204b = ErrorConstant.getErrMsg(i2);
    }

    @Override // p000a.p001a.InterfaceC0008i
    /* renamed from: d */
    public String mo51d() {
        return this.f1204b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // p000a.p001a.InterfaceC0008i
    /* renamed from: e */
    public C0035a mo52e() {
        return this.f1208f;
    }

    @Override // p000a.p001a.InterfaceC0008i
    /* renamed from: f */
    public Map<String, List<String>> mo53f() {
        return this.f1206d;
    }

    @Override // p000a.p001a.InterfaceC0008i
    /* renamed from: g */
    public Throwable mo54g() {
        return this.f1207e;
    }

    @Override // p000a.p001a.InterfaceC0008i
    public int getStatusCode() {
        return this.f1203a;
    }

    @Override // p000a.p001a.InterfaceC0008i
    /* renamed from: n */
    public byte[] mo55n() {
        return this.f1205c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkResponse [");
        sb.append("statusCode=");
        sb.append(this.f1203a);
        sb.append(", desc=");
        sb.append(this.f1204b);
        sb.append(", connHeadFields=");
        sb.append(this.f1206d);
        sb.append(", bytedata=");
        byte[] bArr = this.f1205c;
        sb.append(bArr != null ? new String(bArr) : "");
        sb.append(", error=");
        sb.append(this.f1207e);
        sb.append(", statisticData=");
        sb.append(this.f1208f);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1203a);
        parcel.writeString(this.f1204b);
        byte[] bArr = this.f1205c;
        int length = bArr != null ? bArr.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.f1205c);
        }
        parcel.writeMap(this.f1206d);
        C0035a c0035a = this.f1208f;
        if (c0035a != null) {
            parcel.writeSerializable(c0035a);
        }
    }

    public NetworkResponse(int i2) {
        this.f1203a = i2;
        this.f1204b = ErrorConstant.getErrMsg(i2);
    }

    /* renamed from: a */
    public void m753a(byte[] bArr) {
        this.f1205c = bArr;
    }

    /* renamed from: a */
    public void m752a(Map<String, List<String>> map) {
        this.f1206d = map;
    }

    /* renamed from: a */
    public void m750a(String str) {
        this.f1204b = str;
    }

    /* renamed from: a */
    public void m751a(Throwable th) {
        this.f1207e = th;
    }

    /* renamed from: a */
    public static NetworkResponse m747a(Parcel parcel) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            networkResponse.f1203a = parcel.readInt();
            networkResponse.f1204b = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                networkResponse.f1205c = new byte[readInt];
                parcel.readByteArray(networkResponse.f1205c);
            }
            networkResponse.f1206d = parcel.readHashMap(NetworkResponse.class.getClassLoader());
            try {
                networkResponse.f1208f = (C0035a) parcel.readSerializable();
            } catch (Throwable unused) {
                ALog.m716i("anet.NetworkResponse", "[readFromParcel] source.readSerializable() error", null, new Object[0]);
            }
        } catch (Exception e2) {
            ALog.m717w("anet.NetworkResponse", "[readFromParcel]", null, e2, new Object[0]);
        }
        return networkResponse;
    }

    /* renamed from: a */
    public void m749a(C0035a c0035a) {
        this.f1208f = c0035a;
    }
}
