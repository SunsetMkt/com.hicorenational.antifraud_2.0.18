package com.xiaomi.push;

/* renamed from: com.xiaomi.push.gf */
/* loaded from: classes2.dex */
public enum EnumC4239gf {
    Registration(1),
    UnRegistration(2),
    Subscription(3),
    UnSubscription(4),
    SendMessage(5),
    AckMessage(6),
    SetConfig(7),
    ReportFeedback(8),
    Notification(9),
    Command(10),
    MultiConnectionBroadcast(11),
    MultiConnectionResult(12),
    ConnectionKick(13),
    ApnsMessage(14),
    IOSDeviceTokenWrite(15),
    SaveInvalidRegId(16),
    ApnsCertChanged(17),
    RegisterDevice(18),
    ExpandTopicInXmq(19),
    SendMessageNew(22),
    ExpandTopicInXmqNew(23),
    DeleteInvalidMessage(24),
    BadAction(99),
    Presence(100),
    FetchOfflineMessage(101),
    SaveJob(102),
    Broadcast(103),
    BatchPresence(104),
    BatchMessage(105),
    StatCounter(107),
    FetchTopicMessage(108),
    DeleteAliasCache(109),
    UpdateRegistration(110),
    BatchMessageNew(112),
    PublicWelfareMessage(113),
    RevokeMessage(114),
    SimulatorJob(200);


    /* renamed from: a */
    private final int f15491a;

    EnumC4239gf(int i2) {
        this.f15491a = i2;
    }

    /* renamed from: a */
    public int m14968a() {
        return this.f15491a;
    }

    /* renamed from: a */
    public static EnumC4239gf m14967a(int i2) {
        if (i2 == 200) {
            return SimulatorJob;
        }
        switch (i2) {
            case 1:
                return Registration;
            case 2:
                return UnRegistration;
            case 3:
                return Subscription;
            case 4:
                return UnSubscription;
            case 5:
                return SendMessage;
            case 6:
                return AckMessage;
            case 7:
                return SetConfig;
            case 8:
                return ReportFeedback;
            case 9:
                return Notification;
            case 10:
                return Command;
            case 11:
                return MultiConnectionBroadcast;
            case 12:
                return MultiConnectionResult;
            case 13:
                return ConnectionKick;
            case 14:
                return ApnsMessage;
            case 15:
                return IOSDeviceTokenWrite;
            case 16:
                return SaveInvalidRegId;
            case 17:
                return ApnsCertChanged;
            case 18:
                return RegisterDevice;
            case 19:
                return ExpandTopicInXmq;
            default:
                switch (i2) {
                    case 22:
                        return SendMessageNew;
                    case 23:
                        return ExpandTopicInXmqNew;
                    case 24:
                        return DeleteInvalidMessage;
                    default:
                        switch (i2) {
                            case 99:
                                return BadAction;
                            case 100:
                                return Presence;
                            case 101:
                                return FetchOfflineMessage;
                            case 102:
                                return SaveJob;
                            case 103:
                                return Broadcast;
                            case 104:
                                return BatchPresence;
                            case 105:
                                return BatchMessage;
                            default:
                                switch (i2) {
                                    case 107:
                                        return StatCounter;
                                    case 108:
                                        return FetchTopicMessage;
                                    case 109:
                                        return DeleteAliasCache;
                                    case 110:
                                        return UpdateRegistration;
                                    default:
                                        switch (i2) {
                                            case 112:
                                                return BatchMessageNew;
                                            case 113:
                                                return PublicWelfareMessage;
                                            case 114:
                                                return RevokeMessage;
                                            default:
                                                return null;
                                        }
                                }
                        }
                }
        }
    }
}
