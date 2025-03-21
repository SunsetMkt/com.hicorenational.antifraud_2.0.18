package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4130ce;
import com.xiaomi.push.C4167do;
import com.xiaomi.push.C4194eo;
import com.xiaomi.push.C4195ep;
import com.xiaomi.push.C4408w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.service.z */
/* loaded from: classes2.dex */
public class C4404z {

    /* renamed from: a */
    private static final Pattern f16820a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: a */
    private static long f16818a = 0;

    /* renamed from: a */
    private static ThreadPoolExecutor f16819a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m16348b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            AbstractC4022b.m13347a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(C4130ce.m14062a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            AbstractC4022b.m13347a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            AbstractC4022b.m13361d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static void m16344a() {
        C4167do.a m16026a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f16819a.getActiveCount() <= 0 || currentTimeMillis - f16818a >= 1800000) && C4194eo.m14657a().m14664a() && (m16026a = C4372ax.m16017a().m16026a()) != null && m16026a.m14330e() > 0) {
            f16818a = currentTimeMillis;
            m16345a(m16026a.m14319a(), true);
        }
    }

    /* renamed from: a */
    public static void m16345a(final List<String> list, final boolean z) {
        f16819a.execute(new Runnable() { // from class: com.xiaomi.push.service.z.1
            @Override // java.lang.Runnable
            public void run() {
                boolean m16348b = C4404z.m16348b("www.baidu.com:80");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m16348b = m16348b || C4404z.m16348b((String) it.next());
                    if (m16348b && !z) {
                        break;
                    }
                }
                C4195ep.m14668a(m16348b ? 1 : 2);
            }
        });
    }

    /* renamed from: a */
    private static String m16343a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append("\n");
                    sb.append(readLine);
                } else {
                    String sb2 = sb.toString();
                    C4408w.m16356a(bufferedReader);
                    return sb2;
                }
            }
        } catch (Exception unused2) {
            C4408w.m16356a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            C4408w.m16356a(bufferedReader);
            throw th;
        }
    }

    /* renamed from: b */
    public static void m16347b() {
        String m16343a = m16343a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(m16343a)) {
            AbstractC4022b.m13347a("dump tcp for uid = " + Process.myUid());
            AbstractC4022b.m13347a(m16343a);
        }
        String m16343a2 = m16343a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(m16343a2)) {
            return;
        }
        AbstractC4022b.m13347a("dump tcp6 for uid = " + Process.myUid());
        AbstractC4022b.m13347a(m16343a2);
    }
}
