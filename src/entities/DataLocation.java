package entities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataLocation {

    private String modelCar;
    private LocalDateTime instantInitial;
    private LocalDateTime finalLocation;

    public DataLocation(LocalDateTime instantInitial, LocalDateTime finalLocation, String modelCar) {
        this.modelCar = modelCar;
        this.instantInitial = instantInitial;
        this.finalLocation = finalLocation;
    }

    public DataLocation(LocalDateTime instantInitial, LocalDateTime finalLocation) {
        this.instantInitial = instantInitial;
        this.finalLocation = finalLocation;
    }


    public String getModelCar() {
        return modelCar;
    }

    public LocalDateTime getInstantInitial() {
        return instantInitial;
    }

    public LocalDateTime getFinalLocation() {
        return finalLocation;
    }
}
