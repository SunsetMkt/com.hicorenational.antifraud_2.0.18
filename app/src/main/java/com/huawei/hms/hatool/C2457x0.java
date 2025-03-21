package com.huawei.hms.hatool;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import java.lang.reflect.InvocationTargetException;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import util.permissionutil.C7308a;

/* renamed from: com.huawei.hms.hatool.x0 */
/* loaded from: classes.dex */
public class C2457x0 extends AbstractC2436o {
    /* renamed from: c */
    public static String m7412c() {
        String str;
        String str2;
        try {
            str = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
        } catch (AndroidRuntimeException unused) {
            str = "";
        } catch (ClassNotFoundException unused2) {
            str = "";
        } catch (IllegalAccessException unused3) {
            str = "";
        } catch (IllegalArgumentException unused4) {
            str = "";
        } catch (NoSuchMethodException unused5) {
            str = "";
        } catch (InvocationTargetException unused6) {
            str = "";
        }
        try {
            C2452v.m7385c("hmsSdk", "getUDID success");
        } catch (AndroidRuntimeException unused7) {
            str2 = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
            C2452v.m7390f("hmsSdk", str2);
            return str;
        } catch (ClassNotFoundException unused8) {
            str2 = "getUDID method invoke failed";
            C2452v.m7390f("hmsSdk", str2);
            return str;
        } catch (IllegalAccessException unused9) {
            str2 = "getUDID method invoke failed : Illegal AccessException";
            C2452v.m7390f("hmsSdk", str2);
            return str;
        } catch (IllegalArgumentException unused10) {
            str2 = "getUDID method invoke failed : Illegal ArgumentException";
            C2452v.m7390f("hmsSdk", str2);
            return str;
        } catch (NoSuchMethodException unused11) {
            str2 = "getUDID method invoke failed : NoSuchMethodException";
            C2452v.m7390f("hmsSdk", str2);
            return str;
        } catch (InvocationTargetException unused12) {
            str2 = "getUDID method invoke failed : InvocationTargetException";
            C2452v.m7390f("hmsSdk", str2);
            return str;
        }
        return str;
    }

    /* renamed from: e */
    public static Pair<String, String> m7413e(Context context) {
        if (C2401c0.m7058a(context, C7308a.f25531j)) {
            C2452v.m7390f("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
            String networkOperator = telephonyManager.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, AbstractC1191a.f2571h)) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
        }
        return new Pair<>("", "");
    }
}
