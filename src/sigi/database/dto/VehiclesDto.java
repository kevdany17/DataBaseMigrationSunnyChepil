package sigi.database.dto;

public class VehiclesDto {
    private String brand;
    private String model;
    private String licenceP;
    private String alias;
    private String description;
    private Long km;

    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getLicenceP(){
        return licenceP;
    }
    public void setLicenceP(String licenceP){
        this.licenceP = licenceP;
    }

    public String getAlias(){
        return alias;
    }
    public void setAlias(String alias){
        this.alias = alias;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Long getKm(){
        
        return km;
    }
    public void setKm(Long km){

        this.km = km;
    }

}
