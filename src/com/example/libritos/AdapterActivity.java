package com.example.libritos;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class AdapterActivity extends BaseAdapter {


    private ArrayList<?> entrar; 
    private int R_layout_IdView; 
    private Context cont;
      
    public AdapterActivity(Context cont, int R_layout_IdView, ArrayList<?> entrar) {
        super();
        this.cont = cont;
        this.entrar = entrar; 
        this.R_layout_IdView = R_layout_IdView; 
    }
      
    @Override
    public View getView(int posicion, View view, ViewGroup pariente) {
        if (view == null) {
			LayoutInflater vi = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
            view = vi.inflate(R_layout_IdView, null); 
        }
        onEntrada (entrar.get(posicion), view);
        return view; 
    }

	@Override
	public int getCount() {
		return entrar.size();
	}

	@Override
	public Object getItem(int posicion) {
		return entrar.get(posicion);
	}

	@Override
	public long getItemId(int posicion) {
		return posicion;
	}
	
	public abstract void onEntrada (Object activity_item, View view);
    
}