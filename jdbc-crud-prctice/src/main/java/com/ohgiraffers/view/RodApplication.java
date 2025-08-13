package com.ohgiraffers.view;

import com.ohgiraffers.model.dao.RodDAO;
import com.ohgiraffers.model.dto.RodDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class RodApplication {

    Connection con = getConnection();
    RodDAO rodDAO = new RodDAO();
    Scanner sc = new Scanner(System.in);

    public void svcSelectAllRodList() {
        List<RodDTO> rodList = rodDAO.selectAllRod(con);

        System.out.println();
        System.out.println("* 보유중인 전체 낚시대 목록");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%s | %-5s | %-5s | %-15s | %-5s | %-5s | %-5s%n",
                "No.", "사용장소", "종류", "이름", "길이", "액션", "대상어");
        System.out.println("---------------------------------------------------------------");

        for(RodDTO rod : rodList) {
            System.out.printf("%-3d | %-5s | %-5s | %-15s | %-5s | %-5s | %-5s%n",
                    rod.getRodNo(),
                    rod.getFishingPoint(),
                    rod.getRodType(),
                    rod.getRodName(),
                    rod.getRodLength(),
                    rod.getRodAction(),
                    rod.getFishSize());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }


    public void svcSelectTargetRod() {

        System.out.println("======================== 특정 낚시대 조회 ========================");
        System.out.println("[1/2] 찾고 싶은 낚시대의 필드명을 선택하세요");
        System.out.print("1=사용장소, 2=종류, 3=이름, 4=길이, 5=액션, 6=대상어 : ");
        int tempFieldName = sc.nextInt();
        sc.nextLine();
        String fieldName = null;

        switch (tempFieldName) {
            case 1 : fieldName = "fishing_point"; break;
            case 2 : fieldName = "rod_type"; break;
            case 3 : fieldName = "rod_name"; break;
            case 4 : fieldName = "rod_length"; break;
            case 5 : fieldName = "rod_action"; break;
            case 6 : fieldName = "fish_size"; break;
        }
        System.out.println();

        System.out.print("[2/2] 찾고 싶은 낚시대의 값을 입력하세요 : ");
        String fieldValue = sc.nextLine();

        List<RodDTO> targetRod = rodDAO.selectTargetRod(con, fieldName, fieldValue);

        System.out.println("----------------------------------------------------------");
        System.out.printf("%s | %-5s | %-5s | %-15s | %-5s | %-5s | %-5s%n",
                "No.", "사용장소", "종류", "이름", "길이", "액션", "대상어");
        System.out.println("----------------------------------------------------------");

        for(RodDTO rod : targetRod) {
            System.out.printf("%-3d | %-5s | %-5s | %-15s | %-5s | %-5s | %-5s%n",
                    rod.getRodNo(),
                    rod.getFishingPoint(),
                    rod.getRodType(),
                    rod.getRodName(),
                    rod.getRodLength(),
                    rod.getRodAction(),
                    rod.getFishSize());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }


    public void svcInsertNewRod() {

        int maxRodNo = rodDAO.selectLastRodNo(con);

        System.out.println("maxRodNo = " + maxRodNo);
        System.out.println();
        System.out.println("======================== 신규 낚시대 등록  ========================");
        System.out.println("[1/6] 신규로 등록할 낚시대의 사용 장소를 입력하세요");
        System.out.print("(예) 계류, 강, 선상, 방파제, 저수지 : ");
        String fishingPoint = sc.nextLine();
        System.out.println();
        System.out.println("[2/6] 신규로 등록할 낚시대의 낚시 종류를 입력하세요");
        System.out.print("(예) 플라이, 스피닝, 베이트, 민물: ");
        String rodType = sc.nextLine();
        System.out.println();
        System.out.println("[3/6] 신규로 등록할 낚시대의 이름을 입력하세요");
        System.out.print("(예) SAGE SLP #0 : ");
        String rodName = sc.nextLine();
        System.out.println();
        System.out.println("[4/6] 신규로 등록할 낚시대의 길이를 입력하세요");
        System.out.print("(예) 7.0 : ");
        String rodLength = sc.nextLine();
        System.out.println();
        System.out.println("[5/6] 신규로 등록할 낚시대의 액션을 입력하세요");
        System.out.print("(예) 울트라라이트, 라이트, 미디엄, 페스트 : ");
        String rodAction = sc.nextLine();
        System.out.println();
        System.out.println("[6/6] 신규로 등록할 낚시대의 대상어 크기를 입력하세요");
        System.out.print("(예) 소, 중, 대 : ");
        String fishSize = sc.nextLine();

        int rodNo = maxRodNo + 1;

        RodDTO newRod = new RodDTO(rodNo, fishingPoint, rodType, rodName, rodLength, rodAction, fishSize);

        int result = rodDAO.insertNewRod(newRod, con);

        if(result > 0) {
            System.out.println();
            System.out.println("          **********************************");
            System.out.println("          축하합니다! 신규 낚시대 등록에 성공하였습니다.");
            System.out.println("          **********************************");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("          **********************************");
            System.out.println("          안타깝네요! 신규 낚시대 등록에 실패하였습니다.");
            System.out.println("          **********************************");
            System.out.println();
        }
    }


    public void svcUpdateTargetRod() {
        System.out.println("======================== 기존 낚시대 수정  ========================");
        System.out.print("수정할 낚시대의 등록번호를 입력하세요 : ");
        int rodNoToUpdate = sc.nextInt();
        sc.nextLine();
        System.out.println();
        System.out.println("[1/5] 수정할 낚시대의 사용 장소를 입력하세요");
        System.out.print("(예) 계류, 강, 선상, 방파제, 저수지 : ");
        String fishingPointToUpdate = sc.nextLine();
        System.out.println();
        System.out.println("[2/5] 수정할 낚시대의 낚시 종류를 입력하세요");
        System.out.print("(예) 플라이, 스피닝, 베이트, 민물: ");
        String rodTypeToUpdate = sc.nextLine();
        System.out.println();
        System.out.println("[3/5] 수정할 낚시대의 이름을 입력하세요");
        System.out.print("(예) SAGE SLP #0 : ");
        String rodNameToUpdate = sc.nextLine();
        System.out.println();
        System.out.println("[4/5] 수정할 낚시대의 길이를 입력하세요");
        System.out.print("(예) 7.0 : ");
        String rodLengthToUpdate = sc.nextLine();
        System.out.println();
        System.out.println("[5/5] 수정할 낚시대의 액션을 입력하세요");
        System.out.print("(예) 울트라라이트, 라이트, 미디엄, 페스트 : ");
        String rodActionToUpdate = sc.nextLine();
        System.out.println();
        System.out.println("[6/6] 수정할 낚시대의 대상어 크기를 입력하세요");
        System.out.print("(예) 소, 중, 대 : ");
        String fishSizeToUpdate = sc.nextLine();
        System.out.println();

        RodDTO updateRod = new RodDTO(rodNoToUpdate, fishingPointToUpdate, rodTypeToUpdate, rodNameToUpdate, rodLengthToUpdate, rodActionToUpdate, fishSizeToUpdate);

        int result = rodDAO.updateRod(updateRod, con);

        if(result > 0) {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            축하합니다! 낚시대 수정에 성공하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            안타깝네요! 낚시대 수정에 실패하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        }
    }


    public void svcDeleteTargetRod() {
        System.out.println("======================== 기존 낚시대 삭제  ========================");
        System.out.print("삭제할 낚시대의 등록번호를 입력하세요 : ");
        int rodNoToDelete = sc.nextInt();

        RodDTO deleteRod = new RodDTO();
        deleteRod.setRodNo(rodNoToDelete);

        int result = rodDAO.deleteRod(deleteRod, con);

        if(result > 0) {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("          축하합니다! 낚시대 삭제에 성공하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("          ********************************");
            System.out.println("            안타깝네요! 낚시대 삭제에 실패하였습니다.");
            System.out.println("          ********************************");
            System.out.println();
        }
    }


}
