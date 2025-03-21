package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

/* compiled from: ResourceLoader.java */
/* renamed from: com.huawei.hms.push.s */
/* loaded from: classes.dex */
public class C2499s {
    /* renamed from: a */
    public static int m7635a(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    HMSLog.m7717i("ResourceLoader", "Error-resourceType=" + str + "--resourceName=" + str2 + "--resourceId =" + identifier);
                }
            }
            return identifier;
        } catch (ClassNotFoundException e2) {
            HMSLog.m7716e("ResourceLoader", "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e2);
            return 0;
        } catch (IllegalAccessException e3) {
            HMSLog.m7716e("ResourceLoader", "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e3);
            return 0;
        } catch (NoSuchFieldException e4) {
            HMSLog.m7716e("ResourceLoader", "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e4);
            return 0;
        } catch (NumberFormatException e5) {
            HMSLog.m7716e("ResourceLoader", "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e5);
            return 0;
        } catch (IllegalArgumentException e6) {
            HMSLog.m7716e("ResourceLoader", "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e6);
            return 0;
        }
    }

    /* renamed from: a */
    public static int m7634a(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(str);
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m7718w("ResourceLoader", "load meta data resource failed.");
            return 0;
        }
    }
}
