package com.stansavenger.permute;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

import java.util.Scanner;

public class Permute {
   static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int amountOfMoney;
        String inputCurrency,outputCurrency;
        
        System.out.println("Enter Amount Of Money: ");
        amountOfMoney = scanner.nextInt();
        
        System.out.println("Enter The Currency You Want to Convert: ");
        inputCurrency = scanner.next().toUpperCase();
        
        System.out.println("Enter The Currency You Want to Exchange To: ");
        outputCurrency = scanner.next().toUpperCase();
        
        ConvertMoneyToOtherCurrency.ConvertCurrency(amountOfMoney,inputCurrency,outputCurrency);
        
        System.out.println(Data.GetCurrencyCodeOrSymbol(inputCurrency, "CurrencySymbol")+ amountOfMoney + " = " + Data.GetCurrencyCodeOrSymbol(outputCurrency, "CurrencySymbol") + Data.GetCurrencyValue(outputCurrency));
        
    }
    
}