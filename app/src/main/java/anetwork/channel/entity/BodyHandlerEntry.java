package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.BodyEntry;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BodyHandlerEntry implements BodyEntry {
    public static final Parcelable.Creator<BodyHandlerEntry> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    anetwork.channel.aidl.d f2184a;

    /* synthetic */ BodyHandlerEntry(b bVar) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // anet.channel.request.BodyEntry
    public String getContentType() {
        return null;
    }

    @Override // anet.channel.request.BodyEntry
    public int writeTo(OutputStream outputStream) throws IOException {
        try {
            ByteArray a2 = a.C0012a.f1691a.a(2048);
            int i2 = 0;
            while (!this.f2184a.g()) {
                int read = this.f2184a.read(a2.getBuffer());
                outputStream.write(a2.getBuffer(), 0, read);
                i2 += read;
            }
            a2.recycle();
            return i2;
        } catch (RemoteException e2) {
            throw new IOException("RemoteException", e2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongInterface(this.f2184a);
    }

    public BodyHandlerEntry(a.a.b bVar) {
        this.f2184a = null;
        this.f2184a = new anetwork.channel.aidl.j.b(bVar);
    }

    private BodyHandlerEntry() {
        this.f2184a = null;
    }
}
