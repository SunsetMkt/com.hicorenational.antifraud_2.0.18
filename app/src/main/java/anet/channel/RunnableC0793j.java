package anet.channel;

import anet.channel.p018b.C0748a;
import p000a.p001a.p002j.C0010b;

/* compiled from: Taobao */
/* renamed from: anet.channel.j */
/* loaded from: classes.dex */
final class RunnableC0793j implements Runnable {
    RunnableC0793j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C0748a c0748a = new C0748a();
            c0748a.m445a();
            C0010b.m59a(c0748a, new C0794k(this), 1);
        } catch (Exception unused) {
        }
    }
}
