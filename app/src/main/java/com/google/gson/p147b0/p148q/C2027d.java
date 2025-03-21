package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2072t;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.C2013f;
import com.google.gson.p147b0.C2019l;
import com.google.gson.p147b0.p148q.p149p.C2039a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* compiled from: DefaultDateTypeAdapter.java */
/* renamed from: com.google.gson.b0.q.d */
/* loaded from: classes.dex */
public final class C2027d<T extends Date> extends AbstractC2077y<T> {

    /* renamed from: c */
    private static final String f5727c = "DefaultDateTypeAdapter";

    /* renamed from: a */
    private final b<T> f5728a;

    /* renamed from: b */
    private final List<DateFormat> f5729b;

    /* compiled from: DefaultDateTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.d$b */
    public static abstract class b<T extends Date> {

        /* renamed from: b */
        public static final b<Date> f5730b = new a(Date.class);

        /* renamed from: a */
        private final Class<T> f5731a;

        /* compiled from: DefaultDateTypeAdapter.java */
        /* renamed from: com.google.gson.b0.q.d$b$a */
        class a extends b<Date> {
            a(Class cls) {
                super(cls);
            }

            @Override // com.google.gson.p147b0.p148q.C2027d.b
            /* renamed from: a */
            protected Date mo5408a(Date date) {
                return date;
            }
        }

        protected b(Class<T> cls) {
            this.f5731a = cls;
        }

        /* renamed from: a */
        private InterfaceC2078z m5403a(C2027d<T> c2027d) {
            return C2038o.m5484a(this.f5731a, c2027d);
        }

        /* renamed from: a */
        protected abstract T mo5408a(Date date);

        /* renamed from: a */
        public final InterfaceC2078z m5407a(String str) {
            return m5403a(new C2027d<>(this, str));
        }

        /* renamed from: a */
        public final InterfaceC2078z m5405a(int i2) {
            return m5403a(new C2027d<>(this, i2));
        }

        /* renamed from: a */
        public final InterfaceC2078z m5406a(int i2, int i3) {
            return m5403a(new C2027d<>(this, i2, i3));
        }

        /* renamed from: a */
        public final InterfaceC2078z m5404a() {
            int i2 = 2;
            return m5403a(new C2027d<>(this, i2, i2));
        }
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(C2055d c2055d, Date date) throws IOException {
        String format;
        if (date == null) {
            c2055d.mo5448j();
            return;
        }
        DateFormat dateFormat = this.f5729b.get(0);
        synchronized (this.f5729b) {
            format = dateFormat.format(date);
        }
        c2055d.mo5444d(format);
    }

    public String toString() {
        DateFormat dateFormat = this.f5729b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read */
    public T read2(C2052a c2052a) throws IOException {
        if (c2052a.peek() == EnumC2054c.NULL) {
            c2052a.mo5429r();
            return null;
        }
        return this.f5728a.mo5408a(m5401a(c2052a));
    }

    private C2027d(b<T> bVar, String str) {
        this.f5729b = new ArrayList();
        this.f5728a = (b) Objects.requireNonNull(bVar);
        this.f5729b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.f5729b.add(new SimpleDateFormat(str));
    }

    /* renamed from: a */
    private Date m5401a(C2052a c2052a) throws IOException {
        String mo5430s = c2052a.mo5430s();
        synchronized (this.f5729b) {
            Iterator<DateFormat> it = this.f5729b.iterator();
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

    private C2027d(b<T> bVar, int i2) {
        this.f5729b = new ArrayList();
        this.f5728a = (b) Objects.requireNonNull(bVar);
        this.f5729b.add(DateFormat.getDateInstance(i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f5729b.add(DateFormat.getDateInstance(i2));
        }
        if (C2013f.m5361c()) {
            this.f5729b.add(C2019l.m5377d(i2));
        }
    }

    private C2027d(b<T> bVar, int i2, int i3) {
        this.f5729b = new ArrayList();
        this.f5728a = (b) Objects.requireNonNull(bVar);
        this.f5729b.add(DateFormat.getDateTimeInstance(i2, i3, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f5729b.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (C2013f.m5361c()) {
            this.f5729b.add(C2019l.m5374a(i2, i3));
        }
    }
}
