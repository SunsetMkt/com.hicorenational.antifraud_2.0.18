package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.cloudwalk.FaceInterface;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.ad;
import com.vivo.push.util.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private static volatile m a;

    /* JADX INFO: renamed from: h */
    private Context f8553h;

    /* JADX INFO: renamed from: j */
    private String f8555j;

    /* JADX INFO: renamed from: m */
    private Boolean f8558m;

    /* JADX INFO: renamed from: n */
    private Long f8559n;
    private boolean o;
    private int q;

    /* JADX INFO: renamed from: b */
    private long f8547b = -1;

    /* JADX INFO: renamed from: c */
    private long f8548c = -1;

    /* JADX INFO: renamed from: d */
    private long f8549d = -1;

    /* JADX INFO: renamed from: e */
    private long f8550e = -1;

    /* JADX INFO: renamed from: f */
    private long f8551f = -1;

    /* JADX INFO: renamed from: g */
    private long f8552g = -1;

    /* JADX INFO: renamed from: i */
    private boolean f8554i = true;

    /* JADX INFO: renamed from: k */
    private SparseArray<a> f8556k = new SparseArray<>();

    /* JADX INFO: renamed from: l */
    private int f8557l = 0;
    private IPushClientFactory p = new l();

    private m() {
    }

    public static List<String> c() {
        String strG = com.vivo.push.restructure.a.a().e().g();
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(strG)) {
                return arrayList;
            }
            Iterator<String> itKeys = new JSONObject(strG).keys();
            while (itKeys.hasNext()) {
                arrayList.add(itKeys.next());
            }
        } catch (JSONException unused) {
            com.vivo.push.restructure.a.a().e().h();
            arrayList.clear();
            com.vivo.push.util.u.d("PushClientManager", "getTags error");
        }
        return arrayList;
    }

    private boolean l() {
        if (this.f8558m == null) {
            this.f8558m = Boolean.valueOf(k() >= 1230 && ag.d(this.f8553h));
        }
        return this.f8558m.booleanValue();
    }

    public final boolean d() {
        if (this.f8553h == null) {
            com.vivo.push.util.u.d("PushClientManager", "support:context is null");
            return false;
        }
        this.f8558m = Boolean.valueOf(l());
        return this.f8558m.booleanValue();
    }

    public final void e() {
        this.f8555j = null;
        com.vivo.push.restructure.a.a().e().j();
    }

    public final boolean f() {
        return this.o;
    }

    public final boolean g() {
        return this.f8554i;
    }

    public final Context h() {
        return this.f8553h;
    }

    public final String i() {
        return this.f8555j;
    }

    public final int j() {
        return this.q;
    }

    public final long k() {
        Context context = this.f8553h;
        if (context == null) {
            return -1L;
        }
        if (this.f8559n == null) {
            this.f8559n = Long.valueOf(ag.a(context));
        }
        return this.f8559n.longValue();
    }

    public static synchronized m a() {
        if (a == null) {
            a = new m();
        }
        return a;
    }

    protected final void b() throws VivoPushException {
        Context context = this.f8553h;
        if (context != null) {
            ag.b(context);
        }
    }

    public static void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String strG = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(string)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(string);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    /* JADX INFO: compiled from: PushClientManager.java */
    public static class a {
        private IPushActionListener a;

        /* JADX INFO: renamed from: b */
        private com.vivo.push.b.c f8560b;

        /* JADX INFO: renamed from: c */
        private IPushActionListener f8561c;

        /* JADX INFO: renamed from: d */
        private Runnable f8562d;

        /* JADX INFO: renamed from: e */
        private Object[] f8563e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f8560b = cVar;
            this.a = iPushActionListener;
        }

        public final void a(int i2, Object... objArr) {
            this.f8563e = objArr;
            IPushActionListener iPushActionListener = this.f8561c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i2);
            }
            IPushActionListener iPushActionListener2 = this.a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i2);
            }
        }

        public final Object[] b() {
            return this.f8563e;
        }

        public final void a(Runnable runnable) {
            this.f8562d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f8562d;
            if (runnable == null) {
                com.vivo.push.util.u.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f8561c = iPushActionListener;
        }
    }

    public final synchronized void a(Context context) {
        if (this.f8553h == null) {
            this.f8553h = ContextDelegate.getContext(context);
            this.o = com.vivo.push.util.aa.c(context, context.getPackageName());
            ad.b().a(this.f8553h);
            a(new com.vivo.push.b.g());
            this.f8555j = com.vivo.push.restructure.a.a().e().i();
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.f8555j)) {
            e();
        }
    }

    public static void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String strG = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), System.currentTimeMillis());
            }
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(string)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(string);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    public final void c(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 1);
    }

    public void c(String str) {
        t.a(new r(this, str));
    }

    public final void b(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 11);
    }

    final void b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f8553h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f8555j)) {
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
        if (!a(this.f8550e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f8553h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f8550e = SystemClock.elapsedRealtime();
        String strA = a(new a(aVar, iPushActionListener));
        aVar.b(strA);
        a(aVar);
        c(strA);
    }

    protected final void a(boolean z) {
        this.f8554i = z;
    }

    final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f8553h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        com.vivo.push.restructure.a.a().h().b();
        if (!a(this.f8547b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f8547b = SystemClock.elapsedRealtime();
        String packageName = this.f8553h.getPackageName();
        a aVarA = null;
        if (this.f8553h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.e();
            bVar.c(str);
            bVar.d(str2);
            bVar.b(100);
            if (!this.o || l()) {
                aVarA = a(bVar, iPushActionListener);
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVarA == null) {
            return;
        }
        aVarA.a(new n(this, aVarA, str, str2));
        aVarA.a();
    }

    public synchronized a b(String str) {
        if (str != null) {
            try {
                int i2 = Integer.parseInt(str);
                a aVar = this.f8556k.get(i2);
                this.f8556k.delete(i2);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    final void b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f8553h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f8552g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f8552g = SystemClock.elapsedRealtime();
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
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_UNSUPPORT_FORMAT_ERR);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, this.f8553h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String strA = a(new a(zVar, iPushActionListener));
        zVar.b(strA);
        a(zVar);
        c(strA);
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String strA = a(aVar);
        bVar.b(strA);
        aVar.a(new o(this, bVar, strA));
        return aVar;
    }

    private void a(IPushActionListener iPushActionListener, String str, String str2, int i2) {
        if (this.f8553h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else if (!a(this.f8548c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f8548c = SystemClock.elapsedRealtime();
            a aVarA = a(iPushActionListener, this.f8553h.getPackageName(), str, str2, i2);
            if (aVarA == null) {
                return;
            }
            aVarA.a(new p(this));
            aVarA.a();
        }
    }

    private a a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i2) {
        if (this.f8553h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, str);
        bVar.c(str2);
        bVar.d(str3);
        if (i2 > 0) {
            bVar.a(i2);
        }
        bVar.e();
        bVar.b(100);
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(bVar, iPushActionListener);
            String strA = a(aVar);
            bVar.b(strA);
            aVar.a(new q(this, bVar, strA));
            return aVar;
        }
        if (bVar.a(this.f8553h) == 2) {
            return a(bVar, iPushActionListener);
        }
        return a(bVar, iPushActionListener);
    }

    public final void a(String str, int i2, Object... objArr) {
        a aVarB = b(str);
        if (aVarB != null) {
            aVarB.a(i2, objArr);
        } else {
            com.vivo.push.util.u.d("PushClientManager", "notifyApp token is null");
        }
    }

    final void a(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f8553h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.f8555j) && this.f8555j.equals(str)) {
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
        if (!a(this.f8549d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f8553h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f8549d = SystemClock.elapsedRealtime();
        String strA = a(new a(aVar, iPushActionListener));
        aVar.b(strA);
        a(aVar);
        c(strA);
    }

    private static boolean a(long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return j2 == -1 || jElapsedRealtime <= j2 || jElapsedRealtime >= j2 + 2000;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public final void a(String str) {
        this.f8555j = str;
        com.vivo.push.restructure.a.a().e().e(str);
    }

    public final void a(String str, int i2) {
        a aVarB = b(str);
        if (aVarB != null) {
            aVarB.a(i2, new Object[0]);
        } else {
            com.vivo.push.util.u.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i2;
        this.f8556k.put(this.f8557l, aVar);
        i2 = this.f8557l;
        this.f8557l = i2 + 1;
        return Integer.toString(i2);
    }

    final void a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f8553h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f8551f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f8551f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_NO_FACE);
                return;
            }
            return;
        }
        if (arrayList.size() + c().size() > 500) {
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
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_UNSUPPORT_FORMAT_ERR);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, this.f8553h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String strA = a(new a(zVar, iPushActionListener));
        zVar.b(strA);
        a(zVar);
        c(strA);
    }

    public final int a(Intent intent, PushMessageCallback pushMessageCallback) {
        v vVarCreateReceiverCommand = this.p.createReceiverCommand(intent);
        Context context = a().f8553h;
        if (vVarCreateReceiverCommand == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            com.vivo.push.util.u.c(context, "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4\u7a7a\uff01");
            return 2805;
        }
        com.vivo.push.f.aa aaVarCreateReceiveTask = this.p.createReceiveTask(vVarCreateReceiverCommand);
        if (aaVarCreateReceiveTask == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVarCreateReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            com.vivo.push.util.u.c(context, "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4" + vVarCreateReceiverCommand + "\u4efb\u52a1\u7a7a\uff01");
            return 2806;
        }
        if (context != null && !(vVarCreateReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.u.a(context, "[\u63a5\u6536\u6307\u4ee4]".concat(String.valueOf(vVarCreateReceiverCommand)));
        }
        aaVarCreateReceiveTask.a(pushMessageCallback);
        aaVarCreateReceiveTask.run();
        return aaVarCreateReceiveTask.c();
    }

    public final void a(v vVar) {
        Context context = a().f8553h;
        if (vVar == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.u.c(context, "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4\u7a7a\uff01");
                return;
            }
            return;
        }
        s sVarCreateTask = this.p.createTask(vVar);
        if (sVarCreateTask == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVar)));
            if (context != null) {
                com.vivo.push.util.u.c(context, "[\u6267\u884c\u6307\u4ee4\u5931\u8d25]\u6307\u4ee4" + vVar + "\u4efb\u52a1\u7a7a\uff01");
                return;
            }
            return;
        }
        com.vivo.push.util.u.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(vVar)));
        t.a(sVarCreateTask);
    }
}
