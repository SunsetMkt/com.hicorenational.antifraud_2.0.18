package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class er {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    int f462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private dp.a f463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f465a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f466b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f467b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f8955b = fx.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f461a = new byte[0];

    public er() {
        this.f465a = (short) 2;
        this.f467b = f461a;
        this.f464a = null;
        this.f466b = System.currentTimeMillis();
        this.f463a = new dp.a();
        this.f462a = 1;
    }

    public static synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(f8955b);
        long j2 = a;
        a = 1 + j2;
        sb.append(Long.toString(j2));
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m387a() {
        return this.f466b;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m395b() {
        return this.f463a.m289d();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m398c() {
        return this.f463a.m293f();
    }

    public String e() {
        String strM291e = this.f463a.m291e();
        if ("ID_NOT_AVAILABLE".equals(strM291e)) {
            return null;
        }
        if (this.f463a.g()) {
            return strM291e;
        }
        String strD = d();
        this.f463a.e(strD);
        return strD;
    }

    public String f() {
        return this.f464a;
    }

    public String g() {
        if (!this.f463a.m285b()) {
            return null;
        }
        return Long.toString(this.f463a.m279a()) + "@" + this.f463a.m281a() + "/" + this.f463a.m284b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.aj.a(e()) + "; cmd=" + m388a() + "; type=" + ((int) m390a()) + "; from=" + g() + " ]";
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f463a.c(str);
        this.f463a.m280a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f463a.d(str2);
    }

    public int b() {
        return this.f463a.f();
    }

    public void c(long j2) {
        this.f463a.c(j2);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m396b() {
        return this.f463a.l();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m397c() {
        return this.f463a.m279a();
    }

    public void b(long j2) {
        this.f463a.b(j2);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iIndexOf = str.indexOf("@");
        try {
            long j2 = Long.parseLong(str.substring(0, iIndexOf));
            int iIndexOf2 = str.indexOf("/", iIndexOf);
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 1);
            this.f463a.a(j2);
            this.f463a.a(strSubstring);
            this.f463a.b(strSubstring2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Blob parse user err " + e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m394b() {
        return this.f463a.m283b();
    }

    public void b(String str) {
        this.f464a = str;
    }

    er(dp.a aVar, short s, byte[] bArr) {
        this.f465a = (short) 2;
        this.f467b = f461a;
        this.f464a = null;
        this.f466b = System.currentTimeMillis();
        this.f463a = aVar;
        this.f465a = s;
        this.f467b = bArr;
        this.f462a = 2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m388a() {
        return this.f463a.m287c();
    }

    public void a(int i2) {
        this.f463a.a(i2);
    }

    public int a() {
        return this.f463a.c();
    }

    public void a(String str) {
        this.f463a.e(str);
    }

    public void a(long j2) {
        this.f463a.a(j2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m391a() {
        return this.f463a.j();
    }

    public void a(long j2, String str, String str2) {
        if (j2 != 0) {
            this.f463a.a(j2);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f463a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f463a.b(str2);
    }

    public int c() {
        return this.f463a.b() + 8 + this.f467b.length;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f463a.c(1);
            this.f467b = com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), bArr);
        } else {
            this.f463a.c(0);
            this.f467b = bArr;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m392a() {
        return es.a(this, this.f467b);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m393a(String str) {
        if (this.f463a.e() == 1) {
            return es.a(this, com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), this.f467b));
        }
        if (this.f463a.e() == 0) {
            return es.a(this, this.f467b);
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("unknow cipher = " + this.f463a.e());
        return es.a(this, this.f467b);
    }

    @Deprecated
    public static er a(fo foVar, String str) {
        int i2;
        er erVar = new er();
        try {
            i2 = Integer.parseInt(foVar.k());
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Blob parse chid err " + e2.getMessage());
            i2 = 1;
        }
        erVar.a(i2);
        erVar.a(foVar.j());
        erVar.c(foVar.m());
        erVar.b(foVar.n());
        erVar.a("XMLMSG", (String) null);
        try {
            erVar.a(foVar.mo429a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                erVar.a((short) 3);
            } else {
                erVar.a((short) 2);
                erVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Blob setPayload err\uff1a " + e3.getMessage());
        }
        return erVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    ByteBuffer mo389a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f465a);
        byteBuffer.putShort((short) this.f463a.a());
        byteBuffer.putInt(this.f467b.length);
        int iPosition = byteBuffer.position();
        this.f463a.m371a(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, this.f463a.a());
        byteBuffer.position(iPosition + this.f463a.a());
        byteBuffer.put(this.f467b);
        return byteBuffer;
    }

    static er a(ByteBuffer byteBuffer) throws IOException {
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            short s = byteBufferSlice.getShort(0);
            short s2 = byteBufferSlice.getShort(2);
            int i2 = byteBufferSlice.getInt(4);
            dp.a aVar = new dp.a();
            aVar.a(byteBufferSlice.array(), byteBufferSlice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i2];
            byteBufferSlice.position(s2 + 8);
            byteBufferSlice.get(bArr, 0, i2);
            return new er(aVar, s, bArr);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short m390a() {
        return this.f465a;
    }

    public void a(short s) {
        this.f465a = s;
    }
}
