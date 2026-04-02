package ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class AddSmsFourFragment_ViewBinding implements Unbinder {
    private AddSmsFourFragment a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f14149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f14150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14151d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AddSmsFourFragment a;

        a(AddSmsFourFragment addSmsFourFragment) {
            this.a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ AddSmsFourFragment a;

        b(AddSmsFourFragment addSmsFourFragment) {
            this.a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ AddSmsFourFragment a;

        c(AddSmsFourFragment addSmsFourFragment) {
            this.a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsFourFragment_ViewBinding(AddSmsFourFragment addSmsFourFragment, View view) {
        this.a = addSmsFourFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsFourFragment.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f14149b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addSmsFourFragment));
        addSmsFourFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsFourFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsFourFragment.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f14150c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(addSmsFourFragment));
        addSmsFourFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_brand, "field 'mTvBrand' and method 'onViewClicked'");
        addSmsFourFragment.mTvBrand = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_brand, "field 'mTvBrand'", TextView.class);
        this.f14151d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(addSmsFourFragment));
        addSmsFourFragment.mEtBrandOther = (EditText) Utils.findRequiredViewAsType(view, R.id.et_brand_other, "field 'mEtBrandOther'", EditText.class);
        addSmsFourFragment.mGpBrandOther = (Group) Utils.findRequiredViewAsType(view, R.id.gp_brand_other, "field 'mGpBrandOther'", Group.class);
        addSmsFourFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsFourFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsFourFragment addSmsFourFragment = this.a;
        if (addSmsFourFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        addSmsFourFragment.mBtnCommit = null;
        addSmsFourFragment.mEtDescribe = null;
        addSmsFourFragment.mEtVictimPhone = null;
        addSmsFourFragment.mTvTime = null;
        addSmsFourFragment.mRecyclerview = null;
        addSmsFourFragment.mTvBrand = null;
        addSmsFourFragment.mEtBrandOther = null;
        addSmsFourFragment.mGpBrandOther = null;
        addSmsFourFragment.mLlPicture = null;
        addSmsFourFragment.mTvTipPicture = null;
        this.f14149b.setOnClickListener(null);
        this.f14149b = null;
        this.f14150c.setOnClickListener(null);
        this.f14150c = null;
        this.f14151d.setOnClickListener(null);
        this.f14151d = null;
    }
}
