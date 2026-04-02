package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SignCallDetailActivity_ViewBinding implements Unbinder {
    private SignCallDetailActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13800c;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SignCallDetailActivity a;

        a(SignCallDetailActivity signCallDetailActivity) {
            this.a = signCallDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SignCallDetailActivity a;

        b(SignCallDetailActivity signCallDetailActivity) {
            this.a = signCallDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SignCallDetailActivity_ViewBinding(SignCallDetailActivity signCallDetailActivity) {
        this(signCallDetailActivity, signCallDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCallDetailActivity signCallDetailActivity = this.a;
        if (signCallDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        signCallDetailActivity.mTvTitle = null;
        signCallDetailActivity.mBtnConfirm = null;
        signCallDetailActivity.mEtVictimPhone = null;
        signCallDetailActivity.mEtPhone = null;
        signCallDetailActivity.mTvOccurTime = null;
        signCallDetailActivity.mTvDuration = null;
        signCallDetailActivity.mLlClause = null;
        signCallDetailActivity.mTCbSelect = null;
        signCallDetailActivity.mAudioNum = null;
        this.f13799b.setOnClickListener(null);
        this.f13799b = null;
        this.f13800c.setOnClickListener(null);
        this.f13800c = null;
    }

    @UiThread
    public SignCallDetailActivity_ViewBinding(SignCallDetailActivity signCallDetailActivity, View view) {
        this.a = signCallDetailActivity;
        signCallDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCallDetailActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        signCallDetailActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        signCallDetailActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        signCallDetailActivity.mTvOccurTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_occur_time, "field 'mTvOccurTime'", TextView.class);
        signCallDetailActivity.mTvDuration = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_duration, "field 'mTvDuration'", TextView.class);
        signCallDetailActivity.mLlClause = Utils.findRequiredView(view, R.id.ll_clause, "field 'mLlClause'");
        signCallDetailActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_audio_num, "field 'mAudioNum' and method 'onViewClicked'");
        signCallDetailActivity.mAudioNum = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_audio_num, "field 'mAudioNum'", TextView.class);
        this.f13799b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCallDetailActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13800c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(signCallDetailActivity));
    }
}
