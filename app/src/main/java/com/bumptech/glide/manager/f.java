package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.c;

/* JADX INFO: compiled from: DefaultConnectivityMonitorFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {
    private static final String a = "ConnectivityMonitor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3326b = "android.permission.ACCESS_NETWORK_STATE";

    @Override // com.bumptech.glide.manager.d
    @NonNull
    public c a(@NonNull Context context, @NonNull c.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, f3326b) == 0;
        Log.isLoggable(a, 3);
        return z ? new e(context, aVar) : new j();
    }
}
