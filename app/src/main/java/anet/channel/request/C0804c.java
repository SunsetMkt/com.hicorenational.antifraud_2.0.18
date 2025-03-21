package anet.channel.request;

import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

/* compiled from: Taobao */
/* renamed from: anet.channel.request.c */
/* loaded from: classes.dex */
public class C0804c implements Cancelable {
    public static final C0804c NULL = new C0804c(null, 0, null);

    /* renamed from: a */
    private final int f954a;

    /* renamed from: b */
    private final SpdySession f955b;

    /* renamed from: c */
    private final String f956c;

    public C0804c(SpdySession spdySession, int i2, String str) {
        this.f955b = spdySession;
        this.f954a = i2;
        this.f956c = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        try {
            if (this.f955b == null || this.f954a == 0) {
                return;
            }
            ALog.m716i("awcn.TnetCancelable", "cancel tnet request", this.f956c, "streamId", Integer.valueOf(this.f954a));
            this.f955b.streamReset(this.f954a, 5);
        } catch (SpdyErrorException e2) {
            ALog.m714e("awcn.TnetCancelable", "request cancel failed.", this.f956c, e2, Constants.KEY_ERROR_CODE, Integer.valueOf(e2.SpdyErrorGetCode()));
        }
    }
}
