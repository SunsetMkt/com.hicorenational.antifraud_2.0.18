package p388ui.view.signature;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class GestureSignatureView extends View {

    /* renamed from: i */
    private static final String f24976i = "GestureSignatureView";

    /* renamed from: a */
    private Context f24977a;

    /* renamed from: b */
    private Path f24978b;

    /* renamed from: c */
    private Paint f24979c;

    /* renamed from: d */
    private Canvas f24980d;

    /* renamed from: e */
    private Bitmap f24981e;

    /* renamed from: f */
    private boolean f24982f;

    /* renamed from: g */
    private float[] f24983g;

    /* renamed from: h */
    private float[] f24984h;

    public GestureSignatureView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static Bitmap m26032a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* renamed from: b */
    private void m26034b() {
        this.f24979c = new Paint(1);
        this.f24979c.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f24979c.setStrokeWidth(10.0f);
        this.f24979c.setStrokeCap(Paint.Cap.ROUND);
        this.f24979c.setStyle(Paint.Style.STROKE);
        this.f24979c.setStrokeJoin(Paint.Join.ROUND);
        this.f24979c.setDither(true);
        this.f24978b = new Path();
    }

    public Bitmap getPaintBitmap() {
        return m26032a(this.f24981e, 320, 480);
    }

    public boolean getTouched() {
        return this.f24982f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(this.f24981e, 0.0f, 0.0f, this.f24979c);
        canvas.drawPath(this.f24978b, this.f24979c);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f24981e = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f24980d = new Canvas(this.f24981e);
        this.f24980d.drawColor(0);
        this.f24980d.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        this.f24982f = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        String str = "onMeasure: 测量的宽高：" + getMeasuredWidth() + "-----------" + getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f24983g[0] = motionEvent.getX();
        this.f24983g[1] = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            float[] fArr = this.f24984h;
            float[] fArr2 = this.f24983g;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            this.f24978b.moveTo(fArr2[0], fArr2[1]);
        } else if (action == 1) {
            this.f24980d.drawPath(this.f24978b, this.f24979c);
            this.f24978b.reset();
        } else if (action == 2) {
            float abs = Math.abs(this.f24983g[0] - this.f24984h[0]);
            float abs2 = Math.abs(this.f24983g[1] - this.f24984h[1]);
            if (abs >= 3.0f || abs2 >= 3.0f) {
                float[] fArr3 = this.f24983g;
                float f2 = fArr3[0];
                float[] fArr4 = this.f24984h;
                this.f24978b.quadTo(fArr4[0], fArr4[1], (f2 + fArr4[0]) / 2.0f, (fArr3[1] + fArr4[1]) / 2.0f);
                float[] fArr5 = this.f24984h;
                float[] fArr6 = this.f24983g;
                fArr5[0] = fArr6[0];
                fArr5[1] = fArr6[1];
                this.f24982f = true;
            }
        }
        invalidate();
        return true;
    }

    public GestureSignatureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureSignatureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24982f = false;
        this.f24983g = new float[2];
        this.f24984h = new float[2];
        this.f24977a = context;
        m26034b();
    }

    /* renamed from: a */
    public void m26035a() {
        if (this.f24980d != null) {
            this.f24982f = false;
            this.f24978b.reset();
            this.f24980d.drawColor(0, PorterDuff.Mode.CLEAR);
            invalidate();
        }
    }

    /* renamed from: a */
    public void m26036a(String str) throws IOException {
        m26037a(str, false, 0);
    }

    @SuppressLint({"WrongThread"})
    /* renamed from: a */
    public void m26037a(String str, boolean z, int i2) throws IOException {
        Bitmap bitmap = this.f24981e;
        if (z) {
            bitmap = m26031a(bitmap, i2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray != null) {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArray);
            fileOutputStream.close();
            m26033a(file);
        }
    }

    /* renamed from: a */
    private Bitmap m26031a(Bitmap bitmap, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int[] iArr = new int[width];
        int i3 = 0;
        for (int i4 = 0; i4 < height; i4++) {
            bitmap.getPixels(iArr, 0, width, 0, i4, width, 1);
            int length = iArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z4 = false;
                    break;
                }
                if (iArr[i5] != 0) {
                    i3 = i4;
                    z4 = true;
                    break;
                }
                i5++;
            }
            if (z4) {
                break;
            }
        }
        int i6 = height - 1;
        int i7 = 0;
        for (int i8 = i6; i8 >= 0; i8--) {
            bitmap.getPixels(iArr, 0, width, 0, i8, width, 1);
            int length2 = iArr.length;
            int i9 = 0;
            while (true) {
                if (i9 >= length2) {
                    z3 = false;
                    break;
                }
                if (iArr[i9] != 0) {
                    i7 = i8;
                    z3 = true;
                    break;
                }
                i9++;
            }
            if (z3) {
                break;
            }
        }
        int[] iArr2 = new int[height];
        int i10 = 0;
        for (int i11 = 0; i11 < width; i11++) {
            bitmap.getPixels(iArr2, 0, 1, i11, 0, 1, height);
            int length3 = iArr2.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length3) {
                    z2 = false;
                    break;
                }
                if (iArr2[i12] != 0) {
                    i10 = i11;
                    z2 = true;
                    break;
                }
                i12++;
            }
            if (z2) {
                break;
            }
        }
        int i13 = width - 1;
        int i14 = 0;
        for (int i15 = i13; i15 > 0; i15--) {
            bitmap.getPixels(iArr2, 0, 1, i15, 0, 1, height);
            int length4 = iArr2.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length4) {
                    z = false;
                    break;
                }
                if (iArr2[i16] != 0) {
                    i14 = i15;
                    z = true;
                    break;
                }
                i16++;
            }
            if (z) {
                break;
            }
        }
        int i17 = i2 < 0 ? 0 : i2;
        int i18 = i10 - i17;
        if (i18 <= 0) {
            i18 = 0;
        }
        int i19 = i3 - i17;
        if (i19 <= 0) {
            i19 = 0;
        }
        int i20 = i14 + i17;
        if (i20 > i13) {
            i20 = i13;
        }
        int i21 = i7 + i17;
        if (i21 > i6) {
            i21 = i6;
        }
        return Bitmap.createBitmap(bitmap, i18, i19, i20 - i18, i21 - i19);
    }

    /* renamed from: a */
    private void m26033a(File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        getContext().sendBroadcast(intent);
    }
}
