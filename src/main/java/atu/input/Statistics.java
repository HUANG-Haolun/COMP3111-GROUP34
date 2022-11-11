package atu.input;

import javafx.beans.property.SimpleStringProperty;

public class Statistics {

    private final SimpleStringProperty entry;
    private final SimpleStringProperty value;
    private final SimpleStringProperty index;

    public Statistics(String fName, String lName, String index) {
        this.entry = new SimpleStringProperty(fName);
        this.value = new SimpleStringProperty(lName);
        this.index = new SimpleStringProperty(index);
    }

    public String getEntry() {
        return entry.get();
    }

    public void setEntry(String val) {
        entry.set(val);
    }

    public String getValue() {
        return value.get();
    }

    public void setValue(String val) {
        value.set(val);
    }

    public String getIndex() {
        return index.get();
    }

    public void setIndex(String val) {
        index.set(val);
    }

}

