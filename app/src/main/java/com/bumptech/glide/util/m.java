package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.e;
import com.bumptech.glide.r.l.o;
import java.util.Arrays;

/* JADX INFO: compiled from: ViewPreloadSizeProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class m<T> implements e.b<T>, o {
    private int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f3574b;

    /* JADX INFO: compiled from: ViewPreloadSizeProvider.java */
    static final class a extends com.bumptech.glide.r.l.f<View, Object> {
        a(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f<? super Object> fVar) {
        }

        @Override // com.bumptech.glide.r.l.f
        protected void d(@Nullable Drawable drawable) {
        }
    }

    public m() {
    }

    @Override // com.bumptech.glide.e.b
    @Nullable
    public int[] a(@NonNull T t, int i2, int i3) {
        int[] iArr = this.a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public m(@NonNull View view) {
        this.f3574b = new a(view);
        this.f3574b.b(this);
    }

    @Override // com.bumptech.glide.r.l.o
    public void a(int i2, int i3) {
        this.a = new int[]{i2, i3};
        this.f3574b = null;
    }

    public void a(@NonNull View view) {
        if (this.a == null && this.f3574b == null) {
            this.f3574b = new a(view);
            this.f3574b.b(this);
        }
    }
}
