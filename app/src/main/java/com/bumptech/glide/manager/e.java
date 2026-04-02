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
import com.bumptech.glide.manager.c;

/* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
/* JADX INFO: loaded from: classes.dex */
final class e implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f3321f = "ConnectivityMonitor";
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c.a f3322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f3323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f3325e = new a();

    /* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f3323c;
            eVar.f3323c = eVar.a(context);
            if (z != e.this.f3323c) {
                if (Log.isLoggable(e.f3321f, 3)) {
                    String str = "connectivity changed, isConnected: " + e.this.f3323c;
                }
                e eVar2 = e.this;
                eVar2.f3322b.a(eVar2.f3323c);
            }
        }
    }

    e(@NonNull Context context, @NonNull c.a aVar) {
        this.a = context.getApplicationContext();
        this.f3322b = aVar;
    }

    private void a() {
        if (this.f3324d) {
            return;
        }
        this.f3323c = a(this.a);
        try {
            this.a.registerReceiver(this.f3325e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f3324d = true;
        } catch (SecurityException unused) {
            Log.isLoggable(f3321f, 5);
        }
    }

    private void b() {
        if (this.f3324d) {
            this.a.unregisterReceiver(this.f3325e);
            this.f3324d = false;
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
        b();
    }

    @SuppressLint({"MissingPermission"})
    boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.bumptech.glide.util.j.a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable(f3321f, 5);
            return true;
        }
    }
}
