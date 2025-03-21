package p388ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class MyScrollView extends ScrollView {

    /* renamed from: a */
    private InterfaceC7185a f24591a;

    /* renamed from: ui.view.MyScrollView$a */
    public interface InterfaceC7185a {
        /* renamed from: a */
        void m25803a(int i2);
    }

    public MyScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        InterfaceC7185a interfaceC7185a = this.f24591a;
        if (interfaceC7185a != null) {
            interfaceC7185a.m25803a(i3);
        }
    }

    public void setOnScrollListener(InterfaceC7185a interfaceC7185a) {
        this.f24591a = interfaceC7185a;
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
