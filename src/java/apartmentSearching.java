/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.sql.*;

/**
 *
 * @author harshshah2303
 */
@Named(value = "apartmentSearching")
@RequestScoped
public class apartmentSearching {

    private String bedRoom;
    private String bathRoom;
    private ArrayList<String> bedRoomOptions = new ArrayList<>();
    private ArrayList<String> bathRoomOptions = new ArrayList<>();
    
    private ArrayList<Apartment> results = new ArrayList<>();

    public ArrayList<Apartment> getResults() {
        return results;
    }

    public void setResults(ArrayList<Apartment> results) {
        this.results = results;
    }
    
    
    

    public String getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(String bedRoom) {
        this.bedRoom = bedRoom;
    }

    public String getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(String bathRoom) {
        this.bathRoom = bathRoom;
    }

    public ArrayList<String> getBedRoomOptions() {
        return bedRoomOptions;
    }

    public void setBedRoomOptions(ArrayList<String> bedRoomOptions) {
        this.bedRoomOptions = bedRoomOptions;
    }

    public ArrayList<String> getBathRoomOptions() {
        return bathRoomOptions;
    }

    public void setBathRoomOptions(ArrayList<String> bathRoomOptions) {
        this.bathRoomOptions = bathRoomOptions;
    }
    
    public apartmentSearching()
    {
        bedRoomOptions.add("1");
        bedRoomOptions.add("2");
        bedRoomOptions.add("3");
        
        bathRoomOptions.add("Any");
        bathRoomOptions.add("1");
        bathRoomOptions.add("2");
    }
    
    public String search()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            return "internalError";
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        final String DB_URL = "jdbc:mysql://mis-sql.uhcl.edu/shahh6626";
        try
        {
            conn = DriverManager.getConnection(DB_URL,"shahh6626","1453730");
            stat = conn.createStatement();
            if(bathRoom.equals("Any"))
            {
                rs = stat.executeQuery("select * from Apartment where NumBed = '" + bedRoom + "' ");
                while(rs.next())
                {
                    results.add(new Apartment(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
                }
                if(results.isEmpty())
                {
                    return "noFound";
                }
                else
                {
                    return "result";
                }
            }
            else
            {
                rs = stat.executeQuery("select * from Apartment where NumBed = '" + bedRoom + "' and NumBath = '" + bathRoom + "' ");
                while(rs.next())
                {
                    results.add(new Apartment(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
                }
                if(results.isEmpty())
                {
                    return "noFound";
                }
                else
                {
                    return "result";
                }
                
            }
            
        }
        catch(SQLException e)
        {
            return "internalError";
        }
        finally
        {
            try
            {
                conn.close();
                stat.close();
                rs.close();
            }
            catch(Exception e)
            {
                return "internalError";
            }
        }
       
    }
}
