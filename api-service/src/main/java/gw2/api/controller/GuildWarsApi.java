package gw2.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import gw2.api.model.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.List;

public class GuildWarsApi {

    private static final String baseUrl = "https://api.guildwars2.com/v2/";

    public static GuildWarsAccount getAccount(String apiKey) {

        String url = baseUrl + "account?access_token=" + apiKey + "&?lang=de";
        String responseBody = get(url);
        ObjectMapper mapper = new ObjectMapper();
        try{
            GuildWarsAccount account = mapper.readValue(responseBody, new TypeReference<GuildWarsAccount>(){});
            return account;
        }
        catch (Exception ex) {
            System.out.println("[GW2_API] PARSING ERROR: " + ex.getMessage());
            return null;
        }
    }

    public static List<GuildWarsAchievementProgress> getAchievements(String apiKey) {
        String url = baseUrl + "account/achievements?access_token=" + apiKey + "&?lang=de";
        String responseBody = get(url);
        ObjectMapper mapper = new ObjectMapper();
        try{
            GuildWarsAchievementStatus[] achievementStates = mapper.readValue(responseBody, new TypeReference<GuildWarsAchievementStatus[]>(){});
            List<Integer> achievementIds = new ArrayList<Integer>();
            for(GuildWarsAchievementStatus status : achievementStates) {
                achievementIds.add(status.getId());
            }
            List<GuildWarsAchievement> achievements = new ArrayList<>();
            List<List<Integer>> achievementIdChunks = Lists.partition(achievementIds, 200);
            for(List<Integer> chunk : achievementIdChunks) {
                achievements.addAll(getMultipleAchievementInfo(chunk));
            }
            List<GuildWarsAchievementProgress> gw2Achievements = new ArrayList<>();
            for(GuildWarsAchievement achiev : achievements) {
                for(GuildWarsAchievementStatus state: achievementStates) {
                    if(state.getId() == achiev.getId()) {
                        gw2Achievements.add(new GuildWarsAchievementProgress(achiev, state));
                        break;
                    }
                }
            }
            return gw2Achievements;
        }
        catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    private static String get(String url) {
        try{
            System.out.println("[GW2_API] Requesting Ressource: " + url);
            SSLContext sslContext = new SSLContextBuilder()
                    .loadTrustMaterial(null, (certificate, authType) -> true).build();

            CloseableHttpClient client = HttpClients.custom()
                    .setSSLContext(sslContext)
                    .setSSLHostnameVerifier(new NoopHostnameVerifier())
                    .build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Accept", "application/xml");
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println("[GW2_API] Received: " + content.length());
            return content;
        }
        catch(Exception ex) {
            System.out.println("[GW2_API]Request Failed: " + url + " " +ex.getMessage());
        }
        return "";
    }

    public static GuildWarsAchievement getSingleAchievementInfo(int achievementId) {
        String url = baseUrl + "achievements/" + achievementId + "?lang=de";
        String responseBody = get(url);
        ObjectMapper mapper = new ObjectMapper();
        try{
            GuildWarsAchievement achievement = mapper.readValue(responseBody, new TypeReference<GuildWarsAchievement>(){});
            return achievement;
        }
        catch (Exception ex) {
            return null;
        }
    }

    public static List<GuildWarsAchievement> getMultipleAchievementInfo(List<Integer> achievementIds) {
        String url = baseUrl + "achievements?ids=" + ListToString(achievementIds) + "&?lang=de";
        String responseBody = get(url);
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<GuildWarsAchievement> achievements = mapper.readValue(responseBody, new TypeReference<List<GuildWarsAchievement>>(){});
            return achievements;
        }
        catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    public static List<GuildWarsCharacter> getCharacters(String apiKey) {
        String url = baseUrl + "characters?access_token=" + apiKey + "&?lang=de";
        String responseBody = get(url);
        ObjectMapper mapper = new ObjectMapper();
        try{
            String[] characterNames = mapper.readValue(responseBody, new TypeReference<String[]>(){});
            List<GuildWarsCharacter> characters = new ArrayList<>();
            for(String charName: characterNames) {
                String fixedName = charName.replace(" ", "%20");
                String charRequestUrl = baseUrl + "characters/"+ fixedName +"?access_token=" + apiKey + "&?lang=de";
                String characterResponse = get(charRequestUrl);
                GuildWarsCharacter character = mapper.readValue(characterResponse, new TypeReference<GuildWarsCharacter>(){});
                characters.add(character);
            }
            return characters;
        }
        catch (Exception ex) {
            return null;
        }
    }


    public static List<GuildWarsWalletItem> getWallet(String apiKey) {
        String url = baseUrl + "account/wallet?access_token=" + apiKey + "&?lang=de";
        String walletContent = get(url);
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<GuildWarsWalletItem> items = new ArrayList<>();
            List<GuildWarsCurrencyIdentifier> itemData = mapper.readValue(walletContent, new TypeReference<List<GuildWarsCurrencyIdentifier>>(){});
            for(GuildWarsCurrencyIdentifier identifier : itemData) {
                String currencyUrl = baseUrl + "currencies/" + identifier.getId() + "?lang=de";
                String currencyInfo = get(currencyUrl);
                GuildWarsCurrencyDetails details = mapper.readValue(currencyInfo, new TypeReference<GuildWarsCurrencyDetails>(){});
                items.add(new GuildWarsWalletItem(identifier, details));
            }
            return items;
        }
        catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    public static List<GuildWarsItem> getBank(String apiKey) {
        String url = baseUrl + "account/bank?access_token=" + apiKey + "&?lang=de";
        String bankContend = get(url);
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<GuildWarsItem> items = new ArrayList<>();
            List<GuildWarsItemData> itemData = mapper.readValue(bankContend, new TypeReference<List<GuildWarsItemData>>(){});
            return getItemsFromData(itemData);
        }
        catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    private static List<GuildWarsItem> getItemsFromData(List<GuildWarsItemData> itemData) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<Integer> itemIds = new ArrayList<>();
            for(GuildWarsItemData data : itemData) {
                if(data != null)
                    itemIds.add(data.getId());
            }
            List<GuildWarsItem> items = new ArrayList<>();
            List<List<Integer>> itemIdChunks = Lists.partition(itemIds, 200);
            for(List<Integer> chunk : itemIdChunks) {
                String itemDetailsUrl = baseUrl + "items?ids=" + ListToString(chunk) + "&?lang=de";
                String itemDetails = get(itemDetailsUrl);
                List<GuildWarsItemInfo> itemInfos = mapper.readValue(itemDetails, new TypeReference<List<GuildWarsItemInfo>>(){});
                for (GuildWarsItemInfo info : itemInfos) {
                    if(info != null)
                        for(GuildWarsItemData data: itemData) {
                            if(data != null && info.getId() == data.getId()){
                                items.add(new GuildWarsItem(data, info));
                                break;
                            }
                        }
                }
            }
            return items;
        }
        catch(Exception ex) {
            return new ArrayList<>();
        }
    }


    private static String ArrayToString(Integer[] array) {
        StringBuilder result = new StringBuilder();
        for(int number : array) {
            result.append(number);
            result.append(",");
        }
        return result.length() > 0 ? result.substring(0, result.length() - 1): "";
    }

    private static String ListToString(List<Integer> list) {
        StringBuilder result = new StringBuilder();
        for(int number : list) {
            result.append(number);
            result.append(",");
        }
        return result.length() > 0 ? result.substring(0, result.length() - 1): "";
    }
}
