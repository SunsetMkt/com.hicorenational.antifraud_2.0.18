package org.android.agoo.control;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class e implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f12880b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ AgooFactory f12881c;

    e(AgooFactory agooFactory, String str, String str2) {
        this.f12881c = agooFactory;
        this.a = str;
        this.f12880b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12881c.updateMsgStatus(this.a, this.f12880b);
    }
}
