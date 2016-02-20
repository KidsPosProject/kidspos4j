package info.nukoneko.kidspos4j.model;

import rx.Observable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by atsumi on 2016/02/03.
 */
final public class DataItemGenreImpl extends DataBase<ModelItemGenre> {

    @Override
    String QueryCreate() {
        return "CREATE TABLE IF NOT EXISTS " + getTableKind().getName() +
                "(id INTEGER  PRIMARY KEY AUTOINCREMENT, name TEXT, store TEXT)";
    }

    @Override
    String QueryInsert(ModelItemGenre item) {
        return String
                .format("INSERT INTO %s(name, store) VALUES('%s','%s')",
                        getTableKind().getName(), item.getName(), item.getStore());
    }

    @Override
    String QueryUpdate(ModelItemGenre item) {
        return null;
    }

    @Override
    public Observable<ModelItemGenre> findAllRx() {
        ArrayList<ModelItemGenre> list = find(ModelItemGenre.class);
        return Observable.from(list.toArray(new ModelItemGenre[list.size()]));
    }

    @Override
    public ArrayList<ModelItemGenre> findAll() {
        return find(ModelItemGenre.class);
    }

    @Override
    public ArrayList<ModelItemGenre> find(String where) {
        return find(ModelItemGenre.class, where);
    }

    @Override
    public ModelItemGenre findFirst(String where) {
        ArrayList<ModelItemGenre> arrayList =
                find(ModelItemGenre.class, where);
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList.get(0);
    }

    @Override
    public ModelItemGenre findFromBarcode(String barcode) {
        return null;
    }

    @Override
    void setValues(ModelItemGenre model, ResultSet rs) throws SQLException {
        model.setId(rs.getInt("id"));
        model.setName(rs.getString("name"));
        model.setStore(rs.getString("store"));
    }

    @Override
    TableKind getTableKind() {
        return TableKind.ITEM_GENRE;
    }
}
