package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.xiaomi.push.ih */
/* loaded from: classes2.dex */
public class C4295ih extends AbstractC4298ik {

    /* renamed from: a */
    protected InputStream f16359a;

    /* renamed from: a */
    protected OutputStream f16360a;

    protected C4295ih() {
        this.f16359a = null;
        this.f16360a = null;
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a */
    public int mo15662a(byte[] bArr, int i2, int i3) {
        InputStream inputStream = this.f16359a;
        if (inputStream == null) {
            throw new C4299il(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i2, i3);
            if (read >= 0) {
                return read;
            }
            throw new C4299il(4);
        } catch (IOException e2) {
            throw new C4299il(0, e2);
        }
    }

    public C4295ih(OutputStream outputStream) {
        this.f16359a = null;
        this.f16360a = null;
        this.f16360a = outputStream;
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a */
    public void mo15663a(byte[] bArr, int i2, int i3) {
        OutputStream outputStream = this.f16360a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i2, i3);
                return;
            } catch (IOException e2) {
                throw new C4299il(0, e2);
            }
        }
        throw new C4299il(1, "Cannot write to null outputStream");
    }
}
