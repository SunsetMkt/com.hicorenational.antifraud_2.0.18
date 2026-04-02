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

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static q a = new q();

    /* JADX INFO: renamed from: b */
    public BetaGrayStrategy f6553b;

    /* JADX INFO: renamed from: c */
    public DownloadTask f6554c;

    /* JADX INFO: renamed from: g */
    private com.tencent.bugly.beta.global.d f6558g;

    /* JADX INFO: renamed from: h */
    private boolean f6559h;

    /* JADX INFO: renamed from: d */
    public final Handler f6555d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e */
    private DownloadListener f6556e = new com.tencent.bugly.beta.download.a(4, this, 0);

    /* JADX INFO: renamed from: f */
    private com.tencent.bugly.beta.upgrade.a f6557f = null;

    /* JADX INFO: renamed from: i */
    private final Object f6560i = new Object();

    /* JADX INFO: renamed from: com.tencent.bugly.proguard.q$1 */
    /* JADX INFO: compiled from: BUGLY */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ u a;

        AnonymousClass1(u uVar) {
            uVar = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.bugly.beta.global.e.G.Y.onPatchReceived(uVar.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0057 A[Catch: all -> 0x00df, TryCatch #2 {, blocks: (B:60:0x000f, B:61:0x0019, B:63:0x001f, B:65:0x0025, B:68:0x002a, B:69:0x002c, B:72:0x0042, B:96:0x00dd, B:76:0x0050, B:77:0x0051, B:79:0x0057, B:80:0x005b, B:93:0x00d4, B:95:0x00da, B:83:0x0090, B:85:0x0094, B:86:0x009c, B:90:0x00b3, B:70:0x002d, B:71:0x0041), top: B:105:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2, int i2) {
        synchronized (this.f6560i) {
            BetaGrayStrategy betaGrayStrategy = null;
            if (i2 != 3 || z) {
                if (this.f6557f != null && !this.f6557f.f6077d && this.f6559h == z) {
                    synchronized (this.f6557f) {
                        this.f6557f.f6076c[0] = Boolean.valueOf(z);
                        this.f6557f.f6076c[1] = Boolean.valueOf(z2);
                    }
                    this.f6558g.f6017b[0] = false;
                }
                this.f6559h = z;
                if (this.f6557f != null) {
                    this.f6557f.f6077d = true;
                }
                this.f6557f = new com.tencent.bugly.beta.upgrade.a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
                this.f6558g = new com.tencent.bugly.beta.global.d(12, false, this.f6557f);
                String str = "";
                long j2 = 0;
                if (betaGrayStrategy != null) {
                    try {
                        if (betaGrayStrategy.a != null) {
                            str = betaGrayStrategy.a.f6606m;
                            j2 = betaGrayStrategy.a.o;
                        }
                    } catch (Throwable th) {
                        if (!an.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
                String str2 = str;
                long j3 = j2;
                HashMap map = new HashMap();
                map.put("G16", com.tencent.bugly.beta.global.e.G.N);
                com.tencent.bugly.beta.upgrade.b.a.a(804, i2, ah.a((m) new z(!z ? 1 : 0, str2, j3, map)), this.f6557f, z, com.tencent.bugly.beta.global.e.G.H.a.f6493e);
            } else {
                betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
                if (this.f6557f != null) {
                    synchronized (this.f6557f) {
                    }
                }
                this.f6559h = z;
                if (this.f6557f != null) {
                }
                this.f6557f = new com.tencent.bugly.beta.upgrade.a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
                this.f6558g = new com.tencent.bugly.beta.global.d(12, false, this.f6557f);
                String str3 = "";
                long j22 = 0;
                if (betaGrayStrategy != null) {
                }
                String str22 = str3;
                long j32 = j22;
                HashMap map2 = new HashMap();
                map2.put("G16", com.tencent.bugly.beta.global.e.G.N);
                com.tencent.bugly.beta.upgrade.b.a.a(804, i2, ah.a((m) new z(!z ? 1 : 0, str22, j32, map2)), this.f6557f, z, com.tencent.bugly.beta.global.e.G.H.a.f6493e);
            }
        }
    }

    public synchronized void a(int i2, y yVar, boolean z) {
        u uVarB;
        File file;
        this.f6554c = null;
        this.f6553b = a(yVar);
        if (i2 == 0 && this.f6553b != null) {
            if (this.f6553b == null || this.f6553b.a == null || this.f6553b.a.f6599f == null || (file = com.tencent.bugly.beta.global.e.G.I) == null || !file.exists() || !com.tencent.bugly.beta.global.a.a(file, this.f6553b.a.f6599f.a, "SHA")) {
                if (yVar != null) {
                    if (com.tencent.bugly.beta.global.e.G.Y != null && (uVarB = this.f6553b.a.b()) != null) {
                        this.f6555d.post(new Runnable() { // from class: com.tencent.bugly.proguard.q.1
                            final /* synthetic */ u a;

                            AnonymousClass1(u uVarB2) {
                                uVar = uVarB2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                com.tencent.bugly.beta.global.e.G.Y.onPatchReceived(uVar.a());
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
    /* JADX WARN: Removed duplicated region for block: B:145:0x018f  */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BetaGrayStrategy a(y yVar) {
        y yVar2;
        int i2;
        Map<String, String> map;
        int i3;
        y yVar3 = yVar;
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.a == null) {
            com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch");
            betaGrayStrategy = null;
        }
        if (yVar3 != null) {
            if (yVar3.f6607n != 1 && betaGrayStrategy != null && !TextUtils.isEmpty(betaGrayStrategy.a.f6606m) && TextUtils.equals(yVar3.f6606m, betaGrayStrategy.a.f6606m)) {
                p pVar = p.a;
                long jCurrentTimeMillis = System.currentTimeMillis();
                y yVar4 = betaGrayStrategy.a;
                pVar.a(new w("recall", jCurrentTimeMillis, (byte) 0, 0L, null, yVar4.f6606m, yVar4.p, null));
                com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch");
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
                DownloadTask downloadTaskA = eVar.r.a(betaGrayStrategy.a.f6599f.f6568b, eVar.K.getAbsolutePath(), null, betaGrayStrategy.a.f6599f.a);
                downloadTaskA.setDownloadType(3);
                downloadTaskA.delete(true);
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
            if (yVar3.f6607n != 1) {
                yVar3 = null;
            }
        }
        if (yVar3 == null) {
            if (betaGrayStrategy == null || (yVar2 = betaGrayStrategy.a) == null || yVar2.p != 3) {
                return null;
            }
            return betaGrayStrategy;
        }
        BetaGrayStrategy betaGrayStrategy2 = new BetaGrayStrategy();
        betaGrayStrategy2.a = yVar3;
        betaGrayStrategy2.f6073e = System.currentTimeMillis();
        if (betaGrayStrategy == null || (TextUtils.equals(betaGrayStrategy.a.f6599f.f6568b, yVar3.f6599f.f6568b) && ((map = yVar3.f6605l) == null || !TextUtils.equals(map.get("H1"), b.a.u.a.f1909k)))) {
            i2 = 0;
        } else {
            com.tencent.bugly.beta.global.e.G.O = yVar3.f6605l.get("H2");
            com.tencent.bugly.beta.global.e eVar2 = com.tencent.bugly.beta.global.e.G;
            DownloadTask downloadTaskA2 = eVar2.r.a(betaGrayStrategy.a.f6599f.f6568b, eVar2.K.getAbsolutePath(), null, null);
            downloadTaskA2.setDownloadType(3);
            downloadTaskA2.delete(true);
            if (betaGrayStrategy.a.p == 3) {
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
            }
        }
        a(betaGrayStrategy2);
        Object[] objArr = new Object[2];
        objArr[i2] = yVar3;
        objArr[1] = Integer.valueOf(yVar3.p);
        an.a("onUpgradeReceived: %s [type: %d]", objArr);
        return betaGrayStrategy2;
    }

    private void a() {
        BetaGrayStrategy betaGrayStrategy = this.f6553b;
        if (betaGrayStrategy == null) {
            return;
        }
        if (this.f6554c == null) {
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
            this.f6554c = eVar.r.a(betaGrayStrategy.a.f6599f.f6568b, eVar.K.getAbsolutePath(), null, this.f6553b.a.f6599f.a);
            this.f6554c.setDownloadType(3);
        }
        DownloadTask downloadTask = this.f6554c;
        if (downloadTask == null) {
            return;
        }
        downloadTask.addListener(this.f6556e);
        this.f6554c.setNeededNotify(false);
        this.f6554c.download();
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        y yVar = betaGrayStrategy.a;
        if (yVar == null || yVar.p != 3) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", betaGrayStrategy);
    }
}
