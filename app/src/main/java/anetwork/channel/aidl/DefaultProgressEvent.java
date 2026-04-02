package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.e;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class DefaultProgressEvent implements Parcelable, e.b {
    public static final Parcelable.Creator<DefaultProgressEvent> CREATOR = new k();
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f1668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    byte[] f1669e;

    public DefaultProgressEvent() {
    }

    @Override // b.a.e.b
    public int a() {
        return this.f1666b;
    }

    public Object b() {
        return this.f1668d;
    }

    @Override // b.a.e.b
    public String d() {
        return "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // b.a.e.b
    public int m() {
        return this.a;
    }

    @Override // b.a.e.b
    public byte[] n() {
        return this.f1669e;
    }

    @Override // b.a.e.b
    public int o() {
        return this.f1667c;
    }

    public String toString() {
        return "DefaultProgressEvent [index=" + this.a + ", size=" + this.f1666b + ", total=" + this.f1667c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f1666b);
        parcel.writeInt(this.f1667c);
        byte[] bArr = this.f1669e;
        parcel.writeInt(bArr != null ? bArr.length : 0);
        parcel.writeByteArray(this.f1669e);
    }

    public DefaultProgressEvent(int i2, int i3, int i4, byte[] bArr) {
        this.a = i2;
        this.f1666b = i3;
        this.f1667c = i4;
        this.f1669e = bArr;
    }

    public void a(Object obj) {
        this.f1668d = obj;
    }

    public static DefaultProgressEvent a(Parcel parcel) {
        DefaultProgressEvent defaultProgressEvent = new DefaultProgressEvent();
        try {
            defaultProgressEvent.a = parcel.readInt();
            defaultProgressEvent.f1666b = parcel.readInt();
            defaultProgressEvent.f1667c = parcel.readInt();
            int i2 = parcel.readInt();
            if (i2 > 0) {
                byte[] bArr = new byte[i2];
                parcel.readByteArray(bArr);
                defaultProgressEvent.f1669e = bArr;
            }
        } catch (Exception unused) {
        }
        return defaultProgressEvent;
    }
}
