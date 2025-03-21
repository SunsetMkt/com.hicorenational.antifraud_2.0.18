package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.InterfaceC1789c;

/* compiled from: DefaultConnectivityMonitorFactory.java */
/* renamed from: com.bumptech.glide.manager.f */
/* loaded from: classes.dex */
public class C1792f implements InterfaceC1790d {

    /* renamed from: a */
    private static final String f5080a = "ConnectivityMonitor";

    /* renamed from: b */
    private static final String f5081b = "android.permission.ACCESS_NETWORK_STATE";

    @Override // com.bumptech.glide.manager.InterfaceC1790d
    @NonNull
    /* renamed from: a */
    public InterfaceC1789c mo4528a(@NonNull Context context, @NonNull InterfaceC1789c.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, f5081b) == 0;
        Log.isLoggable(f5080a, 3);
        return z ? new C1791e(context, aVar) : new C1796j();
    }
}
