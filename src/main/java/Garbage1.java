/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SIDDHANT
 */
public class Garbage1 {
        private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {                                                

        jRadioButton2.setActionCommand("Normal");
        jRadioButton1.setActionCommand("Bussiness");
        String[] data = new String[] {Fname.getText(), Lname.getText(), Uname.getText(),
                        String.valueOf(Password.getText()), String.valueOf(RePassword.getText()),
                        String.valueOf(AccType.getSelection().getActionCommand()), Contact.getText(),Gender.getText(), City.getText(),
                       State.getText(), Country.getText(), Address.getText()};
        String query, query_s, query_t;
        ResultSet re ;
        Statement st;
        String val="sdfgs";
        String[] sqlstr = new String[] {"`City_ID`" , "`State_ID`", "`Country_ID`", "`CITY`", "`STATE`", "`COUNTRY`", "`CityName`", "`StateName`", "`CountryName`", "`State_ID`", "`Country_ID`", "", "`CityName`= '"+data[8]+"'", "`StateName`= '"+data[9]+"'", "`CountryName`= '"+data[10]+"'" };
        for(int i = 0;i<3;i++){
            
            query_t = String.format("SELECT "+sqlstr[2-i]+" FROM "+sqlstr[5-i]+"  WHERE "+sqlstr[14-i]);
            query = String.format("SELECT City.`City_ID`, State.`State_ID`, Country.`Country_ID` FROM `CITY`, `STATE`, `COUNTRY`  WHERE CITY.State_ID = State.State_ID AND State.Country_ID = Country.Country_ID AND "+sqlstr[14]+" And "+sqlstr[13]+" AND "+sqlstr[12]);
            System.out.println(query);
//            Boolean Bool = true;
            try {
                st = M_Connector.getconnection().createStatement();
                re = st.executeQuery(query);
                Boolean Bool1 = re.next(); 
                Boolean Bool2;
                if(!sqlstr[5-i].equals("`COUNTRY`")){
                        System.out.println(sqlstr[5-i]);
                        System.out.println(sqlstr[3-i]);System.out.println(sqlstr[6-i]);System.out.println(sqlstr[15-i]);
                        if(sqlstr[5-i].equals("`STATE`")){
                            query = String.format("SELECT "+sqlstr[3-i]+" FROM "+sqlstr[6-i]+"  WHERE "+sqlstr[15-i]);
                        }
                        else{
                            query = String.format("SELECT "+sqlstr[6-i]+"."+sqlstr[3-i]+" FROM "+sqlstr[6-i]+", "+sqlstr[7-i]+"  WHERE "+sqlstr[15-i]+" AND "+ sqlstr[16-i]+ "AND" +sqlstr[6-i]+"."+sqlstr[4-i]+" = "+sqlstr[7-i]+"."+sqlstr[4-i] );
                        }

//                    query = String.format("SELECT City.`City_ID`, State.`State_ID`, Country.`Country_ID` FROM `CITY`, `STATE`, `COUNTRY`  WHERE CITY.State_ID = State.State_ID AND State.Country_ID = Country.Country_ID AND "+sqlstr[14]+" And "+sqlstr[13]+" AND "+sqlstr[12]);
            
                    System.out.println(query);
                    re = st.executeQuery(query);
                    re.next();
                    val = re.getString(sqlstr[3-i].replace("`", ""));
                    System.out.println("\n"+val+"\n");
                    if(sqlstr[5-i].equals("`CITY`")){
                        query = String.format("SELECT "+sqlstr[5-i]+"."+sqlstr[3-i]+" FROM "+sqlstr[5-i]+", "+sqlstr[6-i]+", "+sqlstr[7-i]+"  WHERE "+sqlstr[5-i]+"."+sqlstr[3-i]+" = "+sqlstr[6-i]+"."+sqlstr[3-i]+" ANd "+sqlstr[6-i]+"."+sqlstr[4-i]+" = "+sqlstr[7-i]+"."+sqlstr[4-i]+"  AND "+sqlstr[14-i] +" AND "+sqlstr[15-i]+" AND "+ sqlstr[16-i] );
                    }
                    else{
                        query = String.format("SELECT "+sqlstr[5-i]+"."+sqlstr[3-i]+" FROM "+sqlstr[5-i]+", "+sqlstr[6-i]+"  WHERE "+sqlstr[5-i]+"."+sqlstr[3-i]+" = "+sqlstr[6-i]+"."+sqlstr[3-i]+"  AND "+sqlstr[14-i]+ "AND"+sqlstr[15-i]);
                    }
                    System.out.println("-->"+query);
                    re = st.executeQuery(query);
                    Bool2 = re.next();

                    }
                else{
                re = st.executeQuery(query_t);
                Bool2 = re.next(); 
                }
//                if(sqlstr[5-i].equals("`CITY`")){
//                    re = st.executeQuery(query_t);
//                    Bool2 = re.next(); 
//                }
                
                if(!Bool1 & !Bool2){
//                    if(!sqlstr[5-i].equals("`COUNTRY`")){
//                        System.out.println(sqlstr[5-i]);
//                        System.out.println(sqlstr[3-i]);System.out.println(sqlstr[6-i]);System.out.println(sqlstr[15-i]);
//                    query = String.format("SELECT "+sqlstr[3-i]+" FROM "+sqlstr[6-i]+"  WHERE "+sqlstr[15-i]);
//                    System.out.println(query);
//                    re = st.executeQuery(query);
//                    re.next();
//                    val = re.getString(sqlstr[3-i].replace("`", ""));
    //                try{val = re.getString(sqlstr[2-i]);}
    //                catch(Exception e){}
//                    System.out.println("\n"+val+"\n");}
                    
                    
                    
                    if(sqlstr[5-i].equals("`COUNTRY`")){
                        query_s = String.format("INSERT INTO "+sqlstr[5-i]+"("+sqlstr[8-i]+") VALUES ('"+data[10-i]+"')");
                    }
                    else{
                        query_s = String.format("INSERT INTO "+sqlstr[5-i]+"("+sqlstr[8-i]+", "+sqlstr[11-i]+") VALUES ('"+data[10-i]+"',"+val+")");
                    }     
                    st.executeUpdate(query_s);
//                    val = re.getString(sqlstr[2-i]);
                }
                else{
//                    val = re.getString(sqlstr[2-i]);
//                    if(!sqlstr[5-i].equals("`COUNTRY`")){
//                        System.out.println(sqlstr[5-i]);
//                        System.out.println(sqlstr[3-i]);System.out.println(sqlstr[6-i]);System.out.println(sqlstr[15-i]);
//                    query = String.format("SELECT "+sqlstr[3-i]+" FROM "+sqlstr[6-i]+"  WHERE "+sqlstr[15-i]);
//                    System.out.println(query);
//                    re = st.executeQuery(query);
//                    re.next();
//                    val = re.getString(sqlstr[3-i].replace("`", ""));
    //                try{val = re.getString(sqlstr[2-i]);}
    //                catch(Exception e){}
//                    System.out.println("\n"+val+"\n");}
                }
            } catch (SQLException ex) {
                Logger.getLogger(C_RegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        if(data[5].equals("Normal")){
            query = String.format("INSERT INTO `CUSTOMERS`(`Fname`, `Lname`, `Uname`, `Password`, `Contact`, `Gender`, `City_ID`, `Address`) VALUES ('%s','%s','%s','%s',%s,'%s',%s,'%s')",data[0],data[1],data[2],data[3],data[6],data[7],val,data[11]);  
        }
        else{
            query = String.format("INSERT INTO `VENDERS` (`Fname`, `Lname`, `Uname`, `Password`, `Contact`, `Gender`, `City_ID`, `Address`) VALUES ('%s','%s','%s','%s',%s,'%s',%s,'%s')",data[0],data[1],data[2],data[3],data[6],data[7],val,data[11]);  
        }
        try {
            st = M_Connector.getconnection().createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(C_RegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }     
}
