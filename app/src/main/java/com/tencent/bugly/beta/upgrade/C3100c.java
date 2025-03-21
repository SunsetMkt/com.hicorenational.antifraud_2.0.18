package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.C3075a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.C3083f;
import com.tencent.bugly.beta.global.RunnableC3081d;
import com.tencent.bugly.beta.p205ui.C3097h;
import com.tencent.bugly.beta.utils.C3105e;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.C3174bj;
import com.tencent.bugly.proguard.C3175bk;
import com.tencent.bugly.proguard.C3191p;
import com.tencent.bugly.proguard.C3198w;
import com.tencent.bugly.proguard.C3200y;
import java.io.File;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.upgrade.c */
/* loaded from: classes2.dex */
public class C3100c {

    /* renamed from: a */
    public static C3100c f10000a = new C3100c();

    /* renamed from: b */
    public BetaGrayStrategy f10001b;

    /* renamed from: c */
    public DownloadTask f10002c;

    /* renamed from: d */
    public DownloadListener f10003d;

    /* renamed from: e */
    public UpgradeListener f10004e;

    /* renamed from: f */
    public UpgradeStateListener f10005f;

    /* renamed from: g */
    public boolean f10006g;

    /* renamed from: h */
    public boolean f10007h;

    /* renamed from: i */
    public RunnableC3081d f10008i;

    /* renamed from: j */
    public RunnableC3081d f10009j;

    /* renamed from: k */
    public int f10010k;

    /* renamed from: l */
    private final Object f10011l = new Object();

    /* renamed from: m */
    private final Object f10012m = new Object();

    /* renamed from: n */
    private DownloadListener f10013n = new C3075a(3, this, 0);

    /* renamed from: o */
    private C3098a f10014o = null;

    /* renamed from: p */
    private RunnableC3081d f10015p;

    /* renamed from: q */
    private boolean f10016q;

    /* renamed from: r */
    private int f10017r;

    /* renamed from: b */
    private DownloadTask m9378b() {
        C3200y m9375a = m9375a();
        if (m9375a == null) {
            return null;
        }
        if (this.f10002c == null) {
            C3082e c3082e = C3082e.f9867G;
            this.f10002c = c3082e.f9916r.mo9315a(m9375a.f10837f.f10797b, c3082e.f9920v.getAbsolutePath(), null, this.f10001b.f9988a.f10837f.f10796a);
            this.f10002c.setDownloadType(1);
        }
        return this.f10002c;
    }

    /* renamed from: c */
    private void m9379c() {
        C3200y m9375a = m9375a();
        if (m9375a == null) {
            return;
        }
        if (this.f10002c == null) {
            this.f10002c = m9378b();
        }
        if (this.f10002c == null) {
            return;
        }
        m9376a(this.f10001b);
        BetaReceiver.addTask(this.f10002c);
        if (this.f10002c.getStatus() != 1 || this.f10007h) {
            this.f10002c.download();
        } else if (this.f10006g && C3078a.m9331a(C3082e.f9867G.f9919u, this.f10002c.getSaveFile(), m9375a.f10837f.f10796a)) {
            C3191p.f10775a.m10131a(new C3198w("install", System.currentTimeMillis(), (byte) 0, 0L, m9375a.f10836e, m9375a.f10844m, m9375a.f10847p, null));
        } else {
            m9377a(this.f10006g);
        }
    }

    /* renamed from: a */
    public BetaGrayStrategy m9380a(C3200y c3200y) {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        C3200y c3200y2 = c3200y;
        synchronized (this.f10011l) {
            BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) C3078a.m9326a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            betaGrayStrategy = null;
            if (betaGrayStrategy3 != null && betaGrayStrategy3.f9988a == null) {
                C3078a.m9334a("app.upgrade.strategy.bch");
                betaGrayStrategy3 = null;
            }
            if (betaGrayStrategy3 != null && betaGrayStrategy3.f9988a != null && (betaGrayStrategy3.f9988a.f10836e.f10804c < C3082e.f9867G.f9923y || ((betaGrayStrategy3.f9988a.f10836e.f10804c == C3082e.f9867G.f9923y && betaGrayStrategy3.f9988a.f10836e.f10806e <= C3082e.f9867G.f9915q) || betaGrayStrategy3.f9988a.f10845n != 1 || (betaGrayStrategy3.f9988a.f10837f != null && TextUtils.equals(C3082e.f9867G.f9922x, betaGrayStrategy3.f9988a.f10837f.f10796a))))) {
                C3078a.m9334a("app.upgrade.strategy.bch");
                this.f10002c = null;
                betaGrayStrategy3 = null;
            }
            if (c3200y2 != null && (c3200y2.f10836e.f10804c < C3082e.f9867G.f9923y || (c3200y2.f10836e.f10804c == C3082e.f9867G.f9923y && c3200y2.f10836e.f10806e <= C3082e.f9867G.f9915q))) {
                C3151an.m9915a("versionCode is too small, discard remote strategy: [new: %d buildno: %d] [current: %d buildno: %d]", Integer.valueOf(c3200y2.f10836e.f10804c), Integer.valueOf(c3200y2.f10836e.f10806e), Integer.valueOf(C3082e.f9867G.f9923y), Integer.valueOf(C3082e.f9867G.f9915q));
                c3200y2 = null;
            }
            if (c3200y2 != null) {
                if (c3200y2.f10845n == 2 && betaGrayStrategy3 != null && betaGrayStrategy3.f9988a != null && !TextUtils.isEmpty(c3200y2.f10844m) && !TextUtils.isEmpty(betaGrayStrategy3.f9988a.f10844m) && TextUtils.equals(c3200y2.f10844m, betaGrayStrategy3.f9988a.f10844m)) {
                    C3151an.m9915a("撤回 strategy: %s", c3200y2.f10844m);
                    betaGrayStrategy3 = null;
                }
                if (c3200y2.f10845n != 1) {
                    C3151an.m9915a("invalid strategy: %s", c3200y2.f10844m);
                    c3200y2 = null;
                }
            }
            if (c3200y2 != null) {
                if (betaGrayStrategy3 == null || betaGrayStrategy3.f9988a == null || TextUtils.isEmpty(c3200y2.f10844m) || TextUtils.isEmpty(betaGrayStrategy3.f9988a.f10844m) || !TextUtils.equals(c3200y2.f10844m, betaGrayStrategy3.f9988a.f10844m)) {
                    betaGrayStrategy2 = new BetaGrayStrategy();
                } else {
                    BetaGrayStrategy betaGrayStrategy4 = new BetaGrayStrategy(C3154aq.m9997d(C3154aq.m9973a(betaGrayStrategy3)));
                    C3151an.m9915a("same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d", c3200y2.f10844m, betaGrayStrategy3.f9988a.f10844m, Integer.valueOf(betaGrayStrategy4.f9989b), Long.valueOf(c3200y2.f10840i));
                    betaGrayStrategy2 = betaGrayStrategy4;
                }
                betaGrayStrategy2.f9988a = c3200y2;
                betaGrayStrategy2.f9992e = System.currentTimeMillis();
                if (betaGrayStrategy3 != null && !betaGrayStrategy3.f9988a.f10837f.f10797b.equals(c3200y2.f10837f.f10797b)) {
                    if (this.f10002c == null) {
                        this.f10002c = C3082e.f9867G.f9916r.mo9315a(betaGrayStrategy3.f9988a.f10837f.f10797b, C3082e.f9867G.f9920v.getAbsolutePath(), null, null);
                        this.f10002c.setDownloadType(1);
                        this.f10002c.delete(true);
                        for (File file : C3082e.f9867G.f9920v.listFiles()) {
                            if (!file.delete()) {
                                C3151an.m9923e("cannot deleteCache file:%s", file.getAbsolutePath());
                            }
                        }
                        this.f10002c = null;
                    } else {
                        BetaReceiver.netListeners.remove(this.f10002c.getDownloadUrl());
                        this.f10002c.delete(true);
                        this.f10002c = null;
                    }
                }
                m9376a(betaGrayStrategy2);
                C3151an.m9915a("onUpgradeReceived: %s [type: %d]", c3200y2, Integer.valueOf(c3200y2.f10838g));
                C3191p.f10775a.m10131a(new C3198w("rcv", System.currentTimeMillis(), (byte) 0, 0L, c3200y2.f10836e, c3200y2.f10844m, c3200y2.f10847p, null));
                betaGrayStrategy = betaGrayStrategy2;
            }
        }
        return betaGrayStrategy;
    }

    /* renamed from: a */
    public void m9383a(boolean z, boolean z2, int i2, C3200y c3200y, String str) {
        synchronized (this.f10011l) {
            this.f10002c = null;
            this.f10001b = m9380a(c3200y);
            this.f10006g = z;
            this.f10007h = z2;
            if (this.f10004e != null) {
                C3151an.m9915a("你已放弃让SDK来处理策略", new Object[0]);
                this.f10010k = 3;
                if (this.f10001b == null) {
                    C3151an.m9915a("betaStrategy is null", new Object[0]);
                    C3105e.m9461a(new RunnableC3081d(5, Beta.strToastYourAreTheLatestVersion));
                    return;
                }
                if (this.f10001b.f9988a != null && !z && (this.f10001b.f9990c + this.f10001b.f9988a.f10840i > System.currentTimeMillis() || this.f10001b.f9988a.f10839h - this.f10001b.f9989b <= 0)) {
                    return;
                }
                if (this.f10001b != null && this.f10002c == null) {
                    this.f10002c = C3082e.f9867G.f9916r.mo9315a(this.f10001b.f9988a.f10837f.f10797b, C3082e.f9867G.f9920v.getAbsolutePath(), null, this.f10001b.f9988a.f10837f.f10796a);
                    this.f10002c.setDownloadType(1);
                }
                if (this.f10002c == null) {
                    C3151an.m9915a("用户自定义activity，创建task失败 [strategy:%s]", this.f10001b);
                    this.f10001b = null;
                    C3078a.m9334a("app.upgrade.strategy.bch");
                } else {
                    this.f10002c.addListener(this.f10013n);
                }
                C3105e.m9461a(new RunnableC3081d(16, this.f10004e, Integer.valueOf(i2), this.f10001b, Boolean.valueOf(z), Boolean.valueOf(z2)));
            }
            if (i2 != 0 && z && !z2 && this.f10001b == null) {
                if (this.f10005f != null) {
                    C3105e.m9461a(new RunnableC3081d(18, this.f10005f, -1, Boolean.valueOf(z)));
                } else {
                    C3105e.m9461a(new RunnableC3081d(5, Beta.strToastCheckUpgradeError));
                }
                return;
            }
            if (this.f10001b != null && this.f10001b.f9988a != null) {
                if (this.f10002c == null) {
                    this.f10002c = m9378b();
                }
                this.f10002c.addListener(this.f10013n);
                if (this.f10005f != null) {
                    C3105e.m9461a(new RunnableC3081d(18, this.f10005f, 0, Boolean.valueOf(z)));
                }
                if (this.f10004e != null) {
                    return;
                }
                if (!z && this.f10001b.f9988a.f10838g != 2) {
                    if (this.f10001b.f9991d && C3082e.f9867G.f9905g) {
                        if ((C3078a.m9321a(C3082e.f9867G.f9919u) == 1 && C3082e.f9867G.f9888U) || (C3078a.m9321a(C3082e.f9867G.f9919u) == 4 && C3082e.f9867G.f9889V)) {
                            m9379c();
                            return;
                        } else {
                            if (!z2) {
                                m9377a(z);
                            }
                            return;
                        }
                    }
                    if (this.f10001b.f9990c + this.f10001b.f9988a.f10840i > System.currentTimeMillis() || this.f10001b.f9988a.f10839h - this.f10001b.f9989b <= 0 || this.f10001b.f9988a.f10838g == 3) {
                        return;
                    }
                }
                if (((C3078a.m9321a(C3082e.f9867G.f9919u) == 1 && C3082e.f9867G.f9888U) || (C3078a.m9321a(C3082e.f9867G.f9919u) == 4 && C3082e.f9867G.f9889V)) && !z) {
                    m9379c();
                } else if (!z2) {
                    m9377a(z);
                }
            } else if (this.f10005f != null) {
                C3105e.m9461a(new RunnableC3081d(18, this.f10005f, 1, Boolean.valueOf(z)));
            } else if (z && !z2) {
                C3105e.m9461a(new RunnableC3081d(5, Beta.strToastYourAreTheLatestVersion));
            }
        }
    }

    /* renamed from: a */
    private C3200y m9375a() {
        BetaGrayStrategy betaGrayStrategy = this.f10001b;
        if (betaGrayStrategy == null) {
            return null;
        }
        return betaGrayStrategy.f9988a;
    }

    /* renamed from: a */
    private void m9377a(boolean z) {
        C3200y m9375a = m9375a();
        if (m9375a == null) {
            return;
        }
        if (System.currentTimeMillis() <= m9375a.m10150a() - 86400000) {
            C3151an.m9923e(System.currentTimeMillis() + "ms", new Object[0]);
            return;
        }
        C3083f.f9925a.m9341a(C3082e.f9867G.f9916r, m9375a.f10843l);
        if (this.f10002c == null) {
            this.f10002c = m9378b();
        }
        DownloadTask downloadTask = this.f10002c;
        if (downloadTask == null) {
            return;
        }
        if (!z && downloadTask.getStatus() == 2) {
            C3151an.m9915a("Task is downloading %s %s", m9375a.f10844m, this.f10002c.getDownloadUrl());
            return;
        }
        this.f10002c.addListener(this.f10013n);
        DownloadListener downloadListener = this.f10003d;
        if (downloadListener != null) {
            this.f10002c.addListener(downloadListener);
        }
        C3097h c3097h = C3097h.f9972v;
        c3097h.m9364a(m9375a, this.f10002c);
        c3097h.f9980r = new RunnableC3081d(3, this.f10001b, this.f10002c);
        c3097h.f9981s = new RunnableC3081d(4, this.f10001b, this.f10002c, Boolean.valueOf(z));
        this.f10001b.f9990c = System.currentTimeMillis();
        m9376a(this.f10001b);
        if (z) {
            C3083f.f9925a.m9343a(new RunnableC3081d(2, c3097h, Boolean.valueOf(z)), PathInterpolatorCompat.MAX_NUM_POINTS);
            return;
        }
        C3083f c3083f = C3083f.f9925a;
        Object[] objArr = new Object[2];
        objArr[0] = c3097h;
        objArr[1] = Boolean.valueOf(z || m9375a.f10838g == 2);
        c3083f.m9342a(new RunnableC3081d(2, objArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0076, code lost:
    
        if (r7 == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x007a, code lost:
    
        if (r7.f9988a == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0080, code lost:
    
        if (r7.f9988a.f10847p != 3) goto L128;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x008b A[Catch: all -> 0x0191, TryCatch #0 {, blocks: (B:4:0x001c, B:6:0x002d, B:8:0x0086, B:10:0x008b, B:12:0x0091, B:14:0x0095, B:17:0x009a, B:18:0x009c, B:22:0x00b2, B:25:0x0183, B:26:0x018f, B:30:0x0179, B:32:0x017d, B:37:0x00bc, B:38:0x00bd, B:40:0x00c5, B:41:0x00c9, B:51:0x016a, B:53:0x0170, B:60:0x003a, B:62:0x0050, B:65:0x0056, B:67:0x005a, B:72:0x0078, B:74:0x007c, B:80:0x0065, B:84:0x006c, B:56:0x00f9, B:58:0x00fd, B:45:0x010f, B:48:0x013a, B:20:0x009d, B:21:0x00b1), top: B:3:0x001c, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0175 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5 A[Catch: all -> 0x0191, TryCatch #0 {, blocks: (B:4:0x001c, B:6:0x002d, B:8:0x0086, B:10:0x008b, B:12:0x0091, B:14:0x0095, B:17:0x009a, B:18:0x009c, B:22:0x00b2, B:25:0x0183, B:26:0x018f, B:30:0x0179, B:32:0x017d, B:37:0x00bc, B:38:0x00bd, B:40:0x00c5, B:41:0x00c9, B:51:0x016a, B:53:0x0170, B:60:0x003a, B:62:0x0050, B:65:0x0056, B:67:0x005a, B:72:0x0078, B:74:0x007c, B:80:0x0065, B:84:0x006c, B:56:0x00f9, B:58:0x00fd, B:45:0x010f, B:48:0x013a, B:20:0x009d, B:21:0x00b1), top: B:3:0x001c, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m9382a(boolean r20, boolean r21, int r22) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.C3100c.m9382a(boolean, boolean, int):void");
    }

    /* renamed from: a */
    public void m9381a(C3175bk c3175bk) {
        C3082e c3082e = C3082e.f9867G;
        if (c3082e.f9875H == null) {
            c3082e.f9875H = new BetaUploadStrategy();
        }
        if (c3175bk != null) {
            BetaUploadStrategy betaUploadStrategy = C3082e.f9867G.f9875H;
            long j2 = betaUploadStrategy.f9994b;
            long j3 = c3175bk.f10707h;
            if (j2 == j3) {
                return;
            }
            betaUploadStrategy.f9994b = j3;
            C3175bk c3175bk2 = betaUploadStrategy.f9993a;
            c3175bk2.f10701b = c3175bk.f10701b;
            c3175bk2.f10702c = c3175bk.f10702c;
            c3175bk2.f10707h = j3;
            if (C3154aq.m9995c(c3175bk.f10703d)) {
                C3082e.f9867G.f9875H.f9993a.f10703d = c3175bk.f10703d;
            }
            if (C3154aq.m9995c(c3175bk.f10704e)) {
                C3082e.f9867G.f9875H.f9993a.f10704e = c3175bk.f10704e;
            }
            C3174bj c3174bj = c3175bk.f10705f;
            if (c3174bj != null && !TextUtils.isEmpty(c3174bj.f10695a)) {
                C3082e.f9867G.f9875H.f9993a.f10705f.f10695a = c3175bk.f10705f.f10695a;
            }
            Map<String, String> map = c3175bk.f10706g;
            if (map != null && map.size() > 0) {
                C3082e.f9867G.f9875H.f9993a.f10706g = c3175bk.f10706g;
            }
            if (C3154aq.m9995c(c3175bk.f10708i)) {
                C3082e.f9867G.f9875H.f9993a.f10708i = c3175bk.f10708i;
            }
            if (C3154aq.m9995c(c3175bk.f10709j)) {
                C3082e.f9867G.f9875H.f9993a.f10709j = c3175bk.f10709j;
            }
            C3078a.m9335a("us.bch", C3082e.f9867G.f9875H);
        }
    }

    /* renamed from: a */
    private void m9376a(BetaGrayStrategy betaGrayStrategy) {
        C3200y c3200y = betaGrayStrategy.f9988a;
        if (c3200y == null || c3200y.f10847p != 1) {
            return;
        }
        C3078a.m9335a("app.upgrade.strategy.bch", betaGrayStrategy);
    }
}
