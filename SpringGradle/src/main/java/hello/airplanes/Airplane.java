package hello.airplanes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Airplane {

    @JsonProperty("id")
    private  int id;
    @JsonProperty("passengers")
    private  int passengers;
    @JsonProperty("description")
    private String description;

    public Airplane(int id, int passangers, String description) {
        this.id = id;
        this.passengers = passangers;
        this.description = description;
    }

    public Airplane(int passengers, String description) {
        this.passengers = passengers;
        this.description = description;
    }

    public Airplane() {
    }

    public int getId() {
        return id;
    }

    public int getPassengers() {
        return passengers;
    }

    public String getDescription() {
        return description;
    }



    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

