package util.permissionutil;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.hicorenational.antifraud.R;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.cw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: Permission.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String A = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String a = "android.permission.READ_CALENDAR";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15025b = "android.permission.WRITE_CALENDAR";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15026c = "android.permission.CAMERA";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f15027d = "android.permission.READ_CONTACTS";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f15028e = "android.permission.WRITE_CONTACTS";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f15029f = "android.permission.GET_ACCOUNTS";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f15030g = "android.permission.ACCESS_FINE_LOCATION";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f15031h = "android.permission.ACCESS_COARSE_LOCATION";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f15032i = "android.permission.RECORD_AUDIO";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f15033j = "android.permission.READ_PHONE_STATE";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f15034k = "android.permission.CALL_PHONE";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f15035l = "android.permission.READ_CALL_LOG";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f15036m = "android.permission.WRITE_CALL_LOG";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f15037n = "com.android.voicemail.permission.ADD_VOICEMAIL";
    static final String o = "android.permission.ADD_VOICEMAIL";
    public static final String p = "android.permission.USE_SIP";
    public static final String q = "android.permission.PROCESS_OUTGOING_CALLS";
    public static final String r = "android.permission.READ_PHONE_NUMBERS";
    public static final String s = "android.permission.ANSWER_PHONE_CALLS";
    public static final String t = "android.permission.BODY_SENSORS";
    public static final String u = "android.permission.SEND_SMS";
    public static final String v = "android.permission.RECEIVE_SMS";
    public static final String w = "android.permission.READ_SMS";
    public static final String x = "android.permission.RECEIVE_WAP_PUSH";
    public static final String y = "android.permission.RECEIVE_MMS";
    public static final String z = "android.permission.READ_EXTERNAL_STORAGE";

    /* JADX INFO: renamed from: util.permissionutil.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Permission.java */
    public static final class C0326a {
        public static final String[] a = {a.a, a.f15025b};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f15038b = {a.f15026c};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f15039c = {a.f15027d, a.f15028e, a.f15029f};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String[] f15040d = {a.f15030g, a.f15031h};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String[] f15041e = {a.f15032i};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String[] f15042f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String[] f15043g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String[] f15044h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String[] f15045i;

        static {
            if (Build.VERSION.SDK_INT >= 26) {
                f15042f = new String[]{a.f15033j, a.f15034k, a.f15035l, a.f15036m, a.f15037n, a.p, a.q, a.r, a.s};
            } else {
                f15042f = new String[]{a.f15033j, a.f15034k, a.f15035l, a.f15036m, a.f15037n, a.p, a.q};
            }
            f15043g = new String[]{a.t};
            f15044h = new String[]{a.u, a.v, a.w, a.x, a.y};
            f15045i = new String[]{a.z, a.A};
        }
    }

    public static List<String> a(Context context, String... strArr) {
        return a(context, (List<String>) Arrays.asList(strArr));
    }

    @NonNull
    public static void b(Activity activity) {
        try {
            activity.startActivity(a(activity));
        } catch (Exception unused) {
            activity.startActivity(a((Context) activity));
        }
    }

    private static Intent c(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            return a(context);
        }
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    private static Intent d(Context context) {
        return a(context);
    }

    private static Intent e(Context context) {
        return a(context);
    }

    private static Intent f(Context context) {
        return a(context);
    }

    private static Intent g(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        if (Build.VERSION.SDK_INT >= 25) {
            intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
        } else {
            intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        }
        return intent;
    }

    private static Intent h(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }

    public static List<String> a(Context context, String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            arrayList.addAll(Arrays.asList(strArr2));
        }
        return a(context, arrayList);
    }

    private static Intent b(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static List<String> a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            byte b2 = -1;
            switch (str.hashCode()) {
                case -2062386608:
                    if (str.equals(w)) {
                        b2 = 22;
                    }
                    break;
                case -1928411001:
                    if (str.equals(a)) {
                        b2 = 0;
                    }
                    break;
                case -1921431796:
                    if (str.equals(f15035l)) {
                        b2 = 11;
                    }
                    break;
                case -1888586689:
                    if (str.equals(f15030g)) {
                        b2 = 6;
                    }
                    break;
                case -1674700861:
                    if (str.equals(s)) {
                        b2 = 18;
                    }
                    break;
                case -1479758289:
                    if (str.equals(x)) {
                        b2 = 23;
                    }
                    break;
                case -1238066820:
                    if (str.equals(t)) {
                        b2 = 19;
                    }
                    break;
                case -1164582768:
                    if (str.equals(r)) {
                        b2 = 17;
                    }
                    break;
                case -895679497:
                    if (str.equals(y)) {
                        b2 = 24;
                    }
                    break;
                case -895673731:
                    if (str.equals(v)) {
                        b2 = 21;
                    }
                    break;
                case -406040016:
                    if (str.equals(z)) {
                        b2 = 25;
                    }
                    break;
                case -63024214:
                    if (str.equals(f15031h)) {
                        b2 = 7;
                    }
                    break;
                case -5573545:
                    if (str.equals(f15033j)) {
                        b2 = 9;
                    }
                    break;
                case 52602690:
                    if (str.equals(u)) {
                        b2 = 20;
                    }
                    break;
                case 112197485:
                    if (str.equals(f15034k)) {
                        b2 = 10;
                    }
                    break;
                case 214526995:
                    if (str.equals(f15028e)) {
                        b2 = 4;
                    }
                    break;
                case 463403621:
                    if (str.equals(f15026c)) {
                        b2 = 2;
                    }
                    break;
                case 603653886:
                    if (str.equals(f15025b)) {
                        b2 = 1;
                    }
                    break;
                case 610633091:
                    if (str.equals(f15036m)) {
                        b2 = 12;
                    }
                    break;
                case 784519842:
                    if (str.equals(p)) {
                        b2 = cw.f7205m;
                    }
                    break;
                case 952819282:
                    if (str.equals(q)) {
                        b2 = cw.f7206n;
                    }
                    break;
                case 1271781903:
                    if (str.equals(f15029f)) {
                        b2 = 5;
                    }
                    break;
                case 1365911975:
                    if (str.equals(A)) {
                        b2 = 26;
                    }
                    break;
                case 1831139720:
                    if (str.equals(f15032i)) {
                        b2 = 8;
                    }
                    break;
                case 1897049163:
                    if (str.equals(o)) {
                        b2 = cw.f7204l;
                    }
                    break;
                case 1977429404:
                    if (str.equals(f15027d)) {
                        b2 = 3;
                    }
                    break;
                case 2133799037:
                    if (str.equals(f15037n)) {
                        b2 = cw.f7203k;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                case 1:
                    String string = context.getString(R.string.permission_name_calendar);
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                    }
                    break;
                case 2:
                    String string2 = context.getString(R.string.permission_name_camera);
                    if (!arrayList.contains(string2)) {
                        arrayList.add(string2);
                    }
                    break;
                case 3:
                case 4:
                    String string3 = context.getString(R.string.permission_name_contacts);
                    if (!arrayList.contains(string3)) {
                        arrayList.add(string3);
                    }
                    break;
                case 5:
                    String string4 = context.getString(R.string.permission_name_accounts);
                    if (!arrayList.contains(string4)) {
                        arrayList.add(string4);
                    }
                    break;
                case 6:
                case 7:
                    String string5 = context.getString(R.string.permission_name_location);
                    if (!arrayList.contains(string5)) {
                        arrayList.add(string5);
                    }
                    break;
                case 8:
                    String string6 = context.getString(R.string.permission_name_microphone);
                    if (!arrayList.contains(string6)) {
                        arrayList.add(string6);
                    }
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    String string7 = context.getString(R.string.permission_name_phone);
                    if (!arrayList.contains(string7)) {
                        arrayList.add(string7);
                    }
                    break;
                case 19:
                    String string8 = context.getString(R.string.permission_name_sensors);
                    if (!arrayList.contains(string8)) {
                        arrayList.add(string8);
                    }
                    break;
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    String string9 = context.getString(R.string.permission_name_sms);
                    if (!arrayList.contains(string9)) {
                        arrayList.add(string9);
                    }
                    break;
                case 25:
                case 26:
                    String string10 = context.getString(R.string.permission_name_storage);
                    if (!arrayList.contains(string10)) {
                        arrayList.add(string10);
                    }
                    break;
            }
        }
        return arrayList;
    }

    private static Intent a(Activity activity) {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains("huawei")) {
            return b((Context) activity);
        }
        if (lowerCase.contains("xiaomi")) {
            return h(activity);
        }
        if (lowerCase.contains("oppo")) {
            return d(activity);
        }
        if (lowerCase.contains("vivo")) {
            return g(activity);
        }
        if (lowerCase.contains("samsung")) {
            return e(activity);
        }
        if (lowerCase.contains("meizu")) {
            return c(activity);
        }
        if (lowerCase.contains("smartisan")) {
            return f(activity);
        }
        return a((Context) activity);
    }

    private static Intent a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }
}
