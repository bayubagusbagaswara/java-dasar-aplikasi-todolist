package studi.java.dasar.todolist;

public class AplikasiTodoList {
    public static String[] model = new String[10];

    public static void main(String[] args) {
        testShowTodoList();

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
     */
    public static void addTodoList(){

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
