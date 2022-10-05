package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(!(object instanceof Job)) return false;
        return this.getId() == ((Job) object).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String str = "\n";
        if(allFieldsAreNull()) {
            str += "OOPS! This job does not seem to exist.";
        } else {
            str += "ID: " + getId();
            str += "Name: " + name == null || name == "" ? "Data not available" : name;
            str += "Employer: " + employer == null || employer.getValue() == "" ? "Data not available" : employer.getValue();
            str += "Location: " + location == null || location.getValue() == "" ? "Data not available" : location.getValue();
            str += "Position Type: " + positionType == null || positionType.getValue() == "" ? "Data not available" : positionType.getValue();
            str += "Core Competency: " + coreCompetency == null || coreCompetency.getValue() == "" ? "Data not available" : coreCompetency.getValue();
        }
        return str + "\n";
    }

    private boolean allFieldsAreNull() {
        return  name == null
                && employer == null
                && location == null
                && positionType == null
                && coreCompetency == null;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
