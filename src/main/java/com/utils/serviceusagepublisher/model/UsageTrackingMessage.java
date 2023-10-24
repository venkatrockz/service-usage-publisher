package com.utils.serviceusagepublisher.model;

import lombok.Data;

@Data
public class UsageTrackingMessage {
    private String clientId;
    private String eventId;
}

