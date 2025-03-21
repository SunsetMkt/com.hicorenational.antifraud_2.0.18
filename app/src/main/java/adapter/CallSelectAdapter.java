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
public class CallSelectAdapter extends BaseQuickAdapter<CallBean, BaseViewHolder> {

    /* renamed from: V */
    private List<CallBean> f175V;

    /* renamed from: W */
    private List<CallBean> f176W;

    /* renamed from: X */
    private InterfaceC0055b f177X;

    /* renamed from: adapter.CallSelectAdapter$a */
    class ViewOnClickListenerC0054a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ BaseViewHolder f178a;

        /* renamed from: b */
        final /* synthetic */ CallBean f179b;

        ViewOnClickListenerC0054a(BaseViewHolder baseViewHolder, CallBean callBean) {
            this.f178a = baseViewHolder;
            this.f179b = callBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CallSelectAdapter.this.f177X != null) {
                CallSelectAdapter.this.f177X.mo218a(this.f178a.getAdapterPosition(), CallSelectAdapter.this.f175V, this.f179b);
            }
        }
    }

    /* renamed from: adapter.CallSelectAdapter$b */
    public interface InterfaceC0055b {
        /* renamed from: a */
        void mo218a(int i2, List<CallBean> list, CallBean callBean);
    }

    public CallSelectAdapter(int i2, List<CallBean> list, List<CallBean> list2) {
        super(i2, list);
        this.f175V = list;
        this.f176W = list2;
    }

    public void setOnItemClickListener(InterfaceC0055b interfaceC0055b) {
        this.f177X = interfaceC0055b;
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
        if (TextUtils.isEmpty(place)) {
            place = C7337y1.m26788m(number);
        }
        baseViewHolder.m5211a(C2113R.id.tv_phone_num, (CharSequence) number).m5211a(C2113R.id.tv_place, (CharSequence) place).m5211a(C2113R.id.tv_date, (CharSequence) callBean.getCrime_time());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((CallSelectAdapter) baseViewHolder, i2);
        CallBean callBean = this.f175V.get(baseViewHolder.getAdapterPosition());
        CallBean m216a = m216a(callBean);
        if (callBean.isSelect()) {
            ((ImageView) baseViewHolder.m5224c(C2113R.id.iv_checkbox)).setImageResource(C2113R.mipmap.checkbox_checked);
        } else {
            ((ImageView) baseViewHolder.m5224c(C2113R.id.iv_checkbox)).setImageResource(C2113R.mipmap.checkbox_unchecked);
        }
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0054a(baseViewHolder, m216a));
    }

    /* renamed from: a */
    private CallBean m216a(CallBean callBean) {
        List<CallBean> list = this.f176W;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (CallBean callBean2 : this.f176W) {
            if (TextUtils.equals(callBean.getNumber(), callBean2.getNumber()) && TextUtils.equals(callBean.getCrime_time(), callBean2.getCrime_time())) {
                callBean.setSelect(true);
                return callBean2;
            }
        }
        return null;
    }
}
