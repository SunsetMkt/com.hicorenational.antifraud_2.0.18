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
public class AddSmsThreeFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AddSmsThreeFragment f23781a;

    /* renamed from: b */
    private View f23782b;

    /* renamed from: c */
    private View f23783c;

    /* renamed from: ui.fragment.AddSmsThreeFragment_ViewBinding$a */
    class C6847a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsThreeFragment f23784a;

        C6847a(AddSmsThreeFragment addSmsThreeFragment) {
            this.f23784a = addSmsThreeFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23784a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.AddSmsThreeFragment_ViewBinding$b */
    class C6848b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsThreeFragment f23786a;

        C6848b(AddSmsThreeFragment addSmsThreeFragment) {
            this.f23786a = addSmsThreeFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23786a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsThreeFragment_ViewBinding(AddSmsThreeFragment addSmsThreeFragment, View view) {
        this.f23781a = addSmsThreeFragment;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsThreeFragment.mBtnCommit = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f23782b = findRequiredView;
        findRequiredView.setOnClickListener(new C6847a(addSmsThreeFragment));
        addSmsThreeFragment.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_phone, "field 'mEtPhone'", EditText.class);
        addSmsThreeFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsThreeFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsThreeFragment.mTvTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f23783c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6848b(addSmsThreeFragment));
        addSmsThreeFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        addSmsThreeFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsThreeFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsThreeFragment addSmsThreeFragment = this.f23781a;
        if (addSmsThreeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23781a = null;
        addSmsThreeFragment.mBtnCommit = null;
        addSmsThreeFragment.mEtPhone = null;
        addSmsThreeFragment.mEtDescribe = null;
        addSmsThreeFragment.mEtVictimPhone = null;
        addSmsThreeFragment.mTvTime = null;
        addSmsThreeFragment.mRecyclerview = null;
        addSmsThreeFragment.mLlPicture = null;
        addSmsThreeFragment.mTvTipPicture = null;
        this.f23782b.setOnClickListener(null);
        this.f23782b = null;
        this.f23783c.setOnClickListener(null);
        this.f23783c = null;
    }
}
