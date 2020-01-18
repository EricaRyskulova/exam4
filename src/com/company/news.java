package com.company;

import java.sql.*;

public class news {
    private int id;
    private String headline_news;
    private String text_news;
    private String publishing_time;

    public news() {
    }

    public news(int id, String headline_news, String text_news, String publishing_time) {
        this.id = id;
        this.headline_news = headline_news;
        this.text_news = text_news;
        this.publishing_time = publishing_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadline_news() {
        return headline_news;
    }

    public void setHeadline_news(String headline_news) {
        this.headline_news = headline_news;
    }

    public String getText_news() {
        return text_news;
    }

    public void setText_news(String text_news) {
        this.text_news = text_news;
    }

    public String getPublishing_time() {
        return publishing_time;
    }

    public void setPublishing_time(String publishing_time) {
        this.publishing_time = publishing_time;
    }



    private final static String url = "jdbc:postgresql://localhost:5432/";
    private final static String user = "postgres";
    private final static String password = "tilly";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

                public void printNewNews(){
                    String SQL = "select *from news(headline_news, text_news, publishing_time)";
                    try(Connection conn = connect();
                        Statement statement = conn.createStatement();
                        ResultSet rs = statement.executeQuery(SQL)){
                        while (rs.next()) {
                            System.out.println(rs.getString("headline_news"));
                            System.out.println(rs.getString("text_news"));
                            System.out.println(rs.getString("publishing_news"));
                        }
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
//                    public void printNewNews(String headline_news, String text_news, String publishing_time){
//                        String SQL = "select *from news(headline_news, text_news, publishing_time) values (?,?)";
//                        try(Connection conn = connect();
//                         PreparedStatement statement = conn.prepareStatement(SQL)){
//                            statement.setString(1,headline_news);
//                            statement.setString(2,text_news);
//                            statement.setString(3,publishing_time);
//                            statement.executeUpdate();
//
//                        }catch (SQLException e){
//                            e.printStackTrace();
//                        }


            }

    }









