package org.android.agoo.control;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.i */
/* loaded from: classes2.dex */
class ServiceConnectionC6022i implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ BaseIntentService f21498a;

    ServiceConnectionC6022i(BaseIntentService baseIntentService) {
        this.f21498a = baseIntentService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
