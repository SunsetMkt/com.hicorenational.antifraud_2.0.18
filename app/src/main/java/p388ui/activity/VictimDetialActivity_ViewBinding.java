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
public final class VictimDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private VictimDetialActivity f23379a;

    /* renamed from: b */
    private View f23380b;

    /* renamed from: ui.activity.VictimDetialActivity_ViewBinding$a */
    class C6660a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ VictimDetialActivity f23381a;

        C6660a(VictimDetialActivity victimDetialActivity) {
            this.f23381a = victimDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23381a.onClick(view);
        }
    }

    @UiThread
    public VictimDetialActivity_ViewBinding(VictimDetialActivity victimDetialActivity) {
        this(victimDetialActivity, victimDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        VictimDetialActivity victimDetialActivity = this.f23379a;
        if (victimDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23379a = null;
        victimDetialActivity.mIvBack = null;
        victimDetialActivity.mTvTitle = null;
        victimDetialActivity.mTvPeopName = null;
        victimDetialActivity.mTvPeopPhone = null;
        victimDetialActivity.mTvPeopCredentType = null;
        victimDetialActivity.mEtPeopCredentNumber = null;
        this.f23380b.setOnClickListener(null);
        this.f23380b = null;
    }

    @UiThread
    public VictimDetialActivity_ViewBinding(VictimDetialActivity victimDetialActivity, View view) {
        this.f23379a = victimDetialActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        victimDetialActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f23380b = findRequiredView;
        findRequiredView.setOnClickListener(new C6660a(victimDetialActivity));
        victimDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        victimDetialActivity.mTvPeopName = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_peop_name, "field 'mTvPeopName'", TextView.class);
        victimDetialActivity.mTvPeopPhone = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_num_phone, "field 'mTvPeopPhone'", TextView.class);
        victimDetialActivity.mTvPeopCredentType = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_peop_credent_type, "field 'mTvPeopCredentType'", TextView.class);
        victimDetialActivity.mEtPeopCredentNumber = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.et_peop_credent_number, "field 'mEtPeopCredentNumber'", TextView.class);
    }
}
