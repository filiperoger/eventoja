package ucsal.br.eventoja;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ucsal.br.eventoja.EventoContract.EventoEntry;

public class DetalheActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = DetalheActivity.this.getIntent();
        if (intent.hasExtra("posicao")) {
            int posicao = intent.getIntExtra("posicao", 0);

            EventoDbHelper eventoDbHelper = new EventoDbHelper(this);
            SQLiteDatabase db = eventoDbHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM evento", null);
            cursor.moveToPosition(posicao);

            String eventoNome = cursor.getString(cursor.getColumnIndexOrThrow(EventoEntry.COLUNA_NOME_NOME));
            String eventoData = cursor.getString(cursor.getColumnIndexOrThrow(EventoEntry.COLUNA_NOME_DATA));
            String eventoLocal = cursor.getString(cursor.getColumnIndexOrThrow(EventoEntry.COLUNA_NOME_LOCAL));
            String eventoEndereco = cursor.getString(cursor.getColumnIndexOrThrow(EventoEntry.COLUNA_NOME_ENDERECO));
            String eventoPreco = cursor.getString(cursor.getColumnIndexOrThrow(EventoEntry.COLUNA_NOME_PRECO));
            String eventoDetalhes = cursor.getString(cursor.getColumnIndexOrThrow(EventoEntry.COLUNA_NOME_DETALHES));
            String eventoImagem = cursor.getString(cursor.getColumnIndexOrThrow(EventoEntry.COLUNA_NOME_IMAGEM));

            ((TextView) DetalheActivity.this.findViewById(R.id.nome)).setText(eventoNome);
            ((TextView) DetalheActivity.this.findViewById(R.id.data)).setText(eventoData);
            ((TextView) DetalheActivity.this.findViewById(R.id.local)).setText(eventoLocal);
            ((TextView) DetalheActivity.this.findViewById(R.id.endereco)).setText(eventoEndereco);
            ((TextView) DetalheActivity.this.findViewById(R.id.preco)).setText(eventoPreco);
            ((TextView) DetalheActivity.this.findViewById(R.id.detalhes)).setText(eventoDetalhes);
            Picasso.with(DetalheActivity.this).load(eventoImagem).into((ImageView) DetalheActivity.this.findViewById(R.id.imagem));

            fragmentManager = getSupportFragmentManager();
        }
    }
}