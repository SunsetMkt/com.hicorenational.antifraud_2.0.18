package anet.channel.session;

import android.content.Context;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.j */
/* loaded from: classes.dex */
class C0819j implements AccsSSLCallback {

    /* renamed from: a */
    final /* synthetic */ TnetSpdySession f997a;

    C0819j(TnetSpdySession tnetSpdySession) {
        this.f997a = tnetSpdySession;
    }

    @Override // org.android.spdy.AccsSSLCallback
    public byte[] getSSLPublicKey(int i2, byte[] bArr) {
        byte[] bArr2;
        Context context;
        try {
            ISecurity iSecurity = this.f997a.f969G;
            context = this.f997a.f683a;
            bArr2 = iSecurity.decrypt(context, ISecurity.CIPHER_ALGORITHM_AES128, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
            if (bArr2 != null) {
                try {
                    if (ALog.isPrintLog(2)) {
                        ALog.m716i("getSSLPublicKey", null, "decrypt", new String(bArr2));
                    }
                } catch (Throwable th) {
                    th = th;
                    ALog.m714e("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
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
