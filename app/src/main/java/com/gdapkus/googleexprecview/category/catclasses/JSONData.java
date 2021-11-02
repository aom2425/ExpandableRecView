package com.gdapkus.googleexprecview.category.catclasses;

import android.util.Log;

import com.gdapkus.googleexprecview.category.SubcategoryList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONData {

    private static JSONObject categories;
    private static String SUBTITLE = "subgroup";
    public static String json_str = "{\n" +
            "  \"categories\": [\n" +
            "    {\n" +
            "      \"name\": \"VIRTUALIOS/ONLINE PASLAUGOS\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Front-end programavimas arba Interneto svetainių kūrimas\": 1,\n" +
            "        \"Back-end programavimas arba Programavimas\": 2,\n" +
            "        \"Grafikos dizainas\": 3,\n" +
            "        \"Klientų aptarnavimas\": 4,\n" +
            "        \"Duomenų analizavimas\": 5,\n" +
            "        \"Testuotojas\": 6,\n" +
            "        \"Mobiliųjų aplikacijų kūrimas\": 7,\n" +
            "        \"Virtualus asistentas\": 8,\n" +
            "        \"SEO paslaugos\": 9,\n" +
            "        \"Reklamos paslaugos\": 10,\n" +
            "        \"Video klipų kūrimas\": 11,\n" +
            "        \"Forografija verslui\": 12,\n" +
            "        \"Spaudos paslaugos\": 13,\n" +
            "        \"Dokumentų rašymas\": 14,\n" +
            "        \"Vertėjas\": 1,\n" +
            "        \"Įgarsintojas\": 1,\n" +
            "        \"Virtualus menininkas\": 1\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"NAMO VIDAUS DARBAI\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Namo vidaus apdaila, remontas\": 1,\n" +
            "        \"Namo vidaus dizainas\": 2,\n" +
            "        \"Baldų gamyba\": 3,\n" +
            "        \"Baldų projektavimas, dizaineriai\": 4,\n" +
            "        \"Baldų surinkimas\": 5,\n" +
            "        \"Interjero dekoravimas\": 6,\n" +
            "        \"Restauravimas\": 7,\n" +
            "        \"Virtuvė\": 8,\n" +
            "        \"Svetainė\": 9,\n" +
            "        \"Vonia\": 10,\n" +
            "        \"Miegamasis\": 11,\n" +
            "        \"Valgomasis\": 12,\n" +
            "        \"Namo vidinės sienos\": 13,\n" +
            "        \"Grindys\": 1,\n" +
            "        \"Santechnikai, santechnikos darbai\": 14,\n" +
            "        \"Elektrikai, elektros darbai\": 15,\n" +
            "        \"Montavimo paslaugos\": 16,\n" +
            "        \"Elektronikos dalių instaliavimas\": 17,\n" +
            "        \"Namo vidaus valymo paslaugos\": 18,\n" +
            "        \"Langai, durys, gamyba montavimas\": 19,\n" +
            "        \"Apšiltinimas\": 20,\n" +
            "        \"Vandens filtrai, montavimas, keitimas\": 21,\n" +
            "        \"Pirtys, pirčių įrengimas\": 22,\n" +
            "        \"Buitinės technikos remontas\": 23,\n" +
            "        \"Dujų įvedimas, pajungimas\": 24,\n" +
            "        \"Plytelės, plytelių pjovimas\": 25,\n" +
            "        \"Inžineriai\": 26,\n" +
            "        \"Palėsio naikinimas\": 27,\n" +
            "        \"Stiklų, veidrodžių gamyba, keitimas\": 28,\n" +
            "        \"Sąmatininkai: sąmatų skaičiavimas\": 29,\n" +
            "        \"Statybos dokumentų tvarymas\": 30,\n" +
            "        \"Statybos projektų tvarkymas\": 31,\n" +
            "        \"Statybų darbų vadovai\": 32,\n" +
            "        \"Vidaus židinio įrengimas\": 33\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"NAMO IŠORĖS DARBAI\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Namo išorės apdaila, remontas\": 1,\n" +
            "        \"Namo sienos murijimas\": 2,\n" +
            "        \"Sienų špakliavimas\": 3,\n" +
            "        \"Sienų apšiltinimas\": 4,\n" +
            "        \"Sienų apdailos darbai\": 5,\n" +
            "        \"Terasa\": 6,\n" +
            "        \"Trinkeles\": 7,\n" +
            "        \"Elektriko darbai\": 8,\n" +
            "        \"Namo stogo darbai\": 9,\n" +
            "        \"Aplinkos tvarkymas, apželdinimas\": 10,\n" +
            "        \"Medžio darbai (staliai)\": 11,\n" +
            "        \"Metalo gaminiai (suvirintojai)\": 12,\n" +
            "        \"Sienu murijimas\": 13,\n" +
            "        \"Roletai, žaliuzės\": 14,\n" +
            "        \"Įrankių nuoma\": 15,\n" +
            "        \"Ventiliacija, vėdinimo sistemos\": 16,\n" +
            "        \"Šiukšlių išvežimas, statybinių medžiagų ir pnš.\": 17,\n" +
            "        \"Garažo vartai, montavimas\": 18,\n" +
            "        \"Vandens gręžiniai\": 19,\n" +
            "        \"Lauko židiniai\": 20,\n" +
            "        \"Aukštalipio paslaugos\": 21,\n" +
            "        \"Lauko židinio įrengimas\": 22,\n" +
            "        \"Kelių tiesimas\": 23,\n" +
            "        \"Malkos, gamyba, pristatymas\": 24,\n" +
            "        \"Nuotekų valymo įrenginiai\": 25,\n" +
            "        \"Nuotekų išvežimas\": 26,\n" +
            "        \"Kaminų valymas\": 27\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"LAUKO DARBAI\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Žolės pjovimas\": 1,\n" +
            "        \"Medžių kirtimas\": 2,\n" +
            "        \"Lauko darbai žiemos laikotarpiu\": 3,\n" +
            "        \"Lauko darbai rudens laikotarpiu\": 4,\n" +
            "        \"Pastatu griovimas\": 5,\n" +
            "        \"Sulinio kasimas\": 6,\n" +
            "        \"Grioviu kasimas\": 7,\n" +
            "        \"Pamatu darbai\": 8,\n" +
            "        \"Betonavimo darbai\": 9,\n" +
            "        \"Žemės kasimas, lyginimas\": 10,\n" +
            "        \"Kelmų šalinimas\": 11,\n" +
            "        \"Geodezininko paslaugos\": 12,\n" +
            "        \"Statybinės technikos nuoma\": 13,\n" +
            "        \"Skalda, žvyras, smėlis, juodžemis\": 14,\n" +
            "        \"Griovmo darbai\": 15,\n" +
            "        \"Signalizacija. Kameros, apsaugos sistemos\": 16\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"PRISTATYMO PASLAUGOS\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Maisto paėmimas ir pristatymas\": 1,\n" +
            "        \"Daiktų/prekių paėmimas ir pristatymas\": 2\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"PAGALBA KRAUSTANTIS\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Daiktų sukrovimas ir iškrovimas\": 1,\n" +
            "        \"Sunkių daiktų kilnojimas\": 2,\n" +
            "        \"Baldų pernešimas\": 3,\n" +
            "        \"Baldų surinkimas\": 4,\n" +
            "        \"Baldų ir kitų daiktų pervežimas\": 5,\n" +
            "        \"Namo valymas kraustantis\": 6\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"GYVŪNŲ PASLAUGOS\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Šunų vedžiojimas\": 1,\n" +
            "        \"Augintinių priežiūra\": 2,\n" +
            "        \"Augintiniu kirpimas\": 3,\n" +
            "        \"Akvariumų paslaugos\": 4,\n" +
            "        \"Gyvūnų treniravimas\": 5,\n" +
            "        \"Veterinaro paslaugos\": 6\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"VAIKŲ PRIEŽIŪRA\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Ilgalaikė vaikų priežiūra\": 1,\n" +
            "        \"Trumpalaikė vaikų priežiūra\": 2,\n" +
            "        \"Papildomas mokytojas, korepetitorius\": 3\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"GROŽIO IR SVEIKATOS PASLAUGOS\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Manikiūras (procedūros rankų nagams)\": 1,\n" +
            "        \"Pedikiūras (procedūros kojų nagams)\": 2,\n" +
            "        \"Kirpėjų paslaugos (kirpimas, dažymas, gydomosios ir atstatomosios procedūros plaukams)\": 3,\n" +
            "        \"SPA ir Masažo paslaugos\": 4,\n" +
            "        \"Burnos priežiūra (burnos higiena, dantų balinimas, estetinis plombavimas)\": 5,\n" +
            "        \"Veido procedūros (veido valymas, drekinančios, jauninančios, atstatančios procedūros)\": 6,\n" +
            "        \"Estetinė medicina (lūpų putlinimas, hialuriono injekcijos, botulino injekcijos, dėmių, apgamų šalinimas)\": 7,\n" +
            "        \"Dietistas\": 8,\n" +
            "        \"Visažisto paslaugos (dieninis/vakarinis/vestuvinis makiažas, permanentinis makiažas)\": 9,\n" +
            "        \"Asmeninis treneris (sportas)\": 10\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"RENGINIAI\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Muzikantų, dainininkų, gupių paslaugos\": 1,\n" +
            "        \"Renginių vedėjai\": 2,\n" +
            "        \"Sodybos nuoma\": 3,\n" +
            "        \"Salės nuoma\": 4,\n" +
            "        \"Lauko žaidimų nuoma\": 5,\n" +
            "        \"Lauko palapinių, paviljonų nuoma\": 6,\n" +
            "        \"Renginių organizimas\": 7,\n" +
            "        \"Pramogos vaikams\": 8,\n" +
            "        \"Vestuvių organizavimas\": 9,\n" +
            "        \"Video klipų kūrimas\": 10,\n" +
            "        \"Vestuvių, švenčių dekoravimas\": 11,\n" +
            "        \"Šventinės įrangos nuoma\": 12,\n" +
            "        \"Maitinimas, maisto paslaugos\": 13,\n" +
            "        \"Tortai, desertai\": 14,\n" +
            "        \"Suknelių nuoma\": 15,\n" +
            "        \"Barmenai, gėrimai renginiams\": 16,\n" +
            "        \"Dizaineris\": 17,\n" +
            "        \"Fotopaslaugos\": 18,\n" +
            "        \"Nuotraukų retušavimas\": 19,\n" +
            "        \"Floristo paslaugos, gėlių salonai\": 20,\n" +
            "        \"Automobiliu nuoma\": 21,\n" +
            "        \"Pasirodymai, šou renginiams\": 22,\n" +
            "        \"Kitos paslaugos renginiams\": 23\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"KITOS PASLAUGOS\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Kompiuterio taisymas\": 1,\n" +
            "        \"Telefono taisymas\": 2,\n" +
            "        \"Apsauga\": 3\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SPECIALISTAI ir konsultacijos (prie pasiulymo pridedama konsultacija)\",\n" +
            "      \"subgroup\": {\n" +
            "        \"Administratoriai\": 1,\n" +
            "        \"Apdailininkai\": 2,\n" +
            "        \"Animatoriai\": 3,\n" +
            "        \"Architektai\": 4,\n" +
            "        \"Apsaugos darbuotojai\": 5,\n" +
            "        \"Auklės, namų auklėtojos\": 6,\n" +
            "        \"Automobilių darbininkai\": 7,\n" +
            "        \"Barmenai, padavėjai\": 8,\n" +
            "        \"Buhalteriai\": 9,\n" +
            "        \"Burnos higienistai\": 10,\n" +
            "        \"Dažytojai\": 11,\n" +
            "        \"Dizaineriai\": 12,\n" +
            "        \"Elektrikai\": 13,\n" +
            "        \"Foristai\": 14,\n" +
            "        \"Fotografai\": 15,\n" +
            "        \"Inžineriai\": 16,\n" +
            "        \"IT specialistai\": 17,\n" +
            "        \"Kalviai, suvirintojai-šaltkalviai\": 18,\n" +
            "        \"Kirpėjos\": 19,\n" +
            "        \"Konsultantai\": 20,\n" +
            "        \"Kosmetologai\": 21,\n" +
            "        \"Krovėjai\": 22,\n" +
            "        \"Manikiūrininkai\": 23,\n" +
            "        \"Masažuotojai\": 24,\n" +
            "        \"Mokytojai, korepetitoriai\": 25,\n" +
            "        \"Operatoriai\": 26,\n" +
            "        \"Pagalbiniai darbininkai\": 27,\n" +
            "        \"Pardavėjai\": 28,\n" +
            "        \"Plovėjai\": 29,\n" +
            "        \"Programuotojai\": 30,\n" +
            "        \"Psichologai\": 31,\n" +
            "        \"Sandėlininkai\": 32,\n" +
            "        \"Santechnikai\": 33,\n" +
            "        \"Siūvėjai\": 34,\n" +
            "        \"Slaugės, seselės, saugytojos\": 35,\n" +
            "        \"Staliai, baldžiai\": 36,\n" +
            "        \"Stogdengiai\": 37,\n" +
            "        \"Statybininkai\": 38,\n" +
            "        \"Šokėjai\": 39,\n" +
            "        \"Teisininkai, advokatai\": 40,\n" +
            "        \"Vadybininkai\": 41,\n" +
            "        \"Vairuotojai\": 42,\n" +
            "        \"Valytojai\": 43,\n" +
            "        \"Vertėjai\": 44,\n" +
            "        \"Virėjai\": 45,\n" +
            "        \"Visažistai\": 46,\n" +
            "        \"Žemės ūkio specialistai\": 47,\n" +
            "        \"Uždarbis internete\": 48,\n" +
            "        \"Darbas užsienyje\": 49\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String getCategories(){
        return json_str;
    }

    public static JSONArray getCatJSON(){
        try {
            return new JSONObject(getCategories()).getJSONArray("categories");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getJSONCategories(){

        //TODO: get categories from GRPC

        try {
            categories = new JSONObject(json_str);
            //JSONPa parser = new JSONParser();
            JSONArray cate = categories.getJSONArray("categories");
            List<String> category_list = new ArrayList<>();
            for(int i = 0; i < cate.length(); i++){
                //category_list.add(categories.getString("name"));
                cate.get(i);
                JSONObject obj = cate.getJSONObject(i);
                category_list.add(obj.getString("name"));
                //Log.d("DEBUG: ", "category elements " + obj.getString("name"));
            }
            return category_list;
        } catch (JSONException e) {
            Log.e("DEBUG: ", "CATEGORIES JSON error: " + e.getMessage());
        }
        return null;
    }

    // JSON object transform to map
    public static Map<String, Object> toMap(JSONObject obj) {
        try{
            Map<String, Object> conv_obj = new HashMap<String, Object>();
            Iterator<String> keysItr =  obj.keys();

            while(keysItr.hasNext()){
                String key = keysItr.next();
                String value = obj.getString(key);

                /*if(value instanceof JSONArray){
                    value = toList((JSONArray) value);
                }
                else if(value instanceof JSONObject){
                    value = toMap((JSONObject) value);
                }*/
                Log.d("DEBUG:", "Json key: " + key + "\n" +
                        "json value: " + value.toString());
            }
            return conv_obj;
        } catch (JSONException e){
            Log.e("DEBUG:", "JSON toMap method failed" + e.getMessage());
        }

        return null;
    }

    public static List<Object> toList(JSONArray arrays){
        try{
            List<Object> list = new ArrayList<Object>();
            for(int i = 0; i < arrays.length(); i++){
                Object value = arrays.get(i);
                if(value instanceof JSONArray){
                    value = toList((JSONArray) value);
                }
                else if(value instanceof JSONObject){
                    value = toMap((JSONObject) value);
                }
                list.add(value);
            }
            return list;

        } catch (JSONException e){
            Log.e("JSONDATA:", "toList error:" + e.getMessage());
        }
        return null;
    }

}
