package p388ui.fragment;

import android.view.View;
import android.widget.EditText;
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
public class AddSmsOneFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AddSmsOneFragment f23766a;

    /* renamed from: b */
    private View f23767b;

    /* renamed from: c */
    private View f23768c;

    /* renamed from: ui.fragment.AddSmsOneFragment_ViewBinding$a */
    class C6841a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsOneFragment f23769a;

        C6841a(AddSmsOneFragment addSmsOneFragment) {
            this.f23769a = addSmsOneFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23769a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.AddSmsOneFragment_ViewBinding$b */
    class C6842b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsOneFragment f23771a;

        C6842b(AddSmsOneFragment addSmsOneFragment) {
            this.f23771a = addSmsOneFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23771a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsOneFragment_ViewBinding(AddSmsOneFragment addSmsOneFragment, View view) {
        this.f23766a = addSmsOneFragment;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsOneFragment.mBtnCommit = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f23767b = findRequiredView;
        findRequiredView.setOnClickListener(new C6841a(addSmsOneFragment));
        addSmsOneFragment.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone, "field 'mEtPhone'", EditText.class);
        addSmsOneFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsOneFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsOneFragment.mTvTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f23768c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6842b(addSmsOneFragment));
        addSmsOneFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        addSmsOneFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsOneFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsOneFragment addSmsOneFragment = this.f23766a;
        if (addSmsOneFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23766a = null;
        addSmsOneFragment.mBtnCommit = null;
        addSmsOneFragment.mEtPhone = null;
        addSmsOneFragment.mEtDescribe = null;
        addSmsOneFragment.mEtVictimPhone = null;
        addSmsOneFragment.mTvTime = null;
        addSmsOneFragment.mRecyclerview = null;
        addSmsOneFragment.mLlPicture = null;
        addSmsOneFragment.mTvTipPicture = null;
        this.f23767b.setOnClickListener(null);
        this.f23767b = null;
        this.f23768c.setOnClickListener(null);
        this.f23768c = null;
    }
}
