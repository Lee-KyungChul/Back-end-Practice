package com.ohgiraffers.view;

import com.ohgiraffers.model.dao.ReelDAO;
import com.ohgiraffers.model.dto.ReelDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class ReelApplication {

    Connection con = getConnection();
    ReelDAO registReelDAO = new ReelDAO();
    Scanner sc = new Scanner(System.in);

    public void svcSelectAllReelList() {
        List<ReelDTO> reelList = registReelDAO.selectAllReel(con);

        System.out.println();
        System.out.println("* 보유중인 전체 릴 목록");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%s | %s | %s | %-15s | %-5s | %-5s %n",
                "No.", "사용장소", "낚시종류", "릴 이름", "릴 종류", "무게");
        System.out.println("----------------------------------------------------------");

        for(ReelDTO reel : reelList) {
            System.out.printf("%-3d | %-5s | %-5s | %-15s | %-5s | %-10s%n",
                    reel.getReel_no(),
                    reel.getFishing_point(),
                    reel.getFishing_type(),
                    reel.getReel_name(),
                    reel.getReel_type(),
                    reel.getReel_weight());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();

    }

    public void svcSelectTargetReel() {

        System.out.println("======================== 특정 릴 조회 ========================");
        System.out.println("[1/2] 찾고 싶은 릴의 필드명을 선택하세요");
        System.out.print("1=사용장소, 2=낚시종류, 3=이름, 4=종류, 5=무게 : ");
        int tempFieldName = sc.nextInt();
        sc.nextLine();
        String fieldName = null;

        switch (tempFieldName) {
            case 1 : fieldName = "fishing_point"; break;
            case 2 : fieldName = "fishing_type"; break;
            case 3 : fieldName = "reel_name"; break;
            case 4 : fieldName = "reel_type"; break;
            case 5 : fieldName = "reel_weight"; break;
        }
        System.out.println();

        System.out.print("[2/2] 찾고 싶은 릴의 값을 입력하세요 : ");
        String fieldValue = sc.nextLine();

        List<ReelDTO> targetReel = registReelDAO.selectTargetReel(con, fieldName, fieldValue);

        System.out.println("----------------------------------------------------------");
        System.out.printf("%s | %s | %s | %-15s | %-5s | %-5s %n",
                "No.", "사용장소", "낚시종류", "릴 이름", "릴 종류", "무게");
        System.out.println("----------------------------------------------------------");

        for(ReelDTO reel : targetReel) {
            System.out.printf("%-3d | %-5s | %-5s | %-15s | %-5s | %-10s%n",
                    reel.getReel_no(),
                    reel.getFishing_point(),
                    reel.getFishing_type(),
                    reel.getReel_name(),
                    reel.getReel_type(),
                    reel.getReel_weight());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();

    }



    public void svcInsertNewReel() {

        /* 1. 릴의 마지막 번호 조회 */
        int maxReelNo = registReelDAO.selectLastReelNo(con);

        System.out.println("maxReelNo = " + maxReelNo);
        System.out.println();
        System.out.println("======================== 신규 릴 등록  ========================");
        System.out.println("[1/5] 신규로 등록할 릴의 사용 장소를 입력하세요");
        System.out.print("(예) 계류, 강, 선상, 방파제, 갯바위, 저수지 : ");
        String fishingPoint = sc.nextLine();
        System.out.println();
        System.out.println("[2/5] 신규로 등록할 릴의 낚시 종류를 입력하세요");
        System.out.print("(예) 플라이, 루어, 선상, 방파제, 갯바위, 원투: ");
        String fishingType = sc.nextLine();
        System.out.println();
        System.out.println("[3/5] 신규로 등록할 릴의 이름을 입력하세요");
        System.out.print("(예) ABEL TR #0 : ");
        String reelName = sc.nextLine();
        System.out.println();
        System.out.println("[4/5] 신규로 등록할 릴의 낚시 종류를 입력하세요");
        System.out.print("(예) 플라이, 스피닝, 베이트 : ");
        String reelType = sc.nextLine();
        System.out.println();
        System.out.println("[5/5] 신규로 등록할 릴의 무게을 입력하세요");
        System.out.print("(예) 울트라라이트, 라이트, 미디엄, 미더엄헤비, 헤비 : ");
        String reelWeight = sc.nextLine();

        int reelNo = maxReelNo + 1;

        ReelDTO newReel = new ReelDTO(reelNo, fishingPoint, fishingType, reelName, reelType, reelWeight);

        int result = registReelDAO.insertNewReel(newReel, con);

        if(result > 0) {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            축하합니다! 신규 릴 등록에 성공하였습니다.");
            System.out.println("          ********************************");
            System.out.println();

        } else {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            안타깝네요! 신규 릴 등록에 실패하였습니다.");
            System.out.println("          ********************************");
            System.out.println();

        }
        System.out.println();
    }



    public void svcUpdateTargetReel() {

        System.out.println("======================== 기존 릴 수정  ========================");
        System.out.print("수정할 릴의 등록번호를 입력하세요 : ");
        int reelNo1 = sc.nextInt();
        sc.nextLine();
        System.out.println();
        System.out.println("[1/5] 수정할 릴의 사용 장소를 입력하세요");
        System.out.print("(예) 계류, 강, 선상, 방파제, 갯바위, 저수지 : ");
        String fishingPoint1 = sc.nextLine();
        System.out.println();
        System.out.println("[2/5] 수정할 릴의 낚시 종류를 입력하세요");
        System.out.print("(예) 플라이, 루어, 선상, 방파제, 갯바위, 원투: ");
        String fishingType1 = sc.nextLine();
        System.out.println();
        System.out.println("[3/5] 수정할 릴의 이름을 입력하세요");
        System.out.print("(예) ABEL TR #0 : ");
        String reelName1 = sc.nextLine();
        System.out.println();
        System.out.println("[4/5] 수정할 릴의 낚시 종류를 입력하세요");
        System.out.print("(예) 플라이, 스피닝, 베이트 : ");
        String reelType1 = sc.nextLine();
        System.out.println();
        System.out.println("[5/5] 수정할 릴의 무게을 입력하세요");
        System.out.print("(예) 울트라라이트, 라이트, 미디엄, 미더엄헤비, 헤비 : ");
        String reelWeight1 = sc.nextLine();

        ReelDTO updateReel = new ReelDTO(reelNo1, fishingPoint1, fishingType1, reelName1, reelType1, reelWeight1);

        int result1 = registReelDAO.updateReel(updateReel, con);

        if(result1 > 0) {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            축하합니다! 릴 업데이트에 성공하였습니다.");
            System.out.println("          ********************************");
            System.out.println();


        } else {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            안타깝네요! 릴 업데이트에 실패하였습니다.");
            System.out.println("          ********************************");
            System.out.println();

        }


    }


    public void svcDeleteTargetReel() {

        System.out.println("======================== 기존 릴 삭제  ========================");
        System.out.print("삭제할 릴의 등록번호를 입력하세요 : ");
        int reelNo2 = sc.nextInt();

        ReelDTO deleteReel = new ReelDTO();
        deleteReel.setReel_no(reelNo2);

        int result2 = registReelDAO.deleteReel(deleteReel, con);

        if(result2 > 0) {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            축하합니다! 릴 삭제에 성공하였습니다.");
            System.out.println("          ********************************");
            System.out.println();


        } else {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            안타깝네요! 릴 삭제에 실패하였습니다.");
            System.out.println("          ********************************");
            System.out.println();

        }


    }


}
