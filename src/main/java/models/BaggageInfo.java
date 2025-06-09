package models;



public class BaggageInfo {
    private int baggageId;
    private int flightId;
    private int checkinWeightPerAdultKg;
    private int cabinWeightPerAdultKg;

    @Override
    public String toString() {
        return "BaggageInfo{" +
                "baggageId=" + baggageId +
                ", flightId=" + flightId +
                ", checkinWeightPerAdultKg=" + checkinWeightPerAdultKg +
                ", cabinWeightPerAdultKg=" + cabinWeightPerAdultKg +
                '}';
    }

    public BaggageInfo() {
    }

    public BaggageInfo(int baggageId, int flightId, int checkinWeightPerAdultKg, int cabinWeightPerAdultKg) {
        this.baggageId = baggageId;
        this.flightId = flightId;
        this.checkinWeightPerAdultKg = checkinWeightPerAdultKg;
        this.cabinWeightPerAdultKg = cabinWeightPerAdultKg;
    }

    public int getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(int baggageId) {
        this.baggageId = baggageId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getCheckinWeightPerAdultKg() {
        return checkinWeightPerAdultKg;
    }

    public void setCheckinWeightPerAdultKg(int checkinWeightPerAdultKg) {
        this.checkinWeightPerAdultKg = checkinWeightPerAdultKg;
    }

    public int getCabinWeightPerAdultKg() {
        return cabinWeightPerAdultKg;
    }

    public void setCabinWeightPerAdultKg(int cabinWeightPerAdultKg) {
        this.cabinWeightPerAdultKg = cabinWeightPerAdultKg;
    }
}
