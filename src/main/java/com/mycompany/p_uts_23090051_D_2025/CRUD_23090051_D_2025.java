package com.mycompany.p_uts_23090051_D_2025;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

public class CRUD_23090051_D_2025 {

    private static void viewData(FindIterable<Document> docs, String label) {
        System.out.println("\n== " + label + " ==");
        for (Document d : docs) {
            System.out.println(d.toJson());
        }
    }

    public static void main(String[] args) {
        String URL = "mongodb://localhost:27017/";
        MongoClient client = MongoClients.create(URL);
        MongoDatabase db = client.getDatabase("uts_23090051_2025");
        MongoCollection<Document> tabel = db.getCollection("coll_23090051_D_2025");

        // INSERT (Create)
        Document data = new Document("produk", "Kebab Sapi Original")
                .append("jumlahTerjual", 25)
                .append("hargaSatuan", 15000);
        tabel.insertOne(data);

        // VIEW (Read) sebelum update
        FindIterable<Document> result = tabel.find();
        viewData(result, "Data Penjualan Sebelum Update");

        // UPDATE jumlah terjual
        Bson filter = Filters.eq("produk", "Kebab Sapi Original");
        Bson update = Updates.set("jumlahTerjual", 30);
        tabel.updateOne(filter, update);

        // VIEW setelah update
        result = tabel.find();
        viewData(result, "Data Penjualan Setelah Update");

        // DELETE berdasarkan produk
        System.out.println("\n== DELETE DATA ==");
        Bson dataTarget = Filters.eq("produk", "Kebab Ayam Pedas");
        tabel.deleteOne(dataTarget);  // Tidak menghapus jika produk tidak ada

        // SEARCHING berdasarkan harga satuan
        System.out.println("\n== SEARCH DATA ==");
        Bson find = Filters.eq("hargaSatuan", 15000);
        Document found = tabel.find(find).first();
        if (found != null) {
            System.out.println(found.toJson());
        } else {
            System.out.println("Data penjualan tidak ditemukan.");
        }

        client.close();
    }
}
