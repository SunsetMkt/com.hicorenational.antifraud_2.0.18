package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Misc.java */
/* renamed from: com.umeng.analytics.pro.ap */
/* loaded from: classes2.dex */
public class C3332ap {
    /* renamed from: a */
    public static void m10858a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static String m10854a(Context context, String str, String str2) {
        return context == null ? str2 : UMEnvelopeBuild.imprintProperty(context, str, str2);
    }

    /* renamed from: a */
    public static void m10857a(Context context, String str) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("processEvent", Context.class, String.class)) == null) {
                return;
            }
            declaredMethod.invoke(cls, context, str);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static Map<String, String> m10855a() {
        HashMap hashMap = new HashMap();
        hashMap.put(C3351bh.f11632bd, C3470a.f12591e);
        if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
            hashMap.put(C3351bh.f11633be, UMUtils.VALUE_ANALYTICS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
            hashMap.put(C3351bh.f11634bf, UMUtils.VALUE_GAME_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
            hashMap.put(C3351bh.f11635bg, UMUtils.VALUE_PUSH_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
            hashMap.put(C3351bh.f11636bh, UMUtils.VALUE_SHARE_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
            hashMap.put(C3351bh.f11637bi, UMUtils.VALUE_APM_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
            hashMap.put(C3351bh.f11638bj, UMUtils.VALUE_VERIFY_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
            hashMap.put(C3351bh.f11639bk, UMUtils.VALUE_SMS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
            hashMap.put(C3351bh.f11640bl, UMUtils.VALUE_REC_VERSION_NAME);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
            hashMap.put(C3351bh.f11641bm, UMUtils.VALUE_VISUAL_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
            hashMap.put(C3351bh.f11642bn, UMUtils.VALUE_ASMS_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
            hashMap.put(C3351bh.f11643bo, UMUtils.VALUE_LINK_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
            hashMap.put(C3351bh.f11644bp, UMUtils.VALUE_ABTEST_VERSION);
        }
        if (!TextUtils.isEmpty(UMUtils.VALUE_ANTI_VERSION)) {
            hashMap.put(C3351bh.f11645bq, UMUtils.VALUE_ANTI_VERSION);
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, String> m10856a(JSONObject jSONObject) {
        String str;
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String valueOf = String.valueOf(keys.next());
                if (!TextUtils.isEmpty(valueOf) && (str = (String) jSONObject.get(valueOf)) != null) {
                    hashMap.put(valueOf, str);
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }
}
