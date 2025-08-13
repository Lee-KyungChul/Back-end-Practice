package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.RodDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class RodDAO {

    private final Properties prop;

    public RodDAO() {
        this.prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/fishing-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<RodDTO> selectAllRod(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        List<RodDTO> rodList = null;

        String query = prop.getProperty("selectAllRodList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            rodList = new ArrayList<>();
            while (rset.next()) {
                RodDTO rod = new RodDTO();
                rod.setRodNo(rset.getInt("rod_no"));
                rod.setFishingPoint(rset.getString("fishing_point"));
                rod.setRodType(rset.getString("rod_type"));
                rod.setRodName(rset.getString("rod_name"));
                rod.setRodLength(rset.getString("rod_length"));
                rod.setRodAction(rset.getString("rod_action"));
                rod.setFishSize(rset.getString("fish_size"));
                rodList.add(rod);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return rodList;
    }


    public int selectLastRodNo(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;
        int maxRodNo = 0;
        String query = prop.getProperty("selectLastRodNo");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                maxRodNo = rset.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return maxRodNo;
    }


    public List<RodDTO> selectTargetRod(Connection con, String fieldName, String fieldValue) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<RodDTO> rodList = null;


        String query = "SELECT * FROM tbl_rod WHERE " + fieldName + " = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, fieldValue);
            rset = pstmt.executeQuery();

            rodList = new ArrayList<>();
            while (rset.next()) {
                RodDTO rod = new RodDTO();
                rod.setRodNo(rset.getInt("rod_no"));
                rod.setFishingPoint(rset.getString("fishing_point"));
                rod.setRodType(rset.getString("rod_type"));
                rod.setRodName(rset.getString("rod_name"));
                rod.setRodLength(rset.getString("rod_length"));
                rod.setRodAction(rset.getString("rod_action"));
                rod.setFishSize(rset.getString("fish_size"));
                rodList.add(rod);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }

        return rodList;
    }


    public int insertNewRod(RodDTO newRod, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertNewRod");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, newRod.getRodNo());
            pstmt.setString(2, newRod.getFishingPoint());
            pstmt.setString(3, newRod.getRodType());
            pstmt.setString(4, newRod.getRodName());
            pstmt.setString(5, newRod.getRodLength());
            pstmt.setString(6, newRod.getRodAction());
            pstmt.setString(7, newRod.getFishSize());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }


    public int updateRod(RodDTO updateRod, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updateRod");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, updateRod.getFishingPoint());
            pstmt.setString(2, updateRod.getRodType());
            pstmt.setString(3, updateRod.getRodName());
            pstmt.setString(4, updateRod.getRodLength());
            pstmt.setString(5, updateRod.getRodAction());
            pstmt.setString(6, updateRod.getFishSize());
            pstmt.setInt(7, updateRod.getRodNo());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }


    public int deleteRod(RodDTO deleteRod, Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deleteRod");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, deleteRod.getRodNo());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}
