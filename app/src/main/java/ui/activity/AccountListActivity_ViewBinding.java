package ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class AccountListActivity_ViewBinding implements Unbinder {
    private AccountListActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13062c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AccountListActivity a;

        a(AccountListActivity accountListActivity) {
            this.a = accountListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AccountListActivity a;

        b(AccountListActivity accountListActivity) {
            this.a = accountListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountListActivity_ViewBinding(AccountListActivity accountListActivity) {
        this(accountListActivity, accountListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountListActivity accountListActivity = this.a;
        if (accountListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        accountListActivity.mTvTitle = null;
        accountListActivity.mLlAdd = null;
        accountListActivity.mTvAdd = null;
        accountListActivity.mRecyclerview = null;
        this.f13061b.setOnClickListener(null);
        this.f13061b = null;
        this.f13062c.setOnClickListener(null);
        this.f13062c = null;
    }

    @UiThread
    public AccountListActivity_ViewBinding(AccountListActivity accountListActivity, View view) {
        this.a = accountListActivity;
        accountListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_add, "field 'mLlAdd' and method 'onViewClicked'");
        accountListActivity.mLlAdd = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_add, "field 'mLlAdd'", LinearLayout.class);
        this.f13061b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(accountListActivity));
        accountListActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        accountListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13062c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(accountListActivity));
    }
}
