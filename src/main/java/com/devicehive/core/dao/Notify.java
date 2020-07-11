package com.devicehive.core.dao;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "notify")
@TypeDef(name = "JsonbType", typeClass = JsonbType.class)
public class Notify {
    @Column
    private String notification;

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "networkid")
    private Integer networkId;
    @Column(name = "devicetypeid")
    private Integer deviceTypeId;
    @Column(name = "deviceid")
    private String deviceId;

    public Integer getNetworkId() {
        return networkId;
    }

    @Override
    public String toString() {
        return "Notify{" +
                "notification='" + notification + '\'' +
                ", id='" + id + '\'' +
                ", networkId=" + networkId +
                ", deviceTypeId=" + deviceTypeId +
                ", deviceId='" + deviceId + '\'' +
                ", timestamp=" + timestamp +
                ", parameters=" + parameters +
                '}';
    }

    public void setNetworkId(Integer networkId) {
        this.networkId = networkId;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;



    @Column(columnDefinition = "parameters")
    @Type(type = "JsonbType")
    private Map<String,Object> parameters;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }



}
