package info.nukoneko.cuc.kidspos4j.api;

import info.nukoneko.cuc.kidspos4j.model.ModelSale;
import okhttp3.ResponseBody;
import retrofit2.http.*;
import rx.Observable;

import java.util.List;

public interface Sale {
    /***
     * 売上の一覧を取得する
     * @return
     */
    @GET("sale/list")
    Observable<List<ModelSale>> getList();

    /***
     * 一つだけの売上の情報を取得する。無い時はnull
     * @param barcode
     * @return
     */
    @GET("sale/{barcode}")
    Observable<ModelSale> getSale(
            @Path("barcode") String barcode);

    /***
     * 重要!! 売上が送信されてきたので受け取る
     * サーバーではレシート印刷もするよ (予定)
     * @param points 商品点数
     * @param price 合計金額
     * @param items 購入した商品ID  1,2,3,
     * @param storeId 購入した商店のID
     * @param staffId レジを担当したスタッフID
     * @return 新しい売上情報
     */
    @FormUrlEncoded
    @POST("sale/create")
    Observable<ModelSale> createSale(
            @Field("received") Integer receivedMoney,
            @Field("points") Integer points,
            @Field("price") Integer price,
            @Field("items") String items,
            @Field("storeId") Integer storeId,
            @Field("staffBarcode") String staffBarcode);

    /***
     * 売上情報を更新する
     * @param barcode targetBarcode
     * @param points 商品点数
     * @param price 合計金額
     * @param items 購入した商品ID  1,2,3,
     * @param storeId 購入した商店のID
     * @param staffId レジを担当したスタッフID
     * @return 更新した売上情報
     */
    @FormUrlEncoded
    @POST("sale/{barcode}/update")
    Observable<ModelSale> updateSale(
            @Path("barcode") String barcode,
            @Field("points") int points,
            @Field("price") int price,
            @Field("items") String items,
            @Field("storeId") int storeId,
            @Field("staffId") int staffId);


    @Headers("Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    @GET("sale/download/latest")
    Observable<ResponseBody> downloadLatestSale(@Query("store_id") int storeId);
}
