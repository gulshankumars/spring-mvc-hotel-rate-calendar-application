package com.sunglowsys.service;

import com.sunglowsys.domain.HotelRateCalendar;
import com.sunglowsys.repository.HotelRateCalendarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelRateCalendarServiceImpl implements HotelRateCalendarService{

    private final HotelRateCalendarRepository hotelRateCalendarRepository;

    public HotelRateCalendarServiceImpl(HotelRateCalendarRepository hotelRateCalendarRepository) {
        this.hotelRateCalendarRepository = hotelRateCalendarRepository;
    }


    @Override
    public HotelRateCalendar save(HotelRateCalendar hotelRateCalendar) {
        return hotelRateCalendarRepository.save(hotelRateCalendar);
    }

    @Override
    public HotelRateCalendar update(HotelRateCalendar hotelRateCalendar, Long id) {
        HotelRateCalendar hotelRateCalendar1 = hotelRateCalendarRepository.findById(id).get();
        hotelRateCalendar1.setSingleOccupancy(hotelRateCalendar1.getSingleOccupancy());
        hotelRateCalendar1.setDoubleOccupancy(hotelRateCalendar1.getDoubleOccupancy());
        hotelRateCalendar1.setExtraAdultPrice(hotelRateCalendar1.getExtraAdultPrice());
        hotelRateCalendar1.setExtraChildPrice(hotelRateCalendar1.getExtraChildPrice());
        hotelRateCalendar1.setApplicableDays(hotelRateCalendar1.getApplicableDays());
        hotelRateCalendar1.setHotelId(hotelRateCalendar1.getHotelId());
        hotelRateCalendar1.setHotelRoomRateId(hotelRateCalendar1.getHotelRoomRateId());
        return hotelRateCalendarRepository.save(hotelRateCalendar);
    }

    @Override
    public HotelRateCalendar findById(Long id) {
        return hotelRateCalendarRepository.findById(id).get();
    }

    @Override
    public List<HotelRateCalendar> findAll() {
        return hotelRateCalendarRepository.findAll();
    }

    @Override
    public void delete(HotelRateCalendar hotelRateCalendar, Long id) {
        hotelRateCalendarRepository.deleteById(id);
    }
}
