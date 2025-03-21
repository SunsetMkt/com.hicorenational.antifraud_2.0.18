package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3336at;
import com.umeng.analytics.pro.C3363bt;
import com.umeng.analytics.pro.C3369bz;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.proto.C3523a;
import com.umeng.commonsdk.statistics.proto.C3524b;
import com.umeng.commonsdk.statistics.proto.C3525c;
import com.umeng.commonsdk.utils.C3531d;
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

/* compiled from: IdTracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.e */
/* loaded from: classes2.dex */
public class C3505e {

    /* renamed from: a */
    public static final long f12784a = 86400000;

    /* renamed from: b */
    public static C3505e f12785b;

    /* renamed from: c */
    private static final String f12786c = C3336at.m10865b().m10868b("id");

    /* renamed from: j */
    private static Object f12787j = new Object();

    /* renamed from: d */
    private File f12788d;

    /* renamed from: f */
    private long f12790f;

    /* renamed from: i */
    private a f12793i;

    /* renamed from: e */
    private C3525c f12789e = null;

    /* renamed from: h */
    private Set<AbstractC3501a> f12792h = new HashSet();

    /* renamed from: g */
    private long f12791g = 86400000;

    /* compiled from: IdTracker.java */
    /* renamed from: com.umeng.commonsdk.statistics.idtracking.e$a */
    public static class a {

        /* renamed from: a */
        private Context f12794a;

        /* renamed from: b */
        private Set<String> f12795b = new HashSet();

        public a(Context context) {
            this.f12794a = context;
        }

        /* renamed from: a */
        public synchronized boolean m11871a(String str) {
            return !this.f12795b.contains(str);
        }

        /* renamed from: b */
        public synchronized void m11873b(String str) {
            this.f12795b.add(str);
        }

        /* renamed from: c */
        public void m11874c(String str) {
            this.f12795b.remove(str);
        }

        /* renamed from: a */
        public synchronized void m11870a() {
            if (!this.f12795b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.f12795b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f12794a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        /* renamed from: b */
        public synchronized void m11872b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f12794a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f12795b.add(str);
                    }
                }
            }
        }
    }

    C3505e(Context context) {
        this.f12793i = null;
        this.f12788d = new File(context.getFilesDir(), f12786c);
        this.f12793i = new a(context);
        this.f12793i.m11872b();
    }

    /* renamed from: a */
    public static synchronized void m11857a() {
        synchronized (C3505e.class) {
            if (f12785b != null) {
                f12785b.m11867e();
                f12785b = null;
            }
        }
    }

    /* renamed from: h */
    private synchronized void m11861h() {
        C3525c c3525c = new C3525c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (AbstractC3501a abstractC3501a : this.f12792h) {
            if (abstractC3501a.m11852c()) {
                if (abstractC3501a.m11853d() != null) {
                    hashMap.put(abstractC3501a.m11851b(), abstractC3501a.m11853d());
                }
                if (abstractC3501a.m11854e() != null && !abstractC3501a.m11854e().isEmpty()) {
                    arrayList.addAll(abstractC3501a.m11854e());
                }
            }
        }
        c3525c.m11986a(arrayList);
        c3525c.m11987a(hashMap);
        synchronized (this) {
            this.f12789e = c3525c;
        }
    }

    /* renamed from: i */
    private C3525c m11862i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f12787j) {
            if (!this.f12788d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f12788d);
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
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    C3525c c3525c = new C3525c();
                    new C3363bt().m11061a(c3525c, readStreamToByteArray);
                    HelperUtils.safeClose(fileInputStream);
                    return c3525c;
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

    /* renamed from: b */
    public synchronized void m11864b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f12790f >= this.f12791g) {
            boolean z = false;
            for (AbstractC3501a abstractC3501a : this.f12792h) {
                if (abstractC3501a.m11852c() && abstractC3501a.m11850a()) {
                    z = true;
                    if (!abstractC3501a.m11852c()) {
                        this.f12793i.m11873b(abstractC3501a.m11851b());
                    }
                }
            }
            if (z) {
                m11861h();
                this.f12793i.m11870a();
                m11869g();
            }
            this.f12790f = currentTimeMillis;
        }
    }

    /* renamed from: c */
    public synchronized C3525c m11865c() {
        return this.f12789e;
    }

    /* renamed from: d */
    public String m11866d() {
        return null;
    }

    /* renamed from: e */
    public synchronized void m11867e() {
        if (f12785b == null) {
            return;
        }
        boolean z = false;
        for (AbstractC3501a abstractC3501a : this.f12792h) {
            if (abstractC3501a.m11852c() && abstractC3501a.m11854e() != null && !abstractC3501a.m11854e().isEmpty()) {
                abstractC3501a.m11849a((List<C3523a>) null);
                z = true;
            }
        }
        if (z) {
            this.f12789e.m11992b(false);
            m11869g();
        }
    }

    /* renamed from: f */
    public synchronized void m11868f() {
        C3525c m11862i = m11862i();
        if (m11862i == null) {
            return;
        }
        m11858a(m11862i);
        ArrayList arrayList = new ArrayList(this.f12792h.size());
        synchronized (this) {
            this.f12789e = m11862i;
            for (AbstractC3501a abstractC3501a : this.f12792h) {
                abstractC3501a.m11848a(this.f12789e);
                if (!abstractC3501a.m11852c()) {
                    arrayList.add(abstractC3501a);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f12792h.remove((AbstractC3501a) it.next());
            }
            m11861h();
        }
    }

    /* renamed from: g */
    public synchronized void m11869g() {
        if (this.f12789e != null) {
            m11860b(this.f12789e);
        }
    }

    /* renamed from: a */
    public static synchronized C3505e m11856a(Context context) {
        C3505e c3505e;
        synchronized (C3505e.class) {
            if (f12785b == null) {
                f12785b = new C3505e(context);
                f12785b.m11859a(new C3506f(context));
                f12785b.m11859a(new C3502b(context));
                f12785b.m11859a(new C3510j(context));
                f12785b.m11859a(new C3504d(context));
                f12785b.m11859a(new C3503c(context));
                f12785b.m11859a(new C3507g(context));
                f12785b.m11859a(new C3509i());
                if (FieldManager.allow(C3531d.f12959G)) {
                    f12785b.m11859a(new C3508h(context));
                }
                f12785b.m11868f();
            }
            c3505e = f12785b;
        }
        return c3505e;
    }

    /* renamed from: b */
    private void m11860b(C3525c c3525c) {
        byte[] m11073a;
        synchronized (f12787j) {
            if (c3525c != null) {
                try {
                    synchronized (this) {
                        m11858a(c3525c);
                        m11073a = new C3369bz().m11073a(c3525c);
                    }
                    if (m11073a != null) {
                        HelperUtils.writeFile(this.f12788d, m11073a);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m11859a(AbstractC3501a abstractC3501a) {
        if (this.f12793i.m11871a(abstractC3501a.m11851b())) {
            return this.f12792h.add(abstractC3501a);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.m11762w("invalid domain: " + abstractC3501a.m11851b());
        return false;
    }

    /* renamed from: a */
    public void m11863a(long j2) {
        this.f12791g = j2;
    }

    /* renamed from: a */
    private void m11858a(C3525c c3525c) {
        Map<String, C3524b> map;
        if (c3525c == null || (map = c3525c.f12880a) == null) {
            return;
        }
        if (map.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_MAC) && !FieldManager.allow(C3531d.f13006h)) {
            c3525c.f12880a.remove(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        }
        if (c3525c.f12880a.containsKey("imei") && !FieldManager.allow(C3531d.f13005g)) {
            c3525c.f12880a.remove("imei");
        }
        if (c3525c.f12880a.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) && !FieldManager.allow(C3531d.f13007i)) {
            c3525c.f12880a.remove(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        }
        if (c3525c.f12880a.containsKey("serial") && !FieldManager.allow(C3531d.f13008j)) {
            c3525c.f12880a.remove("serial");
        }
        if (c3525c.f12880a.containsKey("idfa") && !FieldManager.allow(C3531d.f13021w)) {
            c3525c.f12880a.remove("idfa");
        }
        if (!c3525c.f12880a.containsKey("oaid") || FieldManager.allow(C3531d.f12959G)) {
            return;
        }
        c3525c.f12880a.remove("oaid");
    }
}
