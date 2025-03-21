package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.C3075a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.RunnableC3081d;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C3098a;
import com.tencent.bugly.beta.upgrade.C3099b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p014u.C0052a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.q */
/* loaded from: classes2.dex */
public class C3192q {

    /* renamed from: a */
    public static C3192q f10776a = new C3192q();

    /* renamed from: b */
    public BetaGrayStrategy f10777b;

    /* renamed from: c */
    public DownloadTask f10778c;

    /* renamed from: g */
    private RunnableC3081d f10782g;

    /* renamed from: h */
    private boolean f10783h;

    /* renamed from: d */
    public final Handler f10779d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private DownloadListener f10780e = new C3075a(4, this, 0);

    /* renamed from: f */
    private C3098a f10781f = null;

    /* renamed from: i */
    private final Object f10784i = new Object();

    /* renamed from: a */
    public void m10141a(boolean z, boolean z2, int i2) {
        synchronized (this.f10784i) {
            BetaGrayStrategy betaGrayStrategy = null;
            if (i2 == 3 && !z) {
                betaGrayStrategy = (BetaGrayStrategy) C3078a.m9326a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            }
            if (this.f10781f != null && !this.f10781f.f9998d && this.f10783h == z) {
                synchronized (this.f10781f) {
                    this.f10781f.f9997c[0] = Boolean.valueOf(z);
                    this.f10781f.f9997c[1] = Boolean.valueOf(z2);
                }
                this.f10782g.f9866b[0] = false;
            }
            this.f10783h = z;
            if (this.f10781f != null) {
                this.f10781f.f9998d = true;
            }
            this.f10781f = new C3098a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
            this.f10782g = new RunnableC3081d(12, false, this.f10781f);
            String str = "";
            long j2 = 0;
            if (betaGrayStrategy != null) {
                try {
                    if (betaGrayStrategy.f9988a != null) {
                        str = betaGrayStrategy.f9988a.f10844m;
                        j2 = betaGrayStrategy.f9988a.f10846o;
                    }
                } catch (Throwable th) {
                    if (!C3151an.m9919b(th)) {
                        th.printStackTrace();
                    }
                }
            }
            String str2 = str;
            long j3 = j2;
            HashMap hashMap = new HashMap();
            hashMap.put("G16", C3082e.f9867G.f9881N);
            C3099b.f9999a.m9372a(804, i2, C3145ah.m9854a((AbstractC3188m) new C3201z(z ? 1 : 0, str2, j3, hashMap)), this.f10781f, z, C3082e.f9867G.f9875H.f9993a.f10704e);
        }
    }

    /* renamed from: a */
    public synchronized void m10140a(int i2, C3200y c3200y, boolean z) {
        final C3196u m10151b;
        File file;
        this.f10778c = null;
        this.f10777b = m10139a(c3200y);
        if (i2 == 0 && this.f10777b != null) {
            if (this.f10777b == null || this.f10777b.f9988a == null || this.f10777b.f9988a.f10837f == null || (file = C3082e.f9867G.f9876I) == null || !file.exists() || !C3078a.m9333a(file, this.f10777b.f9988a.f10837f.f10796a, "SHA")) {
                if (c3200y != null) {
                    if (C3082e.f9867G.f9892Y != null && (m10151b = this.f10777b.f9988a.m10151b()) != null) {
                        this.f10779d.post(new Runnable() { // from class: com.tencent.bugly.proguard.q.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C3082e.f9867G.f9892Y.onPatchReceived(m10151b.m10148a());
                            }
                        });
                    }
                    if ((C3082e.f9867G.f9894aa || z) && C3082e.f9867G.f9895ab) {
                        m10137a();
                    }
                }
                return;
            }
            C3151an.m9915a("patch has downloaded!", new Object[0]);
            if (!C3082e.f9867G.f9883P && C3082e.f9867G.f9884Q <= 3) {
                C3151an.m9915a("patch has downloaded but not patched execute patch!", new Object[0]);
                C3082e c3082e = C3082e.f9867G;
                int i3 = c3082e.f9884Q + 1;
                c3082e.f9884Q = i3;
                C3078a.m9329a("PATCH_MAX_TIMES", String.valueOf(i3));
                C3078a.m9332a(file, C3082e.f9867G.f9877J);
                TinkerManager.getInstance().onDownloadSuccess(C3082e.f9867G.f9877J.getAbsolutePath(), C3082e.f9867G.f9891X);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* renamed from: a */
    public BetaGrayStrategy m10139a(C3200y c3200y) {
        C3200y c3200y2;
        int i2;
        Map<String, String> map;
        int i3;
        C3200y c3200y3 = c3200y;
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C3078a.m9326a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.f9988a == null) {
            C3078a.m9334a("hotfix.strategy.bch");
            betaGrayStrategy = null;
        }
        if (c3200y3 != null) {
            if (c3200y3.f10845n != 1 && betaGrayStrategy != null && !TextUtils.isEmpty(betaGrayStrategy.f9988a.f10844m) && TextUtils.equals(c3200y3.f10844m, betaGrayStrategy.f9988a.f10844m)) {
                C3191p c3191p = C3191p.f10775a;
                long currentTimeMillis = System.currentTimeMillis();
                C3200y c3200y4 = betaGrayStrategy.f9988a;
                c3191p.m10131a(new C3198w("recall", currentTimeMillis, (byte) 0, 0L, null, c3200y4.f10844m, c3200y4.f10847p, null));
                C3078a.m9334a("hotfix.strategy.bch");
                C3082e c3082e = C3082e.f9867G;
                DownloadTask mo9315a = c3082e.f9916r.mo9315a(betaGrayStrategy.f9988a.f10837f.f10797b, c3082e.f9878K.getAbsolutePath(), null, betaGrayStrategy.f9988a.f10837f.f10796a);
                mo9315a.setDownloadType(3);
                mo9315a.delete(true);
                File file = C3082e.f9867G.f9877J;
                if (file != null && file.exists() && file.delete()) {
                    C3151an.m9915a("delete tmpPatchFile", new Object[0]);
                }
                File file2 = C3082e.f9867G.f9876I;
                if (file2 != null && file2.exists() && file2.delete()) {
                    i3 = 0;
                    C3151an.m9915a("delete patchFile", new Object[0]);
                } else {
                    i3 = 0;
                }
                C3078a.m9330a("IS_PATCH_ROLL_BACK", true);
                C3151an.m9915a("patch rollback", new Object[i3]);
                if (!C3154aq.m9987b(C3082e.f9867G.f9919u)) {
                    TinkerManager.getInstance().onPatchRollback(true);
                } else {
                    TinkerManager.getInstance().onPatchRollback(i3);
                }
                betaGrayStrategy = null;
            }
            if (c3200y3.f10845n != 1) {
                c3200y3 = null;
            }
        }
        if (c3200y3 == null) {
            if (betaGrayStrategy == null || (c3200y2 = betaGrayStrategy.f9988a) == null || c3200y2.f10847p != 3) {
                return null;
            }
            return betaGrayStrategy;
        }
        BetaGrayStrategy betaGrayStrategy2 = new BetaGrayStrategy();
        betaGrayStrategy2.f9988a = c3200y3;
        betaGrayStrategy2.f9992e = System.currentTimeMillis();
        if (betaGrayStrategy != null && (!TextUtils.equals(betaGrayStrategy.f9988a.f10837f.f10797b, c3200y3.f10837f.f10797b) || ((map = c3200y3.f10843l) != null && TextUtils.equals(map.get("H1"), C0052a.f159k)))) {
            C3082e.f9867G.f9882O = c3200y3.f10843l.get("H2");
            C3082e c3082e2 = C3082e.f9867G;
            DownloadTask mo9315a2 = c3082e2.f9916r.mo9315a(betaGrayStrategy.f9988a.f10837f.f10797b, c3082e2.f9878K.getAbsolutePath(), null, null);
            mo9315a2.setDownloadType(3);
            mo9315a2.delete(true);
            if (betaGrayStrategy.f9988a.f10847p == 3) {
                File file3 = C3082e.f9867G.f9877J;
                if (file3 != null && file3.exists() && file3.delete()) {
                    C3151an.m9915a("delete tmpPatchFile", new Object[0]);
                }
                File file4 = C3082e.f9867G.f9876I;
                if (file4 != null && file4.exists() && file4.delete()) {
                    C3082e.f9867G.f9881N = "";
                    i2 = 0;
                    C3151an.m9915a("delete patchFile", new Object[0]);
                } else {
                    i2 = 0;
                }
                C3082e.f9867G.f9884Q = i2;
                C3078a.m9329a("PATCH_MAX_TIMES", "0");
                m10138a(betaGrayStrategy2);
                Object[] objArr = new Object[2];
                objArr[i2] = c3200y3;
                objArr[1] = Integer.valueOf(c3200y3.f10847p);
                C3151an.m9915a("onUpgradeReceived: %s [type: %d]", objArr);
                return betaGrayStrategy2;
            }
        }
        i2 = 0;
        m10138a(betaGrayStrategy2);
        Object[] objArr2 = new Object[2];
        objArr2[i2] = c3200y3;
        objArr2[1] = Integer.valueOf(c3200y3.f10847p);
        C3151an.m9915a("onUpgradeReceived: %s [type: %d]", objArr2);
        return betaGrayStrategy2;
    }

    /* renamed from: a */
    private void m10137a() {
        BetaGrayStrategy betaGrayStrategy = this.f10777b;
        if (betaGrayStrategy == null) {
            return;
        }
        if (this.f10778c == null) {
            C3082e c3082e = C3082e.f9867G;
            this.f10778c = c3082e.f9916r.mo9315a(betaGrayStrategy.f9988a.f10837f.f10797b, c3082e.f9878K.getAbsolutePath(), null, this.f10777b.f9988a.f10837f.f10796a);
            this.f10778c.setDownloadType(3);
        }
        DownloadTask downloadTask = this.f10778c;
        if (downloadTask == null) {
            return;
        }
        downloadTask.addListener(this.f10780e);
        this.f10778c.setNeededNotify(false);
        this.f10778c.download();
    }

    /* renamed from: a */
    private void m10138a(BetaGrayStrategy betaGrayStrategy) {
        C3200y c3200y = betaGrayStrategy.f9988a;
        if (c3200y == null || c3200y.f10847p != 3) {
            return;
        }
        C3078a.m9335a("hotfix.strategy.bch", betaGrayStrategy);
    }
}
