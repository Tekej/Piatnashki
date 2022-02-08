package sample;

import javafx.beans.property.SimpleStringProperty;

public class ScoreTable{



    private SimpleStringProperty name;
    private SimpleStringProperty grid;
    private SimpleStringProperty time;

    public ScoreTable(String s1, String s2, String s3){
        name = new SimpleStringProperty(s1);
        grid = new SimpleStringProperty(s2);
        time = new SimpleStringProperty(s3);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getGrid() {
        return grid.get();
    }

    public SimpleStringProperty gridProperty() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid.set(grid);
    }
    @Override
    public String toString(){
        return (name.get() + " " + grid.get() + " " + time.get());
    }



}
