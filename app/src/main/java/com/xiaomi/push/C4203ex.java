package com.xiaomi.push;

import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.ex */
/* loaded from: classes2.dex */
public final class C4203ex extends C4197er {
    public C4203ex() {
        m14692a("PING", (String) null);
        m14691a("0");
        m14688a(0);
    }

    @Override // com.xiaomi.push.C4197er
    /* renamed from: a */
    ByteBuffer mo14686a(ByteBuffer byteBuffer) {
        return m14696a().length == 0 ? byteBuffer : super.mo14686a(byteBuffer);
    }

    @Override // com.xiaomi.push.C4197er
    /* renamed from: c */
    public int mo14704c() {
        if (m14696a().length == 0) {
            return 0;
        }
        return super.mo14704c();
    }
}
