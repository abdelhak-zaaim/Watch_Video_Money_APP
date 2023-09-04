package watchvideo.dailytrend.Earnmoney_6.EarnMoney_106;

import android.content.Context;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_3;
import watchvideo.dailytrend.R;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Locale;

public class EarnMoney_117 extends RecyclerView.Adapter<EarnMoney_117.MyViewHolder> {
    private Context _context;
    private ArrayList<moneyapp_3> arrVideos = new ArrayList<>();
    private int identify = RealMoney_105.IS_FULLSCREEN_VIDEOS;
    private ItemClick itemClick;
    private String searchText = "";

    public interface ItemClick {
        void onItemClick(moneyapp_3 moneyapp3);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;

        public MyViewHolder(View view, int i) {
            super(view);
            this.txtName = (TextView) view.findViewById(R.id.txtName);
        }
    }

    public EarnMoney_117(Context context, ArrayList<moneyapp_3> arrayList, ItemClick itemClick2) {
        this.arrVideos = arrayList;
        this._context = context;
        this.itemClick = itemClick2;
    }

    public void changeIdentify(int i) {
        this.identify = i;
    }

    public void changeSearch(String str) {
        this.searchText = str;
    }

    @Override 
    public int getItemCount() {
        return this.arrVideos.size();
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        final moneyapp_3 moneyapp3 = this.arrVideos.get(i);
        if (moneyapp3.getTitle().toLowerCase().contains(this.searchText.toLowerCase())) {
            try {
                SpannableString spannableString = new SpannableString(moneyapp3.getTitle());
                String lowerCase = Normalizer.normalize(moneyapp3.getTitle(), Normalizer.Form.NFD).toLowerCase(Locale.ENGLISH);
                int indexOf = lowerCase.indexOf(this.searchText.toLowerCase(Locale.ENGLISH));
                while (indexOf >= 0) {
                    int min = Math.min(indexOf, moneyapp3.getTitle().length());
                    int min2 = Math.min(indexOf + this.searchText.length(), moneyapp3.getTitle().length());
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this._context, R.color.colorAccent)), min, min2, 33);
                    indexOf = lowerCase.indexOf(this.searchText, min2);
                }
                myViewHolder.txtName.setText(spannableString, TextView.BufferType.SPANNABLE);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Erroe : ", i + "--" + e.getMessage());
                myViewHolder.txtName.setText(moneyapp3.getTitle());
            }
        } else {
            myViewHolder.txtName.setText(moneyapp3.getTitle());
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override 
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {

                    @Override // java.lang.Runnable
                    public void run() {
                        if (EarnMoney_117.this.itemClick != null) {
                            EarnMoney_117.this.itemClick.onItemClick(moneyapp3);
                        }
                    }
                }, 50);
            }
        });
    }

    @Override 
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.winandspingames, viewGroup, false), i);
    }
}
