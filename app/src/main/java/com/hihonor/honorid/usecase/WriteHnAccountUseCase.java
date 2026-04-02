package com.hihonor.honorid.usecase;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import cn.cloudwalk.util.LogUtils;
import com.hihonor.honorid.UseCase;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.g.c.b;
import java.util.ArrayList;
import l.a.a.a.c;
import l.a.a.a.j.e;

/* JADX INFO: loaded from: classes.dex */
public class WriteHnAccountUseCase extends UseCase<RequestValues> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f4225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<HonorAccount> f4226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4227d;

    public WriteHnAccountUseCase(Context context, ArrayList<HonorAccount> arrayList, boolean z) {
        this.f4225b = context;
        this.f4226c = arrayList;
        this.f4227d = z;
    }

    public static final class RequestValues extends UseCase.RequestValues {
        public static final Parcelable.Creator<RequestValues> CREATOR = new a();
        private String a;

        class a implements Parcelable.Creator<RequestValues> {
            a() {
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
            this.a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a);
        }

        protected RequestValues(Parcel parcel) {
            this.a = parcel.readString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.honorid.UseCase
    public void a(RequestValues requestValues) {
        e.b("WriteHnAccountUseCase", "writeHnAccount", true);
        c.a(this.f4225b, "accounts.xml");
        try {
            b.a(this.f4225b, "accounts.xml", this.f4226c, this.f4227d);
        } catch (Exception unused) {
            e.d("WriteHnAccountUseCase", LogUtils.LOG_EXCEPTION, true);
        }
    }
}
