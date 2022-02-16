package com.sunglowsys.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "hotel_rate_calendar")
public class HotelRateCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;

    @NotNull
    private Integer singleOccupancy ;

    @NotNull
    private Integer doubleOccupancy ;

    @NotNull
    private Integer extraAdultPrice ;

    @NotNull
    private Integer extraChildPrice ;

    @NotNull
    private Integer applicableDays ;

    @NotNull
    private Long hotelId ;

    @NotNull
    private Long hotelRoomRateId ;

    public HotelRateCalendar(){}

    public HotelRateCalendar(Long id, Integer singleOccupancy, Integer doubleOccupancy, Integer extraAdultPrice, Integer extraChildPrice, Integer applicableDays, Long hotelId, Long hotelRoomRateId) {
        this.id = id;
        this.singleOccupancy = singleOccupancy;
        this.doubleOccupancy = doubleOccupancy;
        this.extraAdultPrice = extraAdultPrice;
        this.extraChildPrice = extraChildPrice;
        this.applicableDays = applicableDays;
        this.hotelId = hotelId;
        this.hotelRoomRateId = hotelRoomRateId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSingleOccupancy() {
        return singleOccupancy;
    }

    public void setSingleOccupancy(Integer singleOccupancy) {
        this.singleOccupancy = singleOccupancy;
    }

    public Integer getDoubleOccupancy() {
        return doubleOccupancy;
    }

    public void setDoubleOccupancy(Integer doubleOccupancy) {
        this.doubleOccupancy = doubleOccupancy;
    }

    public Integer getExtraAdultPrice() {
        return extraAdultPrice;
    }

    public void setExtraAdultPrice(Integer extraAdultPrice) {
        this.extraAdultPrice = extraAdultPrice;
    }

    public Integer getExtraChildPrice() {
        return extraChildPrice;
    }

    public void setExtraChildPrice(Integer extraChildPrice) {
        this.extraChildPrice = extraChildPrice;
    }

    public Integer getApplicableDays() {
        return applicableDays;
    }

    public void setApplicableDays(Integer applicableDays) {
        this.applicableDays = applicableDays;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getHotelRoomRateId() {
        return hotelRoomRateId;
    }

    public void setHotelRoomRateId(Long hotelRoomRateId) {
        this.hotelRoomRateId = hotelRoomRateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRateCalendar that = (HotelRateCalendar) o;
        return Objects.equals(id, that.id) && Objects.equals(singleOccupancy, that.singleOccupancy) && Objects.equals(doubleOccupancy, that.doubleOccupancy) && Objects.equals(extraAdultPrice, that.extraAdultPrice) && Objects.equals(extraChildPrice, that.extraChildPrice) && Objects.equals(applicableDays, that.applicableDays) && Objects.equals(hotelId, that.hotelId) && Objects.equals(hotelRoomRateId, that.hotelRoomRateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, singleOccupancy, doubleOccupancy, extraAdultPrice, extraChildPrice, applicableDays, hotelId, hotelRoomRateId);
    }

    @Override
    public String toString() {
        return "HotelRateCalendar{" +
                "id=" + id +
                ", singleOccupancy=" + singleOccupancy +
                ", doubleOccupancy=" + doubleOccupancy +
                ", extraAdultPrice=" + extraAdultPrice +
                ", extraChildPrice=" + extraChildPrice +
                ", applicableDays=" + applicableDays +
                ", hotelId=" + hotelId +
                ", hotelRoomRateId=" + hotelRoomRateId +
                '}';
    }
}
