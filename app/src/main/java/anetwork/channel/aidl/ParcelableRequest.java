package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class ParcelableRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableRequest> CREATOR = new n();
    public b.a.h a;

    /* JADX INFO: renamed from: b */
    public BodyEntry f1680b;

    /* JADX INFO: renamed from: c */
    public int f1681c;

    /* JADX INFO: renamed from: d */
    public String f1682d;

    /* JADX INFO: renamed from: e */
    public String f1683e;

    /* JADX INFO: renamed from: f */
    public boolean f1684f;

    /* JADX INFO: renamed from: g */
    public String f1685g;

    /* JADX INFO: renamed from: h */
    public Map<String, String> f1686h;

    /* JADX INFO: renamed from: i */
    public Map<String, String> f1687i;

    /* JADX INFO: renamed from: j */
    public int f1688j;

    /* JADX INFO: renamed from: k */
    public int f1689k;

    /* JADX INFO: renamed from: l */
    public String f1690l;

    /* JADX INFO: renamed from: m */
    public String f1691m;

    /* JADX INFO: renamed from: n */
    public Map<String, String> f1692n;

    public ParcelableRequest(b.a.h hVar) {
        this.f1686h = null;
        this.f1687i = null;
        this.a = hVar;
        if (hVar != null) {
            this.f1682d = hVar.b();
            this.f1681c = hVar.k();
            this.f1683e = hVar.g();
            this.f1684f = hVar.h();
            this.f1685g = hVar.f();
            List<b.a.a> listA = hVar.a();
            if (listA != null) {
                this.f1686h = new HashMap();
                for (b.a.a aVar : listA) {
                    this.f1686h.put(aVar.getName(), aVar.getValue());
                }
            }
            List<b.a.g> params = hVar.getParams();
            if (params != null) {
                this.f1687i = new HashMap();
                for (b.a.g gVar : params) {
                    this.f1687i.put(gVar.getKey(), gVar.getValue());
                }
            }
            this.f1680b = hVar.i();
            this.f1688j = hVar.getConnectTimeout();
            this.f1689k = hVar.getReadTimeout();
            this.f1690l = hVar.n();
            this.f1691m = hVar.l();
            this.f1692n = hVar.d();
        }
    }

    public static ParcelableRequest a(Parcel parcel) {
        ParcelableRequest parcelableRequest = new ParcelableRequest();
        try {
            parcelableRequest.f1681c = parcel.readInt();
            parcelableRequest.f1682d = parcel.readString();
            parcelableRequest.f1683e = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            parcelableRequest.f1684f = z;
            parcelableRequest.f1685g = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.f1686h = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            if (parcel.readInt() != 0) {
                parcelableRequest.f1687i = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            parcelableRequest.f1680b = (BodyEntry) parcel.readParcelable(ParcelableRequest.class.getClassLoader());
            parcelableRequest.f1688j = parcel.readInt();
            parcelableRequest.f1689k = parcel.readInt();
            parcelableRequest.f1690l = parcel.readString();
            parcelableRequest.f1691m = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.f1692n = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
        } catch (Throwable th) {
            ALog.w("anet.ParcelableRequest", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        b.a.h hVar = this.a;
        if (hVar == null) {
            return;
        }
        try {
            parcel.writeInt(hVar.k());
            parcel.writeString(this.f1682d);
            parcel.writeString(this.a.g());
            parcel.writeInt(this.a.h() ? 1 : 0);
            parcel.writeString(this.a.f());
            parcel.writeInt(this.f1686h == null ? 0 : 1);
            if (this.f1686h != null) {
                parcel.writeMap(this.f1686h);
            }
            parcel.writeInt(this.f1687i == null ? 0 : 1);
            if (this.f1687i != null) {
                parcel.writeMap(this.f1687i);
            }
            parcel.writeParcelable(this.f1680b, 0);
            parcel.writeInt(this.a.getConnectTimeout());
            parcel.writeInt(this.a.getReadTimeout());
            parcel.writeString(this.a.n());
            parcel.writeString(this.a.l());
            Map<String, String> mapD = this.a.d();
            parcel.writeInt(mapD == null ? 0 : 1);
            if (mapD != null) {
                parcel.writeMap(mapD);
            }
        } catch (Throwable th) {
            ALog.w("anet.ParcelableRequest", "[writeToParcel]", null, th, new Object[0]);
        }
    }

    public String a(String str) {
        Map<String, String> map = this.f1692n;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public ParcelableRequest() {
        this.f1686h = null;
        this.f1687i = null;
    }
}
