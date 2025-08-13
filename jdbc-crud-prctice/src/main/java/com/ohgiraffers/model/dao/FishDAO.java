package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.FishDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class FishDAO {

    private Properties prop = new Properties();

    public FishDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/fishing-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectLastFishNo(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        int maxFishNo = 0;

        String query = prop.getProperty("selectLastFishNo");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                maxFishNo = rset.getInt("MAX(A.fish_no)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }

        return maxFishNo;
    }


    public List<FishDTO> selectAllFish(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<FishDTO> fishList = null;

        String query = prop.getProperty("selectAllFishList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            fishList = new ArrayList<>();

            while (rset.next()) {
                FishDTO fish = new FishDTO();
                fish.setFish_no(rset.getInt("fish_no"));
                fish.setFish_name(rset.getString("fish_name"));
                fish.setFishing_type(rset.getString("fishing_type"));
                fish.setFishing_point(rset.getString("fishing_point"));
                fish.setFish_size(rset.getString("fish_size"));
                fishList.add(fish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }

        return fishList;
    }


    public List<FishDTO> selectTargetFish(Connection con, String fieldName, String fieldValue) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<FishDTO> fishList = null;

        String query = "SELECT fish_no, fish_name, fishing_type, fishing_point, fish_size FROM tbl_fish WHERE " + fieldName + " = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, fieldValue);

            rset = pstmt.executeQuery();
            fishList = new ArrayList<>();

            while (rset.next()) {
                FishDTO fish = new FishDTO();
                fish.setFish_no(rset.getInt("fish_no"));
                fish.setFish_name(rset.getString("fish_name"));
                fish.setFishing_type(rset.getString("fishing_type"));
                fish.setFishing_point(rset.getString("fishing_point"));
                fish.setFish_size(rset.getString("fish_size"));
                fishList.add(fish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return fishList;
    }


    public int insertNewFish(FishDTO newFish, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertNewFish");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, newFish.getFish_no());
            pstmt.setString(2, newFish.getFish_name());
            pstmt.setString(3, newFish.getFishing_type());
            pstmt.setString(4, newFish.getFishing_point());
            pstmt.setString(5, newFish.getFish_size());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    public int updateFish(FishDTO updateFish, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updateFish");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, updateFish.getFish_name());
            pstmt.setString(2, updateFish.getFishing_type());
            pstmt.setString(3, updateFish.getFishing_point());
            pstmt.setString(4, updateFish.getFish_size());
            pstmt.setInt(5, updateFish.getFish_no());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    public int deleteFish(FishDTO deleteFish, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deleteFish");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, deleteFish.getFish_no());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
}
