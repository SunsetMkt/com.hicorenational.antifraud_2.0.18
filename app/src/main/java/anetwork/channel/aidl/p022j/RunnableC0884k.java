package anetwork.channel.aidl.p022j;

import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.k */
/* loaded from: classes.dex */
final class RunnableC0884k implements Runnable {
    RunnableC0884k() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C0882i.f1316c) {
            C0882i.f1316c = false;
            ALog.m715e("anet.RemoteGetter", "binding service timeout. reset status!", null, new Object[0]);
        }
    }
}
