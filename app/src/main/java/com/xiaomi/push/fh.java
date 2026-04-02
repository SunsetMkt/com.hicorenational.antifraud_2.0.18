package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class fh extends fa {
    protected Exception a;

    /* JADX INFO: renamed from: a */
    protected Socket f514a;

    /* JADX INFO: renamed from: b */
    protected XMPushService f8974b;

    /* JADX INFO: renamed from: c */
    private int f8975c;

    /* JADX INFO: renamed from: c */
    String f515c;

    /* JADX INFO: renamed from: d */
    private String f8976d;

    /* JADX INFO: renamed from: e */
    protected volatile long f8977e;

    /* JADX INFO: renamed from: f */
    protected volatile long f8978f;

    /* JADX INFO: renamed from: g */
    protected volatile long f8979g;

    /* JADX INFO: renamed from: h */
    private long f8980h;

    /* JADX INFO: renamed from: com.xiaomi.push.fh$2 */
    class AnonymousClass2 extends XMPushService.j {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Exception f517a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f8982b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i2, int i3, Exception exc) {
            super(i2);
            i = i3;
            exc = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            fh.this.f8974b.a(i, exc);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "shutdown the connection. " + i + ", " + exc;
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.fh$3 */
    class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f518a;

        AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            cg.a().a(str, true);
        }
    }

    public fh(XMPushService xMPushService, fb fbVar) {
        super(xMPushService, fbVar);
        this.a = null;
        this.f515c = null;
        this.f8977e = 0L;
        this.f8978f = 0L;
        this.f8979g = 0L;
        this.f8980h = 0L;
        this.f8974b = xMPushService;
    }

    public Context a() {
        return this.f8974b;
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo404a(boolean z);

    @Override // com.xiaomi.push.fa
    public void b(boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        mo404a(z);
        com.xiaomi.push.service.m.a(this.f8974b).m726c();
        if (z) {
            return;
        }
        this.f8974b.a(new XMPushService.j(13) { // from class: com.xiaomi.push.fh.1
            final /* synthetic */ long a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ long f8981b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i2, long jElapsedRealtime2, long jCurrentTimeMillis2) {
                super(i2);
                j = jElapsedRealtime2;
                j = jCurrentTimeMillis2;
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                Thread.yield();
                if (!fh.this.m417c() || fh.this.a(j)) {
                    return;
                }
                com.xiaomi.push.service.m.a(fh.this.f8974b).m725b();
                fh.this.f8974b.a(22, (Exception) null);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "check the ping-pong." + j;
            }
        }, com.heytap.mcssdk.constant.a.q);
    }

    public String c() {
        return ((fa) this).f500a;
    }

    public synchronized void e() {
        try {
            if (!m417c() && !m416b()) {
                a(0, 0, (Exception) null);
                a(((fa) this).f497a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new fi(e2);
        }
    }

    public void f() {
        this.f8977e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f8978f = SystemClock.elapsedRealtime();
    }

    @Override // com.xiaomi.push.fa
    /* JADX INFO: renamed from: a */
    public String mo412a() {
        return this.f8976d;
    }

    public void c(int i2, Exception exc) {
        au.b();
        this.f8974b.a(new XMPushService.j(2) { // from class: com.xiaomi.push.fh.2

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Exception f517a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ int f8982b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(int i22, int i23, Exception exc2) {
                super(i22);
                i = i23;
                exc = exc2;
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                fh.this.f8974b.a(i, exc);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "shutdown the connection. " + i + ", " + exc;
            }
        });
    }

    protected synchronized void a(int i2, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i2, exc);
        ((fa) this).f500a = "";
        try {
            this.f514a.close();
        } catch (Throwable unused) {
        }
        this.f8977e = 0L;
        this.f8978f = 0L;
    }

    /* JADX INFO: renamed from: com.xiaomi.push.fh$1 */
    class AnonymousClass1 extends XMPushService.j {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ long f8981b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i2, long jElapsedRealtime2, long jCurrentTimeMillis2) {
            super(i2);
            j = jElapsedRealtime2;
            j = jCurrentTimeMillis2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            Thread.yield();
            if (!fh.this.m417c() || fh.this.a(j)) {
                return;
            }
            com.xiaomi.push.service.m.a(fh.this.f8974b).m725b();
            fh.this.f8974b.a(22, (Exception) null);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "check the ping-pong." + j;
        }
    }

    @Override // com.xiaomi.push.fa
    public void b(int i2, Exception exc) {
        a(i2, exc);
        if ((exc != null || i2 == 18) && this.f8979g != 0) {
            a(exc);
        }
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f8979g < 300000) {
            if (au.m149a((Context) this.f8974b)) {
                this.f8975c++;
                if (this.f8975c >= 2) {
                    String strMo412a = mo412a();
                    com.xiaomi.channel.commonutils.logger.b.m48a("max short conn time reached, sink down current host:" + strMo412a);
                    a(strMo412a, 0L, exc);
                    this.f8975c = 0;
                    return;
                }
                return;
            }
            return;
        }
        this.f8975c = 0;
    }

    protected void a(String str, long j2, Exception exc) {
        cc ccVarA = cg.a().a(fb.a(), false);
        if (ccVarA != null) {
            ccVarA.b(str, j2, 0L, exc);
            cg.a().m234c();
        }
    }

    @Override // com.xiaomi.push.fa
    public void a(er[] erVarArr) throws fi {
        throw new fi("Don't support send Blob");
    }

    private void a(fb fbVar) throws Throwable {
        a(fbVar.c(), fbVar.m418a());
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x033d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i2) throws Throwable {
        StringBuilder sb;
        long j2;
        int i3;
        String str2;
        boolean z;
        Iterator<String> it;
        String str3;
        cc ccVar;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        this.a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int iIntValue = com.xiaomi.channel.commonutils.logger.b.a("get bucket for host : " + str).intValue();
        cc ccVarA = a(str);
        com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(iIntValue));
        if (ccVarA != null) {
            arrayList = ccVarA.a(true);
        }
        cc ccVarD = cg.a().d(str);
        if (ccVarD != null) {
            for (String str9 : ccVarD.a(true)) {
                if (arrayList.indexOf(str9) == -1) {
                    arrayList.add(str9);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        long j3 = 0;
        this.f8979g = 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strM145a = au.m145a((Context) this.f8974b);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it2 = arrayList.iterator();
        String str10 = "";
        int i4 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ((fa) this).f495a++;
            int i5 = i4 + 1;
            try {
                com.xiaomi.channel.commonutils.logger.b.m48a("begin to connect to " + next);
                this.f514a = m423a();
                this.f514a.connect(ce.m223a(next, i2), 8000);
                com.xiaomi.channel.commonutils.logger.b.m48a("tcp connected");
                this.f514a.setTcpNoDelay(true);
                this.f8976d = next;
                mo424a();
                ((fa) this).f496a = System.currentTimeMillis() - jCurrentTimeMillis;
                ((fa) this).f505b = strM145a;
                if (ccVarA != null) {
                    it = it2;
                    sb = sb2;
                    str3 = strM145a;
                    z = true;
                    j2 = 0;
                    ccVar = ccVarA;
                    try {
                        ccVarA.b(next, ((fa) this).f496a, 0L);
                    } catch (Exception e2) {
                        e = e2;
                        str4 = str10;
                        str5 = str3;
                        try {
                            this.a = e;
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next);
                            sb.append(" port:");
                            sb.append(i2);
                            sb.append(" err:");
                            sb.append(this.a.getClass().getSimpleName());
                            sb.append("\n");
                            str2 = TextUtils.isEmpty(str4) ? next : str4 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + next;
                            ep.a(next, this.a);
                            if (ccVar != null) {
                                str7 = str5;
                                ccVar.b(next, System.currentTimeMillis() - jCurrentTimeMillis, 0L, this.a);
                            } else {
                                str7 = str5;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next);
                            sb.append(" port:");
                            sb.append(i2);
                            sb.append(" err:");
                            sb.append(this.a.getClass().getSimpleName());
                            sb.append("\n");
                            String str11 = TextUtils.isEmpty(str4) ? str4 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + next : next;
                            ep.a(next, this.a);
                            if (ccVar == null) {
                                str8 = str5;
                                ccVar.b(next, System.currentTimeMillis() - jCurrentTimeMillis, 0L, this.a);
                            } else {
                                str8 = str5;
                            }
                            if (!TextUtils.equals(str8, au.m145a((Context) this.f8974b))) {
                                throw th;
                            }
                            str2 = str11;
                            i3 = i5;
                            z = false;
                            cg.a().m234c();
                            int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (z) {
                            }
                        }
                        if (TextUtils.equals(str7, au.m145a((Context) this.f8974b))) {
                            str10 = str2;
                            sb2 = sb;
                            strM145a = str7;
                            i4 = i5;
                            it2 = it;
                            j3 = j2;
                            ccVarA = ccVar;
                        } else {
                            i3 = i5;
                            z = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            this.a = new Exception("abnormal exception", th);
                            com.xiaomi.channel.commonutils.logger.b.a(th);
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next);
                            sb.append(" port:");
                            sb.append(i2);
                            sb.append(" err:");
                            sb.append(this.a.getClass().getSimpleName());
                            sb.append("\n");
                            str2 = TextUtils.isEmpty(str10) ? next : str10 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + next;
                            ep.a(next, this.a);
                            if (ccVar != null) {
                                ccVar.b(next, System.currentTimeMillis() - jCurrentTimeMillis, 0L, this.a);
                            }
                            str6 = str3;
                        } catch (Throwable th3) {
                            th = th3;
                            str4 = str10;
                            str5 = str3;
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next);
                            sb.append(" port:");
                            sb.append(i2);
                            sb.append(" err:");
                            sb.append(this.a.getClass().getSimpleName());
                            sb.append("\n");
                            if (TextUtils.isEmpty(str4)) {
                            }
                            ep.a(next, this.a);
                            if (ccVar == null) {
                            }
                            if (!TextUtils.equals(str8, au.m145a((Context) this.f8974b))) {
                            }
                        }
                        if (TextUtils.equals(str6, au.m145a((Context) this.f8974b))) {
                            str7 = str6;
                            str10 = str2;
                            sb2 = sb;
                            strM145a = str7;
                            i4 = i5;
                            it2 = it;
                            j3 = j2;
                            ccVarA = ccVar;
                        } else {
                            i3 = i5;
                            z = false;
                        }
                    }
                } else {
                    it = it2;
                    sb = sb2;
                    str3 = strM145a;
                    ccVar = ccVarA;
                    z = true;
                    j2 = 0;
                }
                this.f8979g = SystemClock.elapsedRealtime();
                com.xiaomi.channel.commonutils.logger.b.m48a("connected to " + next + " in " + ((fa) this).f496a);
                str2 = str10;
                i3 = i5;
                break;
            } catch (Exception e3) {
                e = e3;
                it = it2;
                sb = sb2;
                ccVar = ccVarA;
                j2 = 0;
                str4 = str10;
                str5 = strM145a;
            } catch (Throwable th4) {
                th = th4;
                it = it2;
                sb = sb2;
                str3 = strM145a;
                ccVar = ccVarA;
                j2 = 0;
            }
        }
        sb = sb2;
        j2 = j3;
        i3 = i4;
        str2 = str10;
        z = false;
        cg.a().m234c();
        int iElapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - jElapsedRealtime);
        if (z) {
            if (this.f8980h == j2 || SystemClock.elapsedRealtime() - this.f8980h > 480000) {
                this.f8980h = SystemClock.elapsedRealtime();
                ep.a(0, ei.BATCH_TCP_CONN_FAIL.a(), iElapsedRealtime2, str2, au.b(this.f8974b.getApplicationContext()) ? 1 : 0);
            }
            throw new fi(sb.toString());
        }
        ep.a(0, ei.BATCH_TCP_CONN_SUCCESS.a(), iElapsedRealtime2, str2, i3);
    }

    /* JADX INFO: renamed from: a */
    protected synchronized void mo424a() {
    }

    /* JADX INFO: renamed from: a */
    public Socket m423a() {
        return new Socket();
    }

    cc a(String str) {
        cc ccVarA = cg.a().a(str, false);
        if (!ccVarA.b()) {
            fy.a(new Runnable() { // from class: com.xiaomi.push.fh.3

                /* JADX INFO: renamed from: a */
                final /* synthetic */ String f518a;

                AnonymousClass3(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    cg.a().a(str, true);
                }
            });
        }
        return ccVarA;
    }
}
