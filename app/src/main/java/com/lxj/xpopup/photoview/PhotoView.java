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

/* loaded from: classes.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: a */
    public ViewOnTouchListenerC2839k f8805a;

    /* renamed from: b */
    private ImageView.ScaleType f8806b;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f8805a = new ViewOnTouchListenerC2839k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f8806b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f8806b = null;
        }
    }

    public ViewOnTouchListenerC2839k getAttacher() {
        return this.f8805a;
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.f8805a.m8557a(matrix);
    }

    public RectF getDisplayRect() {
        return this.f8805a.m8551a();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f8805a.m8561b();
    }

    public float getMaximumScale() {
        return this.f8805a.m8565c();
    }

    public float getMediumScale() {
        return this.f8805a.m8568d();
    }

    public float getMinimumScale() {
        return this.f8805a.m8570e();
    }

    public float getScale() {
        return this.f8805a.m8572f();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f8805a.m8574g();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.f8805a.m8563b(matrix);
    }

    public boolean isZoomable() {
        return this.f8805a.m8577i();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f8805a.m8560a(z);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.f8805a.m8567c(matrix);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.f8805a.m8578j();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ViewOnTouchListenerC2839k viewOnTouchListenerC2839k = this.f8805a;
        if (viewOnTouchListenerC2839k != null) {
            viewOnTouchListenerC2839k.m8578j();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        ViewOnTouchListenerC2839k viewOnTouchListenerC2839k = this.f8805a;
        if (viewOnTouchListenerC2839k != null) {
            viewOnTouchListenerC2839k.m8578j();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        ViewOnTouchListenerC2839k viewOnTouchListenerC2839k = this.f8805a;
        if (viewOnTouchListenerC2839k != null) {
            viewOnTouchListenerC2839k.m8578j();
        }
    }

    public void setMaximumScale(float f2) {
        this.f8805a.m8562b(f2);
    }

    public void setMediumScale(float f2) {
        this.f8805a.m8566c(f2);
    }

    public void setMinimumScale(float f2) {
        this.f8805a.m8569d(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8805a.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f8805a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8805a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(InterfaceC2832d interfaceC2832d) {
        this.f8805a.setOnMatrixChangeListener(interfaceC2832d);
    }

    public void setOnOutsidePhotoTapListener(InterfaceC2833e interfaceC2833e) {
        this.f8805a.setOnOutsidePhotoTapListener(interfaceC2833e);
    }

    public void setOnPhotoTapListener(InterfaceC2834f interfaceC2834f) {
        this.f8805a.setOnPhotoTapListener(interfaceC2834f);
    }

    public void setOnScaleChangeListener(InterfaceC2835g interfaceC2835g) {
        this.f8805a.setOnScaleChangeListener(interfaceC2835g);
    }

    public void setOnSingleFlingListener(InterfaceC2836h interfaceC2836h) {
        this.f8805a.setOnSingleFlingListener(interfaceC2836h);
    }

    public void setOnViewDragListener(InterfaceC2837i interfaceC2837i) {
        this.f8805a.setOnViewDragListener(interfaceC2837i);
    }

    public void setOnViewTapListener(InterfaceC2838j interfaceC2838j) {
        this.f8805a.setOnViewTapListener(interfaceC2838j);
    }

    public void setRotationBy(float f2) {
        this.f8805a.m8571e(f2);
    }

    public void setRotationTo(float f2) {
        this.f8805a.m8573f(f2);
    }

    public void setScale(float f2) {
        this.f8805a.m8575g(f2);
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        this.f8805a.m8553a(f2, f3, f4);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        ViewOnTouchListenerC2839k viewOnTouchListenerC2839k = this.f8805a;
        if (viewOnTouchListenerC2839k == null) {
            this.f8806b = scaleType;
        } else {
            viewOnTouchListenerC2839k.m8559a(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.f8805a.m8567c(matrix);
    }

    public void setZoomTransitionDuration(int i2) {
        this.f8805a.m8556a(i2);
    }

    public void setZoomable(boolean z) {
        this.f8805a.m8564b(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f2, boolean z) {
        this.f8805a.m8555a(f2, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.f8805a.m8554a(f2, f3, f4, z);
    }
}
