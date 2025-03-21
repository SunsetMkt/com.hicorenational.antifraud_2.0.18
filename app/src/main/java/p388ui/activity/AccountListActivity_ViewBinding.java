package p388ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AccountListActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AccountListActivity f21764a;

    /* renamed from: b */
    private View f21765b;

    /* renamed from: c */
    private View f21766c;

    /* renamed from: ui.activity.AccountListActivity_ViewBinding$a */
    class C6107a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountListActivity f21767a;

        C6107a(AccountListActivity accountListActivity) {
            this.f21767a = accountListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21767a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.AccountListActivity_ViewBinding$b */
    class C6108b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountListActivity f21769a;

        C6108b(AccountListActivity accountListActivity) {
            this.f21769a = accountListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21769a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountListActivity_ViewBinding(AccountListActivity accountListActivity) {
        this(accountListActivity, accountListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountListActivity accountListActivity = this.f21764a;
        if (accountListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21764a = null;
        accountListActivity.mTvTitle = null;
        accountListActivity.mLlAdd = null;
        accountListActivity.mTvAdd = null;
        accountListActivity.mRecyclerview = null;
        this.f21765b.setOnClickListener(null);
        this.f21765b = null;
        this.f21766c.setOnClickListener(null);
        this.f21766c = null;
    }

    @UiThread
    public AccountListActivity_ViewBinding(AccountListActivity accountListActivity, View view) {
        this.f21764a = accountListActivity;
        accountListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.ll_add, "field 'mLlAdd' and method 'onViewClicked'");
        accountListActivity.mLlAdd = (LinearLayout) Utils.castView(findRequiredView, C2113R.id.ll_add, "field 'mLlAdd'", LinearLayout.class);
        this.f21765b = findRequiredView;
        findRequiredView.setOnClickListener(new C6107a(accountListActivity));
        accountListActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvAdd'", TextView.class);
        accountListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21766c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6108b(accountListActivity));
    }
}
