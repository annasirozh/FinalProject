package com.it_academy.onliner.rest_api.model;

import java.util.Objects;

public class SushiVeslaRollsFacet {
    private int id;
    private String name;
    private String name_prefix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_prefix() {
        return name_prefix;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SushiVeslaRollsFacet that = (SushiVeslaRollsFacet) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(name_prefix, that.name_prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, name_prefix);
    }

    @Override
    public String toString() {
        return "SushiVeslaRollsFacet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name_prefix='" + name_prefix + '\'' +
                '}';
    }
}
