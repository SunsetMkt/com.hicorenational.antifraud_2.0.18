package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bz;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: IdTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static final long a = 86400000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f7712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f7713c = at.b().b("id");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Object f7714j = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f7715d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7717f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f7720i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f7716e = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f7719h = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f7718g = 86400000;

    /* JADX INFO: compiled from: IdTracker.java */
    public static class a {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<String> f7721b = new HashSet();

        public a(Context context) {
            this.a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f7721b.contains(str);
        }

        public synchronized void b(String str) {
            this.f7721b.add(str);
        }

        public void c(String str) {
            this.f7721b.remove(str);
        }

        public synchronized void a() {
            if (!this.f7721b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.f7721b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] strArrSplit;
            String string = PreferenceWrapper.getDefault(this.a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f7721b.add(str);
                    }
                }
            }
        }
    }

    e(Context context) {
        this.f7720i = null;
        this.f7715d = new File(context.getFilesDir(), f7713c);
        this.f7720i = new a(context);
        this.f7720i.b();
    }

    public static synchronized void a() {
        if (f7712b != null) {
            f7712b.e();
            f7712b = null;
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f7719h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    map.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(map);
        synchronized (this) {
            this.f7716e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f7714j) {
            if (!this.f7715d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f7715d);
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
            try {
                try {
                    byte[] streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                    new bt().a(cVar, streamToByteArray);
                    HelperUtils.safeClose(fileInputStream);
                    return cVar;
                } catch (Throwable th3) {
                    th = th3;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                HelperUtils.safeClose(fileInputStream);
                return null;
            }
        }
    }

    public synchronized void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f7717f >= this.f7718g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f7719h) {
                if (aVar.c() && aVar.a()) {
                    z = true;
                    if (!aVar.c()) {
                        this.f7720i.b(aVar.b());
                    }
                }
            }
            if (z) {
                h();
                this.f7720i.a();
                g();
            }
            this.f7717f = jCurrentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f7716e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (f7712b == null) {
            return;
        }
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f7719h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.f7716e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c cVarI = i();
        if (cVarI == null) {
            return;
        }
        a(cVarI);
        ArrayList arrayList = new ArrayList(this.f7719h.size());
        synchronized (this) {
            this.f7716e = cVarI;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f7719h) {
                aVar.a(this.f7716e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f7719h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            h();
        }
    }

    public synchronized void g() {
        if (this.f7716e != null) {
            b(this.f7716e);
        }
    }

    public static synchronized e a(Context context) {
        if (f7712b == null) {
            f7712b = new e(context);
            f7712b.a(new f(context));
            f7712b.a(new b(context));
            f7712b.a(new j(context));
            f7712b.a(new d(context));
            f7712b.a(new c(context));
            f7712b.a(new g(context));
            f7712b.a(new i());
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                f7712b.a(new h(context));
            }
            f7712b.f();
        }
        return f7712b;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] bArrA;
        synchronized (f7714j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        bArrA = new bz().a(cVar);
                    }
                    if (bArrA != null) {
                        HelperUtils.writeFile(this.f7715d, bArrA);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f7720i.a(aVar.b())) {
            return this.f7719h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j2) {
        this.f7718g = j2;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.a) == null) {
            return;
        }
        if (map.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_MAC) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f7856h)) {
            cVar.a.remove(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        }
        if (cVar.a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f7855g)) {
            cVar.a.remove("imei");
        }
        if (cVar.a.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f7857i)) {
            cVar.a.remove(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        }
        if (cVar.a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f7858j)) {
            cVar.a.remove("serial");
        }
        if (cVar.a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
            cVar.a.remove("idfa");
        }
        if (!cVar.a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.a.remove("oaid");
    }
}
