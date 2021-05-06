package studi.java.dasar.todolist;

import java.util.Scanner;

public class AplikasiTodoList {
    /**
     * Atribut Data
     */
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    /**
     * MAIN FUNCTION
     * @param args
     */
    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList(){
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int nomor = i + 1;
            if (todo != null){
                System.out.println(nomor + ". " + todo);
            }
        }
    }

    /**
     * Menambah todo ke list
     * @param todo sebagai parameter data teks todo list
     */
    public static void addTodoList(String todo){
        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                isFull = false;
                break;
            }
        }
        if (isFull) {
            String[] temporary = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temporary.length; i++) {
                model[i] = temporary[i];
            }
        }
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * Menghapus todo dari list
     * @param number adalah inputan yang dibutuhkan untuk menjalankan method
     * karena untuk menghapus todo list berdasarkan nomor urutannya
     * @return berupa boolean, true jika berhasil remove dan false jika gagal remove
     */
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length){
            return false;
        } else if (model[number - 1] == null){
            return false;
        } else {
            model[number - 1] = null;
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length) - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * Input Data dari User
     * @param info adalah parameter untuk memberitahu info pilihan yang disediakan
     * @return valuenya adalah data yang diinputkan user di terminal
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /**
     * Menampilkan Screen atau View todo list
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")){
                viewRemoveTodoList();
            } else if(input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    /**
     * Menampilkan Screen atau view Menambahkan todo list
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");
        String todo = input("Todo(x jika batal)");

        if (todo.equals("x")){
            // batal
        } else {
            addTodoList(todo);
        }
    }

    /**
     * Menampilkan Screen atau View Menghapus todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        String number = input("Nomor yang dihapus (x jika batal hapus)");

        if (number.equals("x")) {
            // batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    /**
     * METHOD UNTUK TESTING
     */
    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Todolist jada dasar";
        showTodoList();
    }
    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh todo ke." + i);
        }
        showTodoList();
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
    public static void testInput(){
        String name = input("Nama");
        System.out.println("Hi " + name);

        String channel = input("Channel");
        System.out.println(channel);
    }
    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }
    public static void testViewAddTodoList(){
        addTodoList("Bakso");
        addTodoList("Es Teh");
        addTodoList("Soto");
        viewAddTodoList();
        showTodoList();
    }
    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
    public static void cekModelLength(){
        int a = model.length;
        System.out.println("model length: " + a);
    }
}
