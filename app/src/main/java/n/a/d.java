package n.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import d.b.c.n;
import java.io.IOException;

/* JADX INFO: compiled from: CameraManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: m */
    private static final String f12829m = "d";

    /* JADX INFO: renamed from: n */
    private static final int f12830n = 240;
    private static final int o = 240;
    private static final int p = 1200;
    private static final int q = 675;
    private final Context a;

    /* JADX INFO: renamed from: b */
    private final b f12831b;

    /* JADX INFO: renamed from: c */
    private Camera f12832c;

    /* JADX INFO: renamed from: d */
    private a f12833d;

    /* JADX INFO: renamed from: e */
    private Rect f12834e;

    /* JADX INFO: renamed from: f */
    private Rect f12835f;

    /* JADX INFO: renamed from: g */
    private boolean f12836g;

    /* JADX INFO: renamed from: h */
    private boolean f12837h;

    /* JADX INFO: renamed from: i */
    private int f12838i = -1;

    /* JADX INFO: renamed from: j */
    private int f12839j;

    /* JADX INFO: renamed from: k */
    private int f12840k;

    /* JADX INFO: renamed from: l */
    private final f f12841l;

    public d(Context context) {
        this.a = context;
        this.f12831b = new b(context);
        this.f12841l = new f(this.f12831b);
    }

    public synchronized void a(SurfaceHolder surfaceHolder) throws IOException {
        Camera cameraA = this.f12832c;
        if (cameraA == null) {
            cameraA = this.f12838i >= 0 ? e.a(this.f12838i) : e.a();
            if (cameraA == null) {
                throw new IOException();
            }
            this.f12832c = cameraA;
        }
        cameraA.setPreviewDisplay(surfaceHolder);
        if (!this.f12836g) {
            this.f12836g = true;
            this.f12831b.a(cameraA);
            if (this.f12839j > 0 && this.f12840k > 0) {
                a(this.f12839j, this.f12840k);
                this.f12839j = 0;
                this.f12840k = 0;
            }
        }
        Camera.Parameters parameters = cameraA.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.f12831b.a(cameraA, false);
        } catch (RuntimeException unused) {
            String str = "Resetting to saved camera params: " + strFlatten;
            if (strFlatten != null) {
                Camera.Parameters parameters2 = cameraA.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    cameraA.setParameters(parameters2);
                    this.f12831b.a(cameraA, true);
                } catch (RuntimeException unused2) {
                }
            }
        }
    }

    public synchronized Rect b() {
        if (this.f12834e == null) {
            if (this.f12832c == null) {
                return null;
            }
            Point pointB = this.f12831b.b();
            if (pointB == null) {
                return null;
            }
            int iA = (a(pointB.x, 240, p) * 4) / 5;
            int iA2 = (a(pointB.y, 240, q) * 4) / 5;
            int i2 = (pointB.x - iA) / 2;
            int i3 = (pointB.y - iA2) / 2;
            this.f12834e = new Rect(i2, i3, iA + i2, iA2 + i3);
            String str = "Calculated framing rect: " + this.f12834e;
        }
        return this.f12834e;
    }

    public synchronized Rect c() {
        if (this.f12835f == null) {
            Rect rectB = b();
            if (rectB == null) {
                return null;
            }
            Rect rect = new Rect(rectB);
            Point pointA = this.f12831b.a();
            Point pointB = this.f12831b.b();
            if (pointA != null && pointB != null) {
                rect.left = (rect.left * pointA.y) / pointB.x;
                rect.right = (rect.right * pointA.y) / pointB.x;
                rect.top = (rect.top * pointA.x) / pointB.y;
                rect.bottom = (rect.bottom * pointA.x) / pointB.y;
                this.f12835f = rect;
            }
            return null;
        }
        return this.f12835f;
    }

    public synchronized boolean d() {
        return this.f12832c != null;
    }

    public synchronized void e() {
        Camera camera = this.f12832c;
        if (camera != null && !this.f12837h) {
            camera.startPreview();
            this.f12837h = true;
            this.f12833d = new a(this.a, this.f12832c);
        }
    }

    public synchronized void f() {
        if (this.f12833d != null) {
            this.f12833d.b();
            this.f12833d = null;
        }
        if (this.f12832c != null && this.f12837h) {
            this.f12832c.stopPreview();
            this.f12841l.a(null, 0);
            this.f12837h = false;
        }
    }

    public synchronized void a() {
        if (this.f12832c != null) {
            this.f12832c.setPreviewCallback(null);
            this.f12832c.stopPreview();
            this.f12832c.release();
            this.f12832c = null;
            this.f12834e = null;
            this.f12835f = null;
        }
    }

    public synchronized void a(Handler handler, int i2) {
        Camera camera = this.f12832c;
        if (camera != null && this.f12837h) {
            this.f12841l.a(handler, i2);
            camera.setOneShotPreviewCallback(this.f12841l);
        }
    }

    private static int a(int i2, int i3, int i4) {
        int i5 = (i2 * 5) / 8;
        return i5 < i3 ? i3 : i5 > i4 ? i4 : i5;
    }

    public synchronized void a(int i2) {
        this.f12838i = i2;
    }

    public synchronized void a(int i2, int i3) {
        if (this.f12836g) {
            Point pointB = this.f12831b.b();
            if (i2 > pointB.x) {
                i2 = pointB.x;
            }
            if (i3 > pointB.y) {
                i3 = pointB.y;
            }
            int i4 = (pointB.x - i2) / 2;
            int i5 = (pointB.y - i3) / 2;
            this.f12834e = new Rect(i4, i5, i2 + i4, i3 + i5);
            String str = "Calculated manual framing rect: " + this.f12834e;
            this.f12835f = null;
        } else {
            this.f12839j = i2;
            this.f12840k = i3;
        }
    }

    public n a(byte[] bArr, int i2, int i3) {
        Rect rectC = c();
        if (rectC == null) {
            return null;
        }
        return new n(bArr, i2, i3, rectC.left, rectC.top, rectC.width(), rectC.height(), false);
    }
}
