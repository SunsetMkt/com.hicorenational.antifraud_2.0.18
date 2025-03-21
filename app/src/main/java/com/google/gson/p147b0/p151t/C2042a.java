package com.google.gson.p147b0.p151t;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2072t;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter.java */
/* renamed from: com.google.gson.b0.t.a */
/* loaded from: classes.dex */
final class C2042a extends AbstractC2077y<Date> {

    /* renamed from: b */
    static final InterfaceC2078z f5885b = new a();

    /* renamed from: a */
    private final DateFormat f5886a;

    /* compiled from: SqlDateTypeAdapter.java */
    /* renamed from: com.google.gson.b0.t.a$a */
    class a implements InterfaceC2078z {
        a() {
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            a aVar = null;
            if (c2049a.getRawType() == Date.class) {
                return new C2042a(aVar);
            }
            return null;
        }
    }

    /* synthetic */ C2042a(a aVar) {
        this();
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(C2055d c2055d, Date date) throws IOException {
        String format;
        if (date == null) {
            c2055d.mo5448j();
            return;
        }
        synchronized (this) {
            format = this.f5886a.format((java.util.Date) date);
        }
        c2055d.mo5444d(format);
    }

    private C2042a() {
        this.f5886a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(C2052a c2052a) throws IOException {
        java.util.Date parse;
        if (c2052a.peek() == EnumC2054c.NULL) {
            c2052a.mo5429r();
            return null;
        }
        String mo5430s = c2052a.mo5430s();
        try {
            synchronized (this) {
                parse = this.f5886a.parse(mo5430s);
            }
            return new Date(parse.getTime());
        } catch (ParseException e2) {
            throw new C2072t("Failed parsing '" + mo5430s + "' as SQL Date; at path " + c2052a.mo5422i(), e2);
        }
    }
}
