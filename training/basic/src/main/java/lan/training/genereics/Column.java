package lan.training.genereics;

/**
 * Created by NL on 7/20/2016.
*/
public class Column {
    private String value;

    public Column(String value) {
        this.value = value;
    }

    public String getTitle() {
        return "Column";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
