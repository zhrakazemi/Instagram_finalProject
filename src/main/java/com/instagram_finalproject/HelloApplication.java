package com.instagram_finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public static Account loggedInAccount;

    public static ArrayList<Post> allPosts = new ArrayList<>() ;

    @Override
    public void start(Stage stage) throws IOException, SQLException {


         //////
                MySQLConnection sql = new MySQLConnection() ;
                String s = "SELECT * FROM allaccounts" ;
                ResultSet res = sql.ExecuteQuery(s);

                if (res==null)
                    System.out.println("-Error !");
                else
                    while (true)
                    {
                        try {
                            if (!res.next()) break;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        Account.AllAccount.add((new Account(res.getString("username"),res.getString("password"),res.getString("name"),res.getString("lastName"),res.getString("email"),res.getString("birthDate"),res.getString("bio")))) ;
                    }
                    //اضافه شدن به لیست پست های هر اکانت
                    for (int i=0 ; i<Account.AllAccount.size() ; i++){
                        MySQLConnection sql3 = new MySQLConnection() ;
                        String s3 = String.format("SELECT * FROM allposts WHERE username='%s'",Account.AllAccount.get(i).getUsername()) ;
                        ResultSet res3 = sql3.ExecuteQuery(s3);
                        if (res3==null)
                            System.out.println("-Error !");
                        else
                            while (true)
                            {
                                try {
                                    if (!res3.next()) break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Account.AllAccount.get(i).getPosts().add(new Post(res3.getString("username"),res3.getString("text"),res3.getInt("like"),res3.getInt("dislike"))) ;
                            }

                    }
                    //
                    // هر اکانتی که پابلیک هست پستش بیاد تو این اری لیست

                 MySQLConnection sql2 = new MySQLConnection() ;
                 String s2 = String.format("SELECT * FROM allposts WHERE private=%s",0) ;
                 ResultSet res2 = sql2.ExecuteQuery(s2);

                if (res2==null)
                   System.out.println("-Error !");
                else
                    while (true)
                  {
                     try {
                       if (!res2.next()) break;
                   } catch (SQLException e) {
                    e.printStackTrace();
                   }

                   allPosts.add(new Post(res2.getString("username"),res2.getString("text"),res2.getInt("like"),res2.getInt("dislike"))) ;
               }
        ///////



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("Instagram");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

                launch();
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class MySQLConnection
{
    String URL = "jdbc:mysql://localhost/instagram" ;
    String UserName = "root" ;
    String Password = "" ;

    Boolean ExecuteSQL (String SqlCmd) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(URL, UserName, Password);
            Statement s = Con.prepareStatement(SqlCmd);
            s.execute(SqlCmd);

            Con.close();
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    ResultSet ExecuteQuery (String SqlCmd) {  //به صورت جدولی
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(URL, UserName, Password);
            Statement s = Con.prepareStatement(SqlCmd);
            ResultSet rs = s.executeQuery(SqlCmd);


            //Con.close();
            return rs;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

