package ui.presenter;

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
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.VictimActivity;
import ui.activity.VictimDetialActivity;
import ui.callview.VictimPeopleView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class ReportCaseInfoPresenter extends ModelPresent<VictimPeopleView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<SurveyPeopleBean> surveyPeopleBeans;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            View a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            ImageView f14387b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            TextView f14388c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            TextView f14389d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            TextView f14390e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            TextView f14391f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            ImageView f14392g;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.fl_view);
                this.f14387b = (ImageView) view.findViewById(R.id.iv_head_sex);
                this.f14388c = (TextView) view.findViewById(R.id.tv_peop_name);
                this.f14389d = (TextView) view.findViewById(R.id.tv_peop_phone);
                this.f14390e = (TextView) view.findViewById(R.id.tv_card_type);
                this.f14391f = (TextView) view.findViewById(R.id.tv_peop_id);
                this.f14392g = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            SurveyPeopleBean surveyPeopleBean;
            if (ReportCaseInfoPresenter.this.surveyPeopleBeans.size() > 0 && (surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(i2)) != null) {
                aVar.f14388c.setText(surveyPeopleBean.getPeopleName());
                aVar.f14391f.setText(surveyPeopleBean.getDocumentNumber());
                aVar.f14390e.setText(surveyPeopleBean.getDocumentName());
                aVar.f14389d.setText(surveyPeopleBean.getPeoplePhone());
                if (ReportCaseInfoPresenter.this.caseInfoId == null) {
                    aVar.f14392g.setVisibility(8);
                }
            }
            aVar.a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
            aVar.f14392g.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            f1.b(ReportCaseInfoPresenter.this.mActivity, "\u5220\u9664\u5f53\u524d\u4e8b\u4e3b\u4fe1\u606f\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", new l0(this, i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportCaseInfoPresenter.this.surveyPeopleBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_victim_people, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            SurveyPeopleBean surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(i2);
            if (surveyPeopleBean != null) {
                if (ReportCaseInfoPresenter.this.caseInfoId == null) {
                    Intent intent = new Intent(ReportCaseInfoPresenter.this.mActivity, (Class<?>) VictimDetialActivity.class);
                    intent.putExtra(p1.f15011c, surveyPeopleBean);
                    ReportCaseInfoPresenter.this.mActivity.startActivity(intent);
                } else {
                    Intent intent2 = new Intent(ReportCaseInfoPresenter.this.mActivity, (Class<?>) VictimActivity.class);
                    intent2.putExtra(p1.C0, ReportCaseInfoPresenter.this.caseInfoId);
                    intent2.putExtra(p1.f15011c, surveyPeopleBean);
                    ReportCaseInfoPresenter.this.mActivity.startActivity(intent2);
                }
            }
        }
    }

    class a extends MiddleSubscriber<APIresult<List<SurveyPeopleBean>>> {

        /* JADX INFO: renamed from: ui.presenter.ReportCaseInfoPresenter$a$a, reason: collision with other inner class name */
        class C0311a extends com.google.gson.d0.a<List<SurveyPeopleBean>> {
            C0311a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0311a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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

    class b extends MiddleSubscriber<APIresult<SignComitBean>> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return SignComitBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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

    class c extends MiddleSubscriber<APIresult> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.f1);
        HashMap<String, String> map = new HashMap<>();
        map.put("victimInfoID", str);
        deletePeople(strB, map, new c());
    }

    public void getSubmitCaseInfo(String str) {
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.c2);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getComitReportNum(strB, map, new b());
    }

    public void getVictimList(String str) {
        f1.a("\u8bf7\u7a0d\u540e...", true, this.mActivity);
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.e1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getVictimList(strB, map, new a());
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
