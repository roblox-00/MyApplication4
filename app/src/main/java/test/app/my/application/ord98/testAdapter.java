package test.app.my.application.ord98;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class testAdapter extends RecyclerView.Adapter<testAdapter.TestVIewHolder> {


    @NonNull
    @Override
    public TestVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        TestVIewHolder holder = new TestVIewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestVIewHolder holder, int position) {

        switch (position) {
            case 0:
                holder.txtName.setText("Jeff Bezos");
                holder.txt_message.setText("112 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_1);
                break;

            case 1:
                holder.txtName.setText("Bill Gates");
                holder.txt_message.setText("90 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_2);
                break;
            case 2:
                holder.txtName.setText("Warren Buffett");
                holder.txt_message.setText("84 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_3);
                break;
            case 3:
                holder.txtName.setText("Bernard Arnault");
                holder.txt_message.setText("30.5 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_4);

                break;
            case 4:
                holder.txtName.setText("Mark Zuckerberg");
                holder.txt_message.setText("71 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_5);
                break;
            case 5:
                holder.txtName.setText("Amancio Ortega");
                holder.txt_message.setText("70 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_6);
                break;
            case 6:
                holder.txtName.setText("Carlos Slim Helu");
                holder.txt_message.setText("67.1 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_7);
                break;
            case 7:
                holder.txtName.setText("Charles Koch");
                holder.txt_message.setText("60 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_8);
                break;
            case 8:
                holder.txtName.setText("David Koch");
                holder.txt_message.setText("60 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_9);
                break;
            case 9:
                holder.txtName.setText("Larry Ellison");
                holder.txt_message.setText("58.5 million dollar");
                holder.img_avatar.setImageResource(R.drawable.avatar_10);
                break;

        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class TestVIewHolder extends RecyclerView.ViewHolder {


        ImageView img_avatar;
        TextView txtName;
        TextView txt_message;

        public TestVIewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txt_message = itemView.findViewById(R.id.txt_message);
            img_avatar = itemView.findViewById(R.id.img_avatar);
        }
    }
}
