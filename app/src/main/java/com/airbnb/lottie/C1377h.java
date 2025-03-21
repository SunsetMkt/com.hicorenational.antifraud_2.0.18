package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.p098a0.C1343t;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p106y.C1441g;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* compiled from: LottieCompositionFactory.java */
/* renamed from: com.airbnb.lottie.h */
/* loaded from: classes.dex */
public class C1377h {

    /* renamed from: a */
    private static final Map<String, C1386q<C1376g>> f3218a = new HashMap();

    /* renamed from: b */
    private static final byte[] f3219b = {80, 75, 3, 4};

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$a */
    class a implements InterfaceC1381l<C1376g> {

        /* renamed from: a */
        final /* synthetic */ String f3220a;

        a(String str) {
            this.f3220a = str;
        }

        @Override // com.airbnb.lottie.InterfaceC1381l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(C1376g c1376g) {
            C1377h.f3218a.remove(this.f3220a);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$b */
    class b implements InterfaceC1381l<Throwable> {

        /* renamed from: a */
        final /* synthetic */ String f3221a;

        b(String str) {
            this.f3221a = str;
        }

        @Override // com.airbnb.lottie.InterfaceC1381l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            C1377h.f3218a.remove(this.f3221a);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$c */
    class c implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ Context f3222a;

        /* renamed from: b */
        final /* synthetic */ String f3223b;

        /* renamed from: c */
        final /* synthetic */ String f3224c;

        c(Context context, String str, String str2) {
            this.f3222a = context;
            this.f3223b = str;
            this.f3224c = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            C1385p<C1376g> m3412a = C1374e.m2884b(this.f3222a).m3412a(this.f3223b, this.f3224c);
            if (this.f3224c != null && m3412a.m3061b() != null) {
                C1441g.m3212b().m3216a(this.f3224c, m3412a.m3061b());
            }
            return m3412a;
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$d */
    class d implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ Context f3225a;

        /* renamed from: b */
        final /* synthetic */ String f3226b;

        /* renamed from: c */
        final /* synthetic */ String f3227c;

        d(Context context, String str, String str2) {
            this.f3225a = context;
            this.f3226b = str;
            this.f3227c = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return C1377h.m2945b(this.f3225a, this.f3226b, this.f3227c);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$e */
    class e implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ WeakReference f3228a;

        /* renamed from: b */
        final /* synthetic */ Context f3229b;

        /* renamed from: c */
        final /* synthetic */ int f3230c;

        /* renamed from: d */
        final /* synthetic */ String f3231d;

        e(WeakReference weakReference, Context context, int i2, String str) {
            this.f3228a = weakReference;
            this.f3229b = context;
            this.f3230c = i2;
            this.f3231d = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            Context context = (Context) this.f3228a.get();
            if (context == null) {
                context = this.f3229b;
            }
            return C1377h.m2943b(context, this.f3230c, this.f3231d);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$f */
    class f implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ InputStream f3232a;

        /* renamed from: b */
        final /* synthetic */ String f3233b;

        f(InputStream inputStream, String str) {
            this.f3232a = inputStream;
            this.f3233b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return C1377h.m2947b(this.f3232a, this.f3233b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$g */
    class g implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ JSONObject f3234a;

        /* renamed from: b */
        final /* synthetic */ String f3235b;

        g(JSONObject jSONObject, String str) {
            this.f3234a = jSONObject;
            this.f3235b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return C1377h.m2950b(this.f3234a, this.f3235b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$h */
    class h implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ String f3236a;

        /* renamed from: b */
        final /* synthetic */ String f3237b;

        h(String str, String str2) {
            this.f3236a = str;
            this.f3237b = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return C1377h.m2948b(this.f3236a, this.f3237b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$i */
    class i implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ AbstractC1330c f3238a;

        /* renamed from: b */
        final /* synthetic */ String f3239b;

        i(AbstractC1330c abstractC1330c, String str) {
            this.f3238a = abstractC1330c;
            this.f3239b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return C1377h.m2946b(this.f3238a, this.f3239b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$j */
    class j implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ ZipInputStream f3240a;

        /* renamed from: b */
        final /* synthetic */ String f3241b;

        j(ZipInputStream zipInputStream, String str) {
            this.f3240a = zipInputStream;
            this.f3241b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return C1377h.m2949b(this.f3240a, this.f3241b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$k */
    class k implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ C1376g f3242a;

        k(C1376g c1376g) {
            this.f3242a = c1376g;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return new C1385p<>(this.f3242a);
        }
    }

    private C1377h() {
    }

    @WorkerThread
    /* renamed from: b */
    public static C1385p<C1376g> m2944b(Context context, String str) {
        return m2945b(context, str, "asset_" + str);
    }

    /* renamed from: c */
    public static C1386q<C1376g> m2953c(Context context, String str) {
        return m2954c(context, str, "url_" + str);
    }

    @WorkerThread
    /* renamed from: d */
    public static C1385p<C1376g> m2956d(Context context, String str) {
        return m2957d(context, str, str);
    }

    /* renamed from: a */
    public static void m2940a(int i2) {
        C1441g.m3212b().m3215a(i2);
    }

    /* renamed from: c */
    public static C1386q<C1376g> m2954c(Context context, String str, @Nullable String str2) {
        return m2935a(str2, new c(context, str, str2));
    }

    @WorkerThread
    /* renamed from: d */
    public static C1385p<C1376g> m2957d(Context context, String str, @Nullable String str2) {
        C1385p<C1376g> m3412a = C1374e.m2884b(context).m3412a(str, str2);
        if (str2 != null && m3412a.m3061b() != null) {
            C1441g.m3212b().m3216a(str2, m3412a.m3061b());
        }
        return m3412a;
    }

    /* renamed from: a */
    public static void m2941a(Context context) {
        f3218a.clear();
        C1441g.m3212b().m3214a();
        C1374e.m2878a(context).m3405a();
    }

    @WorkerThread
    /* renamed from: b */
    public static C1385p<C1376g> m2945b(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return m2947b(context.getAssets().open(str), str2);
            }
            return m2949b(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e2) {
            return new C1385p<>((Throwable) e2);
        }
    }

    /* renamed from: c */
    private static String m2955c(Context context, @RawRes int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(m2951b(context) ? "_night_" : "_day_");
        sb.append(i2);
        return sb.toString();
    }

    @WorkerThread
    /* renamed from: c */
    private static C1385p<C1376g> m2952c(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            C1376g c1376g = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    c1376g = m2926a(AbstractC1330c.m2691a(Okio.buffer(Okio.source(zipInputStream))), (String) null, false).m3061b();
                } else {
                    if (!name.contains(PictureMimeType.PNG) && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (c1376g == null) {
                return new C1385p<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                C1380k m2925a = m2925a(c1376g, (String) entry.getKey());
                if (m2925a != null) {
                    m2925a.m3052a(C1358h.m2836a((Bitmap) entry.getValue(), m2925a.m3057f(), m2925a.m3055d()));
                }
            }
            for (Map.Entry<String, C1380k> entry2 : c1376g.m2904h().entrySet()) {
                if (entry2.getValue().m3051a() == null) {
                    return new C1385p<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().m3054c()));
                }
            }
            if (str != null) {
                C1441g.m3212b().m3216a(str, c1376g);
            }
            return new C1385p<>(c1376g);
        } catch (IOException e2) {
            return new C1385p<>((Throwable) e2);
        }
    }

    /* renamed from: a */
    public static C1386q<C1376g> m2930a(Context context, String str) {
        return m2931a(context, str, "asset_" + str);
    }

    @WorkerThread
    /* renamed from: b */
    public static C1385p<C1376g> m2942b(Context context, @RawRes int i2) {
        return m2943b(context, i2, m2955c(context, i2));
    }

    /* renamed from: a */
    public static C1386q<C1376g> m2931a(Context context, String str, @Nullable String str2) {
        return m2935a(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    /* renamed from: b */
    public static C1385p<C1376g> m2943b(Context context, @RawRes int i2, @Nullable String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i2)));
            if (m2938a(buffer).booleanValue()) {
                return m2949b(new ZipInputStream(buffer.inputStream()), str);
            }
            return m2947b(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e2) {
            return new C1385p<>((Throwable) e2);
        }
    }

    /* renamed from: a */
    public static C1386q<C1376g> m2928a(Context context, @RawRes int i2) {
        return m2929a(context, i2, m2955c(context, i2));
    }

    /* renamed from: a */
    public static C1386q<C1376g> m2929a(Context context, @RawRes int i2, @Nullable String str) {
        return m2935a(str, new e(new WeakReference(context), context.getApplicationContext(), i2, str));
    }

    /* renamed from: b */
    private static boolean m2951b(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* renamed from: a */
    public static C1386q<C1376g> m2933a(InputStream inputStream, @Nullable String str) {
        return m2935a(str, new f(inputStream, str));
    }

    @WorkerThread
    /* renamed from: b */
    public static C1385p<C1376g> m2947b(InputStream inputStream, @Nullable String str) {
        return m2927a(inputStream, str, true);
    }

    @WorkerThread
    /* renamed from: a */
    private static C1385p<C1376g> m2927a(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return m2946b(AbstractC1330c.m2691a(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                C1358h.m2843a(inputStream);
            }
        }
    }

    @WorkerThread
    @Deprecated
    /* renamed from: b */
    public static C1385p<C1376g> m2950b(JSONObject jSONObject, @Nullable String str) {
        return m2948b(jSONObject.toString(), str);
    }

    @WorkerThread
    /* renamed from: b */
    public static C1385p<C1376g> m2948b(String str, @Nullable String str2) {
        return m2946b(AbstractC1330c.m2691a(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @Deprecated
    /* renamed from: a */
    public static C1386q<C1376g> m2937a(JSONObject jSONObject, @Nullable String str) {
        return m2935a(str, new g(jSONObject, str));
    }

    @WorkerThread
    /* renamed from: b */
    public static C1385p<C1376g> m2946b(AbstractC1330c abstractC1330c, @Nullable String str) {
        return m2926a(abstractC1330c, str, true);
    }

    /* renamed from: a */
    public static C1386q<C1376g> m2934a(String str, @Nullable String str2) {
        return m2935a(str2, new h(str, str2));
    }

    @WorkerThread
    /* renamed from: b */
    public static C1385p<C1376g> m2949b(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return m2952c(zipInputStream, str);
        } finally {
            C1358h.m2843a(zipInputStream);
        }
    }

    /* renamed from: a */
    public static C1386q<C1376g> m2932a(AbstractC1330c abstractC1330c, @Nullable String str) {
        return m2935a(str, new i(abstractC1330c, str));
    }

    /* renamed from: a */
    private static C1385p<C1376g> m2926a(AbstractC1330c abstractC1330c, @Nullable String str, boolean z) {
        try {
            try {
                C1376g m2764a = C1343t.m2764a(abstractC1330c);
                if (str != null) {
                    C1441g.m3212b().m3216a(str, m2764a);
                }
                C1385p<C1376g> c1385p = new C1385p<>(m2764a);
                if (z) {
                    C1358h.m2843a(abstractC1330c);
                }
                return c1385p;
            } catch (Exception e2) {
                C1385p<C1376g> c1385p2 = new C1385p<>(e2);
                if (z) {
                    C1358h.m2843a(abstractC1330c);
                }
                return c1385p2;
            }
        } catch (Throwable th) {
            if (z) {
                C1358h.m2843a(abstractC1330c);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static C1386q<C1376g> m2936a(ZipInputStream zipInputStream, @Nullable String str) {
        return m2935a(str, new j(zipInputStream, str));
    }

    /* renamed from: a */
    private static Boolean m2938a(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b2 : f3219b) {
                if (peek.readByte() != b2) {
                    return false;
                }
            }
            peek.close();
            return true;
        } catch (Exception e2) {
            C1354d.m2792b("Failed to check zip file header", e2);
            return false;
        }
    }

    @Nullable
    /* renamed from: a */
    private static C1380k m2925a(C1376g c1376g, String str) {
        for (C1380k c1380k : c1376g.m2904h().values()) {
            if (c1380k.m3054c().equals(str)) {
                return c1380k;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C1386q<C1376g> m2935a(@Nullable String str, Callable<C1385p<C1376g>> callable) {
        C1376g m3213a = str == null ? null : C1441g.m3212b().m3213a(str);
        if (m3213a != null) {
            return new C1386q<>(new k(m3213a));
        }
        if (str != null && f3218a.containsKey(str)) {
            return f3218a.get(str);
        }
        C1386q<C1376g> c1386q = new C1386q<>(callable);
        if (str != null) {
            c1386q.m3071b(new a(str));
            c1386q.m3070a(new b(str));
            f3218a.put(str, c1386q);
        }
        return c1386q;
    }
}
