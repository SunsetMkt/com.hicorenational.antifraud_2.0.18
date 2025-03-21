package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.InterfaceC3076b;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.p205ui.UILifecycleListener;
import com.tencent.bugly.beta.upgrade.BetaUploadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.e */
/* loaded from: classes2.dex */
public class C3082e {

    /* renamed from: G */
    public static C3082e f9867G = new C3082e();

    /* renamed from: a */
    public static int f9868a;

    /* renamed from: B */
    public PackageInfo f9870B;

    /* renamed from: C */
    public SharedPreferences f9871C;

    /* renamed from: D */
    public DisplayMetrics f9872D;

    /* renamed from: H */
    public BetaUploadStrategy f9875H;

    /* renamed from: I */
    public File f9876I;

    /* renamed from: J */
    public File f9877J;

    /* renamed from: K */
    public File f9878K;

    /* renamed from: Y */
    public BetaPatchListener f9892Y;

    /* renamed from: af */
    public boolean f9899af;

    /* renamed from: h */
    public int f9906h;

    /* renamed from: i */
    public int f9907i;

    /* renamed from: j */
    public int f9908j;

    /* renamed from: k */
    public int f9909k;

    /* renamed from: l */
    public int f9910l;

    /* renamed from: m */
    public UILifecycleListener<UpgradeInfo> f9911m;

    /* renamed from: n */
    public File f9912n;

    /* renamed from: q */
    public int f9915q;

    /* renamed from: r */
    public InterfaceC3076b f9916r;

    /* renamed from: s */
    public DownloadListener f9917s;

    /* renamed from: t */
    public File f9918t;

    /* renamed from: u */
    public Context f9919u;

    /* renamed from: v */
    public File f9920v;

    /* renamed from: w */
    public String f9921w;

    /* renamed from: x */
    public String f9922x;

    /* renamed from: b */
    public long f9900b = 3000;

    /* renamed from: c */
    public long f9901c = 0;

    /* renamed from: d */
    public boolean f9902d = true;

    /* renamed from: e */
    public boolean f9903e = false;

    /* renamed from: f */
    public boolean f9904f = false;

    /* renamed from: g */
    public boolean f9905g = true;

    /* renamed from: o */
    public final List<Class<? extends Activity>> f9913o = new ArrayList();

    /* renamed from: p */
    public final List<Class<? extends Activity>> f9914p = new ArrayList();

    /* renamed from: y */
    public int f9923y = Integer.MIN_VALUE;

    /* renamed from: z */
    public String f9924z = "";

    /* renamed from: A */
    public String f9869A = "";

    /* renamed from: E */
    public boolean f9873E = true;

    /* renamed from: F */
    public boolean f9874F = false;

    /* renamed from: L */
    public String f9879L = "";

    /* renamed from: M */
    public String f9880M = "";

    /* renamed from: N */
    public String f9881N = "";

    /* renamed from: O */
    public String f9882O = "";

    /* renamed from: P */
    public boolean f9883P = false;

    /* renamed from: Q */
    public int f9884Q = 0;

    /* renamed from: R */
    public String f9885R = "";

    /* renamed from: S */
    public boolean f9886S = false;

    /* renamed from: T */
    public boolean f9887T = true;

    /* renamed from: U */
    public boolean f9888U = false;

    /* renamed from: V */
    public boolean f9889V = false;

    /* renamed from: W */
    public boolean f9890W = true;

    /* renamed from: X */
    public boolean f9891X = true;

    /* renamed from: Z */
    public boolean f9893Z = false;

    /* renamed from: aa */
    public boolean f9894aa = true;

    /* renamed from: ab */
    public boolean f9895ab = false;

    /* renamed from: ac */
    public final List<String> f9896ac = new ArrayList();

    /* renamed from: ad */
    public boolean f9897ad = false;

    /* renamed from: ae */
    public boolean f9898ae = false;

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0142, code lost:
    
        if (r8.f9920v.mkdirs() != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0152, code lost:
    
        if (r8.f9918t.mkdirs() != false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01df A[Catch: all -> 0x020b, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0023, B:8:0x0029, B:10:0x0031, B:11:0x0037, B:13:0x004b, B:14:0x0055, B:16:0x0063, B:18:0x0074, B:20:0x0085, B:22:0x008b, B:23:0x0094, B:25:0x00af, B:28:0x00b8, B:29:0x0114, B:63:0x0128, B:65:0x0134, B:67:0x013c, B:69:0x0144, B:71:0x014c, B:43:0x019f, B:45:0x01df, B:46:0x01e4, B:48:0x01ea, B:49:0x01f2, B:51:0x0202, B:35:0x0154, B:37:0x016c, B:39:0x0174, B:41:0x0178, B:56:0x0180, B:59:0x0196, B:61:0x019c, B:74:0x00f1, B:76:0x006b, B:78:0x0071), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ea A[Catch: all -> 0x020b, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0023, B:8:0x0029, B:10:0x0031, B:11:0x0037, B:13:0x004b, B:14:0x0055, B:16:0x0063, B:18:0x0074, B:20:0x0085, B:22:0x008b, B:23:0x0094, B:25:0x00af, B:28:0x00b8, B:29:0x0114, B:63:0x0128, B:65:0x0134, B:67:0x013c, B:69:0x0144, B:71:0x014c, B:43:0x019f, B:45:0x01df, B:46:0x01e4, B:48:0x01ea, B:49:0x01f2, B:51:0x0202, B:35:0x0154, B:37:0x016c, B:39:0x0174, B:41:0x0178, B:56:0x0180, B:59:0x0196, B:61:0x019c, B:74:0x00f1, B:76:0x006b, B:78:0x0071), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0202 A[Catch: all -> 0x020b, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0023, B:8:0x0029, B:10:0x0031, B:11:0x0037, B:13:0x004b, B:14:0x0055, B:16:0x0063, B:18:0x0074, B:20:0x0085, B:22:0x008b, B:23:0x0094, B:25:0x00af, B:28:0x00b8, B:29:0x0114, B:63:0x0128, B:65:0x0134, B:67:0x013c, B:69:0x0144, B:71:0x014c, B:43:0x019f, B:45:0x01df, B:46:0x01e4, B:48:0x01ea, B:49:0x01f2, B:51:0x0202, B:35:0x0154, B:37:0x016c, B:39:0x0174, B:41:0x0178, B:56:0x0180, B:59:0x0196, B:61:0x019c, B:74:0x00f1, B:76:0x006b, B:78:0x0071), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0124  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void m9339a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C3082e.m9339a(android.content.Context):void");
    }
}
