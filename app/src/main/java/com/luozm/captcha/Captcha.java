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
import com.luozm.captcha.AsyncTaskC2740a;
import com.luozm.captcha.PictureVertifyView;

/* loaded from: classes.dex */
public class Captcha extends LinearLayout {

    /* renamed from: s */
    public static final int f8414s = -100;

    /* renamed from: t */
    public static final int f8415t = 1;

    /* renamed from: u */
    public static final int f8416u = 2;

    /* renamed from: a */
    private PictureVertifyView f8417a;

    /* renamed from: b */
    private TextSeekbar f8418b;

    /* renamed from: c */
    private View f8419c;

    /* renamed from: d */
    private View f8420d;

    /* renamed from: e */
    private TextView f8421e;

    /* renamed from: f */
    private TextView f8422f;

    /* renamed from: g */
    private ImageView f8423g;

    /* renamed from: h */
    private int f8424h;

    /* renamed from: i */
    private int f8425i;

    /* renamed from: j */
    private int f8426j;

    /* renamed from: k */
    private int f8427k;

    /* renamed from: l */
    private int f8428l;

    /* renamed from: m */
    private int f8429m;

    /* renamed from: n */
    private int f8430n;

    /* renamed from: o */
    private boolean f8431o;

    /* renamed from: p */
    private boolean f8432p;

    /* renamed from: q */
    private InterfaceC2736f f8433q;

    /* renamed from: r */
    private AsyncTaskC2740a f8434r;

    /* renamed from: com.luozm.captcha.Captcha$b */
    class C2732b implements SeekBar.OnSeekBarChangeListener {
        C2732b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (Captcha.this.f8432p) {
                Captcha.this.f8432p = false;
                if (i2 > 10) {
                    Captcha.this.f8431o = false;
                } else {
                    Captcha.this.f8431o = true;
                    Captcha.this.f8420d.setVisibility(8);
                    Captcha.this.f8417a.m8178a(0);
                }
            }
            if (Captcha.this.f8431o) {
                Captcha.this.f8417a.m8185b(i2);
            } else {
                seekBar.setProgress(0);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Captcha.this.f8432p = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (Captcha.this.f8431o) {
                Captcha.this.f8417a.m8183b();
            }
        }
    }

    /* renamed from: com.luozm.captcha.Captcha$c */
    class ViewOnClickListenerC2733c implements View.OnClickListener {
        ViewOnClickListenerC2733c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Captcha.this.m8147a(view);
        }
    }

    /* renamed from: com.luozm.captcha.Captcha$d */
    class C2734d implements Animator.AnimatorListener {
        C2734d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (Captcha.this.f8433q != null) {
                Captcha.this.f8433q.mo8170a(-100);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.luozm.captcha.Captcha$e */
    class C2735e implements AsyncTaskC2740a.a {
        C2735e() {
        }

        @Override // com.luozm.captcha.AsyncTaskC2740a.a
        /* renamed from: a */
        public void mo8168a(Bitmap bitmap) {
            Captcha.this.setBitmap(bitmap);
        }
    }

    /* renamed from: com.luozm.captcha.Captcha$f */
    public interface InterfaceC2736f {
        /* renamed from: a */
        String mo8169a();

        /* renamed from: a */
        String mo8170a(int i2);

        /* renamed from: a */
        String mo8171a(long j2);
    }

    /* renamed from: com.luozm.captcha.Captcha$g */
    public @interface InterfaceC2737g {
    }

    public Captcha(@NonNull Context context) {
        super(context);
        this.f8424h = -1;
    }

    public int getMaxFailedCount() {
        return this.f8428l;
    }

    public int getMode() {
        return this.f8427k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AsyncTaskC2740a asyncTaskC2740a = this.f8434r;
        if (asyncTaskC2740a != null && asyncTaskC2740a.getStatus().equals(AsyncTask.Status.RUNNING)) {
            this.f8434r.cancel(true);
        }
        super.onDetachedFromWindow();
    }

    public void setBitmap(int i2) {
        setBitmap(BitmapFactory.decodeResource(getResources(), i2));
    }

    public void setBlockSize(int i2) {
        this.f8417a.m8187c(i2);
    }

    public void setCaptchaListener(InterfaceC2736f interfaceC2736f) {
        this.f8433q = interfaceC2736f;
    }

    public void setCaptchaStrategy(AbstractC2743d abstractC2743d) {
        if (abstractC2743d != null) {
            this.f8417a.m8181a(abstractC2743d);
        }
    }

    public void setMaxFailedCount(int i2) {
        this.f8428l = i2;
    }

    public void setMode(@InterfaceC2737g int i2) {
        this.f8427k = i2;
        this.f8417a.m8189d(i2);
        if (this.f8427k == 2) {
            this.f8418b.setVisibility(8);
            this.f8417a.m8182a(true);
        } else {
            this.f8418b.setVisibility(0);
            this.f8418b.setEnabled(true);
        }
        m8165b();
    }

    /* renamed from: c */
    private void m8152c() {
        View inflate = LayoutInflater.from(getContext()).inflate(C2739R.layout.container, (ViewGroup) this, true);
        this.f8417a = (PictureVertifyView) inflate.findViewById(C2739R.id.vertifyView);
        this.f8418b = (TextSeekbar) inflate.findViewById(C2739R.id.seekbar);
        this.f8419c = inflate.findViewById(C2739R.id.accessRight);
        this.f8420d = inflate.findViewById(C2739R.id.accessFailed);
        this.f8421e = (TextView) inflate.findViewById(C2739R.id.accessText);
        this.f8422f = (TextView) inflate.findViewById(C2739R.id.accessFailedText);
        this.f8423g = (ImageView) inflate.findViewById(C2739R.id.refresh);
        setMode(this.f8427k);
        int i2 = this.f8424h;
        if (i2 != -1) {
            this.f8417a.setImageResource(i2);
        }
        setBlockSize(this.f8430n);
        this.f8417a.m8180a(new C2731a());
        m8163a(this.f8425i, this.f8426j);
        this.f8418b.setOnSeekBarChangeListener(new C2732b());
        this.f8423g.setOnClickListener(new ViewOnClickListenerC2733c());
    }

    public Captcha(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    public void m8165b() {
        this.f8420d.setVisibility(8);
        this.f8419c.setVisibility(8);
    }

    public void setBitmap(Bitmap bitmap) {
        this.f8417a.setImageBitmap(bitmap);
        m8164a(false);
    }

    public Captcha(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f8424h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2739R.styleable.Captcha);
        this.f8424h = obtainStyledAttributes.getResourceId(C2739R.styleable.Captcha_src, C2739R.drawable.container_backgroud);
        this.f8425i = obtainStyledAttributes.getResourceId(C2739R.styleable.Captcha_progressDrawable, C2739R.drawable.po_seekbar);
        this.f8426j = obtainStyledAttributes.getResourceId(C2739R.styleable.Captcha_thumbDrawable, C2739R.drawable.iv_tc_thumb);
        this.f8427k = obtainStyledAttributes.getInteger(C2739R.styleable.Captcha_mode, 1);
        this.f8428l = obtainStyledAttributes.getInteger(C2739R.styleable.Captcha_max_fail_count, 3);
        this.f8430n = obtainStyledAttributes.getDimensionPixelSize(C2739R.styleable.Captcha_blockSize, C2742c.m8192a(getContext(), 50.0f));
        obtainStyledAttributes.recycle();
        m8152c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8147a(View view) {
        view.animate().rotationBy(360.0f).setDuration(500L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new C2734d());
    }

    public void setBitmap(String str) {
        this.f8434r = new AsyncTaskC2740a(new C2735e());
        this.f8434r.execute(str);
    }

    /* renamed from: com.luozm.captcha.Captcha$a */
    class C2731a implements PictureVertifyView.InterfaceC2738a {
        C2731a() {
        }

        @Override // com.luozm.captcha.PictureVertifyView.InterfaceC2738a
        /* renamed from: a */
        public void mo8167a(long j2) {
            if (Captcha.this.f8433q != null) {
                String mo8171a = Captcha.this.f8433q.mo8171a(j2);
                if (mo8171a != null) {
                    Captcha.this.f8421e.setText(mo8171a);
                } else {
                    Captcha.this.f8421e.setText(String.format(Captcha.this.getResources().getString(C2739R.string.vertify_access), Long.valueOf(j2)));
                }
            }
            Captcha.this.f8419c.setVisibility(0);
            Captcha.this.f8420d.setVisibility(8);
        }

        @Override // com.luozm.captcha.PictureVertifyView.InterfaceC2738a
        /* renamed from: a */
        public void mo8166a() {
            Captcha.this.f8418b.setEnabled(false);
            Captcha.this.f8417a.m8182a(false);
            Captcha captcha = Captcha.this;
            captcha.f8429m = captcha.f8429m > Captcha.this.f8428l ? Captcha.this.f8428l : Captcha.this.f8429m + 1;
            Captcha.this.f8420d.setVisibility(0);
            Captcha.this.f8419c.setVisibility(8);
            if (Captcha.this.f8433q != null) {
                if (Captcha.this.f8429m == Captcha.this.f8428l) {
                    String mo8169a = Captcha.this.f8433q.mo8169a();
                    if (mo8169a != null) {
                        Captcha.this.f8422f.setText(mo8169a);
                        return;
                    } else {
                        Captcha.this.f8422f.setText(String.format(Captcha.this.getResources().getString(C2739R.string.vertify_failed), Integer.valueOf(Captcha.this.f8428l - Captcha.this.f8429m)));
                        return;
                    }
                }
                String mo8170a = Captcha.this.f8433q.mo8170a(Captcha.this.f8429m);
                if (mo8170a != null) {
                    Captcha.this.f8422f.setText(mo8170a);
                } else {
                    Captcha.this.f8422f.setText(String.format(Captcha.this.getResources().getString(C2739R.string.vertify_failed), Integer.valueOf(Captcha.this.f8428l - Captcha.this.f8429m)));
                }
            }
        }
    }

    /* renamed from: a */
    public void m8163a(@DrawableRes int i2, @DrawableRes int i3) {
        this.f8418b.setProgressDrawable(getResources().getDrawable(i2));
        this.f8418b.setThumb(getResources().getDrawable(i3));
        this.f8418b.setThumbOffset(0);
    }

    /* renamed from: a */
    public void m8162a() {
        m8147a(this.f8423g);
    }

    /* renamed from: a */
    public void m8164a(boolean z) {
        m8165b();
        this.f8417a.m8186c();
        if (z) {
            this.f8429m = 0;
        }
        if (this.f8427k == 1) {
            this.f8418b.setEnabled(true);
            this.f8418b.setProgress(0);
        } else {
            this.f8417a.m8182a(true);
        }
    }
}
