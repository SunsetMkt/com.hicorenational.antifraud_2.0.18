package com.vivo.push.p231a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;
import com.vivo.push.ServiceConnectionC3920i;
import com.vivo.push.p236e.C3878b;
import com.vivo.push.util.C3983a;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C3985ab;
import com.vivo.push.util.C4010u;
import java.util.List;

/* compiled from: CommandBridge.java */
/* renamed from: com.vivo.push.a.a */
/* loaded from: classes2.dex */
public final class C3825a {
    /* renamed from: a */
    public static void m12828a(Context context, String str, AbstractC4016v abstractC4016v) {
        boolean mo12884c = abstractC4016v.mo12884c();
        ServiceConnectionC3920i m12995a = ServiceConnectionC3920i.m12995a(context, mo12884c ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean m13005a = m12995a.m13005a();
        if (TextUtils.isEmpty(abstractC4016v.m13321a())) {
            abstractC4016v.m13324a(context.getPackageName());
        }
        if (m13005a && !"com.vivo.pushservice".equals(context.getPackageName())) {
            C3862d c3862d = new C3862d(abstractC4016v.m13321a(), str, new Bundle());
            abstractC4016v.m13323a(c3862d);
            if (m12995a.m13006a(c3862d.m12923b())) {
                return;
            }
            C4010u.m13301b("CommandBridge", "send command error by aidl");
            C4010u.m13308c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, mo12884c ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        abstractC4016v.m13322a(intent);
        try {
            m12826a(context, intent);
        } catch (Exception e2) {
            C4010u.m13293a("CommandBridge", "CommandBridge startService exception: ", e2);
        }
    }

    /* renamed from: a */
    public static void m12826a(Context context, Intent intent) throws Exception {
        if (context != null) {
            try {
                context.startService(intent);
                return;
            } catch (Exception e2) {
                C4010u.m13293a("CommandBridge", "start service error", e2);
                intent.setComponent(null);
                context.sendBroadcast(intent);
                return;
            }
        }
        C4010u.m13309d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    }

    /* renamed from: a */
    public static void m12827a(Context context, AbstractC4016v abstractC4016v, String str) {
        try {
            boolean m13188d = C3984aa.m13188d(context, str);
            String str2 = m13188d ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (!TextUtils.isEmpty(str)) {
                if (m13188d || m12829a(context, str2, str)) {
                    if (TextUtils.isEmpty(abstractC4016v.m13321a())) {
                        abstractC4016v.m13324a(context.getPackageName());
                    }
                    Intent intent = new Intent();
                    intent.setFlags(1048576);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setAction(str2);
                    }
                    intent.setPackage(str);
                    intent.setClassName(str, m13188d ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                    intent.putExtra("security_avoid_pull", C3983a.m13174a(context).m13177a("com.vivo.pushservice"));
                    abstractC4016v.m13326b(intent);
                    intent.putExtra("command_type", "reflect_receiver");
                    if (Build.VERSION.SDK_INT >= 18) {
                        intent.putExtra("security_avoid_pull_rsa", C3878b.m12943a().m12944a(context).mo12940a("com.vivo.pushservice"));
                        intent.putExtra("security_avoid_rsa_public_key", C3985ab.m13192a(C3878b.m12943a().m12944a(context).mo12941a()));
                    }
                    m12826a(context, intent);
                    return;
                }
                return;
            }
            C4010u.m13308c(context, "消息接受者包名为空！");
            throw new Exception("消息接受者包名为空！");
        } catch (Exception e2) {
            C4010u.m13293a("CommandBridge", "CommandBridge sendCommandToClient exception", e2);
        }
    }

    /* renamed from: a */
    private static boolean m12829a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return true;
            }
            C4010u.m13301b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            C4010u.m13301b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
