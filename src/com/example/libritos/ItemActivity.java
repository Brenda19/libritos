 package com.example.libritos;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends ActionBarActivity {
	ImageView idImag; 
	TextView textoSobre; 
	TextView textoAbajo;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item);
		textoSobre = (TextView) findViewById(R.id.textView_superior);
		textoAbajo = (TextView) findViewById(R.id.textView_inferior);
		idImag = (ImageView) findViewById(R.id.imageView_imagen);
		
		Bundle bundle = getIntent().getExtras();
		textoSobre.setText(bundle.getString("Sobre"));
		textoAbajo.setText(bundle.getString("Abajo"));
		idImag.setImageResource(getIntent().getExtras().getInt("imag"));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.item, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

