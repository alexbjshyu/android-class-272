package com.example.familyfirst.simpleui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by familyfirst on 8/11/16.
 */
public class DrinkAdapter extends BaseAdapter{

    List<Drink> drinks;
    LayoutInflater layoutInflater;


    public DrinkAdapter(Context context, List<Drink> drinkList){
        this.drinks = drinkList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public Object getItem(int position) {
        return drinks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.listview_drink_item,null);
            TextView drinkNameTextView = (TextView) convertView.findViewById(R.id.drinkNameTextView);
            TextView mPriceTextView = (TextView) convertView.findViewById(R.id.mPriceTextView);
            TextView lPriceTextView = (TextView) convertView.findViewById(R.id.lPriceTextView);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

            holder = new Holder();

            holder.drinkNameTextView = drinkNameTextView;
            holder.mPriceTextView = mPriceTextView;
            holder.lPriceTextView = lPriceTextView;
            holder.imageView = imageView;

            convertView.setTag(holder);
        }
        else
        {
            holder = (Holder)convertView.getTag();
        }

        Drink drink = drinks.get(position);
        holder.drinkNameTextView.setText(drink.name);

        holder.mPriceTextView.setText(String.valueOf(drink.mPrice));
        holder.lPriceTextView.setText(String.valueOf(drink.lPrice));
        holder.imageView.setImageResource(drink.ImageId);
        return convertView;
    }

    class Holder
    {
        TextView drinkNameTextView;
        TextView mPriceTextView;
        TextView lPriceTextView;
        ImageView imageView;
    }

}
