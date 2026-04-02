package com.bumptech.glide.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import i.f1;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: GifHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f3407e = "GifHeaderParser";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f3408f = 255;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f3409g = 44;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f3410h = 33;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f3411i = 59;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f3412j = 249;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f3413k = 255;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f3414l = 254;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f3415m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f3416n = 28;
    private static final int o = 2;
    private static final int p = 1;
    private static final int q = 128;
    private static final int r = 64;
    private static final int s = 7;
    private static final int t = 128;
    private static final int u = 7;
    static final int v = 2;
    static final int w = 10;
    private static final int x = 256;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f3417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f3418c;
    private final byte[] a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3419d = 0;

    private boolean d() {
        return this.f3418c.f3395b != 0;
    }

    private int e() {
        try {
            return this.f3417b.get() & f1.f12066c;
        } catch (Exception unused) {
            this.f3418c.f3395b = 1;
            return 0;
        }
    }

    private void f() {
        this.f3418c.f3397d.a = m();
        this.f3418c.f3397d.f3384b = m();
        this.f3418c.f3397d.f3385c = m();
        this.f3418c.f3397d.f3386d = m();
        int iE = e();
        boolean z = (iE & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iE & 7) + 1);
        this.f3418c.f3397d.f3387e = (iE & 64) != 0;
        if (z) {
            this.f3418c.f3397d.f3393k = a(iPow);
        } else {
            this.f3418c.f3397d.f3393k = null;
        }
        this.f3418c.f3397d.f3392j = this.f3417b.position();
        p();
        if (d()) {
            return;
        }
        c cVar = this.f3418c;
        cVar.f3396c++;
        cVar.f3398e.add(cVar.f3397d);
    }

    private void g() {
        this.f3419d = e();
        if (this.f3419d > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f3419d) {
                try {
                    i3 = this.f3419d - i2;
                    this.f3417b.get(this.a, i2, i3);
                    i2 += i3;
                } catch (Exception unused) {
                    if (Log.isLoggable(f3407e, 3)) {
                        String str = "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f3419d;
                    }
                    this.f3418c.f3395b = 1;
                    return;
                }
            }
        }
    }

    private void h() {
        b(Integer.MAX_VALUE);
    }

    private void i() {
        e();
        int iE = e();
        b bVar = this.f3418c.f3397d;
        bVar.f3389g = (iE & 28) >> 2;
        if (bVar.f3389g == 0) {
            bVar.f3389g = 1;
        }
        this.f3418c.f3397d.f3388f = (iE & 1) != 0;
        int iM = m();
        if (iM < 2) {
            iM = 10;
        }
        b bVar2 = this.f3418c.f3397d;
        bVar2.f3391i = iM * 10;
        bVar2.f3390h = e();
        e();
    }

    private void j() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f3418c.f3395b = 1;
            return;
        }
        k();
        if (!this.f3418c.f3401h || d()) {
            return;
        }
        c cVar = this.f3418c;
        cVar.a = a(cVar.f3402i);
        c cVar2 = this.f3418c;
        cVar2.f3405l = cVar2.a[cVar2.f3403j];
    }

    private void k() {
        this.f3418c.f3399f = m();
        this.f3418c.f3400g = m();
        this.f3418c.f3401h = (e() & 128) != 0;
        this.f3418c.f3402i = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f3418c.f3403j = e();
        this.f3418c.f3404k = e();
    }

    private void l() {
        do {
            g();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.f3418c.f3406m = ((bArr[2] & f1.f12066c) << 8) | (bArr[1] & f1.f12066c);
            }
            if (this.f3419d <= 0) {
                return;
            }
        } while (!d());
    }

    private int m() {
        return this.f3417b.getShort();
    }

    private void n() {
        this.f3417b = null;
        Arrays.fill(this.a, (byte) 0);
        this.f3418c = new c();
        this.f3419d = 0;
    }

    private void o() {
        int iE;
        do {
            iE = e();
            this.f3417b.position(Math.min(this.f3417b.position() + iE, this.f3417b.limit()));
        } while (iE > 0);
    }

    private void p() {
        e();
        o();
    }

    public d a(@NonNull ByteBuffer byteBuffer) {
        n();
        this.f3417b = byteBuffer.asReadOnlyBuffer();
        this.f3417b.position(0);
        this.f3417b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public boolean b() {
        j();
        if (!d()) {
            b(2);
        }
        return this.f3418c.f3396c > 1;
    }

    @NonNull
    public c c() {
        if (this.f3417b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (d()) {
            return this.f3418c;
        }
        j();
        if (!d()) {
            h();
            c cVar = this.f3418c;
            if (cVar.f3396c < 0) {
                cVar.f3395b = 1;
            }
        }
        return this.f3418c;
    }

    private void b(int i2) {
        boolean z = false;
        while (!z && !d() && this.f3418c.f3396c <= i2) {
            int iE = e();
            if (iE == 33) {
                int iE2 = e();
                if (iE2 == 1) {
                    o();
                } else if (iE2 == f3412j) {
                    this.f3418c.f3397d = new b();
                    i();
                } else if (iE2 == 254) {
                    o();
                } else if (iE2 != 255) {
                    o();
                } else {
                    g();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        l();
                    } else {
                        o();
                    }
                }
            } else if (iE == 44) {
                c cVar = this.f3418c;
                if (cVar.f3397d == null) {
                    cVar.f3397d = new b();
                }
                f();
            } else if (iE != 59) {
                this.f3418c.f3395b = 1;
            } else {
                z = true;
            }
        }
    }

    public d a(@Nullable byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
        } else {
            this.f3417b = null;
            this.f3418c.f3395b = 2;
        }
        return this;
    }

    public void a() {
        this.f3417b = null;
        this.f3418c = null;
    }

    @Nullable
    private int[] a(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f3417b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = bArr[i4] & f1.f12066c;
                int i7 = i5 + 1;
                int i8 = bArr[i5] & f1.f12066c;
                int i9 = i7 + 1;
                int i10 = i3 + 1;
                iArr[i3] = (i6 << 16) | ViewCompat.MEASURED_STATE_MASK | (i8 << 8) | (bArr[i7] & f1.f12066c);
                i4 = i9;
                i3 = i10;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable(f3407e, 3);
            this.f3418c.f3395b = 1;
        }
        return iArr;
    }
}
