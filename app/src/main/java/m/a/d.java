package m.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import c.b.c.n;
import java.io.IOException;

/* compiled from: CameraManager.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: m, reason: collision with root package name */
    private static final String f17266m = "d";
    private static final int n = 240;
    private static final int o = 240;
    private static final int p = 1200;
    private static final int q = 675;

    /* renamed from: a, reason: collision with root package name */
    private final Context f17267a;

    /* renamed from: b, reason: collision with root package name */
    private final b f17268b;

    /* renamed from: c, reason: collision with root package name */
    private Camera f17269c;

    /* renamed from: d, reason: collision with root package name */
    private a f17270d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f17271e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f17272f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f17273g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f17274h;

    /* renamed from: i, reason: collision with root package name */
    private int f17275i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f17276j;

    /* renamed from: k, reason: collision with root package name */
    private int f17277k;

    /* renamed from: l, reason: collision with root package name */
    private final f f17278l;

    public d(Context context) {
        this.f17267a = context;
        this.f17268b = new b(context);
        this.f17278l = new f(this.f17268b);
    }

    public synchronized void a(SurfaceHolder surfaceHolder) throws IOException {
        Camera camera = this.f17269c;
        if (camera == null) {
            camera = this.f17275i >= 0 ? e.a(this.f17275i) : e.a();
            if (camera == null) {
                throw new IOException();
            }
            this.f17269c = camera;
        }
        camera.setPreviewDisplay(surfaceHolder);
        if (!this.f17273g) {
            this.f17273g = true;
            this.f17268b.a(camera);
            if (this.f17276j > 0 && this.f17277k > 0) {
                a(this.f17276j, this.f17277k);
                this.f17276j = 0;
                this.f17277k = 0;
            }
        }
        Camera.Parameters parameters = camera.getParameters();
        String flatten = parameters == null ? null : parameters.flatten();
        try {
            this.f17268b.a(camera, false);
        } catch (RuntimeException unused) {
            String str = "Resetting to saved camera params: " + flatten;
            if (flatten != null) {
                Camera.Parameters parameters2 = camera.getParameters();
                parameters2.unflatten(flatten);
                try {
                    camera.setParameters(parameters2);
                    this.f17268b.a(camera, true);
                } catch (RuntimeException unused2) {
                }
            }
        }
    }

    public synchronized Rect b() {
        if (this.f17271e == null) {
            if (this.f17269c == null) {
                return null;
            }
            Point b2 = this.f17268b.b();
            if (b2 == null) {
                return null;
            }
            int a2 = (a(b2.x, 240, p) * 4) / 5;
            int a3 = (a(b2.y, 240, q) * 4) / 5;
            int i2 = (b2.x - a2) / 2;
            int i3 = (b2.y - a3) / 2;
            this.f17271e = new Rect(i2, i3, a2 + i2, a3 + i3);
            String str = "Calculated framing rect: " + this.f17271e;
        }
        return this.f17271e;
    }

    public synchronized Rect c() {
        if (this.f17272f == null) {
            Rect b2 = b();
            if (b2 == null) {
                return null;
            }
            Rect rect = new Rect(b2);
            Point a2 = this.f17268b.a();
            Point b3 = this.f17268b.b();
            if (a2 != null && b3 != null) {
                rect.left = (rect.left * a2.y) / b3.x;
                rect.right = (rect.right * a2.y) / b3.x;
                rect.top = (rect.top * a2.x) / b3.y;
                rect.bottom = (rect.bottom * a2.x) / b3.y;
                this.f17272f = rect;
            }
            return null;
        }
        return this.f17272f;
    }

    public synchronized boolean d() {
        return this.f17269c != null;
    }

    public synchronized void e() {
        Camera camera = this.f17269c;
        if (camera != null && !this.f17274h) {
            camera.startPreview();
            this.f17274h = true;
            this.f17270d = new a(this.f17267a, this.f17269c);
        }
    }

    public synchronized void f() {
        if (this.f17270d != null) {
            this.f17270d.b();
            this.f17270d = null;
        }
        if (this.f17269c != null && this.f17274h) {
            this.f17269c.stopPreview();
            this.f17278l.a(null, 0);
            this.f17274h = false;
        }
    }

    public synchronized void a() {
        if (this.f17269c != null) {
            this.f17269c.setPreviewCallback(null);
            this.f17269c.stopPreview();
            this.f17269c.release();
            this.f17269c = null;
            this.f17271e = null;
            this.f17272f = null;
        }
    }

    public synchronized void a(Handler handler, int i2) {
        Camera camera = this.f17269c;
        if (camera != null && this.f17274h) {
            this.f17278l.a(handler, i2);
            camera.setOneShotPreviewCallback(this.f17278l);
        }
    }

    private static int a(int i2, int i3, int i4) {
        int i5 = (i2 * 5) / 8;
        return i5 < i3 ? i3 : i5 > i4 ? i4 : i5;
    }

    public synchronized void a(int i2) {
        this.f17275i = i2;
    }

    public synchronized void a(int i2, int i3) {
        if (this.f17273g) {
            Point b2 = this.f17268b.b();
            if (i2 > b2.x) {
                i2 = b2.x;
            }
            if (i3 > b2.y) {
                i3 = b2.y;
            }
            int i4 = (b2.x - i2) / 2;
            int i5 = (b2.y - i3) / 2;
            this.f17271e = new Rect(i4, i5, i2 + i4, i3 + i5);
            String str = "Calculated manual framing rect: " + this.f17271e;
            this.f17272f = null;
        } else {
            this.f17276j = i2;
            this.f17277k = i3;
        }
    }

    public n a(byte[] bArr, int i2, int i3) {
        Rect c2 = c();
        if (c2 == null) {
            return null;
        }
        return new n(bArr, i2, i3, c2.left, c2.top, c2.width(), c2.height(), false);
    }
}
