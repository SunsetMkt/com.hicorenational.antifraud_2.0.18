package p388ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MultiLineRadioGroup extends LinearLayout {

    /* renamed from: a */
    private int f24578a;

    /* renamed from: b */
    private CompoundButton.OnCheckedChangeListener f24579b;

    /* renamed from: c */
    private boolean f24580c;

    /* renamed from: d */
    private InterfaceC7181d f24581d;

    /* renamed from: e */
    private ViewGroupOnHierarchyChangeListenerC7182e f24582e;

    /* renamed from: ui.view.MultiLineRadioGroup$b */
    private class C7179b implements CompoundButton.OnCheckedChangeListener {
        private C7179b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (MultiLineRadioGroup.this.f24580c) {
                return;
            }
            MultiLineRadioGroup.this.f24580c = true;
            if (MultiLineRadioGroup.this.f24578a != -1) {
                MultiLineRadioGroup multiLineRadioGroup = MultiLineRadioGroup.this;
                multiLineRadioGroup.m25787a(multiLineRadioGroup.f24578a, false);
            }
            MultiLineRadioGroup.this.f24580c = false;
            MultiLineRadioGroup.this.setCheckedId(compoundButton.getId());
        }
    }

    /* renamed from: ui.view.MultiLineRadioGroup$c */
    public static class C7180c extends LinearLayout.LayoutParams {
        public C7180c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i2, int i3) {
            if (typedArray.hasValue(i2)) {
                ((LinearLayout.LayoutParams) this).width = typedArray.getLayoutDimension(i2, "layout_width");
            } else {
                ((LinearLayout.LayoutParams) this).width = -2;
            }
            if (typedArray.hasValue(i3)) {
                ((LinearLayout.LayoutParams) this).height = typedArray.getLayoutDimension(i3, "layout_height");
            } else {
                ((LinearLayout.LayoutParams) this).height = -2;
            }
        }

        public C7180c(int i2, int i3) {
            super(i2, i3);
        }

        public C7180c(int i2, int i3, float f2) {
            super(i2, i3, f2);
        }

        public C7180c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C7180c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* renamed from: ui.view.MultiLineRadioGroup$d */
    public interface InterfaceC7181d {
        /* renamed from: a */
        void m25797a(MultiLineRadioGroup multiLineRadioGroup, int i2);
    }

    /* renamed from: ui.view.MultiLineRadioGroup$e */
    private class ViewGroupOnHierarchyChangeListenerC7182e implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a */
        private ViewGroup.OnHierarchyChangeListener f24584a;

        private ViewGroupOnHierarchyChangeListenerC7182e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        @SuppressLint({"NewApi"})
        public void onChildViewAdded(View view, View view2) {
            List<RadioButton> m25785a;
            MultiLineRadioGroup multiLineRadioGroup = MultiLineRadioGroup.this;
            if (view == multiLineRadioGroup && (m25785a = multiLineRadioGroup.m25785a(view2)) != null && m25785a.size() > 0) {
                for (RadioButton radioButton : m25785a) {
                    if (radioButton.getId() == -1 && Build.VERSION.SDK_INT >= 17) {
                        radioButton.setId(View.generateViewId());
                    }
                    radioButton.setOnCheckedChangeListener(MultiLineRadioGroup.this.f24579b);
                }
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f24584a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            List m25785a;
            MultiLineRadioGroup multiLineRadioGroup = MultiLineRadioGroup.this;
            if (view == multiLineRadioGroup && (m25785a = multiLineRadioGroup.m25785a(view2)) != null && m25785a.size() > 0) {
                Iterator it = m25785a.iterator();
                while (it.hasNext()) {
                    ((RadioButton) it.next()).setOnCheckedChangeListener(null);
                }
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f24584a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public MultiLineRadioGroup(Context context) {
        super(context);
        this.f24578a = -1;
        this.f24580c = false;
        setOrientation(1);
        m25793b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i2) {
        this.f24578a = i2;
        InterfaceC7181d interfaceC7181d = this.f24581d;
        if (interfaceC7181d != null) {
            interfaceC7181d.m25797a(this, this.f24578a);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        List<RadioButton> m25785a = m25785a(view);
        if (m25785a != null && m25785a.size() > 0) {
            for (RadioButton radioButton : m25785a) {
                if (radioButton.isChecked()) {
                    this.f24580c = true;
                    int i3 = this.f24578a;
                    if (i3 != -1) {
                        m25787a(i3, false);
                    }
                    this.f24580c = false;
                    setCheckedId(radioButton.getId());
                }
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C7180c;
    }

    public int getCheckedRadioButtonId() {
        return this.f24578a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MultiLineRadioGroup.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MultiLineRadioGroup.class.getName());
    }

    public void setCheckWithoutNotif(int i2) {
        if (i2 == -1 || i2 != this.f24578a) {
            this.f24580c = true;
            int i3 = this.f24578a;
            if (i3 != -1) {
                m25787a(i3, false);
            }
            if (i2 != -1) {
                m25787a(i2, true);
            }
            this.f24578a = i2;
            this.f24580c = false;
        }
    }

    public void setOnCheckedChangeListener(InterfaceC7181d interfaceC7181d) {
        this.f24581d = interfaceC7181d;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f24582e.f24584a = onHierarchyChangeListener;
    }

    /* renamed from: b */
    private void m25793b() {
        this.f24579b = new C7179b();
        this.f24582e = new ViewGroupOnHierarchyChangeListenerC7182e();
        super.setOnHierarchyChangeListener(this.f24582e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new C7180c(-2, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public C7180c generateLayoutParams(AttributeSet attributeSet) {
        return new C7180c(getContext(), attributeSet);
    }

    public MultiLineRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24578a = -1;
        this.f24580c = false;
        m25793b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<RadioButton> m25785a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof RadioButton) {
            arrayList.add((RadioButton) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                arrayList.addAll(m25785a(viewGroup.getChildAt(i2)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m25796a(int i2) {
        if (i2 == -1 || i2 != this.f24578a) {
            int i3 = this.f24578a;
            if (i3 != -1) {
                m25787a(i3, false);
            }
            if (i2 != -1) {
                m25787a(i2, true);
            }
            setCheckedId(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25787a(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById == null || !(findViewById instanceof RadioButton)) {
            return;
        }
        ((RadioButton) findViewById).setChecked(z);
    }

    /* renamed from: a */
    public void m25795a() {
        m25796a(-1);
    }
}
