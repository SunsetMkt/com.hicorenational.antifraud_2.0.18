package k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.bumptech.glide.r.h;
import com.bumptech.glide.r.l.j;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/* JADX INFO: compiled from: GlideEngine.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements ImageEngine {

    /* JADX INFO: renamed from: b */
    private static b f12638b;
    com.bumptech.glide.r.a a;

    /* JADX INFO: compiled from: GlideEngine.java */
    class a extends j<Bitmap> {

        /* JADX INFO: renamed from: k */
        final /* synthetic */ OnImageCompleteCallback f12639k;

        /* JADX INFO: renamed from: l */
        final /* synthetic */ SubsamplingScaleImageView f12640l;

        /* JADX INFO: renamed from: m */
        final /* synthetic */ ImageView f12641m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ImageView imageView, OnImageCompleteCallback onImageCompleteCallback, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
            super(imageView);
            this.f12639k = onImageCompleteCallback;
            this.f12640l = subsamplingScaleImageView;
            this.f12641m = imageView2;
        }

        @Override // com.bumptech.glide.r.l.j, com.bumptech.glide.r.l.r, com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
        public void b(@Nullable Drawable drawable) {
            super.b(drawable);
            OnImageCompleteCallback onImageCompleteCallback = this.f12639k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onShowLoading();
            }
        }

        @Override // com.bumptech.glide.r.l.j, com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
        public void a(@Nullable Drawable drawable) {
            super.a(drawable);
            OnImageCompleteCallback onImageCompleteCallback = this.f12639k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
        }

        @Override // com.bumptech.glide.r.l.j
        public void a(@Nullable Bitmap bitmap) {
            OnImageCompleteCallback onImageCompleteCallback = this.f12639k;
            if (onImageCompleteCallback != null) {
                onImageCompleteCallback.onHideLoading();
            }
            if (bitmap != null) {
                boolean zIsLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                this.f12640l.setVisibility(zIsLongImg ? 0 : 8);
                this.f12641m.setVisibility(zIsLongImg ? 8 : 0);
                if (zIsLongImg) {
                    this.f12640l.setQuickScaleEnabled(true);
                    this.f12640l.setZoomEnabled(true);
                    this.f12640l.setPanEnabled(true);
                    this.f12640l.setDoubleTapZoomDuration(100);
                    this.f12640l.setMinimumScaleType(2);
                    this.f12640l.setDoubleTapZoomDpi(2);
                    this.f12640l.setImage(ImageSource.bitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
                    return;
                }
                this.f12641m.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: k.b$b */
    /* JADX INFO: compiled from: GlideEngine.java */
    class C0264b extends j<Bitmap> {

        /* JADX INFO: renamed from: k */
        final /* synthetic */ SubsamplingScaleImageView f12643k;

        /* JADX INFO: renamed from: l */
        final /* synthetic */ ImageView f12644l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0264b(ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
            super(imageView);
            this.f12643k = subsamplingScaleImageView;
            this.f12644l = imageView2;
        }

        @Override // com.bumptech.glide.r.l.j
        public void a(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                boolean zIsLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                this.f12643k.setVisibility(zIsLongImg ? 0 : 8);
                this.f12644l.setVisibility(zIsLongImg ? 8 : 0);
                if (!zIsLongImg) {
                    this.f12644l.setImageBitmap(bitmap);
                    return;
                }
                this.f12643k.setQuickScaleEnabled(true);
                this.f12643k.setZoomEnabled(true);
                this.f12643k.setPanEnabled(true);
                this.f12643k.setDoubleTapZoomDuration(100);
                this.f12643k.setMinimumScaleType(2);
                this.f12643k.setDoubleTapZoomDpi(2);
                this.f12643k.setImage(ImageSource.bitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
            }
        }
    }

    /* JADX INFO: compiled from: GlideEngine.java */
    class c extends com.bumptech.glide.r.l.c {

        /* JADX INFO: renamed from: k */
        final /* synthetic */ Context f12646k;

        /* JADX INFO: renamed from: l */
        final /* synthetic */ ImageView f12647l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ImageView imageView, Context context, ImageView imageView2) {
            super(imageView);
            this.f12646k = context;
            this.f12647l = imageView2;
        }

        @Override // com.bumptech.glide.r.l.c, com.bumptech.glide.r.l.j
        public void a(Bitmap bitmap) {
            RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(this.f12646k.getResources(), bitmap);
            roundedBitmapDrawableCreate.setCornerRadius(8.0f);
            this.f12647l.setImageDrawable(roundedBitmapDrawableCreate);
        }
    }

    private b() {
    }

    public static b a() {
        if (f12638b == null) {
            synchronized (b.class) {
                if (f12638b == null) {
                    f12638b = new b();
                }
            }
        }
        return f12638b;
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadAsGifImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        com.bumptech.glide.b.e(context).e().a(str).a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadFolderImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        com.bumptech.glide.b.e(context).b().a(180, 180).a(str).b().a(0.5f).a((com.bumptech.glide.r.a<?>) new h().e(R.drawable.picture_image_placeholder)).b(new c(imageView, context, imageView));
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadGridImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        if (this.a == null) {
            this.a = new h().e(R.drawable.picture_image_placeholder);
        }
        com.bumptech.glide.b.e(context).a(str).a(200, 200).b().a(this.a).a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView) {
        com.bumptech.glide.b.e(context).a(str).a(imageView);
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, OnImageCompleteCallback onImageCompleteCallback) {
        com.bumptech.glide.b.e(context).b().a(str).b(new a(imageView, onImageCompleteCallback, subsamplingScaleImageView, imageView));
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView) {
        com.bumptech.glide.b.e(context).b().a(str).b(new C0264b(imageView, subsamplingScaleImageView, imageView));
    }
}
