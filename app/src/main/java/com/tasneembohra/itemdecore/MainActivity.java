package com.tasneembohra.itemdecore;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new ItemDecorator(-160));

        recyclerView.setAdapter(new Adapter());


    }

    class Adapter extends  RecyclerView.Adapter<Adapter.ItemViewHolder> {
        @Override
        public Adapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, parent, false);
            return new ItemViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(Adapter.ItemViewHolder holder, int position) {
            holder.view.setText((5 - position) +"");
            holder.itemView.setElevation(30.0f * position);
            Random rand = new Random();
            holder.itemView.setBackgroundColor(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        }

        @Override
        public int getItemCount() {
            return 5;
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {
            TextView view;
            public ItemViewHolder(View itemView) {
                super(itemView);
                view = (TextView)itemView.findViewById(R.id.text);
            }
        }
    }

}
