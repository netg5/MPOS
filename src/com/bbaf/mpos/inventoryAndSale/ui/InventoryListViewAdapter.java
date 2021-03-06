package com.bbaf.mpos.inventoryAndSale.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bbaf.mpos.FacadeController.Register;
import com.bbaf.mpos.ProductDescription.ProductDescription;

/**
 * A class adapt ArrayList<ProductDescription> to be ListView shown in Inventory view.
 *  @author Poramet Homprakob 5510546077
 */
public class InventoryListViewAdapter extends BaseAdapter {
	
	private Activity activity;
	private ArrayList<ProductDescription> productList;

	/**
	 * Constructor, using calling activity.
	 * @param activity calling activity
	 */
	public InventoryListViewAdapter(Activity activity) {
		this.activity = activity;
		this.productList = Register.getInstance().getInventory().getAllProduct();
	}

	@Override
	public int getCount() {
		return productList.size();
	}

	@Override
	public Object getItem(int position) {
		return productList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return new InventoryListRow(activity, productList.get(position));
	}

	/**
	 * Notify ListView to show new row lists
	 */
	public void notifyDataSetChanged() {
		productList = Register.getInstance().getInventory().getAllProduct();
		super.notifyDataSetChanged();
	}
	
	/**
	 * Notify ListView to show new row lists by using list of ProductDescription lists
	 * @param productList list of ProductDescription
	 */
	public void notifyDataSetChanged(ArrayList<ProductDescription> productList) {
		this.productList = productList;
		super.notifyDataSetChanged();
	}
}
