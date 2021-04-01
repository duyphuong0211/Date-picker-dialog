package com.example.date_picker_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    EditText edtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDate = (EditText) findViewById(R.id.editTextTextDate);


        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Chongay();
            }
        });
    }
    // func chon ngay
    private void Chongay()
    {
        // để lấy thời gian hiện tại
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        // dạng này sẽ chiếm cái view của mình
        // khac với dialog chỉ pop up
        // tham số của datepickerdailog(context, sự kiện, nam,thang,ngay)
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set((year,month,dayOfMonth)); // đổ ra ngày tháng năm người dùng chọn.(nếu không có thì trả ra hiện tạo theo hàm getTime
                    // khi click oke, thì date sẽ đỗ ra textview
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("đ/MM/yyyy");
                edtDate.setText(simpleDateFormat.format(calendar.getTime())); // calender.gettime trả ra hiện tại.
            }
        },nam,thang,ngay);

        datePickerDialog.show();
    }

}