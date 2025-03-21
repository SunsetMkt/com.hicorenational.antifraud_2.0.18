package com.hihonor.honorid.usecase;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import cn.cloudwalk.util.LogUtils;
import com.hihonor.honorid.UseCase;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.p166g.p167c.C2177b;
import java.util.ArrayList;
import p358k.p359a.p360a.p361a.C5849c;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* loaded from: classes.dex */
public class WriteHnAccountUseCase extends UseCase<RequestValues> {

    /* renamed from: b */
    private Context f6734b;

    /* renamed from: c */
    private ArrayList<HonorAccount> f6735c;

    /* renamed from: d */
    private boolean f6736d;

    public WriteHnAccountUseCase(Context context, ArrayList<HonorAccount> arrayList, boolean z) {
        this.f6734b = context;
        this.f6735c = arrayList;
        this.f6736d = z;
    }

    public static final class RequestValues extends UseCase.RequestValues {
        public static final Parcelable.Creator<RequestValues> CREATOR = new C2179a();

        /* renamed from: a */
        private String f6737a;

        /* renamed from: com.hihonor.honorid.usecase.WriteHnAccountUseCase$RequestValues$a */
        class C2179a implements Parcelable.Creator<RequestValues> {
            C2179a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestValues createFromParcel(Parcel parcel) {
                return new RequestValues(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestValues[] newArray(int i2) {
                return new RequestValues[i2];
            }
        }

        public RequestValues(String str) {
            this.f6737a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f6737a);
        }

        protected RequestValues(Parcel parcel) {
            this.f6737a = parcel.readString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.honorid.UseCase
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo6090a(RequestValues requestValues) {
        C5863e.m24692b("WriteHnAccountUseCase", "writeHnAccount", true);
        C5849c.m24630a(this.f6734b, "accounts.xml");
        try {
            C2177b.m6340a(this.f6734b, "accounts.xml", this.f6735c, this.f6736d);
        } catch (Exception unused) {
            C5863e.m24694d("WriteHnAccountUseCase", LogUtils.LOG_EXCEPTION, true);
        }
    }
}
