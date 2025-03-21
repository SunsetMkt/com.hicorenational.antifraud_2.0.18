package com.bumptech.glide.load.p123q;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import java.io.InputStream;

/* compiled from: ResourceLoader.java */
/* renamed from: com.bumptech.glide.load.q.s */
/* loaded from: classes.dex */
public class C1700s<Data> implements InterfaceC1695n<Integer, Data> {

    /* renamed from: c */
    private static final String f4751c = "ResourceLoader";

    /* renamed from: a */
    private final InterfaceC1695n<Uri, Data> f4752a;

    /* renamed from: b */
    private final Resources f4753b;

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.q.s$a */
    public static final class a implements InterfaceC1696o<Integer, AssetFileDescriptor> {

        /* renamed from: a */
        private final Resources f4754a;

        public a(Resources resources) {
            this.f4754a = resources;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public InterfaceC1695n<Integer, AssetFileDescriptor> mo4220a(C1699r c1699r) {
            return new C1700s(this.f4754a, c1699r.m4276a(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.q.s$b */
    public static class b implements InterfaceC1696o<Integer, ParcelFileDescriptor> {

        /* renamed from: a */
        private final Resources f4755a;

        public b(Resources resources) {
            this.f4755a = resources;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Integer, ParcelFileDescriptor> mo4220a(C1699r c1699r) {
            return new C1700s(this.f4755a, c1699r.m4276a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.q.s$c */
    public static class c implements InterfaceC1696o<Integer, InputStream> {

        /* renamed from: a */
        private final Resources f4756a;

        public c(Resources resources) {
            this.f4756a = resources;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Integer, InputStream> mo4220a(C1699r c1699r) {
            return new C1700s(this.f4756a, c1699r.m4276a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.q.s$d */
    public static class d implements InterfaceC1696o<Integer, Uri> {

        /* renamed from: a */
        private final Resources f4757a;

        public d(Resources resources) {
            this.f4757a = resources;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Integer, Uri> mo4220a(C1699r c1699r) {
            return new C1700s(this.f4757a, C1703v.m4289a());
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1700s(Resources resources, InterfaceC1695n<Uri, Data> interfaceC1695n) {
        this.f4753b = resources;
        this.f4752a = interfaceC1695n;
    }

    @Nullable
    /* renamed from: b */
    private Uri m4286b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f4753b.getResourcePackageName(num.intValue()) + '/' + this.f4753b.getResourceTypeName(num.intValue()) + '/' + this.f4753b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (!Log.isLoggable(f4751c, 5)) {
                return null;
            }
            String str = "Received invalid resource id: " + num;
            return null;
        }
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull Integer num) {
        return true;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<Data> mo4217a(@NonNull Integer num, int i2, int i3, @NonNull C1596j c1596j) {
        Uri m4286b = m4286b(num);
        if (m4286b == null) {
            return null;
        }
        return this.f4752a.mo4217a(m4286b, i2, i3, c1596j);
    }
}
