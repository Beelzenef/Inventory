package com.example.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Dashboard para aplicacion de Inventory
 * @author Elena G (Beelzenef)
 */

public class DashboardActivity extends AppCompatActivity {

    private GridLayout grdDashboard;
    private ClickListenerDashboard listenerDashboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);

        grdDashboard = (GridLayout) findViewById(R.id.grdLDashboard);

        // Definir un int array, para id de imágenes Inventory, Producto, Dependencias, Secciones, Preferencias
        int[] imgs = { R.drawable.inventory, R.drawable.monitor, R.drawable.mouse, R.drawable.closet };


        /* R.drawable.chair, R.drawable.closet, R.drawable.cpu, R.drawable.inventory,
                R.drawable.keyboard, R.drawable.monitor, R.drawable.mouse, R.drawable.printer,
                R.drawable.table, R.drawable.whiteboard, R.drawable.proyector*/

        // En Java, no usamos arrays de Objetos como ImageView[]
        //ImageView[] listaImgView = new ImageView[imgs.length];
        // Utilizamos Vectors o Colecciones:
        // Vector<> queda descartado porque no trabajamos con hilos, innecesaria sincronizacion
        //Vector<ImageView> vectorImgView = new Vector<ImageView>();

        float widthDashboard = getResources().getDimension(R.dimen.imgDashboardWidth);
        float heightDashboard = getResources().getDimension(R.dimen.imgDashboardHeigth);

        //En Java, no usamos arrays de Objetos como ImageView[]
        //ImageView[] listaImgView = new ImageView[imgs.length];
        // Utilizamos Vectors o Colecciones:
        // Vector<> queda descartado porque no trabajamos con hilos, innecesaria sincronizacion
        // Vector<ImageView> vectorImgView = new Vector<ImageView>();

        ImageView imgV;
        listenerDashboard = new ClickListenerDashboard();

        for (int i = 0; i < imgs.length; i++) {

            // Nuevo ImageView con imagen incorporada
            imgV = new ImageView(this);
            imgV.setImageResource(imgs[i]);

            imgV.setId(imgs[i]);

            // Parametros de dimensiones para cada ImageView, FILL, pesos para columnas y filas:
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) widthDashboard;
            params.height = (int) heightDashboard;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);

            // Aplicando params
            imgV.setLayoutParams(params);

            //
            imgV.setOnClickListener(listenerDashboard);

            // Añadiendo a GridLayout
            grdDashboard.addView(imgV);
        }

    }


    class ClickListenerDashboard implements View.OnClickListener {

        @Override
        public void onClick(View v)
        {
            Intent unIntent = null;

            switch (v.getId())
            {
                case R.drawable.inventory:
                    unIntent = new Intent(DashboardActivity.this, InventoryActivity.class);
                    break;
                case R.drawable.monitor:
                    unIntent = new Intent(DashboardActivity.this, ProductActivity.class);
                    break;
                case R.drawable.mouse:
                    unIntent = new Intent(DashboardActivity.this, DependencyActivity.class);
                    break;
                case R.drawable.closet:
                    unIntent = new Intent(DashboardActivity.this, SectorActivity.class);
                    break;
            }
            startActivity(unIntent);
        }

    }

}