package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.cloudwalk.FaceInterface;
import com.vivo.push.p232b.C3829a;
import com.vivo.push.p232b.C3830b;
import com.vivo.push.p232b.C3831c;
import com.vivo.push.p232b.C3835g;
import com.vivo.push.p232b.C3842n;
import com.vivo.push.p232b.C3854z;
import com.vivo.push.p237f.AbstractC3882aa;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C3987ad;
import com.vivo.push.util.C3990ag;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.m */
/* loaded from: classes2.dex */
public final class C3924m {

    /* renamed from: a */
    private static volatile C3924m f14069a;

    /* renamed from: h */
    private Context f14076h;

    /* renamed from: j */
    private String f14078j;

    /* renamed from: m */
    private Boolean f14081m;

    /* renamed from: n */
    private Long f14082n;

    /* renamed from: o */
    private boolean f14083o;

    /* renamed from: q */
    private int f14085q;

    /* renamed from: b */
    private long f14070b = -1;

    /* renamed from: c */
    private long f14071c = -1;

    /* renamed from: d */
    private long f14072d = -1;

    /* renamed from: e */
    private long f14073e = -1;

    /* renamed from: f */
    private long f14074f = -1;

    /* renamed from: g */
    private long f14075g = -1;

    /* renamed from: i */
    private boolean f14077i = true;

    /* renamed from: k */
    private SparseArray<a> f14079k = new SparseArray<>();

    /* renamed from: l */
    private int f14080l = 0;

    /* renamed from: p */
    private IPushClientFactory f14084p = new C3923l();

    private C3924m() {
    }

    /* renamed from: c */
    public static List<String> m13026c() {
        String mo13125g = C3932a.m13069a().m13074e().mo13125g();
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            C3932a.m13069a().m13074e().mo13126h();
            arrayList.clear();
            C4010u.m13309d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(mo13125g)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(mo13125g).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    /* renamed from: l */
    private boolean m13028l() {
        if (this.f14081m == null) {
            this.f14081m = Boolean.valueOf(m13052k() >= 1230 && C3990ag.m13223d(this.f14076h));
        }
        return this.f14081m.booleanValue();
    }

    /* renamed from: d */
    public final boolean m13045d() {
        if (this.f14076h == null) {
            C4010u.m13309d("PushClientManager", "support:context is null");
            return false;
        }
        this.f14081m = Boolean.valueOf(m13028l());
        return this.f14081m.booleanValue();
    }

    /* renamed from: e */
    public final void m13046e() {
        this.f14078j = null;
        C3932a.m13069a().m13074e().mo13128j();
    }

    /* renamed from: f */
    public final boolean m13047f() {
        return this.f14083o;
    }

    /* renamed from: g */
    public final boolean m13048g() {
        return this.f14077i;
    }

    /* renamed from: h */
    public final Context m13049h() {
        return this.f14076h;
    }

    /* renamed from: i */
    public final String m13050i() {
        return this.f14078j;
    }

    /* renamed from: j */
    public final int m13051j() {
        return this.f14085q;
    }

    /* renamed from: k */
    public final long m13052k() {
        Context context = this.f14076h;
        if (context == null) {
            return -1L;
        }
        if (this.f14082n == null) {
            this.f14082n = Long.valueOf(C3990ag.m13206a(context));
        }
        return this.f14082n.longValue();
    }

    /* renamed from: a */
    public static synchronized C3924m m13016a() {
        C3924m c3924m;
        synchronized (C3924m.class) {
            if (f14069a == null) {
                f14069a = new C3924m();
            }
            c3924m = f14069a;
        }
        return c3924m;
    }

    /* renamed from: b */
    protected final void m13039b() throws VivoPushException {
        Context context = this.f14076h;
        if (context != null) {
            C3990ag.m13219b(context);
        }
    }

    /* renamed from: b */
    public static void m13025b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String mo13125g = C3932a.m13069a().m13074e().mo13125g();
            if (TextUtils.isEmpty(mo13125g)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(mo13125g);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                C3932a.m13069a().m13074e().mo13126h();
            } else {
                C3932a.m13069a().m13074e().mo13121d(jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            C3932a.m13069a().m13074e().mo13126h();
        }
    }

    /* compiled from: PushClientManager.java */
    /* renamed from: com.vivo.push.m$a */
    public static class a {

        /* renamed from: a */
        private IPushActionListener f14086a;

        /* renamed from: b */
        private C3831c f14087b;

        /* renamed from: c */
        private IPushActionListener f14088c;

        /* renamed from: d */
        private Runnable f14089d;

        /* renamed from: e */
        private Object[] f14090e;

        public a(C3831c c3831c, IPushActionListener iPushActionListener) {
            this.f14087b = c3831c;
            this.f14086a = iPushActionListener;
        }

        /* renamed from: a */
        public final void m13054a(int i2, Object... objArr) {
            this.f14090e = objArr;
            IPushActionListener iPushActionListener = this.f14088c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i2);
            }
            IPushActionListener iPushActionListener2 = this.f14086a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i2);
            }
        }

        /* renamed from: b */
        public final Object[] m13057b() {
            return this.f14090e;
        }

        /* renamed from: a */
        public final void m13056a(Runnable runnable) {
            this.f14089d = runnable;
        }

        /* renamed from: a */
        public final void m13053a() {
            Runnable runnable = this.f14089d;
            if (runnable == null) {
                C4010u.m13292a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        /* renamed from: a */
        public final void m13055a(IPushActionListener iPushActionListener) {
            this.f14088c = iPushActionListener;
        }
    }

    /* renamed from: a */
    public final synchronized void m13030a(Context context) {
        if (this.f14076h == null) {
            this.f14076h = ContextDelegate.getContext(context);
            this.f14083o = C3984aa.m13187c(context, context.getPackageName());
            C3987ad.m13198b().m13200a(this.f14076h);
            m13032a(new C3835g());
            this.f14078j = C3932a.m13069a().m13074e().mo13127i();
        }
    }

    /* renamed from: c */
    public final void m13044c(List<String> list) {
        if (list.contains(this.f14078j)) {
            m13046e();
        }
    }

    /* renamed from: a */
    public static void m13020a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String mo13125g = C3932a.m13069a().m13074e().mo13125g();
            if (TextUtils.isEmpty(mo13125g)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(mo13125g);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                C3932a.m13069a().m13074e().mo13126h();
            } else {
                C3932a.m13069a().m13074e().mo13121d(jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            C3932a.m13069a().m13074e().mo13126h();
        }
    }

    /* renamed from: c */
    public final void m13043c(IPushActionListener iPushActionListener, String str, String str2) {
        m13018a(iPushActionListener, str, str2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13027c(String str) {
        C3975t.m13169a(new RunnableC3931r(this, str));
    }

    /* renamed from: b */
    public final void m13040b(IPushActionListener iPushActionListener, String str, String str2) {
        m13018a(iPushActionListener, str, str2, 11);
    }

    /* renamed from: b */
    final void m13041b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f14076h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f14078j)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!m13021a(this.f14073e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.f14083o) {
            if (!m13028l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(C3932a.m13069a().m13077h().mo13011b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C3829a c3829a = new C3829a(false, this.f14076h.getPackageName(), arrayList);
        c3829a.m12837b(100);
        c3829a.m12839c(str2);
        c3829a.m12841d(str3);
        this.f14073e = SystemClock.elapsedRealtime();
        String m13017a = m13017a(new a(c3829a, iPushActionListener));
        c3829a.m12838b(m13017a);
        m13032a(c3829a);
        m13027c(m13017a);
    }

    /* renamed from: a */
    protected final void m13038a(boolean z) {
        this.f14077i = z;
    }

    /* renamed from: a */
    final void m13031a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f14076h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (m13022a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        C3932a.m13069a().m13077h().mo13011b();
        if (!m13021a(this.f14070b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f14070b = SystemClock.elapsedRealtime();
        String packageName = this.f14076h.getPackageName();
        a aVar = null;
        if (this.f14076h != null) {
            C3830b c3830b = new C3830b(true, packageName);
            c3830b.m12842e();
            c3830b.m12839c(str);
            c3830b.m12841d(str2);
            c3830b.m12837b(100);
            if (this.f14083o) {
                if (m13028l()) {
                    aVar = m13015a(c3830b, iPushActionListener);
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else {
                aVar = m13015a(c3830b, iPushActionListener);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.m13055a(new C3927n(this, aVar, str, str2));
        aVar.m13053a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized a m13024b(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.f14079k.get(parseInt);
                this.f14079k.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    final void m13042b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f14076h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!m13021a(this.f14075g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f14075g = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_NO_FACE);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_ROI_ERR);
                    return;
                }
                return;
            }
        }
        if (this.f14083o) {
            if (!m13028l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(C3932a.m13069a().m13077h().mo13011b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_UNSUPPORT_FORMAT_ERR);
                    return;
                }
                return;
            }
        }
        C3854z c3854z = new C3854z(false, this.f14076h.getPackageName(), arrayList);
        c3854z.m12837b(500);
        c3854z.m12839c(str);
        c3854z.m12841d(str2);
        String m13017a = m13017a(new a(c3854z, iPushActionListener));
        c3854z.m12838b(m13017a);
        m13032a(c3854z);
        m13027c(m13017a);
    }

    /* renamed from: a */
    private a m13015a(C3830b c3830b, IPushActionListener iPushActionListener) {
        a aVar = new a(c3830b, iPushActionListener);
        String m13017a = m13017a(aVar);
        c3830b.m12838b(m13017a);
        aVar.m13056a(new RunnableC3928o(this, c3830b, m13017a));
        return aVar;
    }

    /* renamed from: a */
    private void m13018a(IPushActionListener iPushActionListener, String str, String str2, int i2) {
        if (this.f14076h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (m13022a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else if (!m13021a(this.f14071c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f14071c = SystemClock.elapsedRealtime();
            a m13014a = m13014a(iPushActionListener, this.f14076h.getPackageName(), str, str2, i2);
            if (m13014a == null) {
                return;
            }
            m13014a.m13055a(new C3929p(this));
            m13014a.m13053a();
        }
    }

    /* renamed from: a */
    private a m13014a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i2) {
        if (this.f14076h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        C3830b c3830b = new C3830b(false, str);
        c3830b.m12839c(str2);
        c3830b.m12841d(str3);
        if (i2 > 0) {
            c3830b.m12835a(i2);
        }
        c3830b.m12842e();
        c3830b.m12837b(100);
        if (this.f14083o) {
            if (!m13028l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(c3830b, iPushActionListener);
            String m13017a = m13017a(aVar);
            c3830b.m12838b(m13017a);
            aVar.m13056a(new RunnableC3930q(this, c3830b, m13017a));
            return aVar;
        }
        if (c3830b.m12836a(this.f14076h) == 2) {
            return m13015a(c3830b, iPushActionListener);
        }
        return m13015a(c3830b, iPushActionListener);
    }

    /* renamed from: a */
    public final void m13035a(String str, int i2, Object... objArr) {
        a m13024b = m13024b(str);
        if (m13024b != null) {
            m13024b.m13054a(i2, objArr);
        } else {
            C4010u.m13309d("PushClientManager", "notifyApp token is null");
        }
    }

    /* renamed from: a */
    final void m13036a(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f14076h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.f14078j) && this.f14078j.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!m13021a(this.f14072d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.f14083o) {
            if (!m13028l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(C3932a.m13069a().m13077h().mo13011b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C3829a c3829a = new C3829a(true, this.f14076h.getPackageName(), arrayList);
        c3829a.m12837b(100);
        c3829a.m12839c(str2);
        c3829a.m12841d(str3);
        this.f14072d = SystemClock.elapsedRealtime();
        String m13017a = m13017a(new a(c3829a, iPushActionListener));
        c3829a.m12838b(m13017a);
        m13032a(c3829a);
        m13027c(m13017a);
    }

    /* renamed from: a */
    private static boolean m13021a(long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j2 == -1 || elapsedRealtime <= j2 || elapsedRealtime >= j2 + 2000;
    }

    /* renamed from: a */
    private static boolean m13022a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* renamed from: a */
    public final void m13033a(String str) {
        this.f14078j = str;
        C3932a.m13069a().m13074e().mo13123e(str);
    }

    /* renamed from: a */
    public final void m13034a(String str, int i2) {
        a m13024b = m13024b(str);
        if (m13024b != null) {
            m13024b.m13054a(i2, new Object[0]);
        } else {
            C4010u.m13309d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    /* renamed from: a */
    private synchronized String m13017a(a aVar) {
        int i2;
        this.f14079k.put(this.f14080l, aVar);
        i2 = this.f14080l;
        this.f14080l = i2 + 1;
        return Integer.toString(i2);
    }

    /* renamed from: a */
    final void m13037a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f14076h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!m13021a(this.f14074f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f14074f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_NO_FACE);
                return;
            }
            return;
        }
        if (arrayList.size() + m13026c().size() > 500) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_MINMAX_ERR);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_ROI_ERR);
                    return;
                }
                return;
            }
        }
        if (this.f14083o) {
            if (!m13028l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(C3932a.m13069a().m13077h().mo13011b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_UNSUPPORT_FORMAT_ERR);
                    return;
                }
                return;
            }
        }
        C3854z c3854z = new C3854z(true, this.f14076h.getPackageName(), arrayList);
        c3854z.m12837b(500);
        c3854z.m12839c(str);
        c3854z.m12841d(str2);
        String m13017a = m13017a(new a(c3854z, iPushActionListener));
        c3854z.m12838b(m13017a);
        m13032a(c3854z);
        m13027c(m13017a);
    }

    /* renamed from: a */
    public final int m13029a(Intent intent, PushMessageCallback pushMessageCallback) {
        AbstractC4016v createReceiverCommand = this.f14084p.createReceiverCommand(intent);
        Context context = m13016a().f14076h;
        if (createReceiverCommand == null) {
            C4010u.m13292a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            C4010u.m13308c(context, "[执行指令失败]指令空！");
            return 2805;
        }
        AbstractC3882aa createReceiveTask = this.f14084p.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            C4010u.m13292a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            C4010u.m13308c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
            return 2806;
        }
        if (context != null && !(createReceiverCommand instanceof C3842n)) {
            C4010u.m13297a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.m12955a(pushMessageCallback);
        createReceiveTask.run();
        return createReceiveTask.m12958c();
    }

    /* renamed from: a */
    public final void m13032a(AbstractC4016v abstractC4016v) {
        Context context = m13016a().f14076h;
        if (abstractC4016v == null) {
            C4010u.m13292a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                C4010u.m13308c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        AbstractRunnableC3971s createTask = this.f14084p.createTask(abstractC4016v);
        if (createTask == null) {
            C4010u.m13292a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(abstractC4016v)));
            if (context != null) {
                C4010u.m13308c(context, "[执行指令失败]指令" + abstractC4016v + "任务空！");
                return;
            }
            return;
        }
        C4010u.m13309d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(abstractC4016v)));
        C3975t.m13168a(createTask);
    }
}
