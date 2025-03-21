package p381m.p382a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

/* compiled from: PreviewCallback.java */
/* renamed from: m.a.f */
/* loaded from: classes2.dex */
final class C5931f implements Camera.PreviewCallback {

    /* renamed from: d */
    private static final String f21405d = C5931f.class.getSimpleName();

    /* renamed from: a */
    private final C5927b f21406a;

    /* renamed from: b */
    private Handler f21407b;

    /* renamed from: c */
    private int f21408c;

    C5931f(C5927b c5927b) {
        this.f21406a = c5927b;
    }

    /* renamed from: a */
    void m24911a(Handler handler, int i2) {
        this.f21407b = handler;
        this.f21408c = i2;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point m24877a = this.f21406a.m24877a();
        Handler handler = this.f21407b;
        if (m24877a == null || handler == null) {
            return;
        }
        handler.obtainMessage(this.f21408c, m24877a.x, m24877a.y, bArr).sendToTarget();
        this.f21407b = null;
    }
}
