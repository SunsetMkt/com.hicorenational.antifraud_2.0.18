package com.google.gson.b0.q;

import com.google.gson.t;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: DateTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends y<Date> {

    /* JADX INFO: renamed from: b */
    public static final z f3683b = new a();
    private final List<DateFormat> a = new ArrayList();

    /* JADX INFO: compiled from: DateTypeAdapter.java */
    class a implements z {
        a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        this.a.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.a.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.b0.f.c()) {
            this.a.add(com.google.gson.b0.l.a(2, 2));
        }
    }

    private Date a(com.google.gson.e0.a aVar) throws IOException {
        String strS = aVar.s();
        synchronized (this.a) {
            Iterator<DateFormat> it = this.a.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(strS);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.google.gson.b0.q.p.a.a(strS, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new t("Failed parsing '" + strS + "' as Date; at path " + aVar.i(), e2);
            }
        }
    }

    @Override // com.google.gson.y
    public Date read(com.google.gson.e0.a aVar) throws IOException {
        if (aVar.peek() != com.google.gson.e0.c.NULL) {
            return a(aVar);
        }
        aVar.r();
        return null;
    }

    @Override // com.google.gson.y
    /* JADX INFO: renamed from: a */
    public void write(com.google.gson.e0.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.j();
            return;
        }
        DateFormat dateFormat = this.a.get(0);
        synchronized (this.a) {
            str = dateFormat.format(date);
        }
        dVar.d(str);
    }
}
