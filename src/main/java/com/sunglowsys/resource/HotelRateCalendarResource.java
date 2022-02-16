package com.sunglowsys.resource;



import com.sunglowsys.domain.HotelRateCalendar;
import com.sunglowsys.resource.util.BadRequestException;
import com.sunglowsys.service.HotelRateCalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class HotelRateCalendarResource {

    private final Logger log = LoggerFactory.getLogger(HotelRateCalendarResource.class);

    private final HotelRateCalendarService hotelRateCalendarService;

    public HotelRateCalendarResource(HotelRateCalendarService hotelRateCalendarService) {
        this.hotelRateCalendarService = hotelRateCalendarService;
    }

    @PostMapping("/hotel-rate-calendars")
    public ResponseEntity<HotelRateCalendar> createHotelRateCalendar(@RequestBody HotelRateCalendar hotelRateCalendar) throws URISyntaxException {
        log.debug("REST request to create HotelRateCalendar : {}", hotelRateCalendar);
        if (hotelRateCalendar.getId() != null){
            throw new BadRequestException("Id should be null in create api call");
        }
        HotelRateCalendar result = hotelRateCalendarService.save(hotelRateCalendar);
        return ResponseEntity
                .created(new URI("/api/hotel-rate-calendars/" + result.getId()))
                .body(result);
    }

    @PutMapping("/hotel-rate-calendar")
    public ResponseEntity<HotelRateCalendar> updateHotelRateCalendar(@RequestBody HotelRateCalendar hotelRateCalendar) throws  URISyntaxException{
        log.debug("REST request to update HotelRateCalendar : {}", hotelRateCalendar);
        if (hotelRateCalendar.getId() == null){
            throw new BadRequestException("Id should not be null in update api call");
        }
        HotelRateCalendar result = hotelRateCalendarService.update(hotelRateCalendar);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/hotel-rate-calendars")
    public ResponseEntity<List<HotelRateCalendar>> getAllHotelRateCalendars(@RequestBody Pageable pageable){
        log.debug("REST request to get HotelRateCalendars : {}",pageable.toString());
        Page<HotelRateCalendar> result = hotelRateCalendarService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("/hotel-rate-calendar/{id}")
    public ResponseEntity<HotelRateCalendar> getHotelRateCalendar(@PathVariable Long id){
        log.debug("REST request to get HotelRateCalendar : {}", id);
        Optional<HotelRateCalendar> result = hotelRateCalendarService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @DeleteMapping("/hotel-rate-calendar")
    public ResponseEntity<Void> deleteHotelRateCalendar(@PathVariable Long id){
        log.debug("REST request to delete HotelRateCalendar : {}", id);
        hotelRateCalendarService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
