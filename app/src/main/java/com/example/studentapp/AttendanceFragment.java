package com.example.studentapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;


public class AttendanceFragment extends Fragment {
ImageView iv_qr;
Button sendRequest;
    public static TextView selectGroup;
    RecyclerView re;
    public static String groupName;
    public static Dialog dialog ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_attendance, container, false);
        iv_qr = v.findViewById(R.id.iv_qr);
        selectGroup =v.findViewById(R.id.txt_selectGroup);
        sendRequest =v.findViewById(R.id.btn_sendRequest);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(groupName == null){
                    Toast.makeText(getActivity(), "Select Group", Toast.LENGTH_SHORT).show();
                }else{
                    showDialogSuccessfully();

                }
            }
        });
        try {
            generateQrCode();
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }

        selectGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContinueAsDialog();
            }
        });
        return v;
    }
   public void generateQrCode() throws WriterException {
        String text ="Base64".toString().trim();
       MultiFormatWriter writer = new MultiFormatWriter();
       try {
           BitMatrix matrix =writer.encode(text, BarcodeFormat.QR_CODE,600,600);
           BarcodeEncoder encoder =new BarcodeEncoder();
           Bitmap bitmap =encoder.createBitmap(matrix);
           iv_qr.setImageBitmap(bitmap);

       }catch (WriterException e)
       {
           e.printStackTrace();
       }


   }

    public void showContinueAsDialog(){
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.group_custom_dialog);
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().getAttributes().windowAnimations =R.style.DialoAnimation;
        ImageButton close=dialog.findViewById(R.id.btn_close);
         re =dialog.findViewById(R.id.rv_selectGroup);
        setupRvSelectGroup();
        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    public  void setupRvSelectGroup(){
        ArrayList<DataQuiz> dataQuizzes =new ArrayList<>();
        dataQuizzes.add(new DataQuiz("Group 1",""));
        dataQuizzes.add(new DataQuiz("Group 2",""));
        dataQuizzes.add(new DataQuiz("Group 3",""));
        dataQuizzes.add(new DataQuiz("Group 4",""));
        RecyclerView.LayoutManager lm =new LinearLayoutManager(getActivity());
        GroupAdapter groupAdapter = new GroupAdapter(dataQuizzes);
        re.setHasFixedSize(true);
        re.setLayoutManager(lm);
        re.setAdapter(groupAdapter);

    }
    public void showDialogSuccessfully(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.request_sucsessfully);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
        Button home =dialog.findViewById(R.id.btn_home);
        ImageButton close =dialog.findViewById(R.id.btn_close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.bottomNavigationView.setSelectedItemId(R.id.action_home);
                dialog.dismiss();
            }

        });
    }


}