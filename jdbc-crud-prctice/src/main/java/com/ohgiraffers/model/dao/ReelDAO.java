package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.ReelDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;


public class ReelDAO {

    public Properties prop = new Properties();

    public ReelDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/fishing-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int selectLastReelNo(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        int maxReelNo = 0;

        String query = prop.getProperty("selectLastReelNo");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                maxReelNo = rset.getInt("MAX(A.REEL_NO)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return maxReelNo;

    }

    public List<ReelDTO> selectAllReel(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        List<ReelDTO> reelList = null;

        String query = prop.getProperty("selectAllReelList");

        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            reelList = new ArrayList<>();

            while (rset.next()) {
                ReelDTO reel = new ReelDTO();

                reel.setReel_no(rset.getInt("REEL_NO"));
                reel.setFishing_point(rset.getString("FISHING_POINT"));
                reel.setFishing_type(rset.getString("FISHING_TYPE"));
                reel.setReel_name(rset.getString("REEL_NAME"));
                reel.setReel_type(rset.getString("REEL_TYPE"));
                reel.setReel_weight(rset.getString("REEL_WEIGHT"));

                reelList.add(reel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return reelList;
    }




    public List<ReelDTO> selectTargetReel(Connection con, String fieldName, String fieldValue) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        List<ReelDTO> targetReel = null;

        String query = "SELECT REEL_NO, FISHING_POINT, FISHING_TYPE, REEL_NAME, REEL_TYPE, REEL_WEIGHT FROM TBL_REEL WHERE " + fieldName + " = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, fieldValue);

            rset = pstmt.executeQuery();

            targetReel = new ArrayList<>();

            while (rset.next()) {
                ReelDTO reel = new ReelDTO();

                reel.setReel_no(rset.getInt("REEL_NO"));
                reel.setFishing_point(rset.getString("FISHING_POINT"));
                reel.setFishing_type(rset.getString("FISHING_TYPE"));
                reel.setReel_name(rset.getString("REEL_NAME"));
                reel.setReel_type(rset.getString("REEL_TYPE"));
                reel.setReel_weight(rset.getString("REEL_WEIGHT"));

                targetReel.add(reel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return targetReel;
    }


    public int insertNewReel(ReelDTO newReel, Connection con) {

        PreparedStatement pstmt  = null;

        int result = 0;

        String query = prop.getProperty("insertNewReel");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, newReel.getReel_no());
            pstmt.setString(2, newReel.getFishing_point());
            pstmt.setString(3, newReel.getFishing_type());
            pstmt.setString(4, newReel.getReel_name());
            pstmt.setString(5, newReel.getReel_type());
            pstmt.setString(6, newReel.getReel_weight());


            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;

    }

    public int updateReel(ReelDTO updateReel, Connection con) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("updateReel");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, updateReel.getFishing_point());
            pstmt.setString(2, updateReel.getFishing_type());
            pstmt.setString(3, updateReel.getReel_name());
            pstmt.setString(4, updateReel.getReel_type());
            pstmt.setString(5, updateReel.getReel_weight());
            pstmt.setInt(6, updateReel.getReel_no());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;

    }

    public int deleteReel(ReelDTO deleteReel, Connection con) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("deleteReel");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, deleteReel.getReel_no());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;

    }

}
