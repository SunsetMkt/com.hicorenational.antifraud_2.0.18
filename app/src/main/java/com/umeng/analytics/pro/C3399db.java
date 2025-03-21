package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TIOStreamTransport.java */
/* renamed from: com.umeng.analytics.pro.db */
/* loaded from: classes2.dex */
public class C3399db extends AbstractC3401dd {

    /* renamed from: a */
    protected InputStream f11961a;

    /* renamed from: b */
    protected OutputStream f11962b;

    protected C3399db() {
        this.f11961a = null;
        this.f11962b = null;
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: a */
    public int mo11189a(byte[] bArr, int i2, int i3) throws C3402de {
        InputStream inputStream = this.f11961a;
        if (inputStream == null) {
            throw new C3402de(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i2, i3);
            if (read >= 0) {
                return read;
            }
            throw new C3402de(4);
        } catch (IOException e2) {
            throw new C3402de(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: a */
    public boolean mo11190a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: b */
    public void mo11191b() throws C3402de {
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: b */
    public void mo11192b(byte[] bArr, int i2, int i3) throws C3402de {
        OutputStream outputStream = this.f11962b;
        if (outputStream == null) {
            throw new C3402de(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i2, i3);
        } catch (IOException e2) {
            throw new C3402de(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: c */
    public void mo11193c() {
        InputStream inputStream = this.f11961a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f11961a = null;
        }
        OutputStream outputStream = this.f11962b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.f11962b = null;
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: d */
    public void mo11194d() throws C3402de {
        OutputStream outputStream = this.f11962b;
        if (outputStream == null) {
            throw new C3402de(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e2) {
            throw new C3402de(0, e2);
        }
    }

    public C3399db(InputStream inputStream) {
        this.f11961a = null;
        this.f11962b = null;
        this.f11961a = inputStream;
    }

    public C3399db(OutputStream outputStream) {
        this.f11961a = null;
        this.f11962b = null;
        this.f11962b = outputStream;
    }

    public C3399db(InputStream inputStream, OutputStream outputStream) {
        this.f11961a = null;
        this.f11962b = null;
        this.f11961a = inputStream;
        this.f11962b = outputStream;
    }
}
