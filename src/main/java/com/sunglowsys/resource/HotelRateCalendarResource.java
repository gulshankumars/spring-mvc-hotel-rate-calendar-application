package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelRateCalendar;
import com.sunglowsys.service.HotelRateCalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class HotelRateCalendarResource {

    private final HotelRateCalendarService hotelRateCalendarService;

    public HotelRateCalendarResource(HotelRateCalendarService hotelRateCalendarService) {
        this.hotelRateCalendarService = hotelRateCalendarService;
    }

    @PostMapping("/hotel-rate-calendars")
    public ResponseEntity<?> createHotelRateCalendar(@RequestBody HotelRateCalendar hotelRateCalendar){
        HotelRateCalendar result = hotelRateCalendarService.save(hotelRateCalendar);
        return ResponseEntity.ok().body(" HotelRateCalendar is created successfully: " + result);
    }

    @PutMapping("/hotel-rate-calendars/{id}")
    public ResponseEntity<?> updateHotelRateCalendar(@RequestBody HotelRateCalendar hotelRateCalendar, @PathVariable("id") Long id){
        hotelRateCalendarService.update(hotelRateCalendar, id);
        return ResponseEntity.ok().body(" HotelRateCalendar is updated successfully: " + id);
    }

    @GetMapping("hotel-rate-calendar/{id}")
    public HotelRateCalendar getHotelRateCalendarById(@PathVariable("id") Long id){
        return hotelRateCalendarService.findById(id);
    }

    @GetMapping
    public List<HotelRateCalendar> getAllHotelRateCalendar(){
        List<HotelRateCalendar> result1 = hotelRateCalendarService.findAll();
        return result1;
    }

    @DeleteMapping("hotel-rate-calendar/{id}")
    public ResponseEntity<?> delete(@RequestBody HotelRateCalendar hotelRateCalendar,@PathVariable("id") Long id){
        hotelRateCalendarService.delete(hotelRateCalendar,id);
        return ResponseEntity.ok().body("HotelRateCalendar is deleted successfully on this id :" + id);
    }
}
