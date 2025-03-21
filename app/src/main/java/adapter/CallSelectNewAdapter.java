package adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import bean.CallBean;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import util.C7337y1;

/* loaded from: classes.dex */
public class CallSelectNewAdapter extends BaseQuickAdapter<CallBean, BaseViewHolder> {

    /* renamed from: V */
    private List<CallBean> f181V;

    /* renamed from: W */
    private InterfaceC0057b f182W;

    /* renamed from: adapter.CallSelectNewAdapter$a */
    class ViewOnClickListenerC0056a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f183a;

        /* renamed from: b */
        final /* synthetic */ CallBean f184b;

        ViewOnClickListenerC0056a(BaseViewHolder baseViewHolder, CallBean callBean) {
            this.f183a = baseViewHolder;
            this.f184b = callBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CallSelectNewAdapter.this.f182W != null) {
                CallSelectNewAdapter.this.f182W.mo222a(this.f183a.getAdapterPosition(), ((BaseQuickAdapter) CallSelectNewAdapter.this).f5546A, this.f184b);
            }
        }
    }

    /* renamed from: adapter.CallSelectNewAdapter$b */
    public interface InterfaceC0057b {
        /* renamed from: a */
        void mo222a(int i2, List<CallBean> list, CallBean callBean);
    }

    public CallSelectNewAdapter(int i2, List<CallBean> list, List<CallBean> list2) {
        super(i2, list);
        this.f181V = list2;
    }

    public void setOnItemClickListener(InterfaceC0057b interfaceC0057b) {
        this.f182W = interfaceC0057b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, CallBean callBean) {
        int type = callBean.getType();
        String place = callBean.getPlace();
        String number = callBean.getNumber();
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.phone_status);
        if (type == 1) {
            baseViewHolder.m5234g(C2113R.id.tv_phone_num, this.f5580x.getResources().getColor(C2113R.color._030303));
            imageView.setVisibility(4);
        } else if (type == 2) {
            baseViewHolder.m5234g(C2113R.id.tv_phone_num, this.f5580x.getResources().getColor(C2113R.color._030303));
            imageView.setVisibility(0);
            ComponentCallbacks2C1576b.m3649e(this.f5580x).mo3717a(Integer.valueOf(C2113R.mipmap.received_call)).m3768a(imageView);
        } else {
            baseViewHolder.m5234g(C2113R.id.tv_phone_num, this.f5580x.getResources().getColor(C2113R.color.missing_phone));
            imageView.setVisibility(0);
            ComponentCallbacks2C1576b.m3649e(this.f5580x).mo3717a(Integer.valueOf(C2113R.mipmap.missed_call)).m3768a(imageView);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(type == 2 ? "呼出" : "呼入");
        sb.append(callBean.getTalkTime());
        baseViewHolder.m5211a(C2113R.id.tv_description, (CharSequence) sb.toString());
        if (TextUtils.isEmpty(place)) {
            place = C7337y1.m26788m(number);
        }
        baseViewHolder.m5211a(C2113R.id.tv_phone_num, (CharSequence) number).m5211a(C2113R.id.tv_place, (CharSequence) place).m5211a(C2113R.id.tv_date, (CharSequence) callBean.getCrime_time());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((CallSelectNewAdapter) baseViewHolder, i2);
        CallBean callBean = (CallBean) this.f5546A.get(i2);
        CallBean m220a = m220a(callBean);
        if (callBean.isSelect()) {
            ((ImageView) baseViewHolder.m5224c(C2113R.id.iv_checkbox)).setImageResource(C2113R.mipmap.checkbox_checked);
        } else {
            ((ImageView) baseViewHolder.m5224c(C2113R.id.iv_checkbox)).setImageResource(C2113R.mipmap.checkbox_unchecked);
        }
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0056a(baseViewHolder, m220a));
    }

    /* renamed from: a */
    private CallBean m220a(CallBean callBean) {
        List<CallBean> list = this.f181V;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (CallBean callBean2 : this.f181V) {
            if (TextUtils.equals(callBean.getNumber(), callBean2.getNumber()) && TextUtils.equals(callBean.getCrime_time(), callBean2.getCrime_time())) {
                callBean.setSelect(true);
                return callBean2;
            }
        }
        return null;
    }
}
