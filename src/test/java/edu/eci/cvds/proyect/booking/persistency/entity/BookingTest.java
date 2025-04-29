package edu.eci.cvds.proyect.booking.persistency.entity;

import org.junit.jupiter.api.Test;
import edu.eci.cvds.proyect.booking.shedules.Hour;
import edu.eci.cvds.proyect.booking.GroupName;
import edu.eci.cvds.proyect.booking.bookings.BookingStatus;
import edu.eci.cvds.proyect.booking.laboratorys.LaboratoryName;
import edu.eci.cvds.proyect.booking.shedules.Day;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class BookingTest {
    @Test
    void getBookingIdTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);
        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        assertEquals(123, booking.getId());
    }

    @Test
    void getBookingUserIdTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        assertEquals(10000087,booking.getUserId());
    }

    @Test
    void getBookingLaboratoryNameTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        assertEquals(LaboratoryName.FUNDAMENTOS,booking.getLaboratoryName());
    }

    @Test
    void getBookingDayTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.DESARROLLO_VJ, Day.MARTES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        assertEquals(Day.MARTES,booking.getDay());
    }

    @Test
    void getBookingStartHourTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.DESARROLLO_VJ, Day.MARTES, Hour.OCHO_TREINTA, Hour.DIEZ, BookingStatus.ACTIVED,group);
        assertEquals(Hour.OCHO_TREINTA,booking.getStartHour());
    }

    @Test
    void getBookingEndHourTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.DESARROLLO_VJ, Day.MARTES, Hour.OCHO_TREINTA, Hour.DIEZ, BookingStatus.ACTIVED,group);
        assertEquals(Hour.DIEZ,booking.getEndHour());
    }

    @Test
    void getBookingStatusTest(){
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.DESARROLLO_VJ, Day.MARTES, Hour.ONCE_TREINTA, Hour.DIEZ, BookingStatus.CANCELED,group);
        assertEquals(BookingStatus.CANCELED,booking.getStatus());
    } 
    
    @Test
    void setBookingIdTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        booking.setId(456);
        assertEquals(456, booking.getId());
    }

    @Test
    void setBookingUserIdTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        booking.setUserId(20000099);
        assertEquals(20000099, booking.getUserId());
    }

    @Test
    void setBookingLaboratoryNameTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        booking.setLaboratoryName(LaboratoryName.DESARROLLO_VJ);
        assertEquals(LaboratoryName.DESARROLLO_VJ, booking.getLaboratoryName());
    }

    @Test
    void setBookingDayTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        booking.setDay(Day.MIERCOLES);
        assertEquals(Day.MIERCOLES, booking.getDay());
    }

    @Test
    void setBookingStartHourTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        booking.setStartHour(Hour.OCHO_TREINTA);
        assertEquals(Hour.OCHO_TREINTA, booking.getStartHour());
    }

    @Test
    void setBookingEndHourTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        booking.setEndHour(Hour.CUATRO);
        assertEquals(Hour.CUATRO, booking.getEndHour());
    }

    @Test
    void setBookingStatusTest() {
        Group group = new Group(1,1,GroupName.ACSO,2);

        Booking booking = new Booking(123, 10000087, LaboratoryName.FUNDAMENTOS, Day.LUNES, Hour.ONCE_TREINTA, Hour.UNA, BookingStatus.ACTIVED,group);
        booking.setStatus(BookingStatus.CANCELED);
        assertEquals(BookingStatus.CANCELED, booking.getStatus());
    }
}