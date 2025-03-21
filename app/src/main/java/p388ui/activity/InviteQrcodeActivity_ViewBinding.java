package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class InviteQrcodeActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private InviteQrcodeActivity f22441a;

    /* renamed from: b */
    private View f22442b;

    /* renamed from: ui.activity.InviteQrcodeActivity_ViewBinding$a */
    class C6343a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ InviteQrcodeActivity f22443a;

        C6343a(InviteQrcodeActivity inviteQrcodeActivity) {
            this.f22443a = inviteQrcodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22443a.onClick(view);
        }
    }

    @UiThread
    public InviteQrcodeActivity_ViewBinding(InviteQrcodeActivity inviteQrcodeActivity) {
        this(inviteQrcodeActivity, inviteQrcodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        InviteQrcodeActivity inviteQrcodeActivity = this.f22441a;
        if (inviteQrcodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22441a = null;
        inviteQrcodeActivity.mRlTitle = null;
        inviteQrcodeActivity.mIvBack = null;
        inviteQrcodeActivity.mTvTitle = null;
        inviteQrcodeActivity.mIvQrcode = null;
        this.f22442b.setOnClickListener(null);
        this.f22442b = null;
    }

    @UiThread
    public InviteQrcodeActivity_ViewBinding(InviteQrcodeActivity inviteQrcodeActivity, View view) {
        this.f22441a = inviteQrcodeActivity;
        inviteQrcodeActivity.mRlTitle = Utils.findRequiredView(view, C2113R.id.rl_title, "field 'mRlTitle'");
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        inviteQrcodeActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22442b = findRequiredView;
        findRequiredView.setOnClickListener(new C6343a(inviteQrcodeActivity));
        inviteQrcodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        inviteQrcodeActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, C2113R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
    }
}
