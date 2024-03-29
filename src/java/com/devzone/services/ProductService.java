package com.devzone.services;

import com.devzone.model.Product;
import com.devzone.util.dbConnect.DBConnection;
import com.devzone.util.query.MaterialQueries;
import com.devzone.util.query.ProductQueries;
import com.devzone.util.utility.UtilityMethod;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private ArrayList<Product> productsData = new ArrayList<Product>();

    public ArrayList<Product> loadData() {
        try {
            Connection conn = DBConnection.Connect();
            ResultSet rsLoadProduct = conn.createStatement().executeQuery(ProductQueries.LOAD_DATA_QUERY);

            while (rsLoadProduct.next()) {
              productsData.add(new Product(rsLoadProduct.getString(1), rsLoadProduct.getString(2), rsLoadProduct.getString(3), rsLoadProduct.getString(4), rsLoadProduct.getString(5), rsLoadProduct.getString(6), rsLoadProduct.getString(7), rsLoadProduct.getString(8), rsLoadProduct.getString(9), rsLoadProduct.getDouble(10), UtilityMethod.base64Image(rsLoadProduct.getBlob(11)), UtilityMethod.base64Image(rsLoadProduct.getBlob(12)), UtilityMethod.base64Image(rsLoadProduct.getBlob(13)), rsLoadProduct.getString(14)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return productsData;
    }

    public Product selectProduct(String ID) {
        Product productData = new Product();
        PreparedStatement psProduct = null;
        ResultSet rsLoadProduct = null;
        try {
            Connection conn = DBConnection.Connect();
            psProduct = conn.prepareStatement(ProductQueries.SELECT_DATA_QUERY);
            psProduct.setInt(1, UtilityMethod.seperateID(ID));
            rsLoadProduct = psProduct.executeQuery();
            while (rsLoadProduct.next()) {
                productData.setpID(rsLoadProduct.getString(1));
                productData.setpName(rsLoadProduct.getString(2));
                productData.setpDescription(rsLoadProduct.getString(3));
                productData.setpDimention(rsLoadProduct.getString(4));
                productData.setpWeight(rsLoadProduct.getString(5));
                productData.setpColor(rsLoadProduct.getString(6));
                productData.setpMaterial(rsLoadProduct.getString(7));
                productData.setpAvailability(rsLoadProduct.getString(8));
                productData.setpCustomize(rsLoadProduct.getString(9));
                productData.setpPrice(String.valueOf(rsLoadProduct.getDouble(10)));
                productData.setpImage1(UtilityMethod.base64Image(rsLoadProduct.getBlob(11)));
                productData.setpImage2(UtilityMethod.base64Image(rsLoadProduct.getBlob(12)));
                productData.setpImage3(UtilityMethod.base64Image(rsLoadProduct.getBlob(13)));
                productData.setpHomeProduct(rsLoadProduct.getString(14));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                psProduct.close();
                rsLoadProduct.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return productData;
    }

    public boolean insertData(Product product) throws Exception {
        PreparedStatement psProduct = null;
        boolean resultval = false;
        InputStream stream1 = null;
        InputStream stream2 = null;
        InputStream stream3 = null;
        try {
            Connection conn = DBConnection.Connect();
            psProduct = conn.prepareStatement(ProductQueries.INSERT_DATA_QUERY);
            
            
            psProduct.setString(1, product.getpName());
            psProduct.setString(2, product.getpDescription());
            psProduct.setString(3, product.getpDimention());
            psProduct.setString(4, product.getpWeight());
            psProduct.setString(5, product.getpColor());
            psProduct.setString(6, product.getpMaterial());
            psProduct.setString(7, product.getpAvailability());
            psProduct.setString(8, product.getpCustomize());
            psProduct.setDouble(9, product.getpPrice());
            //psProduct.setBytes(10, product.getpImage1());
            //psProduct.setBytes(11, product.getpImage2());
            //psProduct.setBytes(12, product.getpImage3());
            psProduct.setString(13, product.getpHomeProduct());
            
            
            psProduct.execute();
            //AlertPopUp.insertSuccesfully("Allowance Scheme");
            resultval = true;

        } catch (SQLException ex) {
            //AlertPopUp.insertionFailed(ex, "Allowance Scheme");
        } finally {
            psProduct.close();

        }
        return resultval;
    }

    public boolean updateData(Product product) throws Exception {
        PreparedStatement psProduct = null;
        boolean resultVal = false;
        InputStream stream1 = null;
        InputStream stream2 = null;
        InputStream stream3 = null;
        try {
            Connection conn = DBConnection.Connect();
            psProduct = conn.prepareStatement(ProductQueries.UPDATE_DATA_QUERY);
            
            
            psProduct.setString(1, product.getpName());
            psProduct.setString(2, product.getpDescription());
            psProduct.setString(3, product.getpDimention());
            psProduct.setString(4, product.getpWeight());
            psProduct.setString(5, product.getpColor());
            psProduct.setString(6, product.getpMaterial());
            psProduct.setString(7, product.getpAvailability());
            psProduct.setString(8, product.getpCustomize());
            psProduct.setDouble(9, product.getpPrice());
            //psProduct.setBytes(10, product.getpImage1());
            //psProduct.setBytes(11, product.getpImage2());
            //psProduct.setBytes(12, product.getpImage3());
            psProduct.setString(13, product.getpHomeProduct());
            psProduct.setInt(14, UtilityMethod.seperateID(product.getpID()));
            psProduct.execute();
            // AlertPopUp.updateSuccesfully("Allowance Scheme");
            resultVal = true;

        } catch (SQLException ex) {
            // AlertPopUp.updateFailed(ex, "Allowance Scheme");

        } finally {
            //psAllowance.close();
        }
        return resultVal;
    }

    public Boolean deleteData(String itemID) throws SQLException {
        PreparedStatement psProduct = null;
        Boolean resultVal = false;
        Connection conn = DBConnection.Connect();
        try {
            psProduct = conn.prepareStatement(ProductQueries.DELETE_DATA_QUERY);
            psProduct.setInt(1, UtilityMethod.seperateID(itemID));
            psProduct.executeUpdate();
            //AlertPopUp.deleteSuccesfull("Allowance Scheme");
            resultVal = true;

        } catch (SQLException ex) {
            //AlertPopUp.deleteFailed(ex, "Allowance Scheme");
        } finally {
            //psAllowance.close();
        }
        return resultVal;
    }
    /*
    public SortedList<Product> searchTable(String searchField){

        //Retreiving all data from database
        ObservableList<Product> productsData = null;

        try {
            Connection conn = DBConnection.Connect();
            productsData = FXCollections.observableArrayList();
            ResultSet rsLoadProduct = conn.createStatement().executeQuery(ProductQueries.LOAD_DATA_QUERY);

            while (rsLoadProduct.next()) {
                productsData.add(new Product(rsLoadProduct.getString(1),rsLoadProduct.getString(2),rsLoadProduct.getString(3),rsLoadProduct.getString(4),rsLoadProduct.getString(5),rsLoadProduct.getString(6),rsLoadProduct.getString(7),rsLoadProduct.getString(8),rsLoadProduct.getString(9)));
            }
        } catch (SQLException ex) {

        }
        //Wrap the ObservableList in a filtered List (initially display all data)
        FilteredList<Product> filteredData = new FilteredList<>(productsData, b -> true);

        searchField.Listener((observable,oldValue,newValue) ->{
            filteredData.setPredicate(allowance -> {
                //if filter text is empty display all data
                if(newValue == null){
                    return true;
                }
                //comparing search text with table columns one by one
                String lowerCaseFilter = newValue.toLowerCase();

                if(allowance.getaID().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaTitle().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaDescription().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaType().toLowerCase().indexOf(lowerCaseFilter) !=-1){
                    //return if filter matches data
                    return true;
                }else if(String.valueOf(allowance.getaValue()).toLowerCase().indexOf(lowerCaseFilter) !=-1){
                    //return if filter matches data
                    return true;
                }else{
                    //have no matchings
                    return false;
                }
            });
        });
        //wrapping the FilteredList in a SortedList
        SortedList<Allowance> sortedData = new SortedList<>(filteredData);
        return sortedData;
    }
     */
}
