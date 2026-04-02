package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.o.e;
import com.bumptech.glide.load.o.k;
import com.bumptech.glide.load.o.m;
import com.bumptech.glide.load.p.d0.d;
import com.bumptech.glide.load.q.a;
import com.bumptech.glide.load.q.b;
import com.bumptech.glide.load.q.d;
import com.bumptech.glide.load.q.e;
import com.bumptech.glide.load.q.f;
import com.bumptech.glide.load.q.k;
import com.bumptech.glide.load.q.s;
import com.bumptech.glide.load.q.u;
import com.bumptech.glide.load.q.v;
import com.bumptech.glide.load.q.w;
import com.bumptech.glide.load.q.x;
import com.bumptech.glide.load.q.y.b;
import com.bumptech.glide.load.q.y.c;
import com.bumptech.glide.load.q.y.d;
import com.bumptech.glide.load.q.y.e;
import com.bumptech.glide.load.q.y.f;
import com.bumptech.glide.load.q.y.g;
import com.bumptech.glide.load.r.d.a0;
import com.bumptech.glide.load.r.d.c0;
import com.bumptech.glide.load.r.d.f0;
import com.bumptech.glide.load.r.d.h0;
import com.bumptech.glide.load.r.d.j0;
import com.bumptech.glide.load.r.d.o;
import com.bumptech.glide.load.r.d.q;
import com.bumptech.glide.load.r.d.t;
import com.bumptech.glide.load.r.d.y;
import com.bumptech.glide.load.r.e.a;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.r.l.p;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Glide.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: m */
    private static final String f2636m = "image_manager_disk_cache";

    /* JADX INFO: renamed from: n */
    private static final String f2637n = "Glide";
    private static volatile b o;
    private static volatile boolean p;
    private final com.bumptech.glide.load.p.k a;

    /* JADX INFO: renamed from: b */
    private final com.bumptech.glide.load.p.a0.e f2638b;

    /* JADX INFO: renamed from: c */
    private final com.bumptech.glide.load.p.b0.j f2639c;

    /* JADX INFO: renamed from: d */
    private final d f2640d;

    /* JADX INFO: renamed from: e */
    private final i f2641e;

    /* JADX INFO: renamed from: f */
    private final com.bumptech.glide.load.p.a0.b f2642f;

    /* JADX INFO: renamed from: g */
    private final com.bumptech.glide.manager.k f2643g;

    /* JADX INFO: renamed from: h */
    private final com.bumptech.glide.manager.d f2644h;

    /* JADX INFO: renamed from: j */
    private final a f2646j;

    /* JADX INFO: renamed from: l */
    @Nullable
    @GuardedBy("this")
    private com.bumptech.glide.load.p.d0.b f2648l;

    /* JADX INFO: renamed from: i */
    private final List<k> f2645i = new ArrayList();

    /* JADX INFO: renamed from: k */
    private f f2647k = f.NORMAL;

    /* JADX INFO: compiled from: Glide.java */
    public interface a {
        @NonNull
        com.bumptech.glide.r.h build();
    }

    b(@NonNull Context context, @NonNull com.bumptech.glide.load.p.k kVar, @NonNull com.bumptech.glide.load.p.b0.j jVar, @NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull com.bumptech.glide.load.p.a0.b bVar, @NonNull com.bumptech.glide.manager.k kVar2, @NonNull com.bumptech.glide.manager.d dVar, int i2, @NonNull a aVar, @NonNull Map<Class<?>, l<?, ?>> map, @NonNull List<com.bumptech.glide.r.g<Object>> list, boolean z, boolean z2) {
        com.bumptech.glide.load.l jVar2;
        com.bumptech.glide.load.l f0Var;
        Object obj;
        this.a = kVar;
        this.f2638b = eVar;
        this.f2642f = bVar;
        this.f2639c = jVar;
        this.f2643g = kVar2;
        this.f2644h = dVar;
        this.f2646j = aVar;
        Resources resources = context.getResources();
        this.f2641e = new i();
        this.f2641e.a((ImageHeaderParser) new o());
        if (Build.VERSION.SDK_INT >= 27) {
            this.f2641e.a((ImageHeaderParser) new t());
        }
        List<ImageHeaderParser> listA = this.f2641e.a();
        com.bumptech.glide.load.resource.gif.a aVar2 = new com.bumptech.glide.load.resource.gif.a(context, listA, eVar, bVar);
        com.bumptech.glide.load.l<ParcelFileDescriptor, Bitmap> lVarC = j0.c(eVar);
        q qVar = new q(this.f2641e.a(), resources.getDisplayMetrics(), eVar, bVar);
        if (!z2 || Build.VERSION.SDK_INT < 28) {
            jVar2 = new com.bumptech.glide.load.r.d.j(qVar);
            f0Var = new f0(qVar, bVar);
        } else {
            f0Var = new y();
            jVar2 = new com.bumptech.glide.load.r.d.k();
        }
        com.bumptech.glide.load.r.f.e eVar2 = new com.bumptech.glide.load.r.f.e(context);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        com.bumptech.glide.load.r.d.e eVar3 = new com.bumptech.glide.load.r.d.e(bVar);
        com.bumptech.glide.load.r.h.a aVar4 = new com.bumptech.glide.load.r.h.a();
        com.bumptech.glide.load.r.h.d dVar3 = new com.bumptech.glide.load.r.h.d();
        ContentResolver contentResolver = context.getContentResolver();
        this.f2641e.a(ByteBuffer.class, new com.bumptech.glide.load.q.c()).a(InputStream.class, new com.bumptech.glide.load.q.t(bVar)).a(i.f2685l, ByteBuffer.class, Bitmap.class, jVar2).a(i.f2685l, InputStream.class, Bitmap.class, f0Var);
        if (m.c()) {
            obj = com.bumptech.glide.o.a.class;
            this.f2641e.a(i.f2685l, ParcelFileDescriptor.class, Bitmap.class, new a0(qVar));
        } else {
            obj = com.bumptech.glide.o.a.class;
        }
        Object obj2 = obj;
        this.f2641e.a(i.f2685l, ParcelFileDescriptor.class, Bitmap.class, lVarC).a(i.f2685l, AssetFileDescriptor.class, Bitmap.class, j0.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.b()).a(i.f2685l, Bitmap.class, Bitmap.class, new h0()).a(Bitmap.class, (com.bumptech.glide.load.m) eVar3).a(i.f2686m, ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.r.d.a(resources, jVar2)).a(i.f2686m, InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.r.d.a(resources, f0Var)).a(i.f2686m, ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.r.d.a(resources, lVarC)).a(BitmapDrawable.class, (com.bumptech.glide.load.m) new com.bumptech.glide.load.r.d.b(eVar, eVar3)).a(i.f2684k, InputStream.class, GifDrawable.class, new com.bumptech.glide.load.resource.gif.i(listA, aVar2, bVar)).a(i.f2684k, ByteBuffer.class, GifDrawable.class, aVar2).a(GifDrawable.class, (com.bumptech.glide.load.m) new com.bumptech.glide.load.resource.gif.c()).a((Class) obj2, (Class) obj2, (com.bumptech.glide.load.q.o) v.a.b()).a(i.f2685l, obj2, Bitmap.class, new com.bumptech.glide.load.resource.gif.g(eVar)).a(Uri.class, Drawable.class, eVar2).a(Uri.class, Bitmap.class, new c0(eVar2, eVar)).a((e.a<?>) new a.C0060a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.bumptech.glide.load.r.g.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.b()).a((e.a<?>) new k.a(bVar));
        if (m.c()) {
            this.f2641e.a((e.a<?>) new m.a());
        }
        this.f2641e.a(Integer.TYPE, InputStream.class, cVar).a(Integer.TYPE, ParcelFileDescriptor.class, bVar2).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar2).a(Integer.class, Uri.class, dVar2).a(Integer.TYPE, AssetFileDescriptor.class, aVar3).a(Integer.class, AssetFileDescriptor.class, aVar3).a(Integer.TYPE, Uri.class, dVar2).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new c.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new d.a(context)).a(Uri.class, InputStream.class, new e.a(context));
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2641e.a(Uri.class, InputStream.class, new f.c(context));
            this.f2641e.a(Uri.class, ParcelFileDescriptor.class, new f.b(context));
        }
        this.f2641e.a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new g.a()).a(Uri.class, File.class, new k.a(context)).a(com.bumptech.glide.load.q.g.class, InputStream.class, new b.a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.b()).a(Drawable.class, Drawable.class, v.a.b()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.r.f.f()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.r.h.b(resources)).a(Bitmap.class, byte[].class, aVar4).a(Drawable.class, byte[].class, new com.bumptech.glide.load.r.h.c(eVar, aVar4, dVar3)).a(GifDrawable.class, byte[].class, dVar3);
        if (Build.VERSION.SDK_INT >= 23) {
            com.bumptech.glide.load.l<ByteBuffer, Bitmap> lVarB = j0.b(eVar);
            this.f2641e.a(ByteBuffer.class, Bitmap.class, lVarB);
            this.f2641e.a(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.r.d.a(resources, lVarB));
        }
        this.f2640d = new d(context, bVar, this.f2641e, new com.bumptech.glide.r.l.k(), aVar, map, list, kVar, z, i2);
    }

    @Nullable
    public static File a(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            Log.isLoggable(f2637n, 6);
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    @GuardedBy("Glide.class")
    private static void b(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        a(context, new c(), generatedAppGlideModule);
    }

    @Nullable
    public static File c(@NonNull Context context) {
        return a(context, "image_manager_disk_cache");
    }

    @VisibleForTesting
    public static synchronized void j() {
        if (o != null) {
            o.f().getApplicationContext().unregisterComponentCallbacks(o);
            o.a.b();
        }
        o = null;
    }

    @NonNull
    public com.bumptech.glide.load.p.a0.e d() {
        return this.f2638b;
    }

    com.bumptech.glide.manager.d e() {
        return this.f2644h;
    }

    @NonNull
    public Context f() {
        return this.f2640d.getBaseContext();
    }

    @NonNull
    d g() {
        return this.f2640d;
    }

    @NonNull
    public i h() {
        return this.f2641e;
    }

    @NonNull
    public com.bumptech.glide.manager.k i() {
        return this.f2643g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        a(i2);
    }

    @Nullable
    private static GeneratedAppGlideModule b(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            Log.isLoggable(f2637n, 5);
            return null;
        } catch (IllegalAccessException e2) {
            a(e2);
            return null;
        } catch (InstantiationException e3) {
            a(e3);
            return null;
        } catch (NoSuchMethodException e4) {
            a(e4);
            return null;
        } catch (InvocationTargetException e5) {
            a(e5);
            return null;
        }
    }

    @NonNull
    private static com.bumptech.glide.manager.k d(@Nullable Context context) {
        com.bumptech.glide.util.j.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).i();
    }

    @NonNull
    public static k e(@NonNull Context context) {
        return d(context).a(context);
    }

    @NonNull
    public com.bumptech.glide.load.p.a0.b c() {
        return this.f2642f;
    }

    @NonNull
    public static b a(@NonNull Context context) {
        if (o == null) {
            GeneratedAppGlideModule generatedAppGlideModuleB = b(context.getApplicationContext());
            synchronized (b.class) {
                if (o == null) {
                    a(context, generatedAppGlideModuleB);
                }
            }
        }
        return o;
    }

    public void b() {
        com.bumptech.glide.util.l.b();
        this.f2639c.a();
        this.f2638b.a();
        this.f2642f.a();
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!p) {
            p = true;
            b(context, generatedAppGlideModule);
            p = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    void b(k kVar) {
        synchronized (this.f2645i) {
            if (this.f2645i.contains(kVar)) {
                this.f2645i.remove(kVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void a(b bVar) {
        if (o != null) {
            j();
        }
        o = bVar;
    }

    @VisibleForTesting
    public static void a(@NonNull Context context, @NonNull c cVar) {
        GeneratedAppGlideModule generatedAppGlideModuleB = b(context);
        synchronized (b.class) {
            if (o != null) {
                j();
            }
            a(context, cVar, generatedAppGlideModuleB);
        }
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @NonNull c cVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<com.bumptech.glide.p.c> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.a()) {
            listEmptyList = new com.bumptech.glide.p.e(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.b().isEmpty()) {
            Set<Class<?>> setB = generatedAppGlideModule.b();
            Iterator<com.bumptech.glide.p.c> it = listEmptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.p.c next = it.next();
                if (setB.contains(next.getClass())) {
                    if (Log.isLoggable(f2637n, 3)) {
                        String str = "AppGlideModule excludes manifest GlideModule: " + next;
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(f2637n, 3)) {
            Iterator<com.bumptech.glide.p.c> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                String str2 = "Discovered GlideModule from manifest: " + it2.next().getClass();
            }
        }
        cVar.a(generatedAppGlideModule != null ? generatedAppGlideModule.c() : null);
        Iterator<com.bumptech.glide.p.c> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, cVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, cVar);
        }
        b bVarA = cVar.a(applicationContext);
        for (com.bumptech.glide.p.c cVar2 : listEmptyList) {
            try {
                cVar2.a(applicationContext, bVarA, bVarA.f2641e);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + cVar2.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, bVarA, bVarA.f2641e);
        }
        applicationContext.registerComponentCallbacks(bVarA);
        o = bVarA;
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public synchronized void a(@NonNull d.a... aVarArr) {
        if (this.f2648l == null) {
            this.f2648l = new com.bumptech.glide.load.p.d0.b(this.f2639c, this.f2638b, (com.bumptech.glide.load.b) this.f2646j.build().o().a(q.f3209g));
        }
        this.f2648l.a(aVarArr);
    }

    public void a(int i2) {
        com.bumptech.glide.util.l.b();
        Iterator<k> it = this.f2645i.iterator();
        while (it.hasNext()) {
            it.next().onTrimMemory(i2);
        }
        this.f2639c.a(i2);
        this.f2638b.a(i2);
        this.f2642f.a(i2);
    }

    public void a() {
        com.bumptech.glide.util.l.a();
        this.a.a();
    }

    @NonNull
    public f a(@NonNull f fVar) {
        com.bumptech.glide.util.l.b();
        this.f2639c.a(fVar.getMultiplier());
        this.f2638b.a(fVar.getMultiplier());
        f fVar2 = this.f2647k;
        this.f2647k = fVar;
        return fVar2;
    }

    @NonNull
    public static k a(@NonNull Activity activity) {
        return d(activity).a(activity);
    }

    @NonNull
    public static k a(@NonNull FragmentActivity fragmentActivity) {
        return d(fragmentActivity).a(fragmentActivity);
    }

    @NonNull
    public static k a(@NonNull Fragment fragment) {
        return d(fragment.getContext()).a(fragment);
    }

    @NonNull
    @Deprecated
    public static k a(@NonNull android.app.Fragment fragment) {
        return d(fragment.getActivity()).a(fragment);
    }

    @NonNull
    public static k a(@NonNull View view) {
        return d(view.getContext()).a(view);
    }

    boolean a(@NonNull p<?> pVar) {
        synchronized (this.f2645i) {
            Iterator<k> it = this.f2645i.iterator();
            while (it.hasNext()) {
                if (it.next().b(pVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    void a(k kVar) {
        synchronized (this.f2645i) {
            if (!this.f2645i.contains(kVar)) {
                this.f2645i.add(kVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
