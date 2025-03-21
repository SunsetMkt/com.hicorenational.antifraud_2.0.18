package p388ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class SettingSwitchItemView extends LinearLayout {

    /* renamed from: a */
    private ViewGroup f24669a;

    /* renamed from: b */
    private TextView f24670b;

    /* renamed from: c */
    private Switch f24671c;

    /* renamed from: ui.view.SettingSwitchItemView$a */
    class ViewOnClickListenerC7196a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ View.OnClickListener f24672a;

        ViewOnClickListenerC7196a(View.OnClickListener onClickListener) {
            this.f24672a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f24672a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public SettingSwitchItemView(Context context) {
        super(context);
        m25843a(null);
    }

    /* renamed from: a */
    private void m25843a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(C2113R.layout.layout_settings_radio_item, (ViewGroup) this, true);
        this.f24669a = (ViewGroup) findViewById(C2113R.id.container_settings);
        this.f24670b = (TextView) findViewById(C2113R.id.tv_settings_title);
        this.f24671c = (Switch) findViewById(C2113R.id.swicth_settings);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C2113R.styleable.SettingSwitchItemView);
            String string = obtainStyledAttributes.getString(1);
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            this.f24670b.setText(string);
            this.f24671c.setChecked(z);
        }
    }

    public void setItemEnable(boolean z) {
        this.f24669a.setEnabled(z);
    }

    public void setOnSwitchCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch r0 = this.f24671c;
        if (r0 != null) {
            r0.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setSettingItemClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f24669a;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new ViewOnClickListenerC7196a(onClickListener));
        }
    }

    public void setSwichChecked(boolean z) {
        Switch r0 = this.f24671c;
        if (r0 != null) {
            r0.setChecked(z);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f24670b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public SettingSwitchItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25843a(attributeSet);
    }

    public SettingSwitchItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m25843a(attributeSet);
    }
}
