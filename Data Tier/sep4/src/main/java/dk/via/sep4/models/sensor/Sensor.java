package dk.via.sep4.models.sensor;

import dk.via.sep4.models.CO2.CO2;
import dk.via.sep4.models.humidity.Humidity;
import dk.via.sep4.models.room.Room;
import dk.via.sep4.models.temperature.Temperature;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Sensor {
    @Id
    @Column(updatable = false)
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensor_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TemperatureId")
    private Temperature temperature;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HumidityId")
    private Humidity humidity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CO2Id")
    private CO2 co2;

    @Column
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    public Sensor(CO2 co2, Humidity humidity, Temperature temperature, Timestamp time) {
        this.co2 = co2;
        this.humidity = humidity;
        this.temperature = temperature;
        this.time = time;
    }

    /**
     * Instantiates a new Sensor.
     */
    public Sensor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public CO2 getCO2() {
        return co2;
    }

    public void setCO2(CO2 co2) {
        this.co2 = co2;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}