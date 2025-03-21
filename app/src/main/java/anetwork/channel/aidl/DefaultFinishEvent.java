package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ErrorConstant;
import p000a.p001a.C0004e;
import p000a.p001a.p012s.C0035a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DefaultFinishEvent implements Parcelable, C0004e.a {
    public static final Parcelable.Creator<DefaultFinishEvent> CREATOR = new C0873i();

    /* renamed from: a */
    Object f1192a;

    /* renamed from: b */
    int f1193b;

    /* renamed from: c */
    String f1194c;

    /* renamed from: d */
    C0035a f1195d;

    /* renamed from: e */
    public final RequestStatistic f1196e;

    /* renamed from: f */
    public final Request f1197f;

    public DefaultFinishEvent(int i2) {
        this(i2, null, null, null);
    }

    /* renamed from: a */
    public Object m742a() {
        return this.f1192a;
    }

    @Override // p000a.p001a.C0004e.a
    /* renamed from: d */
    public String mo8d() {
        return this.f1194c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // p000a.p001a.C0004e.a
    /* renamed from: e */
    public C0035a mo9e() {
        return this.f1195d;
    }

    @Override // p000a.p001a.C0004e.a
    /* renamed from: f */
    public int mo10f() {
        return this.f1193b;
    }

    public String toString() {
        return "DefaultFinishEvent [code=" + this.f1193b + ", desc=" + this.f1194c + ", context=" + this.f1192a + ", statisticData=" + this.f1195d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1193b);
        parcel.writeString(this.f1194c);
        C0035a c0035a = this.f1195d;
        if (c0035a != null) {
            parcel.writeSerializable(c0035a);
        }
    }

    public DefaultFinishEvent(int i2, String str, RequestStatistic requestStatistic) {
        this(i2, str, null, requestStatistic);
    }

    /* renamed from: a */
    public void m743a(Object obj) {
        this.f1192a = obj;
    }

    public DefaultFinishEvent(int i2, String str, Request request) {
        this(i2, str, request, request != null ? request.f916a : null);
    }

    /* renamed from: a */
    static DefaultFinishEvent m741a(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent(0);
        try {
            defaultFinishEvent.f1193b = parcel.readInt();
            defaultFinishEvent.f1194c = parcel.readString();
            defaultFinishEvent.f1195d = (C0035a) parcel.readSerializable();
        } catch (Throwable unused) {
        }
        return defaultFinishEvent;
    }

    private DefaultFinishEvent(int i2, String str, Request request, RequestStatistic requestStatistic) {
        this.f1195d = new C0035a();
        this.f1193b = i2;
        this.f1194c = str == null ? ErrorConstant.getErrMsg(i2) : str;
        this.f1197f = request;
        this.f1196e = requestStatistic;
    }
}
