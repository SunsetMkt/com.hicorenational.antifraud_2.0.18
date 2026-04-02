package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class bw {
    private static volatile bw a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private bv f229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final HashMap<String, bu> f231a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f232a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f230a = new ArrayList<>();

    public static class d extends a {
        private String a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected String[] f242a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f242a = strArr;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f8785b, this.a, this.f242a);
        }
    }

    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f8785b, null, this.a);
        }
    }

    private bw(Context context) {
        this.f228a = context;
    }

    public void b(a aVar) {
        bu buVarA;
        if (aVar == null) {
            return;
        }
        if (this.f229a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String strM192a = aVar.m192a();
        synchronized (this.f231a) {
            buVarA = this.f231a.get(strM192a);
            if (buVarA == null) {
                buVarA = this.f229a.a(this.f228a, strM192a);
                this.f231a.put(strM192a, buVarA);
            }
        }
        if (this.f232a.isShutdown()) {
            return;
        }
        aVar.a(buVarA, this.f228a);
        a((Runnable) aVar);
    }

    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.a = new ArrayList<>();
            this.a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            for (a aVar : this.a) {
                if (aVar != null) {
                    aVar.a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.bw.a
        public final void a(Context context) {
            super.a(context);
            for (a aVar : this.a) {
                if (aVar != null) {
                    aVar.a(context);
                }
            }
        }
    }

    public static bw a(Context context) {
        if (a == null) {
            synchronized (bw.class) {
                if (a == null) {
                    a = new bw(context);
                }
            }
        }
        return a;
    }

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f234a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f235a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f8785b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected bu f233a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Random f237a = new Random();
        private int a = 0;

        public a(String str) {
            this.f235a = str;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public Object mo191a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        void a(bu buVar, Context context) {
            this.f233a = buVar;
            this.f8785b = this.f233a.a();
            this.f236a = new WeakReference<>(context);
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            final Context context;
            WeakReference<Context> weakReference = this.f236a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f233a == null || TextUtils.isEmpty(this.f235a)) {
                return;
            }
            File file = new File(this.f235a);
            u.a(context, new File(file.getParentFile(), ba.b(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bw.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SQLiteDatabase sQLiteDatabaseA = null;
                    try {
                        try {
                            sQLiteDatabaseA = a.this.a();
                            if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                                sQLiteDatabaseA.beginTransaction();
                                a.this.a(context, sQLiteDatabaseA);
                                sQLiteDatabaseA.setTransactionSuccessful();
                            }
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception e2) {
                                    e = e2;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                }
                            }
                            if (a.this.f233a != null) {
                                a.this.f233a.close();
                            }
                        } catch (Exception e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception e4) {
                                    e = e4;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                }
                            }
                            if (a.this.f233a != null) {
                                a.this.f233a.close();
                            }
                        }
                        a.this.a(context);
                    } catch (Throwable th) {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Exception e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                                a.this.a(context);
                                throw th;
                            }
                        }
                        if (a.this.f233a != null) {
                            a.this.f233a.close();
                        }
                        a.this.a(context);
                        throw th;
                    }
                }
            });
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m193a() {
            return this.f233a == null || TextUtils.isEmpty(this.f8785b) || this.f236a == null;
        }

        public void a(a aVar) {
            this.f234a = aVar;
        }

        public void a(Context context, Object obj) {
            bw.a(context).a(this);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m192a() {
            return this.f235a;
        }

        public SQLiteDatabase a() {
            return this.f233a.getWritableDatabase();
        }

        void a(Context context) {
            a aVar = this.f234a;
            if (aVar != null) {
                aVar.a(context, mo191a());
            }
            b(context);
        }
    }

    private void a() {
        ae.a(this.f228a).b(new ae.a() { // from class: com.xiaomi.push.bw.1
            @Override // com.xiaomi.push.ae.a
            /* JADX INFO: renamed from: a */
            public String mo181a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (bw.this.f230a) {
                    if (bw.this.f230a.size() > 0) {
                        if (bw.this.f230a.size() > 1) {
                            bw.this.a(bw.this.f230a);
                        } else {
                            bw.this.b((a) bw.this.f230a.get(0));
                        }
                        bw.this.f230a.clear();
                        System.gc();
                    }
                }
            }
        }, com.xiaomi.push.service.ah.a(this.f228a).a(gk.StatDataProcessFrequency.a(), 5));
    }

    public static abstract class b<T> extends a {
        private int a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f239a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f240a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String[] f241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<T> f8786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f8787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f8788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f8789e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            this.f8786b = new ArrayList();
            this.f240a = list;
            this.f239a = str2;
            this.f241a = strArr;
            this.f8787c = str3;
            this.f8788d = str4;
            this.f8789e = str5;
            this.a = i2;
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f8786b.clear();
            List<String> list = this.f240a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f240a.size()];
                this.f240a.toArray(strArr2);
                strArr = strArr2;
            }
            int i2 = this.a;
            Cursor cursorQuery = sQLiteDatabase.query(super.f8785b, strArr, this.f239a, this.f241a, this.f8787c, this.f8788d, this.f8789e, i2 > 0 ? String.valueOf(i2) : null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    T tA = a(context, cursorQuery);
                    if (tA != null) {
                        this.f8786b.add(tA);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            }
            a(context, (List) this.f8786b);
        }

        public abstract void a(Context context, List<T> list);

        @Override // com.xiaomi.push.bw.a
        public SQLiteDatabase a() {
            return ((a) this).f233a.getReadableDatabase();
        }
    }

    public void a(a aVar) {
        bu buVarA;
        if (aVar == null) {
            return;
        }
        if (this.f229a != null) {
            String strM192a = aVar.m192a();
            synchronized (this.f231a) {
                buVarA = this.f231a.get(strM192a);
                if (buVarA == null) {
                    buVarA = this.f229a.a(this.f228a, strM192a);
                    this.f231a.put(strM192a, buVarA);
                }
            }
            if (this.f232a.isShutdown()) {
                return;
            }
            aVar.a(buVarA, this.f228a);
            synchronized (this.f230a) {
                this.f230a.add(aVar);
                a();
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(Runnable runnable) {
        if (this.f232a.isShutdown()) {
            return;
        }
        this.f232a.execute(runnable);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m190a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f229a != null) {
            HashMap map = new HashMap();
            if (this.f232a.isShutdown()) {
                return;
            }
            for (a aVar : arrayList) {
                if (aVar.m193a()) {
                    aVar.a(a(aVar.m192a()), this.f228a);
                }
                ArrayList arrayList2 = (ArrayList) map.get(aVar.m192a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(aVar.m192a(), arrayList2);
                }
                arrayList2.add(aVar);
            }
            for (String str : map.keySet()) {
                ArrayList arrayList3 = (ArrayList) map.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f233a, this.f228a);
                    this.f232a.execute(cVar);
                }
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    private bu a(String str) {
        bu buVarA = this.f231a.get(str);
        if (buVarA == null) {
            synchronized (this.f231a) {
                if (buVarA == null) {
                    buVarA = this.f229a.a(this.f228a, str);
                    this.f231a.put(str, buVarA);
                }
            }
        }
        return buVarA;
    }
}
