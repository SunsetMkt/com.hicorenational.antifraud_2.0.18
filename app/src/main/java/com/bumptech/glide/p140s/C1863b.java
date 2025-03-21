package com.bumptech.glide.p140s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.InterfaceC1593g;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ApplicationVersionSignature.java */
/* renamed from: com.bumptech.glide.s.b */
/* loaded from: classes.dex */
public final class C1863b {

    /* renamed from: a */
    private static final String f5458a = "AppVersionSignature";

    /* renamed from: b */
    private static final ConcurrentMap<String, InterfaceC1593g> f5459b = new ConcurrentHashMap();

    private C1863b() {
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m4946a() {
        f5459b.clear();
    }

    @NonNull
    /* renamed from: b */
    public static InterfaceC1593g m4947b(@NonNull Context context) {
        String packageName = context.getPackageName();
        InterfaceC1593g interfaceC1593g = f5459b.get(packageName);
        if (interfaceC1593g != null) {
            return interfaceC1593g;
        }
        InterfaceC1593g m4948c = m4948c(context);
        InterfaceC1593g putIfAbsent = f5459b.putIfAbsent(packageName, m4948c);
        return putIfAbsent == null ? m4948c : putIfAbsent;
    }

    @NonNull
    /* renamed from: c */
    private static InterfaceC1593g m4948c(@NonNull Context context) {
        return new C1866e(m4945a(m4944a(context)));
    }

    @NonNull
    /* renamed from: a */
    private static String m4945a(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @Nullable
    /* renamed from: a */
    private static PackageInfo m4944a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            String str = "Cannot resolve info for" + context.getPackageName();
            return null;
        }
    }
}
