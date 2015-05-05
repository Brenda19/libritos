package com.example.libritos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;


public class MainActivity extends Activity {
	private ListView lis;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	
	 ArrayList<MiLibro> info = new ArrayList<MiLibro>(); 
	 
    info.add(new MiLibro(R.drawable.anna, "Anna Karenina, de León Tolstoi", "Esta es una de esas obras clásicas de la narrativa que permanecen a través de generaciones debido a lo que refleja,"
    		+ " pues sus acciones logran que el lector se identifique con sus personajes."));
   info.add(new MiLibro(R.drawable.madame, "Madame Bovary, de Gustave Flaubert", "Una novela controversial que dejó en evidencia a la sociedad francesa del siglo XIX; Madame Bovary, de Gustave Flaubert,"
    		+ " fue publicada el 12 de abril de 1857, convirtiéndose, hasta la fecha, en una de las novelas más importantes de la literatura universal.")); 
    info.add(new MiLibro(R.drawable.guerra01,"Guerra y paz, de León Tolstoi" , "Esta es considerada como la obra cumbre del autor junto con su otro trabajo, Anna Karénina. En Guerra y paz, Tolstoi quiso narrar"
    		+ " las vicisitudes de numerosos personajes de todo tipo y condición a lo largo de unos cincuenta años de historia rusa, desde las guerras napoleónicas hasta más allá de mediado el siglo XIX."));
    info.add(new MiLibro(R.drawable.lo_lita, "Lolita, de Vladimir Nabokov", "Este clásico de la literatura erótica, obra del escritor ruso Vladimir Nabokov, continúa siendo uno de los títulos más representativos del género"
    		+ " desde que se publicó por vez primera en 1955. Esta novela trata el escabroso tema de la atracción que puede llegar a sentir un hombre mayor por una mujer joven, específicamente una niña de 12 años"));
    info.add(new MiLibro(R.drawable.mark_twain,"Las aventuras de Huckleberry Finn, de Mark Twain", "El protagonista de este libro es un niño desharrapado, que no va a la escuela, roba y utiliza un lenguaje barriobajero. A través"
    		+ "de sus atónitos ojos de chiquillo espabilado, Mark Twain consigue realizar sus mayores ambiciones literarias, pues a partir del color local creó una historia universal cuyo impacto en el lector es profundo y duradero: todo un clásico de literatura universal."));
    info.add(new MiLibro(R.drawable.hamlet02,"Hamlet, de William Shakespeare", "La tragedia se centra en las tribulaciones y dudas del joven príncipe de Dinamarca después de que recibe la visita del fantasma de su padre para pedirle que "
    		+ "vengue su muerte a manos de su hermano Claudio."));	
    info.add(new MiLibro(R.drawable.gatbsy, "El gran Gatsby, de Scott Fitzgerald","Publicada por primera vez el 10 de abril de 1925, El gran Gatsby es considerada como La Gran Novela Norteamericana. Simboliza el triunfo, la perpetua juventud y el deslumbramiento que desemboca"
    		+ " en la tragedia, la decadencia y la caída; constantes reflejadas con asombrosa precisión en la vida de Fitzgerald."));
    info.add(new MiLibro(R.drawable.tiempo_perdido,"En busca del tiempo perdido, Marcel Proust", "Se suele decir que los escritores noveles utilizan numerosos elementos autobiográficos para escribir sus primeros trabajos. Y también que todos los narradores beben de sus propias biografías"
    		+ " para escribir sus ficciones. "));
    info.add(new MiLibro(R.drawable.anton03, "Cuentos de Anton Chejov, de Anton Chejov", " Pensar en Chéjov remite a su labor como cuentista; considerado el maestro del relato corto, el ruso marcó un antes y un después en el género, esto le otorgaría un lugar dentro de los más importantes escritores"
    		+ " de cuentos en la literatura universal."));
    info.add(new MiLibro(R.drawable.middlemarch, "Middlemarch, de George Eliot", "La novela se desarrolla en la ficticia ciudad de Middlemarch, en la región inglesa de las Midlands durante los años 1830-32. La historia tiene varias líneas argumentales y un amplio número de personajes y además de su claridad"
    		+ " al entrelazar los relatos incluye otros temas subyacentes como la situación de la mujer, la naturaleza del matrimonio, el idealismo y el interés personal, la religión y la hipocresía, las reformas políticas y la educación."));

      
    lis = (ListView) findViewById(R.id.ListView_listado);
     lis.setAdapter(new AdapterActivity(this, R.layout.activity_item, info){
			public void onEntrada(Object listview_item, View view) {
		        if (listview_item != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((MiLibro) listview_item).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((MiLibro) listview_item).get_textoDebajo()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((MiLibro) listview_item).get_idImagen());
		        }
			}
		});
     
     
     lis.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				MiLibro elegido = (MiLibro) pariente.getItemAtPosition(posicion); 
             
             CharSequence texto = "Abriendo: " + elegido.get_textoEncima();
             Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
             toast.show();

             nuevo(pariente,view,posicion,id);
			}
     });

 }
 public void nuevo(AdapterView<?> pariente, View view, int posicion, long id){
 	Intent intent = new Intent(this, ItemActivity.class );
 	MiLibro item = (MiLibro) lis.getAdapter().getItem(posicion);
 	intent.putExtra("Imagen",item.get_idImagen());
 	intent.putExtra("Abajo",item.get_textoDebajo().toString());
 	intent.putExtra("Sobre",item.get_textoEncima().toString()); 
     startActivity(intent);

 }
 }
