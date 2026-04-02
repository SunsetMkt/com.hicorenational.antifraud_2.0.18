package com.bumptech.glide.r.m;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.r.m.f;

/* JADX INFO: compiled from: BitmapContainerTransitionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<R> implements g<R> {
    private final g<Drawable> a;

    /* JADX INFO: renamed from: com.bumptech.glide.r.m.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BitmapContainerTransitionFactory.java */
    private final class C0065a implements f<R> {
        private final f<Drawable> a;

        C0065a(f<Drawable> fVar) {
            this.a = fVar;
        }

        @Override // com.bumptech.glide.r.m.f
        public boolean a(R r, f.a aVar) {
            return this.a.a(new BitmapDrawable(aVar.getView().getResources(), a.this.a(r)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.a = gVar;
    }

    protected abstract Bitmap a(R r);

    @Override // com.bumptech.glide.r.m.g
    public f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        return new C0065a(this.a.a(aVar, z));
    }
}
