package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import interfaces.IClickListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import p388ui.callview.AccountListCallView;
import p388ui.presenter.AccountListPresenter;
import util.C7257b1;
import util.C7292k1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class PayStopListActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i, BaseQuickAdapter.InterfaceC1897k, AccountListCallView {
    private PayStopAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.v_line)
    View mLine;

    @BindView(C2113R.id.ll_input)
    View mLlInput;

    @BindView(C2113R.id.ll_select)
    View mLlSelect;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private List<AccountListBean> autoAccList = new ArrayList();
    private List<AccountListBean> allAccountList = new ArrayList();
    private AccountListPresenter mPresenter = null;
    private String mCaseInfoId = "";

    /* renamed from: ui.activity.PayStopListActivity$a */
    class C6411a implements IClickListener {
        C6411a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            PayStopListActivity.this.finish();
        }
    }

    /* renamed from: ui.activity.PayStopListActivity$b */
    class C6412b implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ int f22628a;

        /* renamed from: b */
        final /* synthetic */ BaseQuickAdapter f22629b;

        C6412b(int i2, BaseQuickAdapter baseQuickAdapter) {
            this.f22628a = i2;
            this.f22629b = baseQuickAdapter;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            AccountListBean accountListBean = (AccountListBean) PayStopListActivity.this.allAccountList.get(this.f22628a);
            if (!accountListBean.isEdit()) {
                PayStopListActivity.this.deleteAutoList(accountListBean);
            }
            PayStopListActivity.this.allAccountList.remove(this.f22628a);
            this.f22629b.notifyDataSetChanged();
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

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("嫌疑人止付账户");
        this.mPresenter = new AccountListPresenter(this, this);
        this.mCaseInfoId = getIntent().getStringExtra(C7292k1.f25338C0);
        ArrayList arrayList = (ArrayList) getIntent().getSerializableExtra(C7292k1.f25391c);
        if (arrayList != null && arrayList.size() > 0) {
            this.allAccountList = arrayList;
        }
        ArrayList arrayList2 = (ArrayList) getIntent().getSerializableExtra(C7292k1.f25388b);
        if (arrayList2 != null) {
            this.autoAccList = arrayList2;
        }
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new PayStopAdapter(C2113R.layout.item_paystop, this.allAccountList);
        this.mAdapter.m5103a(this.mRecyclerview);
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

    @Override // p388ui.callview.AccountListCallView
    public void onDeleteSuccess(AccountListBean accountListBean) {
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEvent(C7265a c7265a) {
        if (c7265a != null) {
            switch (c7265a.m26297a()) {
                case 300:
                    AccountListBean accountListBean = (AccountListBean) c7265a.m26300b();
                    if (accountListBean.getPosition() < 0) {
                        this.allAccountList.add(accountListBean);
                        this.mAdapter.setNewData(this.allAccountList);
                        break;
                    } else {
                        this.allAccountList.set(accountListBean.getPosition(), accountListBean);
                        this.mAdapter.notifyItemChanged(accountListBean.getPosition());
                        break;
                    }
                case 301:
                    List list = (List) c7265a.m26300b();
                    cleanAutoList();
                    if (list != null && list.size() > 0) {
                        this.allAccountList.addAll(list);
                        this.mAdapter.setNewData(this.allAccountList);
                        break;
                    }
                    break;
                case 302:
                    this.autoAccList = (List) c7265a.m26300b();
                    break;
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!isDouble() && view.getId() == C2113R.id.iv_clear) {
            C7257b1.m26184a((Activity) this, "确认删除该止付账户?", "", "取消", "确定", C2113R.color._2D4AEB, -1, true, (IClickListener) new C6412b(i2, baseQuickAdapter));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1897k
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (isDouble()) {
            return;
        }
        AccountListBean accountListBean = this.allAccountList.get(i2);
        if (accountListBean.isEdit()) {
            accountListBean.setPosition(i2);
            Intent intent = new Intent(this, (Class<?>) PayStopAddActivity.class);
            intent.putExtra(C7292k1.f25391c, accountListBean);
            startActivity(intent);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<AccountListBean> list = this.allAccountList;
        if (list == null || list.size() <= 0) {
            this.mBtnCommit.setVisibility(8);
        } else {
            this.mBtnCommit.setVisibility(0);
        }
    }

    @Override // p388ui.callview.AccountListCallView
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

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_select, C2113R.id.ll_input, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                C6049c.m24987f().m25000d(new C7265a(303, this.allAccountList));
                C6049c.m24987f().m25000d(new C7265a(304, this.autoAccList));
                finish();
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                C7257b1.m26184a((Activity) this, "放弃本次编辑?", "", "取消", "确定", C2113R.color._2D4AEB, -1, true, (IClickListener) new C6411a());
                break;
            case C2113R.id.ll_input /* 2131296950 */:
                startActivity(PayStopAddActivity.class);
                break;
            case C2113R.id.ll_select /* 2131296984 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) PayStopSelectActivity.class);
                intent.putExtra(C7292k1.f25391c, (Serializable) this.autoAccList);
                startActivity(intent);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_paystop_list;
    }
}
