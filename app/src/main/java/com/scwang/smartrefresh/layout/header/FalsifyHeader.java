package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.C2851R;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2875i;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p192e.C2889b;

/* loaded from: classes.dex */
public class FalsifyHeader extends InternalAbstract implements InterfaceC2873g {

    /* renamed from: d */
    protected InterfaceC2875i f9205d;

    public FalsifyHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8715a(@NonNull InterfaceC2875i interfaceC2875i, int i2, int i3) {
        this.f9205d = interfaceC2875i;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: b */
    public void mo8719b(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        InterfaceC2875i interfaceC2875i = this.f9205d;
        if (interfaceC2875i != null) {
            interfaceC2875i.mo8693a(EnumC2879b.None);
            this.f9205d.mo8693a(EnumC2879b.RefreshFinish);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int m8735b = C2889b.m8735b(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-858993460);
            paint.setStrokeWidth(C2889b.m8735b(1.0f));
            float f2 = m8735b;
            paint.setPathEffect(new DashPathEffect(new float[]{f2, f2, f2, f2}, 1.0f));
            canvas.drawRect(f2, f2, getWidth() - m8735b, getBottom() - m8735b, paint);
            TextView textView = new TextView(getContext());
            textView.setText(getResources().getString(C2851R.string.srl_component_falsify, FalsifyHeader.class.getSimpleName(), Float.valueOf(C2889b.m8734b(getHeight()))));
            textView.setTextColor(-858993460);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
