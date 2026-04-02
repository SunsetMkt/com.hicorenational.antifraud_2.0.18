package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.bj;
import com.tencent.bugly.proguard.bk;
import com.tencent.bugly.proguard.m;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static c a = new c();

    /* JADX INFO: renamed from: b */
    public BetaGrayStrategy f6078b;

    /* JADX INFO: renamed from: c */
    public DownloadTask f6079c;

    /* JADX INFO: renamed from: d */
    public DownloadListener f6080d;

    /* JADX INFO: renamed from: e */
    public UpgradeListener f6081e;

    /* JADX INFO: renamed from: f */
    public UpgradeStateListener f6082f;

    /* JADX INFO: renamed from: g */
    public boolean f6083g;

    /* JADX INFO: renamed from: h */
    public boolean f6084h;

    /* JADX INFO: renamed from: i */
    public d f6085i;

    /* JADX INFO: renamed from: j */
    public d f6086j;

    /* JADX INFO: renamed from: k */
    public int f6087k;

    /* JADX INFO: renamed from: l */
    private final Object f6088l = new Object();

    /* JADX INFO: renamed from: m */
    private final Object f6089m = new Object();

    /* JADX INFO: renamed from: n */
    private DownloadListener f6090n = new com.tencent.bugly.beta.download.a(3, this, 0);
    private a o = null;
    private d p;
    private boolean q;
    private int r;

    private DownloadTask b() {
        y yVarA = a();
        if (yVarA == null) {
            return null;
        }
        if (this.f6079c == null) {
            e eVar = e.G;
            this.f6079c = eVar.r.a(yVarA.f6599f.f6568b, eVar.v.getAbsolutePath(), null, this.f6078b.a.f6599f.a);
            this.f6079c.setDownloadType(1);
        }
        return this.f6079c;
    }

    private void c() {
        y yVarA = a();
        if (yVarA == null) {
            return;
        }
        if (this.f6079c == null) {
            this.f6079c = b();
        }
        if (this.f6079c == null) {
            return;
        }
        a(this.f6078b);
        BetaReceiver.addTask(this.f6079c);
        if (this.f6079c.getStatus() != 1 || this.f6084h) {
            this.f6079c.download();
        } else if (this.f6083g && com.tencent.bugly.beta.global.a.a(e.G.u, this.f6079c.getSaveFile(), yVarA.f6599f.a)) {
            p.a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, yVarA.f6598e, yVarA.f6606m, yVarA.p, null));
        } else {
            a(this.f6083g);
        }
    }

    public BetaGrayStrategy a(y yVar) {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        y yVar2 = yVar;
        synchronized (this.f6088l) {
            BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            betaGrayStrategy = null;
            if (betaGrayStrategy3 != null && betaGrayStrategy3.a == null) {
                com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                betaGrayStrategy3 = null;
            }
            if (betaGrayStrategy3 != null && betaGrayStrategy3.a != null && (betaGrayStrategy3.a.f6598e.f6574c < e.G.y || ((betaGrayStrategy3.a.f6598e.f6574c == e.G.y && betaGrayStrategy3.a.f6598e.f6576e <= e.G.q) || betaGrayStrategy3.a.f6607n != 1 || (betaGrayStrategy3.a.f6599f != null && TextUtils.equals(e.G.x, betaGrayStrategy3.a.f6599f.a))))) {
                com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                this.f6079c = null;
                betaGrayStrategy3 = null;
            }
            if (yVar2 != null && (yVar2.f6598e.f6574c < e.G.y || (yVar2.f6598e.f6574c == e.G.y && yVar2.f6598e.f6576e <= e.G.q))) {
                an.a("versionCode is too small, discard remote strategy: [new: %d buildno: %d] [current: %d buildno: %d]", Integer.valueOf(yVar2.f6598e.f6574c), Integer.valueOf(yVar2.f6598e.f6576e), Integer.valueOf(e.G.y), Integer.valueOf(e.G.q));
                yVar2 = null;
            }
            if (yVar2 != null) {
                if (yVar2.f6607n == 2 && betaGrayStrategy3 != null && betaGrayStrategy3.a != null && !TextUtils.isEmpty(yVar2.f6606m) && !TextUtils.isEmpty(betaGrayStrategy3.a.f6606m) && TextUtils.equals(yVar2.f6606m, betaGrayStrategy3.a.f6606m)) {
                    an.a("\u64a4\u56de strategy: %s", yVar2.f6606m);
                    betaGrayStrategy3 = null;
                }
                if (yVar2.f6607n != 1) {
                    an.a("invalid strategy: %s", yVar2.f6606m);
                    yVar2 = null;
                }
            }
            if (yVar2 != null) {
                if (betaGrayStrategy3 == null || betaGrayStrategy3.a == null || TextUtils.isEmpty(yVar2.f6606m) || TextUtils.isEmpty(betaGrayStrategy3.a.f6606m) || !TextUtils.equals(yVar2.f6606m, betaGrayStrategy3.a.f6606m)) {
                    betaGrayStrategy2 = new BetaGrayStrategy();
                } else {
                    BetaGrayStrategy betaGrayStrategy4 = new BetaGrayStrategy(aq.d(aq.a(betaGrayStrategy3)));
                    an.a("same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d", yVar2.f6606m, betaGrayStrategy3.a.f6606m, Integer.valueOf(betaGrayStrategy4.f6070b), Long.valueOf(yVar2.f6602i));
                    betaGrayStrategy2 = betaGrayStrategy4;
                }
                betaGrayStrategy2.a = yVar2;
                betaGrayStrategy2.f6073e = System.currentTimeMillis();
                if (betaGrayStrategy3 != null && !betaGrayStrategy3.a.f6599f.f6568b.equals(yVar2.f6599f.f6568b)) {
                    if (this.f6079c == null) {
                        this.f6079c = e.G.r.a(betaGrayStrategy3.a.f6599f.f6568b, e.G.v.getAbsolutePath(), null, null);
                        this.f6079c.setDownloadType(1);
                        this.f6079c.delete(true);
                        for (File file : e.G.v.listFiles()) {
                            if (!file.delete()) {
                                an.e("cannot deleteCache file:%s", file.getAbsolutePath());
                            }
                        }
                        this.f6079c = null;
                    } else {
                        BetaReceiver.netListeners.remove(this.f6079c.getDownloadUrl());
                        this.f6079c.delete(true);
                        this.f6079c = null;
                    }
                }
                a(betaGrayStrategy2);
                an.a("onUpgradeReceived: %s [type: %d]", yVar2, Integer.valueOf(yVar2.f6600g));
                p.a.a(new w("rcv", System.currentTimeMillis(), (byte) 0, 0L, yVar2.f6598e, yVar2.f6606m, yVar2.p, null));
                betaGrayStrategy = betaGrayStrategy2;
            }
        }
        return betaGrayStrategy;
    }

    public void a(boolean z, boolean z2, int i2, y yVar, String str) {
        synchronized (this.f6088l) {
            this.f6079c = null;
            this.f6078b = a(yVar);
            this.f6083g = z;
            this.f6084h = z2;
            if (this.f6081e != null) {
                an.a("\u4f60\u5df2\u653e\u5f03\u8ba9SDK\u6765\u5904\u7406\u7b56\u7565", new Object[0]);
                this.f6087k = 3;
                if (this.f6078b == null) {
                    an.a("betaStrategy is null", new Object[0]);
                    com.tencent.bugly.beta.utils.e.a(new d(5, Beta.strToastYourAreTheLatestVersion));
                    return;
                }
                if (this.f6078b.a != null && !z && (this.f6078b.f6071c + this.f6078b.a.f6602i > System.currentTimeMillis() || this.f6078b.a.f6601h - this.f6078b.f6070b <= 0)) {
                    return;
                }
                if (this.f6078b != null && this.f6079c == null) {
                    this.f6079c = e.G.r.a(this.f6078b.a.f6599f.f6568b, e.G.v.getAbsolutePath(), null, this.f6078b.a.f6599f.a);
                    this.f6079c.setDownloadType(1);
                }
                if (this.f6079c == null) {
                    an.a("\u7528\u6237\u81ea\u5b9a\u4e49activity\uff0c\u521b\u5efatask\u5931\u8d25 [strategy:%s]", this.f6078b);
                    this.f6078b = null;
                    com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                } else {
                    this.f6079c.addListener(this.f6090n);
                }
                com.tencent.bugly.beta.utils.e.a(new d(16, this.f6081e, Integer.valueOf(i2), this.f6078b, Boolean.valueOf(z), Boolean.valueOf(z2)));
            }
            if (i2 != 0 && z && !z2 && this.f6078b == null) {
                if (this.f6082f != null) {
                    com.tencent.bugly.beta.utils.e.a(new d(18, this.f6082f, -1, Boolean.valueOf(z)));
                } else {
                    com.tencent.bugly.beta.utils.e.a(new d(5, Beta.strToastCheckUpgradeError));
                }
                return;
            }
            if (this.f6078b != null && this.f6078b.a != null) {
                if (this.f6079c == null) {
                    this.f6079c = b();
                }
                this.f6079c.addListener(this.f6090n);
                if (this.f6082f != null) {
                    com.tencent.bugly.beta.utils.e.a(new d(18, this.f6082f, 0, Boolean.valueOf(z)));
                }
                if (this.f6081e != null) {
                    return;
                }
                if (!z && this.f6078b.a.f6600g != 2) {
                    if (this.f6078b.f6072d && e.G.f6023g) {
                        if ((com.tencent.bugly.beta.global.a.a(e.G.u) == 1 && e.G.U) || (com.tencent.bugly.beta.global.a.a(e.G.u) == 4 && e.G.V)) {
                            c();
                            return;
                        } else {
                            if (!z2) {
                                a(z);
                            }
                            return;
                        }
                    }
                    if (this.f6078b.f6071c + this.f6078b.a.f6602i > System.currentTimeMillis() || this.f6078b.a.f6601h - this.f6078b.f6070b <= 0 || this.f6078b.a.f6600g == 3) {
                        return;
                    }
                }
                if (((com.tencent.bugly.beta.global.a.a(e.G.u) == 1 && e.G.U) || (com.tencent.bugly.beta.global.a.a(e.G.u) == 4 && e.G.V)) && !z) {
                    c();
                } else if (!z2) {
                    a(z);
                }
            } else if (this.f6082f != null) {
                com.tencent.bugly.beta.utils.e.a(new d(18, this.f6082f, 1, Boolean.valueOf(z)));
            } else if (z && !z2) {
                com.tencent.bugly.beta.utils.e.a(new d(5, Beta.strToastYourAreTheLatestVersion));
            }
        }
    }

    private y a() {
        BetaGrayStrategy betaGrayStrategy = this.f6078b;
        if (betaGrayStrategy == null) {
            return null;
        }
        return betaGrayStrategy.a;
    }

    private void a(boolean z) {
        y yVarA = a();
        if (yVarA == null) {
            return;
        }
        if (System.currentTimeMillis() <= yVarA.a() - 86400000) {
            an.e(System.currentTimeMillis() + "ms", new Object[0]);
            return;
        }
        f.a.a(e.G.r, yVarA.f6605l);
        if (this.f6079c == null) {
            this.f6079c = b();
        }
        DownloadTask downloadTask = this.f6079c;
        if (downloadTask == null) {
            return;
        }
        if (!z && downloadTask.getStatus() == 2) {
            an.a("Task is downloading %s %s", yVarA.f6606m, this.f6079c.getDownloadUrl());
            return;
        }
        this.f6079c.addListener(this.f6090n);
        DownloadListener downloadListener = this.f6080d;
        if (downloadListener != null) {
            this.f6079c.addListener(downloadListener);
        }
        h hVar = h.v;
        hVar.a(yVarA, this.f6079c);
        hVar.r = new d(3, this.f6078b, this.f6079c);
        hVar.s = new d(4, this.f6078b, this.f6079c, Boolean.valueOf(z));
        this.f6078b.f6071c = System.currentTimeMillis();
        a(this.f6078b);
        if (z) {
            f.a.a(new d(2, hVar, Boolean.valueOf(z)), PathInterpolatorCompat.MAX_NUM_POINTS);
            return;
        }
        f fVar = f.a;
        Object[] objArr = new Object[2];
        objArr[0] = hVar;
        objArr[1] = Boolean.valueOf(z || yVarA.f6600g == 2);
        fVar.a(new d(2, objArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x008b A[Catch: all -> 0x0191, TryCatch #0 {, blocks: (B:97:0x001c, B:99:0x002d, B:130:0x0086, B:132:0x008b, B:134:0x0091, B:136:0x0095, B:139:0x009a, B:140:0x009c, B:143:0x00b2, B:175:0x0183, B:176:0x018f, B:171:0x0179, B:173:0x017d, B:147:0x00bc, B:148:0x00bd, B:150:0x00c5, B:151:0x00c9, B:165:0x016a, B:167:0x0170, B:101:0x003a, B:103:0x0050, B:106:0x0056, B:108:0x005a, B:123:0x0078, B:125:0x007c, B:112:0x0065, B:116:0x006c, B:154:0x00f9, B:156:0x00fd, B:158:0x010f, B:162:0x013a, B:141:0x009d, B:142:0x00b1), top: B:181:0x001c, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00c5 A[Catch: all -> 0x0191, TryCatch #0 {, blocks: (B:97:0x001c, B:99:0x002d, B:130:0x0086, B:132:0x008b, B:134:0x0091, B:136:0x0095, B:139:0x009a, B:140:0x009c, B:143:0x00b2, B:175:0x0183, B:176:0x018f, B:171:0x0179, B:173:0x017d, B:147:0x00bc, B:148:0x00bd, B:150:0x00c5, B:151:0x00c9, B:165:0x016a, B:167:0x0170, B:101:0x003a, B:103:0x0050, B:106:0x0056, B:108:0x005a, B:123:0x0078, B:125:0x007c, B:112:0x0065, B:116:0x006c, B:154:0x00f9, B:156:0x00fd, B:158:0x010f, B:162:0x013a, B:141:0x009d, B:142:0x00b1), top: B:181:0x001c, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0175 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0177 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2, int i2) {
        BetaGrayStrategy betaGrayStrategy;
        int i3;
        String str;
        long j2;
        an.c("requestGrayTactics strategyType:[%s]", Integer.valueOf(i2));
        synchronized (this.f6089m) {
            an.c("requestGrayTactics1 strategyType:[%s]", Integer.valueOf(i2));
            BetaGrayStrategy betaGrayStrategy2 = null;
            if (i2 != 1) {
                if (i2 == 0) {
                    BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
                    BetaGrayStrategy betaGrayStrategy4 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                    if (betaGrayStrategy3 == null || betaGrayStrategy3.a == null || betaGrayStrategy4 == null || betaGrayStrategy4.a == null) {
                        if (betaGrayStrategy3 == null || betaGrayStrategy3.a == null) {
                            betaGrayStrategy3 = betaGrayStrategy4;
                        } else if (betaGrayStrategy4 != null && betaGrayStrategy4.a != null) {
                            betaGrayStrategy3 = null;
                        }
                        if (z || betaGrayStrategy3 == null || betaGrayStrategy3.a == null || betaGrayStrategy3.a.p != 3) {
                            betaGrayStrategy = betaGrayStrategy3;
                            if (this.o != null && !this.o.f6077d && this.q == z && this.r == i2) {
                                synchronized (this.o) {
                                    this.o.f6076c[0] = Boolean.valueOf(z);
                                    this.o.f6076c[1] = Boolean.valueOf(z2);
                                }
                                this.p.f6017b[0] = false;
                                if ((z && !z2) || (betaGrayStrategy != null && betaGrayStrategy.a != null && betaGrayStrategy.a.p == 2)) {
                                    com.tencent.bugly.beta.utils.e.b(this.p);
                                    com.tencent.bugly.beta.utils.e.a(this.p, 6000L);
                                }
                            }
                            this.q = z;
                            this.r = i2;
                            if (this.o != null) {
                                this.o.f6077d = true;
                            }
                            this.o = new a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
                            this.p = new d(12, false, this.o);
                            if (betaGrayStrategy != null) {
                                try {
                                    if (betaGrayStrategy.a != null) {
                                        String str2 = betaGrayStrategy.a.f6606m;
                                        long j3 = betaGrayStrategy.a.o;
                                        i3 = betaGrayStrategy.f6070b;
                                        str = str2;
                                        j2 = j3;
                                    }
                                    HashMap map = new HashMap();
                                    map.put("hasPopTimes", "" + i3);
                                    map.put("G16", e.G.N);
                                    byte[] bArrA = ah.a((m) new z(!z ? 1 : 0, str, j2, map));
                                    an.c("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i2));
                                    b.a.a(804, i2, bArrA, this.o, z, e.G.H.a.f6493e);
                                } catch (Throwable th) {
                                    if (!an.b(th)) {
                                        th.printStackTrace();
                                    }
                                }
                                if (z) {
                                    com.tencent.bugly.beta.utils.e.b(this.p);
                                    com.tencent.bugly.beta.utils.e.a(this.p, 6000L);
                                } else {
                                    com.tencent.bugly.beta.utils.e.b(this.p);
                                    com.tencent.bugly.beta.utils.e.a(this.p, 6000L);
                                }
                            }
                            str = "";
                            j2 = 0;
                            i3 = 0;
                            HashMap map2 = new HashMap();
                            map2.put("hasPopTimes", "" + i3);
                            map2.put("G16", e.G.N);
                            byte[] bArrA2 = ah.a((m) new z(!z ? 1 : 0, str, j2, map2));
                            an.c("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i2));
                            b.a.a(804, i2, bArrA2, this.o, z, e.G.H.a.f6493e);
                            if (z) {
                            }
                        }
                    } else {
                        if (betaGrayStrategy3.f6073e > betaGrayStrategy4.f6073e) {
                        }
                        if (z) {
                        }
                        betaGrayStrategy = betaGrayStrategy3;
                        if (this.o != null) {
                            synchronized (this.o) {
                            }
                        }
                        this.q = z;
                        this.r = i2;
                        if (this.o != null) {
                        }
                        this.o = new a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
                        this.p = new d(12, false, this.o);
                        if (betaGrayStrategy != null) {
                        }
                        str = "";
                        j2 = 0;
                        i3 = 0;
                        HashMap map22 = new HashMap();
                        map22.put("hasPopTimes", "" + i3);
                        map22.put("G16", e.G.N);
                        byte[] bArrA22 = ah.a((m) new z(!z ? 1 : 0, str, j2, map22));
                        an.c("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i2));
                        b.a.a(804, i2, bArrA22, this.o, z, e.G.H.a.f6493e);
                        if (z) {
                        }
                    }
                }
            }
            betaGrayStrategy2 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            betaGrayStrategy = betaGrayStrategy2;
            if (this.o != null) {
            }
            this.q = z;
            this.r = i2;
            if (this.o != null) {
            }
            this.o = new a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
            this.p = new d(12, false, this.o);
            if (betaGrayStrategy != null) {
            }
            str = "";
            j2 = 0;
            i3 = 0;
            HashMap map222 = new HashMap();
            map222.put("hasPopTimes", "" + i3);
            map222.put("G16", e.G.N);
            byte[] bArrA222 = ah.a((m) new z(!z ? 1 : 0, str, j2, map222));
            an.c("requestGrayTactics2 strategyType:[%s]", Integer.valueOf(i2));
            b.a.a(804, i2, bArrA222, this.o, z, e.G.H.a.f6493e);
            if (z) {
            }
        }
    }

    public void a(bk bkVar) {
        e eVar = e.G;
        if (eVar.H == null) {
            eVar.H = new BetaUploadStrategy();
        }
        if (bkVar != null) {
            BetaUploadStrategy betaUploadStrategy = e.G.H;
            long j2 = betaUploadStrategy.f6074b;
            long j3 = bkVar.f6496h;
            if (j2 == j3) {
                return;
            }
            betaUploadStrategy.f6074b = j3;
            bk bkVar2 = betaUploadStrategy.a;
            bkVar2.f6490b = bkVar.f6490b;
            bkVar2.f6491c = bkVar.f6491c;
            bkVar2.f6496h = j3;
            if (aq.c(bkVar.f6492d)) {
                e.G.H.a.f6492d = bkVar.f6492d;
            }
            if (aq.c(bkVar.f6493e)) {
                e.G.H.a.f6493e = bkVar.f6493e;
            }
            bj bjVar = bkVar.f6494f;
            if (bjVar != null && !TextUtils.isEmpty(bjVar.a)) {
                e.G.H.a.f6494f.a = bkVar.f6494f.a;
            }
            Map<String, String> map = bkVar.f6495g;
            if (map != null && map.size() > 0) {
                e.G.H.a.f6495g = bkVar.f6495g;
            }
            if (aq.c(bkVar.f6497i)) {
                e.G.H.a.f6497i = bkVar.f6497i;
            }
            if (aq.c(bkVar.f6498j)) {
                e.G.H.a.f6498j = bkVar.f6498j;
            }
            com.tencent.bugly.beta.global.a.a("us.bch", e.G.H);
        }
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        y yVar = betaGrayStrategy.a;
        if (yVar == null || yVar.p != 1) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", betaGrayStrategy);
    }
}
