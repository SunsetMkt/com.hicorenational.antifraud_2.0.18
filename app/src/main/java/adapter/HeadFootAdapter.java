package adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class HeadFootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1126b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f1127c = 2;

    public abstract View a();

    public abstract View b();

    public abstract int c();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (b() == null && a() == null) ? c() : (b() != null || a() == null) ? (b() == null || a() != null) ? c() + 2 : c() + 1 : c() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (b() == null || i2 != 0) {
            return (a() == null || i2 != getItemCount() - 1) ? 2 : 1;
        }
        return 0;
    }
}
