package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.BodyEntry;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class BodyHandlerEntry implements BodyEntry {
    public static final Parcelable.Creator<BodyHandlerEntry> CREATOR = new b();
    anetwork.channel.aidl.d a;

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
            ByteArray byteArrayA = a.C0008a.a.a(2048);
            int i2 = 0;
            while (!this.a.g()) {
                int i3 = this.a.read(byteArrayA.getBuffer());
                outputStream.write(byteArrayA.getBuffer(), 0, i3);
                i2 += i3;
            }
            byteArrayA.recycle();
            return i2;
        } catch (RemoteException e2) {
            throw new IOException("RemoteException", e2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongInterface(this.a);
    }

    public BodyHandlerEntry(b.a.b bVar) {
        this.a = null;
        this.a = new anetwork.channel.aidl.j.b(bVar);
    }

    private BodyHandlerEntry() {
        this.a = null;
    }
}
