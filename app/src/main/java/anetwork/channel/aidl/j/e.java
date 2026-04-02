package anetwork.channel.aidl.j;

import android.os.Handler;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.g;
import b.a.d;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class e extends g.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f1740k = "anet.ParcelableNetworkListenerWrapper";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b.a.f f1741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f1742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f1743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte f1744j;

    public e(b.a.f fVar, Handler handler, Object obj) {
        this.f1744j = (byte) 0;
        this.f1741g = fVar;
        if (fVar != null) {
            if (d.a.class.isAssignableFrom(fVar.getClass())) {
                this.f1744j = (byte) (this.f1744j | 1);
            }
            if (d.c.class.isAssignableFrom(fVar.getClass())) {
                this.f1744j = (byte) (this.f1744j | 2);
            }
            if (d.InterfaceC0021d.class.isAssignableFrom(fVar.getClass())) {
                this.f1744j = (byte) (this.f1744j | 4);
            }
            if (d.b.class.isAssignableFrom(fVar.getClass())) {
                this.f1744j = (byte) (this.f1744j | 8);
            }
        }
        this.f1742h = handler;
        this.f1743i = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte b2, Object obj) {
        try {
            if (b2 == 4) {
                ParcelableHeader parcelableHeader = (ParcelableHeader) obj;
                ((d.InterfaceC0021d) this.f1741g).a(parcelableHeader.b(), parcelableHeader.a(), this.f1743i);
                if (ALog.isPrintLog(1)) {
                    ALog.d(f1740k, "[onResponseCode]" + parcelableHeader, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b2 == 2) {
                DefaultProgressEvent defaultProgressEvent = (DefaultProgressEvent) obj;
                if (defaultProgressEvent != null) {
                    defaultProgressEvent.a(this.f1743i);
                }
                ((d.c) this.f1741g).a(defaultProgressEvent, this.f1743i);
                if (ALog.isPrintLog(1)) {
                    ALog.d(f1740k, "[onDataReceived]" + defaultProgressEvent, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b2 != 1) {
                if (b2 == 8) {
                    ((d.b) this.f1741g).a((anetwork.channel.aidl.f) obj, this.f1743i);
                    if (ALog.isPrintLog(1)) {
                        ALog.d(f1740k, "[onInputStreamReceived]", null, new Object[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            DefaultFinishEvent defaultFinishEvent = (DefaultFinishEvent) obj;
            if (defaultFinishEvent != null) {
                defaultFinishEvent.a(this.f1743i);
            }
            ((d.a) this.f1741g).a(defaultFinishEvent, this.f1743i);
            if (ALog.isPrintLog(1)) {
                ALog.d(f1740k, "[onFinished]" + defaultFinishEvent, null, new Object[0]);
            }
        } catch (Exception unused) {
            ALog.e(f1740k, "dispatchCallback error", null, new Object[0]);
        }
    }

    @Override // anetwork.channel.aidl.g
    public byte j() throws RemoteException {
        return this.f1744j;
    }

    public b.a.f a() {
        return this.f1741g;
    }

    private void a(byte b2, Object obj) {
        Handler handler = this.f1742h;
        if (handler == null) {
            b(b2, obj);
        } else {
            handler.post(new h(this, b2, obj));
        }
    }

    @Override // anetwork.channel.aidl.g
    public void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
        if ((this.f1744j & 2) != 0) {
            a((byte) 2, defaultProgressEvent);
        }
    }

    @Override // anetwork.channel.aidl.g
    public void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
        if ((this.f1744j & 1) != 0) {
            a((byte) 1, defaultFinishEvent);
        }
        this.f1741g = null;
        this.f1743i = null;
        this.f1742h = null;
    }

    @Override // anetwork.channel.aidl.g
    public boolean a(int i2, ParcelableHeader parcelableHeader) throws RemoteException {
        if ((this.f1744j & 4) == 0) {
            return false;
        }
        a((byte) 4, (Object) parcelableHeader);
        return false;
    }

    @Override // anetwork.channel.aidl.g
    public void a(anetwork.channel.aidl.f fVar) throws RemoteException {
        if ((this.f1744j & 8) != 0) {
            a((byte) 8, fVar);
        }
    }
}
