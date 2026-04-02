package ui.view;

import android.content.Context;
import android.view.View;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class SoftInputListenerView extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14636b = "SoftInputListenerView";
    private a a;

    public interface a {
        void a(int i2, int i3, int i4, int i5);
    }

    public SoftInputListenerView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        s1.a(f14636b, "onSizeChanged() called with: w = [" + i2 + "], h = [" + i3 + "], oldw = [" + i4 + "], oldh = [" + i5 + "]");
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i2, i3, i4, i5);
        }
    }

    public void setOnSoftInputStateChangeListener(a aVar) {
        this.a = aVar;
    }
}
