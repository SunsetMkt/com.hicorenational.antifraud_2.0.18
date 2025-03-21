package p388ui.fragment;

import adapter.SmsPictureAdapter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import p023b.p024a.p025a.p027e.C0923i;
import p388ui.activity.CriminalSmsAddActivity;
import util.C7319s1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class AddSmsFourFragment extends BaseFragment {

    /* renamed from: b */
    private CriminalSmsAddActivity f23741b;

    /* renamed from: c */
    private SmsPictureAdapter f23742c;

    @BindView(C2113R.id.confirm)
    TextView mBtnCommit;

    @BindView(C2113R.id.et_brand_other)
    EditText mEtBrandOther;

    @BindView(C2113R.id.et_describe)
    EditText mEtDescribe;

    @BindView(C2113R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(C2113R.id.gp_brand_other)
    Group mGpBrandOther;

    @BindView(C2113R.id.ll_picture)
    LinearLayout mLlPicture;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_brand)
    TextView mTvBrand;

    @BindView(C2113R.id.tv_time)
    TextView mTvTime;

    @BindView(C2113R.id.tv_tip_picture)
    TextView mTvTipPicture;

    /* renamed from: a */
    private CriminalSmsBean f23740a = null;

    /* renamed from: d */
    private List<LocalMedia> f23743d = new ArrayList();

    /* renamed from: ui.fragment.AddSmsFourFragment$a */
    class ViewOnTouchListenerC6830a implements View.OnTouchListener {
        ViewOnTouchListenerC6830a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                AddSmsFourFragment.this.mEtDescribe.setFocusable(true);
                AddSmsFourFragment.this.mEtDescribe.setFocusableInTouchMode(true);
            } else if (action == 2) {
                AddSmsFourFragment.this.mEtDescribe.setFocusable(false);
            }
            return false;
        }
    }

    /* renamed from: ui.fragment.AddSmsFourFragment$b */
    class C6831b implements C0923i.b<BrandBean> {
        C6831b() {
        }

        @Override // p023b.p024a.p025a.p027e.C0923i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo970a(int i2, BrandBean brandBean) {
            AddSmsFourFragment.this.f23740a.setOsBrandType(brandBean.getOsBrandType());
            AddSmsFourFragment.this.f23740a.setOsBrandTypeText(brandBean.getOsBrandTypeText());
            AddSmsFourFragment.this.mTvBrand.setText(brandBean.getOsBrandTypeText());
            if (brandBean.getEx() == 1) {
                AddSmsFourFragment.this.mGpBrandOther.setVisibility(0);
            } else {
                AddSmsFourFragment.this.mGpBrandOther.setVisibility(8);
            }
        }
    }

    /* renamed from: ui.fragment.AddSmsFourFragment$c */
    class C6832c implements SmsPictureAdapter.InterfaceC0074b {
        C6832c() {
        }

        @Override // adapter.SmsPictureAdapter.InterfaceC0074b
        public void onItemClickListener(int i2, List<LocalMedia> list) {
            AddSmsFourFragment.this.f23741b.onItemClickListener(i2, list);
        }
    }

    /* renamed from: ui.fragment.AddSmsFourFragment$d */
    class C6833d implements BaseQuickAdapter.InterfaceC1895i {
        C6833d() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            AddSmsFourFragment.this.f23741b.onItemChildClick(baseQuickAdapter, view, i2);
        }
    }

    /* renamed from: h */
    private void m25532h() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        List<LocalMedia> list = this.f23743d;
        this.f23741b.getClass();
        this.f23742c = new SmsPictureAdapter(C2113R.layout.recyclerview_feedback, list, 6, this.f23741b.isOnlyShow());
        this.f23742c.m5103a(this.mRecyclerview);
        this.f23742c.setOnItemClickListener(new C6832c());
        this.f23742c.setOnItemChildClickListener(new C6833d());
        this.mRecyclerview.setAdapter(this.f23742c);
    }

    /* renamed from: i */
    private void m25533i() {
        this.mTvBrand.setEnabled(false);
        this.mEtDescribe.setEnabled(false);
        this.mEtVictimPhone.setEnabled(false);
        this.mEtBrandOther.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        if (this.f23743d.size() <= 0) {
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    /* renamed from: d */
    public CriminalSmsBean m25535d() {
        return this.f23740a;
    }

    /* renamed from: e */
    public List<LocalMedia> m25536e() {
        return this.f23743d;
    }

    /* renamed from: f */
    public void m25537f() {
        this.f23742c.notifyDataSetChanged();
    }

    /* renamed from: g */
    public void m25538g() {
        String obj = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            C7331w1.m26688a("请输入接收短信号码");
            return;
        }
        if (this.mTvBrand.length() == 0) {
            C7331w1.m26688a("请选择接收短信手机品牌");
            return;
        }
        if (this.mGpBrandOther.getVisibility() == 0 && this.mEtBrandOther.length() == 0) {
            C7331w1.m26688a("请输入手机品牌名称");
            return;
        }
        if (this.mTvTime.length() == 0) {
            C7331w1.m26688a("请选择涉诈短信接收时间");
            return;
        }
        if (TextUtils.isEmpty(obj)) {
            C7331w1.m26688a("请输入涉诈短信内容");
            return;
        }
        if (this.f23740a == null) {
            this.f23740a = new CriminalSmsBean();
        }
        if (this.mGpBrandOther.getVisibility() == 0) {
            this.f23740a.setOsBrandTypeText(this.mEtBrandOther.getText().toString());
        }
        this.f23740a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f23740a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f23740a.setContent(obj);
        this.f23740a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.f23740a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f23741b.confirm(this.f23740a);
    }

    @Override // p388ui.fragment.BaseFragment
    protected int getLayoutId() {
        return C2113R.layout.fragment_sms_ip;
    }

    @Override // p388ui.fragment.BaseFragment
    public void initPage() {
        this.f23741b = (CriminalSmsAddActivity) this.mActivity;
        this.mEtDescribe.setOnTouchListener(new ViewOnTouchListenerC6830a());
        try {
            CriminalSmsBean criminalSmsBean = ((CriminalSmsAddActivity) this.mActivity).getCriminalSmsBean();
            if (criminalSmsBean.getSmsType() == 4) {
                this.f23740a = criminalSmsBean;
            }
            if (this.f23740a != null) {
                String victimMobile = this.f23740a.getVictimMobile();
                String deliveryTime = this.f23740a.getDeliveryTime();
                this.f23740a.getOsBrandTypeText();
                String content = this.f23740a.getContent();
                if (!TextUtils.isEmpty(victimMobile)) {
                    this.mEtVictimPhone.setText(victimMobile);
                }
                if (!TextUtils.isEmpty(deliveryTime)) {
                    this.mTvTime.setText(deliveryTime);
                }
                if (!TextUtils.isEmpty(content)) {
                    this.mEtDescribe.setText(content);
                }
                List<SmsPictureBean> smsDetails = this.f23740a.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia = new LocalMedia();
                        localMedia.setPath(smsPictureBean.getLocalPath());
                        localMedia.setCompressPath(smsPictureBean.getFilePath());
                        localMedia.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.f23743d.add(localMedia);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f23740a == null) {
            this.f23740a = new CriminalSmsBean();
            this.f23740a.setSmsType(4);
            this.f23740a.setSmsTypeText(this.f23741b.strs[3]);
        }
        this.f23741b.setChildBean(this.f23740a);
        m25532h();
        this.mGpBrandOther.setVisibility(8);
        if (this.f23741b.isOnlyShow()) {
            m25533i();
        }
    }

    @OnClick({C2113R.id.tv_time, C2113R.id.tv_brand, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            m25538g();
        } else if (id == C2113R.id.tv_brand) {
            this.f23741b.brandPick(new C6831b());
        } else {
            if (id != C2113R.id.tv_time) {
                return;
            }
            C7319s1.m26565a(this.mActivity, this.mTvTime);
        }
    }

    /* renamed from: a */
    public void m25534a(List<BrandBean> list) {
        CriminalSmsBean criminalSmsBean = this.f23740a;
        if (criminalSmsBean == null || TextUtils.isEmpty(criminalSmsBean.getOsBrandType())) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            BrandBean brandBean = list.get(i2);
            if (TextUtils.equals(this.f23740a.getOsBrandType(), brandBean.getOsBrandType())) {
                this.mTvBrand.setText(brandBean.getOsBrandTypeText());
                if (brandBean.getEx() == 1) {
                    this.mEtBrandOther.setText(this.f23740a.getOsBrandTypeText());
                    this.mGpBrandOther.setVisibility(0);
                    return;
                }
                return;
            }
        }
    }
}
