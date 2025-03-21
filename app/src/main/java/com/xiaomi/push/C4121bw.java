package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.service.C4356ah;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.bw */
/* loaded from: classes2.dex */
public class C4121bw {

    /* renamed from: a */
    private static volatile C4121bw f14662a;

    /* renamed from: a */
    private Context f14663a;

    /* renamed from: a */
    private AbstractC4120bv f14664a;

    /* renamed from: a */
    private final HashMap<String, AbstractC4119bu> f14666a = new HashMap<>();

    /* renamed from: a */
    private ThreadPoolExecutor f14667a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    private final ArrayList<a> f14665a = new ArrayList<>();

    /* renamed from: com.xiaomi.push.bw$d */
    public static class d extends a {

        /* renamed from: a */
        private String f14687a;

        /* renamed from: a */
        protected String[] f14688a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f14687a = str2;
            this.f14688a = strArr;
        }

        @Override // com.xiaomi.push.C4121bw.a
        /* renamed from: a */
        public void mo13968a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f14675b, this.f14687a, this.f14688a);
        }
    }

    /* renamed from: com.xiaomi.push.bw$e */
    public static class e extends a {

        /* renamed from: a */
        private ContentValues f14689a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f14689a = contentValues;
        }

        @Override // com.xiaomi.push.C4121bw.a
        /* renamed from: a */
        public void mo13968a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f14675b, null, this.f14689a);
        }
    }

    private C4121bw(Context context) {
        this.f14663a = context;
    }

    /* renamed from: b */
    public void m13964b(a aVar) {
        AbstractC4119bu abstractC4119bu;
        if (aVar == null) {
            return;
        }
        if (this.f14664a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m13966a = aVar.m13966a();
        synchronized (this.f14666a) {
            abstractC4119bu = this.f14666a.get(m13966a);
            if (abstractC4119bu == null) {
                abstractC4119bu = this.f14664a.m13955a(this.f14663a, m13966a);
                this.f14666a.put(m13966a, abstractC4119bu);
            }
        }
        if (this.f14667a.isShutdown()) {
            return;
        }
        aVar.m13969a(abstractC4119bu, this.f14663a);
        m13962a((Runnable) aVar);
    }

    /* renamed from: com.xiaomi.push.bw$c */
    public static class c extends a {

        /* renamed from: a */
        private ArrayList<a> f14686a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.f14686a = new ArrayList<>();
            this.f14686a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.C4121bw.a
        /* renamed from: a */
        public void mo13968a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f14686a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.mo13968a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.C4121bw.a
        /* renamed from: a */
        public final void mo13967a(Context context) {
            super.mo13967a(context);
            Iterator<a> it = this.f14686a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.mo13967a(context);
                }
            }
        }
    }

    /* renamed from: a */
    public static C4121bw m13957a(Context context) {
        if (f14662a == null) {
            synchronized (C4121bw.class) {
                if (f14662a == null) {
                    f14662a = new C4121bw(context);
                }
            }
        }
        return f14662a;
    }

    /* renamed from: com.xiaomi.push.bw$a */
    public static abstract class a implements Runnable {

        /* renamed from: a */
        private a f14671a;

        /* renamed from: a */
        private String f14672a;

        /* renamed from: a */
        private WeakReference<Context> f14673a;

        /* renamed from: b */
        protected String f14675b;

        /* renamed from: a */
        protected AbstractC4119bu f14670a = null;

        /* renamed from: a */
        private Random f14674a = new Random();

        /* renamed from: a */
        private int f14669a = 0;

        public a(String str) {
            this.f14672a = str;
        }

        /* renamed from: a */
        public Object mo13950a() {
            return null;
        }

        /* renamed from: a */
        public abstract void mo13968a(Context context, SQLiteDatabase sQLiteDatabase);

        /* renamed from: a */
        void m13969a(AbstractC4119bu abstractC4119bu, Context context) {
            this.f14670a = abstractC4119bu;
            this.f14675b = this.f14670a.m13954a();
            this.f14673a = new WeakReference<>(context);
        }

        /* renamed from: b */
        public void m13972b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            final Context context;
            WeakReference<Context> weakReference = this.f14673a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f14670a == null || TextUtils.isEmpty(this.f14672a)) {
                return;
            }
            File file = new File(this.f14672a);
            AbstractRunnableC4406u.m16351a(context, new File(file.getParentFile(), C4099ba.m13877b(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bw.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SQLiteDatabase sQLiteDatabase = null;
                    try {
                        try {
                            sQLiteDatabase = a.this.mo13965a();
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.beginTransaction();
                                a.this.mo13968a(context, sQLiteDatabase);
                                sQLiteDatabase.setTransactionSuccessful();
                            }
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e2) {
                                    e = e2;
                                    AbstractC4022b.m13351a(e);
                                    a.this.mo13967a(context);
                                }
                            }
                            if (a.this.f14670a != null) {
                                a.this.f14670a.close();
                            }
                        } catch (Exception e3) {
                            AbstractC4022b.m13351a(e3);
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e4) {
                                    e = e4;
                                    AbstractC4022b.m13351a(e);
                                    a.this.mo13967a(context);
                                }
                            }
                            if (a.this.f14670a != null) {
                                a.this.f14670a.close();
                            }
                        }
                        a.this.mo13967a(context);
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Exception e5) {
                                AbstractC4022b.m13351a(e5);
                                a.this.mo13967a(context);
                                throw th;
                            }
                        }
                        if (a.this.f14670a != null) {
                            a.this.f14670a.close();
                        }
                        a.this.mo13967a(context);
                        throw th;
                    }
                }
            });
        }

        /* renamed from: a */
        public boolean m13971a() {
            return this.f14670a == null || TextUtils.isEmpty(this.f14675b) || this.f14673a == null;
        }

        /* renamed from: a */
        public void m13970a(a aVar) {
            this.f14671a = aVar;
        }

        /* renamed from: a */
        public void mo13947a(Context context, Object obj) {
            C4121bw.m13957a(context).m13961a(this);
        }

        /* renamed from: a */
        public String m13966a() {
            return this.f14672a;
        }

        /* renamed from: a */
        public SQLiteDatabase mo13965a() {
            return this.f14670a.getWritableDatabase();
        }

        /* renamed from: a */
        void mo13967a(Context context) {
            a aVar = this.f14671a;
            if (aVar != null) {
                aVar.mo13947a(context, mo13950a());
            }
            m13972b(context);
        }
    }

    /* renamed from: a */
    private void m13959a() {
        C4076ae.m13698a(this.f14663a).m13710b(new C4076ae.a() { // from class: com.xiaomi.push.bw.1
            @Override // com.xiaomi.push.C4076ae.a
            /* renamed from: a */
            public String mo13391a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (C4121bw.this.f14665a) {
                    if (C4121bw.this.f14665a.size() > 0) {
                        if (C4121bw.this.f14665a.size() > 1) {
                            C4121bw.this.m13963a(C4121bw.this.f14665a);
                        } else {
                            C4121bw.this.m13964b((a) C4121bw.this.f14665a.get(0));
                        }
                        C4121bw.this.f14665a.clear();
                        System.gc();
                    }
                }
            }
        }, C4356ah.m15923a(this.f14663a).m15927a(EnumC4244gk.StatDataProcessFrequency.m15014a(), 5));
    }

    /* renamed from: com.xiaomi.push.bw$b */
    public static abstract class b<T> extends a {

        /* renamed from: a */
        private int f14678a;

        /* renamed from: a */
        private String f14679a;

        /* renamed from: a */
        private List<String> f14680a;

        /* renamed from: a */
        private String[] f14681a;

        /* renamed from: b */
        private List<T> f14682b;

        /* renamed from: c */
        private String f14683c;

        /* renamed from: d */
        private String f14684d;

        /* renamed from: e */
        private String f14685e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            this.f14682b = new ArrayList();
            this.f14680a = list;
            this.f14679a = str2;
            this.f14681a = strArr;
            this.f14683c = str3;
            this.f14684d = str4;
            this.f14685e = str5;
            this.f14678a = i2;
        }

        /* renamed from: a */
        public abstract T mo13949a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.C4121bw.a
        /* renamed from: a */
        public void mo13968a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f14682b.clear();
            List<String> list = this.f14680a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f14680a.size()];
                this.f14680a.toArray(strArr2);
                strArr = strArr2;
            }
            int i2 = this.f14678a;
            Cursor query = sQLiteDatabase.query(super.f14675b, strArr, this.f14679a, this.f14681a, this.f14683c, this.f14684d, this.f14685e, i2 > 0 ? String.valueOf(i2) : null);
            if (query != null && query.moveToFirst()) {
                do {
                    T mo13949a = mo13949a(context, query);
                    if (mo13949a != null) {
                        this.f14682b.add(mo13949a);
                    }
                } while (query.moveToNext());
                query.close();
            }
            mo13951a(context, (List) this.f14682b);
        }

        /* renamed from: a */
        public abstract void mo13951a(Context context, List<T> list);

        @Override // com.xiaomi.push.C4121bw.a
        /* renamed from: a */
        public SQLiteDatabase mo13965a() {
            return ((a) this).f14670a.getReadableDatabase();
        }
    }

    /* renamed from: a */
    public void m13961a(a aVar) {
        AbstractC4119bu abstractC4119bu;
        if (aVar == null) {
            return;
        }
        if (this.f14664a != null) {
            String m13966a = aVar.m13966a();
            synchronized (this.f14666a) {
                abstractC4119bu = this.f14666a.get(m13966a);
                if (abstractC4119bu == null) {
                    abstractC4119bu = this.f14664a.m13955a(this.f14663a, m13966a);
                    this.f14666a.put(m13966a, abstractC4119bu);
                }
            }
            if (this.f14667a.isShutdown()) {
                return;
            }
            aVar.m13969a(abstractC4119bu, this.f14663a);
            synchronized (this.f14665a) {
                this.f14665a.add(aVar);
                m13959a();
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    /* renamed from: a */
    public void m13962a(Runnable runnable) {
        if (this.f14667a.isShutdown()) {
            return;
        }
        this.f14667a.execute(runnable);
    }

    /* renamed from: a */
    public String m13960a(String str) {
        return m13956a(str).m13954a();
    }

    /* renamed from: a */
    public void m13963a(ArrayList<a> arrayList) {
        if (this.f14664a != null) {
            HashMap hashMap = new HashMap();
            if (this.f14667a.isShutdown()) {
                return;
            }
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.m13971a()) {
                    next.m13969a(m13956a(next.m13966a()), this.f14663a);
                }
                ArrayList arrayList2 = (ArrayList) hashMap.get(next.m13966a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(next.m13966a(), arrayList2);
                }
                arrayList2.add(next);
            }
            for (String str : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.m13969a(((a) arrayList3.get(0)).f14670a, this.f14663a);
                    this.f14667a.execute(cVar);
                }
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    /* renamed from: a */
    private AbstractC4119bu m13956a(String str) {
        AbstractC4119bu abstractC4119bu = this.f14666a.get(str);
        if (abstractC4119bu == null) {
            synchronized (this.f14666a) {
                if (abstractC4119bu == null) {
                    abstractC4119bu = this.f14664a.m13955a(this.f14663a, str);
                    this.f14666a.put(str, abstractC4119bu);
                }
            }
        }
        return abstractC4119bu;
    }
}
