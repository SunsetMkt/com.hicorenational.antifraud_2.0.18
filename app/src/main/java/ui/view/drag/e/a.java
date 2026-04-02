package ui.view.drag.e;

import android.content.Context;

/* JADX INFO: compiled from: ICarrier.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void a();

    void a(int i2, int i3, int i4, int i5);

    Context getContext();

    boolean post(Runnable runnable);

    boolean removeCallbacks(Runnable runnable);
}
