package com.stansavenger.permute;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;
import org.apache.http.ParseException;
import org.apache.http.HttpEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class ConvertMoneyToOtherCurrency {
    
    static CloseableHttpClient httpClient = HttpClients.createDefault();
    
    public static void ConvertCurrency(double amountOfMoney, String inputCurrency, String outputCurrency)throws IOException{
        double convertedAmount;
        Data.SetBaseCurrency(inputCurrency);
        HttpGet get = new HttpGet(Data.GetBaseUrl() + Data.GetEndpoint() + "?base="+ Data.GetBaseCurrency());
        
        try {
            try (CloseableHttpResponse response = httpClient.execute(get)) {
                HttpEntity entity = response.getEntity();
                
                // the following line converts the JSON Response to an equivalent Java Object
                JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
                
                convertedAmount = amountOfMoney * exchangeRates.getJSONObject("rates").getDouble(outputCurrency);
                
                Data.SetCurrencyValue(Data.GetCurrencyCodeOrSymbol(outputCurrency,"CurrencyCode"), convertedAmount);
            }
        } catch (ClientProtocolException e) {
            System.out.println(e);
        } catch (IOException | ParseException | JSONException e) {
            System.out.println(e);
        }
        
        httpClient.close();
    }
}
