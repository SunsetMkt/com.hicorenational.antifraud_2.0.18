package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class AccountListPreviewActivity_ViewBinding implements Unbinder {
    private AccountListPreviewActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13065b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AccountListPreviewActivity a;

        a(AccountListPreviewActivity accountListPreviewActivity) {
            this.a = accountListPreviewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountListPreviewActivity_ViewBinding(AccountListPreviewActivity accountListPreviewActivity) {
        this(accountListPreviewActivity, accountListPreviewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountListPreviewActivity accountListPreviewActivity = this.a;
        if (accountListPreviewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        accountListPreviewActivity.mTvTitle = null;
        accountListPreviewActivity.mRecyclerview = null;
        this.f13065b.setOnClickListener(null);
        this.f13065b = null;
    }

    @UiThread
    public AccountListPreviewActivity_ViewBinding(AccountListPreviewActivity accountListPreviewActivity, View view) {
        this.a = accountListPreviewActivity;
        accountListPreviewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        accountListPreviewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13065b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(accountListPreviewActivity));
    }
}
