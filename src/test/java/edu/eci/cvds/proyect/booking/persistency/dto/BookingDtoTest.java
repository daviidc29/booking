package edu.eci.cvds.proyect.booking.persistency.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.eci.cvds.proyect.booking.GroupName;
import edu.eci.cvds.proyect.booking.bookings.BookingStatus;
import edu.eci.cvds.proyect.booking.laboratorys.LaboratoryName;
import edu.eci.cvds.proyect.booking.persistency.entity.Group;
import edu.eci.cvds.proyect.booking.shedules.Day;
import edu.eci.cvds.proyect.booking.shedules.Hour;

 class BookingDtoTest {
    

    @Test
    void getBookingDtoUserIdTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto(10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        assertEquals(10000087,bookingDto.getUserId());
    }

    @Test
    void getBookingDtoLaboratoryNameTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);
        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        assertEquals(LaboratoryName.FUNDAMENTOS,bookingDto.getLaboratoryName());
    }

    @Test
    void getBookingDtoDayTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);
        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.DESARROLLO_VJ, Day.MARTES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        assertEquals(Day.MARTES,bookingDto.getDay());
    }

    @Test
    void getBookingDtoStartHourTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);
        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.DESARROLLO_VJ, Day.MARTES, Hour.OCHO_TREINTA, Hour.DIEZ, BookingStatus.ACTIVED,group);
        assertEquals(Hour.OCHO_TREINTA,bookingDto.getStartHour());
    }

    @Test
    void getBookingDtoEndHourTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto(10000087, LaboratoryName.DESARROLLO_VJ, Day.MARTES, Hour.OCHO_TREINTA, Hour.DIEZ, BookingStatus.ACTIVED,group);
        assertEquals(Hour.DIEZ,bookingDto.getEndHour());
    }

    @Test
    void getBookingDtoStatusTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.DESARROLLO_VJ, Day.MARTES, Hour.ONCE_TREINTA, Hour.DIEZ, BookingStatus.CANCELED,group);
        assertEquals(BookingStatus.CANCELED,bookingDto.getStatus());
    } 
    
    @Test
    void setBookingDtoUserIdTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto(10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        bookingDto.setUserId(20000099);
        assertEquals(20000099, bookingDto.getUserId());
    }

    @Test
    void setBookingDtoLaboratoryNameTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        bookingDto.setLaboratoryName(LaboratoryName.DESARROLLO_VJ);
        assertEquals(LaboratoryName.DESARROLLO_VJ, bookingDto.getLaboratoryName());
    }

    @Test
    void setBookingDtoDayTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        bookingDto.setDay(Day.MIERCOLES);
        assertEquals(Day.MIERCOLES, bookingDto.getDay());
    }

    @Test
    void setBookingDtoStartHourTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        bookingDto.setStartHour(Hour.OCHO_TREINTA);
        assertEquals(Hour.OCHO_TREINTA, bookingDto.getStartHour());
    }

    @Test
    void setBookingEndHourTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        bookingDto.setEndHour(Hour.CUATRO);
        assertEquals(Hour.CUATRO, bookingDto.getEndHour());
    }

    @Test
    void setBookingDtoStatusTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        BookingDto bookingDto = new BookingDto( 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        bookingDto.setStatus(BookingStatus.CANCELED);
        assertEquals(BookingStatus.CANCELED, bookingDto.getStatus());
    }
}