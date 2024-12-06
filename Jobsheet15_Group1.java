import java.util.Scanner;
public class Jobsheet15_Group1 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int MaxEntries = 26;
    String[] StudentName = new String[MaxEntries] ;
    String[] CourseCode = new String[MaxEntries] ;
    String[] CourseName = new String[MaxEntries] ;
    String[] StudentNim = new String[MaxEntries] ;
    int[] CreditHours = new int[MaxEntries] ;
    int EntryStorage = 0;
    
    while(true){
        System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
        System.out.println("1. Input Data KRS");
        System.out.println("2. Tampilkan Daftar KRS Mahasiswa ");
        System.out.println("3. Analisis Data KRS");
        System.out.println("4. Keluar");
        System.out.print("Entry Your Choice :");
        int choice = sc.nextInt();
        
        System.out.println("--- Tambah Data KRS ---");
        System.out.println("Nama Mahasiswa:");
        System.out.println("NIM: ");
        System.out.println("Kode Mata Kuliah :");
        System.out.println("Nama Mata Kuliah :");
        System.out.println("Jumlah Sks (1-3) :");
        
        System.out.println("Data Mata Kuliah Berhasil Ditambahkan");
        
        System.out.println("Tambah mata kuliah lain? (Y/T) :");
        System.out.println("Total SKS yang Diambil :");
    }
}}
