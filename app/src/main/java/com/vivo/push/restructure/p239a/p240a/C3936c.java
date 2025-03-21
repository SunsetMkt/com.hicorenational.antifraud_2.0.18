package com.vivo.push.restructure.p239a.p240a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.p236e.C3878b;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.p239a.InterfaceC3933a;
import com.vivo.push.sdk.C3973a;
import com.vivo.push.util.C3983a;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C3985ab;
import com.vivo.push.util.C3990ag;
import com.vivo.push.util.C4010u;
import java.util.Arrays;
import java.util.List;

/* compiled from: CheckNode.java */
/* renamed from: com.vivo.push.restructure.a.a.c */
/* loaded from: classes2.dex */
final class C3936c extends AbstractC3934a<InterfaceC3933a> {

    /* renamed from: b */
    private static final List<Integer> f14128b = Arrays.asList(3);

    public C3936c(InterfaceC3933a interfaceC3933a, InterfaceC3942i interfaceC3942i) {
        super("CheckNode", interfaceC3933a, interfaceC3942i);
    }

    /* renamed from: b */
    private static boolean m13099b(Intent intent) {
        if (Build.VERSION.SDK_INT < 18) {
            return true;
        }
        try {
            Context m13071b = C3932a.m13069a().m13071b();
            String m13217b = C3990ag.m13217b(m13071b, "com.vivo.pushservice");
            C4010u.m13309d("CheckNode", " 配置的验签参数 = ".concat(String.valueOf(m13217b)));
            if (!TextUtils.equals(m13217b, "1")) {
                return true;
            }
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                if (!TextUtils.equals(stringExtra, "com.vivo.pushservice") && !TextUtils.equals(stringExtra2, "com.vivo.pushservice")) {
                    if (C3878b.m12943a().m12944a(m13071b).mo12942a("com.vivo.pushservice".getBytes("UTF-8"), C3985ab.m13193a(stringExtra2), Base64.decode(stringExtra, 2))) {
                        C4010u.m13309d("CheckNode", " RSA验签通过  ");
                        return true;
                    }
                    C4010u.m13309d("CheckNode", " RSA验签 不通过  ");
                    return false;
                }
                C4010u.m13292a("CheckNode", " 验签参数传入错误 securityContent = " + stringExtra + " publickKey= " + stringExtra2);
                return true;
            }
            C4010u.m13292a("CheckNode", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        } catch (Exception e2) {
            C4010u.m13292a("CheckNode", "checkIntentIsSecurity Exception: " + e2.getMessage());
            return true;
        }
    }

    @Override // com.vivo.push.restructure.p239a.p240a.AbstractC3934a
    /* renamed from: a */
    protected final /* bridge */ /* synthetic */ int mo13092a(InterfaceC3933a interfaceC3933a) {
        return a2(interfaceC3933a);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(InterfaceC3933a interfaceC3933a) {
        try {
        } catch (Exception e2) {
            C4010u.m13294a("CheckNode", e2);
        }
        if (!C3932a.m13069a().m13074e().mo13130l().isAgreePrivacyStatement()) {
            C4010u.m13309d("CheckNode", " checkNeedReportByPrivacyStatement is false  ");
            return 2809;
        }
        Intent mo13079b = interfaceC3933a.mo13079b();
        String m13166b = C3973a.m13163a().m13166b();
        if (!TextUtils.isEmpty(m13166b) && m13166b.contains("CommandService")) {
            if (!(mo13079b != null && m13098a(mo13079b) && m13099b(mo13079b))) {
                C4010u.m13292a("CheckNode", " !checkIntentIsSecurity(intent)");
                return 2801;
            }
        }
        Context m13071b = C3932a.m13069a().m13071b();
        String packageName = m13071b.getPackageName();
        String stringExtra = mo13079b.getStringExtra("command_type");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = mo13079b.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = mo13079b.getIntExtra("method", -1);
            }
            if (f14128b.contains(Integer.valueOf(intExtra)) && C3984aa.m13187c(m13071b, packageName) && !C3984aa.m13185b(m13071b)) {
                C4010u.m13292a("CheckNode", "METHOD_ON_MESSAGE is not support");
                return 2803;
            }
            String action = mo13079b.getAction();
            if (TextUtils.isEmpty(C3932a.m13069a().m13074e().mo13113a(m13071b, action))) {
                C4010u.m13309d("CheckNode", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                mo13079b.setPackage(packageName);
                m13071b.sendBroadcast(mo13079b);
                return 2802;
            }
            return 0;
        }
        C4010u.m13292a("CheckNode", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2801;
    }

    /* renamed from: a */
    private static boolean m13098a(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("security_avoid_pull");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    String m13178b = C3983a.m13174a(C3932a.m13069a().m13071b()).m13178b(stringExtra);
                    if ("com.vivo.pushservice".equals(m13178b)) {
                        return true;
                    }
                    C4010u.m13292a("CheckNode", "!decrypt.equals, so decrypt == ".concat(String.valueOf(m13178b)));
                    return false;
                } catch (Exception e2) {
                    C4010u.m13292a("CheckNode", "checkIntentIsSecurity Exception: " + e2.getMessage());
                    return false;
                }
            }
            C4010u.m13292a("CheckNode", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        } catch (Exception unused) {
            C4010u.m13292a("CheckNode", "getStringExtra error");
            return true;
        }
    }
}
