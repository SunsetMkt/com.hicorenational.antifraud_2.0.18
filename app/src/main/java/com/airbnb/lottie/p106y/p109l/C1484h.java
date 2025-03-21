package com.airbnb.lottie.p106y.p109l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.p103b.C1396d;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1427n;
import com.airbnb.lottie.p102w.p104c.C1429p;
import com.airbnb.lottie.p106y.C1436b;
import com.airbnb.lottie.p106y.C1437c;
import com.airbnb.lottie.p106y.C1438d;
import com.airbnb.lottie.p106y.p107j.C1444a;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1454k;
import com.airbnb.lottie.p106y.p108k.C1472n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer.java */
/* renamed from: com.airbnb.lottie.y.l.h */
/* loaded from: classes.dex */
public class C1484h extends AbstractC1477a {

    /* renamed from: D */
    private final StringBuilder f3805D;

    /* renamed from: E */
    private final RectF f3806E;

    /* renamed from: F */
    private final Matrix f3807F;

    /* renamed from: G */
    private final Paint f3808G;

    /* renamed from: H */
    private final Paint f3809H;

    /* renamed from: I */
    private final Map<C1438d, List<C1396d>> f3810I;

    /* renamed from: J */
    private final LongSparseArray<String> f3811J;

    /* renamed from: K */
    private final C1427n f3812K;

    /* renamed from: L */
    private final C1379j f3813L;

    /* renamed from: M */
    private final C1376g f3814M;

    /* renamed from: N */
    @Nullable
    private AbstractC1414a<Integer, Integer> f3815N;

    /* renamed from: O */
    @Nullable
    private AbstractC1414a<Integer, Integer> f3816O;

    /* renamed from: P */
    @Nullable
    private AbstractC1414a<Integer, Integer> f3817P;

    /* renamed from: Q */
    @Nullable
    private AbstractC1414a<Integer, Integer> f3818Q;

    /* renamed from: R */
    @Nullable
    private AbstractC1414a<Float, Float> f3819R;

    /* renamed from: S */
    @Nullable
    private AbstractC1414a<Float, Float> f3820S;

    /* renamed from: T */
    @Nullable
    private AbstractC1414a<Float, Float> f3821T;

    /* renamed from: U */
    @Nullable
    private AbstractC1414a<Float, Float> f3822U;

    /* renamed from: V */
    @Nullable
    private AbstractC1414a<Float, Float> f3823V;

    /* renamed from: W */
    @Nullable
    private AbstractC1414a<Float, Float> f3824W;

    /* renamed from: X */
    @Nullable
    private AbstractC1414a<Typeface, Typeface> f3825X;

    /* compiled from: TextLayer.java */
    /* renamed from: com.airbnb.lottie.y.l.h$a */
    class a extends Paint {
        a(int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    /* renamed from: com.airbnb.lottie.y.l.h$b */
    class b extends Paint {
        b(int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* compiled from: TextLayer.java */
    /* renamed from: com.airbnb.lottie.y.l.h$c */
    static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f3828a = new int[C1436b.a.values().length];

        static {
            try {
                f3828a[C1436b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3828a[C1436b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3828a[C1436b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    C1484h(C1379j c1379j, C1480d c1480d) {
        super(c1379j, c1480d);
        C1445b c1445b;
        C1445b c1445b2;
        C1444a c1444a;
        C1444a c1444a2;
        this.f3805D = new StringBuilder(2);
        this.f3806E = new RectF();
        this.f3807F = new Matrix();
        this.f3808G = new a(1);
        this.f3809H = new b(1);
        this.f3810I = new HashMap();
        this.f3811J = new LongSparseArray<>();
        this.f3813L = c1379j;
        this.f3814M = c1480d.m3358a();
        this.f3812K = c1480d.m3375q().mo3220a();
        this.f3812K.m3138a(this);
        m3345a(this.f3812K);
        C1454k m3376r = c1480d.m3376r();
        if (m3376r != null && (c1444a2 = m3376r.f3617a) != null) {
            this.f3815N = c1444a2.mo3220a();
            this.f3815N.m3138a(this);
            m3345a(this.f3815N);
        }
        if (m3376r != null && (c1444a = m3376r.f3618b) != null) {
            this.f3817P = c1444a.mo3220a();
            this.f3817P.m3138a(this);
            m3345a(this.f3817P);
        }
        if (m3376r != null && (c1445b2 = m3376r.f3619c) != null) {
            this.f3819R = c1445b2.mo3220a();
            this.f3819R.m3138a(this);
            m3345a(this.f3819R);
        }
        if (m3376r == null || (c1445b = m3376r.f3620d) == null) {
            return;
        }
        this.f3821T = c1445b.mo3220a();
        this.f3821T.m3138a(this);
        m3345a(this.f3821T);
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        super.mo3095a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.f3814M.m2888a().width(), this.f3814M.m2888a().height());
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: b */
    void mo3349b(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.f3813L.m2981D()) {
            canvas.concat(matrix);
        }
        C1436b mo3143f = this.f3812K.mo3143f();
        C1437c c1437c = this.f3814M.m2902f().get(mo3143f.f3581b);
        if (c1437c == null) {
            canvas.restore();
            return;
        }
        AbstractC1414a<Integer, Integer> abstractC1414a = this.f3816O;
        if (abstractC1414a != null) {
            this.f3808G.setColor(abstractC1414a.mo3143f().intValue());
        } else {
            AbstractC1414a<Integer, Integer> abstractC1414a2 = this.f3815N;
            if (abstractC1414a2 != null) {
                this.f3808G.setColor(abstractC1414a2.mo3143f().intValue());
            } else {
                this.f3808G.setColor(mo3143f.f3587h);
            }
        }
        AbstractC1414a<Integer, Integer> abstractC1414a3 = this.f3818Q;
        if (abstractC1414a3 != null) {
            this.f3809H.setColor(abstractC1414a3.mo3143f().intValue());
        } else {
            AbstractC1414a<Integer, Integer> abstractC1414a4 = this.f3817P;
            if (abstractC1414a4 != null) {
                this.f3809H.setColor(abstractC1414a4.mo3143f().intValue());
            } else {
                this.f3809H.setColor(mo3143f.f3588i);
            }
        }
        int intValue = ((this.f3754v.m3173c() == null ? 100 : this.f3754v.m3173c().mo3143f().intValue()) * 255) / 100;
        this.f3808G.setAlpha(intValue);
        this.f3809H.setAlpha(intValue);
        AbstractC1414a<Float, Float> abstractC1414a5 = this.f3820S;
        if (abstractC1414a5 != null) {
            this.f3809H.setStrokeWidth(abstractC1414a5.mo3143f().floatValue());
        } else {
            AbstractC1414a<Float, Float> abstractC1414a6 = this.f3819R;
            if (abstractC1414a6 != null) {
                this.f3809H.setStrokeWidth(abstractC1414a6.mo3143f().floatValue());
            } else {
                this.f3809H.setStrokeWidth(mo3143f.f3589j * C1358h.m2832a() * C1358h.m2834a(matrix));
            }
        }
        if (this.f3813L.m2981D()) {
            m3388a(mo3143f, matrix, c1437c, canvas);
        } else {
            m3389a(mo3143f, c1437c, matrix, canvas);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m3388a(C1436b c1436b, Matrix matrix, C1437c c1437c, Canvas canvas) {
        float f2;
        AbstractC1414a<Float, Float> abstractC1414a = this.f3824W;
        if (abstractC1414a != null) {
            f2 = abstractC1414a.mo3143f().floatValue();
        } else {
            AbstractC1414a<Float, Float> abstractC1414a2 = this.f3823V;
            if (abstractC1414a2 != null) {
                f2 = abstractC1414a2.mo3143f().floatValue();
            } else {
                f2 = c1436b.f3582c;
            }
        }
        float f3 = f2 / 100.0f;
        float m2834a = C1358h.m2834a(matrix);
        String str = c1436b.f3580a;
        float m2832a = c1436b.f3585f * C1358h.m2832a();
        List<String> m3385a = m3385a(str);
        int size = m3385a.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = m3385a.get(i2);
            float m3381a = m3381a(str2, c1437c, f3, m2834a);
            canvas.save();
            m3387a(c1436b.f3583d, canvas, m3381a);
            canvas.translate(0.0f, (i2 * m2832a) - (((size - 1) * m2832a) / 2.0f));
            m3394a(str2, c1436b, matrix, c1437c, canvas, m2834a, f3);
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m3394a(String str, C1436b c1436b, Matrix matrix, C1437c c1437c, Canvas canvas, float f2, float f3) {
        float floatValue;
        for (int i2 = 0; i2 < str.length(); i2++) {
            C1438d c1438d = this.f3814M.m2895b().get(C1438d.m3197a(str.charAt(i2), c1437c.m3193b(), c1437c.m3195d()));
            if (c1438d != null) {
                m3390a(c1438d, matrix, f3, c1436b, canvas);
                float m3201d = ((float) c1438d.m3201d()) * f3 * C1358h.m2832a() * f2;
                float f4 = c1436b.f3584e / 10.0f;
                AbstractC1414a<Float, Float> abstractC1414a = this.f3822U;
                if (abstractC1414a != null) {
                    floatValue = abstractC1414a.mo3143f().floatValue();
                } else {
                    AbstractC1414a<Float, Float> abstractC1414a2 = this.f3821T;
                    if (abstractC1414a2 != null) {
                        floatValue = abstractC1414a2.mo3143f().floatValue();
                    }
                    canvas.translate(m3201d + (f4 * f2), 0.0f);
                }
                f4 += floatValue;
                canvas.translate(m3201d + (f4 * f2), 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009e A[LOOP:0: B:16:0x009c->B:17:0x009e, LOOP_END] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3389a(com.airbnb.lottie.p106y.C1436b r7, com.airbnb.lottie.p106y.C1437c r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            android.graphics.Typeface r8 = r6.m3382a(r8)
            if (r8 != 0) goto L7
            return
        L7:
            java.lang.String r9 = r7.f3580a
            com.airbnb.lottie.j r0 = r6.f3813L
            com.airbnb.lottie.v r0 = r0.m3040q()
            if (r0 == 0) goto L15
            java.lang.String r9 = r0.m3089b(r9)
        L15:
            android.graphics.Paint r0 = r6.f3808G
            r0.setTypeface(r8)
            com.airbnb.lottie.w.c.a<java.lang.Float, java.lang.Float> r8 = r6.f3824W
            if (r8 == 0) goto L29
            java.lang.Object r8 = r8.mo3143f()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L3a
        L29:
            com.airbnb.lottie.w.c.a<java.lang.Float, java.lang.Float> r8 = r6.f3823V
            if (r8 == 0) goto L38
            java.lang.Object r8 = r8.mo3143f()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L3a
        L38:
            float r8 = r7.f3582c
        L3a:
            android.graphics.Paint r0 = r6.f3808G
            float r1 = com.airbnb.lottie.p100b0.C1358h.m2832a()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.f3809H
            android.graphics.Paint r1 = r6.f3808G
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.f3809H
            android.graphics.Paint r1 = r6.f3808G
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f3585f
            float r1 = com.airbnb.lottie.p100b0.C1358h.m2832a()
            float r0 = r0 * r1
            int r1 = r7.f3584e
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.airbnb.lottie.w.c.a<java.lang.Float, java.lang.Float> r2 = r6.f3822U
            if (r2 == 0) goto L79
            java.lang.Object r2 = r2.mo3143f()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L77:
            float r1 = r1 + r2
            goto L88
        L79:
            com.airbnb.lottie.w.c.a<java.lang.Float, java.lang.Float> r2 = r6.f3821T
            if (r2 == 0) goto L88
            java.lang.Object r2 = r2.mo3143f()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L77
        L88:
            float r2 = com.airbnb.lottie.p100b0.C1358h.m2832a()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.m3385a(r9)
            int r9 = r8.size()
            r2 = 0
        L9c:
            if (r2 >= r9) goto Ld5
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.f3809H
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            com.airbnb.lottie.y.b$a r5 = r7.f3583d
            r6.m3387a(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.m3393a(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto L9c
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p106y.p109l.C1484h.m3389a(com.airbnb.lottie.y.b, com.airbnb.lottie.y.c, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    @Nullable
    /* renamed from: a */
    private Typeface m3382a(C1437c c1437c) {
        Typeface mo3143f;
        AbstractC1414a<Typeface, Typeface> abstractC1414a = this.f3825X;
        if (abstractC1414a != null && (mo3143f = abstractC1414a.mo3143f()) != null) {
            return mo3143f;
        }
        Typeface m2984a = this.f3813L.m2984a(c1437c.m3193b(), c1437c.m3195d());
        return m2984a != null ? m2984a : c1437c.m3196e();
    }

    /* renamed from: a */
    private List<String> m3385a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    /* renamed from: a */
    private void m3393a(String str, C1436b c1436b, Canvas canvas, float f2) {
        int i2 = 0;
        while (i2 < str.length()) {
            String m3383a = m3383a(str, i2);
            i2 += m3383a.length();
            m3392a(m3383a, c1436b, canvas);
            canvas.translate(this.f3808G.measureText(m3383a) + f2, 0.0f);
        }
    }

    /* renamed from: a */
    private float m3381a(String str, C1437c c1437c, float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            C1438d c1438d = this.f3814M.m2895b().get(C1438d.m3197a(str.charAt(i2), c1437c.m3193b(), c1437c.m3195d()));
            if (c1438d != null) {
                f4 = (float) (f4 + (c1438d.m3201d() * f2 * C1358h.m2832a() * f3));
            }
        }
        return f4;
    }

    /* renamed from: a */
    private void m3387a(C1436b.a aVar, Canvas canvas, float f2) {
        int i2 = c.f3828a[aVar.ordinal()];
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

    /* renamed from: a */
    private void m3390a(C1438d c1438d, Matrix matrix, float f2, C1436b c1436b, Canvas canvas) {
        List<C1396d> m3384a = m3384a(c1438d);
        for (int i2 = 0; i2 < m3384a.size(); i2++) {
            Path path = m3384a.get(i2).getPath();
            path.computeBounds(this.f3806E, false);
            this.f3807F.set(matrix);
            this.f3807F.preTranslate(0.0f, (-c1436b.f3586g) * C1358h.m2832a());
            this.f3807F.preScale(f2, f2);
            path.transform(this.f3807F);
            if (c1436b.f3590k) {
                m3386a(path, this.f3808G, canvas);
                m3386a(path, this.f3809H, canvas);
            } else {
                m3386a(path, this.f3809H, canvas);
                m3386a(path, this.f3808G, canvas);
            }
        }
    }

    /* renamed from: a */
    private void m3386a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    /* renamed from: a */
    private void m3392a(String str, C1436b c1436b, Canvas canvas) {
        if (c1436b.f3590k) {
            m3391a(str, this.f3808G, canvas);
            m3391a(str, this.f3809H, canvas);
        } else {
            m3391a(str, this.f3809H, canvas);
            m3391a(str, this.f3808G, canvas);
        }
    }

    /* renamed from: a */
    private void m3391a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    /* renamed from: a */
    private List<C1396d> m3384a(C1438d c1438d) {
        if (this.f3810I.containsKey(c1438d)) {
            return this.f3810I.get(c1438d);
        }
        List<C1472n> m3198a = c1438d.m3198a();
        int size = m3198a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new C1396d(this.f3813L, this, m3198a.get(i2)));
        }
        this.f3810I.put(c1438d, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private String m3383a(String str, int i2) {
        int codePointAt = str.codePointAt(i2);
        int charCount = Character.charCount(codePointAt) + i2;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!m3395a(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j2 = codePointAt;
        if (this.f3811J.containsKey(j2)) {
            return this.f3811J.get(j2);
        }
        this.f3805D.setLength(0);
        while (i2 < charCount) {
            int codePointAt3 = str.codePointAt(i2);
            this.f3805D.appendCodePoint(codePointAt3);
            i2 += Character.charCount(codePointAt3);
        }
        String sb = this.f3805D.toString();
        this.f3811J.put(j2, sb);
        return sb;
    }

    /* renamed from: a */
    private boolean m3395a(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        super.mo3097a((C1484h) t, (C1370j<C1484h>) c1370j);
        if (t == InterfaceC1384o.f3330a) {
            AbstractC1414a<Integer, Integer> abstractC1414a = this.f3816O;
            if (abstractC1414a != null) {
                m3350b(abstractC1414a);
            }
            if (c1370j == null) {
                this.f3816O = null;
                return;
            }
            this.f3816O = new C1429p(c1370j);
            this.f3816O.m3138a(this);
            m3345a(this.f3816O);
            return;
        }
        if (t == InterfaceC1384o.f3331b) {
            AbstractC1414a<Integer, Integer> abstractC1414a2 = this.f3818Q;
            if (abstractC1414a2 != null) {
                m3350b(abstractC1414a2);
            }
            if (c1370j == null) {
                this.f3818Q = null;
                return;
            }
            this.f3818Q = new C1429p(c1370j);
            this.f3818Q.m3138a(this);
            m3345a(this.f3818Q);
            return;
        }
        if (t == InterfaceC1384o.f3346q) {
            AbstractC1414a<Float, Float> abstractC1414a3 = this.f3820S;
            if (abstractC1414a3 != null) {
                m3350b(abstractC1414a3);
            }
            if (c1370j == null) {
                this.f3820S = null;
                return;
            }
            this.f3820S = new C1429p(c1370j);
            this.f3820S.m3138a(this);
            m3345a(this.f3820S);
            return;
        }
        if (t == InterfaceC1384o.f3347r) {
            AbstractC1414a<Float, Float> abstractC1414a4 = this.f3822U;
            if (abstractC1414a4 != null) {
                m3350b(abstractC1414a4);
            }
            if (c1370j == null) {
                this.f3822U = null;
                return;
            }
            this.f3822U = new C1429p(c1370j);
            this.f3822U.m3138a(this);
            m3345a(this.f3822U);
            return;
        }
        if (t == InterfaceC1384o.f3325D) {
            AbstractC1414a<Float, Float> abstractC1414a5 = this.f3824W;
            if (abstractC1414a5 != null) {
                m3350b(abstractC1414a5);
            }
            if (c1370j == null) {
                this.f3824W = null;
                return;
            }
            this.f3824W = new C1429p(c1370j);
            this.f3824W.m3138a(this);
            m3345a(this.f3824W);
            return;
        }
        if (t == InterfaceC1384o.f3328G) {
            AbstractC1414a<Typeface, Typeface> abstractC1414a6 = this.f3825X;
            if (abstractC1414a6 != null) {
                m3350b(abstractC1414a6);
            }
            if (c1370j == null) {
                this.f3825X = null;
                return;
            }
            this.f3825X = new C1429p(c1370j);
            this.f3825X.m3138a(this);
            m3345a(this.f3825X);
        }
    }
}
