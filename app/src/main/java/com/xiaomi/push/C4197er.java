package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.service.C4358aj;
import com.xiaomi.push.service.C4366ar;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.er */
/* loaded from: classes2.dex */
public class C4197er {

    /* renamed from: a */
    int f15210a;

    /* renamed from: a */
    private C4168dp.a f15211a;

    /* renamed from: a */
    String f15212a;

    /* renamed from: a */
    private short f15213a;

    /* renamed from: b */
    private final long f15214b;

    /* renamed from: b */
    private byte[] f15215b;

    /* renamed from: b */
    private static String f15209b = C4230fx.m14900a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a */
    private static long f15207a = 0;

    /* renamed from: a */
    private static final byte[] f15208a = new byte[0];

    public C4197er() {
        this.f15213a = (short) 2;
        this.f15215b = f15208a;
        this.f15212a = null;
        this.f15214b = System.currentTimeMillis();
        this.f15211a = new C4168dp.a();
        this.f15210a = 1;
    }

    /* renamed from: d */
    public static synchronized String m14682d() {
        String sb;
        synchronized (C4197er.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f15209b);
            long j2 = f15207a;
            f15207a = 1 + j2;
            sb2.append(Long.toString(j2));
            sb = sb2.toString();
        }
        return sb;
    }

    /* renamed from: a */
    public long m14684a() {
        return this.f15214b;
    }

    /* renamed from: b */
    public String m14700b() {
        return this.f15211a.m14356d();
    }

    /* renamed from: c */
    public String m14706c() {
        return this.f15211a.m14364f();
    }

    /* renamed from: e */
    public String m14709e() {
        String m14360e = this.f15211a.m14360e();
        if ("ID_NOT_AVAILABLE".equals(m14360e)) {
            return null;
        }
        if (this.f15211a.m14366g()) {
            return m14360e;
        }
        String m14682d = m14682d();
        this.f15211a.m14359e(m14682d);
        return m14682d;
    }

    /* renamed from: f */
    public String m14710f() {
        return this.f15212a;
    }

    /* renamed from: g */
    public String m14711g() {
        if (!this.f15211a.m14345b()) {
            return null;
        }
        return Long.toString(this.f15211a.m14333a()) + "@" + this.f15211a.m14338a() + "/" + this.f15211a.m14344b();
    }

    public String toString() {
        return "Blob [chid=" + m14683a() + "; Id=" + C4358aj.m15942a(m14709e()) + "; cmd=" + m14685a() + "; type=" + ((int) m14687a()) + "; from=" + m14711g() + " ]";
    }

    /* renamed from: a */
    public void m14692a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f15211a.m14350c(str);
        this.f15211a.m14334a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f15211a.m14355d(str2);
    }

    /* renamed from: b */
    public int m14698b() {
        return this.f15211a.m14362f();
    }

    /* renamed from: c */
    public void m14707c(long j2) {
        this.f15211a.m14349c(j2);
    }

    /* renamed from: b */
    public boolean m14703b() {
        return this.f15211a.m14371l();
    }

    /* renamed from: c */
    public long m14705c() {
        return this.f15211a.m14333a();
    }

    /* renamed from: b */
    public void m14701b(long j2) {
        this.f15211a.m14342b(j2);
    }

    /* renamed from: c */
    public void m14708c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f15211a.m14336a(parseLong);
            this.f15211a.m14337a(substring);
            this.f15211a.m14343b(substring2);
        } catch (Exception e2) {
            AbstractC4022b.m13347a("Blob parse user err " + e2.getMessage());
        }
    }

    /* renamed from: b */
    public long m14699b() {
        return this.f15211a.m14340b();
    }

    /* renamed from: b */
    public void m14702b(String str) {
        this.f15212a = str;
    }

    C4197er(C4168dp.a aVar, short s, byte[] bArr) {
        this.f15213a = (short) 2;
        this.f15215b = f15208a;
        this.f15212a = null;
        this.f15214b = System.currentTimeMillis();
        this.f15211a = aVar;
        this.f15213a = s;
        this.f15215b = bArr;
        this.f15210a = 2;
    }

    /* renamed from: a */
    public String m14685a() {
        return this.f15211a.m14351c();
    }

    /* renamed from: a */
    public void m14688a(int i2) {
        this.f15211a.m14335a(i2);
    }

    /* renamed from: a */
    public int m14683a() {
        return this.f15211a.m14346c();
    }

    /* renamed from: a */
    public void m14691a(String str) {
        this.f15211a.m14359e(str);
    }

    /* renamed from: a */
    public void m14689a(long j2) {
        this.f15211a.m14336a(j2);
    }

    /* renamed from: a */
    public boolean m14695a() {
        return this.f15211a.m14369j();
    }

    /* renamed from: a */
    public void m14690a(long j2, String str, String str2) {
        if (j2 != 0) {
            this.f15211a.m14336a(j2);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f15211a.m14337a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f15211a.m14343b(str2);
    }

    /* renamed from: c */
    public int mo14704c() {
        return this.f15211a.mo14322b() + 8 + this.f15215b.length;
    }

    /* renamed from: a */
    public void m14694a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15211a.m14348c(1);
            this.f15215b = C4366ar.m15996a(C4366ar.m15994a(str, m14709e()), bArr);
        } else {
            this.f15211a.m14348c(0);
            this.f15215b = bArr;
        }
    }

    /* renamed from: a */
    public byte[] m14696a() {
        return C4198es.m14712a(this, this.f15215b);
    }

    /* renamed from: a */
    public byte[] m14697a(String str) {
        if (this.f15211a.m14358e() == 1) {
            return C4198es.m14712a(this, C4366ar.m15996a(C4366ar.m15994a(str, m14709e()), this.f15215b));
        }
        if (this.f15211a.m14358e() == 0) {
            return C4198es.m14712a(this, this.f15215b);
        }
        AbstractC4022b.m13347a("unknow cipher = " + this.f15211a.m14358e());
        return C4198es.m14712a(this, this.f15215b);
    }

    @Deprecated
    /* renamed from: a */
    public static C4197er m14680a(AbstractC4221fo abstractC4221fo, String str) {
        int i2;
        C4197er c4197er = new C4197er();
        try {
            i2 = Integer.parseInt(abstractC4221fo.m14865k());
        } catch (Exception e2) {
            AbstractC4022b.m13347a("Blob parse chid err " + e2.getMessage());
            i2 = 1;
        }
        c4197er.m14688a(i2);
        c4197er.m14691a(abstractC4221fo.m14864j());
        c4197er.m14708c(abstractC4221fo.m14869m());
        c4197er.m14702b(abstractC4221fo.m14871n());
        c4197er.m14692a("XMLMSG", (String) null);
        try {
            c4197er.m14694a(abstractC4221fo.mo14829a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                c4197er.m14693a((short) 3);
            } else {
                c4197er.m14693a((short) 2);
                c4197er.m14692a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            AbstractC4022b.m13347a("Blob setPayload err： " + e3.getMessage());
        }
        return c4197er;
    }

    /* renamed from: a */
    ByteBuffer mo14686a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(mo14704c());
        }
        byteBuffer.putShort(this.f15213a);
        byteBuffer.putShort((short) this.f15211a.mo14314a());
        byteBuffer.putInt(this.f15215b.length);
        int position = byteBuffer.position();
        this.f15211a.m14588a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f15211a.mo14314a());
        byteBuffer.position(position + this.f15211a.mo14314a());
        byteBuffer.put(this.f15215b);
        return byteBuffer;
    }

    /* renamed from: a */
    static C4197er m14681a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i2 = slice.getInt(4);
            C4168dp.a aVar = new C4168dp.a();
            aVar.m14587a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i2];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i2);
            return new C4197er(aVar, s, bArr);
        } catch (Exception e2) {
            AbstractC4022b.m13347a("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* renamed from: a */
    public short m14687a() {
        return this.f15213a;
    }

    /* renamed from: a */
    public void m14693a(short s) {
        this.f15213a = s;
    }
}
