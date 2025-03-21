package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class SignCallDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignCallDetailActivity f23097a;

    /* renamed from: b */
    private View f23098b;

    /* renamed from: c */
    private View f23099c;

    /* renamed from: ui.activity.SignCallDetailActivity_ViewBinding$a */
    class C6579a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignCallDetailActivity f23100a;

        C6579a(SignCallDetailActivity signCallDetailActivity) {
            this.f23100a = signCallDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23100a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SignCallDetailActivity_ViewBinding$b */
    class C6580b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SignCallDetailActivity f23102a;

        C6580b(SignCallDetailActivity signCallDetailActivity) {
            this.f23102a = signCallDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23102a.onViewClicked(view);
        }
    }

    @UiThread
    public SignCallDetailActivity_ViewBinding(SignCallDetailActivity signCallDetailActivity) {
        this(signCallDetailActivity, signCallDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCallDetailActivity signCallDetailActivity = this.f23097a;
        if (signCallDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23097a = null;
        signCallDetailActivity.mTvTitle = null;
        signCallDetailActivity.mBtnConfirm = null;
        signCallDetailActivity.mEtVictimPhone = null;
        signCallDetailActivity.mEtPhone = null;
        signCallDetailActivity.mTvOccurTime = null;
        signCallDetailActivity.mTvDuration = null;
        signCallDetailActivity.mLlClause = null;
        signCallDetailActivity.mTCbSelect = null;
        signCallDetailActivity.mAudioNum = null;
        this.f23098b.setOnClickListener(null);
        this.f23098b = null;
        this.f23099c.setOnClickListener(null);
        this.f23099c = null;
    }

    @UiThread
    public SignCallDetailActivity_ViewBinding(SignCallDetailActivity signCallDetailActivity, View view) {
        this.f23097a = signCallDetailActivity;
        signCallDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCallDetailActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, C2113R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        signCallDetailActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        signCallDetailActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone, "field 'mEtPhone'", EditText.class);
        signCallDetailActivity.mTvOccurTime = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_occur_time, "field 'mTvOccurTime'", TextView.class);
        signCallDetailActivity.mTvDuration = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_duration, "field 'mTvDuration'", TextView.class);
        signCallDetailActivity.mLlClause = Utils.findRequiredView(view, C2113R.id.ll_clause, "field 'mLlClause'");
        signCallDetailActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, C2113R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.tv_audio_num, "field 'mAudioNum' and method 'onViewClicked'");
        signCallDetailActivity.mAudioNum = (TextView) Utils.castView(findRequiredView, C2113R.id.tv_audio_num, "field 'mAudioNum'", TextView.class);
        this.f23098b = findRequiredView;
        findRequiredView.setOnClickListener(new C6579a(signCallDetailActivity));
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23099c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6580b(signCallDetailActivity));
    }
}
