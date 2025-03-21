package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MultiTransformation.java */
/* renamed from: com.bumptech.glide.load.h */
/* loaded from: classes.dex */
public class C1594h<T> implements InterfaceC1600n<T> {

    /* renamed from: c */
    private final Collection<? extends InterfaceC1600n<T>> f4192c;

    @SafeVarargs
    public C1594h(@NonNull InterfaceC1600n<T>... interfaceC1600nArr) {
        if (interfaceC1600nArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f4192c = Arrays.asList(interfaceC1600nArr);
    }

    @Override // com.bumptech.glide.load.InterfaceC1600n
    @NonNull
    /* renamed from: a */
    public InterfaceC1677v<T> mo3828a(@NonNull Context context, @NonNull InterfaceC1677v<T> interfaceC1677v, int i2, int i3) {
        Iterator<? extends InterfaceC1600n<T>> it = this.f4192c.iterator();
        InterfaceC1677v<T> interfaceC1677v2 = interfaceC1677v;
        while (it.hasNext()) {
            InterfaceC1677v<T> mo3828a = it.next().mo3828a(context, interfaceC1677v2, i2, i3);
            if (interfaceC1677v2 != null && !interfaceC1677v2.equals(interfaceC1677v) && !interfaceC1677v2.equals(mo3828a)) {
                interfaceC1677v2.recycle();
            }
            interfaceC1677v2 = mo3828a;
        }
        return interfaceC1677v2;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (obj instanceof C1594h) {
            return this.f4192c.equals(((C1594h) obj).f4192c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return this.f4192c.hashCode();
    }

    public C1594h(@NonNull Collection<? extends InterfaceC1600n<T>> collection) {
        if (!collection.isEmpty()) {
            this.f4192c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        Iterator<? extends InterfaceC1600n<T>> it = this.f4192c.iterator();
        while (it.hasNext()) {
            it.next().mo3827a(messageDigest);
        }
    }
}
