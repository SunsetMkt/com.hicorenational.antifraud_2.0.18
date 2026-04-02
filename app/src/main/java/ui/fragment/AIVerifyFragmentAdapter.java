package ui.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyFragmentAdapter extends FragmentStateAdapter {
    private List<Fragment> a;

    public AIVerifyFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> list) {
        super(fragmentActivity);
        this.a = list;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NonNull
    public Fragment createFragment(int i2) {
        return this.a.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Fragment> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
