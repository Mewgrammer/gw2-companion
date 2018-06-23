package gw2.api.controller;

import gw2.api.exceptions.CustomHttpException;
import gw2.api.model.*;
import me.nithanim.gw2api.v2.api.characters.Character;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLContext;
import java.util.List;

@RestController("/api/guildwars")
public class GuildWarsController {

    @CrossOrigin
    @RequestMapping(value="/api/guildwars/all", method = RequestMethod.GET, params="apiKey")
    public UserData getUserData(@RequestParam("apiKey") String apiKey) throws CustomHttpException {
        UserData data = new UserData();
        data.account = this.getAccountData(apiKey);
        data.achievements = this.getAchievements(apiKey);
        data.characters = this.getCharacters(apiKey);
        data.wallet = this.getAccountWallet(apiKey);
        data.bank = this.getBank(apiKey);
        return data;
    }

    @CrossOrigin
    @RequestMapping(value="/api/guildwars/test", method = RequestMethod.GET)
    public String test() {
        String url = "https://api.guildwars2.com/v2/characters/Ignis%20Fignis?access_token=4DEB96BD-60AE-0449-984F-EE7267389BB44A04E06E-303D-479F-8C2D-0D85EB2841E5";
        try{
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
            return content;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "{}";
    }

    @CrossOrigin
    @RequestMapping(value="/api/guildwars/account", method = RequestMethod.GET, params="apiKey")
    public GuildWarsAccount getAccountData(@RequestParam("apiKey") String apiKey) throws CustomHttpException {
        return GuildWarsApi.getAccount(apiKey);
    }

    @CrossOrigin
    @RequestMapping(value="/api/guildwars/characters", method = RequestMethod.GET, params="apiKey")
    public List<GuildWarsCharacter> getCharacters(@RequestParam("apiKey") String apiKey) throws CustomHttpException {
        return GuildWarsApi.getCharacters(apiKey);
    }

    @CrossOrigin
    @RequestMapping(value="/api/guildwars/wallet", method = RequestMethod.GET, params="apiKey")
    public List<GuildWarsWalletItem> getAccountWallet(@RequestParam("apiKey") String apiKey) throws CustomHttpException {
        return GuildWarsApi.getWallet(apiKey);
    }

    @CrossOrigin
    @RequestMapping(value="/api/guildwars/bank", method = RequestMethod.GET, params="apiKey")
    public List<GuildWarsItem> getBank(@RequestParam("apiKey") String apiKey) throws CustomHttpException {
        return GuildWarsApi.getBank(apiKey);
    }

    @CrossOrigin
    @RequestMapping(value="/api/guildwars/achievements", method = RequestMethod.GET, params="apiKey")
    public List<GuildWarsAchievementProgress> getAchievements(@RequestParam("apiKey") String apiKey) throws CustomHttpException {
        return GuildWarsApi.getAchievements(apiKey);
    }
}
