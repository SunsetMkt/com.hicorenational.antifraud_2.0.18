package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static q f9424a = new q();

    /* renamed from: b, reason: collision with root package name */
    public BetaGrayStrategy f9425b;

    /* renamed from: c, reason: collision with root package name */
    public DownloadTask f9426c;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.bugly.beta.global.d f9430g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9431h;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f9427d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private DownloadListener f9428e = new com.tencent.bugly.beta.download.a(4, this, 0);

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.bugly.beta.upgrade.a f9429f = null;

    /* renamed from: i, reason: collision with root package name */
    private final Object f9432i = new Object();

    public void a(boolean z, boolean z2, int i2) {
        synchronized (this.f9432i) {
            BetaGrayStrategy betaGrayStrategy = null;
            if (i2 == 3 && !z) {
                betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            }
            if (this.f9429f != null && !this.f9429f.f8858d && this.f9431h == z) {
                synchronized (this.f9429f) {
                    this.f9429f.f8857c[0] = Boolean.valueOf(z);
                    this.f9429f.f8857c[1] = Boolean.valueOf(z2);
                }
                this.f9430g.f8790b[0] = false;
            }
            this.f9431h = z;
            if (this.f9429f != null) {
                this.f9429f.f8858d = true;
            }
            this.f9429f = new com.tencent.bugly.beta.upgrade.a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
            this.f9430g = new com.tencent.bugly.beta.global.d(12, false, this.f9429f);
            String str = "";
            long j2 = 0;
            if (betaGrayStrategy != null) {
                try {
                    if (betaGrayStrategy.f8848a != null) {
                        str = betaGrayStrategy.f8848a.f9487m;
                        j2 = betaGrayStrategy.f8848a.o;
                    }
                } catch (Throwable th) {
                    if (!an.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
            String str2 = str;
            long j3 = j2;
            HashMap hashMap = new HashMap();
            hashMap.put("G16", com.tencent.bugly.beta.global.e.G.N);
            com.tencent.bugly.beta.upgrade.b.f8859a.a(804, i2, ah.a((m) new z(z ? 1 : 0, str2, j3, hashMap)), this.f9429f, z, com.tencent.bugly.beta.global.e.G.H.f8853a.f9352e);
        }
    }

    public synchronized void a(int i2, y yVar, boolean z) {
        final u b2;
        File file;
        this.f9426c = null;
        this.f9425b = a(yVar);
        if (i2 == 0 && this.f9425b != null) {
            if (this.f9425b == null || this.f9425b.f8848a == null || this.f9425b.f8848a.f9480f == null || (file = com.tencent.bugly.beta.global.e.G.I) == null || !file.exists() || !com.tencent.bugly.beta.global.a.a(file, this.f9425b.f8848a.f9480f.f9444a, "SHA")) {
                if (yVar != null) {
                    if (com.tencent.bugly.beta.global.e.G.Y != null && (b2 = this.f9425b.f8848a.b()) != null) {
                        this.f9427d.post(new Runnable() { // from class: com.tencent.bugly.proguard.q.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.tencent.bugly.beta.global.e.G.Y.onPatchReceived(b2.a());
                            }
                        });
                    }
                    if ((com.tencent.bugly.beta.global.e.G.aa || z) && com.tencent.bugly.beta.global.e.G.ab) {
                        a();
                    }
                }
                return;
            }
            an.a("patch has downloaded!", new Object[0]);
            if (!com.tencent.bugly.beta.global.e.G.P && com.tencent.bugly.beta.global.e.G.Q <= 3) {
                an.a("patch has downloaded but not patched execute patch!", new Object[0]);
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
                int i3 = eVar.Q + 1;
                eVar.Q = i3;
                com.tencent.bugly.beta.global.a.a("PATCH_MAX_TIMES", String.valueOf(i3));
                com.tencent.bugly.beta.global.a.a(file, com.tencent.bugly.beta.global.e.G.J);
                TinkerManager.getInstance().onDownloadSuccess(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath(), com.tencent.bugly.beta.global.e.G.X);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    public BetaGrayStrategy a(y yVar) {
        y yVar2;
        int i2;
        Map<String, String> map;
        int i3;
        y yVar3 = yVar;
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.f8848a == null) {
            com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch");
            betaGrayStrategy = null;
        }
        if (yVar3 != null) {
            if (yVar3.n != 1 && betaGrayStrategy != null && !TextUtils.isEmpty(betaGrayStrategy.f8848a.f9487m) && TextUtils.equals(yVar3.f9487m, betaGrayStrategy.f8848a.f9487m)) {
                p pVar = p.f9423a;
                long currentTimeMillis = System.currentTimeMillis();
                y yVar4 = betaGrayStrategy.f8848a;
                pVar.a(new w("recall", currentTimeMillis, (byte) 0, 0L, null, yVar4.f9487m, yVar4.p, null));
                com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch");
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
                DownloadTask a2 = eVar.r.a(betaGrayStrategy.f8848a.f9480f.f9445b, eVar.K.getAbsolutePath(), null, betaGrayStrategy.f8848a.f9480f.f9444a);
                a2.setDownloadType(3);
                a2.delete(true);
                File file = com.tencent.bugly.beta.global.e.G.J;
                if (file != null && file.exists() && file.delete()) {
                    an.a("delete tmpPatchFile", new Object[0]);
                }
                File file2 = com.tencent.bugly.beta.global.e.G.I;
                if (file2 != null && file2.exists() && file2.delete()) {
                    i3 = 0;
                    an.a("delete patchFile", new Object[0]);
                } else {
                    i3 = 0;
                }
                com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", true);
                an.a("patch rollback", new Object[i3]);
                if (!aq.b(com.tencent.bugly.beta.global.e.G.u)) {
                    TinkerManager.getInstance().onPatchRollback(true);
                } else {
                    TinkerManager.getInstance().onPatchRollback(i3);
                }
                betaGrayStrategy = null;
            }
            if (yVar3.n != 1) {
                yVar3 = null;
            }
        }
        if (yVar3 == null) {
            if (betaGrayStrategy == null || (yVar2 = betaGrayStrategy.f8848a) == null || yVar2.p != 3) {
                return null;
            }
            return betaGrayStrategy;
        }
        BetaGrayStrategy betaGrayStrategy2 = new BetaGrayStrategy();
        betaGrayStrategy2.f8848a = yVar3;
        betaGrayStrategy2.f8852e = System.currentTimeMillis();
        if (betaGrayStrategy != null && (!TextUtils.equals(betaGrayStrategy.f8848a.f9480f.f9445b, yVar3.f9480f.f9445b) || ((map = yVar3.f9486l) != null && TextUtils.equals(map.get("H1"), a.a.u.a.f1254k)))) {
            com.tencent.bugly.beta.global.e.G.O = yVar3.f9486l.get("H2");
            com.tencent.bugly.beta.global.e eVar2 = com.tencent.bugly.beta.global.e.G;
            DownloadTask a3 = eVar2.r.a(betaGrayStrategy.f8848a.f9480f.f9445b, eVar2.K.getAbsolutePath(), null, null);
            a3.setDownloadType(3);
            a3.delete(true);
            if (betaGrayStrategy.f8848a.p == 3) {
                File file3 = com.tencent.bugly.beta.global.e.G.J;
                if (file3 != null && file3.exists() && file3.delete()) {
                    an.a("delete tmpPatchFile", new Object[0]);
                }
                File file4 = com.tencent.bugly.beta.global.e.G.I;
                if (file4 != null && file4.exists() && file4.delete()) {
                    com.tencent.bugly.beta.global.e.G.N = "";
                    i2 = 0;
                    an.a("delete patchFile", new Object[0]);
                } else {
                    i2 = 0;
                }
                com.tencent.bugly.beta.global.e.G.Q = i2;
                com.tencent.bugly.beta.global.a.a("PATCH_MAX_TIMES", "0");
                a(betaGrayStrategy2);
                Object[] objArr = new Object[2];
                objArr[i2] = yVar3;
                objArr[1] = Integer.valueOf(yVar3.p);
                an.a("onUpgradeReceived: %s [type: %d]", objArr);
                return betaGrayStrategy2;
            }
        }
        i2 = 0;
        a(betaGrayStrategy2);
        Object[] objArr2 = new Object[2];
        objArr2[i2] = yVar3;
        objArr2[1] = Integer.valueOf(yVar3.p);
        an.a("onUpgradeReceived: %s [type: %d]", objArr2);
        return betaGrayStrategy2;
    }

    private void a() {
        BetaGrayStrategy betaGrayStrategy = this.f9425b;
        if (betaGrayStrategy == null) {
            return;
        }
        if (this.f9426c == null) {
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
            this.f9426c = eVar.r.a(betaGrayStrategy.f8848a.f9480f.f9445b, eVar.K.getAbsolutePath(), null, this.f9425b.f8848a.f9480f.f9444a);
            this.f9426c.setDownloadType(3);
        }
        DownloadTask downloadTask = this.f9426c;
        if (downloadTask == null) {
            return;
        }
        downloadTask.addListener(this.f9428e);
        this.f9426c.setNeededNotify(false);
        this.f9426c.download();
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        y yVar = betaGrayStrategy.f8848a;
        if (yVar == null || yVar.p != 3) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", betaGrayStrategy);
    }
}
