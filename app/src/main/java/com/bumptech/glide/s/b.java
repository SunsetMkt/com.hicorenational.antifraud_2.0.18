package com.bumptech.glide.s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.g;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: ApplicationVersionSignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String a = "AppVersionSignature";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap<String, g> f3547b = new ConcurrentHashMap();

    private b() {
    }

    @VisibleForTesting
    static void a() {
        f3547b.clear();
    }

    @NonNull
    public static g b(@NonNull Context context) {
        String packageName = context.getPackageName();
        g gVar = f3547b.get(packageName);
        if (gVar != null) {
            return gVar;
        }
        g gVarC = c(context);
        g gVarPutIfAbsent = f3547b.putIfAbsent(packageName, gVarC);
        return gVarPutIfAbsent == null ? gVarC : gVarPutIfAbsent;
    }

    @NonNull
    private static g c(@NonNull Context context) {
        return new e(a(a(context)));
    }

    @NonNull
    private static String a(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @Nullable
    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            String str = "Cannot resolve info for" + context.getPackageName();
            return null;
        }
    }
}
