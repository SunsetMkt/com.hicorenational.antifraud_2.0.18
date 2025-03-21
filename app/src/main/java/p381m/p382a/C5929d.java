package p381m.p382a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;
import p031c.p035b.p043c.C1103n;

/* compiled from: CameraManager.java */
/* renamed from: m.a.d */
/* loaded from: classes2.dex */
public final class C5929d {

    /* renamed from: m */
    private static final String f21387m = "d";

    /* renamed from: n */
    private static final int f21388n = 240;

    /* renamed from: o */
    private static final int f21389o = 240;

    /* renamed from: p */
    private static final int f21390p = 1200;

    /* renamed from: q */
    private static final int f21391q = 675;

    /* renamed from: a */
    private final Context f21392a;

    /* renamed from: b */
    private final C5927b f21393b;

    /* renamed from: c */
    private Camera f21394c;

    /* renamed from: d */
    private C5926a f21395d;

    /* renamed from: e */
    private Rect f21396e;

    /* renamed from: f */
    private Rect f21397f;

    /* renamed from: g */
    private boolean f21398g;

    /* renamed from: h */
    private boolean f21399h;

    /* renamed from: i */
    private int f21400i = -1;

    /* renamed from: j */
    private int f21401j;

    /* renamed from: k */
    private int f21402k;

    /* renamed from: l */
    private final C5931f f21403l;

    public C5929d(Context context) {
        this.f21392a = context;
        this.f21393b = new C5927b(context);
        this.f21403l = new C5931f(this.f21393b);
    }

    /* renamed from: a */
    public synchronized void m24903a(SurfaceHolder surfaceHolder) throws IOException {
        Camera camera = this.f21394c;
        if (camera == null) {
            camera = this.f21400i >= 0 ? C5930e.m24910a(this.f21400i) : C5930e.m24909a();
            if (camera == null) {
                throw new IOException();
            }
            this.f21394c = camera;
        }
        camera.setPreviewDisplay(surfaceHolder);
        if (!this.f21398g) {
            this.f21398g = true;
            this.f21393b.m24878a(camera);
            if (this.f21401j > 0 && this.f21402k > 0) {
                m24901a(this.f21401j, this.f21402k);
                this.f21401j = 0;
                this.f21402k = 0;
            }
        }
        Camera.Parameters parameters = camera.getParameters();
        String flatten = parameters == null ? null : parameters.flatten();
        try {
            this.f21393b.m24880a(camera, false);
        } catch (RuntimeException unused) {
            String str = "Resetting to saved camera params: " + flatten;
            if (flatten != null) {
                Camera.Parameters parameters2 = camera.getParameters();
                parameters2.unflatten(flatten);
                try {
                    camera.setParameters(parameters2);
                    this.f21393b.m24880a(camera, true);
                } catch (RuntimeException unused2) {
                }
            }
        }
    }

    /* renamed from: b */
    public synchronized Rect m24904b() {
        if (this.f21396e == null) {
            if (this.f21394c == null) {
                return null;
            }
            Point m24881b = this.f21393b.m24881b();
            if (m24881b == null) {
                return null;
            }
            int m24897a = (m24897a(m24881b.x, 240, f21390p) * 4) / 5;
            int m24897a2 = (m24897a(m24881b.y, 240, f21391q) * 4) / 5;
            int i2 = (m24881b.x - m24897a) / 2;
            int i3 = (m24881b.y - m24897a2) / 2;
            this.f21396e = new Rect(i2, i3, m24897a + i2, m24897a2 + i3);
            String str = "Calculated framing rect: " + this.f21396e;
        }
        return this.f21396e;
    }

    /* renamed from: c */
    public synchronized Rect m24905c() {
        if (this.f21397f == null) {
            Rect m24904b = m24904b();
            if (m24904b == null) {
                return null;
            }
            Rect rect = new Rect(m24904b);
            Point m24877a = this.f21393b.m24877a();
            Point m24881b = this.f21393b.m24881b();
            if (m24877a != null && m24881b != null) {
                rect.left = (rect.left * m24877a.y) / m24881b.x;
                rect.right = (rect.right * m24877a.y) / m24881b.x;
                rect.top = (rect.top * m24877a.x) / m24881b.y;
                rect.bottom = (rect.bottom * m24877a.x) / m24881b.y;
                this.f21397f = rect;
            }
            return null;
        }
        return this.f21397f;
    }

    /* renamed from: d */
    public synchronized boolean m24906d() {
        return this.f21394c != null;
    }

    /* renamed from: e */
    public synchronized void m24907e() {
        Camera camera = this.f21394c;
        if (camera != null && !this.f21399h) {
            camera.startPreview();
            this.f21399h = true;
            this.f21395d = new C5926a(this.f21392a, this.f21394c);
        }
    }

    /* renamed from: f */
    public synchronized void m24908f() {
        if (this.f21395d != null) {
            this.f21395d.m24876b();
            this.f21395d = null;
        }
        if (this.f21394c != null && this.f21399h) {
            this.f21394c.stopPreview();
            this.f21403l.m24911a(null, 0);
            this.f21399h = false;
        }
    }

    /* renamed from: a */
    public synchronized void m24899a() {
        if (this.f21394c != null) {
            this.f21394c.setPreviewCallback(null);
            this.f21394c.stopPreview();
            this.f21394c.release();
            this.f21394c = null;
            this.f21396e = null;
            this.f21397f = null;
        }
    }

    /* renamed from: a */
    public synchronized void m24902a(Handler handler, int i2) {
        Camera camera = this.f21394c;
        if (camera != null && this.f21399h) {
            this.f21403l.m24911a(handler, i2);
            camera.setOneShotPreviewCallback(this.f21403l);
        }
    }

    /* renamed from: a */
    private static int m24897a(int i2, int i3, int i4) {
        int i5 = (i2 * 5) / 8;
        return i5 < i3 ? i3 : i5 > i4 ? i4 : i5;
    }

    /* renamed from: a */
    public synchronized void m24900a(int i2) {
        this.f21400i = i2;
    }

    /* renamed from: a */
    public synchronized void m24901a(int i2, int i3) {
        if (this.f21398g) {
            Point m24881b = this.f21393b.m24881b();
            if (i2 > m24881b.x) {
                i2 = m24881b.x;
            }
            if (i3 > m24881b.y) {
                i3 = m24881b.y;
            }
            int i4 = (m24881b.x - i2) / 2;
            int i5 = (m24881b.y - i3) / 2;
            this.f21396e = new Rect(i4, i5, i2 + i4, i3 + i5);
            String str = "Calculated manual framing rect: " + this.f21396e;
            this.f21397f = null;
        } else {
            this.f21401j = i2;
            this.f21402k = i3;
        }
    }

    /* renamed from: a */
    public C1103n m24898a(byte[] bArr, int i2, int i3) {
        Rect m24905c = m24905c();
        if (m24905c == null) {
            return null;
        }
        return new C1103n(bArr, i2, i3, m24905c.left, m24905c.top, m24905c.width(), m24905c.height(), false);
    }
}
