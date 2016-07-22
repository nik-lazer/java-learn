package lan.training.genereics;

import lan.training.genereics.Column;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NL on 7/20/2016.
 */
public class Table<R> {
    R type;
    List<Column> columns = new ArrayList<>();

    public R getType() {
        return type;
    }

    public void setType(R type) {
        this.type = type;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public String getName() {
        return "Table";
    }
}
