package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.util.C1876j;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: TransformationUtils.java */
/* renamed from: com.bumptech.glide.load.r.d.g0 */
/* loaded from: classes.dex */
public final class C1729g0 {

    /* renamed from: a */
    private static final String f4845a = "TransformationUtils";

    /* renamed from: b */
    public static final int f4846b = 6;

    /* renamed from: d */
    private static final int f4848d = 7;

    /* renamed from: f */
    private static final Paint f4850f;

    /* renamed from: h */
    private static final Lock f4852h;

    /* renamed from: c */
    private static final Paint f4847c = new Paint(6);

    /* renamed from: e */
    private static final Paint f4849e = new Paint(7);

    /* renamed from: g */
    private static final Set<String> f4851g = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));

    /* compiled from: TransformationUtils.java */
    /* renamed from: com.bumptech.glide.load.r.d.g0$a */
    class a implements c {

        /* renamed from: a */
        final /* synthetic */ int f4853a;

        a(int i2) {
            this.f4853a = i2;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1729g0.c
        /* renamed from: a */
        public void mo4336a(Canvas canvas, Paint paint, RectF rectF) {
            int i2 = this.f4853a;
            canvas.drawRoundRect(rectF, i2, i2, paint);
        }
    }

    /* compiled from: TransformationUtils.java */
    /* renamed from: com.bumptech.glide.load.r.d.g0$b */
    class b implements c {

        /* renamed from: a */
        final /* synthetic */ float f4854a;

        /* renamed from: b */
        final /* synthetic */ float f4855b;

        /* renamed from: c */
        final /* synthetic */ float f4856c;

        /* renamed from: d */
        final /* synthetic */ float f4857d;

        b(float f2, float f3, float f4, float f5) {
            this.f4854a = f2;
            this.f4855b = f3;
            this.f4856c = f4;
            this.f4857d = f5;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1729g0.c
        /* renamed from: a */
        public void mo4336a(Canvas canvas, Paint paint, RectF rectF) {
            Path path = new Path();
            float f2 = this.f4854a;
            float f3 = this.f4855b;
            float f4 = this.f4856c;
            float f5 = this.f4857d;
            path.addRoundRect(rectF, new float[]{f2, f2, f3, f3, f4, f4, f5, f5}, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    /* compiled from: TransformationUtils.java */
    /* renamed from: com.bumptech.glide.load.r.d.g0$c */
    private interface c {
        /* renamed from: a */
        void mo4336a(Canvas canvas, Paint paint, RectF rectF);
    }

    /* compiled from: TransformationUtils.java */
    /* renamed from: com.bumptech.glide.load.r.d.g0$d */
    private static final class d implements Lock {
        d() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        f4852h = f4851g.contains(Build.MODEL) ? new ReentrantLock() : new d();
        f4850f = new Paint(7);
        f4850f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private C1729g0() {
    }

    /* renamed from: a */
    public static int m4316a(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static Lock m4325a() {
        return f4852h;
    }

    /* renamed from: b */
    public static Bitmap m4332b(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            Log.isLoggable(f4845a, 2);
            return m4335d(interfaceC1626e, bitmap, i2, i3);
        }
        Log.isLoggable(f4845a, 2);
        return bitmap;
    }

    /* renamed from: b */
    public static boolean m4333b(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: c */
    public static Bitmap m4334c(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        int min = Math.min(i2, i3);
        float f2 = min;
        float f3 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f2 / width, f2 / height);
        float f4 = width * max;
        float f5 = max * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap m4319a = m4319a(interfaceC1626e, bitmap);
        Bitmap mo3920a = interfaceC1626e.mo3920a(min, min, m4317a(bitmap));
        mo3920a.setHasAlpha(true);
        f4852h.lock();
        try {
            Canvas canvas = new Canvas(mo3920a);
            canvas.drawCircle(f3, f3, f3, f4849e);
            canvas.drawBitmap(m4319a, (Rect) null, rectF, f4850f);
            m4329a(canvas);
            f4852h.unlock();
            if (!m4319a.equals(bitmap)) {
                interfaceC1626e.mo3924a(m4319a);
            }
            return mo3920a;
        } catch (Throwable th) {
            f4852h.unlock();
            throw th;
        }
    }

    /* renamed from: d */
    public static Bitmap m4335d(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            Log.isLoggable(f4845a, 2);
            return bitmap;
        }
        float min = Math.min(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            Log.isLoggable(f4845a, 2);
            return bitmap;
        }
        Bitmap mo3920a = interfaceC1626e.mo3920a((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), m4330b(bitmap));
        m4327a(bitmap, mo3920a);
        if (Log.isLoggable(f4845a, 2)) {
            String str = "request: " + i2 + "x" + i3;
            String str2 = "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight();
            String str3 = "toReuse: " + mo3920a.getWidth() + "x" + mo3920a.getHeight();
            String str4 = "minPct:   " + min;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        m4328a(bitmap, mo3920a, matrix);
        return mo3920a;
    }

    /* renamed from: a */
    public static Bitmap m4322a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        float width;
        float f2;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f3 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            width = i3 / bitmap.getHeight();
            f2 = (i2 - (bitmap.getWidth() * width)) * 0.5f;
        } else {
            width = i2 / bitmap.getWidth();
            f3 = (i3 - (bitmap.getHeight() * width)) * 0.5f;
            f2 = 0.0f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f2 + 0.5f), (int) (f3 + 0.5f));
        Bitmap mo3920a = interfaceC1626e.mo3920a(i2, i3, m4330b(bitmap));
        m4327a(bitmap, mo3920a);
        m4328a(bitmap, mo3920a, matrix);
        return mo3920a;
    }

    /* renamed from: b */
    public static Bitmap m4331b(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2) {
        C1876j.m4989a(i2 > 0, "roundingRadius must be greater than 0.");
        return m4324a(interfaceC1626e, bitmap, new a(i2));
    }

    @NonNull
    /* renamed from: b */
    private static Bitmap.Config m4330b(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    /* renamed from: a */
    public static void m4327a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    /* renamed from: a */
    public static Bitmap m4318a(@NonNull Bitmap bitmap, int i2) {
        if (i2 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(i2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception unused) {
            Log.isLoggable(f4845a, 6);
            return bitmap;
        }
    }

    /* renamed from: a */
    public static Bitmap m4321a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2) {
        if (!m4333b(i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        m4326a(i2, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap mo3920a = interfaceC1626e.mo3920a(Math.round(rectF.width()), Math.round(rectF.height()), m4330b(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        mo3920a.setHasAlpha(bitmap.hasAlpha());
        m4328a(bitmap, mo3920a, matrix);
        return mo3920a;
    }

    /* renamed from: a */
    private static Bitmap m4319a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap) {
        Bitmap.Config m4317a = m4317a(bitmap);
        if (m4317a.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap mo3920a = interfaceC1626e.mo3920a(bitmap.getWidth(), bitmap.getHeight(), m4317a);
        new Canvas(mo3920a).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return mo3920a;
    }

    @NonNull
    /* renamed from: a */
    private static Bitmap.Config m4317a(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    @Deprecated
    /* renamed from: a */
    public static Bitmap m4323a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3, int i4) {
        return m4331b(interfaceC1626e, bitmap, i4);
    }

    /* renamed from: a */
    public static Bitmap m4320a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, float f2, float f3, float f4, float f5) {
        return m4324a(interfaceC1626e, bitmap, new b(f2, f3, f4, f5));
    }

    /* renamed from: a */
    private static Bitmap m4324a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, c cVar) {
        Bitmap.Config m4317a = m4317a(bitmap);
        Bitmap m4319a = m4319a(interfaceC1626e, bitmap);
        Bitmap mo3920a = interfaceC1626e.mo3920a(m4319a.getWidth(), m4319a.getHeight(), m4317a);
        mo3920a.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(m4319a, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, mo3920a.getWidth(), mo3920a.getHeight());
        f4852h.lock();
        try {
            Canvas canvas = new Canvas(mo3920a);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            cVar.mo4336a(canvas, paint, rectF);
            m4329a(canvas);
            f4852h.unlock();
            if (!m4319a.equals(bitmap)) {
                interfaceC1626e.mo3924a(m4319a);
            }
            return mo3920a;
        } catch (Throwable th) {
            f4852h.unlock();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m4329a(Canvas canvas) {
        canvas.setBitmap(null);
    }

    /* renamed from: a */
    private static void m4328a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        f4852h.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f4847c);
            m4329a(canvas);
        } finally {
            f4852h.unlock();
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m4326a(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }
}
