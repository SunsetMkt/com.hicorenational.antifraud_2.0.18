package com.luozm.captcha;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.luozm.captcha.PictureVertifyView;
import com.luozm.captcha.a;

/* JADX INFO: loaded from: classes2.dex */
public class Captcha extends LinearLayout {
    public static final int s = -100;
    public static final int t = 1;
    public static final int u = 2;
    private PictureVertifyView a;

    /* JADX INFO: renamed from: b */
    private TextSeekbar f5306b;

    /* JADX INFO: renamed from: c */
    private View f5307c;

    /* JADX INFO: renamed from: d */
    private View f5308d;

    /* JADX INFO: renamed from: e */
    private TextView f5309e;

    /* JADX INFO: renamed from: f */
    private TextView f5310f;

    /* JADX INFO: renamed from: g */
    private ImageView f5311g;

    /* JADX INFO: renamed from: h */
    private int f5312h;

    /* JADX INFO: renamed from: i */
    private int f5313i;

    /* JADX INFO: renamed from: j */
    private int f5314j;

    /* JADX INFO: renamed from: k */
    private int f5315k;

    /* JADX INFO: renamed from: l */
    private int f5316l;

    /* JADX INFO: renamed from: m */
    private int f5317m;

    /* JADX INFO: renamed from: n */
    private int f5318n;
    private boolean o;
    private boolean p;
    private f q;
    private com.luozm.captcha.a r;

    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (Captcha.this.p) {
                Captcha.this.p = false;
                if (i2 > 10) {
                    Captcha.this.o = false;
                } else {
                    Captcha.this.o = true;
                    Captcha.this.f5308d.setVisibility(8);
                    Captcha.this.a.a(0);
                }
            }
            if (Captcha.this.o) {
                Captcha.this.a.b(i2);
            } else {
                seekBar.setProgress(0);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Captcha.this.p = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (Captcha.this.o) {
                Captcha.this.a.b();
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Captcha.this.a(view);
        }
    }

    class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (Captcha.this.q != null) {
                Captcha.this.q.a(-100);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class e implements a.InterfaceC0099a {
        e() {
        }

        @Override // com.luozm.captcha.a.InterfaceC0099a
        public void a(Bitmap bitmap) {
            Captcha.this.setBitmap(bitmap);
        }
    }

    public interface f {
        String a();

        String a(int i2);

        String a(long j2);
    }

    public @interface g {
    }

    public Captcha(@NonNull Context context) {
        super(context);
        this.f5312h = -1;
    }

    public int getMaxFailedCount() {
        return this.f5316l;
    }

    public int getMode() {
        return this.f5315k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.luozm.captcha.a aVar = this.r;
        if (aVar != null && aVar.getStatus().equals(AsyncTask.Status.RUNNING)) {
            this.r.cancel(true);
        }
        super.onDetachedFromWindow();
    }

    public void setBitmap(int i2) {
        setBitmap(BitmapFactory.decodeResource(getResources(), i2));
    }

    public void setBlockSize(int i2) {
        this.a.c(i2);
    }

    public void setCaptchaListener(f fVar) {
        this.q = fVar;
    }

    public void setCaptchaStrategy(com.luozm.captcha.d dVar) {
        if (dVar != null) {
            this.a.a(dVar);
        }
    }

    public void setMaxFailedCount(int i2) {
        this.f5316l = i2;
    }

    public void setMode(@g int i2) {
        this.f5315k = i2;
        this.a.d(i2);
        if (this.f5315k == 2) {
            this.f5306b.setVisibility(8);
            this.a.a(true);
        } else {
            this.f5306b.setVisibility(0);
            this.f5306b.setEnabled(true);
        }
        b();
    }

    private void c() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.container, (ViewGroup) this, true);
        this.a = (PictureVertifyView) viewInflate.findViewById(R.id.vertifyView);
        this.f5306b = (TextSeekbar) viewInflate.findViewById(R.id.seekbar);
        this.f5307c = viewInflate.findViewById(R.id.accessRight);
        this.f5308d = viewInflate.findViewById(R.id.accessFailed);
        this.f5309e = (TextView) viewInflate.findViewById(R.id.accessText);
        this.f5310f = (TextView) viewInflate.findViewById(R.id.accessFailedText);
        this.f5311g = (ImageView) viewInflate.findViewById(R.id.refresh);
        setMode(this.f5315k);
        int i2 = this.f5312h;
        if (i2 != -1) {
            this.a.setImageResource(i2);
        }
        setBlockSize(this.f5318n);
        this.a.a(new a());
        a(this.f5313i, this.f5314j);
        this.f5306b.setOnSeekBarChangeListener(new b());
        this.f5311g.setOnClickListener(new c());
    }

    public Captcha(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b() {
        this.f5308d.setVisibility(8);
        this.f5307c.setVisibility(8);
    }

    public void setBitmap(Bitmap bitmap) {
        this.a.setImageBitmap(bitmap);
        a(false);
    }

    public Captcha(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f5312h = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Captcha);
        this.f5312h = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Captcha_src, R.drawable.container_backgroud);
        this.f5313i = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Captcha_progressDrawable, R.drawable.po_seekbar);
        this.f5314j = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Captcha_thumbDrawable, R.drawable.iv_tc_thumb);
        this.f5315k = typedArrayObtainStyledAttributes.getInteger(R.styleable.Captcha_mode, 1);
        this.f5316l = typedArrayObtainStyledAttributes.getInteger(R.styleable.Captcha_max_fail_count, 3);
        this.f5318n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Captcha_blockSize, com.luozm.captcha.c.a(getContext(), 50.0f));
        typedArrayObtainStyledAttributes.recycle();
        c();
    }

    public void a(View view) {
        view.animate().rotationBy(360.0f).setDuration(500L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new d());
    }

    public void setBitmap(String str) {
        this.r = new com.luozm.captcha.a(new e());
        this.r.execute(str);
    }

    class a implements PictureVertifyView.a {
        a() {
        }

        @Override // com.luozm.captcha.PictureVertifyView.a
        public void a(long j2) {
            if (Captcha.this.q != null) {
                String strA = Captcha.this.q.a(j2);
                if (strA != null) {
                    Captcha.this.f5309e.setText(strA);
                } else {
                    Captcha.this.f5309e.setText(String.format(Captcha.this.getResources().getString(R.string.vertify_access), Long.valueOf(j2)));
                }
            }
            Captcha.this.f5307c.setVisibility(0);
            Captcha.this.f5308d.setVisibility(8);
        }

        @Override // com.luozm.captcha.PictureVertifyView.a
        public void a() {
            Captcha.this.f5306b.setEnabled(false);
            Captcha.this.a.a(false);
            Captcha captcha = Captcha.this;
            captcha.f5317m = captcha.f5317m > Captcha.this.f5316l ? Captcha.this.f5316l : Captcha.this.f5317m + 1;
            Captcha.this.f5308d.setVisibility(0);
            Captcha.this.f5307c.setVisibility(8);
            if (Captcha.this.q != null) {
                if (Captcha.this.f5317m == Captcha.this.f5316l) {
                    String strA = Captcha.this.q.a();
                    if (strA != null) {
                        Captcha.this.f5310f.setText(strA);
                        return;
                    } else {
                        Captcha.this.f5310f.setText(String.format(Captcha.this.getResources().getString(R.string.vertify_failed), Integer.valueOf(Captcha.this.f5316l - Captcha.this.f5317m)));
                        return;
                    }
                }
                String strA2 = Captcha.this.q.a(Captcha.this.f5317m);
                if (strA2 != null) {
                    Captcha.this.f5310f.setText(strA2);
                } else {
                    Captcha.this.f5310f.setText(String.format(Captcha.this.getResources().getString(R.string.vertify_failed), Integer.valueOf(Captcha.this.f5316l - Captcha.this.f5317m)));
                }
            }
        }
    }

    public void a(@DrawableRes int i2, @DrawableRes int i3) {
        this.f5306b.setProgressDrawable(getResources().getDrawable(i2));
        this.f5306b.setThumb(getResources().getDrawable(i3));
        this.f5306b.setThumbOffset(0);
    }

    public void a() {
        a(this.f5311g);
    }

    public void a(boolean z) {
        b();
        this.a.c();
        if (z) {
            this.f5317m = 0;
        }
        if (this.f5315k == 1) {
            this.f5306b.setEnabled(true);
            this.f5306b.setProgress(0);
        } else {
            this.a.a(true);
        }
    }
}
