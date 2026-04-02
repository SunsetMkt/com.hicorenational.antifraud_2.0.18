package n.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

/* JADX INFO: compiled from: PreviewCallback.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements Camera.PreviewCallback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12842d = f.class.getSimpleName();
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f12843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12844c;

    f(b bVar) {
        this.a = bVar;
    }

    void a(Handler handler, int i2) {
        this.f12843b = handler;
        this.f12844c = i2;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointA = this.a.a();
        Handler handler = this.f12843b;
        if (pointA == null || handler == null) {
            return;
        }
        handler.obtainMessage(this.f12844c, pointA.x, pointA.y, bArr).sendToTarget();
        this.f12843b = null;
    }
}
