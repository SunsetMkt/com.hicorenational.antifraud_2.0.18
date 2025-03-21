package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2072t;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.C2013f;
import com.google.gson.p147b0.C2019l;
import com.google.gson.p147b0.p148q.p149p.C2039a;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: DateTypeAdapter.java */
/* renamed from: com.google.gson.b0.q.c */
/* loaded from: classes.dex */
public final class C2026c extends AbstractC2077y<Date> {

    /* renamed from: b */
    public static final InterfaceC2078z f5725b = new a();

    /* renamed from: a */
    private final List<DateFormat> f5726a = new ArrayList();

    /* compiled from: DateTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.c$a */
    class a implements InterfaceC2078z {
        a() {
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            if (c2049a.getRawType() == Date.class) {
                return new C2026c();
            }
            return null;
        }
    }

    public C2026c() {
        this.f5726a.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f5726a.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (C2013f.m5361c()) {
            this.f5726a.add(C2019l.m5374a(2, 2));
        }
    }

    /* renamed from: a */
    private Date m5399a(C2052a c2052a) throws IOException {
        String mo5430s = c2052a.mo5430s();
        synchronized (this.f5726a) {
            Iterator<DateFormat> it = this.f5726a.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(mo5430s);
                } catch (ParseException unused) {
                }
            }
            try {
                return C2039a.m5524a(mo5430s, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new C2072t("Failed parsing '" + mo5430s + "' as Date; at path " + c2052a.mo5422i(), e2);
            }
        }
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(C2052a c2052a) throws IOException {
        if (c2052a.peek() != EnumC2054c.NULL) {
            return m5399a(c2052a);
        }
        c2052a.mo5429r();
        return null;
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(C2055d c2055d, Date date) throws IOException {
        String format;
        if (date == null) {
            c2055d.mo5448j();
            return;
        }
        DateFormat dateFormat = this.f5726a.get(0);
        synchronized (this.f5726a) {
            format = dateFormat.format(date);
        }
        c2055d.mo5444d(format);
    }
}
