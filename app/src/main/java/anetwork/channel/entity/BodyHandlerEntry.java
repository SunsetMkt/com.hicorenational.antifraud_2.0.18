package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.C0752a;
import anet.channel.request.BodyEntry;
import anetwork.channel.aidl.InterfaceC0868d;
import anetwork.channel.aidl.p022j.BinderC0875b;
import java.io.IOException;
import java.io.OutputStream;
import p000a.p001a.InterfaceC0001b;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BodyHandlerEntry implements BodyEntry {
    public static final Parcelable.Creator<BodyHandlerEntry> CREATOR = new C0890b();

    /* renamed from: a */
    InterfaceC0868d f1320a;

    /* synthetic */ BodyHandlerEntry(C0890b c0890b) {
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
            ByteArray m446a = C0752a.a.f765a.m446a(2048);
            int i2 = 0;
            while (!this.f1320a.mo767g()) {
                int read = this.f1320a.read(m446a.getBuffer());
                outputStream.write(m446a.getBuffer(), 0, read);
                i2 += read;
            }
            m446a.recycle();
            return i2;
        } catch (RemoteException e2) {
            throw new IOException("RemoteException", e2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongInterface(this.f1320a);
    }

    public BodyHandlerEntry(InterfaceC0001b interfaceC0001b) {
        this.f1320a = null;
        this.f1320a = new BinderC0875b(interfaceC0001b);
    }

    private BodyHandlerEntry() {
        this.f1320a = null;
    }
}
