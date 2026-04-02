package com.lxj.xpermission;

import android.annotation.SuppressLint;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: PermissionConstants.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InlinedApi"})
public final class b {
    public static final String a = "android.permission-group.CALENDAR";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5379b = "android.permission-group.CAMERA";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5380c = "android.permission-group.CONTACTS";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5381d = "android.permission-group.LOCATION";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5382e = "android.permission-group.MICROPHONE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5383f = "android.permission-group.PHONE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5384g = "android.permission-group.SENSORS";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5385h = "android.permission-group.SMS";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5386i = "android.permission-group.STORAGE";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f5387j = {util.permissionutil.a.a, util.permissionutil.a.f15025b};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f5388k = {util.permissionutil.a.f15026c};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f5389l = {util.permissionutil.a.f15027d, util.permissionutil.a.f15028e, util.permissionutil.a.f15029f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f5390m = {util.permissionutil.a.f15030g, util.permissionutil.a.f15031h};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String[] f5391n = {util.permissionutil.a.f15032i};
    private static final String[] o = {util.permissionutil.a.f15033j, util.permissionutil.a.r, util.permissionutil.a.f15034k, util.permissionutil.a.f15035l, util.permissionutil.a.f15036m, util.permissionutil.a.f15037n, util.permissionutil.a.p, util.permissionutil.a.q, util.permissionutil.a.s};
    private static final String[] p = {util.permissionutil.a.f15033j, util.permissionutil.a.r, util.permissionutil.a.f15034k, util.permissionutil.a.f15035l, util.permissionutil.a.f15036m, util.permissionutil.a.f15037n, util.permissionutil.a.p, util.permissionutil.a.q};
    private static final String[] q = {util.permissionutil.a.t};
    private static final String[] r = {util.permissionutil.a.u, util.permissionutil.a.v, util.permissionutil.a.w, util.permissionutil.a.x, util.permissionutil.a.y};
    private static final String[] s = {util.permissionutil.a.z, util.permissionutil.a.A};

    /* JADX INFO: compiled from: PermissionConstants.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] a(String str) {
        switch (str) {
            case "android.permission-group.CALENDAR":
                return f5387j;
            case "android.permission-group.CAMERA":
                return f5388k;
            case "android.permission-group.CONTACTS":
                return f5389l;
            case "android.permission-group.LOCATION":
                return f5390m;
            case "android.permission-group.MICROPHONE":
                return f5391n;
            case "android.permission-group.PHONE":
                return Build.VERSION.SDK_INT < 26 ? p : o;
            case "android.permission-group.SENSORS":
                return q;
            case "android.permission-group.SMS":
                return r;
            case "android.permission-group.STORAGE":
                return s;
            default:
                return new String[]{str};
        }
    }
}
