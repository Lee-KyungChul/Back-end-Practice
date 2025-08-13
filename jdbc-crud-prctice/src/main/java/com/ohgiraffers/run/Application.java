package com.ohgiraffers.run;

import com.ohgiraffers.view.FishingApplication;
import com.ohgiraffers.view.ReelApplication;
import com.ohgiraffers.view.RodApplication;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ReelApplication reelSvc = new ReelApplication();
        RodApplication rodSvc = new RodApplication();
        FishingApplication fishingSvc = new FishingApplication();

        while (true) {
            System.out.println();
            System.out.println("======================== 낚시 장비 관리 프로그램 ========================");
            System.out.println("                        1. 어종별 장비 선택 가이드");
            System.out.println("                        2. 릴 관리");
            System.out.println("                        3. 낚시대 관리");
            System.out.println("                        9. 프로그램 종료");
            System.out.println("===================================================================");
            System.out.print(" 메뉴 선택 : ");
            int menuNo = sc.nextInt();

            switch (menuNo) {
                case 1:
                    fishingMenu(sc, fishingSvc);
                    break;
                case 2:
                    reelMenu(sc, reelSvc);
                    break;
                case 3:
                    rodMenu(sc, rodSvc);
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다.");
            }
        }
    }

    private static void fishingMenu(Scanner sc, FishingApplication fishingSvc) {

        while (true) {
            System.out.println();
            System.out.println("======================== 어종별 장비 선택 가이드 ========================");
            System.out.println("                      1. 어떤 물고기를 잡으러 가시나요?");
            System.out.println("                      2. 전체 대상어 조회");
            System.out.println("                      3. 특정 대상어 조회");
            System.out.println("                      4. 신규 대상어 등록");
            System.out.println("                      5. 기존 대상어 데이터 수정");
            System.out.println("                      6. 기존 대상어 삭제");
            System.out.println("                      9. 이전 메뉴로 돌아가기");
            System.out.println("====================================================================");
            System.out.print(" 메뉴 선택 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    fishingSvc.fishingGuide();
                    break;
                case 2:
                    fishingSvc.svcSelectAllFishList();
                    break;
                case 3:
                    fishingSvc.svcSelectTargetFish();
                    break;
                case 4:
                    fishingSvc.svcInsertNewFish();
                    break;
                case 5:
                    fishingSvc.svcSelectAllFishList();
                    fishingSvc.svcUpdateFish();
                    break;
                case 6:
                    fishingSvc.svcSelectAllFishList();
                    fishingSvc.svcDeleteFish();
                    break;
                case 9:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다.");
                    break;
            }
        }


    }

    private static void reelMenu(Scanner sc, ReelApplication reelSvc) {
        while (true) {
            System.out.println();
            System.out.println("======================== 릴 관리 메뉴 ========================");
            System.out.println("                      1. 릴 전체 조회");
            System.out.println("                      2. 특정 릴 조회");
            System.out.println("                      3. 신규 릴 등록");
            System.out.println("                      4. 기존 릴 데이터 수정");
            System.out.println("                      5. 기존 릴 삭제");
            System.out.println("                      9. 이전 메뉴로 돌아가기");
            System.out.println("===========================================================");
            System.out.print(" 메뉴 선택 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    reelSvc.svcSelectAllReelList();
                    break;
                case 2:
                    reelSvc.svcSelectTargetReel();
                    break;
                case 3:
                    reelSvc.svcInsertNewReel();
                    break;
                case 4:
                    reelSvc.svcSelectAllReelList();
                    reelSvc.svcUpdateTargetReel();
                    break;
                case 5:
                    reelSvc.svcSelectAllReelList();
                    reelSvc.svcDeleteTargetReel();
                    break;
                case 9:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다.");
                    break;
            }
        }
    }

    private static void rodMenu(Scanner sc, RodApplication rodSvc) {
        while (true) {
            System.out.println();
            System.out.println("======================== 낚시대 관리 메뉴 ========================");
            System.out.println("                      1. 낚시대 전체 조회");
            System.out.println("                      2. 특정 낚시대 조회");
            System.out.println("                      3. 신규 낚시대 등록");
            System.out.println("                      4. 기존 낚시대 데이터 수정");
            System.out.println("                      5. 기존 낚시대 삭제");
            System.out.println("                      9. 이전 메뉴로 돌아가기");
            System.out.println("=============================================================");
            System.out.print(" 메뉴 선택 : ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no) {
                case 1:
                    rodSvc.svcSelectAllRodList();
                    break;
                case 2:
                    rodSvc.svcSelectTargetRod();
                    break;
                case 3:
                    rodSvc.svcInsertNewRod();
                    break;
                case 4:
                    rodSvc.svcSelectAllRodList();
                    rodSvc.svcUpdateTargetRod();
                    break;
                case 5:
                    rodSvc.svcSelectAllRodList();
                    rodSvc.svcDeleteTargetRod();
                    break;
                case 9:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다.");
                    break;
            }
        }
    }
}
