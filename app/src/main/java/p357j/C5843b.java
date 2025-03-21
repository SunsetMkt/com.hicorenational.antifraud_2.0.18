package p357j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.bumptech.glide.C1584j;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p137r.C1829h;
import com.bumptech.glide.p137r.p138l.AbstractC1842j;
import com.bumptech.glide.p137r.p138l.C1835c;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/* compiled from: GlideEngine.java */
/* renamed from: j.b */
/* loaded from: classes2.dex */
public class C5843b implements ImageEngine {

    /* renamed from: b */
    private static C5843b f21100b;

    /* renamed from: a */
    AbstractC1822a f21101a;

    /* compiled from: GlideEngine.java */
    /* renamed from: j.b$a */
    class a extends AbstractC1842j<Bitmap> {

        /* renamed from: k */
        final /* synthetic */ OnImageCompleteCallback f21102k;

        /* renamed from: l */
        final /* synthetic */ SubsamplingScaleImageView f21103l;

        /* renamed from: m */
        final /* synthetic */ ImageView f21104m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ImageView imageView, OnImageCompleteCallback onImageCompleteCallback, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
            super(imageView);
            this.f21102k = onImageCompleteCallback;
            this.f21103l = subsamplingScaleImageView;
            this.f21104m = imageView2;
        }

        @Override // com.bumptech.glide.p137r.p138l.AbstractC1842j, com.bumptech.glide.p137r.p138l.AbstractC1850r, com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: b */
        public void mo3710b(@Nullable Drawable drawable) {
            super.mo3710b(drawable);
            OnImageCompleteCallback onImageCompleteCallback = this.f21102k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onShowLoading();
            }
        }

        @Override // com.bumptech.glide.p137r.p138l.AbstractC1842j, com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3706a(@Nullable Drawable drawable) {
            super.mo3706a(drawable);
            OnImageCompleteCallback onImageCompleteCallback = this.f21102k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.p137r.p138l.AbstractC1842j
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo4875a(@Nullable Bitmap bitmap) {
            OnImageCompleteCallback onImageCompleteCallback = this.f21102k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
            if (bitmap != null) {
                boolean isLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                this.f21103l.setVisibility(isLongImg ? 0 : 8);
                this.f21104m.setVisibility(isLongImg ? 8 : 0);
                if (isLongImg) {
                    this.f21103l.setQuickScaleEnabled(true);
                    this.f21103l.setZoomEnabled(true);
                    this.f21103l.setPanEnabled(true);
                    this.f21103l.setDoubleTapZoomDuration(100);
                    this.f21103l.setMinimumScaleType(2);
                    this.f21103l.setDoubleTapZoomDpi(2);
                    this.f21103l.setImage(ImageSource.bitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
                    return;
                }
                this.f21104m.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: GlideEngine.java */
    /* renamed from: j.b$b */
    class b extends AbstractC1842j<Bitmap> {

        /* renamed from: k */
        final /* synthetic */ SubsamplingScaleImageView f21106k;

        /* renamed from: l */
        final /* synthetic */ ImageView f21107l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
            super(imageView);
            this.f21106k = subsamplingScaleImageView;
            this.f21107l = imageView2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.p137r.p138l.AbstractC1842j
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo4875a(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                boolean isLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                this.f21106k.setVisibility(isLongImg ? 0 : 8);
                this.f21107l.setVisibility(isLongImg ? 8 : 0);
                if (!isLongImg) {
                    this.f21107l.setImageBitmap(bitmap);
                    return;
                }
                this.f21106k.setQuickScaleEnabled(true);
                this.f21106k.setZoomEnabled(true);
                this.f21106k.setPanEnabled(true);
                this.f21106k.setDoubleTapZoomDuration(100);
                this.f21106k.setMinimumScaleType(2);
                this.f21106k.setDoubleTapZoomDpi(2);
                this.f21106k.setImage(ImageSource.bitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
            }
        }
    }

    /* compiled from: GlideEngine.java */
    /* renamed from: j.b$c */
    class c extends C1835c {

        /* renamed from: k */
        final /* synthetic */ Context f21109k;

        /* renamed from: l */
        final /* synthetic */ ImageView f21110l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ImageView imageView, Context context, ImageView imageView2) {
            super(imageView);
            this.f21109k = context;
            this.f21110l = imageView2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.p137r.p138l.C1835c, com.bumptech.glide.p137r.p138l.AbstractC1842j
        /* renamed from: a */
        public void mo4875a(Bitmap bitmap) {
            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.f21109k.getResources(), bitmap);
            create.setCornerRadius(8.0f);
            this.f21110l.setImageDrawable(create);
        }
    }

    private C5843b() {
    }

    /* renamed from: a */
    public static C5843b m24586a() {
        if (f21100b == null) {
            synchronized (C5843b.class) {
                if (f21100b == null) {
                    f21100b = new C5843b();
                }
            }
        }
        return f21100b;
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadAsGifImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        ComponentCallbacks2C1576b.m3649e(context).m3794e().mo3719a(str).m3768a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadFolderImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        ComponentCallbacks2C1576b.m3649e(context).m3786b().m4742a(180, 180).mo3719a(str).m4761b().m4740a(0.5f).mo3763a((AbstractC1822a<?>) new C1829h().m4777e(C2113R.drawable.picture_image_placeholder)).m3773b((C1584j) new c(imageView, context, imageView));
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadGridImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        if (this.f21101a == null) {
            this.f21101a = new C1829h().m4777e(C2113R.drawable.picture_image_placeholder);
        }
        ComponentCallbacks2C1576b.m3649e(context).mo3719a(str).m4742a(200, 200).m4761b().mo3763a(this.f21101a).m3768a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        ComponentCallbacks2C1576b.m3649e(context).mo3719a(str).m3768a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, OnImageCompleteCallback onImageCompleteCallback) {
        ComponentCallbacks2C1576b.m3649e(context).m3786b().mo3719a(str).m3773b((C1584j<Bitmap>) new a(imageView, onImageCompleteCallback, subsamplingScaleImageView, imageView));
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView) {
        ComponentCallbacks2C1576b.m3649e(context).m3786b().mo3719a(str).m3773b((C1584j<Bitmap>) new b(imageView, subsamplingScaleImageView, imageView));
    }
}
