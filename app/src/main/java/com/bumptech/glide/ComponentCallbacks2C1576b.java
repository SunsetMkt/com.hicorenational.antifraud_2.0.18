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
import com.bumptech.glide.load.EnumC1588b;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.InterfaceC1599m;
import com.bumptech.glide.load.p116o.C1611k;
import com.bumptech.glide.load.p116o.C1613m;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import com.bumptech.glide.load.p118p.C1666k;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j;
import com.bumptech.glide.load.p118p.p122d0.C1657b;
import com.bumptech.glide.load.p118p.p122d0.C1659d;
import com.bumptech.glide.load.p123q.C1682a;
import com.bumptech.glide.load.p123q.C1683b;
import com.bumptech.glide.load.p123q.C1684c;
import com.bumptech.glide.load.p123q.C1685d;
import com.bumptech.glide.load.p123q.C1686e;
import com.bumptech.glide.load.p123q.C1687f;
import com.bumptech.glide.load.p123q.C1688g;
import com.bumptech.glide.load.p123q.C1692k;
import com.bumptech.glide.load.p123q.C1700s;
import com.bumptech.glide.load.p123q.C1701t;
import com.bumptech.glide.load.p123q.C1702u;
import com.bumptech.glide.load.p123q.C1703v;
import com.bumptech.glide.load.p123q.C1704w;
import com.bumptech.glide.load.p123q.C1705x;
import com.bumptech.glide.load.p123q.InterfaceC1696o;
import com.bumptech.glide.load.p123q.p124y.C1707b;
import com.bumptech.glide.load.p123q.p124y.C1708c;
import com.bumptech.glide.load.p123q.p124y.C1709d;
import com.bumptech.glide.load.p123q.p124y.C1710e;
import com.bumptech.glide.load.p123q.p124y.C1711f;
import com.bumptech.glide.load.p123q.p124y.C1712g;
import com.bumptech.glide.load.p125r.p126d.C1716a;
import com.bumptech.glide.load.p125r.p126d.C1717a0;
import com.bumptech.glide.load.p125r.p126d.C1718b;
import com.bumptech.glide.load.p125r.p126d.C1721c0;
import com.bumptech.glide.load.p125r.p126d.C1724e;
import com.bumptech.glide.load.p125r.p126d.C1727f0;
import com.bumptech.glide.load.p125r.p126d.C1731h0;
import com.bumptech.glide.load.p125r.p126d.C1734j;
import com.bumptech.glide.load.p125r.p126d.C1735j0;
import com.bumptech.glide.load.p125r.p126d.C1736k;
import com.bumptech.glide.load.p125r.p126d.C1740o;
import com.bumptech.glide.load.p125r.p126d.C1742q;
import com.bumptech.glide.load.p125r.p126d.C1745t;
import com.bumptech.glide.load.p125r.p126d.C1750y;
import com.bumptech.glide.load.p125r.p127e.C1752a;
import com.bumptech.glide.load.p125r.p128f.C1758e;
import com.bumptech.glide.load.p125r.p128f.C1759f;
import com.bumptech.glide.load.p125r.p129g.C1760a;
import com.bumptech.glide.load.p125r.p130h.C1762a;
import com.bumptech.glide.load.p125r.p130h.C1763b;
import com.bumptech.glide.load.p125r.p130h.C1764c;
import com.bumptech.glide.load.p125r.p130h.C1765d;
import com.bumptech.glide.load.resource.gif.C1770a;
import com.bumptech.glide.load.resource.gif.C1772c;
import com.bumptech.glide.load.resource.gif.C1776g;
import com.bumptech.glide.load.resource.gif.C1778i;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.C1797k;
import com.bumptech.glide.manager.InterfaceC1790d;
import com.bumptech.glide.p134o.InterfaceC1804a;
import com.bumptech.glide.p135p.C1814e;
import com.bumptech.glide.p135p.InterfaceC1812c;
import com.bumptech.glide.p137r.C1829h;
import com.bumptech.glide.p137r.InterfaceC1828g;
import com.bumptech.glide.p137r.p138l.C1843k;
import com.bumptech.glide.p137r.p138l.InterfaceC1848p;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;
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

/* compiled from: Glide.java */
/* renamed from: com.bumptech.glide.b */
/* loaded from: classes.dex */
public class ComponentCallbacks2C1576b implements ComponentCallbacks2 {

    /* renamed from: m */
    private static final String f4062m = "image_manager_disk_cache";

    /* renamed from: n */
    private static final String f4063n = "Glide";

    /* renamed from: o */
    private static volatile ComponentCallbacks2C1576b f4064o;

    /* renamed from: p */
    private static volatile boolean f4065p;

    /* renamed from: a */
    private final C1666k f4066a;

    /* renamed from: b */
    private final InterfaceC1626e f4067b;

    /* renamed from: c */
    private final InterfaceC1648j f4068c;

    /* renamed from: d */
    private final C1578d f4069d;

    /* renamed from: e */
    private final C1583i f4070e;

    /* renamed from: f */
    private final InterfaceC1623b f4071f;

    /* renamed from: g */
    private final C1797k f4072g;

    /* renamed from: h */
    private final InterfaceC1790d f4073h;

    /* renamed from: j */
    private final a f4075j;

    /* renamed from: l */
    @Nullable
    @GuardedBy("this")
    private C1657b f4077l;

    /* renamed from: i */
    private final List<ComponentCallbacks2C1585k> f4074i = new ArrayList();

    /* renamed from: k */
    private EnumC1580f f4076k = EnumC1580f.NORMAL;

    /* compiled from: Glide.java */
    /* renamed from: com.bumptech.glide.b$a */
    public interface a {
        @NonNull
        C1829h build();
    }

    ComponentCallbacks2C1576b(@NonNull Context context, @NonNull C1666k c1666k, @NonNull InterfaceC1648j interfaceC1648j, @NonNull InterfaceC1626e interfaceC1626e, @NonNull InterfaceC1623b interfaceC1623b, @NonNull C1797k c1797k, @NonNull InterfaceC1790d interfaceC1790d, int i2, @NonNull a aVar, @NonNull Map<Class<?>, AbstractC1586l<?, ?>> map, @NonNull List<InterfaceC1828g<Object>> list, boolean z, boolean z2) {
        InterfaceC1598l c1734j;
        InterfaceC1598l c1727f0;
        Object obj;
        this.f4066a = c1666k;
        this.f4067b = interfaceC1626e;
        this.f4071f = interfaceC1623b;
        this.f4068c = interfaceC1648j;
        this.f4072g = c1797k;
        this.f4073h = interfaceC1790d;
        this.f4075j = aVar;
        Resources resources = context.getResources();
        this.f4070e = new C1583i();
        this.f4070e.m3724a((ImageHeaderParser) new C1740o());
        if (Build.VERSION.SDK_INT >= 27) {
            this.f4070e.m3724a((ImageHeaderParser) new C1745t());
        }
        List<ImageHeaderParser> m3735a = this.f4070e.m3735a();
        C1770a c1770a = new C1770a(context, m3735a, interfaceC1626e, interfaceC1623b);
        InterfaceC1598l<ParcelFileDescriptor, Bitmap> m4353c = C1735j0.m4353c(interfaceC1626e);
        C1742q c1742q = new C1742q(this.f4070e.m3735a(), resources.getDisplayMetrics(), interfaceC1626e, interfaceC1623b);
        if (!z2 || Build.VERSION.SDK_INT < 28) {
            c1734j = new C1734j(c1742q);
            c1727f0 = new C1727f0(c1742q, interfaceC1623b);
        } else {
            c1727f0 = new C1750y();
            c1734j = new C1736k();
        }
        C1758e c1758e = new C1758e(context);
        C1700s.c cVar = new C1700s.c(resources);
        C1700s.d dVar = new C1700s.d(resources);
        C1700s.b bVar = new C1700s.b(resources);
        C1700s.a aVar2 = new C1700s.a(resources);
        C1724e c1724e = new C1724e(interfaceC1623b);
        C1762a c1762a = new C1762a();
        C1765d c1765d = new C1765d();
        ContentResolver contentResolver = context.getContentResolver();
        this.f4070e.m3726a(ByteBuffer.class, new C1684c()).m3726a(InputStream.class, new C1701t(interfaceC1623b)).m3731a(C1583i.f4127l, ByteBuffer.class, Bitmap.class, c1734j).m3731a(C1583i.f4127l, InputStream.class, Bitmap.class, c1727f0);
        if (C1613m.m3870c()) {
            obj = InterfaceC1804a.class;
            this.f4070e.m3731a(C1583i.f4127l, ParcelFileDescriptor.class, Bitmap.class, new C1717a0(c1742q));
        } else {
            obj = InterfaceC1804a.class;
        }
        Object obj2 = obj;
        this.f4070e.m3731a(C1583i.f4127l, ParcelFileDescriptor.class, Bitmap.class, m4353c).m3731a(C1583i.f4127l, AssetFileDescriptor.class, Bitmap.class, C1735j0.m4350a(interfaceC1626e)).m3729a(Bitmap.class, Bitmap.class, C1703v.a.m4290b()).m3731a(C1583i.f4127l, Bitmap.class, Bitmap.class, new C1731h0()).m3727a(Bitmap.class, (InterfaceC1599m) c1724e).m3731a(C1583i.f4128m, ByteBuffer.class, BitmapDrawable.class, new C1716a(resources, c1734j)).m3731a(C1583i.f4128m, InputStream.class, BitmapDrawable.class, new C1716a(resources, c1727f0)).m3731a(C1583i.f4128m, ParcelFileDescriptor.class, BitmapDrawable.class, new C1716a(resources, m4353c)).m3727a(BitmapDrawable.class, (InterfaceC1599m) new C1718b(interfaceC1626e, c1724e)).m3731a(C1583i.f4126k, InputStream.class, GifDrawable.class, new C1778i(m3735a, c1770a, interfaceC1623b)).m3731a(C1583i.f4126k, ByteBuffer.class, GifDrawable.class, c1770a).m3727a(GifDrawable.class, (InterfaceC1599m) new C1772c()).m3729a((Class) obj2, (Class) obj2, (InterfaceC1696o) C1703v.a.m4290b()).m3731a(C1583i.f4127l, obj2, Bitmap.class, new C1776g(interfaceC1626e)).m3728a(Uri.class, Drawable.class, c1758e).m3728a(Uri.class, Bitmap.class, new C1721c0(c1758e, interfaceC1626e)).m3725a((InterfaceC1605e.a<?>) new C1752a.a()).m3729a(File.class, ByteBuffer.class, new C1685d.b()).m3729a(File.class, InputStream.class, new C1687f.e()).m3728a(File.class, File.class, new C1760a()).m3729a(File.class, ParcelFileDescriptor.class, new C1687f.b()).m3729a(File.class, File.class, C1703v.a.m4290b()).m3725a((InterfaceC1605e.a<?>) new C1611k.a(interfaceC1623b));
        if (C1613m.m3870c()) {
            this.f4070e.m3725a((InterfaceC1605e.a<?>) new C1613m.a());
        }
        this.f4070e.m3729a(Integer.TYPE, InputStream.class, cVar).m3729a(Integer.TYPE, ParcelFileDescriptor.class, bVar).m3729a(Integer.class, InputStream.class, cVar).m3729a(Integer.class, ParcelFileDescriptor.class, bVar).m3729a(Integer.class, Uri.class, dVar).m3729a(Integer.TYPE, AssetFileDescriptor.class, aVar2).m3729a(Integer.class, AssetFileDescriptor.class, aVar2).m3729a(Integer.TYPE, Uri.class, dVar).m3729a(String.class, InputStream.class, new C1686e.c()).m3729a(Uri.class, InputStream.class, new C1686e.c()).m3729a(String.class, InputStream.class, new C1702u.c()).m3729a(String.class, ParcelFileDescriptor.class, new C1702u.b()).m3729a(String.class, AssetFileDescriptor.class, new C1702u.a()).m3729a(Uri.class, InputStream.class, new C1708c.a()).m3729a(Uri.class, InputStream.class, new C1682a.c(context.getAssets())).m3729a(Uri.class, ParcelFileDescriptor.class, new C1682a.b(context.getAssets())).m3729a(Uri.class, InputStream.class, new C1709d.a(context)).m3729a(Uri.class, InputStream.class, new C1710e.a(context));
        if (Build.VERSION.SDK_INT >= 29) {
            this.f4070e.m3729a(Uri.class, InputStream.class, new C1711f.c(context));
            this.f4070e.m3729a(Uri.class, ParcelFileDescriptor.class, new C1711f.b(context));
        }
        this.f4070e.m3729a(Uri.class, InputStream.class, new C1704w.d(contentResolver)).m3729a(Uri.class, ParcelFileDescriptor.class, new C1704w.b(contentResolver)).m3729a(Uri.class, AssetFileDescriptor.class, new C1704w.a(contentResolver)).m3729a(Uri.class, InputStream.class, new C1705x.a()).m3729a(URL.class, InputStream.class, new C1712g.a()).m3729a(Uri.class, File.class, new C1692k.a(context)).m3729a(C1688g.class, InputStream.class, new C1707b.a()).m3729a(byte[].class, ByteBuffer.class, new C1683b.a()).m3729a(byte[].class, InputStream.class, new C1683b.d()).m3729a(Uri.class, Uri.class, C1703v.a.m4290b()).m3729a(Drawable.class, Drawable.class, C1703v.a.m4290b()).m3728a(Drawable.class, Drawable.class, new C1759f()).m3730a(Bitmap.class, BitmapDrawable.class, new C1763b(resources)).m3730a(Bitmap.class, byte[].class, c1762a).m3730a(Drawable.class, byte[].class, new C1764c(interfaceC1626e, c1762a, c1765d)).m3730a(GifDrawable.class, byte[].class, c1765d);
        if (Build.VERSION.SDK_INT >= 23) {
            InterfaceC1598l<ByteBuffer, Bitmap> m4352b = C1735j0.m4352b(interfaceC1626e);
            this.f4070e.m3728a(ByteBuffer.class, Bitmap.class, m4352b);
            this.f4070e.m3728a(ByteBuffer.class, BitmapDrawable.class, new C1716a(resources, m4352b));
        }
        this.f4069d = new C1578d(context, interfaceC1623b, this.f4070e, new C1843k(), aVar, map, list, c1666k, z, i2);
    }

    @Nullable
    /* renamed from: a */
    public static File m3639a(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            Log.isLoggable(f4063n, 6);
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    @GuardedBy("Glide.class")
    /* renamed from: b */
    private static void m3646b(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        m3642a(context, new C1577c(), generatedAppGlideModule);
    }

    @Nullable
    /* renamed from: c */
    public static File m3647c(@NonNull Context context) {
        return m3639a(context, "image_manager_disk_cache");
    }

    @VisibleForTesting
    /* renamed from: j */
    public static synchronized void m3650j() {
        synchronized (ComponentCallbacks2C1576b.class) {
            if (f4064o != null) {
                f4064o.m3662f().getApplicationContext().unregisterComponentCallbacks(f4064o);
                f4064o.f4066a.m4153b();
            }
            f4064o = null;
        }
    }

    @NonNull
    /* renamed from: d */
    public InterfaceC1626e m3660d() {
        return this.f4067b;
    }

    /* renamed from: e */
    InterfaceC1790d m3661e() {
        return this.f4073h;
    }

    @NonNull
    /* renamed from: f */
    public Context m3662f() {
        return this.f4069d.getBaseContext();
    }

    @NonNull
    /* renamed from: g */
    C1578d m3663g() {
        return this.f4069d;
    }

    @NonNull
    /* renamed from: h */
    public C1583i m3664h() {
        return this.f4070e;
    }

    @NonNull
    /* renamed from: i */
    public C1797k m3665i() {
        return this.f4072g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        m3657b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        m3653a(i2);
    }

    @Nullable
    /* renamed from: b */
    private static GeneratedAppGlideModule m3645b(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            Log.isLoggable(f4063n, 5);
            return null;
        } catch (IllegalAccessException e2) {
            m3644a(e2);
            return null;
        } catch (InstantiationException e3) {
            m3644a(e3);
            return null;
        } catch (NoSuchMethodException e4) {
            m3644a(e4);
            return null;
        } catch (InvocationTargetException e5) {
            m3644a(e5);
            return null;
        }
    }

    @NonNull
    /* renamed from: d */
    private static C1797k m3648d(@Nullable Context context) {
        C1876j.m4986a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m3633a(context).m3665i();
    }

    @NonNull
    /* renamed from: e */
    public static ComponentCallbacks2C1585k m3649e(@NonNull Context context) {
        return m3648d(context).m4547a(context);
    }

    @NonNull
    /* renamed from: c */
    public InterfaceC1623b m3659c() {
        return this.f4071f;
    }

    @NonNull
    /* renamed from: a */
    public static ComponentCallbacks2C1576b m3633a(@NonNull Context context) {
        if (f4064o == null) {
            GeneratedAppGlideModule m3645b = m3645b(context.getApplicationContext());
            synchronized (ComponentCallbacks2C1576b.class) {
                if (f4064o == null) {
                    m3640a(context, m3645b);
                }
            }
        }
        return f4064o;
    }

    /* renamed from: b */
    public void m3657b() {
        C1878l.m5007b();
        this.f4068c.mo4002a();
        this.f4067b.mo3921a();
        this.f4071f.mo3904a();
    }

    @GuardedBy("Glide.class")
    /* renamed from: a */
    private static void m3640a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f4065p) {
            f4065p = true;
            m3646b(context, generatedAppGlideModule);
            f4065p = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    /* renamed from: b */
    void m3658b(ComponentCallbacks2C1585k componentCallbacks2C1585k) {
        synchronized (this.f4074i) {
            if (this.f4074i.contains(componentCallbacks2C1585k)) {
                this.f4074i.remove(componentCallbacks2C1585k);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @VisibleForTesting
    @Deprecated
    /* renamed from: a */
    public static synchronized void m3643a(ComponentCallbacks2C1576b componentCallbacks2C1576b) {
        synchronized (ComponentCallbacks2C1576b.class) {
            if (f4064o != null) {
                m3650j();
            }
            f4064o = componentCallbacks2C1576b;
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public static void m3641a(@NonNull Context context, @NonNull C1577c c1577c) {
        GeneratedAppGlideModule m3645b = m3645b(context);
        synchronized (ComponentCallbacks2C1576b.class) {
            if (f4064o != null) {
                m3650j();
            }
            m3642a(context, c1577c, m3645b);
        }
    }

    @GuardedBy("Glide.class")
    /* renamed from: a */
    private static void m3642a(@NonNull Context context, @NonNull C1577c c1577c, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<InterfaceC1812c> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.m4686a()) {
            emptyList = new C1814e(applicationContext).m4690a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.m3627b().isEmpty()) {
            Set<Class<?>> m3627b = generatedAppGlideModule.m3627b();
            Iterator<InterfaceC1812c> it = emptyList.iterator();
            while (it.hasNext()) {
                InterfaceC1812c next = it.next();
                if (m3627b.contains(next.getClass())) {
                    if (Log.isLoggable(f4063n, 3)) {
                        String str = "AppGlideModule excludes manifest GlideModule: " + next;
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(f4063n, 3)) {
            Iterator<InterfaceC1812c> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                String str2 = "Discovered GlideModule from manifest: " + it2.next().getClass();
            }
        }
        c1577c.m3682a(generatedAppGlideModule != null ? generatedAppGlideModule.m3628c() : null);
        Iterator<InterfaceC1812c> it3 = emptyList.iterator();
        while (it3.hasNext()) {
            it3.next().mo4685a(applicationContext, c1577c);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.mo4685a(applicationContext, c1577c);
        }
        ComponentCallbacks2C1576b m3666a = c1577c.m3666a(applicationContext);
        for (InterfaceC1812c interfaceC1812c : emptyList) {
            try {
                interfaceC1812c.mo4687a(applicationContext, m3666a, m3666a.f4070e);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + interfaceC1812c.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.mo4687a(applicationContext, m3666a, m3666a.f4070e);
        }
        applicationContext.registerComponentCallbacks(m3666a);
        f4064o = m3666a;
    }

    /* renamed from: a */
    private static void m3644a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    /* renamed from: a */
    public synchronized void m3655a(@NonNull C1659d.a... aVarArr) {
        if (this.f4077l == null) {
            this.f4077l = new C1657b(this.f4068c, this.f4067b, (EnumC1588b) this.f4075j.build().m4788o().m3840a(C1742q.f4918g));
        }
        this.f4077l.m4057a(aVarArr);
    }

    /* renamed from: a */
    public void m3653a(int i2) {
        C1878l.m5007b();
        Iterator<ComponentCallbacks2C1585k> it = this.f4074i.iterator();
        while (it.hasNext()) {
            it.next().onTrimMemory(i2);
        }
        this.f4068c.mo3997a(i2);
        this.f4067b.mo3923a(i2);
        this.f4071f.mo3905a(i2);
    }

    /* renamed from: a */
    public void m3652a() {
        C1878l.m5003a();
        this.f4066a.m4149a();
    }

    @NonNull
    /* renamed from: a */
    public EnumC1580f m3651a(@NonNull EnumC1580f enumC1580f) {
        C1878l.m5007b();
        this.f4068c.mo4003a(enumC1580f.getMultiplier());
        this.f4067b.mo3922a(enumC1580f.getMultiplier());
        EnumC1580f enumC1580f2 = this.f4076k;
        this.f4076k = enumC1580f;
        return enumC1580f2;
    }

    @NonNull
    /* renamed from: a */
    public static ComponentCallbacks2C1585k m3634a(@NonNull Activity activity) {
        return m3648d(activity).m4545a(activity);
    }

    @NonNull
    /* renamed from: a */
    public static ComponentCallbacks2C1585k m3638a(@NonNull FragmentActivity fragmentActivity) {
        return m3648d(fragmentActivity).m4550a(fragmentActivity);
    }

    @NonNull
    /* renamed from: a */
    public static ComponentCallbacks2C1585k m3637a(@NonNull Fragment fragment) {
        return m3648d(fragment.getContext()).m4549a(fragment);
    }

    @NonNull
    @Deprecated
    /* renamed from: a */
    public static ComponentCallbacks2C1585k m3635a(@NonNull android.app.Fragment fragment) {
        return m3648d(fragment.getActivity()).m4546a(fragment);
    }

    @NonNull
    /* renamed from: a */
    public static ComponentCallbacks2C1585k m3636a(@NonNull View view) {
        return m3648d(view.getContext()).m4548a(view);
    }

    /* renamed from: a */
    boolean m3656a(@NonNull InterfaceC1848p<?> interfaceC1848p) {
        synchronized (this.f4074i) {
            Iterator<ComponentCallbacks2C1585k> it = this.f4074i.iterator();
            while (it.hasNext()) {
                if (it.next().m3790b(interfaceC1848p)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    void m3654a(ComponentCallbacks2C1585k componentCallbacks2C1585k) {
        synchronized (this.f4074i) {
            if (!this.f4074i.contains(componentCallbacks2C1585k)) {
                this.f4074i.add(componentCallbacks2C1585k);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
