package com.ohgiraffers.view;

import com.ohgiraffers.model.dao.FishDAO;
import com.ohgiraffers.model.dto.FishDTO;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;


public class FishingApplication {

    Connection con = getConnection();
    FishDAO registFishDAO = new FishDAO();
    Scanner sc = new Scanner(System.in);


    public void fishingGuide() {

        System.out.println();
        System.out.println("======================== 어종별 장비 선택 가이드 ========================");
        System.out.println("[1/4] 어디로 낚시를 가시나요?");
        System.out.print("1=계류, 2=강, 3=저수지, 4=선상, 5=갯바위, 6=방파제 : ");
        int tempFishingPoint = sc.nextInt();
        sc.nextLine();
        String fishingPoint = null;
        switch (tempFishingPoint) {
            case 1 : fishingPoint = "계류"; break;
            case 2 : fishingPoint = "강"; break;
            case 3 : fishingPoint = "저수지"; break;
            case 4 : fishingPoint = "선상"; break;
            case 5 : fishingPoint = "갯바위"; break;
            case 6 : fishingPoint = "방파제"; break;

        }
        System.out.println();

        System.out.println("[2/4] 어떤 고기를 잡으러 가시나요?");
        System.out.print("1=송어, 2=산천어, 3=연어, 4=배스, 5=쏘가리, 6=우럭, 7=광어, 8=참돔, 9=쭈꾸미 : ");
        int tempFishName = sc.nextInt();
        sc.nextLine();
        String fishName = null;
        switch (tempFishName) {
            case 1 : fishName = "송어"; break;
            case 2 : fishName = "산천어"; break;
            case 3 : fishName = "연어"; break;
            case 4 : fishName = "배스"; break;
            case 5 : fishName = "쏘가리"; break;
            case 6 : fishName = "우럭"; break;
            case 7 : fishName = "광어"; break;
            case 8 : fishName = "참돔"; break;
            case 9 : fishName = "쭈꾸미"; break;
        }
        System.out.println();

        System.out.println("[3/4] 어떤 형태의 낚시를 하시나요?");
        System.out.print("1=플라이, 2=루어, 3=선상, 4=갯바위, 5=원투, 6=민물 : ");
        int tempFishingType = sc.nextInt();
        sc.nextLine();
        String fishingType = null;
        switch (tempFishingType) {
            case 1 : fishingType = "플라이"; break;
            case 2 : fishingType = "루어"; break;
            case 3 : fishingType = "선상"; break;
            case 4 : fishingType = "갯바위"; break;
            case 5 : fishingType = "원투"; break;
            case 6 : fishingType = "민물"; break;
        }
        System.out.println();

        System.out.println("[4/4] 잡고자 하는 물고기의 크기는 무언인가요?");
        System.out.print("1=작음, 2=중간, 3=큼, 4=엄청큼 : ");
        int tempFishSize = sc.nextInt();
        sc.nextLine();
        String fishSize = null;
        switch (tempFishSize) {
            case 1 : fishSize = "소"; break;
            case 2 : fishSize = "중"; break;
            case 3 : fishSize = "대"; break;
            case 4 : fishSize = "특대"; break;
        }
        System.out.println();

        Statement stmt1 = null;
        Statement stmt2 = null;

        ResultSet rset1 = null;
        ResultSet rset2 = null;

        String query1 =
                "select A.fish_name, A.fishing_point, A.fishing_type, A.fish_size, B.rod_name, B.rod_type, rod_length, B.rod_action from\n" +
                "(select fish_name, fishing_point, fishing_type, fish_size\n" +
                "from tbl_fish\n" +
                "where fish_name = \"" + fishName +"\") as A\n" +
                "join tbl_rod B\n" +
                "on A.fishing_point = B.fishing_point\n" +
                "AND A.fish_size = B.fish_size\n" +
                "AND A.fishing_type = B.rod_type\n" +
                "WHERE A.fishing_point = \"" + fishingPoint + "\" AND B.rod_type = \"" + fishingType +  "\" AND B.fish_size = \"" + fishSize + "\"";

        try {
            stmt1 = con.createStatement();
            rset1 = stmt1.executeQuery(query1);

            if(rset1.next()) {
                String fishName1 = rset1.getString("fish_name");
                String fishingPoint1 = rset1.getString("fishing_point");
                String fishingType1 = rset1.getString("fishing_type");
                String tempfishSize1 = rset1.getString("fish_size");
                String fishSize1 = "";
                String rodName1 = rset1.getString("rod_name");
                String rodType1 = rset1.getString("rod_type");
                String rodLength1 = rset1.getString("rod_length");
                String rodAction1 = rset1.getString("rod_action");

                switch (tempfishSize1) {
                    case "소" : fishSize1 = "작은"; break;
                    case "중" : fishSize1 = "보통 크기의"; break;
                    case "대" : fishSize1 = "큰"; break;
                    case "특대" : fishSize1 = "엄청 큰"; break;
                }


                System.out.println();
                System.out.println("     ********************** 낚시 장비 추천 **********************");
                System.out.println();
                System.out.println("          " + fishingPoint1 + "(으)로 " + fishSize1 + " " + fishName1 + "(을)를 잡으러 " + fishingType1 + " 낚시를 가시는군요");
                System.out.println();
                System.out.println("      낚시대는 " + rodName1 + " " + rodLength1 + "피트 " + rodAction1 + " 액션을 추천 드리고,");
            } else {
                System.out.println();
                System.out.println("     ********************** 낚시 장비 추천 **********************");
                System.out.println();
                System.out.println("          " + fishingPoint + "(으)로 " + fishSize + " " + fishName + "(을)를 잡으러 " + fishingType + " 낚시를 가시는군요");
                System.out.println();
                System.out.println("      안타깝게도 적당한 낚시대가 없어요. 이럴때 쓰라고 비상금이 있는거잖아요 ^^; ");

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset1);
            close(stmt1);
        }



        String query2 = "select A.fish_name, A.fishing_point, A.fishing_type, A.fish_size, B.reel_name, B.reel_type, reel_weight from\n" +
                "(select fish_name, fishing_point, fishing_type, fish_size\n" +
                "from tbl_fish\n" +
                "where fish_name = \"" + fishName + "\") as A\n" +
                "join tbl_reel B\n" +
                "on A.fishing_point = B.fishing_point\n" +
                "AND A.fish_size = B.reel_weight\n" +
                "AND A.fishing_type = B.fishing_type\n" +
                "WHERE B.fishing_point = \"" + fishingPoint + "\" " +
                "AND B.reel_weight = \"" + fishSize + "\" " +
                "AND B.fishing_type = \"" + fishingType + "\"";



        try {
            stmt2 = con.createStatement();
            rset2 = stmt2.executeQuery(query2);
            if (rset2.next()) {
                String fishName2 = rset2.getString("fish_name");
                String fishingPoint2 = rset2.getString("fishing_point");
                String fishingType2 = rset2.getString("fishing_type");
                String fishSize2 = rset2.getString("fish_size");
                String reelName2 = rset2.getString("reel_name");
                String reelType2 = rset2.getString("reel_type");
                String reelWeight2 = rset2.getString("reel_weight");


                System.out.println("               릴은 " + reelName2 + "(을)를 추천 드려요!!!");
                System.out.println();
                System.out.println("                          어복 많땅 하세요~~~~");
                System.out.println();
                System.out.println("     *********************************************************");

            } else {
                System.out.println("               적당한 릴이 없어요. 비상금 바닥 나겠는데요 ㅎㅎㅎ");
                System.out.println();
                System.out.println("                          어복 많땅 하세요~~~~");
                System.out.println();
                System.out.println("     *********************************************************");
            }
            System.out.println(query2);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset2);
            close(stmt2);
        }



    }

    public void svcSelectAllFishList() {

        System.out.println();
        System.out.println("* 등록중인 전체 물고기 목록");
        List<FishDTO> fishList = registFishDAO.selectAllFish(con);

        if (fishList != null && !fishList.isEmpty()) {
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-5s | %-10s | %-10s | %-10s | %-5s%n",
                    "No.", "물고기 이름", "낚시 종류", "낚시 포인트", "크기");
            System.out.println("----------------------------------------------------------");
            for (FishDTO fish : fishList) {
                System.out.printf("%-5d | %-10s | %-10s | %-10s | %-5s%n",
                        fish.getFish_no(),
                        fish.getFish_name(),
                        fish.getFishing_type(),
                        fish.getFishing_point(),
                        fish.getFish_size());
            }
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("등록된 물고기가 없습니다.");
        }
    }


    public void svcSelectTargetFish() {
        System.out.println("======================== 특정 물고기 정보 조회  ========================");
        System.out.println("찾고 싶은 물고기의 검색 조건을 선택하세요.");
        System.out.print("1. 이름, 2. 낚시 종류, 3. 낚시 포인트, 4. 크기 : ");
        int choice = sc.nextInt();
        sc.nextLine();

        String fieldName = null;
        switch (choice) {
            case 1:
                fieldName = "fish_name";
                break;
            case 2:
                fieldName = "fishing_type";
                break;
            case 3:
                fieldName = "fishing_point";
                break;
            case 4:
                fieldName = "fish_size";
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        System.out.print("검색할 값을 입력하세요: ");
        String fieldValue = sc.nextLine();

        List<FishDTO> targetFishList = registFishDAO.selectTargetFish(con, fieldName, fieldValue);

        if (targetFishList != null && !targetFishList.isEmpty()) {
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-5s | %-10s | %-10s | %-10s | %-5s%n",
                    "No.", "물고기 이름", "낚시 종류", "낚시 포인트", "크기");
            System.out.println("----------------------------------------------------------");
            for (FishDTO fish : targetFishList) {
                System.out.printf("%-5d | %-10s | %-10s | %-10s | %-5s%n",
                        fish.getFish_no(),
                        fish.getFish_name(),
                        fish.getFishing_type(),
                        fish.getFishing_point(),
                        fish.getFish_size());
            }
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("해당 조건에 맞는 물고기가 없습니다.");
        }
    }


    public void svcInsertNewFish() {
        System.out.println("======================== 신규 물고기 등록  ========================");
        int newFishNo = registFishDAO.selectLastFishNo(con) + 1;

        System.out.print("신규 물고기 이름을 입력하세요: ");
        String fishName = sc.nextLine();
        System.out.print("신규 물고기 낚시 종류를 입력하세요: ");
        String fishingType = sc.nextLine();
        System.out.print("신규 물고기 낚시 포인트를 입력하세요: ");
        String fishingPoint = sc.nextLine();
        System.out.print("신규 물고기 크기를 입력하세요 (소, 중, 대, 특대): ");
        String fishSize = sc.nextLine();

        FishDTO newFish = new FishDTO(newFishNo, fishName, fishingType, fishingPoint, fishSize);
        int result = registFishDAO.insertNewFish(newFish, con);

        if (result > 0) {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("        축하합니다! 새로운 물고기 등록에 성공하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("         안타깝네요! 새로운 물고기 등록에 실패하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        }
    }


    public void svcUpdateFish() {
        System.out.println("======================== 기존 물고기 정보 수정  ========================");
        System.out.print("수정할 물고기 번호를 입력하세요: ");
        int fishNo = sc.nextInt();
        sc.nextLine();

        System.out.print("수정할 물고기 이름을 입력하세요: ");
        String fishName = sc.nextLine();
        System.out.print("수정할 물고기 낚시 종류를 입력하세요: ");
        String fishingType = sc.nextLine();
        System.out.print("수정할 물고기 낚시 포인트를 입력하세요: ");
        String fishingPoint = sc.nextLine();
        System.out.print("수정할 물고기 크기를 입력하세요 (소, 중, 대, 특대): ");
        String fishSize = sc.nextLine();

        FishDTO updateFish = new FishDTO(fishNo, fishName, fishingType, fishingPoint, fishSize);
        int result = registFishDAO.updateFish(updateFish, con);

        if (result > 0) {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("         축하합니다! 물고기 정보 수정에 성공하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("         안타깝네요! 물고기 정보 수정에 실패하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        }
    }


    public void svcDeleteFish() {
        System.out.println("======================== 기존 물고기 정보 삭제  ========================");
        System.out.print("삭제할 물고기 번호를 입력하세요: ");
        int fishNo = sc.nextInt();
        sc.nextLine();

        FishDTO deleteFish = new FishDTO();
        deleteFish.setFish_no(fishNo);
        int result = registFishDAO.deleteFish(deleteFish, con);

        if (result > 0) {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("         축하합니다! 물고기 정보 삭제에 성공하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("         안타깝네요! 물고기 정보 삭제에 실패하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        }
    }
}


