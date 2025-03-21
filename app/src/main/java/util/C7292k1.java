package util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import bean.SmsBean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p014u.C0052a;
import p245d.C4443d;
import p388ui.activity.WebFullActivity;

/* compiled from: IntentUtils.java */
/* renamed from: util.k1 */
/* loaded from: classes2.dex */
public class C7292k1 {

    /* renamed from: A */
    public static final String f25333A = "value_apps_warn";

    /* renamed from: A0 */
    public static final String f25334A0 = "extra_group_invite_id";

    /* renamed from: B */
    public static final String f25335B = "report_his_time";

    /* renamed from: B0 */
    public static final String f25336B0 = "extra_group_invite_master";

    /* renamed from: C */
    public static final String f25337C = "turn_page_type";

    /* renamed from: C0 */
    public static final String f25338C0 = "survey_case_ID";

    /* renamed from: D */
    public static final int f25339D = 1;

    /* renamed from: D0 */
    public static final String f25340D0 = "survey_case_num";

    /* renamed from: E */
    public static final String f25341E = "int_phone_code";

    /* renamed from: E0 */
    public static final String f25342E0 = "survey_case_phone";

    /* renamed from: F */
    public static final String f25343F = "int_forget_phone";

    /* renamed from: F0 */
    public static final String f25344F0 = "select_list_item";

    /* renamed from: G */
    public static final String f25345G = "int_forget_phone_code";

    /* renamed from: G0 */
    public static final String f25346G0 = "conversation_id";

    /* renamed from: H */
    public static final String f25347H = "int_forget_phone_resetpwd";

    /* renamed from: H0 */
    public static final String f25348H0 = "chat_record_type";

    /* renamed from: I */
    public static int f25349I = 0;

    /* renamed from: I0 */
    public static final String f25350I0 = "chat_position";

    /* renamed from: J */
    public static int f25351J = 1;

    /* renamed from: J0 */
    public static final String f25352J0 = "extra_chat_typetxt";

    /* renamed from: K */
    public static int f25353K = 2;

    /* renamed from: K0 */
    public static final String f25354K0 = "extra_ocr_help";

    /* renamed from: L */
    public static int f25355L = 3;

    /* renamed from: L0 */
    public static final int f25356L0 = 1;

    /* renamed from: M */
    public static final String f25357M = "platm_type";

    /* renamed from: M0 */
    public static final int f25358M0 = 2;

    /* renamed from: N */
    public static final String f25359N = "open_id";

    /* renamed from: N0 */
    public static final int f25360N0 = 3;

    /* renamed from: O */
    public static final String f25361O = "int_tag_name";

    /* renamed from: O0 */
    public static final String f25362O0 = "extra_one_record_type";

    /* renamed from: P */
    public static final String f25363P = "extra_web_title";

    /* renamed from: P0 */
    public static final String f25364P0 = "extra_one_record_audio";

    /* renamed from: Q */
    public static final String f25365Q = "extra_web_url";

    /* renamed from: Q0 */
    public static final String f25366Q0 = "extra_one_record_video";

    /* renamed from: R */
    public static final String f25367R = "extra_web_img";

    /* renamed from: R0 */
    public static final String f25368R0 = "extra_one_record_path";

    /* renamed from: S */
    public static final String f25369S = "extra_web_desc";

    /* renamed from: S0 */
    public static final String f25370S0 = "extra_one_record_name";

    /* renamed from: T */
    public static final String f25371T = "extra_web_id";

    /* renamed from: T0 */
    public static final String f25372T0 = "extra_one_record_duration";

    /* renamed from: U */
    public static final String f25373U = "extra_web_enter";

    /* renamed from: U0 */
    public static final int f25374U0 = 0;

    /* renamed from: V */
    public static final String f25375V = "extra_web_theme_caragy";

    /* renamed from: V0 */
    public static final int f25376V0 = 1;

    /* renamed from: W */
    public static final int f25377W = 1;

    /* renamed from: W0 */
    public static final int f25378W0 = 2;

    /* renamed from: X */
    public static final int f25379X = 2;

    /* renamed from: X0 */
    public static final String f25380X0 = "extra_node_type";

    /* renamed from: Y */
    public static final int f25381Y = 3;

    /* renamed from: Y0 */
    public static final int f25382Y0 = 1;

    /* renamed from: Z */
    public static final String f25383Z = "extra_web_personalize";

    /* renamed from: Z0 */
    public static final int f25384Z0 = 2;

    /* renamed from: a */
    public static final String f25385a = "com.coolapk.market";

    /* renamed from: a0 */
    public static final String f25386a0 = "extra_web_personalize_ad";

    /* renamed from: a1 */
    public static final int f25387a1 = 3;

    /* renamed from: b */
    public static final String f25388b = "from_page_bean_extra";

    /* renamed from: b0 */
    public static final String f25389b0 = "extra_name";

    /* renamed from: b1 */
    public static final int f25390b1 = 4;

    /* renamed from: c */
    public static final String f25391c = "from_page_bean";

    /* renamed from: c0 */
    public static final String f25392c0 = "extra_id_info";

    /* renamed from: c1 */
    public static final int f25393c1 = 5;

    /* renamed from: d */
    public static final String f25394d = "from_page_type";

    /* renamed from: d0 */
    public static final String f25395d0 = "extra_id_number";

    /* renamed from: d1 */
    public static final int f25396d1 = 6;

    /* renamed from: e */
    public static final String f25397e = "from_page_tag";

    /* renamed from: e0 */
    public static final String f25398e0 = "phone_number";

    /* renamed from: e1 */
    public static final String f25399e1 = "1";

    /* renamed from: f */
    public static final int f25400f = 1;

    /* renamed from: f0 */
    public static final String f25401f0 = "extra_text";

    /* renamed from: f1 */
    public static final String f25402f1 = "2";

    /* renamed from: g */
    public static final int f25403g = 2;

    /* renamed from: g0 */
    public static final String f25404g0 = "extra_code";

    /* renamed from: g1 */
    public static final String f25405g1 = "3";

    /* renamed from: h */
    public static final int f25406h = 3;

    /* renamed from: h0 */
    public static final String f25407h0 = "extra_msg";

    /* renamed from: h1 */
    public static final String f25408h1 = "4";

    /* renamed from: i */
    public static final String f25409i = "int_detial";

    /* renamed from: i0 */
    public static final String f25410i0 = "extra_json_null";

    /* renamed from: i1 */
    public static final String f25411i1 = "extra_feedback_id";

    /* renamed from: j */
    public static final String f25412j = "int_casefrautype";

    /* renamed from: j0 */
    public static final String f25413j0 = "extra_trift_id";

    /* renamed from: j1 */
    public static final String f25414j1 = "extra_payment_type";

    /* renamed from: k */
    public static final String f25415k = "int_casefrautxt";

    /* renamed from: k0 */
    public static final String f25416k0 = "extra_trift_name";

    /* renamed from: k1 */
    public static String f25417k1 = "record_intercepte";

    /* renamed from: l */
    public static final String f25418l = "int_caseregion";

    /* renamed from: l0 */
    public static final String f25419l0 = "extra_trift_api";

    /* renamed from: m */
    public static final String f25420m = "int_casedesc";

    /* renamed from: m0 */
    public static final String f25421m0 = "extra_check_fraud_result";

    /* renamed from: n */
    public static final String f25422n = "int_websit";

    /* renamed from: n0 */
    public static final String f25423n0 = "extra_check_fraud_share";

    /* renamed from: o */
    public static final String f25424o = "int_socail";

    /* renamed from: o0 */
    public static final String f25425o0 = "extra_check_fraud_type";

    /* renamed from: p */
    public static final String f25426p = "int_audio";

    /* renamed from: p0 */
    public static final String f25427p0 = "extra_check_fraud_type_pay";

    /* renamed from: q */
    public static final String f25428q = "int_suspect_id";

    /* renamed from: q0 */
    public static final String f25429q0 = "extra_check_fraud_type_url";

    /* renamed from: r */
    public static final String f25430r = "int_trad";

    /* renamed from: r0 */
    public static final int f25431r0 = 1;

    /* renamed from: s */
    public static final String f25432s = "int_call";

    /* renamed from: s0 */
    public static final int f25433s0 = 2;

    /* renamed from: t */
    public static final String f25434t = "int_apps";

    /* renamed from: t0 */
    public static final int f25435t0 = 3;

    /* renamed from: u */
    public static final String f25436u = "int_SMS";

    /* renamed from: u0 */
    public static final int f25437u0 = 4;

    /* renamed from: v */
    public static final String f25438v = "int_social_pos";

    /* renamed from: v0 */
    public static final int f25439v0 = 5;

    /* renamed from: w */
    public static final String f25440w = "int_social_bean";

    /* renamed from: w0 */
    public static final int f25441w0 = 7;

    /* renamed from: x */
    public static final String f25442x = "int_apps_virus";

    /* renamed from: x0 */
    public static final String f25443x0 = "extra_group";

    /* renamed from: y */
    public static final String f25444y = "extra_apps_type";

    /* renamed from: y0 */
    public static final String f25445y0 = "extra_group_id";

    /* renamed from: z */
    public static final String f25446z = "value_apps_virus";

    /* renamed from: z0 */
    public static final String f25447z0 = "extra_group_api";

    /* renamed from: a */
    public static void m26392a(Activity activity, Uri uri, int i2) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        File file = new File(C4443d.f16963k + C4443d.f16943a);
        if (Build.VERSION.SDK_INT < 24) {
            intent.setDataAndType(uri, "image/*");
        } else {
            File m26343a = uri != null ? C7277f1.m26343a(activity, uri) : file;
            intent.addFlags(128);
            intent.setDataAndType(C7277f1.m26341a(activity, m26343a), "image/*");
        }
        intent.putExtra("crop", C0052a.f158j);
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", i2);
        intent.putExtra("outputY", i2);
        intent.putExtra("circleCrop", true);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("output", Uri.fromFile(file));
        intent.putExtra("return-data", false);
        C7325u1.m26630b(C4443d.f16947c, Uri.fromFile(file).toString());
        activity.startActivityForResult(intent, 100);
    }

    /* renamed from: b */
    public static void m26397b(Activity activity, String str) {
        Uri uriForFile;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Toast.makeText(activity.getApplicationContext(), "请确认已经插入SD卡", 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        File file = new File(C4443d.f16963k);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (Build.VERSION.SDK_INT < 24) {
            uriForFile = Uri.fromFile(new File(str));
        } else {
            new ContentValues(1).put("_data", str);
            uriForFile = FileProvider.getUriForFile(activity.getApplicationContext(), activity.getPackageName() + ".fileprovider", new File(str));
        }
        intent.putExtra("output", uriForFile);
        activity.startActivityForResult(intent, 101);
    }

    /* renamed from: c */
    public static boolean m26399c(Context context) {
        Intent intent = new Intent("com.iqoo.secure");
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
        try {
            return m26396a(context, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    public static Intent m26400d(Context context) {
        Intent intent;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
            } else {
                intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
            }
            return intent;
        } catch (Exception unused) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        }
    }

    /* renamed from: e */
    public static void m26401e(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    /* renamed from: f */
    public static void m26402f(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=20000056")));
        } catch (Exception unused) {
            Toast.makeText(context, "无法跳转到支付宝，请检查您是否安装了支付宝！", 0).show();
        }
    }

    /* renamed from: g */
    public static void m26403g(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=10000007")));
        } catch (Exception unused) {
            Toast.makeText(context, "无法跳转到支付宝，请检查您是否安装了支付宝！", 0).show();
        }
    }

    /* renamed from: h */
    public static void m26404h(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("weixin://")));
        } catch (Exception unused) {
            Toast.makeText(context, "无法跳转到微信，请检查您是否安装了微信！", 0).show();
        }
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: i */
    public static void m26405i(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            intent.setFlags(335544320);
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* renamed from: j */
    public static void m26406j(Context context) {
        Intent intent = new Intent();
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            } else if (Build.VERSION.SDK_INT <= 8) {
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
            }
            context.startActivity(intent);
        } catch (Exception unused) {
            context.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    /* renamed from: b */
    public static boolean m26398b(Context context) {
        try {
            return ((Integer) AppOpsManager.class.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), 24, Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName())).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m26391a(Activity activity) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        activity.startActivityForResult(intent, 102);
    }

    /* renamed from: a */
    private static boolean m26396a(Context context, Intent intent) {
        if (context.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) {
            return false;
        }
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: a */
    public static boolean m26395a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            return true;
        }
        if (i2 >= 23) {
            try {
                return Settings.canDrawOverlays(context);
            } catch (Exception unused) {
                return m26398b(context);
            }
        }
        try {
            Class<?> cls = Class.forName("android.content.Context");
            Field declaredField = cls.getDeclaredField("APP_OPS_SERVICE");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            if (!(obj instanceof String)) {
                return false;
            }
            Object invoke = cls.getMethod("getSystemService", String.class).invoke(context, (String) obj);
            Class<?> cls2 = Class.forName("android.app.AppOpsManager");
            Field declaredField2 = cls2.getDeclaredField("MODE_ALLOWED");
            declaredField2.setAccessible(true);
            return ((Integer) cls2.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(invoke, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == declaredField2.getInt(cls2);
        } catch (Exception unused2) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m26394a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setComponent(null);
        intent.setSelector(null);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static Intent m26390a(Intent intent, HashMap<String, Object> hashMap) {
        try {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if (value instanceof List) {
                    intent.putParcelableArrayListExtra(key, (ArrayList) value);
                } else if (value instanceof SmsBean) {
                    intent.putExtra(key, (SmsBean) value);
                } else {
                    intent.putExtra(key, (String) value);
                }
            }
            return intent;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new Intent();
        }
    }

    /* renamed from: a */
    public static void m26393a(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) WebFullActivity.class);
        intent.putExtra(f25365Q, str);
        activity.startActivity(intent);
    }
}
