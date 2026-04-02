package com.xiaomi.push;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ex extends er {
    public ex() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.er
    /* JADX INFO: renamed from: a */
    ByteBuffer mo389a(ByteBuffer byteBuffer) {
        return m392a().length == 0 ? byteBuffer : super.mo389a(byteBuffer);
    }

    @Override // com.xiaomi.push.er
    public int c() {
        if (m392a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
