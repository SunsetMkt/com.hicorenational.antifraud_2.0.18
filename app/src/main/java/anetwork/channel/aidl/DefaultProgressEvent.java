package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import p000a.p001a.C0004e;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DefaultProgressEvent implements Parcelable, C0004e.b {
    public static final Parcelable.Creator<DefaultProgressEvent> CREATOR = new C0885k();

    /* renamed from: a */
    int f1198a;

    /* renamed from: b */
    int f1199b;

    /* renamed from: c */
    int f1200c;

    /* renamed from: d */
    Object f1201d;

    /* renamed from: e */
    byte[] f1202e;

    public DefaultProgressEvent() {
    }

    @Override // p000a.p001a.C0004e.b
    /* renamed from: a */
    public int mo11a() {
        return this.f1199b;
    }

    /* renamed from: b */
    public Object m746b() {
        return this.f1201d;
    }

    @Override // p000a.p001a.C0004e.b
    /* renamed from: d */
    public String mo12d() {
        return "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // p000a.p001a.C0004e.b
    /* renamed from: m */
    public int mo13m() {
        return this.f1198a;
    }

    @Override // p000a.p001a.C0004e.b
    /* renamed from: n */
    public byte[] mo14n() {
        return this.f1202e;
    }

    @Override // p000a.p001a.C0004e.b
    /* renamed from: o */
    public int mo15o() {
        return this.f1200c;
    }

    public String toString() {
        return "DefaultProgressEvent [index=" + this.f1198a + ", size=" + this.f1199b + ", total=" + this.f1200c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f1198a);
        parcel.writeInt(this.f1199b);
        parcel.writeInt(this.f1200c);
        byte[] bArr = this.f1202e;
        parcel.writeInt(bArr != null ? bArr.length : 0);
        parcel.writeByteArray(this.f1202e);
    }

    public DefaultProgressEvent(int i2, int i3, int i4, byte[] bArr) {
        this.f1198a = i2;
        this.f1199b = i3;
        this.f1200c = i4;
        this.f1202e = bArr;
    }

    /* renamed from: a */
    public void m745a(Object obj) {
        this.f1201d = obj;
    }

    /* renamed from: a */
    public static DefaultProgressEvent m744a(Parcel parcel) {
        DefaultProgressEvent defaultProgressEvent = new DefaultProgressEvent();
        try {
            defaultProgressEvent.f1198a = parcel.readInt();
            defaultProgressEvent.f1199b = parcel.readInt();
            defaultProgressEvent.f1200c = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                defaultProgressEvent.f1202e = bArr;
            }
        } catch (Exception unused) {
        }
        return defaultProgressEvent;
    }
}
