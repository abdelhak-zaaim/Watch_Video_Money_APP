package watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_31;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class earnmoney_29 {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("data")
    private ArrayList<earnmoney_28> data;
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private String status;
    @SerializedName("status_code")
    private int statusCode;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_records")
    private int totalRecords;

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setData(ArrayList<earnmoney_28> arrayList) {
        this.data = arrayList;
    }

    public List<earnmoney_28> getData() {
        return this.data;
    }

    public void setTotalRecords(int i) {
        this.totalRecords = i;
    }

    public int getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalPages(int i) {
        this.totalPages = i;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return "CategoryModel{status_code = '" + this.statusCode + "',data = '" + this.data + "',total_records = '" + this.totalRecords + "',total_pages = '" + this.totalPages + "',message = '" + this.message + "',current_page = '" + this.currentPage + "',status = '" + this.status + "'}";
    }
}
