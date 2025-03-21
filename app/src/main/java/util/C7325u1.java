package util;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.gson.AbstractC2063k;
import com.google.gson.C2051e;
import com.google.gson.C2067o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p388ui.Hicore;

/* compiled from: SpUtils.java */
/* renamed from: util.u1 */
/* loaded from: classes2.dex */
public class C7325u1 {

    /* renamed from: A */
    public static final String f25623A = "um_notify_home";

    /* renamed from: A0 */
    public static final String f25624A0 = "sp_virus_check_finish";

    /* renamed from: B */
    public static final String f25625B = "um_notify_setting";

    /* renamed from: B0 */
    public static final String f25626B0 = "sp_virus_check_risk";

    /* renamed from: C */
    public static final String f25627C = "um_notify_open";

    /* renamed from: C0 */
    public static final String f25628C0 = "sp_virus_app_virus";

    /* renamed from: D */
    public static final String f25629D = "call_anti_note";

    /* renamed from: D0 */
    public static final String f25630D0 = "sp_virus_app_warn";

    /* renamed from: E */
    public static final String f25631E = "notice_time";

    /* renamed from: E0 */
    public static final String f25632E0 = "sp_virus_app_ok";

    /* renamed from: F */
    public static final String f25633F = "warn_call_open";

    /* renamed from: F0 */
    public static final String f25634F0 = "sp_virus_package_virus";

    /* renamed from: G */
    public static final String f25635G = "warn_sms_open";

    /* renamed from: G0 */
    public static final String f25636G0 = "sp_virus_package_warn";

    /* renamed from: H */
    public static final String f25637H = "warn_app_open";

    /* renamed from: H0 */
    public static final String f25638H0 = "sp_virus_package_ok";

    /* renamed from: I */
    public static final String f25639I = "primiss_auto";

    /* renamed from: I0 */
    public static final String f25640I0 = "sp_virus_check_time";

    /* renamed from: J */
    public static final String f25641J = "primiss_power";

    /* renamed from: J0 */
    public static final String f25642J0 = "sp_virus_check_current_time";

    /* renamed from: K */
    public static final String f25643K = "primiss_lock";

    /* renamed from: K0 */
    public static final String f25644K0 = "sp_virus_check_elapsed_real_time";

    /* renamed from: L */
    public static final String f25645L = "complete_info_tip";

    /* renamed from: M */
    public static final String f25646M = "complete_info_TIME";

    /* renamed from: N */
    public static final String f25647N = "sp_attent_order_list";

    /* renamed from: O */
    public static final String f25648O = "key_xsnote";

    /* renamed from: P */
    public static final String f25649P = "key_call";

    /* renamed from: Q */
    public static final String f25650Q = "key_sms";

    /* renamed from: R */
    public static final String f25651R = "key_app";

    /* renamed from: S */
    public static final String f25652S = "key_pic";

    /* renamed from: T */
    public static final String f25653T = "key_audio";

    /* renamed from: U */
    public static final String f25654U = "key_vedio";

    /* renamed from: V */
    public static final String f25655V = "key_audio_state";

    /* renamed from: W */
    public static final String f25656W = "key_app_state";

    /* renamed from: X */
    public static final String f25657X = "key_pic_state";

    /* renamed from: Y */
    public static final String f25658Y = "key_vedio_state";

    /* renamed from: Z */
    public static final String f25659Z = "key_url";

    /* renamed from: a */
    private static SharedPreferences f25660a = null;

    /* renamed from: a0 */
    public static final String f25661a0 = "key_social";

    /* renamed from: b */
    public static final String f25662b = "key_app_is_first_ryn";

    /* renamed from: b0 */
    public static final String f25663b0 = "key_trad";

    /* renamed from: c */
    public static final String f25664c = "key_menu_ball_count";

    /* renamed from: c0 */
    public static final String f25665c0 = "key_report";

    /* renamed from: d */
    private static final String f25666d = "note_national";

    /* renamed from: d0 */
    public static final String f25667d0 = "key_call_repot";

    /* renamed from: e */
    public static int f25668e = 1;

    /* renamed from: e0 */
    public static final String f25669e0 = "key_sms_repot";

    /* renamed from: f */
    public static int f25670f = 2;

    /* renamed from: f0 */
    public static final String f25671f0 = "key_app_repot";

    /* renamed from: g */
    public static final int f25672g = 0;

    /* renamed from: g0 */
    public static final String f25673g0 = "key_app_report_state";

    /* renamed from: h */
    public static final int f25674h = 1;

    /* renamed from: h0 */
    public static final String f25675h0 = "key_pic_repot";

    /* renamed from: i */
    public static final int f25676i = 2;

    /* renamed from: i0 */
    public static final String f25677i0 = "key_pic_local_repot";

    /* renamed from: j */
    public static final int f25678j = 3;

    /* renamed from: j0 */
    public static final String f25679j0 = "key_pic_report_state";

    /* renamed from: k */
    public static final int f25680k = 4;

    /* renamed from: k0 */
    public static final String f25681k0 = "key_audio_repot";

    /* renamed from: l */
    public static final int f25682l = 5;

    /* renamed from: l0 */
    public static final String f25683l0 = "key_audio_report_state";

    /* renamed from: m */
    public static final int f25684m = 9;

    /* renamed from: m0 */
    public static final String f25685m0 = "key_vedio_repot";

    /* renamed from: n */
    public static String f25686n = "sp_clause_first";

    /* renamed from: n0 */
    public static final String f25687n0 = "key_vedio_report_state";

    /* renamed from: o */
    public static String f25688o = "sp_media_type";

    /* renamed from: o0 */
    public static final String f25689o0 = "key_url_repot";

    /* renamed from: p */
    public static String f25690p = "sp_apk_md5";

    /* renamed from: p0 */
    public static final String f25691p0 = "key_social_repot";

    /* renamed from: q */
    public static String f25692q = "sp_operation_first";

    /* renamed from: q0 */
    public static final String f25693q0 = "key_trad_repot";

    /* renamed from: r */
    public static String f25694r = "sp_install_other";

    /* renamed from: r0 */
    public static final String f25695r0 = "key_survey_stepone_report";

    /* renamed from: s */
    public static String f25696s = "sp_guide_version";

    /* renamed from: s0 */
    public static final String f25697s0 = "key_phone_survey";

    /* renamed from: t */
    public static String f25698t = "sp_protorol_version";

    /* renamed from: t0 */
    public static final String f25699t0 = "key_snapcard";

    /* renamed from: u */
    public static String f25700u = "sp_secret_version";

    /* renamed from: u0 */
    public static final String f25701u0 = "key_call_card";

    /* renamed from: v */
    public static String f25702v = "sp_report_up_id";

    /* renamed from: v0 */
    public static final String f25703v0 = "key_social_snap_card";

    /* renamed from: w */
    public static String f25704w = "sp_eviden_up_id";

    /* renamed from: w0 */
    public static final String f25705w0 = "key_trad_snap_card";

    /* renamed from: x */
    public static final String f25706x = "install_app";

    /* renamed from: x0 */
    public static final String f25707x0 = "sp_verified_tag";

    /* renamed from: y */
    public static final String f25708y = "update_home";

    /* renamed from: y0 */
    public static final String f25709y0 = "sp_user_bean";

    /* renamed from: z */
    public static final String f25710z = "update_home_primiss";

    /* renamed from: z0 */
    public static final String f25711z0 = "sp_check_virus_already";

    /* renamed from: a */
    public static String m26616a(String str, String str2) {
        return m26624b().getString(str, str2);
    }

    /* renamed from: b */
    private static SharedPreferences m26624b() {
        if (f25660a == null) {
            f25660a = Hicore.getApp().getSharedPreferences(f25666d, 0);
        }
        return f25660a;
    }

    /* renamed from: a */
    public static boolean m26623a(String str, boolean z) {
        return m26624b().getBoolean(str, z);
    }

    /* renamed from: a */
    public static int m26613a(String str, int i2) {
        return m26624b().getInt(str, i2);
    }

    /* renamed from: a */
    public static float m26612a(String str, float f2) {
        return m26624b().getFloat(str, f2);
    }

    /* renamed from: b */
    public static void m26630b(String str, String str2) {
        m26624b().edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    public static long m26614a(String str, long j2) {
        return m26624b().getLong(str, j2);
    }

    /* renamed from: b */
    public static String m26625b(String str) {
        return m26624b().getString(str, "");
    }

    /* renamed from: a */
    public static <T> void m26619a(T t, String str) {
        SharedPreferences.Editor edit = m26624b().edit();
        C2051e c2051e = new C2051e();
        if (t == null) {
            edit.putString(str, "");
        } else {
            edit.putString(str, c2051e.m5572a(t));
        }
        edit.commit();
    }

    /* renamed from: b */
    public static void m26631b(String str, boolean z) {
        m26624b().edit().putBoolean(str, z).apply();
    }

    /* renamed from: b */
    public static void m26628b(String str, int i2) {
        m26624b().edit().putInt(str, i2).apply();
    }

    /* renamed from: b */
    public static void m26627b(String str, float f2) {
        m26624b().edit().putFloat(str, f2).apply();
    }

    /* renamed from: b */
    public static void m26629b(String str, long j2) {
        m26624b().edit().putLong(str, j2).apply();
    }

    /* renamed from: b */
    public static void m26632b(List<String> list, String str) {
        SharedPreferences.Editor edit = m26624b().edit();
        edit.putString(str, new C2051e().m5572a(list));
        edit.commit();
    }

    /* renamed from: a */
    public static <T> T m26615a(String str, Class<T> cls) {
        C2051e c2051e = new C2051e();
        String string = m26624b().getString(str, "");
        try {
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return (T) c2051e.m5563a((AbstractC2063k) new C2067o().m5677a(string).getAsJsonObject(), (Class) cls);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static <T> List<T> m26626b(String str, Class<T> cls) {
        C2051e c2051e = new C2051e();
        String string = m26624b().getString(str, null);
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(string)) {
                Iterator<AbstractC2063k> it = new C2067o().m5677a(string).getAsJsonArray().iterator();
                while (it.hasNext()) {
                    arrayList.add(c2051e.m5563a(it.next(), (Class) cls));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <T> void m26622a(List<T> list, String str) {
        SharedPreferences.Editor edit = m26624b().edit();
        C2051e c2051e = new C2051e();
        if (list == null) {
            edit.putString(str, "");
        } else {
            edit.putString(str, c2051e.m5572a(list));
        }
        edit.commit();
    }

    /* renamed from: a */
    public static void m26621a(List<Drawable> list) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(C7277f1.m26357b(), "img.bat")));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static List<Drawable> m26618a() {
        ArrayList arrayList = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(C7277f1.m26357b(), "img.bat")));
            ArrayList arrayList2 = (ArrayList) objectInputStream.readObject();
            try {
                objectInputStream.close();
                return arrayList2;
            } catch (Exception e2) {
                e = e2;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* renamed from: a */
    public static void m26620a(String str, LinkedHashMap<String, String> linkedHashMap) {
        JSONArray jSONArray = new JSONArray();
        if (linkedHashMap == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        jSONArray.put(jSONObject);
        m26624b().edit().putString(str, jSONArray.toString()).apply();
    }

    /* renamed from: a */
    public static LinkedHashMap<String, String> m26617a(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        String string = m26624b().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return linkedHashMap;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i3 = 0; i3 < names.length(); i3++) {
                        String string2 = names.getString(i3);
                        linkedHashMap.put(string2, jSONObject.getString(string2));
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return linkedHashMap;
    }
}
