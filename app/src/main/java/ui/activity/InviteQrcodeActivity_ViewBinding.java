package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class InviteQrcodeActivity_ViewBinding implements Unbinder {
    private InviteQrcodeActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13438b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ InviteQrcodeActivity a;

        a(InviteQrcodeActivity inviteQrcodeActivity) {
            this.a = inviteQrcodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public InviteQrcodeActivity_ViewBinding(InviteQrcodeActivity inviteQrcodeActivity) {
        this(inviteQrcodeActivity, inviteQrcodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        InviteQrcodeActivity inviteQrcodeActivity = this.a;
        if (inviteQrcodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        inviteQrcodeActivity.mRlTitle = null;
        inviteQrcodeActivity.mIvBack = null;
        inviteQrcodeActivity.mTvTitle = null;
        inviteQrcodeActivity.mIvQrcode = null;
        this.f13438b.setOnClickListener(null);
        this.f13438b = null;
    }

    @UiThread
    public InviteQrcodeActivity_ViewBinding(InviteQrcodeActivity inviteQrcodeActivity, View view) {
        this.a = inviteQrcodeActivity;
        inviteQrcodeActivity.mRlTitle = Utils.findRequiredView(view, R.id.rl_title, "field 'mRlTitle'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        inviteQrcodeActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13438b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(inviteQrcodeActivity));
        inviteQrcodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        inviteQrcodeActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
    }
}
