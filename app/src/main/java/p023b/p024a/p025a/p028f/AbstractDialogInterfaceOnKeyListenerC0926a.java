package p023b.p024a.p025a.p028f;

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
import p023b.p024a.p025a.p029g.C0931d;
import p023b.p024a.p025a.p029g.C0932e;

/* compiled from: BasicPopup.java */
/* renamed from: b.a.a.f.a */
/* loaded from: classes.dex */
public abstract class AbstractDialogInterfaceOnKeyListenerC0926a<V extends View> implements DialogInterface.OnKeyListener, DialogInterface.OnDismissListener {

    /* renamed from: g */
    public static final int f1518g = -1;

    /* renamed from: h */
    public static final int f1519h = -2;

    /* renamed from: a */
    protected Activity f1520a;

    /* renamed from: b */
    protected int f1521b;

    /* renamed from: c */
    protected int f1522c;

    /* renamed from: d */
    private Dialog f1523d;

    /* renamed from: e */
    private FrameLayout f1524e;

    /* renamed from: f */
    private boolean f1525f = false;

    /* compiled from: BasicPopup.java */
    /* renamed from: b.a.a.f.a$a */
    class a implements DialogInterface.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ DialogInterface.OnDismissListener f1526a;

        a(DialogInterface.OnDismissListener onDismissListener) {
            this.f1526a = onDismissListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AbstractDialogInterfaceOnKeyListenerC0926a.this.onDismiss(dialogInterface);
            this.f1526a.onDismiss(dialogInterface);
        }
    }

    /* compiled from: BasicPopup.java */
    /* renamed from: b.a.a.f.a$b */
    class b implements DialogInterface.OnKeyListener {

        /* renamed from: a */
        final /* synthetic */ DialogInterface.OnKeyListener f1528a;

        b(DialogInterface.OnKeyListener onKeyListener) {
            this.f1528a = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            AbstractDialogInterfaceOnKeyListenerC0926a.this.onKey(dialogInterface, i2, keyEvent);
            return this.f1528a.onKey(dialogInterface, i2, keyEvent);
        }
    }

    public AbstractDialogInterfaceOnKeyListenerC0926a(Activity activity) {
        this.f1520a = activity;
        DisplayMetrics m1173c = C0932e.m1173c(activity);
        this.f1521b = m1173c.widthPixels;
        this.f1522c = m1173c.heightPixels;
        m1020o();
    }

    /* renamed from: o */
    private void m1020o() {
        this.f1524e = new FrameLayout(this.f1520a);
        this.f1524e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f1524e.setFocusable(true);
        this.f1524e.setFocusableInTouchMode(true);
        this.f1523d = new Dialog(this.f1520a);
        this.f1523d.setCanceledOnTouchOutside(true);
        this.f1523d.setCancelable(true);
        this.f1523d.setOnKeyListener(this);
        this.f1523d.setOnDismissListener(this);
        Window window = this.f1523d.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
            window.setContentView(this.f1524e);
        }
        m1023a(this.f1521b, -2);
    }

    /* renamed from: a */
    public void m1024a(View view) {
        this.f1524e.removeAllViews();
        this.f1524e.addView(view);
    }

    /* renamed from: b */
    public void m1027b(int i2) {
        Window window = this.f1523d.getWindow();
        if (window != null) {
            window.setGravity(i2);
        }
        if (i2 == 17) {
            m1033d((int) (this.f1521b * 0.7f));
        }
    }

    /* renamed from: b */
    protected void m1028b(V v) {
    }

    /* renamed from: c */
    public void m1031c(boolean z) {
        if (z) {
            m1023a(this.f1521b, (int) (this.f1522c * 0.85f));
        }
    }

    /* renamed from: d */
    public void m1034d(boolean z) {
        this.f1524e.setFitsSystemWindows(z);
    }

    /* renamed from: e */
    public void m1036e(boolean z) {
        if (z) {
            m1023a(this.f1521b, this.f1522c / 2);
        }
    }

    /* renamed from: f */
    public int m1037f() {
        return this.f1522c;
    }

    /* renamed from: g */
    public int m1039g() {
        return this.f1521b;
    }

    /* renamed from: h */
    public Window m1040h() {
        return this.f1523d.getWindow();
    }

    /* renamed from: i */
    public boolean m1041i() {
        return this.f1523d.isShowing();
    }

    /* renamed from: j */
    protected abstract V mo1042j();

    /* renamed from: k */
    public boolean m1043k() {
        m1021a();
        return false;
    }

    /* renamed from: l */
    protected void m1044l() {
    }

    /* renamed from: m */
    public final void m1045m() {
        if (this.f1525f) {
            this.f1523d.show();
            m1046n();
            return;
        }
        C0931d.m1156c(this, "do something before popup show");
        m1044l();
        V mo1042j = mo1042j();
        m1024a(mo1042j);
        m1028b((AbstractDialogInterfaceOnKeyListenerC0926a<V>) mo1042j);
        this.f1525f = true;
        this.f1523d.show();
        m1046n();
    }

    /* renamed from: n */
    protected void m1046n() {
        C0931d.m1156c(this, "popup show");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        m1021a();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i2 != 4) {
            return false;
        }
        m1043k();
        return false;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f1523d.setOnDismissListener(new a(onDismissListener));
        C0931d.m1156c(this, "popup setOnDismissListener");
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.f1523d.setOnKeyListener(new b(onKeyListener));
        C0931d.m1156c(this, "popup setOnKeyListener");
    }

    /* renamed from: c */
    public void m1030c(int i2) {
        m1023a(0, i2);
    }

    /* renamed from: d */
    public void m1033d(int i2) {
        m1023a(i2, 0);
    }

    /* renamed from: e */
    public ViewGroup m1035e() {
        return this.f1524e;
    }

    /* renamed from: f */
    public void m1038f(boolean z) {
        this.f1525f = z;
    }

    /* renamed from: a */
    public void m1022a(@StyleRes int i2) {
        Window window = this.f1523d.getWindow();
        if (window != null) {
            window.setWindowAnimations(i2);
        }
    }

    /* renamed from: c */
    public View mo1003c() {
        return this.f1524e.getChildAt(0);
    }

    /* renamed from: d */
    public Context m1032d() {
        return this.f1523d.getContext();
    }

    /* renamed from: b */
    public void m1029b(boolean z) {
        this.f1523d.setCanceledOnTouchOutside(z);
    }

    /* renamed from: a */
    public void m1025a(boolean z) {
        this.f1523d.setCancelable(z);
    }

    /* renamed from: b */
    protected final void m1026b() {
        this.f1523d.dismiss();
        C0931d.m1156c(this, "popup dismiss");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0013, code lost:
    
        if (r5 == 0) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1023a(int r4, int r5) {
        /*
            r3 = this;
            r0 = -1
            if (r4 != r0) goto L5
            int r4 = r3.f1521b
        L5:
            r0 = -2
            if (r4 != 0) goto Le
            if (r5 != 0) goto Le
            int r4 = r3.f1521b
        Lc:
            r5 = -2
            goto L16
        Le:
            if (r4 != 0) goto L13
            int r4 = r3.f1521b
            goto L16
        L13:
            if (r5 != 0) goto L16
            goto Lc
        L16:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0[r1] = r2
            r1 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r0[r1] = r2
            java.lang.String r1 = "will set popup width/height to: %s/%s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            p023b.p024a.p025a.p029g.C0931d.m1156c(r3, r0)
            android.widget.FrameLayout r0 = r3.f1524e
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 != 0) goto L3f
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r0.<init>(r4, r5)
            goto L43
        L3f:
            r0.width = r4
            r0.height = r5
        L43:
            android.widget.FrameLayout r4 = r3.f1524e
            r4.setLayoutParams(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p023b.p024a.p025a.p028f.AbstractDialogInterfaceOnKeyListenerC0926a.m1023a(int, int):void");
    }

    /* renamed from: a */
    public void m1021a() {
        m1026b();
    }
}
