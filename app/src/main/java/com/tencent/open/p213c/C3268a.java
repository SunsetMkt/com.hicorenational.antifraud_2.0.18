package com.tencent.open.p213c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.c.a */
/* loaded from: classes2.dex */
public class C3268a extends RelativeLayout {

    /* renamed from: a */
    private static final String f11203a = C3268a.class.getName();

    /* renamed from: b */
    private Rect f11204b;

    /* renamed from: c */
    private boolean f11205c;

    /* renamed from: d */
    private a f11206d;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.c.a$a */
    public interface a {
        /* renamed from: a */
        void mo10480a();

        /* renamed from: a */
        void mo10481a(int i2);
    }

    public C3268a(Context context) {
        super(context);
        this.f11204b = null;
        this.f11205c = false;
        this.f11206d = null;
        if (this.f11204b == null) {
            this.f11204b = new Rect();
        }
    }

    /* renamed from: a */
    public void m10479a(a aVar) {
        this.f11206d = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f11204b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f11204b.top) - size;
        a aVar = this.f11206d;
        if (aVar != null && size != 0) {
            if (height > 100) {
                aVar.mo10481a((Math.abs(this.f11204b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                aVar.mo10480a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
