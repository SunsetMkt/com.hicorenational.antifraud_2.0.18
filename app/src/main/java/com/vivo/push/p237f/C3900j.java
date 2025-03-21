package com.vivo.push.p237f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.p232b.C3838j;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C4010u;
import java.util.List;

/* compiled from: OnChangePushStatusReceiveTask.java */
/* renamed from: com.vivo.push.f.j */
/* loaded from: classes2.dex */
final class C3900j extends AbstractRunnableC3971s {
    C3900j(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    /* renamed from: a */
    public static boolean m12970a(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            C4010u.m13292a("OnChangePushStatusTask", "enableService error: can not find push service.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 1) {
            C4010u.m13309d("OnChangePushStatusTask", "push service has enabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
        C4010u.m13309d("OnChangePushStatusTask", "enableService push service.");
        return true;
    }

    /* renamed from: b */
    public static boolean m12971b(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            C4010u.m13292a("OnChangePushStatusTask", "disableService error: can not find push service.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 2) {
            C4010u.m13309d("OnChangePushStatusTask", "push service has disabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
        C4010u.m13309d("OnChangePushStatusTask", "disableService push service.");
        return true;
    }

    /* renamed from: c */
    private static List<ResolveInfo> m12972c(Context context) {
        List<ResolveInfo> list;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            return list;
        }
        Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        try {
            return context.getPackageManager().queryBroadcastReceivers(intent2, 576);
        } catch (Exception unused2) {
            return list;
        }
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        if (this.f14186a.getPackageName().equals(C3984aa.m13180a(this.f14186a))) {
            return;
        }
        C3838j c3838j = (C3838j) abstractC4016v;
        int m12848d = c3838j.m12848d();
        int m12849e = c3838j.m12849e();
        C4010u.m13309d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + m12848d + " ; receiverStatus is " + m12849e);
        if (m12848d == 2) {
            m12971b(this.f14186a);
        } else if (m12848d == 1) {
            m12970a(this.f14186a);
        } else if (m12848d == 0) {
            Context context = this.f14186a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 0) {
                    packageManager.setComponentEnabledSetting(componentName, 0, 1);
                    C4010u.m13309d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    C4010u.m13309d("OnChangePushStatusTask", "push service has defaulted");
                }
            } else {
                C4010u.m13292a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            }
        }
        if (m12849e == 2) {
            Context context2 = this.f14186a;
            List<ResolveInfo> m12972c = m12972c(context2);
            if (m12972c != null && m12972c.size() > 0) {
                String str = m12972c.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    C4010u.m13309d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager2 = context2.getPackageManager();
                ComponentName componentName2 = new ComponentName(context2, str);
                if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                    packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                    C4010u.m13309d("OnChangePushStatusTask", "push service disableReceiver ");
                    return;
                } else {
                    C4010u.m13309d("OnChangePushStatusTask", "push service has disableReceiver ");
                    return;
                }
            }
            C4010u.m13292a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            return;
        }
        if (m12849e == 1) {
            Context context3 = this.f14186a;
            List<ResolveInfo> m12972c2 = m12972c(context3);
            if (m12972c2 != null && m12972c2.size() > 0) {
                String str2 = m12972c2.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str2)) {
                    C4010u.m13309d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager3 = context3.getPackageManager();
                ComponentName componentName3 = new ComponentName(context3, str2);
                if (packageManager3.getComponentEnabledSetting(componentName3) != 1) {
                    packageManager3.setComponentEnabledSetting(componentName3, 1, 1);
                    C4010u.m13309d("OnChangePushStatusTask", "push service enableReceiver ");
                    return;
                } else {
                    C4010u.m13309d("OnChangePushStatusTask", "push service has enableReceiver ");
                    return;
                }
            }
            C4010u.m13292a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
            return;
        }
        if (m12849e == 0) {
            Context context4 = this.f14186a;
            List<ResolveInfo> m12972c3 = m12972c(context4);
            if (m12972c3 != null && m12972c3.size() > 0) {
                String str3 = m12972c3.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    C4010u.m13309d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager4 = context4.getPackageManager();
                ComponentName componentName4 = new ComponentName(context4, str3);
                if (packageManager4.getComponentEnabledSetting(componentName4) != 0) {
                    packageManager4.setComponentEnabledSetting(componentName4, 0, 1);
                    C4010u.m13309d("OnChangePushStatusTask", "push service defaultReceiver ");
                    return;
                } else {
                    C4010u.m13309d("OnChangePushStatusTask", "push service has defaulted");
                    return;
                }
            }
            C4010u.m13292a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
        }
    }
}
