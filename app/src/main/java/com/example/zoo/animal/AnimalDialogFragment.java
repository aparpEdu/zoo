package com.example.zoo.animal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zoo.R;
import com.example.zoo.cell.Cell;


public class AnimalDialogFragment extends DialogFragment  implements TextWatcher {

    private EditText breed;
    private EditText name;
    private EditText type;
    private AnimalListener listener;



    public AnimalDialogFragment() {
    }



    public static AnimalDialogFragment newInstance(Bundle bundle) {
        AnimalDialogFragment fragment = new AnimalDialogFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        breed = view.findViewById(R.id.editBreedAnimal);
        breed.addTextChangedListener(this);
        name = view.findViewById(R.id.editNameAnimal);
        name.addTextChangedListener(this);
        type = view.findViewById(R.id.editTypeAnimal);
        type.addTextChangedListener(this);

        view.findViewById(R.id.save).setOnClickListener(v -> {
            Bundle bundle = getArguments();
            Cell cell = bundle.getParcelable("cell");
            if(cell.getAnimals().size() != 5) {
                if (breed.getError() == null && name.getError() == null && type.getError() == null) {
                    String breedText = breed.getText().toString();
                    String nameText = name.getText().toString();
                    String typeText = type.getText().toString();
                    Animal animal = new Animal(nameText, typeText, breedText);
                    listener.addItem(animal);
                    dismiss();

                }
            } else {
                Toast.makeText(view.getContext(), "> 5", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animal_dialog, container, false);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        Bundle bundle = getArguments();
        if(bundle != null) {
            String cellType = bundle.getString("type");
            if (name.getText().toString().length() < 3) {
                name.setError("should be at least 3 symbols long");
            } else {
                name.setError(null);
            }

            if (breed.getText().toString().length() < 5) {
                breed.setError("should be at least 5 symbols long");
            } else {
                breed.setError(null);
            }

            if(!type.getText().toString().equalsIgnoreCase("carnivore") || type.getText().toString().equalsIgnoreCase("herbivore")){
                type.setError("herbivore/carnivore");
            } else {
                type.setError(null);
            }

            if(!type.getText().toString().equalsIgnoreCase(cellType)) {
                type.setError("Should be: " + cellType);
            }
        }
    }

    public void setListener(AnimalListener listener) {
        this.listener = listener;
    }
}