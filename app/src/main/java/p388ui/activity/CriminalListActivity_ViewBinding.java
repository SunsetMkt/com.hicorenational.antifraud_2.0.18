package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class CriminalListActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CriminalListActivity f22177a;

    /* renamed from: b */
    private View f22178b;

    /* renamed from: c */
    private View f22179c;

    /* renamed from: ui.activity.CriminalListActivity_ViewBinding$a */
    class C6251a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalListActivity f22180a;

        C6251a(CriminalListActivity criminalListActivity) {
            this.f22180a = criminalListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22180a.onClick(view);
        }
    }

    /* renamed from: ui.activity.CriminalListActivity_ViewBinding$b */
    class C6252b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ CriminalListActivity f22182a;

        C6252b(CriminalListActivity criminalListActivity) {
            this.f22182a = criminalListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22182a.onClick(view);
        }
    }

    @UiThread
    public CriminalListActivity_ViewBinding(CriminalListActivity criminalListActivity) {
        this(criminalListActivity, criminalListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CriminalListActivity criminalListActivity = this.f22177a;
        if (criminalListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22177a = null;
        criminalListActivity.mIvBack = null;
        criminalListActivity.mTvTitle = null;
        criminalListActivity.mRecycleView = null;
        criminalListActivity.mTvAdd = null;
        this.f22178b.setOnClickListener(null);
        this.f22178b = null;
        this.f22179c.setOnClickListener(null);
        this.f22179c = null;
    }

    @UiThread
    public CriminalListActivity_ViewBinding(CriminalListActivity criminalListActivity, View view) {
        this.f22177a = criminalListActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        criminalListActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22178b = findRequiredView;
        findRequiredView.setOnClickListener(new C6251a(criminalListActivity));
        criminalListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalListActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        criminalListActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvAdd'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_add, "method 'onClick'");
        this.f22179c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6252b(criminalListActivity));
    }
}
