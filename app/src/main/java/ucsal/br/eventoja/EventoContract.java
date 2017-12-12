package ucsal.br.eventoja;

import android.provider.BaseColumns;

public class EventoContract {

    public static final String DB_NOME = "MyEventos.db";
    public static final int DB_VERSAO = 1;
    public static final String SQL_CREATE_TABLE = "CREATE TABLE " +
            EventoEntry.TABELA_NOME + " (" +
            EventoEntry._ID + " INTEGER PRIMARY KEY," +
            EventoEntry.COLUNA_NOME_NOME + " TEXT," +
            EventoEntry.COLUNA_NOME_DATA + " TEXT," +
            EventoEntry.COLUNA_NOME_HORA + " TEXT," +
            EventoEntry.COLUNA_NOME_LOCAL + " TEXT," +
            EventoEntry.COLUNA_NOME_ENDERECO + " TEXT," +
            EventoEntry.COLUNA_NOME_LATITUDE + " TEXT," +
            EventoEntry.COLUNA_NOME_LONGITUDE + " TEXT," +
            EventoEntry.COLUNA_NOME_PRECO + " TEXT," +
            EventoEntry.COLUNA_NOME_DETALHES + " TEXT," +
            EventoEntry.COLUNA_NOME_IMAGEM + " TEXT)";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + EventoEntry.TABELA_NOME;

    public static class EventoEntry implements BaseColumns {
        public static final String TABELA_NOME = "evento";
        public static final String COLUNA_NOME_NOME = "nome";
        public static final String COLUNA_NOME_DATA = "data";
        public static final String COLUNA_NOME_HORA = "hora";
        public static final String COLUNA_NOME_LOCAL = "local";
        public static final String COLUNA_NOME_ENDERECO = "endereco";
        public static final String COLUNA_NOME_LATITUDE = "latitude";
        public static final String COLUNA_NOME_LONGITUDE = "longitude";
        public static final String COLUNA_NOME_PRECO = "preco";
        public static final String COLUNA_NOME_DETALHES = "detalhes";
        public static final String COLUNA_NOME_IMAGEM = "imagem";
    }
}