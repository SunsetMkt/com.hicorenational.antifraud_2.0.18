package p388ui.view;

import android.content.Context;
import android.view.View;
import util.C7301n1;

/* loaded from: classes2.dex */
public class SoftInputListenerView extends View {

    /* renamed from: b */
    private static final String f24681b = "SoftInputListenerView";

    /* renamed from: a */
    private InterfaceC7197a f24682a;

    /* renamed from: ui.view.SoftInputListenerView$a */
    public interface InterfaceC7197a {
        /* renamed from: a */
        void m25845a(int i2, int i3, int i4, int i5);
    }

    public SoftInputListenerView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        C7301n1.m26454a(f24681b, "onSizeChanged() called with: w = [" + i2 + "], h = [" + i3 + "], oldw = [" + i4 + "], oldh = [" + i5 + "]");
        InterfaceC7197a interfaceC7197a = this.f24682a;
        if (interfaceC7197a != null) {
            interfaceC7197a.m25845a(i2, i3, i4, i5);
        }
    }

    public void setOnSoftInputStateChangeListener(InterfaceC7197a interfaceC7197a) {
        this.f24682a = interfaceC7197a;
    }
}
