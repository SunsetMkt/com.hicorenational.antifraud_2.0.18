package p000a.p001a.p013t;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.C0752a;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.InterfaceC0865a;
import anetwork.channel.aidl.InterfaceC0869e;
import anetwork.channel.aidl.InterfaceC0870f;
import anetwork.channel.aidl.InterfaceC0871g;
import anetwork.channel.aidl.InterfaceC0872h;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableRequest;
import anetwork.channel.aidl.p022j.BinderC0874a;
import anetwork.channel.aidl.p022j.BinderC0876c;
import anetwork.channel.aidl.p022j.BinderC0878e;
import anetwork.channel.entity.C0895g;
import anetwork.channel.entity.C0899k;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.ByteArrayOutputStream;
import p000a.p001a.p007o.C0025c;

/* compiled from: Taobao */
/* renamed from: a.a.t.b */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0037b extends InterfaceC0872h.a {

    /* renamed from: f */
    public static final int f84f = 0;

    /* renamed from: g */
    public static final int f85g = 1;

    /* renamed from: h */
    private static final String f86h = "anet.UnifiedNetworkDelegate";

    /* renamed from: e */
    public int f87e = 1;

    public AbstractBinderC0037b(Context context) {
        C0025c.init(context);
    }

    /* renamed from: c */
    private NetworkResponse m174c(ParcelableRequest parcelableRequest) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            BinderC0874a binderC0874a = (BinderC0874a) mo177b(parcelableRequest);
            InterfaceC0870f mo764k = binderC0874a.mo764k();
            if (mo764k != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(mo764k.length() > 0 ? mo764k.length() : 1024);
                ByteArray m446a = C0752a.a.f765a.m446a(2048);
                while (true) {
                    int read = mo764k.read(m446a.getBuffer());
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(m446a.getBuffer(), 0, read);
                }
                networkResponse.m753a(byteArrayOutputStream.toByteArray());
            }
            int statusCode = binderC0874a.getStatusCode();
            if (statusCode < 0) {
                networkResponse.m753a((byte[]) null);
            } else {
                networkResponse.m752a(binderC0874a.mo763f());
            }
            networkResponse.m748a(statusCode);
            networkResponse.m749a(binderC0874a.mo762e());
            return networkResponse;
        } catch (RemoteException e2) {
            networkResponse.m748a(-103);
            String message = e2.getMessage();
            if (!TextUtils.isEmpty(message)) {
                networkResponse.m750a(StringUtils.concatString(networkResponse.mo51d(), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, message));
            }
            return networkResponse;
        } catch (Exception unused) {
            networkResponse.m748a(ErrorConstant.ERROR_REQUEST_FAIL);
            return networkResponse;
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0872h
    /* renamed from: a */
    public NetworkResponse mo175a(ParcelableRequest parcelableRequest) throws RemoteException {
        return m174c(parcelableRequest);
    }

    @Override // anetwork.channel.aidl.InterfaceC0872h
    /* renamed from: b */
    public InterfaceC0865a mo177b(ParcelableRequest parcelableRequest) throws RemoteException {
        try {
            C0899k c0899k = new C0899k(parcelableRequest, this.f87e, true);
            BinderC0874a binderC0874a = new BinderC0874a(c0899k);
            binderC0874a.m785a(m173a(c0899k, new BinderC0878e(binderC0874a, null, null)));
            return binderC0874a;
        } catch (Exception e2) {
            ALog.m714e(f86h, "asyncSend failed", parcelableRequest.f1228m, e2, new Object[0]);
            throw new RemoteException(e2.getMessage());
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0872h
    /* renamed from: a */
    public InterfaceC0869e mo176a(ParcelableRequest parcelableRequest, InterfaceC0871g interfaceC0871g) throws RemoteException {
        try {
            return m173a(new C0899k(parcelableRequest, this.f87e, false), interfaceC0871g);
        } catch (Exception e2) {
            ALog.m714e(f86h, "asyncSend failed", parcelableRequest.f1228m, e2, new Object[0]);
            throw new RemoteException(e2.getMessage());
        }
    }

    /* renamed from: a */
    private InterfaceC0869e m173a(C0899k c0899k, InterfaceC0871g interfaceC0871g) throws RemoteException {
        return new BinderC0876c(new C0048m(c0899k, new C0895g(interfaceC0871g, c0899k)).m201a());
    }
}
