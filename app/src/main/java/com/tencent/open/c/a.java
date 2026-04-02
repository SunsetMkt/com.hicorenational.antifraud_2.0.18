package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class a extends RelativeLayout {
    private static final String a = a.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f6840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0119a f6842d;

    /* JADX INFO: renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ProGuard */
    public interface InterfaceC0119a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.f6840b = null;
        this.f6841c = false;
        this.f6842d = null;
        if (this.f6840b == null) {
            this.f6840b = new Rect();
        }
    }

    public void a(InterfaceC0119a interfaceC0119a) {
        this.f6842d = interfaceC0119a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f6840b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f6840b.top) - size;
        InterfaceC0119a interfaceC0119a = this.f6842d;
        if (interfaceC0119a != null && size != 0) {
            if (height > 100) {
                interfaceC0119a.a((Math.abs(this.f6840b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0119a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
