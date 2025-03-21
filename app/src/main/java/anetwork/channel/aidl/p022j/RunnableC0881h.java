package anetwork.channel.aidl.p022j;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.h */
/* loaded from: classes.dex */
class RunnableC0881h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ byte f1311a;

    /* renamed from: b */
    final /* synthetic */ Object f1312b;

    /* renamed from: c */
    final /* synthetic */ BinderC0878e f1313c;

    RunnableC0881h(BinderC0878e binderC0878e, byte b2, Object obj) {
        this.f1313c = binderC0878e;
        this.f1311a = b2;
        this.f1312b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1313c.m792b(this.f1311a, this.f1312b);
    }
}
