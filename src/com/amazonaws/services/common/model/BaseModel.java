package com.amazonaws.services.common.model;

import com.j256.ormlite.field.DatabaseField;

public class BaseModel {

    @DatabaseField(canBeNull = false)
    private String userId;

    @DatabaseField(canBeNull = false)
    private String regionCode;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
