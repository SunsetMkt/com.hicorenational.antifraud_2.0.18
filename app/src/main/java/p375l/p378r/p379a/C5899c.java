package p375l.p378r.p379a;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2064l;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import okhttp3.ResponseBody;
import p375l.InterfaceC5876e;

/* compiled from: GsonResponseBodyConverter.java */
/* renamed from: l.r.a.c */
/* loaded from: classes2.dex */
final class C5899c<T> implements InterfaceC5876e<ResponseBody, T> {

    /* renamed from: a */
    private final C2051e f21363a;

    /* renamed from: b */
    private final AbstractC2077y<T> f21364b;

    C5899c(C2051e c2051e, AbstractC2077y<T> abstractC2077y) {
        this.f21363a = c2051e;
        this.f21364b = abstractC2077y;
    }

    @Override // p375l.InterfaceC5876e
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public T mo24746a(ResponseBody responseBody) throws IOException {
        C2052a m5555a = this.f21363a.m5555a(responseBody.charStream());
        try {
            T read2 = this.f21364b.read2(m5555a);
            if (m5555a.peek() == EnumC2054c.END_DOCUMENT) {
                return read2;
            }
            throw new C2064l("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
