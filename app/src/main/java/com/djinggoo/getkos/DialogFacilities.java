package com.djinggoo.getkos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFacilities extends AppCompatDialogFragment {

    private CheckBox checkBoxBathroom;
    private CheckBox checkBoxWifi;
    private CheckBox checkBoxFreeAccess;

    private DialogFacilitiesListener listener;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_facilities, null);

        builder.setView(view)
                .setNegativeButton(Html.fromHtml("<font color='#000000'>Cancel</font>"), (dialogInterface, i) -> {

                })
                .setPositiveButton(Html.fromHtml("<font color='#000000'>Select</font>"), (dialogInterface, i) -> {
                    Float bathroomVal = checkBoxBathroom.isChecked() ? 2f : 0f;
                    Float accessVal = checkBoxFreeAccess.isChecked() ? 2f : 0f;
                    Float wifiVal = checkBoxWifi.isChecked() ? 2f : 0f;
                    listener.applySelection(bathroomVal, wifiVal, accessVal);
                });

        checkBoxBathroom = view.findViewById(R.id.checkbox_bathroom);
        checkBoxFreeAccess = view.findViewById(R.id.checkbox_free_access);
        checkBoxWifi = view.findViewById(R.id.checkbox_wifi);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (DialogFacilitiesListener) context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "something wrong when casting to DialogFacilitiesListener");
        }

    }

    public interface DialogFacilitiesListener{
        void applySelection(Float bathroomVal, Float wifiVal, Float accessVal);
    }

}
