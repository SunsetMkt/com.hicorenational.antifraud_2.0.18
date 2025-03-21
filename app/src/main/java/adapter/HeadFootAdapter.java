package adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class HeadFootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    public static final int f212a = 0;

    /* renamed from: b */
    public static final int f213b = 1;

    /* renamed from: c */
    public static final int f214c = 2;

    /* renamed from: a */
    public abstract View m238a();

    /* renamed from: b */
    public abstract View m239b();

    /* renamed from: c */
    public abstract int m240c();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (m239b() == null && m238a() == null) ? m240c() : (m239b() != null || m238a() == null) ? (m239b() == null || m238a() != null) ? m240c() + 2 : m240c() + 1 : m240c() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (m239b() == null || i2 != 0) {
            return (m238a() == null || i2 != getItemCount() - 1) ? 2 : 1;
        }
        return 0;
    }
}
