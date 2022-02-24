package exceptions.numbers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberConverter {
    private Properties properties = new Properties();

    public NumberConverter(String lang) {
        //Loeme numbers_xx.properties failist andmed kus on key value paarid.
        String filePath = String.format("src/exceptions/numbers/numbers_%s.properties", lang);


        FileInputStream is = null;

        try {
            is = new FileInputStream(filePath);

            InputStreamReader reader = new InputStreamReader(
                    is, StandardCharsets.UTF_8);
            // püüame võimalikud errorid kinni. nt kui sisendi puhul ei leia faili vms.
            this.properties.load(reader);
        } catch (IOException e) {
            throw new MissingLanguageFileException(lang, e);
        } catch (IllegalArgumentException e) {
            throw new BrokenLanguageFileException(lang, e);
        } finally {
            close(is);
        }

    }


    private String translate(String key) {
        // tagastame key kohta tema value. Kui sellist key ei eksisteeri, siis anda veateade.
        if (properties.containsKey(String.valueOf(key))) {
            return this.properties.getProperty(String.valueOf(key));
        } else {
            throw new MissingTranslationException(String.valueOf(key));
        }
    }


    public String numberInWords(Integer number) {
        // Funktsioon mis konverdib arvu sõneks.
        // Vaatame, kas arvus on sajalised, kümnelised, ühelised.
        String result = "";
        if (number >= 100 && number < 1000) {
            result += getHundreds(number);

            if (number > 100 && (number % 100) != 0) {
                number = number % 100;
            }
        }

        // Kümnelised
        if (number >= 10 && number < 100) {
            if (number >= 20) {
                result += getTens(number);
            } else {
                result += getTeens(number);
                {

                }
            }
            // Üheliste saamiseks leiame jäägi
            if (number % 10 != 0 && number > 20) {
                number = number % 10;
            }
        }

        // Ühelised
        if (number < 10) {
            result += translate(String.valueOf(number));
        }
        return result;

    }


    private String getHundreds(Integer number) {
        // Tagastab sajalised
        String result = "";
        result += translate(String.valueOf(number / 100));
        result += translate("hundreds-before-delimiter");
        result += translate("hundred");
        if (number % 100 != 0) {
            result += translate("hundreds-after-delimiter");
        }
        return result;
    }


    private String getTens(Integer number) {
        // Tagastab kümnelised, kui arv on >= 20
        String result = "";
        try {
            result += translate(String.valueOf(number - (number % 10)));  //34 - 4 = 30, st. arvust lahutan yhelised ja saan kymnelisi
        } catch (MissingTranslationException e) {
            result += translate(String.valueOf(number / 10));
            result += translate("tens-suffix");
        }
        if (number % 10 != 0) {
            result += translate("tens-after-delimiter");
        }

        return result;
    }


    private String getTeens(Integer number) {
        // Tagastab kümnelised. "teist" lõpulised arvud.
        String result = "";
        try {
            result += translate(String.valueOf(number));

        } catch (MissingTranslationException e) {
            result += translate(String.valueOf(number % 10));
            result += translate("teen");

        }
        return result;
    }


    private static void close(FileInputStream is) {
        if (is == null) {
            return;
        }

        try {
            is.close();
        } catch (IOException ignore) {
        }
    }


    public static void main(String[] args) {
        NumberConverter converter = new NumberConverter("et");

        System.out.println(converter.numberInWords(101));
        System.out.println(converter.numberInWords(111));
        System.out.println(converter.numberInWords(112));
        System.out.println(converter.numberInWords(113));
        System.out.println(converter.numberInWords(114));
        System.out.println(converter.numberInWords(121));
        System.out.println(converter.numberInWords(131));
        System.out.println(converter.numberInWords(141));
        System.out.println(converter.numberInWords(661));
        System.out.println(converter.numberInWords(631));
    }
}
