package com.bbaf.mpos.inventory.ui;


import com.bbaf.mpos.FacadeController.Register;
import com.bbaf.mpos.FacadeController.Store;
import com.bbaf.mpos.sale.payment.ui.PaymentActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.Toast;

public class CancelSaleOnClickListener implements OnClickListener {

	private ListView listView;
	private InventoryActivity2 activity;

	public CancelSaleOnClickListener(InventoryActivity2 activity) {
		this.listView = listView;
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		if (Register.getInstance().getSale().getAllList().size() == 0) {
			
		}
		else {
			final AlertDialog.Builder adb = new AlertDialog.Builder(
					activity);
			adb.setTitle("Confirm?");
			adb.setMessage("Cancel Sale?");
			adb.setPositiveButton("Cancel", null);
			adb.setNegativeButton("Confirm", new CancelSaleDialogOnClickListener(activity));
			adb.show();
		}
	}
}
