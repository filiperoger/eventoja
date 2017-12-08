package ucsal.br.eventoja;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventoDbHelper extends SQLiteOpenHelper {

    public EventoDbHelper(Context context) {
        super(context, EventoContract.DB_NOME, null, EventoContract.DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(EventoContract.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(EventoContract.SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }
}