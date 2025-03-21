package p388ui.activity;

import adapter.PaymentTypeAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CaseDivisonBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import p388ui.callview.PaymentTypeCallView;
import p388ui.presenter.PaymentTypePresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* loaded from: classes2.dex */
public class PaymentTypeActivity extends BaseActivity implements PaymentTypeCallView, BaseQuickAdapter.InterfaceC1895i {

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private PaymentTypePresenter mPresenter = null;
    private List<CaseDivisonBean> mPaymentTypeList = new ArrayList();
    private PaymentTypeAdapter mAdapter = null;

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("转账方式");
        this.mPresenter = new PaymentTypePresenter(this, this);
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        this.mAdapter = new PaymentTypeAdapter(this.mPaymentTypeList);
        this.mAdapter.setOnItemChildClickListener(this);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mPresenter.paymentType();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        TextView textView = (TextView) view.findViewById(C2113R.id.tv_txet);
        textView.setTextColor(getResources().getColor(C2113R.color.blue));
        textView.setBackgroundResource(C2113R.drawable.shape_blue_25);
        Intent intent = new Intent();
        intent.putExtra(C7292k1.f25414j1, this.mPaymentTypeList.get(i2));
        setResult(-1, intent);
        finish();
    }

    @Override // p388ui.callview.PaymentTypeCallView
    public void onSuccessPaymentType(List<CaseDivisonBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mPaymentTypeList.addAll(list);
        this.mAdapter.notifyDataSetChanged();
    }

    @OnClick({C2113R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_trans_type;
    }
}
