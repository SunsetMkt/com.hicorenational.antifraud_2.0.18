package util;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import ui.Hicore;

/* JADX INFO: compiled from: SpUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c2 {
    public static final String A = "um_notify_home";
    public static final String A0 = "sp_virus_check_finish";
    public static final String B = "um_notify_setting";
    public static final String B0 = "sp_virus_check_risk";
    public static final String C = "um_notify_open";
    public static final String C0 = "sp_virus_app_virus";
    public static final String D = "call_anti_note";
    public static final String D0 = "sp_virus_app_warn";
    public static final String E = "notice_time";
    public static final String E0 = "sp_virus_app_ok";
    public static final String F = "warn_call_open";
    public static final String F0 = "sp_virus_package_virus";
    public static final String G = "warn_sms_open";
    public static final String G0 = "sp_virus_package_warn";
    public static final String H = "warn_app_open";
    public static final String H0 = "sp_virus_package_ok";
    public static final String I = "primiss_auto";
    public static final String I0 = "sp_virus_check_time";
    public static final String J = "primiss_power";
    public static final String J0 = "sp_virus_check_current_time";
    public static final String K = "primiss_lock";
    public static final String K0 = "sp_virus_check_elapsed_real_time";
    public static final String L = "complete_info_tip";
    public static final String L0 = "sp_media_config";
    public static final String M = "complete_info_TIME";
    public static final String N = "sp_attent_order_list";
    public static final String O = "key_xsnote";
    public static final String P = "key_call";
    public static final String Q = "key_sms";
    public static final String R = "key_app";
    public static final String S = "key_pic";
    public static final String T = "key_audio";
    public static final String U = "key_vedio";
    public static final String V = "key_audio_state";
    public static final String W = "key_app_state";
    public static final String X = "key_pic_state";
    public static final String Y = "key_vedio_state";
    public static final String Z = "key_url";
    private static SharedPreferences a = null;
    public static final String a0 = "key_social";

    /* JADX INFO: renamed from: b */
    public static final String f14857b = "key_app_is_first_ryn";
    public static final String b0 = "key_trad";

    /* JADX INFO: renamed from: c */
    public static final String f14858c = "key_menu_ball_count";
    public static final String c0 = "key_report";

    /* JADX INFO: renamed from: d */
    private static final String f14859d = "note_national";
    public static final String d0 = "key_call_repot";

    /* JADX INFO: renamed from: e */
    public static int f14860e = 1;
    public static final String e0 = "key_sms_repot";

    /* JADX INFO: renamed from: f */
    public static int f14861f = 2;
    public static final String f0 = "key_app_repot";

    /* JADX INFO: renamed from: g */
    public static final int f14862g = 0;
    public static final String g0 = "key_app_report_state";

    /* JADX INFO: renamed from: h */
    public static final int f14863h = 1;
    public static final String h0 = "key_pic_repot";

    /* JADX INFO: renamed from: i */
    public static final int f14864i = 2;
    public static final String i0 = "key_pic_local_repot";

    /* JADX INFO: renamed from: j */
    public static final int f14865j = 3;
    public static final String j0 = "key_pic_report_state";

    /* JADX INFO: renamed from: k */
    public static final int f14866k = 4;
    public static final String k0 = "key_audio_repot";

    /* JADX INFO: renamed from: l */
    public static final int f14867l = 5;
    public static final String l0 = "key_audio_report_state";

    /* JADX INFO: renamed from: m */
    public static final int f14868m = 9;
    public static final String m0 = "key_vedio_repot";

    /* JADX INFO: renamed from: n */
    public static String f14869n = "sp_clause_first";
    public static final String n0 = "key_vedio_report_state";
    public static String o = "sp_media_type";
    public static final String o0 = "key_url_repot";
    public static String p = "sp_apk_md5";
    public static final String p0 = "key_social_repot";
    public static String q = "sp_operation_first";
    public static final String q0 = "key_trad_repot";
    public static String r = "sp_install_other";
    public static final String r0 = "key_survey_stepone_report";
    public static String s = "sp_guide_version";
    public static final String s0 = "key_phone_survey";
    public static String t = "sp_protorol_version";
    public static final String t0 = "key_snapcard";
    public static String u = "sp_secret_version";
    public static final String u0 = "key_call_card";
    public static String v = "sp_report_up_id";
    public static final String v0 = "key_social_snap_card";
    public static String w = "sp_eviden_up_id";
    public static final String w0 = "key_trad_snap_card";
    public static final String x = "install_app";
    public static final String x0 = "sp_verified_tag";
    public static final String y = "update_home";
    public static final String y0 = "sp_user_bean";
    public static final String z = "update_home_primiss";
    public static final String z0 = "sp_check_virus_already";

    public static String a(String str, String str2) {
        return b().getString(str, str2);
    }

    private static SharedPreferences b() {
        if (a == null) {
            a = Hicore.getApp().getSharedPreferences(f14859d, 0);
        }
        return a;
    }

    public static boolean a(String str, boolean z2) {
        return b().getBoolean(str, z2);
    }

    public static int a(String str, int i2) {
        return b().getInt(str, i2);
    }

    public static float a(String str, float f2) {
        return b().getFloat(str, f2);
    }

    public static void b(String str, String str2) {
        b().edit().putString(str, str2).apply();
    }

    public static long a(String str, long j2) {
        return b().getLong(str, j2);
    }

    public static String b(String str) {
        return b().getString(str, "");
    }

    public static <T> void a(T t2, String str) {
        SharedPreferences.Editor editorEdit = b().edit();
        com.google.gson.e eVar = new com.google.gson.e();
        if (t2 == null) {
            editorEdit.putString(str, "");
        } else {
            editorEdit.putString(str, eVar.a(t2));
        }
        editorEdit.commit();
    }

    public static void b(String str, boolean z2) {
        b().edit().putBoolean(str, z2).apply();
    }

    public static void b(String str, int i2) {
        b().edit().putInt(str, i2).apply();
    }

    public static void b(String str, float f2) {
        b().edit().putFloat(str, f2).apply();
    }

    public static void b(String str, long j2) {
        b().edit().putLong(str, j2).apply();
    }

    public static void b(List<String> list, String str) {
        SharedPreferences.Editor editorEdit = b().edit();
        editorEdit.putString(str, new com.google.gson.e().a(list));
        editorEdit.commit();
    }

    public static <T> T a(String str, Class<T> cls) {
        com.google.gson.e eVar = new com.google.gson.e();
        String string = b().getString(str, "");
        try {
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return (T) eVar.a((com.google.gson.k) new com.google.gson.o().a(string).getAsJsonObject(), (Class) cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> List<T> b(String str, Class<T> cls) {
        com.google.gson.e eVar = new com.google.gson.e();
        String string = b().getString(str, null);
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(string)) {
                Iterator<com.google.gson.k> it = new com.google.gson.o().a(string).getAsJsonArray().iterator();
                while (it.hasNext()) {
                    arrayList.add(eVar.a(it.next(), (Class) cls));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static <T> void a(List<T> list, String str) {
        SharedPreferences.Editor editorEdit = b().edit();
        com.google.gson.e eVar = new com.google.gson.e();
        if (list == null) {
            editorEdit.putString(str, "");
        } else {
            editorEdit.putString(str, eVar.a(list));
        }
        editorEdit.commit();
    }

    public static void a(List<Drawable> list) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(j1.b(), "img.bat")));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static List<Drawable> a() {
        ArrayList arrayList = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(j1.b(), "img.bat")));
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

    public static void a(String str, LinkedHashMap<String, String> linkedHashMap) {
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
        b().edit().putString(str, jSONArray.toString()).apply();
    }

    public static LinkedHashMap<String, String> a(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        String string = b().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return linkedHashMap;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                JSONArray jSONArrayNames = jSONObject.names();
                if (jSONArrayNames != null) {
                    for (int i3 = 0; i3 < jSONArrayNames.length(); i3++) {
                        String string2 = jSONArrayNames.getString(i3);
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
