package anet.channel.request;

import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c implements Cancelable {
    public static final c NULL = new c(null, 0, null);
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SpdySession f1526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1527c;

    public c(SpdySession spdySession, int i2, String str) {
        this.f1526b = spdySession;
        this.a = i2;
        this.f1527c = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        try {
            if (this.f1526b == null || this.a == 0) {
                return;
            }
            ALog.i("awcn.TnetCancelable", "cancel tnet request", this.f1527c, "streamId", Integer.valueOf(this.a));
            this.f1526b.streamReset(this.a, 5);
        } catch (SpdyErrorException e2) {
            ALog.e("awcn.TnetCancelable", "request cancel failed.", this.f1527c, e2, Constants.KEY_ERROR_CODE, Integer.valueOf(e2.SpdyErrorGetCode()));
        }
    }
}
