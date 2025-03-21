package p388ui.p390e;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bean.AppInfoBean;
import com.google.gson.C2051e;
import com.hicorenational.antifraud.C2113R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import network.http.SearchVirusAppArrayHttp;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.Hicore;
import p388ui.activity.VirusKillingActivity;
import util.C7301n1;
import util.C7304o1;
import util.C7316r1;
import util.C7331w1;

/* compiled from: ScanAppEngine.java */
/* renamed from: ui.e.b */
/* loaded from: classes2.dex */
public final class C6823b {

    /* renamed from: t */
    public static final int f23690t = 0;

    /* renamed from: u */
    public static final int f23691u = 1;

    /* renamed from: v */
    private static C6823b f23692v;

    /* renamed from: a */
    private final int f23693a = 1;

    /* renamed from: b */
    private final int f23694b = 2;

    /* renamed from: c */
    private int f23695c = 200;

    /* renamed from: d */
    private final int f23696d = 0;

    /* renamed from: e */
    private final int f23697e = 1;

    /* renamed from: f */
    private final int f23698f = 2;

    /* renamed from: g */
    private final int f23699g = 3;

    /* renamed from: h */
    private List<AppInfoBean> f23700h = null;

    /* renamed from: i */
    private List<AppInfoBean> f23701i = null;

    /* renamed from: j */
    private List<AppInfoBean> f23702j = null;

    /* renamed from: k */
    private int f23703k = -1;

    /* renamed from: l */
    private int f23704l = -1;

    /* renamed from: m */
    private int f23705m = 0;

    /* renamed from: n */
    private int f23706n = 0;

    /* renamed from: o */
    private int f23707o = 0;

    /* renamed from: p */
    private InterfaceC6824c f23708p = null;

    /* renamed from: q */
    private WeakReference<Context> f23709q = null;

    /* renamed from: r */
    private Handler f23710r = null;

    /* renamed from: s */
    private Runnable f23711s = new b();

    /* compiled from: ScanAppEngine.java */
    /* renamed from: ui.e.b$a */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 != 1 && i2 != 2) {
                return false;
            }
            if (C6823b.this.f23700h == null || C6823b.this.f23700h.size() <= 0) {
                C6823b.this.m25510g();
                return false;
            }
            C6823b.this.f23708p.mo25403a(C6823b.this.f23700h.size());
            C6823b.this.m25508f();
            return false;
        }
    }

    /* compiled from: ScanAppEngine.java */
    /* renamed from: ui.e.b$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6823b.this.f23702j != null && C6823b.this.f23702j.size() > 0) {
                if (C6823b.this.f23707o != 1 && C6823b.this.f23707o != 3) {
                    C6823b.this.f23708p.mo25405a(null, (AppInfoBean) C6823b.this.f23702j.get(0));
                    C6823b.this.f23702j.remove(0);
                }
                C6823b.this.f23710r.postDelayed(C6823b.this.f23711s, C6823b.this.f23695c);
                return;
            }
            if (C6823b.this.f23708p == null || C6823b.this.f23707o != 2) {
                C6823b.this.f23710r.postDelayed(C6823b.this.f23711s, C6823b.this.f23695c);
            } else {
                C6823b.this.f23707o = 3;
                C6823b.this.f23708p.mo25402a();
            }
        }
    }

    /* compiled from: ScanAppEngine.java */
    /* renamed from: ui.e.b$c */
    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f23714a;

        c(List list) {
            this.f23714a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.f23714a.size(); i2++) {
                try {
                    if (C6823b.this.f23707o == 3) {
                        return;
                    }
                    AppInfoBean appInfoBean = (AppInfoBean) this.f23714a.get(i2);
                    if (TextUtils.isEmpty(appInfoBean.getAppMD5())) {
                        appInfoBean.setAppMD5(C7304o1.m26466a(new File(appInfoBean.getPkgPath())));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (C6823b.this.f23707o == 3) {
                return;
            }
            C6823b.this.m25497a((List<AppInfoBean>) this.f23714a);
        }
    }

    /* compiled from: ScanAppEngine.java */
    /* renamed from: ui.e.b$d */
    class d implements SearchVirusAppArrayHttp.Callback {

        /* renamed from: a */
        final /* synthetic */ List f23716a;

        d(List list) {
            this.f23716a = list;
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalFail(@InterfaceC5817e String str) {
            if (C6823b.this.f23707o == 3) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = Hicore.getApp().getString(C2113R.string.err_timeout);
            }
            C7331w1.m26688a(str);
            C6823b.this.f23701i = this.f23716a;
            C6823b.this.f23707o = 1;
            C6823b.this.f23708p.mo25406b();
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalRequestFinish(int i2, boolean z) {
            if (C6823b.this.f23707o == 3) {
                return;
            }
            if (z) {
                C6823b c6823b = C6823b.this;
                c6823b.m25498a((List<AppInfoBean>) this.f23716a, c6823b.f23708p);
                return;
            }
            C7301n1.m26456b("Finish mNextPosition-->" + C6823b.this.f23704l);
            C7301n1.m26456b("Finish finalSubList-->" + new C2051e().m5572a(this.f23716a));
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalRiskResult(boolean z) {
            if (C6823b.this.f23707o == 3) {
                return;
            }
            C7301n1.m26456b("Risk mNextPosition-->" + C6823b.this.f23704l);
            C7301n1.m26456b("Risk finalSubList-->" + new C2051e().m5572a(this.f23716a));
            C6823b c6823b = C6823b.this;
            c6823b.m25498a((List<AppInfoBean>) this.f23716a, c6823b.f23708p);
        }
    }

    /* renamed from: d */
    private void m25504d() {
        this.f23703k = -1;
        this.f23704l = -1;
        Handler handler = this.f23710r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<AppInfoBean> list = this.f23700h;
        if (list != null) {
            list.clear();
        }
        this.f23700h = null;
        List<AppInfoBean> list2 = this.f23702j;
        if (list2 != null) {
            list2.clear();
        }
        this.f23702j = null;
        List<AppInfoBean> list3 = this.f23701i;
        if (list3 != null) {
            list3.clear();
        }
        this.f23701i = null;
        WeakReference<Context> weakReference = this.f23709q;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f23709q = null;
        this.f23708p = null;
    }

    /* renamed from: e */
    public static C6823b m25505e() {
        if (f23692v == null) {
            synchronized (C6823b.class) {
                if (f23692v == null) {
                    f23692v = new C6823b();
                }
            }
        }
        return f23692v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m25508f() {
        if (this.f23708p == null) {
            throw new NullPointerException("listener 不能为空");
        }
        List<AppInfoBean> list = this.f23700h;
        if (list == null || list.size() <= 0) {
            m25510g();
            return;
        }
        List<AppInfoBean> list2 = this.f23701i;
        if (list2 != null && list2.size() > 0) {
            ArrayList arrayList = new ArrayList(this.f23701i);
            this.f23701i.clear();
            if (this.f23707o != 3) {
                m25497a(arrayList);
                return;
            }
            return;
        }
        int i2 = this.f23703k;
        if (i2 == -1) {
            this.f23703k = 0;
        } else if (i2 != this.f23704l) {
            return;
        }
        this.f23704l = this.f23703k + Math.min(this.f23700h.size() - this.f23703k, 30);
        ArrayList arrayList2 = new ArrayList(this.f23700h.subList(this.f23703k, this.f23704l));
        if (this.f23705m == 1) {
            if (this.f23702j == null) {
                this.f23702j = new ArrayList();
            }
            C7301n1.m26457b("scanSingleIng-->", "mQueueList1 " + this.f23702j.size());
            this.f23702j.addAll(arrayList2);
            C7301n1.m26457b("scanSingleIng-->", "mQueueList2 " + this.f23702j.size());
            if (this.f23703k == 0) {
                this.f23710r.postDelayed(this.f23711s, this.f23695c);
            }
        } else {
            this.f23708p.mo25405a(arrayList2, null);
        }
        new Thread(new c(arrayList2)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m25510g() {
        this.f23707o = 2;
        if (this.f23708p != null) {
            List<AppInfoBean> list = this.f23702j;
            if (list == null || list.size() <= 0) {
                this.f23707o = 3;
                this.f23708p.mo25402a();
            }
        }
    }

    /* renamed from: c */
    public void m25520c() {
        this.f23707o = 1;
    }

    /* renamed from: b */
    public void m25519b(Context context, InterfaceC6824c interfaceC6824c) {
        m25496a(context, 0, 2, interfaceC6824c);
    }

    /* renamed from: b */
    public void m25518b(Context context, int i2, InterfaceC6824c interfaceC6824c) {
        m25496a(context, i2, 2, interfaceC6824c);
    }

    /* renamed from: a */
    public void m25516a(Context context, InterfaceC6824c interfaceC6824c) {
        m25496a(context, 0, 1, interfaceC6824c);
    }

    /* renamed from: b */
    public void m25517b() {
        this.f23707o = 3;
        this.f23705m = 0;
        this.f23706n = 0;
        m25504d();
    }

    /* renamed from: a */
    public void m25515a(Context context, int i2, InterfaceC6824c interfaceC6824c) {
        m25496a(context, i2, 1, interfaceC6824c);
    }

    /* renamed from: a */
    private void m25496a(Context context, int i2, int i3, InterfaceC6824c interfaceC6824c) {
        WeakReference<Context> weakReference;
        List<AppInfoBean> list;
        if (context != null) {
            if (this.f23706n == i3 && (weakReference = this.f23709q) != null && weakReference.get() == context) {
                int i4 = this.f23707o;
                if (i4 == 2) {
                    m25510g();
                    return;
                }
                if (i4 == 1) {
                    if (this.f23704l > 0 && (list = this.f23700h) != null && list.size() > 0 && this.f23704l < this.f23700h.size()) {
                        this.f23707o = 0;
                        m25508f();
                        return;
                    } else {
                        m25510g();
                        return;
                    }
                }
                if (i4 != 3 || this.f23708p == null) {
                    return;
                }
                List<AppInfoBean> list2 = this.f23702j;
                if (list2 == null || list2.size() <= 0) {
                    this.f23708p.mo25402a();
                    return;
                }
                return;
            }
            WeakReference<Context> weakReference2 = this.f23709q;
            if (weakReference2 == null || !(weakReference2.get() instanceof VirusKillingActivity) || (context instanceof VirusKillingActivity)) {
                this.f23705m = i2;
                this.f23706n = i3;
                this.f23707o = 0;
                m25504d();
                this.f23709q = new WeakReference<>(context);
                if (interfaceC6824c != null) {
                    this.f23708p = interfaceC6824c;
                    if (this.f23710r == null) {
                        this.f23710r = new Handler((Handler.Callback) new WeakReference(new a()).get());
                    }
                    this.f23708p.mo25407c();
                    List<AppInfoBean> list3 = this.f23700h;
                    if (list3 != null && list3.size() > 0) {
                        m25508f();
                        return;
                    } else {
                        new Thread(new Runnable() { // from class: ui.e.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                C6823b.this.m25514a();
                            }
                        }).start();
                        return;
                    }
                }
                throw new NullPointerException("listener 不能为空");
            }
            return;
        }
        throw new NullPointerException("context 不能为空");
    }

    /* renamed from: a */
    public /* synthetic */ void m25514a() {
        int i2 = this.f23706n;
        if (i2 == 1) {
            this.f23700h = new C7316r1(Hicore.getApp()).m26557a();
        } else if (i2 == 2) {
            this.f23700h = C7316r1.m26537a(new String[]{C7316r1.f25586d});
        }
        this.f23710r.sendEmptyMessage(this.f23706n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25497a(List<AppInfoBean> list) {
        SearchVirusAppArrayHttp.Companion.getInstance().principalHttp(list, new d(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25498a(List<AppInfoBean> list, InterfaceC6824c interfaceC6824c) {
        interfaceC6824c.mo25404a(list);
        int i2 = this.f23704l;
        if (i2 > 0 && i2 < this.f23700h.size()) {
            this.f23703k = this.f23704l;
            if (this.f23707o == 0) {
                m25508f();
                return;
            }
            return;
        }
        m25510g();
    }
}
