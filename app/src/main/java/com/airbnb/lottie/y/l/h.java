package com.airbnb.lottie.y.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j;
import com.airbnb.lottie.o;
import com.airbnb.lottie.v;
import com.airbnb.lottie.w.c.n;
import com.airbnb.lottie.w.c.p;
import com.airbnb.lottie.y.b;
import com.airbnb.lottie.y.j.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TextLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends com.airbnb.lottie.y.l.a {
    private final StringBuilder D;
    private final RectF E;
    private final Matrix F;
    private final Paint G;
    private final Paint H;
    private final Map<com.airbnb.lottie.y.d, List<com.airbnb.lottie.w.b.d>> I;
    private final LongSparseArray<String> J;
    private final n K;
    private final j L;
    private final com.airbnb.lottie.g M;

    @Nullable
    private com.airbnb.lottie.w.c.a<Integer, Integer> N;

    @Nullable
    private com.airbnb.lottie.w.c.a<Integer, Integer> O;

    @Nullable
    private com.airbnb.lottie.w.c.a<Integer, Integer> P;

    @Nullable
    private com.airbnb.lottie.w.c.a<Integer, Integer> Q;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> R;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> S;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> T;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> U;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> V;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> W;

    @Nullable
    private com.airbnb.lottie.w.c.a<Typeface, Typeface> X;

    /* JADX INFO: compiled from: TextLayer.java */
    class a extends Paint {
        a(int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    /* JADX INFO: compiled from: TextLayer.java */
    class b extends Paint {
        b(int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: compiled from: TextLayer.java */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a = new int[b.a.values().length];

        static {
            try {
                a[b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    h(j jVar, d dVar) {
        com.airbnb.lottie.y.j.b bVar;
        com.airbnb.lottie.y.j.b bVar2;
        com.airbnb.lottie.y.j.a aVar;
        com.airbnb.lottie.y.j.a aVar2;
        super(jVar, dVar);
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        this.G = new a(1);
        this.H = new b(1);
        this.I = new HashMap();
        this.J = new LongSparseArray<>();
        this.L = jVar;
        this.M = dVar.a();
        this.K = dVar.q().a();
        this.K.a(this);
        a(this.K);
        k kVarR = dVar.r();
        if (kVarR != null && (aVar2 = kVarR.a) != null) {
            this.N = aVar2.a();
            this.N.a(this);
            a(this.N);
        }
        if (kVarR != null && (aVar = kVarR.f2428b) != null) {
            this.P = aVar.a();
            this.P.a(this);
            a(this.P);
        }
        if (kVarR != null && (bVar2 = kVarR.f2429c) != null) {
            this.R = bVar2.a();
            this.R.a(this);
            a(this.R);
        }
        if (kVarR == null || (bVar = kVarR.f2430d) == null) {
            return;
        }
        this.T = bVar.a();
        this.T.a(this);
        a(this.T);
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.M.a().width(), this.M.a().height());
    }

    @Override // com.airbnb.lottie.y.l.a
    void b(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.L.D()) {
            canvas.concat(matrix);
        }
        com.airbnb.lottie.y.b bVarF = this.K.f();
        com.airbnb.lottie.y.c cVar = this.M.f().get(bVarF.f2401b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.w.c.a<Integer, Integer> aVar = this.O;
        if (aVar != null) {
            this.G.setColor(aVar.f().intValue());
        } else {
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar2 = this.N;
            if (aVar2 != null) {
                this.G.setColor(aVar2.f().intValue());
            } else {
                this.G.setColor(bVarF.f2407h);
            }
        }
        com.airbnb.lottie.w.c.a<Integer, Integer> aVar3 = this.Q;
        if (aVar3 != null) {
            this.H.setColor(aVar3.f().intValue());
        } else {
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar4 = this.P;
            if (aVar4 != null) {
                this.H.setColor(aVar4.f().intValue());
            } else {
                this.H.setColor(bVarF.f2408i);
            }
        }
        int iIntValue = ((this.v.c() == null ? 100 : this.v.c().f().intValue()) * 255) / 100;
        this.G.setAlpha(iIntValue);
        this.H.setAlpha(iIntValue);
        com.airbnb.lottie.w.c.a<Float, Float> aVar5 = this.S;
        if (aVar5 != null) {
            this.H.setStrokeWidth(aVar5.f().floatValue());
        } else {
            com.airbnb.lottie.w.c.a<Float, Float> aVar6 = this.R;
            if (aVar6 != null) {
                this.H.setStrokeWidth(aVar6.f().floatValue());
            } else {
                this.H.setStrokeWidth(bVarF.f2409j * com.airbnb.lottie.b0.h.a() * com.airbnb.lottie.b0.h.a(matrix));
            }
        }
        if (this.L.D()) {
            a(bVarF, matrix, cVar, canvas);
        } else {
            a(bVarF, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.y.b bVar, Matrix matrix, com.airbnb.lottie.y.c cVar, Canvas canvas) {
        float fFloatValue;
        com.airbnb.lottie.w.c.a<Float, Float> aVar = this.W;
        if (aVar != null) {
            fFloatValue = aVar.f().floatValue();
        } else {
            com.airbnb.lottie.w.c.a<Float, Float> aVar2 = this.V;
            if (aVar2 != null) {
                fFloatValue = aVar2.f().floatValue();
            } else {
                fFloatValue = bVar.f2402c;
            }
        }
        float f2 = fFloatValue / 100.0f;
        float fA = com.airbnb.lottie.b0.h.a(matrix);
        String str = bVar.a;
        float fA2 = bVar.f2405f * com.airbnb.lottie.b0.h.a();
        List<String> listA = a(str);
        int size = listA.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = listA.get(i2);
            float fA3 = a(str2, cVar, f2, fA);
            canvas.save();
            a(bVar.f2403d, canvas, fA3);
            canvas.translate(0.0f, (i2 * fA2) - (((size - 1) * fA2) / 2.0f));
            a(str2, bVar, matrix, cVar, canvas, fA, f2);
            canvas.restore();
        }
    }

    private void a(String str, com.airbnb.lottie.y.b bVar, Matrix matrix, com.airbnb.lottie.y.c cVar, Canvas canvas, float f2, float f3) {
        float fFloatValue;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.y.d dVar = this.M.b().get(com.airbnb.lottie.y.d.a(str.charAt(i2), cVar.b(), cVar.d()));
            if (dVar != null) {
                a(dVar, matrix, f3, bVar, canvas);
                float fD = ((float) dVar.d()) * f3 * com.airbnb.lottie.b0.h.a() * f2;
                float f4 = bVar.f2404e / 10.0f;
                com.airbnb.lottie.w.c.a<Float, Float> aVar = this.U;
                if (aVar != null) {
                    fFloatValue = aVar.f().floatValue();
                } else {
                    com.airbnb.lottie.w.c.a<Float, Float> aVar2 = this.T;
                    if (aVar2 != null) {
                        fFloatValue = aVar2.f().floatValue();
                    }
                    canvas.translate(fD + (f4 * f2), 0.0f);
                }
                f4 += fFloatValue;
                canvas.translate(fD + (f4 * f2), 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009e A[LOOP:0: B:23:0x009c->B:24:0x009e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.airbnb.lottie.y.b bVar, com.airbnb.lottie.y.c cVar, Matrix matrix, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        int size;
        int i2;
        Typeface typefaceA = a(cVar);
        if (typefaceA == null) {
            return;
        }
        String strB = bVar.a;
        v vVarQ = this.L.q();
        if (vVarQ != null) {
            strB = vVarQ.b(strB);
        }
        this.G.setTypeface(typefaceA);
        com.airbnb.lottie.w.c.a<Float, Float> aVar = this.W;
        if (aVar != null) {
            fFloatValue = aVar.f().floatValue();
        } else {
            com.airbnb.lottie.w.c.a<Float, Float> aVar2 = this.V;
            if (aVar2 != null) {
                fFloatValue = aVar2.f().floatValue();
            } else {
                fFloatValue = bVar.f2402c;
            }
        }
        this.G.setTextSize(com.airbnb.lottie.b0.h.a() * fFloatValue);
        this.H.setTypeface(this.G.getTypeface());
        this.H.setTextSize(this.G.getTextSize());
        float fA = bVar.f2405f * com.airbnb.lottie.b0.h.a();
        float f2 = bVar.f2404e / 10.0f;
        com.airbnb.lottie.w.c.a<Float, Float> aVar3 = this.U;
        if (aVar3 != null) {
            fFloatValue2 = aVar3.f().floatValue();
        } else {
            com.airbnb.lottie.w.c.a<Float, Float> aVar4 = this.T;
            if (aVar4 != null) {
                fFloatValue2 = aVar4.f().floatValue();
            }
            float fA2 = ((f2 * com.airbnb.lottie.b0.h.a()) * fFloatValue) / 100.0f;
            List<String> listA = a(strB);
            size = listA.size();
            for (i2 = 0; i2 < size; i2++) {
                String str = listA.get(i2);
                float fMeasureText = this.H.measureText(str) + ((str.length() - 1) * fA2);
                canvas.save();
                a(bVar.f2403d, canvas, fMeasureText);
                canvas.translate(0.0f, (i2 * fA) - (((size - 1) * fA) / 2.0f));
                a(str, bVar, canvas, fA2);
                canvas.restore();
            }
        }
        f2 += fFloatValue2;
        float fA22 = ((f2 * com.airbnb.lottie.b0.h.a()) * fFloatValue) / 100.0f;
        List<String> listA2 = a(strB);
        size = listA2.size();
        while (i2 < size) {
        }
    }

    @Nullable
    private Typeface a(com.airbnb.lottie.y.c cVar) {
        Typeface typefaceF;
        com.airbnb.lottie.w.c.a<Typeface, Typeface> aVar = this.X;
        if (aVar != null && (typefaceF = aVar.f()) != null) {
            return typefaceF;
        }
        Typeface typefaceA = this.L.a(cVar.b(), cVar.d());
        return typefaceA != null ? typefaceA : cVar.e();
    }

    private List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(String str, com.airbnb.lottie.y.b bVar, Canvas canvas, float f2) {
        int length = 0;
        while (length < str.length()) {
            String strA = a(str, length);
            length += strA.length();
            a(strA, bVar, canvas);
            canvas.translate(this.G.measureText(strA) + f2, 0.0f);
        }
    }

    private float a(String str, com.airbnb.lottie.y.c cVar, float f2, float f3) {
        float fD = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.y.d dVar = this.M.b().get(com.airbnb.lottie.y.d.a(str.charAt(i2), cVar.b(), cVar.d()));
            if (dVar != null) {
                fD = (float) (((double) fD) + (dVar.d() * ((double) f2) * ((double) com.airbnb.lottie.b0.h.a()) * ((double) f3)));
            }
        }
        return fD;
    }

    private void a(b.a aVar, Canvas canvas, float f2) {
        int i2 = c.a[aVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                canvas.translate(-f2, 0.0f);
            } else {
                if (i2 != 3) {
                    return;
                }
                canvas.translate((-f2) / 2.0f, 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.y.d dVar, Matrix matrix, float f2, com.airbnb.lottie.y.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.w.b.d> listA = a(dVar);
        for (int i2 = 0; i2 < listA.size(); i2++) {
            Path path = listA.get(i2).getPath();
            path.computeBounds(this.E, false);
            this.F.set(matrix);
            this.F.preTranslate(0.0f, (-bVar.f2406g) * com.airbnb.lottie.b0.h.a());
            this.F.preScale(f2, f2);
            path.transform(this.F);
            if (bVar.f2410k) {
                a(path, this.G, canvas);
                a(path, this.H, canvas);
            } else {
                a(path, this.H, canvas);
                a(path, this.G, canvas);
            }
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(String str, com.airbnb.lottie.y.b bVar, Canvas canvas) {
        if (bVar.f2410k) {
            a(str, this.G, canvas);
            a(str, this.H, canvas);
        } else {
            a(str, this.H, canvas);
            a(str, this.G, canvas);
        }
    }

    private void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.airbnb.lottie.w.b.d> a(com.airbnb.lottie.y.d dVar) {
        if (this.I.containsKey(dVar)) {
            return this.I.get(dVar);
        }
        List<com.airbnb.lottie.y.k.n> listA = dVar.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.airbnb.lottie.w.b.d(this.L, this, listA.get(i2)));
        }
        this.I.put(dVar, arrayList);
        return arrayList;
    }

    private String a(String str, int i2) {
        int iCodePointAt = str.codePointAt(i2);
        int iCharCount = Character.charCount(iCodePointAt) + i2;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!a(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j2 = iCodePointAt;
        if (this.J.containsKey(j2)) {
            return this.J.get(j2);
        }
        this.D.setLength(0);
        while (i2 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i2);
            this.D.appendCodePoint(iCodePointAt3);
            i2 += Character.charCount(iCodePointAt3);
        }
        String string = this.D.toString();
        this.J.put(j2, string);
        return string;
    }

    private boolean a(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        super.a(t, jVar);
        if (t == o.a) {
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar = this.O;
            if (aVar != null) {
                b(aVar);
            }
            if (jVar == null) {
                this.O = null;
                return;
            }
            this.O = new p(jVar);
            this.O.a(this);
            a(this.O);
            return;
        }
        if (t == o.f2221b) {
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar2 = this.Q;
            if (aVar2 != null) {
                b(aVar2);
            }
            if (jVar == null) {
                this.Q = null;
                return;
            }
            this.Q = new p(jVar);
            this.Q.a(this);
            a(this.Q);
            return;
        }
        if (t == o.q) {
            com.airbnb.lottie.w.c.a<Float, Float> aVar3 = this.S;
            if (aVar3 != null) {
                b(aVar3);
            }
            if (jVar == null) {
                this.S = null;
                return;
            }
            this.S = new p(jVar);
            this.S.a(this);
            a(this.S);
            return;
        }
        if (t == o.r) {
            com.airbnb.lottie.w.c.a<Float, Float> aVar4 = this.U;
            if (aVar4 != null) {
                b(aVar4);
            }
            if (jVar == null) {
                this.U = null;
                return;
            }
            this.U = new p(jVar);
            this.U.a(this);
            a(this.U);
            return;
        }
        if (t == o.D) {
            com.airbnb.lottie.w.c.a<Float, Float> aVar5 = this.W;
            if (aVar5 != null) {
                b(aVar5);
            }
            if (jVar == null) {
                this.W = null;
                return;
            }
            this.W = new p(jVar);
            this.W.a(this);
            a(this.W);
            return;
        }
        if (t == o.G) {
            com.airbnb.lottie.w.c.a<Typeface, Typeface> aVar6 = this.X;
            if (aVar6 != null) {
                b(aVar6);
            }
            if (jVar == null) {
                this.X = null;
                return;
            }
            this.X = new p(jVar);
            this.X.a(this);
            a(this.X);
        }
    }
}
