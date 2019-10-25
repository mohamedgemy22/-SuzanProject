package com.enggemy22.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;

public class OrderActivity extends AppCompatActivity {
private ImageView mback;
private ImageView mImageView;
private EditText mname;
private EditText mphone;
private EditText mAdress;
private Button mSend;
private Button mTake;
private Uri mImageUri;
private int GALLERY = 1;

private StorageReference mStorageReference;
private DatabaseReference mDAtabaseRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mback=findViewById(R.id.back);
        mImageView=findViewById(R.id.image);
        mname=findViewById(R.id.name);
        mphone=findViewById(R.id.phone);
        mAdress=findViewById(R.id.adress);
        mSend=findViewById(R.id.send);
        mTake=findViewById(R.id.take);
        mStorageReference= FirebaseStorage.getInstance().getReference("uploads/");
        mDAtabaseRef= FirebaseDatabase.getInstance().getReference("uploads/");

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if
                (
                        mname.getText().toString().trim()!=null &&
                        mphone.getText().toString().trim() !=null &&
                        mAdress.getText().toString().trim() !=null)
                {
                    uploadFile();
                }
                else
                {
                 if(mname.getText().toString().equals("")){
                     mname.setError("يجب ادخال الاسم");
                 }
                 if(mphone.getText().toString().equals("")){
                        mphone.setError("يجب ادخال رقم الهاتف");
                    }
                }
                if(mAdress.getText().toString().trim().equals("")){
                    mAdress.setError("يجب ادخال العنوان");
                }

            }
        });

        mTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowDailog();
            }
        });
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(OrderActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String getFileExtention(Uri uri){
        ContentResolver resolver= getContentResolver();
        MimeTypeMap map=MimeTypeMap.getSingleton();
        return map.getExtensionFromMimeType(resolver.getType(uri));
    }

    private void uploadFile() {
        if(mImageUri!=null)
        {
            StorageReference fileRef=mStorageReference.child(System.currentTimeMillis()+"."+getFileExtention(mImageUri));
            fileRef.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uploads uploads = new Uploads(
                            mname.getText().toString().trim(),
                            mphone.getText().toString().trim(),
                            mAdress.getText().toString().trim(),
                            taskSnapshot.getUploadSessionUri().toString().trim()
                    );
                    String uploadId = mDAtabaseRef.push().getKey();
                    mDAtabaseRef.child(uploadId).setValue(uploads);

                    Toast.makeText(getApplicationContext(),"upload successful",Toast.LENGTH_LONG).show();

                    Intent intent= new Intent(OrderActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                   Toast.makeText(getApplicationContext(),e.getMessage()+"نحقق من الاتصال باالانترنت",Toast.LENGTH_LONG).show();
                }
            });
        }else{
            Toast.makeText(getApplicationContext(),"No File Extention",Toast.LENGTH_LONG).show();
        }
    }

    private void ShowDailog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {"اختيار من المعرض " };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: {
                                choosePhotoFromGallary();
                            break;
                        }
                        }
                    }
                });
        pictureDialog.show();
    }
    private void choosePhotoFromGallary() {
        Intent intentGallary = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intentGallary,GALLERY);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY && resultCode== RESULT_OK && data != null && data.getData()!=null ){
            mImageUri= data.getData();
//            Picasso.get().load(mImageUri).into(mImageView);
            Glide.with(getApplicationContext()).load(mImageUri).into(mImageView);

        }
    }
}
