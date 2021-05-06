package studi.java.dasar.todolist;

import java.util.Scanner;

public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
//        testRemoveTodoList();
//        modelLength();
        testInput();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList(){
        
        // Perulangan data array String
        for (int i = 0; i < model.length; i++) {
            // ambil data tiap ke-i, simpan ke todo
            String todo = model[i];
            // nomor todo
            int nomor = i + 1;

            // cek todo yang kosong
            if (todo != null){
                System.out.println(nomor + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        // untuk test bisa masukkan datanya disini
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Todolist jada dasar";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     * @param todo sebagai parameter data teks todo list
     */
    public static void addTodoList(String todo){

        // buat status untuk modelnya sudah penuh atau belum
        boolean isFull = true;
        // Problemnya jika modelnya sudah penuh, artinya harus resize modelnya
        // cek modelnya udah penuh atau belum
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // cek jika penuh, maka resize ukuran array modelnya yakni 2x lipat
        // tapi jangan sampai data yang lama hilang
        if (isFull) {
            // simpan dulu data lama
            String[] temporary = model;

            // buat resize model baru 2x lipat
            model = new String[model.length * 2];

            // masukkan data temp ke model yang baru
            for (int i = 0; i < temporary.length; i++) {
                model[i] = temporary[i];
            }
        }

        // memasukkan data ke dalam modelnya
        // masukkan ke index yang data arraynya kosong
        for (int i = 0; i < model.length; i++) {
            // cek kalo index modelnya isinya null
            if (model[i] == null) {
                model[i] = todo;
                // break, setelah menambahkan langsung keluar
                break;
            }
        }
    }

    public static void testAddTodoList(){
        // test dengan memasukkan data lebih dari 10, karena default modelnya 10
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh todo ke." + i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo dari list
     * @param number adalah inputan yang dibutuhkan untuk menjalankan method
     * karena untuk menghapus todo list berdasarkan nomor urutannya
     * @return
     */
    public static boolean removeTodoList(Integer number){
        // kalo return boolean nya adalah true, maka aksi menghapusnya sukses

        // cek number todolist (disini kita memasukkan numbernya lebih dari 1),
        // karena number bernilai lebih dari index array + 1
        if ((number - 1) >= model.length){
            return false; // gagal menghapus, karena diluar kapasitas arraynya
        } else if (model[number - 1] == null){
            // cek array kalo sudah null atau sudah tidak ada datanya
            return false; // artinya sudah tidak ada datanya, dan tidak bisa dihapus
        } else {
            // jika ada datanya, maka isi dengan null (berhasil dikosongkan)
            model[number - 1] = null;

            for (int i = (number - 1); i < model.length; i++) {
                // cek urutan datanya, jika datanya berada di ujung
                if (i == (model.length) - 1) {
                    model[i] = null; // kosongkan datanya
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        // tambahkan data dulu
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        // remove jika lebih dari kapasitas arraynya
        boolean result = removeTodoList(11);
        System.out.println(result);

        // remove jika arraynya masih null, jadi false, tapi jika arraynya ada datanya maka akan dihapus
        result = removeTodoList(7);
        System.out.println(result);

        // remove yang berhasil
        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    // INPUT DATA
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine(); // baca data dari yg diketik user
        return data;
    }

    public static void testInput(){
        String name = input("Nama");
        System.out.println("Hi " + name);

        String channel = input("Channel");
        System.out.println(channel);

    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList(){

    }

    /**
     * Menampilkan view menambahkan todo list
     */

    public static void viewAddTodoList(){

    }

    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList(){

    }

    // cek model.length
    public static void modelLength(){
        int a = model.length;
        System.out.println("model length: " + a);
    }
}
