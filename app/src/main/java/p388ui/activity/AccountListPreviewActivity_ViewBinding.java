package p388ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AccountListPreviewActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AccountListPreviewActivity f21771a;

    /* renamed from: b */
    private View f21772b;

    /* renamed from: ui.activity.AccountListPreviewActivity_ViewBinding$a */
    class C6109a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AccountListPreviewActivity f21773a;

        C6109a(AccountListPreviewActivity accountListPreviewActivity) {
            this.f21773a = accountListPreviewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f21773a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountListPreviewActivity_ViewBinding(AccountListPreviewActivity accountListPreviewActivity) {
        this(accountListPreviewActivity, accountListPreviewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountListPreviewActivity accountListPreviewActivity = this.f21771a;
        if (accountListPreviewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f21771a = null;
        accountListPreviewActivity.mTvTitle = null;
        accountListPreviewActivity.mRecyclerview = null;
        this.f21772b.setOnClickListener(null);
        this.f21772b = null;
    }

    @UiThread
    public AccountListPreviewActivity_ViewBinding(AccountListPreviewActivity accountListPreviewActivity, View view) {
        this.f21771a = accountListPreviewActivity;
        accountListPreviewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        accountListPreviewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f21772b = findRequiredView;
        findRequiredView.setOnClickListener(new C6109a(accountListPreviewActivity));
    }
}
