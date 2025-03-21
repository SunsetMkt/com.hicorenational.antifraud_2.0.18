package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.service.C4366ar;
import com.xiaomi.push.service.C4372ax;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* renamed from: com.xiaomi.push.eu */
/* loaded from: classes2.dex */
public class C4200eu {

    /* renamed from: a */
    private int f15225a;

    /* renamed from: a */
    private C4204ey f15226a;

    /* renamed from: a */
    private OutputStream f15227a;

    /* renamed from: a */
    private byte[] f15230a;

    /* renamed from: b */
    private int f15231b;

    /* renamed from: a */
    ByteBuffer f15228a = ByteBuffer.allocate(2048);

    /* renamed from: b */
    private ByteBuffer f15232b = ByteBuffer.allocate(4);

    /* renamed from: a */
    private Adler32 f15229a = new Adler32();

    C4200eu(OutputStream outputStream, C4204ey c4204ey) {
        this.f15227a = new BufferedOutputStream(outputStream);
        this.f15226a = c4204ey;
        TimeZone timeZone = TimeZone.getDefault();
        this.f15225a = timeZone.getRawOffset() / 3600000;
        this.f15231b = timeZone.useDaylightTime() ? 1 : 0;
    }

    /* renamed from: a */
    public int m14719a(C4197er c4197er) {
        int mo14704c = c4197er.mo14704c();
        if (mo14704c > 32768) {
            AbstractC4022b.m13347a("Blob size=" + mo14704c + " should be less than 32768 Drop blob chid=" + c4197er.m14683a() + " id=" + c4197er.m14709e());
            return 0;
        }
        this.f15228a.clear();
        int i2 = mo14704c + 8 + 4;
        if (i2 > this.f15228a.capacity() || this.f15228a.capacity() > 4096) {
            this.f15228a = ByteBuffer.allocate(i2);
        }
        this.f15228a.putShort((short) -15618);
        this.f15228a.putShort((short) 5);
        this.f15228a.putInt(mo14704c);
        int position = this.f15228a.position();
        this.f15228a = c4197er.mo14686a(this.f15228a);
        if (!"CONN".equals(c4197er.m14685a())) {
            if (this.f15230a == null) {
                this.f15230a = this.f15226a.m14747a();
            }
            C4366ar.m15997a(this.f15230a, this.f15228a.array(), true, position, mo14704c);
        }
        this.f15229a.reset();
        this.f15229a.update(this.f15228a.array(), 0, this.f15228a.position());
        this.f15232b.putInt(0, (int) this.f15229a.getValue());
        this.f15227a.write(this.f15228a.array(), 0, this.f15228a.position());
        this.f15227a.write(this.f15232b.array(), 0, 4);
        this.f15227a.flush();
        int position2 = this.f15228a.position() + 4;
        AbstractC4022b.m13359c("[Slim] Wrote {cmd=" + c4197er.m14685a() + ";chid=" + c4197er.m14683a() + ";len=" + position2 + "}");
        return position2;
    }

    /* renamed from: b */
    public void m14721b() {
        C4197er c4197er = new C4197er();
        c4197er.m14692a("CLOSE", (String) null);
        m14719a(c4197er);
        this.f15227a.close();
    }

    /* renamed from: a */
    public void m14720a() {
        C4168dp.e eVar = new C4168dp.e();
        eVar.m14419a(106);
        eVar.m14422a(C4301k.m15694a());
        eVar.m14428b(C4309r.m15717a());
        eVar.m14433c(C4372ax.m16018a());
        eVar.m14426b(48);
        eVar.m14438d(this.f15226a.m14771b());
        eVar.m14442e(this.f15226a.mo14762a());
        eVar.m14446f(Locale.getDefault().toString());
        eVar.m14432c(Build.VERSION.SDK_INT);
        eVar.m14437d(C4233g.m14925a(this.f15226a.m14804a(), "com.xiaomi.xmsf"));
        byte[] mo14790a = this.f15226a.m14761a().mo14790a();
        if (mo14790a != null) {
            eVar.m14421a(C4168dp.b.m14373a(mo14790a));
        }
        C4197er c4197er = new C4197er();
        c4197er.m14688a(0);
        c4197er.m14692a("CONN", (String) null);
        c4197er.m14690a(0L, "xiaomi.com", null);
        c4197er.m14694a(eVar.m14590a(), (String) null);
        m14719a(c4197er);
        AbstractC4022b.m13347a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.f15225a + Constants.COLON_SEPARATOR + this.f15231b + " Model=" + C4301k.m15694a() + " os=" + Build.VERSION.INCREMENTAL);
    }
}
