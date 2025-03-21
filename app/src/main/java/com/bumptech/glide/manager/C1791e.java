package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.InterfaceC1789c;
import com.bumptech.glide.util.C1876j;

/* compiled from: DefaultConnectivityMonitor.java */
/* renamed from: com.bumptech.glide.manager.e */
/* loaded from: classes.dex */
final class C1791e implements InterfaceC1789c {

    /* renamed from: f */
    private static final String f5073f = "ConnectivityMonitor";

    /* renamed from: a */
    private final Context f5074a;

    /* renamed from: b */
    final InterfaceC1789c.a f5075b;

    /* renamed from: c */
    boolean f5076c;

    /* renamed from: d */
    private boolean f5077d;

    /* renamed from: e */
    private final BroadcastReceiver f5078e = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* renamed from: com.bumptech.glide.manager.e$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            C1791e c1791e = C1791e.this;
            boolean z = c1791e.f5076c;
            c1791e.f5076c = c1791e.m4531a(context);
            if (z != C1791e.this.f5076c) {
                if (Log.isLoggable(C1791e.f5073f, 3)) {
                    String str = "connectivity changed, isConnected: " + C1791e.this.f5076c;
                }
                C1791e c1791e2 = C1791e.this;
                c1791e2.f5075b.mo3806a(c1791e2.f5076c);
            }
        }
    }

    C1791e(@NonNull Context context, @NonNull InterfaceC1789c.a aVar) {
        this.f5074a = context.getApplicationContext();
        this.f5075b = aVar;
    }

    /* renamed from: a */
    private void m4529a() {
        if (this.f5077d) {
            return;
        }
        this.f5076c = m4531a(this.f5074a);
        try {
            this.f5074a.registerReceiver(this.f5078e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f5077d = true;
        } catch (SecurityException unused) {
            Log.isLoggable(f5073f, 5);
        }
    }

    /* renamed from: b */
    private void m4530b() {
        if (this.f5077d) {
            this.f5074a.unregisterReceiver(this.f5078e);
            this.f5077d = false;
        }
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStart() {
        m4529a();
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStop() {
        m4530b();
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    boolean m4531a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C1876j.m4985a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable(f5073f, 5);
            return true;
        }
    }
}
