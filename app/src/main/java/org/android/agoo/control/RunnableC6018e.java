package org.android.agoo.control;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.e */
/* loaded from: classes2.dex */
class RunnableC6018e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f21491a;

    /* renamed from: b */
    final /* synthetic */ String f21492b;

    /* renamed from: c */
    final /* synthetic */ AgooFactory f21493c;

    RunnableC6018e(AgooFactory agooFactory, String str, String str2) {
        this.f21493c = agooFactory;
        this.f21491a = str;
        this.f21492b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21493c.updateMsgStatus(this.f21491a, this.f21492b);
    }
}
