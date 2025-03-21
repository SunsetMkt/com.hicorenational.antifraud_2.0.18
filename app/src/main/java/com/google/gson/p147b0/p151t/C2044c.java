package com.google.gson.p147b0.p151t;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: SqlTimestampTypeAdapter.java */
/* renamed from: com.google.gson.b0.t.c */
/* loaded from: classes.dex */
class C2044c extends AbstractC2077y<Timestamp> {

    /* renamed from: b */
    static final InterfaceC2078z f5889b = new a();

    /* renamed from: a */
    private final AbstractC2077y<Date> f5890a;

    /* compiled from: SqlTimestampTypeAdapter.java */
    /* renamed from: com.google.gson.b0.t.c$a */
    class a implements InterfaceC2078z {
        a() {
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            a aVar = null;
            if (c2049a.getRawType() == Timestamp.class) {
                return new C2044c(c2051e.m5559a((Class) Date.class), aVar);
            }
            return null;
        }
    }

    /* synthetic */ C2044c(AbstractC2077y abstractC2077y, a aVar) {
        this(abstractC2077y);
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(C2055d c2055d, Timestamp timestamp) throws IOException {
        this.f5890a.write(c2055d, timestamp);
    }

    private C2044c(AbstractC2077y<Date> abstractC2077y) {
        this.f5890a = abstractC2077y;
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Timestamp read2(C2052a c2052a) throws IOException {
        Date read2 = this.f5890a.read2(c2052a);
        if (read2 != null) {
            return new Timestamp(read2.getTime());
        }
        return null;
    }
}
