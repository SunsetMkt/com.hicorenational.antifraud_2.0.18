package com.airbnb.lottie.p100b0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.p102w.C1392a;
import com.airbnb.lottie.p102w.p103b.C1412t;
import com.airbnb.lottie.p102w.p104c.C1416c;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* compiled from: Utils.java */
/* renamed from: com.airbnb.lottie.b0.h */
/* loaded from: classes.dex */
public final class C1358h {

    /* renamed from: a */
    public static final int f3146a = 1000000000;

    /* renamed from: b */
    private static final ThreadLocal<PathMeasure> f3147b = new a();

    /* renamed from: c */
    private static final ThreadLocal<Path> f3148c = new b();

    /* renamed from: d */
    private static final ThreadLocal<Path> f3149d = new c();

    /* renamed from: e */
    private static final ThreadLocal<float[]> f3150e = new d();

    /* renamed from: f */
    private static final float f3151f = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: g */
    private static float f3152g = -1.0f;

    /* compiled from: Utils.java */
    /* renamed from: com.airbnb.lottie.b0.h$a */
    class a extends ThreadLocal<PathMeasure> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.airbnb.lottie.b0.h$b */
    class b extends ThreadLocal<Path> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Path initialValue() {
            return new Path();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.airbnb.lottie.b0.h$c */
    class c extends ThreadLocal<Path> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Path initialValue() {
            return new Path();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: com.airbnb.lottie.b0.h$d */
    class d extends ThreadLocal<float[]> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public float[] initialValue() {
            return new float[4];
        }
    }

    private C1358h() {
    }

    /* renamed from: a */
    public static int m2835a(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (i2 * 31 * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (i2 * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
    }

    /* renamed from: a */
    public static Path m2838a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF3.x + pointF.x;
            float f3 = pointF.y + pointF3.y;
            float f4 = pointF2.x;
            float f5 = f4 + pointF4.x;
            float f6 = pointF2.y;
            path.cubicTo(f2, f3, f5, f6 + pointF4.y, f4, f6);
        }
        return path;
    }

    /* renamed from: a */
    public static boolean m2844a(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 < i6) {
            return false;
        }
        return i3 > i6 || i4 >= i7;
    }

    /* renamed from: b */
    public static boolean m2846b(Matrix matrix) {
        float[] fArr = f3150e.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    /* renamed from: a */
    public static void m2843a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static float m2834a(Matrix matrix) {
        float[] fArr = f3150e.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f3151f;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    /* renamed from: a */
    public static void m2842a(Path path, @Nullable C1412t c1412t) {
        if (c1412t == null || c1412t.m3130f()) {
            return;
        }
        m2841a(path, ((C1416c) c1412t.m3128d()).m3155i() / 100.0f, ((C1416c) c1412t.m3126b()).m3155i() / 100.0f, ((C1416c) c1412t.m3127c()).m3155i() / 360.0f);
    }

    /* renamed from: a */
    public static void m2841a(Path path, float f2, float f3, float f4) {
        C1374e.m2881a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f3147b.get();
        Path path2 = f3148c.get();
        Path path3 = f3149d.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            C1374e.m2883b("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f3 - f2) - 1.0f) >= 0.01d) {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = C1357g.m2821a(min, length);
                max = C1357g.m2821a(max, length);
            }
            if (min < 0.0f) {
                min = C1357g.m2821a(min, length);
            }
            if (max < 0.0f) {
                max = C1357g.m2821a(max, length);
            }
            if (min == max) {
                path.reset();
                C1374e.m2883b("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            C1374e.m2883b("applyTrimPathIfNeeded");
            return;
        }
        C1374e.m2883b("applyTrimPathIfNeeded");
    }

    /* renamed from: a */
    public static float m2832a() {
        if (f3152g == -1.0f) {
            f3152g = Resources.getSystem().getDisplayMetrics().density;
        }
        return f3152g;
    }

    /* renamed from: a */
    public static float m2833a(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    /* renamed from: a */
    public static Bitmap m2836a(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    /* renamed from: a */
    public static boolean m2845a(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    /* renamed from: a */
    public static void m2839a(Canvas canvas, RectF rectF, Paint paint) {
        m2840a(canvas, rectF, paint, 31);
    }

    /* renamed from: a */
    public static void m2840a(Canvas canvas, RectF rectF, Paint paint, int i2) {
        C1374e.m2881a("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i2);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        C1374e.m2883b("Utils#saveLayer");
    }

    /* renamed from: a */
    public static Bitmap m2837a(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        Bitmap createBitmap = Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        C1392a c1392a = new C1392a();
        c1392a.setAntiAlias(true);
        c1392a.setColor(-16776961);
        canvas.drawPath(path, c1392a);
        return createBitmap;
    }
}
