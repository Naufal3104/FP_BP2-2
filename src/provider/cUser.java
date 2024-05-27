package provider;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class cUser {

    private int id_user;
    private String nama_user;
    private String username;
    private String password;
    private int user_role;

    cUser() {
        System.out.println("User Object");
    }

    cUser(int id_user, String nama_user, String username, String password, int user_role) {
        this.id_user = id_user;
        this.nama_user = nama_user;
        this.username = username;
        this.password = password;
        this.user_role = user_role;
    }

    public void Login(cDoubleLinkedList<cUser> userList) {
        Scanner input = new Scanner(System.in);
        System.out.println("==== Login Form ====");
        System.out.print("Masukkan username dan password: ");
        String inputCredentials = input.nextLine();

        // Split the input line into username and password
        String inputUsername = inputCredentials.split(" ")[0];
        String inputPassword = inputCredentials.split(" ")[1];

        // Validasi login
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login berhasil!");
            // Set user session
            saveUserSession(userList);
        } else {
            System.out.println("Login gagal. Coba lagi.");
        }
    }

//    public cNode getNext() {
//        return next;
//    }
//
//    public void setNext(cNode next) {
//        this.next = next;
//    }
//
//    public cNode getPrev() {
//        return prev;
//    }
//
//    public void setPrev(cNode prev) {
//        this.prev = prev;
//    }
    public int getId_User() {
        return id_user;
    }

    public void setId_User(int id_user) {
        this.id_user = id_user;
    }

    public String getNama_User() {
        return nama_user;
    }

    public void setNama_User(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_Role() {
        return user_role;
    }

    public void setUser_Role(int user_role) {
        this.user_role = user_role;
    }

    public void saveUserSession(cDoubleLinkedList<cUser> userList) {
        cNode<cUser> currentNode = userList.getHead();
        while (currentNode != null) {
            if (currentNode.getData().getUsername().equals(username) && currentNode.getData().getPassword().equals(password)) {
                // Set user session
                System.out.println("User session saved.");
                return;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("User not found.");
    }
}
