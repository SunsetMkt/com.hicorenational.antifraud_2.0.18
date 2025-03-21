package p388ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class ResetPhoneNumActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ResetPhoneNumActivity f23021a;

    /* renamed from: b */
    private View f23022b;

    /* renamed from: c */
    private View f23023c;

    /* renamed from: d */
    private View f23024d;

    /* renamed from: ui.activity.ResetPhoneNumActivity_ViewBinding$a */
    class C6555a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ResetPhoneNumActivity f23025a;

        C6555a(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.f23025a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23025a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ResetPhoneNumActivity_ViewBinding$b */
    class C6556b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ResetPhoneNumActivity f23027a;

        C6556b(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.f23027a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23027a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.ResetPhoneNumActivity_ViewBinding$c */
    class C6557c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ ResetPhoneNumActivity f23029a;

        C6557c(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.f23029a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23029a.onViewClicked(view);
        }
    }

    @UiThread
    public ResetPhoneNumActivity_ViewBinding(ResetPhoneNumActivity resetPhoneNumActivity) {
        this(resetPhoneNumActivity, resetPhoneNumActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ResetPhoneNumActivity resetPhoneNumActivity = this.f23021a;
        if (resetPhoneNumActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23021a = null;
        resetPhoneNumActivity.mTvTitle = null;
        resetPhoneNumActivity.mPhoneCode = null;
        resetPhoneNumActivity.mConfim = null;
        resetPhoneNumActivity.mPhoneLable = null;
        resetPhoneNumActivity.mTvBomTips = null;
        resetPhoneNumActivity.mIvClean = null;
        this.f23022b.setOnClickListener(null);
        this.f23022b = null;
        this.f23023c.setOnClickListener(null);
        this.f23023c = null;
        this.f23024d.setOnClickListener(null);
        this.f23024d = null;
    }

    @UiThread
    public ResetPhoneNumActivity_ViewBinding(ResetPhoneNumActivity resetPhoneNumActivity, View view) {
        this.f23021a = resetPhoneNumActivity;
        resetPhoneNumActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        resetPhoneNumActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        resetPhoneNumActivity.mConfim = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mConfim'", TextView.class);
        this.f23022b = findRequiredView;
        findRequiredView.setOnClickListener(new C6555a(resetPhoneNumActivity));
        resetPhoneNumActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        resetPhoneNumActivity.mTvBomTips = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_bom_tips, "field 'mTvBomTips'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        resetPhoneNumActivity.mIvClean = (ImageView) Utils.castView(findRequiredView2, C2113R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f23023c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6556b(resetPhoneNumActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23024d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6557c(resetPhoneNumActivity));
    }
}
