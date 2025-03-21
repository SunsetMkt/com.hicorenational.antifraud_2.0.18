package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.service.C4356ah;

/* renamed from: com.xiaomi.push.dl */
/* loaded from: classes2.dex */
public abstract class AbstractC4164dl extends C4076ae.a {

    /* renamed from: a */
    protected int f14894a;

    /* renamed from: a */
    protected Context f14895a;

    public AbstractC4164dl(Context context, int i2) {
        this.f14894a = i2;
        this.f14895a = context;
    }

    /* renamed from: c */
    private String m14299c() {
        return "dc_job_result_time_" + mo13391a();
    }

    /* renamed from: d */
    private String m14300d() {
        return "dc_job_result_" + mo13391a();
    }

    /* renamed from: a */
    public abstract EnumC4241gh mo14301a();

    /* renamed from: a */
    protected boolean m14302a() {
        return C4161di.m14286a(this.f14895a, String.valueOf(mo13391a()), this.f14894a);
    }

    /* renamed from: b */
    public abstract String mo14303b();

    /* renamed from: b */
    protected boolean m14304b() {
        return true;
    }

    /* renamed from: c */
    protected boolean m14305c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String mo14303b = mo14303b();
        if (TextUtils.isEmpty(mo14303b)) {
            return;
        }
        if (m14302a()) {
            AbstractC4022b.m13347a("DC run job mutual: " + mo13391a());
            return;
        }
        InterfaceC4158df m14282a = C4159dg.m14281a().m14282a();
        String mo13564a = m14282a == null ? "" : m14282a.mo13564a();
        if (!TextUtils.isEmpty(mo13564a) && m14304b()) {
            if (m14305c()) {
                SharedPreferences sharedPreferences = this.f14895a.getSharedPreferences("mipush_extra", 0);
                if (C4100bb.m13879a(mo14303b).equals(sharedPreferences.getString(m14300d(), null))) {
                    long j2 = sharedPreferences.getLong(m14299c(), 0L);
                    int m15927a = C4356ah.m15923a(this.f14895a).m15927a(EnumC4244gk.DCJobUploadRepeatedInterval.m15014a(), 604800);
                    if ((System.currentTimeMillis() - j2) / 1000 < this.f14894a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j2) / 1000 < m15927a) {
                        mo14303b = "same_" + j2;
                    }
                }
            }
            C4247gn c4247gn = new C4247gn();
            c4247gn.m15021a(mo14303b);
            c4247gn.m15019a(System.currentTimeMillis());
            c4247gn.m15020a(mo14301a());
            m14298a(this.f14895a, c4247gn, mo13564a);
        }
    }

    /* renamed from: a */
    public static void m14297a(Context context, C4247gn c4247gn) {
        InterfaceC4158df m14282a = C4159dg.m14281a().m14282a();
        String mo13564a = m14282a == null ? "" : m14282a.mo13564a();
        if (TextUtils.isEmpty(mo13564a) || TextUtils.isEmpty(c4247gn.m15022a())) {
            return;
        }
        m14298a(context, c4247gn, mo13564a);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #7 {, blocks: (B:20:0x0067, B:23:0x006d, B:26:0x0070, B:27:0x0073, B:28:0x009c, B:49:0x00a3, B:52:0x00a9, B:55:0x00ac, B:56:0x00b2, B:37:0x008f, B:40:0x0095, B:43:0x0098), top: B:8:0x0013 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m14298a(android.content.Context r6, com.xiaomi.push.C4247gn r7, java.lang.String r8) {
        /*
            byte[] r7 = com.xiaomi.push.C4276hp.m15567a(r7)
            byte[] r7 = com.xiaomi.push.C4161di.m14288b(r8, r7)
            if (r7 == 0) goto Lb6
            int r8 = r7.length
            if (r8 != 0) goto Lf
            goto Lb6
        Lf:
            java.lang.Object r8 = com.xiaomi.push.C4162dj.f14887a
            monitor-enter(r8)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.io.File r2 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.lang.String r3 = "push_cdata.lock"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            com.xiaomi.push.C4408w.m16360a(r1)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L80
            java.nio.channels.FileLock r1 = r1.lock()     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L80
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            java.io.File r6 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            java.lang.String r4 = "push_cdata.data"
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            boolean r6 = com.xiaomi.push.C4407v.m16354a(r3)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            if (r6 == 0) goto L64
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            r5 = 1
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            int r0 = r7.length     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            byte[] r0 = com.xiaomi.push.C4410y.m16369a(r0)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.write(r0)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.write(r7)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.flush()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r4 = 0
            r3.setLastModified(r4)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            goto L65
        L60:
            r7 = move-exception
            goto La0
        L62:
            r7 = move-exception
            goto L7b
        L64:
            r6 = r0
        L65:
            if (r1 == 0) goto L70
            boolean r7 = r1.isValid()     // Catch: java.lang.Throwable -> Lb3
            if (r7 == 0) goto L70
            r1.release()     // Catch: java.io.IOException -> L70 java.lang.Throwable -> Lb3
        L70:
            com.xiaomi.push.C4408w.m16356a(r6)     // Catch: java.lang.Throwable -> Lb3
        L73:
            com.xiaomi.push.C4408w.m16356a(r2)     // Catch: java.lang.Throwable -> Lb3
            goto L9c
        L77:
            r7 = move-exception
            goto La1
        L79:
            r7 = move-exception
            r6 = r0
        L7b:
            r0 = r1
            goto L8a
        L7d:
            r7 = move-exception
            r1 = r0
            goto La1
        L80:
            r7 = move-exception
            r6 = r0
            goto L8a
        L83:
            r7 = move-exception
            r1 = r0
            r2 = r1
            goto La1
        L87:
            r7 = move-exception
            r6 = r0
            r2 = r6
        L8a:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L98
            boolean r7 = r0.isValid()     // Catch: java.lang.Throwable -> Lb3
            if (r7 == 0) goto L98
            r0.release()     // Catch: java.io.IOException -> L98 java.lang.Throwable -> Lb3
        L98:
            com.xiaomi.push.C4408w.m16356a(r6)     // Catch: java.lang.Throwable -> Lb3
            goto L73
        L9c:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lb3
            return
        L9e:
            r7 = move-exception
            r1 = r0
        La0:
            r0 = r6
        La1:
            if (r1 == 0) goto Lac
            boolean r6 = r1.isValid()     // Catch: java.lang.Throwable -> Lb3
            if (r6 == 0) goto Lac
            r1.release()     // Catch: java.io.IOException -> Lac java.lang.Throwable -> Lb3
        Lac:
            com.xiaomi.push.C4408w.m16356a(r0)     // Catch: java.lang.Throwable -> Lb3
            com.xiaomi.push.C4408w.m16356a(r2)     // Catch: java.lang.Throwable -> Lb3
            throw r7     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            r6 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lb3
            throw r6
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.AbstractC4164dl.m14298a(android.content.Context, com.xiaomi.push.gn, java.lang.String):void");
    }
}
