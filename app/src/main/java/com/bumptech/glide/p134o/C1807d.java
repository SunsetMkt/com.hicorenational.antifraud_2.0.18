package com.bumptech.glide.p134o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import p286h.C5230f1;

/* compiled from: GifHeaderParser.java */
/* renamed from: com.bumptech.glide.o.d */
/* loaded from: classes.dex */
public class C1807d {

    /* renamed from: e */
    private static final String f5188e = "GifHeaderParser";

    /* renamed from: f */
    private static final int f5189f = 255;

    /* renamed from: g */
    private static final int f5190g = 44;

    /* renamed from: h */
    private static final int f5191h = 33;

    /* renamed from: i */
    private static final int f5192i = 59;

    /* renamed from: j */
    private static final int f5193j = 249;

    /* renamed from: k */
    private static final int f5194k = 255;

    /* renamed from: l */
    private static final int f5195l = 254;

    /* renamed from: m */
    private static final int f5196m = 1;

    /* renamed from: n */
    private static final int f5197n = 28;

    /* renamed from: o */
    private static final int f5198o = 2;

    /* renamed from: p */
    private static final int f5199p = 1;

    /* renamed from: q */
    private static final int f5200q = 128;

    /* renamed from: r */
    private static final int f5201r = 64;

    /* renamed from: s */
    private static final int f5202s = 7;

    /* renamed from: t */
    private static final int f5203t = 128;

    /* renamed from: u */
    private static final int f5204u = 7;

    /* renamed from: v */
    static final int f5205v = 2;

    /* renamed from: w */
    static final int f5206w = 10;

    /* renamed from: x */
    private static final int f5207x = 256;

    /* renamed from: b */
    private ByteBuffer f5209b;

    /* renamed from: c */
    private C1806c f5210c;

    /* renamed from: a */
    private final byte[] f5208a = new byte[256];

    /* renamed from: d */
    private int f5211d = 0;

    /* renamed from: d */
    private boolean m4658d() {
        return this.f5210c.f5176b != 0;
    }

    /* renamed from: e */
    private int m4659e() {
        try {
            return this.f5209b.get() & C5230f1.f20085c;
        } catch (Exception unused) {
            this.f5210c.f5176b = 1;
            return 0;
        }
    }

    /* renamed from: f */
    private void m4660f() {
        this.f5210c.f5178d.f5162a = m4667m();
        this.f5210c.f5178d.f5163b = m4667m();
        this.f5210c.f5178d.f5164c = m4667m();
        this.f5210c.f5178d.f5165d = m4667m();
        int m4659e = m4659e();
        boolean z = (m4659e & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m4659e & 7) + 1);
        this.f5210c.f5178d.f5166e = (m4659e & 64) != 0;
        if (z) {
            this.f5210c.f5178d.f5172k = m4656a(pow);
        } else {
            this.f5210c.f5178d.f5172k = null;
        }
        this.f5210c.f5178d.f5171j = this.f5209b.position();
        m4670p();
        if (m4658d()) {
            return;
        }
        C1806c c1806c = this.f5210c;
        c1806c.f5177c++;
        c1806c.f5179e.add(c1806c.f5178d);
    }

    /* renamed from: g */
    private void m4661g() {
        this.f5211d = m4659e();
        if (this.f5211d > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f5211d) {
                try {
                    i3 = this.f5211d - i2;
                    this.f5209b.get(this.f5208a, i2, i3);
                    i2 += i3;
                } catch (Exception unused) {
                    if (Log.isLoggable(f5188e, 3)) {
                        String str = "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f5211d;
                    }
                    this.f5210c.f5176b = 1;
                    return;
                }
            }
        }
    }

    /* renamed from: h */
    private void m4662h() {
        m4657b(Integer.MAX_VALUE);
    }

    /* renamed from: i */
    private void m4663i() {
        m4659e();
        int m4659e = m4659e();
        C1805b c1805b = this.f5210c.f5178d;
        c1805b.f5168g = (m4659e & 28) >> 2;
        if (c1805b.f5168g == 0) {
            c1805b.f5168g = 1;
        }
        this.f5210c.f5178d.f5167f = (m4659e & 1) != 0;
        int m4667m = m4667m();
        if (m4667m < 2) {
            m4667m = 10;
        }
        C1805b c1805b2 = this.f5210c.f5178d;
        c1805b2.f5170i = m4667m * 10;
        c1805b2.f5169h = m4659e();
        m4659e();
    }

    /* renamed from: j */
    private void m4664j() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) m4659e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f5210c.f5176b = 1;
            return;
        }
        m4665k();
        if (!this.f5210c.f5182h || m4658d()) {
            return;
        }
        C1806c c1806c = this.f5210c;
        c1806c.f5175a = m4656a(c1806c.f5183i);
        C1806c c1806c2 = this.f5210c;
        c1806c2.f5186l = c1806c2.f5175a[c1806c2.f5184j];
    }

    /* renamed from: k */
    private void m4665k() {
        this.f5210c.f5180f = m4667m();
        this.f5210c.f5181g = m4667m();
        this.f5210c.f5182h = (m4659e() & 128) != 0;
        this.f5210c.f5183i = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f5210c.f5184j = m4659e();
        this.f5210c.f5185k = m4659e();
    }

    /* renamed from: l */
    private void m4666l() {
        do {
            m4661g();
            byte[] bArr = this.f5208a;
            if (bArr[0] == 1) {
                this.f5210c.f5187m = ((bArr[2] & C5230f1.f20085c) << 8) | (bArr[1] & C5230f1.f20085c);
            }
            if (this.f5211d <= 0) {
                return;
            }
        } while (!m4658d());
    }

    /* renamed from: m */
    private int m4667m() {
        return this.f5209b.getShort();
    }

    /* renamed from: n */
    private void m4668n() {
        this.f5209b = null;
        Arrays.fill(this.f5208a, (byte) 0);
        this.f5210c = new C1806c();
        this.f5211d = 0;
    }

    /* renamed from: o */
    private void m4669o() {
        int m4659e;
        do {
            m4659e = m4659e();
            this.f5209b.position(Math.min(this.f5209b.position() + m4659e, this.f5209b.limit()));
        } while (m4659e > 0);
    }

    /* renamed from: p */
    private void m4670p() {
        m4659e();
        m4669o();
    }

    /* renamed from: a */
    public C1807d m4671a(@NonNull ByteBuffer byteBuffer) {
        m4668n();
        this.f5209b = byteBuffer.asReadOnlyBuffer();
        this.f5209b.position(0);
        this.f5209b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    /* renamed from: b */
    public boolean m4674b() {
        m4664j();
        if (!m4658d()) {
            m4657b(2);
        }
        return this.f5210c.f5177c > 1;
    }

    @NonNull
    /* renamed from: c */
    public C1806c m4675c() {
        if (this.f5209b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (m4658d()) {
            return this.f5210c;
        }
        m4664j();
        if (!m4658d()) {
            m4662h();
            C1806c c1806c = this.f5210c;
            if (c1806c.f5177c < 0) {
                c1806c.f5176b = 1;
            }
        }
        return this.f5210c;
    }

    /* renamed from: b */
    private void m4657b(int i2) {
        boolean z = false;
        while (!z && !m4658d() && this.f5210c.f5177c <= i2) {
            int m4659e = m4659e();
            if (m4659e == 33) {
                int m4659e2 = m4659e();
                if (m4659e2 == 1) {
                    m4669o();
                } else if (m4659e2 == f5193j) {
                    this.f5210c.f5178d = new C1805b();
                    m4663i();
                } else if (m4659e2 == 254) {
                    m4669o();
                } else if (m4659e2 != 255) {
                    m4669o();
                } else {
                    m4661g();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.f5208a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m4666l();
                    } else {
                        m4669o();
                    }
                }
            } else if (m4659e == 44) {
                C1806c c1806c = this.f5210c;
                if (c1806c.f5178d == null) {
                    c1806c.f5178d = new C1805b();
                }
                m4660f();
            } else if (m4659e != 59) {
                this.f5210c.f5176b = 1;
            } else {
                z = true;
            }
        }
    }

    /* renamed from: a */
    public C1807d m4672a(@Nullable byte[] bArr) {
        if (bArr != null) {
            m4671a(ByteBuffer.wrap(bArr));
        } else {
            this.f5209b = null;
            this.f5210c.f5176b = 2;
        }
        return this;
    }

    /* renamed from: a */
    public void m4673a() {
        this.f5209b = null;
        this.f5210c = null;
    }

    @Nullable
    /* renamed from: a */
    private int[] m4656a(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f5209b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = bArr[i4] & C5230f1.f20085c;
                int i7 = i5 + 1;
                int i8 = bArr[i5] & C5230f1.f20085c;
                int i9 = i7 + 1;
                int i10 = i3 + 1;
                iArr[i3] = (i6 << 16) | ViewCompat.MEASURED_STATE_MASK | (i8 << 8) | (bArr[i7] & C5230f1.f20085c);
                i4 = i9;
                i3 = i10;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable(f5188e, 3);
            this.f5210c.f5176b = 1;
        }
        return iArr;
    }
}
