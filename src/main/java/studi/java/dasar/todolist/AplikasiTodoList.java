package studi.java.dasar.todolist;

public class AplikasiTodoList {
    public static String[] model = new String[10];

    public static void main(String[] args) {
//        testShowTodoList();
        testAddTodoList();
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
     */
    public static void remodeTodoList(){

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
}
