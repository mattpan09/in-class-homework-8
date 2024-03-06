package edu.iu.habahram.ducksservice.model;

public record DuckData(int id, String type) implements Comparable<DuckData> {

    public String toLine() {
        return String.format("%1$s,%2$s", id(), type());
    }

    public static DuckData fromLine(String line) {
        String[] tokens = line.split(",");
        return new DuckData(Integer.parseInt(tokens[0]), tokens[1]);
    }

    @Override
    public int compareTo(DuckData o) {
        //Compare the types
        int typeComparison = type.compareTo(o.type);
        if(typeComparison != 0) {
            return typeComparison;
        }
        //If the types are the same, compare the ids
        return Integer.compare(id, o.id);
    }

}
