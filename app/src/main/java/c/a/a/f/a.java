package c.a.a.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.StyleRes;
import c.a.a.g.d;
import c.a.a.g.e;

/* JADX INFO: compiled from: BasicPopup.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<V extends View> implements DialogInterface.OnKeyListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1941g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1942h = -2;
    protected Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f1943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f1944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Dialog f1945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f1946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1947f = false;

    /* JADX INFO: renamed from: c.a.a.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicPopup.java */
    class DialogInterfaceOnDismissListenerC0029a implements DialogInterface.OnDismissListener {
        final /* synthetic */ DialogInterface.OnDismissListener a;

        DialogInterfaceOnDismissListenerC0029a(DialogInterface.OnDismissListener onDismissListener) {
            this.a = onDismissListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.onDismiss(dialogInterface);
            this.a.onDismiss(dialogInterface);
        }
    }

    /* JADX INFO: compiled from: BasicPopup.java */
    class b implements DialogInterface.OnKeyListener {
        final /* synthetic */ DialogInterface.OnKeyListener a;

        b(DialogInterface.OnKeyListener onKeyListener) {
            this.a = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            a.this.onKey(dialogInterface, i2, keyEvent);
            return this.a.onKey(dialogInterface, i2, keyEvent);
        }
    }

    public a(Activity activity) {
        this.a = activity;
        DisplayMetrics displayMetricsC = e.c(activity);
        this.f1943b = displayMetricsC.widthPixels;
        this.f1944c = displayMetricsC.heightPixels;
        o();
    }

    private void o() {
        this.f1946e = new FrameLayout(this.a);
        this.f1946e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f1946e.setFocusable(true);
        this.f1946e.setFocusableInTouchMode(true);
        this.f1945d = new Dialog(this.a);
        this.f1945d.setCanceledOnTouchOutside(true);
        this.f1945d.setCancelable(true);
        this.f1945d.setOnKeyListener(this);
        this.f1945d.setOnDismissListener(this);
        Window window = this.f1945d.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
            window.setContentView(this.f1946e);
        }
        a(this.f1943b, -2);
    }

    public void a(View view) {
        this.f1946e.removeAllViews();
        this.f1946e.addView(view);
    }

    public void b(int i2) {
        Window window = this.f1945d.getWindow();
        if (window != null) {
            window.setGravity(i2);
        }
        if (i2 == 17) {
            d((int) (this.f1943b * 0.7f));
        }
    }

    protected void b(V v) {
    }

    public void c(boolean z) {
        if (z) {
            a(this.f1943b, (int) (this.f1944c * 0.85f));
        }
    }

    public void d(boolean z) {
        this.f1946e.setFitsSystemWindows(z);
    }

    public void e(boolean z) {
        if (z) {
            a(this.f1943b, this.f1944c / 2);
        }
    }

    public int f() {
        return this.f1944c;
    }

    public int g() {
        return this.f1943b;
    }

    public Window h() {
        return this.f1945d.getWindow();
    }

    public boolean i() {
        return this.f1945d.isShowing();
    }

    protected abstract V j();

    public boolean k() {
        a();
        return false;
    }

    protected void l() {
    }

    public final void m() {
        if (this.f1947f) {
            this.f1945d.show();
            n();
            return;
        }
        d.c(this, "do something before popup show");
        l();
        View viewJ = j();
        a(viewJ);
        b(viewJ);
        this.f1947f = true;
        this.f1945d.show();
        n();
    }

    protected void n() {
        d.c(this, "popup show");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i2 != 4) {
            return false;
        }
        k();
        return false;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f1945d.setOnDismissListener(new DialogInterfaceOnDismissListenerC0029a(onDismissListener));
        d.c(this, "popup setOnDismissListener");
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.f1945d.setOnKeyListener(new b(onKeyListener));
        d.c(this, "popup setOnKeyListener");
    }

    public void c(int i2) {
        a(0, i2);
    }

    public void d(int i2) {
        a(i2, 0);
    }

    public ViewGroup e() {
        return this.f1946e;
    }

    public void f(boolean z) {
        this.f1947f = z;
    }

    public void a(@StyleRes int i2) {
        Window window = this.f1945d.getWindow();
        if (window != null) {
            window.setWindowAnimations(i2);
        }
    }

    public View c() {
        return this.f1946e.getChildAt(0);
    }

    public Context d() {
        return this.f1945d.getContext();
    }

    public void b(boolean z) {
        this.f1945d.setCanceledOnTouchOutside(z);
    }

    public void a(boolean z) {
        this.f1945d.setCancelable(z);
    }

    protected final void b() {
        this.f1945d.dismiss();
        d.c(this, "popup dismiss");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (i2 == -1) {
            i2 = this.f1943b;
        }
        if (i2 == 0 && i3 == 0) {
            i2 = this.f1943b;
        } else {
            if (i2 == 0) {
                i2 = this.f1943b;
            } else if (i3 == 0) {
            }
            d.c(this, String.format("will set popup width/height to: %s/%s", Integer.valueOf(i2), Integer.valueOf(i3)));
            layoutParams = this.f1946e.getLayoutParams();
            if (layoutParams != null) {
                layoutParams = new ViewGroup.LayoutParams(i2, i3);
            } else {
                layoutParams.width = i2;
                layoutParams.height = i3;
            }
            this.f1946e.setLayoutParams(layoutParams);
        }
        i3 = -2;
        d.c(this, String.format("will set popup width/height to: %s/%s", Integer.valueOf(i2), Integer.valueOf(i3)));
        layoutParams = this.f1946e.getLayoutParams();
        if (layoutParams != null) {
        }
        this.f1946e.setLayoutParams(layoutParams);
    }

    public void a() {
        b();
    }
}
