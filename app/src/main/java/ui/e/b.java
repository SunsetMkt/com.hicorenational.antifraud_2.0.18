package ui.e;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import j.c.a.e;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import network.http.SearchVirusAppArrayHttp;
import ui.Hicore;
import ui.activity.VirusKillingActivity;
import util.e2;
import util.s1;
import util.t1;
import util.x1;

/* JADX INFO: compiled from: ScanAppEngine.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final int t = 0;
    public static final int u = 1;
    private static b v;
    private final int a = 1;

    /* JADX INFO: renamed from: b */
    private final int f14097b = 2;

    /* JADX INFO: renamed from: c */
    private int f14098c = 200;

    /* JADX INFO: renamed from: d */
    private final int f14099d = 0;

    /* JADX INFO: renamed from: e */
    private final int f14100e = 1;

    /* JADX INFO: renamed from: f */
    private final int f14101f = 2;

    /* JADX INFO: renamed from: g */
    private final int f14102g = 3;

    /* JADX INFO: renamed from: h */
    private List<AppInfoBean> f14103h = null;

    /* JADX INFO: renamed from: i */
    private List<AppInfoBean> f14104i = null;

    /* JADX INFO: renamed from: j */
    private List<AppInfoBean> f14105j = null;

    /* JADX INFO: renamed from: k */
    private int f14106k = -1;

    /* JADX INFO: renamed from: l */
    private int f14107l = -1;

    /* JADX INFO: renamed from: m */
    private int f14108m = 0;

    /* JADX INFO: renamed from: n */
    private int f14109n = 0;
    private int o = 0;
    private ui.e.c p = null;
    private WeakReference<Context> q = null;
    private Handler r = null;
    private Runnable s = new RunnableC0290b();

    /* JADX INFO: compiled from: ScanAppEngine.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 != 1 && i2 != 2) {
                return false;
            }
            if (b.this.f14103h == null || b.this.f14103h.size() <= 0) {
                b.this.g();
                return false;
            }
            b.this.p.a(b.this.f14103h.size());
            b.this.f();
            return false;
        }
    }

    /* JADX INFO: renamed from: ui.e.b$b */
    /* JADX INFO: compiled from: ScanAppEngine.java */
    class RunnableC0290b implements Runnable {
        RunnableC0290b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f14105j != null && b.this.f14105j.size() > 0) {
                if (b.this.o != 1 && b.this.o != 3) {
                    b.this.p.a(null, (AppInfoBean) b.this.f14105j.get(0));
                    b.this.f14105j.remove(0);
                }
                b.this.r.postDelayed(b.this.s, b.this.f14098c);
                return;
            }
            if (b.this.p == null || b.this.o != 2) {
                b.this.r.postDelayed(b.this.s, b.this.f14098c);
            } else {
                b.this.o = 3;
                b.this.p.a();
            }
        }
    }

    /* JADX INFO: compiled from: ScanAppEngine.java */
    class c implements Runnable {
        final /* synthetic */ List a;

        c(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                try {
                    if (b.this.o == 3) {
                        return;
                    }
                    AppInfoBean appInfoBean = (AppInfoBean) this.a.get(i2);
                    if (TextUtils.isEmpty(appInfoBean.getAppMD5())) {
                        appInfoBean.setAppMD5(t1.a(new File(appInfoBean.getPkgPath())));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (b.this.o == 3) {
                return;
            }
            b.this.a((List<AppInfoBean>) this.a);
        }
    }

    /* JADX INFO: compiled from: ScanAppEngine.java */
    class d implements SearchVirusAppArrayHttp.Callback {
        final /* synthetic */ List a;

        d(List list) {
            this.a = list;
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalFail(@e String str) {
            if (b.this.o == 3) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = Hicore.getApp().getString(R.string.err_timeout);
            }
            e2.a(str);
            b.this.f14104i = this.a;
            b.this.o = 1;
            b.this.p.b();
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalRequestFinish(int i2, boolean z) {
            if (b.this.o == 3) {
                return;
            }
            if (z) {
                b bVar = b.this;
                bVar.a((List<AppInfoBean>) this.a, bVar.p);
                return;
            }
            s1.b("Finish mNextPosition-->" + b.this.f14107l);
            s1.b("Finish finalSubList-->" + new com.google.gson.e().a(this.a));
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalRiskResult(boolean z) {
            if (b.this.o == 3) {
                return;
            }
            s1.b("Risk mNextPosition-->" + b.this.f14107l);
            s1.b("Risk finalSubList-->" + new com.google.gson.e().a(this.a));
            b bVar = b.this;
            bVar.a((List<AppInfoBean>) this.a, bVar.p);
        }
    }

    private void d() {
        this.f14106k = -1;
        this.f14107l = -1;
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<AppInfoBean> list = this.f14103h;
        if (list != null) {
            list.clear();
        }
        this.f14103h = null;
        List<AppInfoBean> list2 = this.f14105j;
        if (list2 != null) {
            list2.clear();
        }
        this.f14105j = null;
        List<AppInfoBean> list3 = this.f14104i;
        if (list3 != null) {
            list3.clear();
        }
        this.f14104i = null;
        WeakReference<Context> weakReference = this.q;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.q = null;
        this.p = null;
    }

    public static b e() {
        if (v == null) {
            synchronized (b.class) {
                if (v == null) {
                    v = new b();
                }
            }
        }
        return v;
    }

    public void f() {
        if (this.p == null) {
            throw new NullPointerException("listener \u4e0d\u80fd\u4e3a\u7a7a");
        }
        List<AppInfoBean> list = this.f14103h;
        if (list == null || list.size() <= 0) {
            g();
            return;
        }
        List<AppInfoBean> list2 = this.f14104i;
        if (list2 != null && list2.size() > 0) {
            ArrayList arrayList = new ArrayList(this.f14104i);
            this.f14104i.clear();
            if (this.o != 3) {
                a(arrayList);
                return;
            }
            return;
        }
        int i2 = this.f14106k;
        if (i2 == -1) {
            this.f14106k = 0;
        } else if (i2 != this.f14107l) {
            return;
        }
        this.f14107l = this.f14106k + Math.min(this.f14103h.size() - this.f14106k, 30);
        ArrayList arrayList2 = new ArrayList(this.f14103h.subList(this.f14106k, this.f14107l));
        if (this.f14108m == 1) {
            if (this.f14105j == null) {
                this.f14105j = new ArrayList();
            }
            s1.b("scanSingleIng-->", "mQueueList1 " + this.f14105j.size());
            this.f14105j.addAll(arrayList2);
            s1.b("scanSingleIng-->", "mQueueList2 " + this.f14105j.size());
            if (this.f14106k == 0) {
                this.r.postDelayed(this.s, this.f14098c);
            }
        } else {
            this.p.a(arrayList2, null);
        }
        new Thread(new c(arrayList2)).start();
    }

    public void g() {
        this.o = 2;
        if (this.p != null) {
            List<AppInfoBean> list = this.f14105j;
            if (list == null || list.size() <= 0) {
                this.o = 3;
                this.p.a();
            }
        }
    }

    public void c() {
        this.o = 1;
    }

    public void b(Context context, ui.e.c cVar) {
        a(context, 0, 2, cVar);
    }

    public void b(Context context, int i2, ui.e.c cVar) {
        a(context, i2, 2, cVar);
    }

    public void a(Context context, ui.e.c cVar) {
        a(context, 0, 1, cVar);
    }

    public void b() {
        this.o = 3;
        this.f14108m = 0;
        this.f14109n = 0;
        d();
    }

    public void a(Context context, int i2, ui.e.c cVar) {
        a(context, i2, 1, cVar);
    }

    private void a(Context context, int i2, int i3, ui.e.c cVar) {
        WeakReference<Context> weakReference;
        List<AppInfoBean> list;
        if (context != null) {
            if (this.f14109n == i3 && (weakReference = this.q) != null && weakReference.get() == context) {
                int i4 = this.o;
                if (i4 == 2) {
                    g();
                    return;
                }
                if (i4 == 1) {
                    if (this.f14107l > 0 && (list = this.f14103h) != null && list.size() > 0 && this.f14107l < this.f14103h.size()) {
                        this.o = 0;
                        f();
                        return;
                    } else {
                        g();
                        return;
                    }
                }
                if (i4 != 3 || this.p == null) {
                    return;
                }
                List<AppInfoBean> list2 = this.f14105j;
                if (list2 == null || list2.size() <= 0) {
                    this.p.a();
                    return;
                }
                return;
            }
            WeakReference<Context> weakReference2 = this.q;
            if (weakReference2 == null || !(weakReference2.get() instanceof VirusKillingActivity) || (context instanceof VirusKillingActivity)) {
                this.f14108m = i2;
                this.f14109n = i3;
                this.o = 0;
                d();
                this.q = new WeakReference<>(context);
                if (cVar != null) {
                    this.p = cVar;
                    if (this.r == null) {
                        this.r = new Handler((Handler.Callback) new WeakReference(new a()).get());
                    }
                    this.p.c();
                    List<AppInfoBean> list3 = this.f14103h;
                    if (list3 != null && list3.size() > 0) {
                        f();
                        return;
                    } else {
                        new Thread(new Runnable() { // from class: ui.e.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.a();
                            }
                        }).start();
                        return;
                    }
                }
                throw new NullPointerException("listener \u4e0d\u80fd\u4e3a\u7a7a");
            }
            return;
        }
        throw new NullPointerException("context \u4e0d\u80fd\u4e3a\u7a7a");
    }

    public /* synthetic */ void a() {
        int i2 = this.f14109n;
        if (i2 == 1) {
            this.f14103h = new x1(Hicore.getApp()).a();
        } else if (i2 == 2) {
            this.f14103h = x1.a(new String[]{x1.f15111d});
        }
        this.r.sendEmptyMessage(this.f14109n);
    }

    public void a(List<AppInfoBean> list) {
        SearchVirusAppArrayHttp.Companion.getInstance().principalHttp(list, new d(list));
    }

    public void a(List<AppInfoBean> list, ui.e.c cVar) {
        cVar.a(list);
        int i2 = this.f14107l;
        if (i2 > 0 && i2 < this.f14103h.size()) {
            this.f14106k = this.f14107l;
            if (this.o == 0) {
                f();
                return;
            }
            return;
        }
        g();
    }
}
