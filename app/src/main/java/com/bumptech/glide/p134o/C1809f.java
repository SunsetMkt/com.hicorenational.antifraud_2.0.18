package com.bumptech.glide.p134o;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.p134o.InterfaceC1804a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import p286h.C5230f1;

/* compiled from: StandardGifDecoder.java */
/* renamed from: com.bumptech.glide.o.f */
/* loaded from: classes.dex */
public class C1809f implements InterfaceC1804a {

    /* renamed from: A */
    private static final String f5212A = "f";

    /* renamed from: B */
    private static final int f5213B = 4096;

    /* renamed from: C */
    private static final int f5214C = -1;

    /* renamed from: D */
    private static final int f5215D = -1;

    /* renamed from: E */
    private static final int f5216E = 4;

    /* renamed from: F */
    private static final int f5217F = 255;

    /* renamed from: G */
    @ColorInt
    private static final int f5218G = 0;

    /* renamed from: f */
    @ColorInt
    private int[] f5219f;

    /* renamed from: g */
    @ColorInt
    private final int[] f5220g;

    /* renamed from: h */
    private final InterfaceC1804a.a f5221h;

    /* renamed from: i */
    private ByteBuffer f5222i;

    /* renamed from: j */
    private byte[] f5223j;

    /* renamed from: k */
    private C1807d f5224k;

    /* renamed from: l */
    private short[] f5225l;

    /* renamed from: m */
    private byte[] f5226m;

    /* renamed from: n */
    private byte[] f5227n;

    /* renamed from: o */
    private byte[] f5228o;

    /* renamed from: p */
    @ColorInt
    private int[] f5229p;

    /* renamed from: q */
    private int f5230q;

    /* renamed from: r */
    private C1806c f5231r;

    /* renamed from: s */
    private Bitmap f5232s;

    /* renamed from: t */
    private boolean f5233t;

    /* renamed from: u */
    private int f5234u;

    /* renamed from: v */
    private int f5235v;

    /* renamed from: w */
    private int f5236w;

    /* renamed from: x */
    private int f5237x;

    /* renamed from: y */
    @Nullable
    private Boolean f5238y;

    /* renamed from: z */
    @NonNull
    private Bitmap.Config f5239z;

    public C1809f(@NonNull InterfaceC1804a.a aVar, C1806c c1806c, ByteBuffer byteBuffer) {
        this(aVar, c1806c, byteBuffer, 1);
    }

    @NonNull
    /* renamed from: m */
    private C1807d m4681m() {
        if (this.f5224k == null) {
            this.f5224k = new C1807d();
        }
        return this.f5224k;
    }

    /* renamed from: n */
    private Bitmap m4682n() {
        Boolean bool = this.f5238y;
        Bitmap mo4464a = this.f5221h.mo4464a(this.f5237x, this.f5236w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f5239z);
        mo4464a.setHasAlpha(true);
        return mo4464a;
    }

    /* renamed from: o */
    private int m4683o() {
        int m4684p = m4684p();
        if (m4684p <= 0) {
            return m4684p;
        }
        ByteBuffer byteBuffer = this.f5222i;
        byteBuffer.get(this.f5223j, 0, Math.min(m4684p, byteBuffer.remaining()));
        return m4684p;
    }

    /* renamed from: p */
    private int m4684p() {
        return this.f5222i.get() & C5230f1.f20085c;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: a */
    public int mo4634a(int i2) {
        if (i2 >= 0) {
            C1806c c1806c = this.f5231r;
            if (i2 < c1806c.f5177c) {
                return c1806c.f5179e.get(i2).f5170i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: b */
    public void mo4641b() {
        this.f5230q = (this.f5230q + 1) % this.f5231r.f5177c;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: c */
    public int mo4642c() {
        return this.f5231r.f5177c;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    public void clear() {
        this.f5231r = null;
        byte[] bArr = this.f5228o;
        if (bArr != null) {
            this.f5221h.mo4466a(bArr);
        }
        int[] iArr = this.f5229p;
        if (iArr != null) {
            this.f5221h.mo4467a(iArr);
        }
        Bitmap bitmap = this.f5232s;
        if (bitmap != null) {
            this.f5221h.mo4465a(bitmap);
        }
        this.f5232s = null;
        this.f5222i = null;
        this.f5238y = null;
        byte[] bArr2 = this.f5223j;
        if (bArr2 != null) {
            this.f5221h.mo4466a(bArr2);
        }
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: d */
    public int mo4643d() {
        int i2;
        if (this.f5231r.f5177c <= 0 || (i2 = this.f5230q) < 0) {
            return 0;
        }
        return mo4634a(i2);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    @NonNull
    /* renamed from: e */
    public ByteBuffer mo4644e() {
        return this.f5222i;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: f */
    public void mo4645f() {
        this.f5230q = -1;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: g */
    public int mo4646g() {
        return this.f5230q;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    public int getHeight() {
        return this.f5231r.f5181g;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    public int getWidth() {
        return this.f5231r.f5180f;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: h */
    public int mo4647h() {
        return this.f5231r.f5187m;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: i */
    public int mo4648i() {
        return this.f5234u;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: j */
    public int mo4649j() {
        return this.f5222i.limit() + this.f5228o.length + (this.f5229p.length * 4);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: k */
    public int mo4650k() {
        int i2 = this.f5231r.f5187m;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    @Deprecated
    /* renamed from: l */
    public int mo4651l() {
        int i2 = this.f5231r.f5187m;
        if (i2 == -1) {
            return 1;
        }
        return i2;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    public synchronized int read(@Nullable byte[] bArr) {
        this.f5231r = m4681m().m4672a(bArr).m4675c();
        if (bArr != null) {
            mo4640a(this.f5231r, bArr);
        }
        return this.f5234u;
    }

    public C1809f(@NonNull InterfaceC1804a.a aVar, C1806c c1806c, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        mo4639a(c1806c, byteBuffer, i2);
    }

    /* renamed from: b */
    private void m4679b(C1805b c1805b) {
        C1805b c1805b2 = c1805b;
        int[] iArr = this.f5229p;
        int i2 = c1805b2.f5165d;
        int i3 = c1805b2.f5163b;
        int i4 = c1805b2.f5164c;
        int i5 = c1805b2.f5162a;
        boolean z = this.f5230q == 0;
        int i6 = this.f5237x;
        byte[] bArr = this.f5228o;
        int[] iArr2 = this.f5219f;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = c1805b2.f5164c * i7;
            for (int i13 = i9; i13 < i10; i13++) {
                byte b3 = bArr[i12];
                int i14 = b3 & C5230f1.f20085c;
                if (i14 != b2) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
            }
            i7++;
            c1805b2 = c1805b;
        }
        Boolean bool = this.f5238y;
        this.f5238y = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f5238y == null && z && b2 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v17, types: [short] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* renamed from: c */
    private void m4680c(C1805b c1805b) {
        int i2;
        int i3;
        short s;
        C1809f c1809f = this;
        if (c1805b != null) {
            c1809f.f5222i.position(c1805b.f5171j);
        }
        if (c1805b == null) {
            C1806c c1806c = c1809f.f5231r;
            i2 = c1806c.f5180f;
            i3 = c1806c.f5181g;
        } else {
            i2 = c1805b.f5164c;
            i3 = c1805b.f5165d;
        }
        int i4 = i2 * i3;
        byte[] bArr = c1809f.f5228o;
        if (bArr == null || bArr.length < i4) {
            c1809f.f5228o = c1809f.f5221h.mo4469b(i4);
        }
        byte[] bArr2 = c1809f.f5228o;
        if (c1809f.f5225l == null) {
            c1809f.f5225l = new short[4096];
        }
        short[] sArr = c1809f.f5225l;
        if (c1809f.f5226m == null) {
            c1809f.f5226m = new byte[4096];
        }
        byte[] bArr3 = c1809f.f5226m;
        if (c1809f.f5227n == null) {
            c1809f.f5227n = new byte[4097];
        }
        byte[] bArr4 = c1809f.f5227n;
        int m4684p = m4684p();
        int i5 = 1 << m4684p;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = m4684p + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = c1809f.f5223j;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        int i21 = 0;
        int i22 = 0;
        while (true) {
            if (i10 >= i4) {
                break;
            }
            if (i15 == 0) {
                i15 = m4683o();
                if (i15 <= 0) {
                    c1809f.f5234u = 3;
                    break;
                }
                i18 = 0;
            }
            i17 += (bArr5[i18] & C5230f1.f20085c) << i16;
            i18++;
            i15--;
            int i23 = i16 + 8;
            int i24 = i20;
            int i25 = i21;
            int i26 = i13;
            int i27 = i19;
            int i28 = i10;
            int i29 = i12;
            while (true) {
                if (i23 < i29) {
                    i12 = i29;
                    i21 = i25;
                    i10 = i28;
                    i19 = i27;
                    i16 = i23;
                    i13 = i26;
                    i20 = i24;
                    c1809f = this;
                    break;
                }
                int i30 = i17 & i14;
                i17 >>= i29;
                i23 -= i29;
                if (i30 == i5) {
                    i29 = i8;
                    i26 = i7;
                    i14 = i9;
                    i24 = -1;
                } else {
                    if (i30 == i6) {
                        i16 = i23;
                        i12 = i29;
                        i10 = i28;
                        i19 = i27;
                        i13 = i26;
                        i21 = i25;
                        i20 = i24;
                        break;
                    }
                    if (i24 == -1) {
                        bArr2[i27] = bArr3[i30];
                        i27++;
                        i28++;
                        c1809f = this;
                        i24 = i30;
                        i25 = i24;
                    } else {
                        int i31 = i26;
                        if (i30 >= i31) {
                            bArr4[i22] = (byte) i25;
                            i22++;
                            s = i24;
                        } else {
                            s = i30;
                        }
                        while (s >= i5) {
                            bArr4[i22] = bArr3[s];
                            i22++;
                            s = sArr[s];
                        }
                        int i32 = bArr3[s] & C5230f1.f20085c;
                        int i33 = i8;
                        byte b2 = (byte) i32;
                        bArr2[i27] = b2;
                        while (true) {
                            i27++;
                            i28++;
                            if (i22 <= 0) {
                                break;
                            }
                            i22--;
                            bArr2[i27] = bArr4[i22];
                        }
                        if (i31 < 4096) {
                            sArr[i31] = (short) i24;
                            bArr3[i31] = b2;
                            i31++;
                            if ((i31 & i14) == 0 && i31 < 4096) {
                                i29++;
                                i14 += i31;
                            }
                        }
                        i24 = i30;
                        i23 = i23;
                        i8 = i33;
                        i25 = i32;
                        i26 = i31;
                        c1809f = this;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i19, i4, (byte) 0);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    @Nullable
    /* renamed from: a */
    public synchronized Bitmap mo4636a() {
        if (this.f5231r.f5177c <= 0 || this.f5230q < 0) {
            if (Log.isLoggable(f5212A, 3)) {
                String str = "Unable to decode frame, frameCount=" + this.f5231r.f5177c + ", framePointer=" + this.f5230q;
            }
            this.f5234u = 1;
        }
        if (this.f5234u != 1 && this.f5234u != 2) {
            this.f5234u = 0;
            if (this.f5223j == null) {
                this.f5223j = this.f5221h.mo4469b(255);
            }
            C1805b c1805b = this.f5231r.f5179e.get(this.f5230q);
            int i2 = this.f5230q - 1;
            C1805b c1805b2 = i2 >= 0 ? this.f5231r.f5179e.get(i2) : null;
            this.f5219f = c1805b.f5172k != null ? c1805b.f5172k : this.f5231r.f5175a;
            if (this.f5219f == null) {
                if (Log.isLoggable(f5212A, 3)) {
                    String str2 = "No valid color table found for frame #" + this.f5230q;
                }
                this.f5234u = 1;
                return null;
            }
            if (c1805b.f5167f) {
                System.arraycopy(this.f5219f, 0, this.f5220g, 0, this.f5219f.length);
                this.f5219f = this.f5220g;
                this.f5219f[c1805b.f5169h] = 0;
                if (c1805b.f5168g == 2 && this.f5230q == 0) {
                    this.f5238y = true;
                }
            }
            return m4677a(c1805b, c1805b2);
        }
        if (Log.isLoggable(f5212A, 3)) {
            String str3 = "Unable to decode frame, status=" + this.f5234u;
        }
        return null;
    }

    public C1809f(@NonNull InterfaceC1804a.a aVar) {
        this.f5220g = new int[256];
        this.f5239z = Bitmap.Config.ARGB_8888;
        this.f5221h = aVar;
        this.f5231r = new C1806c();
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: a */
    public int mo4635a(@Nullable InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.f5234u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.f5234u;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: a */
    public synchronized void mo4640a(@NonNull C1806c c1806c, @NonNull byte[] bArr) {
        mo4638a(c1806c, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: a */
    public synchronized void mo4638a(@NonNull C1806c c1806c, @NonNull ByteBuffer byteBuffer) {
        mo4639a(c1806c, byteBuffer, 1);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: a */
    public synchronized void mo4639a(@NonNull C1806c c1806c, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.f5234u = 0;
            this.f5231r = c1806c;
            this.f5230q = -1;
            this.f5222i = byteBuffer.asReadOnlyBuffer();
            this.f5222i.position(0);
            this.f5222i.order(ByteOrder.LITTLE_ENDIAN);
            this.f5233t = false;
            Iterator<C1805b> it = c1806c.f5179e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f5168g == 3) {
                    this.f5233t = true;
                    break;
                }
            }
            this.f5235v = highestOneBit;
            this.f5237x = c1806c.f5180f / highestOneBit;
            this.f5236w = c1806c.f5181g / highestOneBit;
            this.f5228o = this.f5221h.mo4469b(c1806c.f5180f * c1806c.f5181g);
            this.f5229p = this.f5221h.mo4468a(this.f5237x * this.f5236w);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a
    /* renamed from: a */
    public void mo4637a(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.f5239z = config;
    }

    /* renamed from: a */
    private Bitmap m4677a(C1805b c1805b, C1805b c1805b2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.f5229p;
        int i4 = 0;
        if (c1805b2 == null) {
            Bitmap bitmap2 = this.f5232s;
            if (bitmap2 != null) {
                this.f5221h.mo4465a(bitmap2);
            }
            this.f5232s = null;
            Arrays.fill(iArr, 0);
        }
        if (c1805b2 != null && c1805b2.f5168g == 3 && this.f5232s == null) {
            Arrays.fill(iArr, 0);
        }
        if (c1805b2 != null && (i3 = c1805b2.f5168g) > 0) {
            if (i3 == 2) {
                if (!c1805b.f5167f) {
                    C1806c c1806c = this.f5231r;
                    int i5 = c1806c.f5186l;
                    if (c1805b.f5172k == null || c1806c.f5184j != c1805b.f5169h) {
                        i4 = i5;
                    }
                }
                int i6 = c1805b2.f5165d;
                int i7 = this.f5235v;
                int i8 = i6 / i7;
                int i9 = c1805b2.f5163b / i7;
                int i10 = c1805b2.f5164c / i7;
                int i11 = c1805b2.f5162a / i7;
                int i12 = this.f5237x;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.f5237x;
                }
            } else if (i3 == 3 && (bitmap = this.f5232s) != null) {
                int i17 = this.f5237x;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.f5236w);
            }
        }
        m4680c(c1805b);
        if (!c1805b.f5166e && this.f5235v == 1) {
            m4679b(c1805b);
        } else {
            m4678a(c1805b);
        }
        if (this.f5233t && ((i2 = c1805b.f5168g) == 0 || i2 == 1)) {
            if (this.f5232s == null) {
                this.f5232s = m4682n();
            }
            Bitmap bitmap3 = this.f5232s;
            int i18 = this.f5237x;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.f5236w);
        }
        Bitmap m4682n = m4682n();
        int i19 = this.f5237x;
        m4682n.setPixels(iArr, 0, i19, 0, 0, i19, this.f5236w);
        return m4682n;
    }

    /* renamed from: a */
    private void m4678a(C1805b c1805b) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = this.f5229p;
        int i7 = c1805b.f5165d;
        int i8 = this.f5235v;
        int i9 = i7 / i8;
        int i10 = c1805b.f5163b / i8;
        int i11 = c1805b.f5164c / i8;
        int i12 = c1805b.f5162a / i8;
        Boolean bool = true;
        boolean z = this.f5230q == 0;
        int i13 = this.f5235v;
        int i14 = this.f5237x;
        int i15 = this.f5236w;
        byte[] bArr = this.f5228o;
        int[] iArr2 = this.f5219f;
        Boolean bool2 = this.f5238y;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        int i19 = 8;
        while (i16 < i9) {
            Boolean bool3 = bool;
            if (c1805b.f5166e) {
                if (i17 >= i9) {
                    i2 = i9;
                    i6 = i18 + 1;
                    if (i6 == 2) {
                        i17 = 4;
                    } else if (i6 == 3) {
                        i17 = 2;
                        i19 = 4;
                    } else if (i6 == 4) {
                        i17 = 1;
                        i19 = 2;
                    }
                } else {
                    i2 = i9;
                    i6 = i18;
                }
                i3 = i17 + i19;
                i18 = i6;
            } else {
                i2 = i9;
                i3 = i17;
                i17 = i16;
            }
            int i20 = i17 + i10;
            boolean z2 = i13 == 1;
            if (i20 < i15) {
                int i21 = i20 * i14;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i14;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i10;
                int i25 = i16 * i13 * c1805b.f5164c;
                if (z2) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i11;
                        int i28 = iArr2[bArr[i25] & C5230f1.f20085c];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z && bool2 == null) {
                            bool2 = bool3;
                        }
                        i25 += i13;
                        i26++;
                        i11 = i27;
                    }
                } else {
                    i5 = i11;
                    int i29 = ((i23 - i22) * i13) + i25;
                    int i30 = i22;
                    while (i30 < i23) {
                        int i31 = i23;
                        int m4676a = m4676a(i25, i29, c1805b.f5164c);
                        if (m4676a != 0) {
                            iArr[i30] = m4676a;
                        } else if (z && bool2 == null) {
                            bool2 = bool3;
                        }
                        i25 += i13;
                        i30++;
                        i23 = i31;
                    }
                    i16++;
                    i17 = i3;
                    i11 = i5;
                    bool = bool3;
                    i9 = i2;
                    i10 = i4;
                }
            } else {
                i4 = i10;
            }
            i5 = i11;
            i16++;
            i17 = i3;
            i11 = i5;
            bool = bool3;
            i9 = i2;
            i10 = i4;
        }
        if (this.f5238y == null) {
            this.f5238y = Boolean.valueOf(bool2 == null ? false : bool2.booleanValue());
        }
    }

    @ColorInt
    /* renamed from: a */
    private int m4676a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.f5235v + i2; i10++) {
            byte[] bArr = this.f5228o;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f5219f[bArr[i10] & C5230f1.f20085c];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.f5235v + i12; i13++) {
            byte[] bArr2 = this.f5228o;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f5219f[bArr2[i13] & C5230f1.f20085c];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }
}
