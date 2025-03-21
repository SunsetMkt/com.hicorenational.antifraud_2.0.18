package util.permissionutil;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.hicorenational.antifraud.C2113R;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: Permission.java */
/* renamed from: util.permissionutil.a */
/* loaded from: classes2.dex */
public class C7308a {

    /* renamed from: A */
    public static final String f25521A = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: a */
    public static final String f25522a = "android.permission.READ_CALENDAR";

    /* renamed from: b */
    public static final String f25523b = "android.permission.WRITE_CALENDAR";

    /* renamed from: c */
    public static final String f25524c = "android.permission.CAMERA";

    /* renamed from: d */
    public static final String f25525d = "android.permission.READ_CONTACTS";

    /* renamed from: e */
    public static final String f25526e = "android.permission.WRITE_CONTACTS";

    /* renamed from: f */
    public static final String f25527f = "android.permission.GET_ACCOUNTS";

    /* renamed from: g */
    public static final String f25528g = "android.permission.ACCESS_FINE_LOCATION";

    /* renamed from: h */
    public static final String f25529h = "android.permission.ACCESS_COARSE_LOCATION";

    /* renamed from: i */
    public static final String f25530i = "android.permission.RECORD_AUDIO";

    /* renamed from: j */
    public static final String f25531j = "android.permission.READ_PHONE_STATE";

    /* renamed from: k */
    public static final String f25532k = "android.permission.CALL_PHONE";

    /* renamed from: l */
    public static final String f25533l = "android.permission.READ_CALL_LOG";

    /* renamed from: m */
    public static final String f25534m = "android.permission.WRITE_CALL_LOG";

    /* renamed from: n */
    public static final String f25535n = "com.android.voicemail.permission.ADD_VOICEMAIL";

    /* renamed from: o */
    static final String f25536o = "android.permission.ADD_VOICEMAIL";

    /* renamed from: p */
    public static final String f25537p = "android.permission.USE_SIP";

    /* renamed from: q */
    public static final String f25538q = "android.permission.PROCESS_OUTGOING_CALLS";

    /* renamed from: r */
    public static final String f25539r = "android.permission.READ_PHONE_NUMBERS";

    /* renamed from: s */
    public static final String f25540s = "android.permission.ANSWER_PHONE_CALLS";

    /* renamed from: t */
    public static final String f25541t = "android.permission.BODY_SENSORS";

    /* renamed from: u */
    public static final String f25542u = "android.permission.SEND_SMS";

    /* renamed from: v */
    public static final String f25543v = "android.permission.RECEIVE_SMS";

    /* renamed from: w */
    public static final String f25544w = "android.permission.READ_SMS";

    /* renamed from: x */
    public static final String f25545x = "android.permission.RECEIVE_WAP_PUSH";

    /* renamed from: y */
    public static final String f25546y = "android.permission.RECEIVE_MMS";

    /* renamed from: z */
    public static final String f25547z = "android.permission.READ_EXTERNAL_STORAGE";

    /* compiled from: Permission.java */
    /* renamed from: util.permissionutil.a$a */
    public static final class a {

        /* renamed from: a */
        public static final String[] f25548a = {C7308a.f25522a, C7308a.f25523b};

        /* renamed from: b */
        public static final String[] f25549b = {C7308a.f25524c};

        /* renamed from: c */
        public static final String[] f25550c = {C7308a.f25525d, C7308a.f25526e, C7308a.f25527f};

        /* renamed from: d */
        public static final String[] f25551d = {C7308a.f25528g, C7308a.f25529h};

        /* renamed from: e */
        public static final String[] f25552e = {C7308a.f25530i};

        /* renamed from: f */
        public static final String[] f25553f;

        /* renamed from: g */
        public static final String[] f25554g;

        /* renamed from: h */
        public static final String[] f25555h;

        /* renamed from: i */
        public static final String[] f25556i;

        static {
            if (Build.VERSION.SDK_INT >= 26) {
                f25553f = new String[]{C7308a.f25531j, C7308a.f25532k, C7308a.f25533l, C7308a.f25534m, C7308a.f25535n, C7308a.f25537p, C7308a.f25538q, C7308a.f25539r, C7308a.f25540s};
            } else {
                f25553f = new String[]{C7308a.f25531j, C7308a.f25532k, C7308a.f25533l, C7308a.f25534m, C7308a.f25535n, C7308a.f25537p, C7308a.f25538q};
            }
            f25554g = new String[]{C7308a.f25541t};
            f25555h = new String[]{C7308a.f25542u, C7308a.f25543v, C7308a.f25544w, C7308a.f25545x, C7308a.f25546y};
            f25556i = new String[]{C7308a.f25547z, C7308a.f25521A};
        }
    }

    /* renamed from: a */
    public static List<String> m26499a(Context context, String... strArr) {
        return m26498a(context, (List<String>) Arrays.asList(strArr));
    }

    @NonNull
    /* renamed from: b */
    public static void m26502b(Activity activity) {
        try {
            activity.startActivity(m26496a(activity));
        } catch (Exception unused) {
            activity.startActivity(m26497a((Context) activity));
        }
    }

    /* renamed from: c */
    private static Intent m26503c(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            return m26497a(context);
        }
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    /* renamed from: d */
    private static Intent m26504d(Context context) {
        return m26497a(context);
    }

    /* renamed from: e */
    private static Intent m26505e(Context context) {
        return m26497a(context);
    }

    /* renamed from: f */
    private static Intent m26506f(Context context) {
        return m26497a(context);
    }

    /* renamed from: g */
    private static Intent m26507g(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        if (Build.VERSION.SDK_INT >= 25) {
            intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
        } else {
            intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        }
        return intent;
    }

    /* renamed from: h */
    private static Intent m26508h(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }

    /* renamed from: a */
    public static List<String> m26500a(Context context, String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            arrayList.addAll(Arrays.asList(strArr2));
        }
        return m26498a(context, arrayList);
    }

    /* renamed from: b */
    private static Intent m26501b(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return m26497a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    /* renamed from: a */
    public static List<String> m26498a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            switch (it.next()) {
                case "android.permission.READ_CALENDAR":
                case "android.permission.WRITE_CALENDAR":
                    String string = context.getString(C2113R.string.permission_name_calendar);
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.CAMERA":
                    String string2 = context.getString(C2113R.string.permission_name_camera);
                    if (!arrayList.contains(string2)) {
                        arrayList.add(string2);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.READ_CONTACTS":
                case "android.permission.WRITE_CONTACTS":
                    String string3 = context.getString(C2113R.string.permission_name_contacts);
                    if (!arrayList.contains(string3)) {
                        arrayList.add(string3);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.GET_ACCOUNTS":
                    String string4 = context.getString(C2113R.string.permission_name_accounts);
                    if (!arrayList.contains(string4)) {
                        arrayList.add(string4);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.ACCESS_FINE_LOCATION":
                case "android.permission.ACCESS_COARSE_LOCATION":
                    String string5 = context.getString(C2113R.string.permission_name_location);
                    if (!arrayList.contains(string5)) {
                        arrayList.add(string5);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.RECORD_AUDIO":
                    String string6 = context.getString(C2113R.string.permission_name_microphone);
                    if (!arrayList.contains(string6)) {
                        arrayList.add(string6);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.READ_PHONE_STATE":
                case "android.permission.CALL_PHONE":
                case "android.permission.READ_CALL_LOG":
                case "android.permission.WRITE_CALL_LOG":
                case "com.android.voicemail.permission.ADD_VOICEMAIL":
                case "android.permission.ADD_VOICEMAIL":
                case "android.permission.USE_SIP":
                case "android.permission.PROCESS_OUTGOING_CALLS":
                case "android.permission.READ_PHONE_NUMBERS":
                case "android.permission.ANSWER_PHONE_CALLS":
                    String string7 = context.getString(C2113R.string.permission_name_phone);
                    if (!arrayList.contains(string7)) {
                        arrayList.add(string7);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.BODY_SENSORS":
                    String string8 = context.getString(C2113R.string.permission_name_sensors);
                    if (!arrayList.contains(string8)) {
                        arrayList.add(string8);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.SEND_SMS":
                case "android.permission.RECEIVE_SMS":
                case "android.permission.READ_SMS":
                case "android.permission.RECEIVE_WAP_PUSH":
                case "android.permission.RECEIVE_MMS":
                    String string9 = context.getString(C2113R.string.permission_name_sms);
                    if (!arrayList.contains(string9)) {
                        arrayList.add(string9);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.READ_EXTERNAL_STORAGE":
                case "android.permission.WRITE_EXTERNAL_STORAGE":
                    String string10 = context.getString(C2113R.string.permission_name_storage);
                    if (!arrayList.contains(string10)) {
                        arrayList.add(string10);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static Intent m26496a(Activity activity) {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains("huawei")) {
            return m26501b((Context) activity);
        }
        if (lowerCase.contains("xiaomi")) {
            return m26508h(activity);
        }
        if (lowerCase.contains("oppo")) {
            return m26504d(activity);
        }
        if (lowerCase.contains("vivo")) {
            return m26507g(activity);
        }
        if (lowerCase.contains("samsung")) {
            return m26505e(activity);
        }
        if (lowerCase.contains("meizu")) {
            return m26503c(activity);
        }
        if (lowerCase.contains("smartisan")) {
            return m26506f(activity);
        }
        return m26497a((Context) activity);
    }

    /* renamed from: a */
    private static Intent m26497a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }
}
