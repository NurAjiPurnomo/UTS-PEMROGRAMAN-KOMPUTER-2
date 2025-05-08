package com.mycompany.p_uts_23090051_D_2025;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class CRUD_23090051_D_2025 {
    
    
    // Kelas inner untuk merepresentasikan Document
    static class Document {
        String title;
        String content;
        int pages;

        // Konstruktor untuk membuat dokumen
        public Document(String title, String content, int pages) {
            this.title = title;
            this.content = content;
            this.pages = pages;
        }

        // Method untuk menampilkan isi dokumen
        public String toString() {
            return "Title: " + title + ", Content: " + content + ", Pages: " + pages;
        }
    }

    // List untuk menyimpan dokumen
    static ArrayList<Document> documents = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Fungsi CREATE - Menambahkan 3 dokumen
    public static void createDocuments() {
        // Menambahkan dokumen pertama
        documents.add(new Document("Surat", "Ini adalah surat penting", 1));
        // Menambahkan dokumen kedua
        documents.add(new Document("Laporan", "Isi laporan tahunan", 10));
        // Menambahkan dokumen ketiga
        documents.add(new Document("Proposal", "Proposal kegiatan sekolah", 5));
        System.out.println("✔ 3 Dokumen berhasil ditambahkan.");
    }

    // Fungsi READ - Menampilkan seluruh dokumen
    public static void readDocuments() {
        System.out.println("\n📄 Daftar Dokumen:");
        for (int i = 0; i < documents.size(); i++) {
            // Menampilkan dokumen ke-i
            System.out.println((i + 1) + ". " + documents.get(i));
        }
    }

    // Fungsi UPDATE - Mengubah isi dokumen berdasarkan indeks
    public static void updateDocument(int index, String newTitle, String newContent, int newPages) {
        if (index >= 0 && index < documents.size()) {
            // Mengambil dokumen berdasarkan indeks
            Document doc = documents.get(index);
            // Mengubah isi dokumen
            doc.title = newTitle;
            doc.content = newContent;
            doc.pages = newPages;
            System.out.println("✔ Dokumen berhasil diperbarui.");
        } else {
            System.out.println("❌ Indeks tidak ditemukan.");
        }
    }

    // Fungsi DELETE - Menghapus dokumen berdasarkan indeks
    public static void deleteDocument(int index) {
        if (index >= 0 && index < documents.size()) {
            // Menghapus dokumen dari list
            documents.remove(index);
            System.out.println("✔ Dokumen berhasil dihapus.");
        } else {
            System.out.println("❌ Indeks tidak ditemukan.");
        }
    }

    // Fungsi SEARCHING - Mencari dokumen berdasarkan kata kunci
    public static void searchDocuments(String keyword) {
        System.out.println("\n🔍 Hasil pencarian untuk: " + keyword);
        boolean found = false;

        // Iterasi semua dokumen untuk pencarian
        for (Document doc : documents) {
            // Mencocokkan keyword dengan title atau content
            if (doc.title.contains(keyword) || doc.content.contains(keyword)) {
                System.out.println(doc);
                found = true;
            }
        }

        // Jika tidak ditemukan
        if (!found) {
            System.out.println("❌ Tidak ditemukan dokumen dengan kata kunci tersebut.");
        }
    }

    // Fungsi MAIN untuk mencoba semua fitur
    public static void main(String[] args) {
        // Memanggil fungsi CREATE
        createDocuments();

        // Menampilkan dokumen awal
        readDocuments();

        // Memperbarui dokumen ke-2
        updateDocument(1, "Laporan Revisi", "Isi laporan yang telah diperbarui", 12);
        readDocuments(); // Menampilkan hasil update

        // Mencari dokumen dengan keyword "Proposal"
        searchDocuments("Proposal");

        // Menghapus dokumen ke-1
        deleteDocument(0);
        readDocuments(); // Menampilkan hasil setelah delete
    }

}
