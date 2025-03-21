package p324i.p325a.p326a.p327a.p328k;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BaseNCodecOutputStream.java */
/* renamed from: i.a.a.a.k.i */
/* loaded from: classes2.dex */
public class C5774i extends FilterOutputStream {

    /* renamed from: a */
    private final boolean f20806a;

    /* renamed from: b */
    private final AbstractC5772g f20807b;

    /* renamed from: c */
    private final byte[] f20808c;

    public C5774i(OutputStream outputStream, AbstractC5772g abstractC5772g, boolean z) {
        super(outputStream);
        this.f20808c = new byte[1];
        this.f20807b = abstractC5772g;
        this.f20806a = z;
    }

    /* renamed from: a */
    private void m24189a(boolean z) throws IOException {
        byte[] bArr;
        int m24185c;
        int m24177a = this.f20807b.m24177a();
        if (m24177a > 0 && (m24185c = this.f20807b.m24185c((bArr = new byte[m24177a]), 0, m24177a)) > 0) {
            ((FilterOutputStream) this).out.write(bArr, 0, m24185c);
        }
        if (z) {
            ((FilterOutputStream) this).out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f20806a) {
            this.f20807b.mo24155b(this.f20808c, 0, -1);
        } else {
            this.f20807b.mo24153a(this.f20808c, 0, -1);
        }
        flush();
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        m24189a(true);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f20808c;
        bArr[0] = (byte) i2;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i2 >= 0 && i3 >= 0) {
            if (i2 > bArr.length || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 > 0) {
                if (this.f20806a) {
                    this.f20807b.mo24155b(bArr, i2, i3);
                } else {
                    this.f20807b.mo24153a(bArr, i2, i3);
                }
                m24189a(false);
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
