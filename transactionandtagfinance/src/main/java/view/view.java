package view;


import model.TagFinance;
import model.Transaction;
import controller.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class view {
    private static List<TagFinance> tagFinanceList = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();
    private static List<Transaction> transactionList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    static controller controller = new controller();

    public static void main(String[] args) {


        int choice = 0;
        do {
            showMenu();

            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    controller.insertTagFinance();
                    break;
                }
                case 2: {
                    System.out.println("enter id tagFinance you want to update");
                    int idUpdate = scanner.nextInt();
                    controller.updateTagFinance(idUpdate);
                    break;
                }
                case 3: {
                    System.out.println("enter id tagFinance");
                    int idDelete = scanner.nextInt();
                    controller.deleteTagFinance(idDelete);
                    break;
                }
                case 4: {
                    tagFinanceList = controller.getAllTagFinance();
                    showAllTag(tagFinanceList);
                    break;
                }
                case 5: {
                    tagFinanceList = controller.getAllTagFinance();
                    showAllTag(tagFinanceList);
                    controller.insertTransaction(tagFinanceList);
                    break;
                }
                case 6: {
                    transactionList = controller.getAllTransaction();
                    showAllTransaction(transactionList);
                    break;
                }
                case 7: {
                    System.out.println("enter id Transaction you want to delete");
                    int idDeleteTransaction = scanner.nextInt();
                    controller.deleteTransactions(idDeleteTransaction);
                    break;
                }
                case 8: {
                    System.out.println("enter id Transaction you want to update");
                    int idUpdateTransaction = scanner.nextInt();
                    controller.updateTagFinance(idUpdateTransaction);
                    break;
                }
                case 9: {
                    System.out.println("enter id Transaction");
                    int idSearch = scanner.nextInt();
                    transactions = controller.searchTransactionByTagfinal(idSearch);
                    showAllTransaction(transactions);
                    break;
                }
                case 10: {
                    scanner.nextLine();
                    System.out.println("enter name Transaction");
                    String name = scanner.nextLine();
                    transactions = controller.searchTransactionByName(name);
                    showAllTransaction(transactions);

                    break;
                }
            }
        } while (choice != 0);


    }

    private static void showMenu() {
        System.out.println("1.Insert tag finance");
        System.out.println("2.update tag finance");
        System.out.println("3.delete tag finance");
        System.out.println("4.show tag finance");
        System.out.println("5.Insert transaction");
        System.out.println("6.show transaction");
        System.out.println("7.Delete transaction");
        System.out.println("8.Update transaction");
        System.out.println("9.Search by Id");
        System.out.println("10.Search by name");
    }

    private static void showAllTag(List<TagFinance> tagFinanceList) {
        for (TagFinance tagFinance : tagFinanceList) {
            System.out.println(tagFinance);
        }
    }

    private static void showAllTransaction(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }
}