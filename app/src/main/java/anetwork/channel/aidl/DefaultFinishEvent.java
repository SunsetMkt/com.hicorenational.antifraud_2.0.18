package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ErrorConstant;
import b.a.e;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class DefaultFinishEvent implements Parcelable, e.a {
    public static final Parcelable.Creator<DefaultFinishEvent> CREATOR = new i();
    Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f1662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b.a.s.a f1663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RequestStatistic f1664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Request f1665f;

    public DefaultFinishEvent(int i2) {
        this(i2, null, null, null);
    }

    public Object a() {
        return this.a;
    }

    @Override // b.a.e.a
    public String d() {
        return this.f1662c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // b.a.e.a
    public b.a.s.a e() {
        return this.f1663d;
    }

    @Override // b.a.e.a
    public int f() {
        return this.f1661b;
    }

    public String toString() {
        return "DefaultFinishEvent [code=" + this.f1661b + ", desc=" + this.f1662c + ", context=" + this.a + ", statisticData=" + this.f1663d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1661b);
        parcel.writeString(this.f1662c);
        b.a.s.a aVar = this.f1663d;
        if (aVar != null) {
            parcel.writeSerializable(aVar);
        }
    }

    public DefaultFinishEvent(int i2, String str, RequestStatistic requestStatistic) {
        this(i2, str, null, requestStatistic);
    }

    public void a(Object obj) {
        this.a = obj;
    }

    public DefaultFinishEvent(int i2, String str, Request request) {
        this(i2, str, request, request != null ? request.a : null);
    }

    static DefaultFinishEvent a(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent(0);
        try {
            defaultFinishEvent.f1661b = parcel.readInt();
            defaultFinishEvent.f1662c = parcel.readString();
            defaultFinishEvent.f1663d = (b.a.s.a) parcel.readSerializable();
        } catch (Throwable unused) {
        }
        return defaultFinishEvent;
    }

    private DefaultFinishEvent(int i2, String str, Request request, RequestStatistic requestStatistic) {
        this.f1663d = new b.a.s.a();
        this.f1661b = i2;
        this.f1662c = str == null ? ErrorConstant.getErrMsg(i2) : str;
        this.f1665f = request;
        this.f1664e = requestStatistic;
    }
}
