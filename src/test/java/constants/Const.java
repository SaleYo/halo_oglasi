package constants;

public class Const {
    public static final String BASE_URL = "https://www.halooglasi.com/";
    public static final String MY_PROFILE_PAGE_URL = BASE_URL + "profil";
    public static final String REGISTRATION_PAGE_URL = BASE_URL + "registracija";
    public static final String LOGIN_PAGE_URL =  BASE_URL + "prijava";
    public static final String POST_AD_PAGE_URL = BASE_URL + "postavite-oglas";
    public static final String GOOGLE_LOGIN =
            "https://accounts.google.com/o/oauth2/v2/auth/identifier?response_type=code";
    public static final String FACEBOOK_LOGIN = "https://www.facebook.com/login.php?skip_api_login=1&api_key=";
    public static final String EMAIL_LOCAL_PART = "testerautosalex";
    public static final String EMAIL_DOMAIN_PART = "@gmail.com";
    public static final String EMAIL_REGISTERED_USER = EMAIL_LOCAL_PART + EMAIL_DOMAIN_PART;
    public static final String PASS_REGISTERED_USER = "Test1234!";
    public static final String USERNAME_REGISTERED_USER = "AutoTestSal";

    public static final String USERNAME = "AutoTest";
    public static final String SEARCH_TERM = "aparman";

    public static final String COOKIE_TEXT = "Halooglasi.com koristi kolačiće (cookies) u cilju pružanja najboljeg korisničkog iskustva i prikazivanja personalizovanog sadržaja kao i za druge funkcionalnosti koje ne bismo mogli da obezbedimo na drugi način. Daljim korišćenjem sajta smatraćemo da ste saglasni sa korišćenjem kolačića. Saznajte više →";


    //LoginPage Strings
    public static final String LOGIN_TITLE = "Ulogujte se";
    public static final String USERNAME_LABEL = "E-mail ili korisničko ime";
    public static final String PASSWORD_LABEL = "Lozinka";
    public static final String FORGOT_PASSWORD_LABEL = "Zaboravili ste lozinku?";
    public static final String REMEMBER_ME_LABEL = "Ostavi me ulogovanog";
    public static final String LOGIN_ERROR_MSG = "- Neispravno korisničko ime ili lozinka.\n" +
            "\n" + "Nepopunjena obavezna polja i nepravilno popunjena polja označena su crvenom bojom.";

    //RegistrationPage Strings
    public static final String REGISTRATION_TITLE = "Registracija";
    public static final String PERSON_CHB_LABEL = "Fizičkog lica";
    public static final String COMPANY_CHB_LABEL = "Pravnog lica";
    public static final String REG_USERNAME_LABEL = "Korisničko ime";
    public static final String REG_EMAIL_LABEL = "Email";
    public static final String REG_PASSWORD_LABEL = "Lozinka";
    public static final String REG_CONFIRM_PASSWORD_LABEL = "Ponovi lozinku";
    public static final String REG_ALLOW_SENDING_NEWS_LABEL = "Želim da primam obaveštenja i vesti";
    public static final String REG_SUCCESSFUL_MSG = "Registracija uspešna";
    public static final String REG_HAS_AGREED_TO_SEND_FINANCIAL_LABEL =
            "Saglasan sam da fiskalne račune dobijam elektronskim putem na mejl adresu navedenu u nalogu";
    public static final String EXISTING_USER_ERROR_MSG =
            "U sistemu je već registrovan korisnik sa nekim od jedinstvenih podataka koje ste uneli tokom registracije! Koristite nalog koji ste već kreirali ili zatražite zahtev za reaktivaciju istog.";
    public static final String EMPTY_EMAIL_ERROR_MSG ="- \"Email\" je obavezan podatak.\n" +
            "\n" +
            "Nepopunjena obavezna polja i nepravilno popunjena polja označena su crvenom bojom.";
    public static final String EMPTY_USERNAME_ERROR_MSG = "- \"Korisničko ime\" je obavezan podatak.\n" +
            "\n" +
            "Nepopunjena obavezna polja i nepravilno popunjena polja označena su crvenom bojom.";

    public static final String EMPTY_PASS_ERROR_MSG =
            "- \"Lozinka\" je obavezan podatak.\n" +
            "- \"Ponovi lozinku\" mora biti jednaka sa: \"Lozinka\"" + "\n" + "\n" +
            "Nepopunjena obavezna polja i nepravilno popunjena polja označena su crvenom bojom.";

    public static final String EMPTY_CONFIRM_PASS_ERROR_MSG = "- \"Ponovi lozinku\" je obavezan podatak.\n" +
            "\n" +
            "Nepopunjena obavezna polja i nepravilno popunjena polja označena su crvenom bojom.";

    public static final String HAS_AGREED_TO_SEND_FINANCIAL_ERROR_MSG =
    "- Potrebno je dati saglasnost da fiskalne račune dobijate elektronskim putem na mejl adresu navedenu u nalogu.";


    public static final String DIFFERENT_PASS_ERROR_MSG =
            "- \"Ponovi lozinku\" mora biti jednaka sa: \"Lozinka\"" + "\n" + "\n" +
            "Nepopunjena obavezna polja i nepravilno popunjena polja označena su crvenom bojom.";

    public static final String NOT_ACCEPTED_TO_RECEIVE_RECEIPT_ERROR_MSG =
            "- Potrebno je dati saglasnost da fiskalne račune dobijate elektronskim putem na mejl adresu navedenu u nalogu." + "\n" + "\n"
                    + "Nepopunjena obavezna polja i nepravilno popunjena polja označena su crvenom bojom.";


}
