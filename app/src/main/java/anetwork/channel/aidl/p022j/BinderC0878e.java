package anetwork.channel.aidl.p022j;

import android.os.Handler;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.InterfaceC0870f;
import anetwork.channel.aidl.InterfaceC0871g;
import anetwork.channel.aidl.ParcelableHeader;
import p000a.p001a.C0003d;
import p000a.p001a.InterfaceC0005f;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.e */
/* loaded from: classes.dex */
public class BinderC0878e extends InterfaceC0871g.a {

    /* renamed from: k */
    private static final String f1298k = "anet.ParcelableNetworkListenerWrapper";

    /* renamed from: g */
    private InterfaceC0005f f1299g;

    /* renamed from: h */
    private Handler f1300h;

    /* renamed from: i */
    private Object f1301i;

    /* renamed from: j */
    private byte f1302j;

    public BinderC0878e(InterfaceC0005f interfaceC0005f, Handler handler, Object obj) {
        this.f1302j = (byte) 0;
        this.f1299g = interfaceC0005f;
        if (interfaceC0005f != null) {
            if (C0003d.a.class.isAssignableFrom(interfaceC0005f.getClass())) {
                this.f1302j = (byte) (this.f1302j | 1);
            }
            if (C0003d.c.class.isAssignableFrom(interfaceC0005f.getClass())) {
                this.f1302j = (byte) (this.f1302j | 2);
            }
            if (C0003d.d.class.isAssignableFrom(interfaceC0005f.getClass())) {
                this.f1302j = (byte) (this.f1302j | 4);
            }
            if (C0003d.b.class.isAssignableFrom(interfaceC0005f.getClass())) {
                this.f1302j = (byte) (this.f1302j | 8);
            }
        }
        this.f1300h = handler;
        this.f1301i = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m792b(byte b2, Object obj) {
        try {
            if (b2 == 4) {
                ParcelableHeader parcelableHeader = (ParcelableHeader) obj;
                ((C0003d.d) this.f1299g).mo7a(parcelableHeader.m758b(), parcelableHeader.m757a(), this.f1301i);
                if (ALog.isPrintLog(1)) {
                    ALog.m713d(f1298k, "[onResponseCode]" + parcelableHeader, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b2 == 2) {
                DefaultProgressEvent defaultProgressEvent = (DefaultProgressEvent) obj;
                if (defaultProgressEvent != null) {
                    defaultProgressEvent.m745a(this.f1301i);
                }
                ((C0003d.c) this.f1299g).m6a(defaultProgressEvent, this.f1301i);
                if (ALog.isPrintLog(1)) {
                    ALog.m713d(f1298k, "[onDataReceived]" + defaultProgressEvent, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b2 != 1) {
                if (b2 == 8) {
                    ((C0003d.b) this.f1299g).mo5a((InterfaceC0870f) obj, this.f1301i);
                    if (ALog.isPrintLog(1)) {
                        ALog.m713d(f1298k, "[onInputStreamReceived]", null, new Object[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            DefaultFinishEvent defaultFinishEvent = (DefaultFinishEvent) obj;
            if (defaultFinishEvent != null) {
                defaultFinishEvent.m743a(this.f1301i);
            }
            ((C0003d.a) this.f1299g).mo4a(defaultFinishEvent, this.f1301i);
            if (ALog.isPrintLog(1)) {
                ALog.m713d(f1298k, "[onFinished]" + defaultFinishEvent, null, new Object[0]);
            }
        } catch (Exception unused) {
            ALog.m715e(f1298k, "dispatchCallback error", null, new Object[0]);
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0871g
    /* renamed from: j */
    public byte mo778j() throws RemoteException {
        return this.f1302j;
    }

    /* renamed from: a */
    public InterfaceC0005f m793a() {
        return this.f1299g;
    }

    /* renamed from: a */
    private void m790a(byte b2, Object obj) {
        Handler handler = this.f1300h;
        if (handler == null) {
            m792b(b2, obj);
        } else {
            handler.post(new RunnableC0881h(this, b2, obj));
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0871g
    /* renamed from: a */
    public void mo775a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
        if ((this.f1302j & 2) != 0) {
            m790a((byte) 2, defaultProgressEvent);
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0871g
    /* renamed from: a */
    public void mo774a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
        if ((this.f1302j & 1) != 0) {
            m790a((byte) 1, defaultFinishEvent);
        }
        this.f1299g = null;
        this.f1301i = null;
        this.f1300h = null;
    }

    @Override // anetwork.channel.aidl.InterfaceC0871g
    /* renamed from: a */
    public boolean mo777a(int i2, ParcelableHeader parcelableHeader) throws RemoteException {
        if ((this.f1302j & 4) == 0) {
            return false;
        }
        m790a((byte) 4, (Object) parcelableHeader);
        return false;
    }

    @Override // anetwork.channel.aidl.InterfaceC0871g
    /* renamed from: a */
    public void mo776a(InterfaceC0870f interfaceC0870f) throws RemoteException {
        if ((this.f1302j & 8) != 0) {
            m790a((byte) 8, interfaceC0870f);
        }
    }
}
