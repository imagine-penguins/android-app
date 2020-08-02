package com.startuppro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Registeration extends AppCompatActivity {

    private EditText name, designation, email, number, companyname, companywebsite, companyaddress, description;
    private Spinner companytype, establishment, turnover;
    private Button submit;
    ActionBar actionBar;
    //    private static final String TAG = "Registeration";
//    private  static final String  KEY_NAME="namea";
//    private static final String KEY_DESIGNATION="designationa";
//    private  static final String  KEY_EMAIL="emaila";
//    private  static final String  KEY_NUMBER="numbera";
//    private  static final String  KEY_COMPANYNAME="companynamea";
//    private  static final String  KEY_COMPANYWEBSITE="companywebsitea";
//    private  static final String  KEY_COMPANYADDRESS="companyaddressa";
//    private  static final String  KEY_DESCRIPTION="descriptiona";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Startup");
    private DocumentReference noteRef = db.document("Startup/My Users");
//    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        actionBar=getSupportActionBar();
        actionBar.hide();
        name = findViewById(R.id.EditTextName);
        designation = findViewById(R.id.EditTextDesignation);
        email = findViewById(R.id.EditTextEmail);
        number = findViewById(R.id.EditTextmobileno);
        companyname = findViewById(R.id.EditTextcompanyname);
        companywebsite = findViewById(R.id.EditTextcompanywebsite);
        companyaddress = findViewById(R.id.EditTextcompanyaddress);
        description = findViewById(R.id.EditTextdescription);
        establishment = findViewById(R.id.Spinneryear);
        companytype = findViewById(R.id.SpinnercompanyType);
        turnover = findViewById(R.id.Spinnerannualturnover);

//        progressBar = findViewById(R.id.progressbar);
//        progressBar.setVisibility(View.GONE);
//
        submit = findViewById(R.id.submitt);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote(v);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    return;
                }

                String data = "";

                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Note note = documentSnapshot.toObject(Note.class);
                    note.setDocumentId(documentSnapshot.getId());

                    String documentId = note.getDocumentId();
                    String name = note.getName();
                    String designation = note.getDesignation();
                    String email = note.getEmail();
                    String number = note.getNumber();
                    String companyname = note.getCompanyname();
                    String companywebsite = note.getCompanywebsite();
                    String companyaddress = note.getCompanyaddress();
                    String establishment = note.getEstablishment();
                    String companytype = note.getCompanytype();
                    String turnover = note.getTurnover();
                    String description = note.getDescription();

                    data += "ID: " + documentId
                            + "\nName: " + name + "\nDesignation: " + designation + "\nEmail: " + email + "\nNumber: " + number
                            + "\nCompanyname: " + companyname + "\nCompanywebsite: " + companywebsite +
                            "\nCompanyaddress: " + companyaddress + "\nEstablishment: " + establishment +
                            "\nCompanytype: " + companytype + "\nTurnover: " + turnover + "\nDescription: " + description + "\n\n";

                }

            }
        });
    }

    public void addNote(View v) {
        if (name.getText().length() > 0 && designation.getText().length() > 0 && email.getText().length() > 0 && number.getText().length() > 0 && companyname.getText().length() > 0 && companywebsite.getText().length() > 0 && companyaddress.getText().length() > 0) {
            String names = name.getText().toString();
            String designations = designation.getText().toString();
            String emails = email.getText().toString();
            String numbers = number.getText().toString();
            String comanynames = companyname.getText().toString();
            String companywebsites = companywebsite.getText().toString();
            String companyaddresss = companyaddress.getText().toString();
            String establishments = establishment.getSelectedItem().toString();
            String companytypes = companytype.getSelectedItem().toString();
            String turnovers = turnover.getSelectedItem().toString();
            String descriptions = description.getText().toString();


            Note note = new Note(names, designations, emails, numbers, comanynames, companywebsites, companyaddresss, establishments,
                    companytypes, turnovers, descriptions);

            notebookRef.add(note);
            Intent insa = new Intent(Registeration.this, PopActivity.class);
            startActivity(insa);
        }
        else
        {
            Toast.makeText(Registeration.this, "Firstly Fill The Complete Form", Toast.LENGTH_SHORT).show();
        }
    }

}



