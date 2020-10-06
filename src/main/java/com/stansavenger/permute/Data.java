package com.stansavenger.permute;

public class Data {
    private static String baseCurrency = "";
    
    private static final String 
            BASE_URL = "https://api.exchangeratesapi.io/", 
            ENDPOINT = "latest",
            
            ZAR_CODE = "ZAR", 
            EUR_CODE = "EUR", 
            USD_CODE = "USD", 
            CAD_CODE = "CAD",
            GBP_CODE = "GBP", 
            
            ZAR_SYMBOL = "R", 
            EUR_SYMBOL = "€", 
            USD_SYMBOL = "$", 
            CAD_SYMBOL = "$",
            GBP_SYMBOL = "£"; 
    
    private static Double 
            zarValue = 0.0, 
            eurValue = 0.0, 
            usdValue = 0.0, 
            cadValue = 0.0,
            gbpValue = 0.0; 
    
    /*========================
            GETTERS
    ============================*/
    
    public static String GetBaseUrl(){
        return BASE_URL;
    }
    
    public static String GetBaseCurrency(){
        return baseCurrency;
    }
    
    public static String GetEndpoint(){
        return ENDPOINT;
    }
    

    public static String GetCurrencyCodeOrSymbol(String Currency, String PreferredReturnReturnedOutput){
        switch(Currency) {
            case "ZAR":
                return PreferredReturnReturnedOutput.equals("CurrencyCode") ? ZAR_CODE : PreferredReturnReturnedOutput.equals("CurrencySymbol") ? ZAR_SYMBOL : "unknown currency input";
            case "EUR":
                return PreferredReturnReturnedOutput.equals("CurrencyCode") ? EUR_CODE : PreferredReturnReturnedOutput.equals("CurrencySymbol") ? EUR_SYMBOL : "unknown currency input";
            case "USD":
                return PreferredReturnReturnedOutput.equals("CurrencyCode") ? USD_CODE : PreferredReturnReturnedOutput.equals("CurrencySymbol") ? USD_SYMBOL : "unknown currency input";
            case "CAD":
                return PreferredReturnReturnedOutput.equals("CurrencyCode") ? CAD_CODE : PreferredReturnReturnedOutput.equals("CurrencySymbol") ? CAD_SYMBOL : "unknown currency input";
            case "GBP":
                return PreferredReturnReturnedOutput.equals("CurrencyCode") ? GBP_CODE : PreferredReturnReturnedOutput.equals("CurrencySymbol") ? GBP_SYMBOL : "unknown currency input";
            default:
                return "unknown currency input";
        }
    }
    
    public static Double GetCurrencyValue(String Currency){
        switch(Currency) {
            case "ZAR":
                return zarValue;
            case "EUR":
                return eurValue;
            case "USD":
                return usdValue;
            case "CAD":
                return cadValue;
            case "GBP":
                return gbpValue;
            default:
                return 0.0;
        }
    }   
    
    /*========================
            SETTERS
    ============================*/
    
    public static void SetBaseCurrency(String Currency){
        baseCurrency = Currency;
    }
    
    public static void SetCurrencyValue(String Currency, Double Value){
        switch(Currency) {
            case "ZAR":
              zarValue = Value;
              break;
            case "EUR":
              eurValue = Value;
              break;
            case "USD":
              usdValue = Value;
              break;
            case "CAD":
              cadValue = Value;
              break;
            case "GBP":
              gbpValue = Value;
              break;
            default:
              break;
        }
    }
    
}
