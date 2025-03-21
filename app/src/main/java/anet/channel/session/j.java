package anet.channel.session;

import android.content.Context;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class j implements AccsSSLCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f1898a;

    j(TnetSpdySession tnetSpdySession) {
        this.f1898a = tnetSpdySession;
    }

    @Override // org.android.spdy.AccsSSLCallback
    public byte[] getSSLPublicKey(int i2, byte[] bArr) {
        byte[] bArr2;
        Context context;
        try {
            ISecurity iSecurity = this.f1898a.G;
            context = this.f1898a.f1621a;
            bArr2 = iSecurity.decrypt(context, ISecurity.CIPHER_ALGORITHM_AES128, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
            if (bArr2 != null) {
                try {
                    if (ALog.isPrintLog(2)) {
                        ALog.i("getSSLPublicKey", null, "decrypt", new String(bArr2));
                    }
                } catch (Throwable th) {
                    th = th;
                    ALog.e("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
                    return bArr2;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bArr2 = null;
        }
        return bArr2;
    }
}
