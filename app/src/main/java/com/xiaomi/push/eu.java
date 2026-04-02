package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dp;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes2.dex */
public class eu {
    private int a;

    /* JADX INFO: renamed from: a */
    private ey f474a;

    /* JADX INFO: renamed from: a */
    private OutputStream f475a;

    /* JADX INFO: renamed from: a */
    private byte[] f478a;

    /* JADX INFO: renamed from: b */
    private int f8957b;

    /* JADX INFO: renamed from: a */
    ByteBuffer f476a = ByteBuffer.allocate(2048);

    /* JADX INFO: renamed from: b */
    private ByteBuffer f479b = ByteBuffer.allocate(4);

    /* JADX INFO: renamed from: a */
    private Adler32 f477a = new Adler32();

    eu(OutputStream outputStream, ey eyVar) {
        this.f475a = new BufferedOutputStream(outputStream);
        this.f474a = eyVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.f8957b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(er erVar) throws IOException {
        int iC = erVar.c();
        if (iC > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Blob size=" + iC + " should be less than 32768 Drop blob chid=" + erVar.a() + " id=" + erVar.e());
            return 0;
        }
        this.f476a.clear();
        int i2 = iC + 8 + 4;
        if (i2 > this.f476a.capacity() || this.f476a.capacity() > 4096) {
            this.f476a = ByteBuffer.allocate(i2);
        }
        this.f476a.putShort((short) -15618);
        this.f476a.putShort((short) 5);
        this.f476a.putInt(iC);
        int iPosition = this.f476a.position();
        this.f476a = erVar.mo389a(this.f476a);
        if (!"CONN".equals(erVar.m388a())) {
            if (this.f478a == null) {
                this.f478a = this.f474a.m406a();
            }
            com.xiaomi.push.service.ar.a(this.f478a, this.f476a.array(), true, iPosition, iC);
        }
        this.f477a.reset();
        this.f477a.update(this.f476a.array(), 0, this.f476a.position());
        this.f479b.putInt(0, (int) this.f477a.getValue());
        this.f475a.write(this.f476a.array(), 0, this.f476a.position());
        this.f475a.write(this.f479b.array(), 0, 4);
        this.f475a.flush();
        int iPosition2 = this.f476a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + erVar.m388a() + ";chid=" + erVar.a() + ";len=" + iPosition2 + "}");
        return iPosition2;
    }

    public void b() throws IOException {
        er erVar = new er();
        erVar.a("CLOSE", (String) null);
        a(erVar);
        this.f475a.close();
    }

    public void a() throws IOException {
        dp.e eVar = new dp.e();
        eVar.a(106);
        eVar.a(k.a());
        eVar.b(r.m635a());
        eVar.c(com.xiaomi.push.service.ax.m703a());
        eVar.b(48);
        eVar.d(this.f474a.m414b());
        eVar.e(this.f474a.mo412a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        eVar.d(g.a(this.f474a.a(), "com.xiaomi.xmsf"));
        byte[] bArrMo420a = this.f474a.m411a().mo420a();
        if (bArrMo420a != null) {
            eVar.a(dp.b.a(bArrMo420a));
        }
        er erVar = new er();
        erVar.a(0);
        erVar.a("CONN", (String) null);
        erVar.a(0L, "xiaomi.com", null);
        erVar.a(eVar.m372a(), (String) null);
        a(erVar);
        com.xiaomi.channel.commonutils.logger.b.m48a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.a + Constants.COLON_SEPARATOR + this.f8957b + " Model=" + k.a() + " os=" + Build.VERSION.INCREMENTAL);
    }
}
