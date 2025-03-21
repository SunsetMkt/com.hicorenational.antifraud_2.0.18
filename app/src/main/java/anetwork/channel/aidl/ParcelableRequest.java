package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.InterfaceC0000a;
import p000a.p001a.InterfaceC0006g;
import p000a.p001a.InterfaceC0007h;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ParcelableRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableRequest> CREATOR = new C0888n();

    /* renamed from: a */
    public InterfaceC0007h f1216a;

    /* renamed from: b */
    public BodyEntry f1217b;

    /* renamed from: c */
    public int f1218c;

    /* renamed from: d */
    public String f1219d;

    /* renamed from: e */
    public String f1220e;

    /* renamed from: f */
    public boolean f1221f;

    /* renamed from: g */
    public String f1222g;

    /* renamed from: h */
    public Map<String, String> f1223h;

    /* renamed from: i */
    public Map<String, String> f1224i;

    /* renamed from: j */
    public int f1225j;

    /* renamed from: k */
    public int f1226k;

    /* renamed from: l */
    public String f1227l;

    /* renamed from: m */
    public String f1228m;

    /* renamed from: n */
    public Map<String, String> f1229n;

    public ParcelableRequest(InterfaceC0007h interfaceC0007h) {
        this.f1223h = null;
        this.f1224i = null;
        this.f1216a = interfaceC0007h;
        if (interfaceC0007h != null) {
            this.f1219d = interfaceC0007h.mo26b();
            this.f1218c = interfaceC0007h.mo47k();
            this.f1220e = interfaceC0007h.mo43g();
            this.f1221f = interfaceC0007h.mo44h();
            this.f1222g = interfaceC0007h.mo41f();
            List<InterfaceC0000a> mo16a = interfaceC0007h.mo16a();
            if (mo16a != null) {
                this.f1223h = new HashMap();
                for (InterfaceC0000a interfaceC0000a : mo16a) {
                    this.f1223h.put(interfaceC0000a.getName(), interfaceC0000a.getValue());
                }
            }
            List<InterfaceC0006g> params = interfaceC0007h.getParams();
            if (params != null) {
                this.f1224i = new HashMap();
                for (InterfaceC0006g interfaceC0006g : params) {
                    this.f1224i.put(interfaceC0006g.getKey(), interfaceC0006g.getValue());
                }
            }
            this.f1217b = interfaceC0007h.mo45i();
            this.f1225j = interfaceC0007h.getConnectTimeout();
            this.f1226k = interfaceC0007h.getReadTimeout();
            this.f1227l = interfaceC0007h.mo50n();
            this.f1228m = interfaceC0007h.mo48l();
            this.f1229n = interfaceC0007h.mo36d();
        }
    }

    /* renamed from: a */
    public static ParcelableRequest m759a(Parcel parcel) {
        ParcelableRequest parcelableRequest = new ParcelableRequest();
        try {
            parcelableRequest.f1218c = parcel.readInt();
            parcelableRequest.f1219d = parcel.readString();
            parcelableRequest.f1220e = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            parcelableRequest.f1221f = z;
            parcelableRequest.f1222g = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.f1223h = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            if (parcel.readInt() != 0) {
                parcelableRequest.f1224i = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            parcelableRequest.f1217b = (BodyEntry) parcel.readParcelable(ParcelableRequest.class.getClassLoader());
            parcelableRequest.f1225j = parcel.readInt();
            parcelableRequest.f1226k = parcel.readInt();
            parcelableRequest.f1227l = parcel.readString();
            parcelableRequest.f1228m = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.f1229n = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
        } catch (Throwable th) {
            ALog.m717w("anet.ParcelableRequest", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        InterfaceC0007h interfaceC0007h = this.f1216a;
        if (interfaceC0007h == null) {
            return;
        }
        try {
            parcel.writeInt(interfaceC0007h.mo47k());
            parcel.writeString(this.f1219d);
            parcel.writeString(this.f1216a.mo43g());
            parcel.writeInt(this.f1216a.mo44h() ? 1 : 0);
            parcel.writeString(this.f1216a.mo41f());
            parcel.writeInt(this.f1223h == null ? 0 : 1);
            if (this.f1223h != null) {
                parcel.writeMap(this.f1223h);
            }
            parcel.writeInt(this.f1224i == null ? 0 : 1);
            if (this.f1224i != null) {
                parcel.writeMap(this.f1224i);
            }
            parcel.writeParcelable(this.f1217b, 0);
            parcel.writeInt(this.f1216a.getConnectTimeout());
            parcel.writeInt(this.f1216a.getReadTimeout());
            parcel.writeString(this.f1216a.mo50n());
            parcel.writeString(this.f1216a.mo48l());
            Map<String, String> mo36d = this.f1216a.mo36d();
            parcel.writeInt(mo36d == null ? 0 : 1);
            if (mo36d != null) {
                parcel.writeMap(mo36d);
            }
        } catch (Throwable th) {
            ALog.m717w("anet.ParcelableRequest", "[writeToParcel]", null, th, new Object[0]);
        }
    }

    /* renamed from: a */
    public String m760a(String str) {
        Map<String, String> map = this.f1229n;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public ParcelableRequest() {
        this.f1223h = null;
        this.f1224i = null;
    }
}
