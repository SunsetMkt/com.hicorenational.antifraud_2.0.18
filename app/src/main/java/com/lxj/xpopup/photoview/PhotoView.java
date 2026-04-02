package com.lxj.xpopup.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoView extends AppCompatImageView {
    public k a;

    /* JADX INFO: renamed from: b */
    private ImageView.ScaleType f5480b;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void init() {
        this.a = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f5480b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f5480b = null;
        }
    }

    public k getAttacher() {
        return this.a;
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.a.a(matrix);
    }

    public RectF getDisplayRect() {
        return this.a.a();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.a.b();
    }

    public float getMaximumScale() {
        return this.a.c();
    }

    public float getMediumScale() {
        return this.a.d();
    }

    public float getMinimumScale() {
        return this.a.e();
    }

    public float getScale() {
        return this.a.f();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.a.g();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.a.b(matrix);
    }

    public boolean isZoomable() {
        return this.a.i();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.a(z);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.a.c(matrix);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.a.j();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.a;
        if (kVar != null) {
            kVar.j();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        k kVar = this.a;
        if (kVar != null) {
            kVar.j();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.a;
        if (kVar != null) {
            kVar.j();
        }
    }

    public void setMaximumScale(float f2) {
        this.a.b(f2);
    }

    public void setMediumScale(float f2) {
        this.a.c(f2);
    }

    public void setMinimumScale(float f2) {
        this.a.d(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.a.setOnMatrixChangeListener(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.a.setOnOutsidePhotoTapListener(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.a.setOnPhotoTapListener(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.a.setOnScaleChangeListener(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.a.setOnSingleFlingListener(hVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.a.setOnViewDragListener(iVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.a.setOnViewTapListener(jVar);
    }

    public void setRotationBy(float f2) {
        this.a.e(f2);
    }

    public void setRotationTo(float f2) {
        this.a.f(f2);
    }

    public void setScale(float f2) {
        this.a.g(f2);
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        this.a.a(f2, f3, f4);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.a;
        if (kVar == null) {
            this.f5480b = scaleType;
        } else {
            kVar.a(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.a.c(matrix);
    }

    public void setZoomTransitionDuration(int i2) {
        this.a.a(i2);
    }

    public void setZoomable(boolean z) {
        this.a.b(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f2, boolean z) {
        this.a.a(f2, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.a.a(f2, f3, f4, z);
    }
}
