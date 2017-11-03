package com.example.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.inventory.adapter.SectionAdapter;
import com.example.inventory.pojo.Section;

public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SectionAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerSection);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        if (savedInstanceState != null) {
            sectionAdapter = new SectionAdapter(savedInstanceState.<Section>getParcelableArrayList("seccion"));
        }
        else {
            sectionAdapter = new SectionAdapter();
        }

        recyclerView.setAdapter(sectionAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflador = getMenuInflater();
        menuInflador.inflate(R.menu.menu_activity_sector, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almaceno las secciones modificadas en la vista y no han sido guardados para visualizarlos
     * en el estado correcto en onCreate()
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList("seccion", sectionAdapter.getSectionsModified());

        // Identificar switch
        // Comprobar cambio
        // Comprobar todos los sections
    }
}
