package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SignComitBean;
import bean.SurveyPeopleBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.activity.VictimActivity;
import p388ui.activity.VictimDetialActivity;
import p388ui.callview.VictimPeopleView;
import p388ui.model.ModelPresent;
import p388ui.presenter.ReportCaseInfoPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ReportCaseInfoPresenter extends ModelPresent<VictimPeopleView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<SurveyPeopleBean> surveyPeopleBeans;

    public class HolderAdapte extends RecyclerView.Adapter<C7065a> {

        /* renamed from: a */
        private Context f24244a;

        /* renamed from: ui.presenter.ReportCaseInfoPresenter$HolderAdapte$a */
        class C7065a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            View f24246a;

            /* renamed from: b */
            ImageView f24247b;

            /* renamed from: c */
            TextView f24248c;

            /* renamed from: d */
            TextView f24249d;

            /* renamed from: e */
            TextView f24250e;

            /* renamed from: f */
            TextView f24251f;

            /* renamed from: g */
            ImageView f24252g;

            public C7065a(View view) {
                super(view);
                this.f24246a = view.findViewById(C2113R.id.fl_view);
                this.f24247b = (ImageView) view.findViewById(C2113R.id.iv_head_sex);
                this.f24248c = (TextView) view.findViewById(C2113R.id.tv_peop_name);
                this.f24249d = (TextView) view.findViewById(C2113R.id.tv_peop_phone);
                this.f24250e = (TextView) view.findViewById(C2113R.id.tv_card_type);
                this.f24251f = (TextView) view.findViewById(C2113R.id.tv_peop_id);
                this.f24252g = (ImageView) view.findViewById(C2113R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f24244a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7065a c7065a, final int i2) {
            SurveyPeopleBean surveyPeopleBean;
            if (ReportCaseInfoPresenter.this.surveyPeopleBeans.size() > 0 && (surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(i2)) != null) {
                c7065a.f24248c.setText(surveyPeopleBean.getPeopleName());
                c7065a.f24251f.setText(surveyPeopleBean.getDocumentNumber());
                c7065a.f24250e.setText(surveyPeopleBean.getDocumentName());
                c7065a.f24249d.setText(surveyPeopleBean.getPeoplePhone());
                if (ReportCaseInfoPresenter.this.caseInfoId == null) {
                    c7065a.f24252g.setVisibility(8);
                }
            }
            c7065a.f24246a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportCaseInfoPresenter.HolderAdapte.this.m25653a(i2, view);
                }
            });
            c7065a.f24252g.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportCaseInfoPresenter.HolderAdapte.this.m25655b(i2, view);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void m25655b(int i2, View view) {
            C7257b1.m26211b(ReportCaseInfoPresenter.this.mActivity, "删除当前事主信息？", "", "确定", "取消", new C7139f0(this, i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportCaseInfoPresenter.this.surveyPeopleBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7065a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7065a(LayoutInflater.from(this.f24244a).inflate(C2113R.layout.item_victim_people, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25653a(int i2, View view) {
            SurveyPeopleBean surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(i2);
            if (surveyPeopleBean != null) {
                if (ReportCaseInfoPresenter.this.caseInfoId == null) {
                    Intent intent = new Intent(ReportCaseInfoPresenter.this.mActivity, (Class<?>) VictimDetialActivity.class);
                    intent.putExtra(C7292k1.f25391c, surveyPeopleBean);
                    ReportCaseInfoPresenter.this.mActivity.startActivity(intent);
                } else {
                    Intent intent2 = new Intent(ReportCaseInfoPresenter.this.mActivity, (Class<?>) VictimActivity.class);
                    intent2.putExtra(C7292k1.f25338C0, ReportCaseInfoPresenter.this.caseInfoId);
                    intent2.putExtra(C7292k1.f25391c, surveyPeopleBean);
                    ReportCaseInfoPresenter.this.mActivity.startActivity(intent2);
                }
            }
        }
    }

    /* renamed from: ui.presenter.ReportCaseInfoPresenter$a */
    class C7066a extends MiddleSubscriber<APIresult<List<SurveyPeopleBean>>> {

        /* renamed from: ui.presenter.ReportCaseInfoPresenter$a$a */
        class a extends C2049a<List<SurveyPeopleBean>> {
            a() {
            }
        }

        C7066a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<SurveyPeopleBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessHandle(new ArrayList());
            } else {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessHandle(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.ReportCaseInfoPresenter$b */
    class C7067b extends MiddleSubscriber<APIresult<SignComitBean>> {
        C7067b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return SignComitBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<SignComitBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessHandle(new ArrayList());
            } else {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessCaseNum(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.ReportCaseInfoPresenter$c */
    class C7068c extends MiddleSubscriber<APIresult> {
        C7068c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((VictimPeopleView) ReportCaseInfoPresenter.this.mvpView).onSuccessDelet();
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    public ReportCaseInfoPresenter(Activity activity, String str, VictimPeopleView victimPeopleView) {
        super(activity, victimPeopleView);
        this.surveyPeopleBeans = new ArrayList();
        this.caseInfoId = str;
    }

    public void deletePeople(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17081e1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("victimInfoID", str);
        deletePeople(m16395a, hashMap, new C7068c());
    }

    public void getSubmitCaseInfo(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17070b2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getComitReportNum(m16395a, hashMap, new C7067b());
    }

    public void getVictimList(String str) {
        C7257b1.m26203a("请稍后...", true, this.mActivity);
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17077d1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getVictimList(m16395a, hashMap, new C7066a());
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<SurveyPeopleBean> list) {
        this.surveyPeopleBeans = list;
        this.mAdapter.notifyDataSetChanged();
    }
}
