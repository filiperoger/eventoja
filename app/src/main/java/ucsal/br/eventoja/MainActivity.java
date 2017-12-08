package ucsal.br.eventoja;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;
import ucsal.br.eventoja.EventoContract.EventoEntry;

public class MainActivity extends AppCompatActivity {

    private EventoCursorAdapter adapter;
    Evento[] eventos;
    private EventoDbHelper eventoDbHelper = new EventoDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titulo = (TextView) this.findViewById(R.id.titulo);
        titulo.setText(R.string.eventos_titulo);

        SQLiteDatabase db = eventoDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM evento", null);
        adapter = new EventoCursorAdapter(this, cursor);

        ListView lista_eventos = (ListView) this.findViewById(R.id.lista_eventos);
        lista_eventos.setAdapter(adapter);

        Context context = this;
        String text = "Olá Filipe!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        lista_eventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detalheActivity = new Intent(MainActivity.this, DetalheActivity.class);
                detalheActivity.putExtra("posicao", i);
                startActivity(detalheActivity);
            }
        });
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://raw.githubusercontent.com/filiperoger/eventoja/master/eventos.txt",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("AsyncHttpClient", "onFailure response = " + responseString);
                        Log.d("AsyncHttpClient", throwable.toString());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "onSuccess response = " + responseString);

                        Gson gson = new GsonBuilder().create();
                        eventos = gson.fromJson(responseString, Evento[].class);

                        inserirEventoDB(eventos);

                        SQLiteDatabase db = eventoDbHelper.getWritableDatabase();
                        Cursor cursor = db.rawQuery("SELECT * FROM evento", null);
                        adapter.changeCursor(cursor);
                    }
                });
    }

    private void inserirEventoDB(Evento[] eventos) {
        SQLiteDatabase db = eventoDbHelper.getWritableDatabase();
        for (Evento e : eventos) {
            ContentValues values = new ContentValues();
            values.put(EventoEntry.COLUNA_NOME_NOME, e.getNome());
            values.put(EventoEntry.COLUNA_NOME_DATA, e.getData());
            values.put(EventoEntry.COLUNA_NOME_LOCAL, e.getLocal());
            values.put(EventoEntry.COLUNA_NOME_ENDERECO, e.getEndereco());
//            values.put(EventoEntry.COLUNA_NOME_LATITUDE, e.getLatitude());
//            values.put(EventoEntry.COLUNA_NOME_LONGITUDE, e.getLongitude());
            values.put(EventoEntry.COLUNA_NOME_PRECO, e.getPreco());
            values.put(EventoEntry.COLUNA_NOME_DETALHES, e.getDetalhes());
            values.put(EventoEntry.COLUNA_NOME_IMAGEM, e.getImagem());
            db.insert(EventoEntry.TABELA_NOME, null, values);
        }
    }
}