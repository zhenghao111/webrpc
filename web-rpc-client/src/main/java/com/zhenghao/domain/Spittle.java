package com.zhenghao.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Spittle implements Serializable {

    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;
    private Spitter spitter;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        //使用Apache Commons
        return EqualsBuilder.reflectionEquals(this, o, "id", "name");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "name");
    }
}
