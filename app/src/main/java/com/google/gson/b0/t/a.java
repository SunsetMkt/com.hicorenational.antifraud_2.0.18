package com.google.gson.b0.t;

import com.google.gson.e;
import com.google.gson.t;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: SqlDateTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
final class a extends y<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final z f3764b = new C0077a();
    private final DateFormat a;

    /* JADX INFO: renamed from: com.google.gson.b0.t.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SqlDateTypeAdapter.java */
    class C0077a implements z {
        C0077a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(e eVar, com.google.gson.d0.a<T> aVar) {
            C0077a c0077a = null;
            if (aVar.getRawType() == Date.class) {
                return new a(c0077a);
            }
            return null;
        }
    }

    /* synthetic */ a(C0077a c0077a) {
        this();
    }

    @Override // com.google.gson.y
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.google.gson.e0.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.j();
            return;
        }
        synchronized (this) {
            str = this.a.format((java.util.Date) date);
        }
        dVar.d(str);
    }

    private a() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.y
    public Date read(com.google.gson.e0.a aVar) throws IOException {
        java.util.Date date;
        if (aVar.peek() == com.google.gson.e0.c.NULL) {
            aVar.r();
            return null;
        }
        String strS = aVar.s();
        try {
            synchronized (this) {
                date = this.a.parse(strS);
            }
            return new Date(date.getTime());
        } catch (ParseException e2) {
            throw new t("Failed parsing '" + strS + "' as SQL Date; at path " + aVar.i(), e2);
        }
    }
}
