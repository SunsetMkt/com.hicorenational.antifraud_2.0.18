package ui.activity;

import adapter.PayStopAdapter;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.AccountListCallView;
import ui.presenter.AccountListPresenter;

/* JADX INFO: loaded from: classes2.dex */
public class PayStopListActivity extends BaseActivity implements BaseQuickAdapter.i, BaseQuickAdapter.k, AccountListCallView {
    private PayStopAdapter mAdapter;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.v_line)
    View mLine;

    @BindView(R.id.ll_input)
    View mLlInput;

    @BindView(R.id.ll_select)
    View mLlSelect;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<AccountListBean> autoAccList = new ArrayList();
    private List<AccountListBean> allAccountList = new ArrayList();
    private AccountListPresenter mPresenter = null;
    private String mCaseInfoId = "";

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            PayStopListActivity.this.finish();
        }
    }

    class b implements IClickListener {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseQuickAdapter f13537b;

        b(int i2, BaseQuickAdapter baseQuickAdapter) {
            this.a = i2;
            this.f13537b = baseQuickAdapter;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            AccountListBean accountListBean = (AccountListBean) PayStopListActivity.this.allAccountList.get(this.a);
            if (!accountListBean.isEdit()) {
                PayStopListActivity.this.deleteAutoList(accountListBean);
            }
            PayStopListActivity.this.allAccountList.remove(this.a);
            this.f13537b.notifyDataSetChanged();
        }
    }

    private void cleanAutoList() {
        List<AccountListBean> list = this.allAccountList;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AccountListBean> it = this.allAccountList.iterator();
        while (it.hasNext()) {
            if (!it.next().isEdit()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAutoList(AccountListBean accountListBean) {
        if (this.autoAccList == null) {
            return;
        }
        for (int i2 = 0; i2 < this.autoAccList.size(); i2++) {
            AccountListBean accountListBean2 = this.autoAccList.get(i2);
            try {
                if (accountListBean2.getSuspectName().equals(accountListBean.getSuspectName()) && accountListBean2.getPaymentTime().equals(accountListBean.getPaymentTime()) && accountListBean2.getTransferAmount().equals(accountListBean.getTransferAmount()) && accountListBean2.getSuspectAccountTypeText().equals(accountListBean.getSuspectAccountTypeText()) && accountListBean2.getSuspectAccount().equals(accountListBean.getSuspectAccount())) {
                    accountListBean2.setSelect(false);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("\u5acc\u7591\u4eba\u6b62\u4ed8\u8d26\u6237");
        this.mPresenter = new AccountListPresenter(this, this);
        this.mCaseInfoId = getIntent().getStringExtra(util.p1.C0);
        ArrayList arrayList = (ArrayList) getIntent().getSerializableExtra(util.p1.f15011c);
        if (arrayList != null && arrayList.size() > 0) {
            this.allAccountList = arrayList;
        }
        ArrayList arrayList2 = (ArrayList) getIntent().getSerializableExtra(util.p1.f15010b);
        if (arrayList2 != null) {
            this.autoAccList = arrayList2;
        }
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new PayStopAdapter(R.layout.item_paystop, this.allAccountList);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
        this.mAdapter.setOnItemClickListener(this);
        List<AccountListBean> list = this.autoAccList;
        if (list == null || list.size() == 0) {
            this.mPresenter.getStopPayment(this.mCaseInfoId);
        } else {
            onSuccess(this.autoAccList);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // ui.callview.AccountListCallView
    public void onDeleteSuccess(AccountListBean accountListBean) {
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEvent(util.n2.a aVar) {
        if (aVar != null) {
            switch (aVar.a()) {
                case 300:
                    AccountListBean accountListBean = (AccountListBean) aVar.b();
                    if (accountListBean.getPosition() < 0) {
                        this.allAccountList.add(accountListBean);
                        this.mAdapter.setNewData(this.allAccountList);
                    } else {
                        this.allAccountList.set(accountListBean.getPosition(), accountListBean);
                        this.mAdapter.notifyItemChanged(accountListBean.getPosition());
                    }
                    break;
                case 301:
                    List list = (List) aVar.b();
                    cleanAutoList();
                    if (list != null && list.size() > 0) {
                        this.allAccountList.addAll(list);
                        this.mAdapter.setNewData(this.allAccountList);
                        break;
                    }
                    break;
                case 302:
                    this.autoAccList = (List) aVar.b();
                    break;
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!isDouble() && view.getId() == R.id.iv_clear) {
            util.f1.a((Activity) this, "\u786e\u8ba4\u5220\u9664\u8be5\u6b62\u4ed8\u8d26\u6237?", "", "\u53d6\u6d88", "\u786e\u5b9a", R.color._2D4AEB, -1, true, (IClickListener) new b(i2, baseQuickAdapter));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.k
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (isDouble()) {
            return;
        }
        AccountListBean accountListBean = this.allAccountList.get(i2);
        if (accountListBean.isEdit()) {
            accountListBean.setPosition(i2);
            Intent intent = new Intent(this, (Class<?>) PayStopAddActivity.class);
            intent.putExtra(util.p1.f15011c, accountListBean);
            startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<AccountListBean> list = this.allAccountList;
        if (list == null || list.size() <= 0) {
            this.mBtnCommit.setVisibility(8);
        } else {
            this.mBtnCommit.setVisibility(0);
        }
    }

    @Override // ui.callview.AccountListCallView
    public void onSuccess(List<AccountListBean> list) {
        if (list == null || list.size() <= 0) {
            this.mLlInput.setVisibility(0);
            return;
        }
        this.autoAccList = list;
        this.mLlSelect.setVisibility(0);
        this.mLine.setVisibility(0);
        this.mLlInput.setVisibility(0);
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.ll_input, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                org.greenrobot.eventbus.c.f().d(new util.n2.a(303, this.allAccountList));
                org.greenrobot.eventbus.c.f().d(new util.n2.a(304, this.autoAccList));
                finish();
                break;
            case R.id.iv_back /* 2131296808 */:
                util.f1.a((Activity) this, "\u653e\u5f03\u672c\u6b21\u7f16\u8f91?", "", "\u53d6\u6d88", "\u786e\u5b9a", R.color._2D4AEB, -1, true, (IClickListener) new a());
                break;
            case R.id.ll_input /* 2131297000 */:
                startActivity(PayStopAddActivity.class);
                break;
            case R.id.ll_select /* 2131297034 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) PayStopSelectActivity.class);
                intent.putExtra(util.p1.f15011c, (Serializable) this.autoAccList);
                startActivity(intent);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_paystop_list;
    }
}
