package hello.airplanes;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class AirplaneController {

    ArrayList<Airplane> airplanes = new ArrayList<Airplane>(Arrays.asList(new Airplane(1,100,"boeing 100"), new Airplane(2,200,"boeing 200")));

    @RequestMapping(value = "/airplanes",  method = RequestMethod.GET)
    public ArrayList<Airplane> getAirplanes(){
        return airplanes;

    }


    @RequestMapping(value = "/airplanes",  method = RequestMethod.POST)
    public ArrayList<Airplane> addAirplanes(@RequestBody Airplane airplane){
        airplanes.add(airplane);
        return airplanes;

    }

    @RequestMapping(value = "/airplanes/{id}", method = RequestMethod.DELETE)
    public ArrayList<Airplane> deleteAirplanes(@PathVariable ("id")int id){

        Airplane airplaneToDelete = null;
        for(Airplane airplane : airplanes){
            if(airplane.getId()== id){
                airplaneToDelete = airplane;
            }
        }
        airplanes.remove(airplaneToDelete);


        return airplanes;
    }

    @RequestMapping(value = "/airplanes/{id}",  method = RequestMethod.PUT)
    public @ResponseBody ArrayList<Airplane> changeAirplane(@PathVariable ("id") int id, @RequestBody Airplane airplane){
        Airplane airplaneToChange = null;
        for(Airplane plane : airplanes){
            if(plane.getId()== id){
                airplaneToChange = plane;
            }
        }

        airplaneToChange.setDescription(airplane.getDescription());
        airplaneToChange.setPassengers(airplane.getPassengers());

        return airplanes;
    }
}
