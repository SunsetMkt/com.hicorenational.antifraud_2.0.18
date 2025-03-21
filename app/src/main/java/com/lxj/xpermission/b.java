package com.lxj.xpermission;

import android.annotation.SuppressLint;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: PermissionConstants.java */
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7924a = "android.permission-group.CALENDAR";

    /* renamed from: b, reason: collision with root package name */
    public static final String f7925b = "android.permission-group.CAMERA";

    /* renamed from: c, reason: collision with root package name */
    public static final String f7926c = "android.permission-group.CONTACTS";

    /* renamed from: d, reason: collision with root package name */
    public static final String f7927d = "android.permission-group.LOCATION";

    /* renamed from: e, reason: collision with root package name */
    public static final String f7928e = "android.permission-group.MICROPHONE";

    /* renamed from: f, reason: collision with root package name */
    public static final String f7929f = "android.permission-group.PHONE";

    /* renamed from: g, reason: collision with root package name */
    public static final String f7930g = "android.permission-group.SENSORS";

    /* renamed from: h, reason: collision with root package name */
    public static final String f7931h = "android.permission-group.SMS";

    /* renamed from: i, reason: collision with root package name */
    public static final String f7932i = "android.permission-group.STORAGE";

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f7933j = {util.permissionutil.a.f20907a, util.permissionutil.a.f20908b};

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f7934k = {util.permissionutil.a.f20909c};

    /* renamed from: l, reason: collision with root package name */
    private static final String[] f7935l = {util.permissionutil.a.f20910d, util.permissionutil.a.f20911e, util.permissionutil.a.f20912f};

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f7936m = {util.permissionutil.a.f20913g, util.permissionutil.a.f20914h};
    private static final String[] n = {util.permissionutil.a.f20915i};
    private static final String[] o = {util.permissionutil.a.f20916j, util.permissionutil.a.r, util.permissionutil.a.f20917k, util.permissionutil.a.f20918l, util.permissionutil.a.f20919m, util.permissionutil.a.n, util.permissionutil.a.p, util.permissionutil.a.q, util.permissionutil.a.s};
    private static final String[] p = {util.permissionutil.a.f20916j, util.permissionutil.a.r, util.permissionutil.a.f20917k, util.permissionutil.a.f20918l, util.permissionutil.a.f20919m, util.permissionutil.a.n, util.permissionutil.a.p, util.permissionutil.a.q};
    private static final String[] q = {util.permissionutil.a.t};
    private static final String[] r = {util.permissionutil.a.u, util.permissionutil.a.v, util.permissionutil.a.w, util.permissionutil.a.x, util.permissionutil.a.y};
    private static final String[] s = {util.permissionutil.a.z, util.permissionutil.a.A};

    /* compiled from: PermissionConstants.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String[] a(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals(f7926c)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1410061184:
                if (str.equals(f7929f)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1250730292:
                if (str.equals(f7924a)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1140935117:
                if (str.equals(f7925b)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 421761675:
                if (str.equals(f7930g)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 828638019:
                if (str.equals(f7927d)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 852078861:
                if (str.equals(f7932i)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1581272376:
                if (str.equals(f7928e)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1795181803:
                if (str.equals(f7931h)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return f7933j;
            case 1:
                return f7934k;
            case 2:
                return f7935l;
            case 3:
                return f7936m;
            case 4:
                return n;
            case 5:
                return Build.VERSION.SDK_INT < 26 ? p : o;
            case 6:
                return q;
            case 7:
                return r;
            case '\b':
                return s;
            default:
                return new String[]{str};
        }
    }
}
