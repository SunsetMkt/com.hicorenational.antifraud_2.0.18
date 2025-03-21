package com.lxj.xpermission;

import android.annotation.SuppressLint;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import util.permissionutil.C7308a;

/* compiled from: PermissionConstants.java */
@SuppressLint({"InlinedApi"})
/* renamed from: com.lxj.xpermission.b */
/* loaded from: classes.dex */
public final class C2765b {

    /* renamed from: a */
    public static final String f8533a = "android.permission-group.CALENDAR";

    /* renamed from: b */
    public static final String f8534b = "android.permission-group.CAMERA";

    /* renamed from: c */
    public static final String f8535c = "android.permission-group.CONTACTS";

    /* renamed from: d */
    public static final String f8536d = "android.permission-group.LOCATION";

    /* renamed from: e */
    public static final String f8537e = "android.permission-group.MICROPHONE";

    /* renamed from: f */
    public static final String f8538f = "android.permission-group.PHONE";

    /* renamed from: g */
    public static final String f8539g = "android.permission-group.SENSORS";

    /* renamed from: h */
    public static final String f8540h = "android.permission-group.SMS";

    /* renamed from: i */
    public static final String f8541i = "android.permission-group.STORAGE";

    /* renamed from: j */
    private static final String[] f8542j = {C7308a.f25522a, C7308a.f25523b};

    /* renamed from: k */
    private static final String[] f8543k = {C7308a.f25524c};

    /* renamed from: l */
    private static final String[] f8544l = {C7308a.f25525d, C7308a.f25526e, C7308a.f25527f};

    /* renamed from: m */
    private static final String[] f8545m = {C7308a.f25528g, C7308a.f25529h};

    /* renamed from: n */
    private static final String[] f8546n = {C7308a.f25530i};

    /* renamed from: o */
    private static final String[] f8547o = {C7308a.f25531j, C7308a.f25539r, C7308a.f25532k, C7308a.f25533l, C7308a.f25534m, C7308a.f25535n, C7308a.f25537p, C7308a.f25538q, C7308a.f25540s};

    /* renamed from: p */
    private static final String[] f8548p = {C7308a.f25531j, C7308a.f25539r, C7308a.f25532k, C7308a.f25533l, C7308a.f25534m, C7308a.f25535n, C7308a.f25537p, C7308a.f25538q};

    /* renamed from: q */
    private static final String[] f8549q = {C7308a.f25541t};

    /* renamed from: r */
    private static final String[] f8550r = {C7308a.f25542u, C7308a.f25543v, C7308a.f25544w, C7308a.f25545x, C7308a.f25546y};

    /* renamed from: s */
    private static final String[] f8551s = {C7308a.f25547z, C7308a.f25521A};

    /* compiled from: PermissionConstants.java */
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.lxj.xpermission.b$a */
    public @interface a {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static String[] m8293a(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals(f8535c)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1410061184:
                if (str.equals(f8538f)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1250730292:
                if (str.equals(f8533a)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1140935117:
                if (str.equals(f8534b)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 421761675:
                if (str.equals(f8539g)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 828638019:
                if (str.equals(f8536d)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 852078861:
                if (str.equals(f8541i)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1581272376:
                if (str.equals(f8537e)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1795181803:
                if (str.equals(f8540h)) {
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
                return f8542j;
            case 1:
                return f8543k;
            case 2:
                return f8544l;
            case 3:
                return f8545m;
            case 4:
                return f8546n;
            case 5:
                return Build.VERSION.SDK_INT < 26 ? f8548p : f8547o;
            case 6:
                return f8549q;
            case 7:
                return f8550r;
            case '\b':
                return f8551s;
            default:
                return new String[]{str};
        }
    }
}
